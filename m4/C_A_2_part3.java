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
