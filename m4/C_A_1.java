package org.apache.openjpa.meta;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.util.*;
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
import org.apache.openjpa.util.*;
import serp.util.Strings;
@SuppressWarnings("serial")
public class ClassMetaData extends Extensions
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
    private static final Localizer _loc =
        Localizer.forPackage(ClassMetaData.class);
    private static final FetchGroup[] EMPTY_FETCH_GROUP_ARRAY =
        new FetchGroup[0];
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private MetaDataRepository _repos;
    private transient ClassLoader _loader = null;
    private final ValueMetaData _owner;
    private final LifecycleMetaData _lifeMeta = new LifecycleMetaData(this);
    private Class<?> _type = Object.class;
    private final Map<String, FieldMetaData> _fieldMap =
        new TreeMap<String, FieldMetaData>();
    private Boolean _openjpaId = null;
    private int _identity = ID_UNKNOWN;
    private int _accessType = AccessCode.UNKNOWN;
    protected ClassMetaData(Class<?> type, MetaDataRepository repos) {
        _repos = repos;
        _owner = null;
        setDescribedType(type);
    }
    protected ClassMetaData(ValueMetaData owner) {
        _owner = owner;
        _repos = owner.getRepository();
    }
    public MetaDataRepository getRepository() {
        return _repos;
    }
    public Class<?> getDescribedType() {
        return _type;
    }
    protected void setDescribedType(Class<?> type) {
        if (type.getSuperclass() != null
            && "java.lang.Enum".equals(type.getSuperclass().getName())) {
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
    public boolean isIntercepting() {
        return false;
    }
    public void setIntercepting(boolean intercepting) {
    }
    public int getIdentityType() {
        if (_identity == ID_UNKNOWN) {
            if (isMapped()) {
                _identity = ID_DATASTORE;
            } else {
                _identity = ID_APPLICATION;
            }
        }
        return _identity;
    }
    public void setIdentityType(int type) {
        _identity = type;
    }
    public boolean isMapped() {
        return true;
    }
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ClassMetaData)) {
            return false;
        }
        ClassMetaData cmd = (ClassMetaData) other;
        return _type.equals(cmd.getDescribedType());
    }
    public int hashCode() {
        return _type.getName().hashCode();
    }
    public int compareTo(ClassMetaData other) {
        if (other == this) {
            return 0;
        }
        return _type.getName().compareTo(other.getDescribedType().getName());
    }
    public String toString() {
        return _type.getName();
    }
    @Override
    public File getSourceFile() {
        return null;
    }
    @Override
    public Object getSourceScope() {
        return null;
    }
    @Override
    public int getSourceType() {
        return 0;
    }
    @Override
    public void setSource(File file, int srcType) {
    }
    @Override
    public String getResourceName() {
        return _type.getName();
    }
    @Override
    public int getLineNumber() {
        return 0;
    }
    @Override
    public void setLineNumber(int lineNum) {
    }
    @Override
    public int getColNumber() {
        return 0;
    }
    @Override
    public void setColNumber(int colNum) {
    }
    @Override
    public String[] getComments() {
        return EMPTY_STRING_ARRAY;
    }
    @Override
    public void setComments(String[] comments) {
    }
    @Override
    public void valueChanged(Value val) {
        if (val != null && val.matches("DataCacheTimeout")) {
        }
    }
}
