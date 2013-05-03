package unhide;

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
     * Return the specified static String field value, or null.
     */
    public static String _String(Class<?> cls, String name) {
        Field field = _field(cls, name);
        if (field != null) {
            try {
                Object value = field.get(null);
                return (String) value;
            } catch(IllegalAccessException e) {
                Log.wtf(Reflector.class.getName(), "error getting String " + cls + "." + name + ": " + e.toString());
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Return the specified static int value, or the default value.
     */
    public static int _int(Class<?> cls, String name, int defaultValue) {
        Field field = _field(cls, name);
        if (field != null) {
            try {
                return field.getInt(null);
            } catch(IllegalAccessException e) {
                Log.wtf(Reflector.class.getName(), "error getting int " + cls + "." + name + ": " + e.toString());
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

}
