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

    public void testSmsInbox() {
        assertNotNull(Telephony.Sms.Inbox._cls);

        assertNotNull(Telephony.Sms.Inbox.CONTENT_URI);
        assertNotNull(Telephony.Sms.Inbox.DEFAULT_SORT_ORDER);

        // Telephony.Sms.Inbox.addMessage()
        assertNotNull(Telephony.Sms.Inbox._addMessage);
    }

    public void testSmsSent() {
        assertNotNull(Telephony.Sms.Sent._cls);

        assertNotNull(Telephony.Sms.Sent.CONTENT_URI);
        assertNotNull(Telephony.Sms.Sent.DEFAULT_SORT_ORDER);

        // Telephony.Sms.Sent.addMessage()
        assertNotNull(Telephony.Sms.Sent._addMessage);
    }

    public void testSmsDraft() {
        assertNotNull(Telephony.Sms.Draft._cls);

        assertNotNull(Telephony.Sms.Draft.CONTENT_URI);
        assertNotNull(Telephony.Sms.Draft.DEFAULT_SORT_ORDER);

        // Telephony.Sms.Draft.addMessage()
        assertNotNull(Telephony.Sms.Draft._addMessage);
        // Telephony.Sms.Draft.saveMessage()
        assertNotNull(Telephony.Sms.Draft._saveMessage);
    }

    public void testSmsOutbox() {
        assertNotNull(Telephony.Sms.Outbox._cls);

        assertNotNull(Telephony.Sms.Outbox.CONTENT_URI);
        assertNotNull(Telephony.Sms.Outbox.DEFAULT_SORT_ORDER);

        // Telephony.Sms.Outbox.addMessage()
        assertNotNull(Telephony.Sms.Outbox._addMessage);
    }

    public void testSmsConversations() {
        assertNotNull(Telephony.Sms.Conversations._cls);

        assertNotNull(Telephony.Sms.Conversations.CONTENT_URI);
        assertNotNull(Telephony.Sms.Conversations.DEFAULT_SORT_ORDER);
        assertNotNull(Telephony.Sms.Conversations.SNIPPET);
        assertNotNull(Telephony.Sms.Conversations.MESSAGE_COUNT);
    }

    public void testSmsIntents() {
        assertNotNull(Telephony.Sms.Intents._cls);

        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.Sms.Intents.RESULT_SMS_HANDLED);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.Sms.Intents.RESULT_SMS_GENERIC_ERROR);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.Sms.Intents.RESULT_SMS_OUT_OF_MEMORY);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.Sms.Intents.RESULT_SMS_UNSUPPORTED);

        assertNotNull(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
        assertNotNull(Telephony.Sms.Intents.DATA_SMS_RECEIVED_ACTION);
        assertNotNull(Telephony.Sms.Intents.WAP_PUSH_RECEIVED_ACTION);
        assertNotNull(Telephony.Sms.Intents.SMS_CB_RECEIVED_ACTION);
        assertNotNull(Telephony.Sms.Intents.SMS_EMERGENCY_CB_RECEIVED_ACTION);
        assertNotNull(Telephony.Sms.Intents.SIM_FULL_ACTION);
        assertNotNull(Telephony.Sms.Intents.SMS_REJECTED_ACTION);

        // Telephony.Sms.Intents.getMessagesFromIntent()
        assertNotNull(Telephony.Sms.Intents._getMessagesFromIntent);
    }

    public void testBaseMmsColumns() {
        assertNotNull(Telephony.BaseMmsColumns._cls);

        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.BaseMmsColumns.MESSAGE_BOX_ALL);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.BaseMmsColumns.MESSAGE_BOX_INBOX);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.BaseMmsColumns.MESSAGE_BOX_SENT);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.BaseMmsColumns.MESSAGE_BOX_DRAFTS);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.BaseMmsColumns.MESSAGE_BOX_OUTBOX);

        assertNotNull(Telephony.BaseMmsColumns.DATE);
        assertNotNull(Telephony.BaseMmsColumns.DATE_SENT);
        assertNotNull(Telephony.BaseMmsColumns.MESSAGE_BOX);
        assertNotNull(Telephony.BaseMmsColumns.READ);
        assertNotNull(Telephony.BaseMmsColumns.SEEN);
        assertNotNull(Telephony.BaseMmsColumns.MESSAGE_ID);
        assertNotNull(Telephony.BaseMmsColumns.SUBJECT);
        assertNotNull(Telephony.BaseMmsColumns.SUBJECT_CHARSET);
        assertNotNull(Telephony.BaseMmsColumns.CONTENT_TYPE);
        assertNotNull(Telephony.BaseMmsColumns.CONTENT_LOCATION);
        assertNotNull(Telephony.BaseMmsColumns.FROM);
        assertNotNull(Telephony.BaseMmsColumns.TO);
        assertNotNull(Telephony.BaseMmsColumns.CC);
        assertNotNull(Telephony.BaseMmsColumns.BCC);
        assertNotNull(Telephony.BaseMmsColumns.EXPIRY);
        assertNotNull(Telephony.BaseMmsColumns.MESSAGE_CLASS);
        assertNotNull(Telephony.BaseMmsColumns.MESSAGE_TYPE);
        assertNotNull(Telephony.BaseMmsColumns.MMS_VERSION);
        assertNotNull(Telephony.BaseMmsColumns.MESSAGE_SIZE);
        assertNotNull(Telephony.BaseMmsColumns.PRIORITY);
        assertNotNull(Telephony.BaseMmsColumns.READ_REPORT);
        assertNotNull(Telephony.BaseMmsColumns.REPORT_ALLOWED);
        assertNotNull(Telephony.BaseMmsColumns.RESPONSE_STATUS);
        assertNotNull(Telephony.BaseMmsColumns.STATUS);
        assertNotNull(Telephony.BaseMmsColumns.TRANSACTION_ID);
        assertNotNull(Telephony.BaseMmsColumns.RETRIEVE_STATUS);
        assertNotNull(Telephony.BaseMmsColumns.RETRIEVE_TEXT);
        assertNotNull(Telephony.BaseMmsColumns.RETRIEVE_TEXT_CHARSET);
        assertNotNull(Telephony.BaseMmsColumns.READ_STATUS);
        assertNotNull(Telephony.BaseMmsColumns.CONTENT_CLASS);
        assertNotNull(Telephony.BaseMmsColumns.DELIVERY_REPORT);
        assertNotNull(Telephony.BaseMmsColumns.DELIVERY_TIME_TOKEN);
        assertNotNull(Telephony.BaseMmsColumns.DELIVERY_TIME);
        assertNotNull(Telephony.BaseMmsColumns.RESPONSE_TEXT);
        assertNotNull(Telephony.BaseMmsColumns.SENDER_VISIBILITY);
        assertNotNull(Telephony.BaseMmsColumns.REPLY_CHARGING);
        assertNotNull(Telephony.BaseMmsColumns.REPLY_CHARGING_DEADLINE_TOKEN);
        assertNotNull(Telephony.BaseMmsColumns.REPLY_CHARGING_DEADLINE);
        assertNotNull(Telephony.BaseMmsColumns.REPLY_CHARGING_ID);
        assertNotNull(Telephony.BaseMmsColumns.REPLY_CHARGING_SIZE);
        assertNotNull(Telephony.BaseMmsColumns.PREVIOUSLY_SENT_BY);
        assertNotNull(Telephony.BaseMmsColumns.PREVIOUSLY_SENT_DATE);
        assertNotNull(Telephony.BaseMmsColumns.STORE);
        assertNotNull(Telephony.BaseMmsColumns.MM_STATE);
        assertNotNull(Telephony.BaseMmsColumns.MM_FLAGS_TOKEN);
        assertNotNull(Telephony.BaseMmsColumns.MM_FLAGS);
        assertNotNull(Telephony.BaseMmsColumns.STORE_STATUS);
        assertNotNull(Telephony.BaseMmsColumns.STORE_STATUS_TEXT);
        assertNotNull(Telephony.BaseMmsColumns.STORED);
        assertNotNull(Telephony.BaseMmsColumns.TOTALS);
        assertNotNull(Telephony.BaseMmsColumns.MBOX_TOTALS);
        assertNotNull(Telephony.BaseMmsColumns.MBOX_TOTALS_TOKEN);
        assertNotNull(Telephony.BaseMmsColumns.QUOTAS);
        assertNotNull(Telephony.BaseMmsColumns.MBOX_QUOTAS);
        assertNotNull(Telephony.BaseMmsColumns.MBOX_QUOTAS_TOKEN);
        assertNotNull(Telephony.BaseMmsColumns.MESSAGE_COUNT);
        assertNotNull(Telephony.BaseMmsColumns.START);
        assertNotNull(Telephony.BaseMmsColumns.DISTRIBUTION_INDICATOR);
        assertNotNull(Telephony.BaseMmsColumns.ELEMENT_DESCRIPTOR);
        assertNotNull(Telephony.BaseMmsColumns.LIMIT);
        assertNotNull(Telephony.BaseMmsColumns.RECOMMENDED_RETRIEVAL_MODE);
        assertNotNull(Telephony.BaseMmsColumns.RECOMMENDED_RETRIEVAL_MODE_TEXT);
        assertNotNull(Telephony.BaseMmsColumns.STATUS_TEXT);
        assertNotNull(Telephony.BaseMmsColumns.APPLIC_ID);
        assertNotNull(Telephony.BaseMmsColumns.REPLY_APPLIC_ID);
        assertNotNull(Telephony.BaseMmsColumns.AUX_APPLIC_ID);
        assertNotNull(Telephony.BaseMmsColumns.DRM_CONTENT);
        assertNotNull(Telephony.BaseMmsColumns.ADAPTATION_ALLOWED);
        assertNotNull(Telephony.BaseMmsColumns.REPLACE_ID);
        assertNotNull(Telephony.BaseMmsColumns.CANCEL_ID);
        assertNotNull(Telephony.BaseMmsColumns.CANCEL_STATUS);
        assertNotNull(Telephony.BaseMmsColumns.THREAD_ID);
        assertNotNull(Telephony.BaseMmsColumns.LOCKED);
        assertNotNull(Telephony.BaseMmsColumns.META_DATA);
    }

    public void testCanonicalAddressesColumns() {
        assertNotNull(Telephony.CanonicalAddressesColumns._cls);

        assertNotNull(Telephony.CanonicalAddressesColumns.ADDRESS);
    }

    public void testThreadsColumns() {
        assertNotNull(Telephony.ThreadsColumns._cls);

        assertNotNull(Telephony.ThreadsColumns.DATE);
        assertNotNull(Telephony.ThreadsColumns.RECIPIENT_IDS);
        assertNotNull(Telephony.ThreadsColumns.MESSAGE_COUNT);
        assertNotNull(Telephony.ThreadsColumns.READ);
        assertNotNull(Telephony.ThreadsColumns.SNIPPET);
        assertNotNull(Telephony.ThreadsColumns.SNIPPET_CHARSET);
        assertNotNull(Telephony.ThreadsColumns.TYPE);
        assertNotNull(Telephony.ThreadsColumns.ERROR);
        assertNotNull(Telephony.ThreadsColumns.HAS_ATTACHMENT);
    }

}
