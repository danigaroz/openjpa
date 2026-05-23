/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.   
 */
package org.apache.openjpa.meta;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.lang.StringUtils;
import org.apache.openjpa.conf.OpenJPAConfiguration;
import org.apache.openjpa.datacache.AbstractDataCache;
import org.apache.openjpa.datacache.DataCache;
import org.apache.openjpa.datacache.DataCacheMode;
import org.apache.openjpa.enhance.PCRegistry;
import org.apache.openjpa.enhance.Reflection;
import org.apache.openjpa.enhance.PersistenceCapable;
import org.apache.openjpa.lib.conf.Configurations;
import org.apache.openjpa.lib.conf.Value;
import org.apache.openjpa.lib.conf.ValueListener;
import org.apache.openjpa.lib.log.Log;
import org.apache.openjpa.lib.meta.SourceTracker;
import org.apache.openjpa.lib.util.J2DoPrivHelper;
import org.apache.openjpa.lib.util.Localizer;
import org.apache.openjpa.lib.util.Options;
import org.apache.openjpa.lib.xml.Commentable;
import org.apache.openjpa.util.BigDecimalId;
import org.apache.openjpa.util.BigIntegerId;
import org.apache.openjpa.util.ByteId;
import org.apache.openjpa.util.CharId;
import org.apache.openjpa.util.DateId;
import org.apache.openjpa.util.DoubleId;
import org.apache.openjpa.util.FloatId;
import org.apache.openjpa.util.GeneralException;
import org.apache.openjpa.util.IntId;
import org.apache.openjpa.util.InternalException;
import org.apache.openjpa.util.LongId;
import org.apache.openjpa.util.MetaDataException;
import org.apache.openjpa.util.ObjectId;
import org.apache.openjpa.util.OpenJPAId;
import org.apache.openjpa.util.ShortId;
import org.apache.openjpa.util.StringId;
import org.apache.openjpa.util.UnsupportedException;
import org.apache.openjpa.util.ImplHelper;
import serp.util.Strings;
@SuppressWarnings("serial")
public class ClassMetaData
    extends Extensions
    implements Comparable<ClassMetaData>, SourceTracker, MetaDataContext,
    MetaDataModes, Commentable, ValueListener {
    public static final int ID_UNKNOWN = 0;
    public static final int ID_DATASTORE = 1;
    public static final int ID_APPLICATION = 2;
    public static final int ACCESS_UNKNOWN = AccessCode.UNKNOWN;
    public static final int ACCESS_FIELD = AccessCode.FIELD;
    public static final int ACCESS_PROPERTY = AccessCode.PROPERTY;
    public static final int ACCESS_EXPLICIT = AccessCode.EXPLICIT;
    public static final String SYNTHETIC = "`syn";
    protected static final String DEFAULT_STRING = "`";
    private static final Localizer _loc = Localizer.forPackage
        (ClassMetaData.class);
    private static final FetchGroup[] EMPTY_FETCH_GROUP_ARRAY
        = new FetchGroup[0];
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private MetaDataRepository _repos;
    private transient ClassLoader _loader = null;
    private final ValueMetaData _owner;
    private final LifecycleMetaData _lifeMeta = new LifecycleMetaData(this);
    private Class<?> _type = Object.class;
    protected ClassMetaData(Class<?> type, MetaDataRepository repos) {
        _repos = repos;
        _owner = null;
        setDescribedType(type);
        registerForValueUpdate("DataCacheTimeout");
    }
    protected ClassMetaData(ValueMetaData owner) {
        _owner = owner;
        _repos = owner.getRepository();
        setEnvClassLoader(owner.getFieldMetaData().getDefiningMetaData().
            getEnvClassLoader());
        registerForValueUpdate("DataCacheTimeout");
    }
    public MetaDataRepository getRepository() {
        return _repos;
    }
    public ValueMetaData getEmbeddingMetaData() {
        return _owner;
    }
    public Class<?> getDescribedType() {
        return _type;
    }
    protected void setDescribedType(Class<?> type) {
        if (type.getSuperclass() != null && "java.lang.Enum".equals
            (type.getSuperclass().getName())) {
            throw new MetaDataException(_loc.get("enum", type));
        }
        _type = type;
        if (PersistenceCapable.class.isAssignableFrom(type)) {
            setIntercepting(true);
        }
    }
    public ClassLoader getEnvClassLoader() {
        return _loader;
    }
    public void setEnvClassLoader(ClassLoader loader) {
        _loader = loader;
    }
    public boolean isMapped() {
        return _embedded != Boolean.TRUE;
    }
    public ClassMetaData getMappedPCSuperclassMetaData() {
        ClassMetaData sup = getPCSuperclassMetaData();
        if (sup == null || sup.isMapped()) {
            return sup;
        }
        return sup.getMappedPCSuperclassMetaData();
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
    public FieldMetaData getField(int index) {
        FieldMetaData[] fields = getFields();
        if (index < 0 || index >= fields.length) {
            return null;
        }
        return fields[index];
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
    private boolean recursiveEmbed(ValueMetaData owner) {
        ClassMetaData cm = owner.getFieldMetaData().getDefiningMetaData();
        if (cm.getDescribedType().isAssignableFrom(_type)) {
            return true;
        }
        ValueMetaData owner1 = cm.getEmbeddingMetaData();
        if (owner1 == null) {
            return false;
        } else {
            return recursiveEmbed(owner1);
        }
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
    public boolean isReplicated() {
        return _replicated;
    }
    public void setReplicated(boolean flag) {
        _replicated = flag;
    }
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
    private boolean isCacheable(String candidateCacheName) {
        boolean rval;
        switch(DataCacheMode.valueOf(_repos.getConfiguration().getDataCacheMode())) {
          case ALL:
              rval = true;
              break;
          case NONE:
              rval = false;
              break;
          case ENABLE_SELECTIVE:
              if(getCacheEnabled() == null) {
                  rval = false;
              }
              else {
                  rval = getCacheEnabled();
              }
              break;
          case DISABLE_SELECTIVE:
              if(getCacheEnabled() == null) {
                  rval = true;
              }
              else {
                  rval = getCacheEnabled();
              }
              break;
          case UNSPECIFIED:
          default:
              rval = isConfiguredForCaching();
      }
      return rval;
    }
   
    public boolean hasAbstractPKField() {
        if (_hasAbstractPKField != null) {
            return _hasAbstractPKField.booleanValue();
        }
        _hasAbstractPKField = Boolean.FALSE;
        if (isAbstract() == true) {
            FieldMetaData[] declaredFields = getDeclaredFields();
            if (declaredFields != null && declaredFields.length != 0) {
                for (FieldMetaData fmd : declaredFields) {
                    if (fmd.isPrimaryKey()) {
                        _hasAbstractPKField = Boolean.TRUE;
                        break;
                    }
                }
            }
        }
        return _hasAbstractPKField.booleanValue();
    }
   
    public boolean hasPKFieldsFromAbstractClass() {
        if (_hasPKFieldsFromAbstractClass != null) {
            return _hasPKFieldsFromAbstractClass.booleanValue();
        }
        _hasPKFieldsFromAbstractClass = Boolean.FALSE;
        FieldMetaData[] pkFields = getPrimaryKeyFields();
        for (FieldMetaData fmd : pkFields) {
            ClassMetaData fmdDMDA = fmd.getDeclaringMetaData();
            if (fmdDMDA.isAbstract()) {
                ClassMetaData cmd = getPCSuperclassMetaData();
                while (cmd != fmdDMDA) {
                    if (fmdDMDA.isAbstract()) {
                        cmd = cmd.getPCSuperclassMetaData();
                    } else {
                        break;
                    }
                }
                if (cmd == fmdDMDA) {
                    _hasPKFieldsFromAbstractClass = Boolean.TRUE;
                    break;
                }
            }
        }
        return _hasPKFieldsFromAbstractClass.booleanValue();
    }
   
    public void setCacheEnabled(Boolean enabled) {
        _cacheEnabled = enabled;
    }
   
    public Boolean getCacheEnabled() {
        return _cacheEnabled;
    }
}
