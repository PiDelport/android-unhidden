package unhide;

import android.net.Uri;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import junit.framework.TestCase;

/**
 * Test {@link Reflector}.
 */
public class ReflectorTest extends TestCase {

    /**
     * Test Reflector.autobox().
     */
    public void testAutobox_primitive() {
        assertSame(Byte.class, Reflector.autobox(byte.class));
        assertSame(Short.class, Reflector.autobox(short.class));
        assertSame(Integer.class, Reflector.autobox(int.class));
        assertSame(Long.class, Reflector.autobox(long.class));
        assertSame(Float.class, Reflector.autobox(float.class));
        assertSame(Double.class, Reflector.autobox(double.class));
        assertSame(Character.class, Reflector.autobox(char.class));
        assertSame(Boolean.class, Reflector.autobox(boolean.class));
    }

    /**
     * Reflector.autobox() should preserve non-primitive classes.
     */
    public void testAutobox_nonprimitive() {
        assertSame(Object.class, Reflector.autobox(Object.class));
        assertSame(String.class, Reflector.autobox(String.class));
    }

    public static class Target {
        public static final int psf_int = 5;
        public static final String psf_String = "fnord";
        public static final String psf_nullString = null;

        public static final Uri psf_Uri = Uri.parse("http://example.com/");
        public static final Uri psf_nullUri = null;

        public static final String upper(String s) {
            return s.toUpperCase();
        }

    }

    // Reflector._class()

    public void testClass_null() {
        assertNull(Reflector._class(null));
        assertNull(Reflector._class(""));
        assertNull(Reflector._class("Spam"));
    }

    public void testClass_self() {
        assertEquals(Reflector.class, Reflector._class("unhide.Reflector"));
    }

    public void testClass_Target() {
        assertEquals(Target.class, Reflector._class("unhide.ReflectorTest$Target"));
    }

    public void testClass_Telephony() {
        assertEquals("android.provider.Telephony", Reflector._class("android.provider.Telephony").getName());
    }

    // Reflector._field()

    public void testField_null() {
        for (Class<?> cls : new Class<?>[] {null, Object.class, Target.class}) {
            for (String name : new String[] {null, "", "spam"}) {
                assertNull(
                        "expected null for class <" + cls + ">, name <" + name + ">",
                        Reflector._field(cls, name));
            }
        }
    }

    public void testField_Target_int() {
        Field field = Reflector._field(Target.class, "psf_int");
        assertNotNull(field);
        assertEquals(int.class, field.getType());
        assertEquals("public static final int unhide.ReflectorTest$Target.psf_int", field.toString());
    }

    public void testField_Target_String() {
        Field field = Reflector._field(Target.class, "psf_String");
        assertNotNull(field);
        assertEquals(String.class, field.getType());
        assertEquals("public static final java.lang.String unhide.ReflectorTest$Target.psf_String", field.toString());
    }

    // Reflector._method()

    public void testMethod_null() {
        for (Class<?> cls : new Class<?>[] {null, Object.class, Target.class}) {
            for (String name : new String[] {null, "", "spam"}) {
                assertNull(
                        "expected null for class <" + cls + ">, method <" + name + ">",
                        Reflector._method(cls, name));
                assertNull(
                        "expected null for class <" + cls + ">, method <" + name + ">",
                        Reflector._method(cls, name, int.class, String.class));
            }
        }
    }

    public void testMethod_Target_upper() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = Reflector._method(Target.class, "upper", String.class);
        assertNotNull(method);
        assertEquals("public static final java.lang.String unhide.ReflectorTest$Target.upper(java.lang.String)", method.toString());
        assertEquals("FOO", method.invoke(null, "foo"));
    }

    public void testMethod_wrongsignature() {
        assertNull(Reflector._method(Target.class, "upper"));
        assertNull(Reflector._method(Target.class, "upper", int.class));
    }

    // Reflector._int()

    public void testInt_null() {
        for (Class<?> cls : new Class<?>[] {null, Object.class, Target.class}) {
            for (String name : new String[] {null, "", "spam"}) {
                assertEquals(
                        "expected default of -123 for class <" + cls + ">, name <" + name + ">",
                        -123, Reflector._int(cls, name, -123));
            }
        }
    }

    public void testInt_Target() {
        assertEquals(5, Reflector._int(Target.class, "psf_int", -123));
    }

    public void testInt_wrongtype() {
        assertEquals(-123, Reflector._int(Target.class, "psf_String", -123));
        assertEquals(-123, Reflector._int(Target.class, "psf_nullString", -123));
        assertEquals(-123, Reflector._int(Target.class, "psf_Uri", -123));
        assertEquals(-123, Reflector._int(Target.class, "psf_nullUri", -123));
    }

    // Reflector._String()

    public void testString_null() {
        for (Class<?> cls : new Class<?>[] {null, Object.class, Target.class}) {
            for (String name : new String[] {null, "", "spam"}) {
                assertNull(
                        "expected null for class <" + cls + ">, name <" + name + ">",
                        Reflector._String(cls, name));
            }
        }
    }

    public void testString_Target() {
        assertEquals("fnord", Reflector._String(Target.class, "psf_String"));
        assertEquals(null, Reflector._String(Target.class, "psf_nullString"));
    }

    public void testString_wrongtype() {
        assertEquals(null, Reflector._String(Target.class, "psf_Uri"));
        assertEquals(null, Reflector._String(Target.class, "psf_nullUri"));
        assertEquals(null, Reflector._String(Target.class, "psf_int"));
    }

    // Reflector._Uri()

    public void testUri_Target() {
        assertSame(Target.psf_Uri, Reflector._Uri(Target.class, "psf_Uri"));
        assertSame(null, Reflector._Uri(Target.class, "psf_nullUri"));
    }

    public void testUri_wrongtype() {
        assertEquals(null, Reflector._Uri(Target.class, "psf_String"));
        assertEquals(null, Reflector._Uri(Target.class, "psf_nullString"));
        assertEquals(null, Reflector._Uri(Target.class, "psf_int"));
    }

}
