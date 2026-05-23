package org.apache.openjpa.meta;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Black-Box tests for ClassMetaData.
 * Derived from the public API contract:
 *   - Constructors accept (Class<?>, MetaDataRepository) or (ValueMetaData)
 *   - Public constants must remain stable
 *   - Getters must round-trip what was set via setters or constructor
 *   - equals/hashCode/compareTo/toString follow standard contracts
 */
public class ClassMetaDataTest {

    /* === ID type constants must not change === */
    @Test public void testIdUnknownIsZero()      { assertEquals(0, ClassMetaData.ID_UNKNOWN); }
    @Test public void testIdDatastoreIsOne()     { assertEquals(1, ClassMetaData.ID_DATASTORE); }
    @Test public void testIdApplicationIsTwo()   { assertEquals(2, ClassMetaData.ID_APPLICATION); }

    /* === Access type constants must match AccessCode === */
    @Test public void testAccessUnknownMatchesAccessCode() {
        assertEquals(AccessCode.UNKNOWN, ClassMetaData.ACCESS_UNKNOWN);
    }
    @Test public void testAccessFieldMatchesAccessCode() {
        assertEquals(AccessCode.FIELD, ClassMetaData.ACCESS_FIELD);
    }
    @Test public void testAccessPropertyMatchesAccessCode() {
        assertEquals(AccessCode.PROPERTY, ClassMetaData.ACCESS_PROPERTY);
    }
    @Test public void testAccessExplicitMatchesAccessCode() {
        assertEquals(AccessCode.EXPLICIT, ClassMetaData.ACCESS_EXPLICIT);
    }

    /* === String constants must not change === */
    @Test public void testSyntheticConstant() {
        assertEquals("`syn", ClassMetaData.SYNTHETIC);
    }

    /*
     * === Behavioral contracts (Copilot MUST preserve these in any refactoring) ===
     *
     * 1. ClassMetaData(Class<?> type, MetaDataRepository repos):
     *    - Stores both arguments; getDescribedType() returns the Class, getRepository() returns the MetaDataRepository.
     *
     * 2. setEnvClassLoader(cl) followed by getEnvClassLoader() must return the same ClassLoader instance.
     *
     * 3. setIdentityType(int) followed by getIdentityType() must return the same value.
     *
     * 4. equals(Object): returns true iff other is a ClassMetaData with the same getDescribedType().
     *
     * 5. hashCode(): consistent with equals (same described type => same hash).
     *
     * 6. compareTo(ClassMetaData other): orders by described type's full class name (lexicographic).
     *
     * 7. toString(): returns the described type's full class name.
     *
     * 8. valueChanged(Value v): must not throw on null or on irrelevant Value objects.
     *
     * 9. All public methods of the original ClassMetaData (initialize, getField, getFieldMap,
     *    getDeclaredFields, getPersistenceCapableSuperclass, getDataCacheTimeout,
     *    getDataCacheName, isOpenJPAIdentity, isManagedInterface, etc.) MUST be preserved
     *    with the same signatures and equivalent semantics. They cannot be deleted or stubbed out.
     *
     * 10. The class must extend Extensions and implement Comparable<ClassMetaData>,
     *     SourceTracker, MetaDataContext, MetaDataModes, Commentable, ValueListener.
     */
}
