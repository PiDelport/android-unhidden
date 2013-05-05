package unhide.android.provider;

import android.os.Build;
import android.test.MoreAsserts;

import junit.framework.TestCase;

public class TelephonyTest extends TestCase {

    public void testTelephony() {
        assertNotNull(Telephony._cls);
    }

    public void testTextBasedSmsColumns() {
        assertNotNull(Telephony.TextBasedSmsColumns._cls);

        assertNotNull(Telephony.TextBasedSmsColumns.TYPE);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.TextBasedSmsColumns.MESSAGE_TYPE_ALL);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.TextBasedSmsColumns.MESSAGE_TYPE_INBOX);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.TextBasedSmsColumns.MESSAGE_TYPE_SENT);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.TextBasedSmsColumns.MESSAGE_TYPE_DRAFT);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.TextBasedSmsColumns.MESSAGE_TYPE_OUTBOX);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.TextBasedSmsColumns.MESSAGE_TYPE_FAILED);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.TextBasedSmsColumns.MESSAGE_TYPE_QUEUED);

        assertNotNull(Telephony.TextBasedSmsColumns.THREAD_ID);
        assertNotNull(Telephony.TextBasedSmsColumns.ADDRESS);
        assertNotNull(Telephony.TextBasedSmsColumns.PERSON_ID);
        assertNotNull(Telephony.TextBasedSmsColumns.DATE);
        if (Build.VERSION_CODES.ICE_CREAM_SANDWICH <= Build.VERSION.SDK_INT) {
            assertNotNull(Telephony.TextBasedSmsColumns.DATE_SENT);
        } else {
            assertNull(Telephony.TextBasedSmsColumns.DATE_SENT);
        }
        assertNotNull(Telephony.TextBasedSmsColumns.READ);
        assertNotNull(Telephony.TextBasedSmsColumns.SEEN);

        assertNotNull(Telephony.TextBasedSmsColumns.STATUS);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.TextBasedSmsColumns.STATUS_NONE);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.TextBasedSmsColumns.STATUS_COMPLETE);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.TextBasedSmsColumns.STATUS_PENDING);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.TextBasedSmsColumns.STATUS_FAILED);

        assertNotNull(Telephony.TextBasedSmsColumns.SUBJECT);
        assertNotNull(Telephony.TextBasedSmsColumns.BODY);
        assertNotNull(Telephony.TextBasedSmsColumns.PERSON);
        assertNotNull(Telephony.TextBasedSmsColumns.PROTOCOL);
        assertNotNull(Telephony.TextBasedSmsColumns.REPLY_PATH_PRESENT);
        assertNotNull(Telephony.TextBasedSmsColumns.SERVICE_CENTER);
        assertNotNull(Telephony.TextBasedSmsColumns.LOCKED);
        assertNotNull(Telephony.TextBasedSmsColumns.ERROR_CODE);
        assertNotNull(Telephony.TextBasedSmsColumns.META_DATA);
    }

    public void testSms() {
        assertNotNull(Telephony.Sms._cls);

        assertNotNull(Telephony.Sms.CONTENT_URI);
        assertNotNull(Telephony.Sms.DEFAULT_SORT_ORDER);
    }

    public void testSMS_isOutgoingFolder() {
        assertFalse(Telephony.Sms.isOutgoingFolder(Telephony.Sms.MESSAGE_TYPE_ALL));
        assertFalse(Telephony.Sms.isOutgoingFolder(Telephony.Sms.MESSAGE_TYPE_INBOX));
        assertTrue(Telephony.Sms.isOutgoingFolder(Telephony.Sms.MESSAGE_TYPE_SENT));
        assertFalse(Telephony.Sms.isOutgoingFolder(Telephony.Sms.MESSAGE_TYPE_DRAFT));
        assertTrue(Telephony.Sms.isOutgoingFolder(Telephony.Sms.MESSAGE_TYPE_OUTBOX));
        assertTrue(Telephony.Sms.isOutgoingFolder(Telephony.Sms.MESSAGE_TYPE_FAILED));
        assertTrue(Telephony.Sms.isOutgoingFolder(Telephony.Sms.MESSAGE_TYPE_QUEUED));
    }

    public void testSMS_operations() {
        // TODO: Test these with a ContentResolver.

        // Telephony.Sms.query()
        assertNotNull(Telephony.Sms._query_2);
        assertNotNull(Telephony.Sms._query_4);

        // Telephony.Sms.addMessageToUri()
        assertNotNull(Telephony.Sms._addMessageToUri_8);
        assertNotNull(Telephony.Sms._addMessageToUri_9);

        // Telephony.Sms.moveMessageToFolder()
        assertNotNull(Telephony.Sms._moveMessageToFolder);
    }

}
