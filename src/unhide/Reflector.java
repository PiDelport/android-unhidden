package unhide;

import android.net.Uri;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * Reflection helpers.
 *
 * These helpers are intended to be input-tolerant: unless otherwise specified,
 * they will return null or default values, rather than propagate any errors
 * that occur while attempting to access the reflection targets.
 */
public class Reflector {

    /**
     * Return Class.forName(className) or null.
     */
    public static Class<?> _class(String className) {
        if (className != null) {
            try {
                return Class.forName(className);
            } catch(ClassNotFoundException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Return cls.getField(name) or null.
     */
    public static Field _field(Class<?> cls, String name) {
        if (name != null) {
            if (cls != null) {
                try {
                    return cls.getField(name);
                } catch(NoSuchFieldException e) {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Return the specified static field value, cast to the given type, or null.
     *
     * NOTE: Passing a primitive type as <code>type</code> will not work, due
     * to {@link Field.get()}'s boxing. To access a primitive type field, call
     * this with the corresponding boxed type instead.
     */
    public static <T> T _fieldValueAsType(Class<T> type, Class<?> cls, String name) {
        if (type.isPrimitive()) {
            throw new IllegalArgumentException("Don't call this with primitive types: use the corresponding boxed type instead.");
        }

        Field field = _field(cls, name);
        if (field != null) {
            Object value;
            try {
                value = field.get(null);
            } catch(IllegalAccessException e) {
                Log.wtf(Reflector.class.getName(), "error getting " + cls + "." + name + " as type " + type + ": " + e.toString());
                return null;
            }
            if (value == null) {
                return null;  // value is actually null.
            } else
                if (type.isInstance(value)) {
                return type.cast(value);
            } else {
                Log.wtf(Reflector.class.getName(), "type error getting " + cls + "." + name + ": expected " + type + ", got " + value.getClass());
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Return the specified static String field value, or null.
     */
    public static String _String(Class<?> cls, String name) {
        return _fieldValueAsType(String.class, cls, name);
    }

    /**
     * Return the specified static int value, or the default value.
     */
    public static int _int(Class<?> cls, String name, int defaultValue) {
        Integer value = _fieldValueAsType(Integer.class, cls, name);
        return (value != null) ? value : defaultValue;
    }

    /**
     * Return the specified static Uri field value, or null.
     */
    public static Uri _Uri(Class<?> cls, String name) {
        return _fieldValueAsType(Uri.class, cls, name);
    }

}
