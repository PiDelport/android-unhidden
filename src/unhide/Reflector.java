package unhide;

import android.net.Uri;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Reflection helpers.
 *
 * These helpers are intended to be input-tolerant: unless otherwise specified,
 * they will return null or default values, rather than propagate any errors
 * that occur while attempting to access the reflection targets.
 */
public class Reflector {

    /**
     * Convert primitive types to their corresponding boxed types.
     */
    public static Class<?> autobox(Class<?> cls) {
        if (! cls.isPrimitive()) {
            return cls;
        } else if (cls == byte.class) {
            return Byte.class;
        } else if (cls == short.class) {
            return Short.class;
        } else if (cls == int.class) {
            return Integer.class;
        } else if (cls == long.class) {
            return Long.class;
        } else if (cls == float.class) {
            return Float.class;
        } else if (cls == double.class) {
            return Double.class;
        } else if (cls == char.class) {
            return Character.class;
        } else if (cls == boolean.class) {
            return Boolean.class;
        } else {
            throw new RuntimeException("unhandled primitive type: " + cls);
        }
    }

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
     * Return cls.getMethod(name) or null.
     */
    public static Method _method(Class<?> cls, String name, Class<?>... parameterTypes) {
        if (cls != null && name != null) {
            try {
                return cls.getMethod(name, parameterTypes);
            } catch(NoSuchMethodException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Return <code>method.invoke(null, Object... args)</code>.
     *
     * Like {@link _invokeStaticUnchecked()}, but propagate all {@link
     * InvocationTargetException}s, allowing the caller to unwrap and rethrow
     * them correctly.
     */
    public static <RT> RT _invokeStaticChecked(Class<RT> rType, Method method, Object... args) throws InvocationTargetException {
        // Check preconditions...
        if (method == null) {
            throw new IllegalArgumentException("missing method");
        }
        if (! Modifier.isStatic(method.getModifiers())) {
            throw new IllegalArgumentException("method is not static: " + method);
        }
        if (rType.isPrimitive()) {
            throw new IllegalArgumentException("Don't call this with a primitive return type: use the corresponding boxed type instead.");
        }
        if (! rType.isAssignableFrom(autobox(method.getReturnType()))) {
            throw new IllegalArgumentException("expected method return type " + rType + ", got " + method.getReturnType());
        }
        // Try to invoke.
        Object result;
        try {
            result = method.invoke(null, args);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("method not accessible: " + method, e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("type error while invoking " + method, e);
        }
        return rType.cast(result);
    }

    /**
     * Return <code>method.invoke(null, Object... args)</code>.
     *
     * Like {@link _invokeStaticChecked()}, but wrap all {@link
     * InvocationTargetException}s in a {@link RuntimeException}.
     */
    public static <RT> RT _invokeStaticUnchecked(Class<RT> rType, Method method, Object... args) {
        try {
            return _invokeStaticChecked(rType, method, args);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("exception while invoking " + method, e.getCause());
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
