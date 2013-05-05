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
        if (Build.VERSION_CODES.ICE_CREAM_SANDWICH <= Build.VERSION.SDK_INT) {  // API level 14 and above
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
        if (Build.VERSION_CODES.ICE_CREAM_SANDWICH <= Build.VERSION.SDK_INT) {  // API level 14 and above
            assertNotNull(Telephony.Sms.Intents.SMS_CB_RECEIVED_ACTION);
            assertNotNull(Telephony.Sms.Intents.SMS_EMERGENCY_CB_RECEIVED_ACTION);
        } else {
            assertNull(Telephony.Sms.Intents.SMS_CB_RECEIVED_ACTION);
            assertNull(Telephony.Sms.Intents.SMS_EMERGENCY_CB_RECEIVED_ACTION);
        }
        if (Build.VERSION_CODES.JELLY_BEAN <= Build.VERSION.SDK_INT) {  // API level 16 and above
            assertNotNull(Telephony.Sms.Intents.SMS_SERVICE_CATEGORY_PROGRAM_DATA_RECEIVED_ACTION);
        } else {
            assertNull(Telephony.Sms.Intents.SMS_SERVICE_CATEGORY_PROGRAM_DATA_RECEIVED_ACTION);
        }
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
        if (Build.VERSION_CODES.ICE_CREAM_SANDWICH <= Build.VERSION.SDK_INT) {  // API level 14 and above
            assertNotNull(Telephony.BaseMmsColumns.DATE_SENT);
        } else {
            assertNull(Telephony.BaseMmsColumns.DATE_SENT);
        }
        assertNotNull(Telephony.BaseMmsColumns.MESSAGE_BOX);
        assertNotNull(Telephony.BaseMmsColumns.READ);
        assertNotNull(Telephony.BaseMmsColumns.SEEN);
        if (Build.VERSION_CODES.JELLY_BEAN_MR1 <= Build.VERSION.SDK_INT) {  // API level 17 and above
            assertNotNull(Telephony.BaseMmsColumns.TEXT_ONLY);
        } else {
            assertNull(Telephony.BaseMmsColumns.TEXT_ONLY);
        }
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

    public void testThreads() {
        assertNotNull(Telephony.Threads._cls);

        assertNotNull(Telephony.Threads.CONTENT_URI);
        assertNotNull(Telephony.Threads.OBSOLETE_THREADS_URI);

        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.Threads.COMMON_THREAD);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.Threads.BROADCAST_THREAD);

        // Telephony.Sms.Intents.getOrCreateThreadId()
        assertNotNull(Telephony.Threads._getOrCreateThreadId_String);
        assertNotNull(Telephony.Threads._getOrCreateThreadId_Set);
    }

    public void testMms() {
        assertNotNull(Telephony.Mms._cls);

        assertNotNull(Telephony.Mms.CONTENT_URI);
        assertNotNull(Telephony.Mms.REPORT_REQUEST_URI);
        assertNotNull(Telephony.Mms.REPORT_STATUS_URI);
        assertNotNull(Telephony.Mms.DEFAULT_SORT_ORDER);

        assertNotNull(Telephony.Mms.NAME_ADDR_EMAIL_PATTERN);
        assertNotNull(Telephony.Mms.QUOTED_STRING_PATTERN);
    }

    public void testMms_query() {
        // TODO: Test these with a ContentResolver.
        assertNotNull(Telephony.Mms._query_2);
        assertNotNull(Telephony.Mms._query_4);
    }

    public void testMms_getMessageBoxName() {
        assertNotNull(Telephony.Mms._getMessageBoxName);

        assertNotNull(Telephony.Mms.getMessageBoxName(Telephony.Mms.MESSAGE_BOX_ALL));
        assertNotNull(Telephony.Mms.getMessageBoxName(Telephony.Mms.MESSAGE_BOX_INBOX));
        assertNotNull(Telephony.Mms.getMessageBoxName(Telephony.Mms.MESSAGE_BOX_SENT));
        assertNotNull(Telephony.Mms.getMessageBoxName(Telephony.Mms.MESSAGE_BOX_DRAFTS));
        assertNotNull(Telephony.Mms.getMessageBoxName(Telephony.Mms.MESSAGE_BOX_OUTBOX));
    }

    public void testMms_extractAddrSpec() {
        assertNotNull(Telephony.Mms._extractAddrSpec);

        assertEquals("", Telephony.Mms.extractAddrSpec(""));
        assertEquals("spam@example.com", Telephony.Mms.extractAddrSpec("Spam <spam@example.com>"));
    }

    public void testMms_isEmailAddress() {
        assertNotNull(Telephony.Mms._isEmailAddress);

        assertFalse(Telephony.Mms.isEmailAddress(null));
        assertFalse(Telephony.Mms.isEmailAddress(""));
        assertTrue(Telephony.Mms.isEmailAddress("spam@example.com"));
    }

    public void testMms_isPhoneNumber() {
        assertNotNull(Telephony.Mms._isPhoneNumber);

        assertFalse(Telephony.Mms.isPhoneNumber(null));
        assertFalse(Telephony.Mms.isPhoneNumber(""));
        assertFalse(Telephony.Mms.isPhoneNumber("spam"));
        assertTrue(Telephony.Mms.isPhoneNumber("+1234567890"));
    }

    public void testMmsInbox() {
        assertNotNull(Telephony.Mms.Inbox._cls);

        assertNotNull(Telephony.Mms.Inbox.CONTENT_URI);
        assertNotNull(Telephony.Mms.Inbox.DEFAULT_SORT_ORDER);
    }

    public void testMmsSent() {
        assertNotNull(Telephony.Mms.Sent._cls);

        assertNotNull(Telephony.Mms.Inbox.CONTENT_URI);
        assertNotNull(Telephony.Mms.Inbox.DEFAULT_SORT_ORDER);
    }

    public void testMmsDraft() {
        assertNotNull(Telephony.Mms.Draft._cls);

        assertNotNull(Telephony.Mms.Inbox.CONTENT_URI);
        assertNotNull(Telephony.Mms.Inbox.DEFAULT_SORT_ORDER);
    }

    public void testMmsOutbox() {
        assertNotNull(Telephony.Mms.Outbox._cls);

        assertNotNull(Telephony.Mms.Inbox.CONTENT_URI);
        assertNotNull(Telephony.Mms.Inbox.DEFAULT_SORT_ORDER);
    }

    public void testMmsAddr() {
        assertNotNull(Telephony.Mms.Addr._cls);

        assertNotNull(Telephony.Mms.Addr.MSG_ID);
        assertNotNull(Telephony.Mms.Addr.CONTACT_ID);
        assertNotNull(Telephony.Mms.Addr.ADDRESS);
        assertNotNull(Telephony.Mms.Addr.TYPE);
        assertNotNull(Telephony.Mms.Addr.CHARSET);
    }

    public void testMmsPart() {
        assertNotNull(Telephony.Mms.Part._cls);

        assertNotNull(Telephony.Mms.Part.MSG_ID);
        assertNotNull(Telephony.Mms.Part.SEQ);
        assertNotNull(Telephony.Mms.Part.CONTENT_TYPE);
        assertNotNull(Telephony.Mms.Part.NAME);
        assertNotNull(Telephony.Mms.Part.CHARSET);
        assertNotNull(Telephony.Mms.Part.FILENAME);
        assertNotNull(Telephony.Mms.Part.CONTENT_DISPOSITION);
        assertNotNull(Telephony.Mms.Part.CONTENT_ID);
        assertNotNull(Telephony.Mms.Part.CONTENT_LOCATION);
        assertNotNull(Telephony.Mms.Part.CT_START);
        assertNotNull(Telephony.Mms.Part.CT_TYPE);
        assertNotNull(Telephony.Mms.Part._DATA);
        assertNotNull(Telephony.Mms.Part.TEXT);
    }

    public void testMmsRate() {
        assertNotNull(Telephony.Mms.Rate._cls);

        assertNotNull(Telephony.Mms.Rate.CONTENT_URI);
        assertNotNull(Telephony.Mms.Rate.SENT_TIME);
    }

    public void testMmsIntents() {
        assertNotNull(Telephony.Mms.Intents._cls);

        assertNotNull(Telephony.Mms.Intents.EXTRA_CONTENTS);
        assertNotNull(Telephony.Mms.Intents.EXTRA_TYPES);
        assertNotNull(Telephony.Mms.Intents.EXTRA_CC);
        assertNotNull(Telephony.Mms.Intents.EXTRA_BCC);
        assertNotNull(Telephony.Mms.Intents.EXTRA_SUBJECT);
        assertNotNull(Telephony.Mms.Intents.CONTENT_CHANGED_ACTION);
        assertNotNull(Telephony.Mms.Intents.DELETED_CONTENTS);
    }

    public void testMmsSms() {
        assertNotNull(Telephony.MmsSms._cls);

        assertNotNull(Telephony.MmsSms.TYPE_DISCRIMINATOR_COLUMN);

        assertNotNull(Telephony.MmsSms.CONTENT_URI);
        assertNotNull(Telephony.MmsSms.CONTENT_CONVERSATIONS_URI);
        assertNotNull(Telephony.MmsSms.CONTENT_FILTER_BYPHONE_URI);
        assertNotNull(Telephony.MmsSms.CONTENT_UNDELIVERED_URI);
        assertNotNull(Telephony.MmsSms.CONTENT_DRAFT_URI);
        assertNotNull(Telephony.MmsSms.CONTENT_LOCKED_URI);
        assertNotNull(Telephony.MmsSms.SEARCH_URI);

        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.MmsSms.SMS_PROTO);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.MmsSms.MMS_PROTO);

        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.MmsSms.NO_ERROR);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.MmsSms.ERR_TYPE_GENERIC);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.MmsSms.ERR_TYPE_SMS_PROTO_TRANSIENT);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.MmsSms.ERR_TYPE_MMS_PROTO_TRANSIENT);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.MmsSms.ERR_TYPE_TRANSPORT_FAILURE);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.MmsSms.ERR_TYPE_GENERIC_PERMANENT);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.MmsSms.ERR_TYPE_SMS_PROTO_PERMANENT);
        MoreAsserts.assertNotEqual(Telephony._MISSING, Telephony.MmsSms.ERR_TYPE_MMS_PROTO_PERMANENT);
    }

    public void testMmsSmsPendingMessages() {
        assertNotNull(Telephony.MmsSms.PendingMessages._cls);

        assertNotNull(Telephony.MmsSms.PendingMessages.CONTENT_URI);

        assertNotNull(Telephony.MmsSms.PendingMessages.PROTO_TYPE);
        assertNotNull(Telephony.MmsSms.PendingMessages.MSG_ID);
        assertNotNull(Telephony.MmsSms.PendingMessages.MSG_TYPE);
        assertNotNull(Telephony.MmsSms.PendingMessages.ERROR_TYPE);
        assertNotNull(Telephony.MmsSms.PendingMessages.ERROR_CODE);
        assertNotNull(Telephony.MmsSms.PendingMessages.RETRY_INDEX);
        assertNotNull(Telephony.MmsSms.PendingMessages.DUE_TIME);
        assertNotNull(Telephony.MmsSms.PendingMessages.LAST_TRY);
    }

    public void testMmsSmsWordsTable() {
        assertNotNull(Telephony.MmsSms.WordsTable._cls);

        assertNotNull(Telephony.MmsSms.WordsTable.ID);
        assertNotNull(Telephony.MmsSms.WordsTable.SOURCE_ROW_ID);
        assertNotNull(Telephony.MmsSms.WordsTable.TABLE_ID);
        assertNotNull(Telephony.MmsSms.WordsTable.INDEXED_TEXT);
    }

    public void testCarriers() {
        assertNotNull(Telephony.Carriers._cls);

        assertNotNull(Telephony.Carriers.CONTENT_URI);
        assertNotNull(Telephony.Carriers.DEFAULT_SORT_ORDER);

        assertNotNull(Telephony.Carriers.NAME);
        assertNotNull(Telephony.Carriers.APN);
        assertNotNull(Telephony.Carriers.PROXY);
        assertNotNull(Telephony.Carriers.PORT);
        assertNotNull(Telephony.Carriers.MMSPROXY);
        assertNotNull(Telephony.Carriers.MMSPORT);
        assertNotNull(Telephony.Carriers.SERVER);
        assertNotNull(Telephony.Carriers.USER);
        assertNotNull(Telephony.Carriers.PASSWORD);
        assertNotNull(Telephony.Carriers.MMSC);
        assertNotNull(Telephony.Carriers.MCC);
        assertNotNull(Telephony.Carriers.MNC);
        assertNotNull(Telephony.Carriers.NUMERIC);
        assertNotNull(Telephony.Carriers.AUTH_TYPE);
        assertNotNull(Telephony.Carriers.TYPE);
        if (Build.VERSION_CODES.ICE_CREAM_SANDWICH <= Build.VERSION.SDK_INT) {  // API level 14 and above
            assertNotNull(Telephony.Carriers.INACTIVE_TIMER);
            assertNotNull(Telephony.Carriers.ENABLED);
            assertNotNull(Telephony.Carriers.CLASS);
            assertNotNull(Telephony.Carriers.PROTOCOL);
            assertNotNull(Telephony.Carriers.ROAMING_PROTOCOL);
        } else {
            assertNull(Telephony.Carriers.INACTIVE_TIMER);
            assertNull(Telephony.Carriers.ENABLED);
            assertNull(Telephony.Carriers.CLASS);
            assertNull(Telephony.Carriers.PROTOCOL);
            assertNull(Telephony.Carriers.ROAMING_PROTOCOL);
        }
        assertNotNull(Telephony.Carriers.CURRENT);
        if (Build.VERSION_CODES.ICE_CREAM_SANDWICH <= Build.VERSION.SDK_INT) {  // API level 14 and above
            assertNotNull(Telephony.Carriers.CARRIER_ENABLED);
            assertNotNull(Telephony.Carriers.BEARER);
        } else {
            assertNull(Telephony.Carriers.CARRIER_ENABLED);
            assertNull(Telephony.Carriers.BEARER);
        }
    }

    public void testCellBroadcasts() {
        if (Build.VERSION_CODES.JELLY_BEAN <= Build.VERSION.SDK_INT) {  // API level 16 and above
            assertNotNull(Telephony.CellBroadcasts._cls);

            assertNotNull(Telephony.CellBroadcasts.CONTENT_URI);

            assertNotNull(Telephony.CellBroadcasts.GEOGRAPHICAL_SCOPE);
            assertNotNull(Telephony.CellBroadcasts.SERIAL_NUMBER);
            assertNotNull(Telephony.CellBroadcasts.PLMN);
            assertNotNull(Telephony.CellBroadcasts.LAC);
            assertNotNull(Telephony.CellBroadcasts.CID);
            assertNotNull(Telephony.CellBroadcasts.V1_MESSAGE_CODE);
            assertNotNull(Telephony.CellBroadcasts.V1_MESSAGE_IDENTIFIER);
            assertNotNull(Telephony.CellBroadcasts.SERVICE_CATEGORY);
            assertNotNull(Telephony.CellBroadcasts.LANGUAGE_CODE);
            assertNotNull(Telephony.CellBroadcasts.MESSAGE_BODY);
            assertNotNull(Telephony.CellBroadcasts.DELIVERY_TIME);
            assertNotNull(Telephony.CellBroadcasts.MESSAGE_READ);
            assertNotNull(Telephony.CellBroadcasts.MESSAGE_FORMAT);
            assertNotNull(Telephony.CellBroadcasts.MESSAGE_PRIORITY);
            assertNotNull(Telephony.CellBroadcasts.ETWS_WARNING_TYPE);
            assertNotNull(Telephony.CellBroadcasts.CMAS_MESSAGE_CLASS);
            assertNotNull(Telephony.CellBroadcasts.CMAS_CATEGORY);
            assertNotNull(Telephony.CellBroadcasts.CMAS_RESPONSE_TYPE);
            assertNotNull(Telephony.CellBroadcasts.CMAS_SEVERITY);
            assertNotNull(Telephony.CellBroadcasts.CMAS_URGENCY);
            assertNotNull(Telephony.CellBroadcasts.CMAS_CERTAINTY);
            assertNotNull(Telephony.CellBroadcasts.DEFAULT_SORT_ORDER);

            assertNotNull(Telephony.CellBroadcasts.QUERY_COLUMNS);
        } else {
            assertNull(Telephony.CellBroadcasts._cls);
        }
    }

    public void testIntents() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {  // preceding API level 17
            assertNotNull(Telephony.Intents._cls);

            assertNotNull(Telephony.Intents.SECRET_CODE_ACTION);
            assertNotNull(Telephony.Intents.SPN_STRINGS_UPDATED_ACTION);
            assertNotNull(Telephony.Intents.EXTRA_SHOW_PLMN);
            assertNotNull(Telephony.Intents.EXTRA_PLMN);
            assertNotNull(Telephony.Intents.EXTRA_SHOW_SPN);
            assertNotNull(Telephony.Intents.EXTRA_SPN);
        } else {
            assertNull(Telephony.Intents._cls);
        }
    }

}
