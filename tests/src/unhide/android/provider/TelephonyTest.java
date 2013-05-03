package unhide.android.provider;

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
        assertNotNull(Telephony.TextBasedSmsColumns.DATE_SENT);  // XXX: not in api level 10
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

}
