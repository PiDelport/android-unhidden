package unhide;

import java.lang.reflect.Field;

import junit.framework.TestCase;

/**
 * Test {@link Reflector}.
 */
public class ReflectorTest extends TestCase {

    public class Target {
        public static final int psf_int = 5;
        public static final String psf_String = "fnord";
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
        for (Class<?> cls : new Class[] {null, Object.class, Target.class}) {
            for (String name : new String[] {null, "", "spam"}) {
                assertNull(
                        "expected null for class <" + cls + ">, name <" + name + ">",
                        Reflector._field(cls, name));
            }
        }
    }

    public void testField_Target_int() {
        Field field = Reflector._field(Target.class, "psf_int");
        assertEquals(int.class, field.getType());
        assertEquals("public static final int unhide.ReflectorTest$Target.psf_int", field.toString());
    }

    public void testField_Target_String() {
        Field field = Reflector._field(Target.class, "psf_String");
        assertEquals(String.class, field.getType());
        assertEquals("public static final java.lang.String unhide.ReflectorTest$Target.psf_String", field.toString());
    }

    // Reflector._int()

    public void testInt_null() {
        for (Class<?> cls : new Class[] {null, Object.class, Target.class}) {
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
    }

    // Reflector._String()

    public void testString_null() {
        for (Class<?> cls : new Class[] {null, Object.class, Target.class}) {
            for (String name : new String[] {null, "", "spam"}) {
                assertNull(
                        "expected null for class <" + cls + ">, name <" + name + ">",
                        Reflector._String(cls, name));
            }
        }
    }

    public void testString_Target() {
        assertEquals("fnord", Reflector._String(Target.class, "psf_String"));
    }

    public void testString_wrongtype() {
        assertEquals(null, Reflector._String(Target.class, "psf_int"));
    }

}
