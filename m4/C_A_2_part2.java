    public String[] getInterfaceAliasedProperties(Class<?> iface) {
        synchronized (_ifaceMap) {
            Map<String,String> fields = _ifaceMap.get(iface);
            if (fields == null) {
                return EMPTY_STRING_ARRAY;
            }
            return fields.keySet().toArray(new String[fields.size()]);
        }
    }
   
    public int getExtraFieldDataLength() {
        int[] table = getExtraFieldDataTable();
        for (int i = table.length - 1; i >= 0; i--) {
            if (table[i] != -1) {
                return table[i] + 1;
            }
        }
        return 0;
    }
    public boolean isAccessibleField(String field) {
        if (getDeclaredField(field) != null) {
            return true;
        }
        if (_staticFields == null) {
            Field[] fields = (Field[]) AccessController.doPrivileged(
                J2DoPrivHelper.getDeclaredFieldsAction(_type));
            Set<String> names = new HashSet<String>();
            for (int i = 0; i < fields.length; i++) {
                if (Modifier.isStatic(fields[i].getModifiers())) {
                    names.add(fields[i].getName());
                }
            }
            _staticFields = names;
        }
        if (_staticFields.contains(field)) {
            return true;
        }
        if (_super != null) {
            return getPCSuperclassMetaData().isAccessibleField(field);
        }
        return false;
    }
    public FieldMetaData getDefinedSuperclassField(String name) {
        if (_supFieldMap == null) {
            return null;
        }
        return (FieldMetaData) _supFieldMap.get(name);
    }
    public boolean removeDefinedSuperclassField(FieldMetaData field) {
        if (field != null && _supFieldMap != null
            && _supFieldMap.remove(field.getName()) != null) {
            clearAllFieldCache();
            _defSupFields = false;
            return true;
        }
        return false;
    }
    public void defineSuperclassFields(boolean force) {
        if (_defSupFields) {
            return;
        }
        ClassMetaData sup = getPCSuperclassMetaData();
        if (isMapped() && sup != null) {
            FieldMetaData[] sups = sup.getFields();
            for (int i = 0; i < sups.length; i++) {
                if ((force || !sups[i].getDefiningMetaData().isMapped())
                    && getDefinedSuperclassField(sups[i].getName()) == null) {
                    addDefinedSuperclassField(sups[i].getName(),
                        sups[i].getDeclaredType(), sups[i].getDeclaringType());
                }
            }
        }
        resolveDefinedSuperclassFields();
        clearAllFieldCache();
        cacheFields();
    }
    private void resolveDefinedSuperclassFields() {
        _defSupFields = true;
        if (_supFieldMap == null) {
            return;
        }
        FieldMetaData sup;
        for (FieldMetaData fmd : _supFieldMap.values()) {
            sup = getSuperclassField(fmd);
            if (fmd.getDeclaringType() == Object.class) {
                fmd.setDeclaringType(sup.getDeclaringType());
                fmd.backingMember(getRepository().getMetaDataFactory().
                    getDefaults().getBackingMember(fmd));
            }
            fmd.copy(sup);
            fmd.resolve(MODE_META);
        }
    }
    public FieldMetaData getField(int index) {
        FieldMetaData[] fields = getFields();
        if (index < 0 || index >= fields.length) {
            return null;
        }
        return fields[index];
    }
    public FieldMetaData getDeclaredField(int index) {
        FieldMetaData[] fields = getDeclaredFields();
        if (index < 0 || index >= fields.length) {
            return null;
        }
        return fields[index];
    }
    public FieldMetaData getDeclaredField(String name) {
        FieldMetaData field = (FieldMetaData) _fieldMap.get(name);
        if (field == null || field.getManagement() == FieldMetaData.MANAGE_NONE) {
            return null;
        }
        return field;
    }
    public boolean removeDeclaredField(FieldMetaData field) {
        if (field != null && _fieldMap.remove(field.getName()) != null) {
            clearFieldCache();
            return true;
        }
        return false;
    }
    protected void clearDefinedFieldCache() {
        _definedFields = null;
        _listingFields = null;
    }
    protected void clearSubclassCache() {
        _subs = null;
        _subMetas = null;
        _mapSubMetas = null;
    }
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ClassMetaData)) {
            return false;
        }
        return _type == ((ClassMetaData) other).getDescribedType();
    }
    public int compareTo(ClassMetaData other) {
        if (other == this) {
            return 0;
        }
        return _type.getName().compareTo(((ClassMetaData) other).
            getDescribedType().getName());
    }
    public boolean resolve(int mode) {
        if ((_resMode & mode) == mode) {
            return true;
        }
        int cur = _resMode;
        _resMode |= mode;
        int val = _repos.getValidate();
        boolean runtime = (val & MetaDataRepository.VALIDATE_RUNTIME) != 0;
        boolean validate =
            !ImplHelper.isManagedType(getRepository().getConfiguration(), _type)
            || (val & MetaDataRepository.VALIDATE_UNENHANCED) == 0;
        if ((mode & MODE_META) != 0 && (cur & MODE_META) == 0) {
            resolveMeta(runtime);
            if (validate && (val & MetaDataRepository.VALIDATE_META) != 0) {
                validateMeta(runtime);
            }
        }
        if ((mode & MODE_MAPPING) != 0 && (cur & MODE_MAPPING) == 0) {
            resolveMapping(runtime);
            if (validate && (val & MetaDataRepository.VALIDATE_MAPPING) != 0) {
                validateMapping(runtime);
            }
        }
        if ((mode & MODE_MAPPING_INIT) != 0 && (cur & MODE_MAPPING_INIT) == 0) {
            initializeMapping();
        }
        return false;
    }
    protected void resolveMapping(boolean runtime) {
        Log log = _repos.getLog();
        if (log.isTraceEnabled()) {
            log.trace(_loc.get("resolve-mapping", this + "@"
                + System.identityHashCode(this)));
        }
        ClassMetaData sup = getPCSuperclassMetaData();
        if (sup != null) {
            sup.resolve(MODE_MAPPING);
        }
    }
    private void validateNoPKFields() {
        FieldMetaData[] fields = getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].isPrimaryKey()) {
                throw new MetaDataException(_loc.get("bad-pk", fields[i]));
            }
        }
    }
    private void validateAccessType() {
        if (AccessCode.isEmpty(_accessType)
           || AccessCode.isExplicit(_accessType)) {
            return;
        }
        ClassMetaData sup = getPCSuperclassMetaData();
        while (sup != null && sup.isExplicitAccess()) {
            sup = sup.getPCSuperclassMetaData();
        }
        if (sup != null && sup.getDeclaredFields().length > 0) {
            int supCode = sup.getAccessType();
            if (!AccessCode.isCompatibleSuper(_accessType, supCode)) {
             throw new MetaDataException(_loc.get("access-inconsistent-inherit",
             new Object[]{this, AccessCode.toClassString(_accessType),
                          sup, AccessCode.toClassString(supCode)}).toString());
            }
        }
    }
    public FetchGroup getFetchGroup(String name) {
        FetchGroup fg = (_fgMap == null) ? null : (FetchGroup) _fgMap.get(name);
        if (fg != null) {
            return fg;
        }
        ClassMetaData sup = getPCSuperclassMetaData();
        if (sup != null) {
            return sup.getFetchGroup(name);
        }
        if (FetchGroup.NAME_DEFAULT.equals(name)) {
            return FetchGroup.DEFAULT;
        }
        if (FetchGroup.NAME_ALL.equals(name)) {
            return FetchGroup.ALL;
        }
        return null;
    }
    public boolean removeDeclaredFetchGroup(FetchGroup fg) {
        if (fg == null) {
            return false;
        }
        if (_fgMap.remove(fg.getName()) != null) {
            _fgs = null;
            _customFGs = null;
            return true;
        }
        return false;
    }
    public void registerForValueUpdate(String...values) {
        if (values == null) {
            return;
        }
        for (String key : values) {
            Value value = getRepository().getConfiguration()
                .getValue(key);
            if (value != null) {
                value.addListener(this);
            }
        }
    }
    public void valueChanged(Value val) {
        if (val != null && val.matches("DataCacheTimeout")) {
            _cacheTimeout = Integer.MIN_VALUE;
        }
    }
    public String[] getFieldNames() {
        return toNames(getFields());
    }
    public String[] getDeclaredFieldNames() {
        return toNames(getDeclaredFields());
    }
    public boolean isConfiguredForCaching() {
        if (_isCacheable != null) {
            return _isCacheable.booleanValue();
        }
        setIsCacheable(true, false);
        return _isCacheable.booleanValue();
    }
    private final Set extractDataCacheClassListing(String classList) {
        if (classList == null || classList.length() == 0) {
            return null;
        }
        HashSet returnSet = new HashSet();
        String[] entries = classList.split(";");
        for (int index = 0; index < entries.length; index++) {
            returnSet.add(entries[index]);
        }
        return returnSet;
    }
// CONTINUE_FROM_LINE: 900
