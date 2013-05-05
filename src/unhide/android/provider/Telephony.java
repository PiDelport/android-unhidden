/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package unhide.android.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;
import android.telephony.SmsMessage;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.regex.Pattern;

import unhide.Reflector;

/**
 * The Telephony provider contains data related to phone operation.
 */
public final class Telephony {

    public static final int _MISSING = -1729;

    public static final Class<?> _cls = Reflector._class("android.provider.Telephony");


    // Constructor
    public Telephony() {
    }

    /**
     * Base columns for tables that contain text based SMSs.
     */
    public interface TextBasedSmsColumns {

        public static final Class<?> _cls = Reflector._class("android.provider.Telephony$TextBasedSmsColumns");

        /**
         * The type of the message
         * <P>Type: INTEGER</P>
         */
        public static final String TYPE = Reflector._String(_cls, "TYPE");

        public static final int MESSAGE_TYPE_ALL    = Reflector._int(_cls, "MESSAGE_TYPE_ALL", _MISSING);
        public static final int MESSAGE_TYPE_INBOX  = Reflector._int(_cls, "MESSAGE_TYPE_INBOX", _MISSING);
        public static final int MESSAGE_TYPE_SENT   = Reflector._int(_cls, "MESSAGE_TYPE_SENT", _MISSING);
        public static final int MESSAGE_TYPE_DRAFT  = Reflector._int(_cls, "MESSAGE_TYPE_DRAFT", _MISSING);
        public static final int MESSAGE_TYPE_OUTBOX = Reflector._int(_cls, "MESSAGE_TYPE_OUTBOX", _MISSING);
        public static final int MESSAGE_TYPE_FAILED = Reflector._int(_cls, "MESSAGE_TYPE_FAILED", _MISSING); // for failed outgoing messages
        public static final int MESSAGE_TYPE_QUEUED = Reflector._int(_cls, "MESSAGE_TYPE_QUEUED", _MISSING); // for messages to send later


        /**
         * The thread ID of the message
         * <P>Type: INTEGER</P>
         */
        public static final String THREAD_ID = Reflector._String(_cls, "THREAD_ID");

        /**
         * The address of the other party
         * <P>Type: TEXT</P>
         */
        public static final String ADDRESS = Reflector._String(_cls, "ADDRESS");

        /**
         * The person ID of the sender
         * <P>Type: INTEGER (long)</P>
         */
        public static final String PERSON_ID = Reflector._String(_cls, "PERSON_ID");

        /**
         * The date the message was received
         * <P>Type: INTEGER (long)</P>
         */
        public static final String DATE = Reflector._String(_cls, "DATE");

        /**
         * The date the message was sent
         * <P>Type: INTEGER (long)</P>
         */
        public static final String DATE_SENT = Reflector._String(_cls, "DATE_SENT");

        /**
         * Has the message been read
         * <P>Type: INTEGER (boolean)</P>
         */
        public static final String READ = Reflector._String(_cls, "READ");

        /**
         * Indicates whether this message has been seen by the user. The "seen" flag will be
         * used to figure out whether we need to throw up a statusbar notification or not.
         */
        public static final String SEEN = Reflector._String(_cls, "SEEN");

        /**
         * The TP-Status value for the message, or -1 if no status has
         * been received
         */
        public static final String STATUS = Reflector._String(_cls, "STATUS");

        public static final int STATUS_NONE = Reflector._int(_cls, "STATUS_NONE", _MISSING);
        public static final int STATUS_COMPLETE = Reflector._int(_cls, "STATUS_COMPLETE", _MISSING);
        public static final int STATUS_PENDING = Reflector._int(_cls, "STATUS_PENDING", _MISSING);
        public static final int STATUS_FAILED = Reflector._int(_cls, "STATUS_FAILED", _MISSING);

        /**
         * The subject of the message, if present
         * <P>Type: TEXT</P>
         */
        public static final String SUBJECT = Reflector._String(_cls, "SUBJECT");

        /**
         * The body of the message
         * <P>Type: TEXT</P>
         */
        public static final String BODY = Reflector._String(_cls, "BODY");

        /**
         * The id of the sender of the conversation, if present
         * <P>Type: INTEGER (reference to item in content://contacts/people)</P>
         */
        public static final String PERSON = Reflector._String(_cls, "PERSON");

        /**
         * The protocol identifier code
         * <P>Type: INTEGER</P>
         */
        public static final String PROTOCOL = Reflector._String(_cls, "PROTOCOL");

        /**
         * Whether the <code>TP-Reply-Path</code> bit was set on this message
         * <P>Type: BOOLEAN</P>
         */
        public static final String REPLY_PATH_PRESENT = Reflector._String(_cls, "REPLY_PATH_PRESENT");

        /**
         * The service center (SC) through which to send the message, if present
         * <P>Type: TEXT</P>
         */
        public static final String SERVICE_CENTER = Reflector._String(_cls, "SERVICE_CENTER");

        /**
         * Has the message been locked?
         * <P>Type: INTEGER (boolean)</P>
         */
        public static final String LOCKED = Reflector._String(_cls, "LOCKED");

        /**
         * Error code associated with sending or receiving this message
         * <P>Type: INTEGER</P>
         */
        public static final String ERROR_CODE = Reflector._String(_cls, "ERROR_CODE");

        /**
         * Meta data used externally.
         * <P>Type: TEXT</P>
         */
        public static final String META_DATA = Reflector._String(_cls, "META_DATA");
    }

    /**
     * Contains all text based SMS messages.
     */
    public static final class Sms implements BaseColumns, TextBasedSmsColumns {

        public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Sms");

        public static final Cursor query(ContentResolver cr, String[] projection) {
            return Reflector._invokeStaticUnchecked(Cursor.class, _query_2, cr, projection);
        }
        public static final Method _query_2 = Reflector._method(_cls, "query", ContentResolver.class, String[].class);

        public static final Cursor query(ContentResolver cr, String[] projection,
                String where, String orderBy) {
            return Reflector._invokeStaticUnchecked(Cursor.class, _query_4, cr, projection, where, orderBy);
        }
        public static final Method _query_4 = Reflector._method(_cls, "query", ContentResolver.class, String[].class,
                String.class, String.class);

        /**
         * The content:// style URL for this table
         */
        public static final Uri CONTENT_URI = Reflector._Uri(_cls, "CONTENT_URI");

        /**
         * The default sort order for this table
         */
        public static final String DEFAULT_SORT_ORDER = Reflector._String(_cls, "DEFAULT_SORT_ORDER");

        /**
         * Add an SMS to the given URI.
         *
         * @param resolver the content resolver to use
         * @param uri the URI to add the message to
         * @param address the address of the sender
         * @param body the body of the message
         * @param subject the psuedo-subject of the message
         * @param date the timestamp for the message
         * @param read true if the message has been read, false if not
         * @param deliveryReport true if a delivery report was requested, false if not
         * @return the URI for the new message
         */
        public static Uri addMessageToUri(ContentResolver resolver,
                Uri uri, String address, String body, String subject,
                Long date, boolean read, boolean deliveryReport) {
            return Reflector._invokeStaticUnchecked(Uri.class, _addMessageToUri_8, resolver,
                uri, address, body, subject,
                date, read, deliveryReport);
        }
        public static final Method _addMessageToUri_8 = Reflector._method(_cls, "addMessageToUri", ContentResolver.class,
                Uri.class, String.class, String.class, String.class,
                Long.class, boolean.class, boolean.class);

        /**
         * Add an SMS to the given URI with thread_id specified.
         *
         * @param resolver the content resolver to use
         * @param uri the URI to add the message to
         * @param address the address of the sender
         * @param body the body of the message
         * @param subject the psuedo-subject of the message
         * @param date the timestamp for the message
         * @param read true if the message has been read, false if not
         * @param deliveryReport true if a delivery report was requested, false if not
         * @param threadId the thread_id of the message
         * @return the URI for the new message
         */
        public static Uri addMessageToUri(ContentResolver resolver,
                Uri uri, String address, String body, String subject,
                Long date, boolean read, boolean deliveryReport, long threadId) {
            return Reflector._invokeStaticUnchecked(Uri.class, _addMessageToUri_9, resolver,
                uri, address, body, subject,
                date, read, deliveryReport, threadId);
        }
        public static final Method _addMessageToUri_9 = Reflector._method(_cls, "addMessageToUri", ContentResolver.class,
                Uri.class, String.class, String.class, String.class,
                Long.class, boolean.class, boolean.class, long.class);

        /**
         * Move a message to the given folder.
         *
         * @param context the context to use
         * @param uri the message to move
         * @param folder the folder to move to
         * @return true if the operation succeeded
         */
        public static boolean moveMessageToFolder(Context context,
                Uri uri, int folder, int error) {
            return Reflector._invokeStaticUnchecked(boolean.class, _moveMessageToFolder, context,
                uri, folder, error);
        }
        public static final Method _moveMessageToFolder = Reflector._method(_cls, "moveMessageToFolder", Context.class,
                Uri.class, int.class, int.class);

        /**
         * Returns true iff the folder (message type) identifies an
         * outgoing message.
         */
        public static boolean isOutgoingFolder(int messageType) {
            return Reflector._invokeStaticUnchecked(Boolean.class, _isOutgoingFolder, messageType);
        }
        public static final Method _isOutgoingFolder = Reflector._method(_cls, "isOutgoingFolder", int.class);

        /**
         * Contains all text based SMS messages in the SMS app's inbox.
         */
        public static final class Inbox implements BaseColumns, TextBasedSmsColumns {

            public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Sms$Inbox");

            /**
             * The content:// style URL for this table
             */
            public static final Uri CONTENT_URI = Reflector._Uri(_cls, "CONTENT_URI");

            /**
             * The default sort order for this table
             */
            public static final String DEFAULT_SORT_ORDER = Reflector._String(_cls, "DEFAULT_SORT_ORDER");

            /**
             * Add an SMS to the Draft box.
             *
             * @param resolver the content resolver to use
             * @param address the address of the sender
             * @param body the body of the message
             * @param subject the psuedo-subject of the message
             * @param date the timestamp for the message
             * @param read true if the message has been read, false if not
             * @return the URI for the new message
             */
            public static Uri addMessage(ContentResolver resolver,
                    String address, String body, String subject, Long date,
                    boolean read) {
                return Reflector._invokeStaticUnchecked(Uri.class, _addMessage, resolver,
                    address, body, subject, date,
                    read);
            }
            public static final Method _addMessage = Reflector._method(_cls, "addMessage", ContentResolver.class,
                    String.class, String.class, String.class, Long.class,
                    boolean.class);

        }

        /**
         * Contains all sent text based SMS messages in the SMS app's.
         */
        public static final class Sent implements BaseColumns, TextBasedSmsColumns {

            public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Sms$Sent");

            /**
             * The content:// style URL for this table
             */
            public static final Uri CONTENT_URI = Reflector._Uri(_cls, "CONTENT_URI");

            /**
             * The default sort order for this table
             */
            public static final String DEFAULT_SORT_ORDER = Reflector._String(_cls, "DEFAULT_SORT_ORDER");

            /**
             * Add an SMS to the Draft box.
             *
             * @param resolver the content resolver to use
             * @param address the address of the sender
             * @param body the body of the message
             * @param subject the psuedo-subject of the message
             * @param date the timestamp for the message
             * @return the URI for the new message
             */
            public static Uri addMessage(ContentResolver resolver,
                    String address, String body, String subject, Long date) {
                return Reflector._invokeStaticUnchecked(Uri.class, _addMessage, resolver,
                    address, body, subject, date);
            }
            public static final Method _addMessage = Reflector._method(_cls, "addMessage", ContentResolver.class,
                    String.class, String.class, String.class, Long.class);

        }

        /**
         * Contains all sent text based SMS messages in the SMS app's.
         */
        public static final class Draft implements BaseColumns, TextBasedSmsColumns {

            public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Sms$Draft");

            /**
             * The content:// style URL for this table
             */
            public static final Uri CONTENT_URI = Reflector._Uri(_cls, "CONTENT_URI");

            /**
             * The default sort order for this table
             */
            public static final String DEFAULT_SORT_ORDER = Reflector._String(_cls, "DEFAULT_SORT_ORDER");

            /**
             * Add an SMS to the Draft box.
             *
             * @param resolver the content resolver to use
             * @param address the address of the sender
             * @param body the body of the message
             * @param subject the psuedo-subject of the message
             * @param date the timestamp for the message
             * @return the URI for the new message
             */
            public static Uri addMessage(ContentResolver resolver,
                    String address, String body, String subject, Long date) {
                return Reflector._invokeStaticUnchecked(Uri.class, _addMessage, resolver,
                        address, body, subject, date);
            }
            public static final Method _addMessage = Reflector._method(_cls, "addMessage", ContentResolver.class,
                    String.class, String.class, String.class, Long.class);

            /**
             * Save over an existing draft message.
             *
             * @param resolver the content resolver to use
             * @param uri of existing message
             * @param body the new body for the draft message
             * @return true is successful, false otherwise
             */
            public static boolean saveMessage(ContentResolver resolver,
                    Uri uri, String body) {
                return Reflector._invokeStaticUnchecked(Boolean.class, _addMessage, resolver,
                    uri, body);
            }
            public static final Method _saveMessage = Reflector._method(_cls, "saveMessage", ContentResolver.class,
                    Uri.class, String.class);

        }

        /**
         * Contains all pending outgoing text based SMS messages.
         */
        public static final class Outbox implements BaseColumns, TextBasedSmsColumns {

            public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Sms$Outbox");

            /**
             * The content:// style URL for this table
             */
            public static final Uri CONTENT_URI = Reflector._Uri(_cls, "CONTENT_URI");

            /**
             * The default sort order for this table
             */
            public static final String DEFAULT_SORT_ORDER = Reflector._String(_cls, "DEFAULT_SORT_ORDER");

            /**
             * Add an SMS to the Out box.
             *
             * @param resolver the content resolver to use
             * @param address the address of the sender
             * @param body the body of the message
             * @param subject the psuedo-subject of the message
             * @param date the timestamp for the message
             * @param deliveryReport whether a delivery report was requested for the message
             * @return the URI for the new message
             */
            public static Uri addMessage(ContentResolver resolver,
                    String address, String body, String subject, Long date,
                    boolean deliveryReport, long threadId) {
                return Reflector._invokeStaticUnchecked(Uri.class, _addMessage, resolver,
                    address, body, subject, date,
                    deliveryReport, threadId);
            }
            public static final Method _addMessage = Reflector._method(_cls, "addMessage", ContentResolver.class,
                    String.class, String.class, String.class, Long.class,
                    boolean.class, long.class);

        }

        /**
         * Contains all sent text-based SMS messages in the SMS app's.
         */
        public static final class Conversations
                implements BaseColumns, TextBasedSmsColumns {

            public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Sms$Conversations");

            /**
             * The content:// style URL for this table
             */
            public static final Uri CONTENT_URI = Reflector._Uri(_cls, "CONTENT_URI");

            /**
             * The default sort order for this table
             */
            public static final String DEFAULT_SORT_ORDER = Reflector._String(_cls, "DEFAULT_SORT_ORDER");

            /**
             * The first 45 characters of the body of the message
             * <P>Type: TEXT</P>
             */
            public static final String SNIPPET = Reflector._String(_cls, "SNIPPET");

            /**
             * The number of messages in the conversation
             * <P>Type: INTEGER</P>
             */
            public static final String MESSAGE_COUNT = Reflector._String(_cls, "MESSAGE_COUNT");
        }

        /**
         * Contains info about SMS related Intents that are broadcast.
         */
        public static final class Intents {

            public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Sms$Intents");

            /**
             * Set by BroadcastReceiver. Indicates the message was handled
             * successfully.
             */
            public static final int RESULT_SMS_HANDLED = Reflector._int(_cls, "RESULT_SMS_HANDLED", _MISSING);

            /**
             * Set by BroadcastReceiver. Indicates a generic error while
             * processing the message.
             */
            public static final int RESULT_SMS_GENERIC_ERROR = Reflector._int(_cls, "RESULT_SMS_GENERIC_ERROR", _MISSING);

            /**
             * Set by BroadcastReceiver. Indicates insufficient memory to store
             * the message.
             */
            public static final int RESULT_SMS_OUT_OF_MEMORY = Reflector._int(_cls, "RESULT_SMS_OUT_OF_MEMORY", _MISSING);

            /**
             * Set by BroadcastReceiver. Indicates the message, while
             * possibly valid, is of a format or encoding that is not
             * supported.
             */
            public static final int RESULT_SMS_UNSUPPORTED = Reflector._int(_cls, "RESULT_SMS_UNSUPPORTED", _MISSING);

            /**
             * Broadcast Action: A new text based SMS message has been received
             * by the device. The intent will have the following extra
             * values:</p>
             *
             * <ul>
             *   <li><em>pdus</em> - An Object[] od byte[]s containing the PDUs
             *   that make up the message.</li>
             * </ul>
             *
             * <p>The extra values can be extracted using
             * {@link #getMessagesFromIntent(Intent)}.</p>
             *
             * <p>If a BroadcastReceiver encounters an error while processing
             * this intent it should set the result code appropriately.</p>
             */
            public static final String SMS_RECEIVED_ACTION =
                    "android.provider.Telephony.SMS_RECEIVED";

            /**
             * Broadcast Action: A new data based SMS message has been received
             * by the device. The intent will have the following extra
             * values:</p>
             *
             * <ul>
             *   <li><em>pdus</em> - An Object[] of byte[]s containing the PDUs
             *   that make up the message.</li>
             * </ul>
             *
             * <p>The extra values can be extracted using
             * {@link #getMessagesFromIntent(Intent)}.</p>
             *
             * <p>If a BroadcastReceiver encounters an error while processing
             * this intent it should set the result code appropriately.</p>
             */
            public static final String DATA_SMS_RECEIVED_ACTION = Reflector._String(_cls, "DATA_SMS_RECEIVED_ACTION");

            /**
             * Broadcast Action: A new WAP PUSH message has been received by the
             * device. The intent will have the following extra
             * values:</p>
             *
             * <ul>
             *   <li><em>transactionId (Integer)</em> - The WAP transaction ID</li>
             *   <li><em>pduType (Integer)</em> - The WAP PDU type</li>
             *   <li><em>header (byte[])</em> - The header of the message</li>
             *   <li><em>data (byte[])</em> - The data payload of the message</li>
             *   <li><em>contentTypeParameters (HashMap&lt;String,String&gt;)</em>
             *   - Any parameters associated with the content type
             *   (decoded from the WSP Content-Type header)</li>
             * </ul>
             *
             * <p>If a BroadcastReceiver encounters an error while processing
             * this intent it should set the result code appropriately.</p>
             *
             * <p>The contentTypeParameters extra value is map of content parameters keyed by
             * their names.</p>
             *
             * <p>If any unassigned well-known parameters are encountered, the key of the map will
             * be 'unassigned/0x...', where '...' is the hex value of the unassigned parameter.  If
             * a parameter has No-Value the value in the map will be null.</p>
             */
            public static final String WAP_PUSH_RECEIVED_ACTION = Reflector._String(_cls, "WAP_PUSH_RECEIVED_ACTION");

            /**
             * Broadcast Action: A new Cell Broadcast message has been received
             * by the device. The intent will have the following extra
             * values:</p>
             *
             * <ul>
             *   <li><em>pdus</em> - An Object[] of byte[]s containing the PDUs
             *   that make up the message.</li>
             * </ul>
             *
             * <p>The extra values can be extracted using
             * {@link #getMessagesFromIntent(Intent)}.</p>
             *
             * <p>If a BroadcastReceiver encounters an error while processing
             * this intent it should set the result code appropriately.</p>
             */
            public static final String SMS_CB_RECEIVED_ACTION = Reflector._String(_cls, "SMS_CB_RECEIVED_ACTION");

            /**
             * Broadcast Action: A new Emergency Broadcast message has been received
             * by the device. The intent will have the following extra
             * values:</p>
             *
             * <ul>
             *   <li><em>pdus</em> - An Object[] of byte[]s containing the PDUs
             *   that make up the message.</li>
             * </ul>
             *
             * <p>The extra values can be extracted using
             * {@link #getMessagesFromIntent(Intent)}.</p>
             *
             * <p>If a BroadcastReceiver encounters an error while processing
             * this intent it should set the result code appropriately.</p>
             */
            public static final String SMS_EMERGENCY_CB_RECEIVED_ACTION = Reflector._String(_cls, "SMS_EMERGENCY_CB_RECEIVED_ACTION");

            /**
             * Broadcast Action: The SIM storage for SMS messages is full.  If
             * space is not freed, messages targeted for the SIM (class 2) may
             * not be saved.
             */
            public static final String SIM_FULL_ACTION = Reflector._String(_cls, "SIM_FULL_ACTION");

            /**
             * Broadcast Action: An incoming SMS has been rejected by the
             * telephony framework.  This intent is sent in lieu of any
             * of the RECEIVED_ACTION intents.  The intent will have the
             * following extra value:</p>
             *
             * <ul>
             *   <li><em>result</em> - An int result code, eg,
             *   <code>{@link #RESULT_SMS_OUT_OF_MEMORY}</code>,
             *   indicating the error returned to the network.</li>
             * </ul>

             */
            public static final String SMS_REJECTED_ACTION = Reflector._String(_cls, "SMS_REJECTED_ACTION");

            /**
             * Read the PDUs out of an {@link #SMS_RECEIVED_ACTION} or a
             * {@link #DATA_SMS_RECEIVED_ACTION} intent.
             *
             * @param intent the intent to read from
             * @return an array of SmsMessages for the PDUs
             */
            public static SmsMessage[] getMessagesFromIntent(
                    Intent intent) {
                return Reflector._invokeStaticUnchecked(SmsMessage[].class, _getMessagesFromIntent,
                        intent);
            }
            public static final Method _getMessagesFromIntent = Reflector._method(_cls, "getMessagesFromIntent",
                    Intent.class);

        }

    }

    /**
     * Base columns for tables that contain MMSs.
     */
    public interface BaseMmsColumns extends BaseColumns {

        public static final Class<?> _cls = Reflector._class("android.provider.Telephony$BaseMmsColumns");

        public static final int MESSAGE_BOX_ALL    = Reflector._int(_cls, "MESSAGE_BOX_ALL", _MISSING);
        public static final int MESSAGE_BOX_INBOX  = Reflector._int(_cls, "MESSAGE_BOX_INBOX", _MISSING);
        public static final int MESSAGE_BOX_SENT   = Reflector._int(_cls, "MESSAGE_BOX_SENT", _MISSING);
        public static final int MESSAGE_BOX_DRAFTS = Reflector._int(_cls, "MESSAGE_BOX_DRAFTS", _MISSING);
        public static final int MESSAGE_BOX_OUTBOX = Reflector._int(_cls, "MESSAGE_BOX_OUTBOX", _MISSING);

        /**
         * The date the message was received.
         * <P>Type: INTEGER (long)</P>
         */
        public static final String DATE = Reflector._String(_cls, "DATE");

        /**
         * The date the message was sent.
         * <P>Type: INTEGER (long)</P>
         */
        public static final String DATE_SENT = Reflector._String(_cls, "DATE_SENT");

        /**
         * The box which the message belong to, for example, MESSAGE_BOX_INBOX.
         * <P>Type: INTEGER</P>
         */
        public static final String MESSAGE_BOX = Reflector._String(_cls, "MESSAGE_BOX");

        /**
         * Has the message been read.
         * <P>Type: INTEGER (boolean)</P>
         */
        public static final String READ = Reflector._String(_cls, "READ");

        /**
         * Indicates whether this message has been seen by the user. The "seen" flag will be
         * used to figure out whether we need to throw up a statusbar notification or not.
         */
        public static final String SEEN = Reflector._String(_cls, "SEEN");

        /**
         * The Message-ID of the message.
         * <P>Type: TEXT</P>
         */
        public static final String MESSAGE_ID = Reflector._String(_cls, "MESSAGE_ID");

        /**
         * The subject of the message, if present.
         * <P>Type: TEXT</P>
         */
        public static final String SUBJECT = Reflector._String(_cls, "SUBJECT");

        /**
         * The character set of the subject, if present.
         * <P>Type: INTEGER</P>
         */
        public static final String SUBJECT_CHARSET = Reflector._String(_cls, "SUBJECT_CHARSET");

        /**
         * The Content-Type of the message.
         * <P>Type: TEXT</P>
         */
        public static final String CONTENT_TYPE = Reflector._String(_cls, "CONTENT_TYPE");

        /**
         * The Content-Location of the message.
         * <P>Type: TEXT</P>
         */
        public static final String CONTENT_LOCATION = Reflector._String(_cls, "CONTENT_LOCATION");

        /**
         * The address of the sender.
         * <P>Type: TEXT</P>
         */
        public static final String FROM = Reflector._String(_cls, "FROM");

        /**
         * The address of the recipients.
         * <P>Type: TEXT</P>
         */
        public static final String TO = Reflector._String(_cls, "TO");

        /**
         * The address of the cc. recipients.
         * <P>Type: TEXT</P>
         */
        public static final String CC = Reflector._String(_cls, "CC");

        /**
         * The address of the bcc. recipients.
         * <P>Type: TEXT</P>
         */
        public static final String BCC = Reflector._String(_cls, "BCC");

        /**
         * The expiry time of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String EXPIRY = Reflector._String(_cls, "EXPIRY");

        /**
         * The class of the message.
         * <P>Type: TEXT</P>
         */
        public static final String MESSAGE_CLASS = Reflector._String(_cls, "MESSAGE_CLASS");

        /**
         * The type of the message defined by MMS spec.
         * <P>Type: INTEGER</P>
         */
        public static final String MESSAGE_TYPE = Reflector._String(_cls, "MESSAGE_TYPE");

        /**
         * The version of specification that this message conform.
         * <P>Type: INTEGER</P>
         */
        public static final String MMS_VERSION = Reflector._String(_cls, "MMS_VERSION");

        /**
         * The size of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String MESSAGE_SIZE = Reflector._String(_cls, "MESSAGE_SIZE");

        /**
         * The priority of the message.
         * <P>Type: TEXT</P>
         */
        public static final String PRIORITY = Reflector._String(_cls, "PRIORITY");

        /**
         * The read-report of the message.
         * <P>Type: TEXT</P>
         */
        public static final String READ_REPORT = Reflector._String(_cls, "READ_REPORT");

        /**
         * Whether the report is allowed.
         * <P>Type: TEXT</P>
         */
        public static final String REPORT_ALLOWED = Reflector._String(_cls, "REPORT_ALLOWED");

        /**
         * The response-status of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String RESPONSE_STATUS = Reflector._String(_cls, "RESPONSE_STATUS");

        /**
         * The status of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String STATUS = Reflector._String(_cls, "STATUS");

        /**
         * The transaction-id of the message.
         * <P>Type: TEXT</P>
         */
        public static final String TRANSACTION_ID = Reflector._String(_cls, "TRANSACTION_ID");

        /**
         * The retrieve-status of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String RETRIEVE_STATUS = Reflector._String(_cls, "RETRIEVE_STATUS");

        /**
         * The retrieve-text of the message.
         * <P>Type: TEXT</P>
         */
        public static final String RETRIEVE_TEXT = Reflector._String(_cls, "RETRIEVE_TEXT");

        /**
         * The character set of the retrieve-text.
         * <P>Type: TEXT</P>
         */
        public static final String RETRIEVE_TEXT_CHARSET = Reflector._String(_cls, "RETRIEVE_TEXT_CHARSET");

        /**
         * The read-status of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String READ_STATUS = Reflector._String(_cls, "READ_STATUS");

        /**
         * The content-class of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String CONTENT_CLASS = Reflector._String(_cls, "CONTENT_CLASS");

        /**
         * The delivery-report of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String DELIVERY_REPORT = Reflector._String(_cls, "DELIVERY_REPORT");

        /**
         * The delivery-time-token of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String DELIVERY_TIME_TOKEN = Reflector._String(_cls, "DELIVERY_TIME_TOKEN");

        /**
         * The delivery-time of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String DELIVERY_TIME = Reflector._String(_cls, "DELIVERY_TIME");

        /**
         * The response-text of the message.
         * <P>Type: TEXT</P>
         */
        public static final String RESPONSE_TEXT = Reflector._String(_cls, "RESPONSE_TEXT");

        /**
         * The sender-visibility of the message.
         * <P>Type: TEXT</P>
         */
        public static final String SENDER_VISIBILITY = Reflector._String(_cls, "SENDER_VISIBILITY");

        /**
         * The reply-charging of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String REPLY_CHARGING = Reflector._String(_cls, "REPLY_CHARGING");

        /**
         * The reply-charging-deadline-token of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String REPLY_CHARGING_DEADLINE_TOKEN = Reflector._String(_cls, "REPLY_CHARGING_DEADLINE_TOKEN");

        /**
         * The reply-charging-deadline of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String REPLY_CHARGING_DEADLINE = Reflector._String(_cls, "REPLY_CHARGING_DEADLINE");

        /**
         * The reply-charging-id of the message.
         * <P>Type: TEXT</P>
         */
        public static final String REPLY_CHARGING_ID = Reflector._String(_cls, "REPLY_CHARGING_ID");

        /**
         * The reply-charging-size of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String REPLY_CHARGING_SIZE = Reflector._String(_cls, "REPLY_CHARGING_SIZE");

        /**
         * The previously-sent-by of the message.
         * <P>Type: TEXT</P>
         */
        public static final String PREVIOUSLY_SENT_BY = Reflector._String(_cls, "PREVIOUSLY_SENT_BY");

        /**
         * The previously-sent-date of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String PREVIOUSLY_SENT_DATE = Reflector._String(_cls, "PREVIOUSLY_SENT_DATE");

        /**
         * The store of the message.
         * <P>Type: TEXT</P>
         */
        public static final String STORE = Reflector._String(_cls, "STORE");

        /**
         * The mm-state of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String MM_STATE = Reflector._String(_cls, "MM_STATE");

        /**
         * The mm-flags-token of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String MM_FLAGS_TOKEN = Reflector._String(_cls, "MM_FLAGS_TOKEN");

        /**
         * The mm-flags of the message.
         * <P>Type: TEXT</P>
         */
        public static final String MM_FLAGS = Reflector._String(_cls, "MM_FLAGS");

        /**
         * The store-status of the message.
         * <P>Type: TEXT</P>
         */
        public static final String STORE_STATUS = Reflector._String(_cls, "STORE_STATUS");

        /**
         * The store-status-text of the message.
         * <P>Type: TEXT</P>
         */
        public static final String STORE_STATUS_TEXT = Reflector._String(_cls, "STORE_STATUS_TEXT");

        /**
         * The stored of the message.
         * <P>Type: TEXT</P>
         */
        public static final String STORED = Reflector._String(_cls, "STORED");

        /**
         * The totals of the message.
         * <P>Type: TEXT</P>
         */
        public static final String TOTALS = Reflector._String(_cls, "TOTALS");

        /**
         * The mbox-totals of the message.
         * <P>Type: TEXT</P>
         */
        public static final String MBOX_TOTALS = Reflector._String(_cls, "MBOX_TOTALS");

        /**
         * The mbox-totals-token of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String MBOX_TOTALS_TOKEN = Reflector._String(_cls, "MBOX_TOTALS_TOKEN");

        /**
         * The quotas of the message.
         * <P>Type: TEXT</P>
         */
        public static final String QUOTAS = Reflector._String(_cls, "QUOTAS");

        /**
         * The mbox-quotas of the message.
         * <P>Type: TEXT</P>
         */
        public static final String MBOX_QUOTAS = Reflector._String(_cls, "MBOX_QUOTAS");

        /**
         * The mbox-quotas-token of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String MBOX_QUOTAS_TOKEN = Reflector._String(_cls, "MBOX_QUOTAS_TOKEN");

        /**
         * The message-count of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String MESSAGE_COUNT = Reflector._String(_cls, "MESSAGE_COUNT");

        /**
         * The start of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String START = Reflector._String(_cls, "START");

        /**
         * The distribution-indicator of the message.
         * <P>Type: TEXT</P>
         */
        public static final String DISTRIBUTION_INDICATOR = Reflector._String(_cls, "DISTRIBUTION_INDICATOR");

        /**
         * The element-descriptor of the message.
         * <P>Type: TEXT</P>
         */
        public static final String ELEMENT_DESCRIPTOR = Reflector._String(_cls, "ELEMENT_DESCRIPTOR");

        /**
         * The limit of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String LIMIT = Reflector._String(_cls, "LIMIT");

        /**
         * The recommended-retrieval-mode of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String RECOMMENDED_RETRIEVAL_MODE = Reflector._String(_cls, "RECOMMENDED_RETRIEVAL_MODE");

        /**
         * The recommended-retrieval-mode-text of the message.
         * <P>Type: TEXT</P>
         */
        public static final String RECOMMENDED_RETRIEVAL_MODE_TEXT = Reflector._String(_cls, "RECOMMENDED_RETRIEVAL_MODE_TEXT");

        /**
         * The status-text of the message.
         * <P>Type: TEXT</P>
         */
        public static final String STATUS_TEXT = Reflector._String(_cls, "STATUS_TEXT");

        /**
         * The applic-id of the message.
         * <P>Type: TEXT</P>
         */
        public static final String APPLIC_ID = Reflector._String(_cls, "APPLIC_ID");

        /**
         * The reply-applic-id of the message.
         * <P>Type: TEXT</P>
         */
        public static final String REPLY_APPLIC_ID = Reflector._String(_cls, "REPLY_APPLIC_ID");

        /**
         * The aux-applic-id of the message.
         * <P>Type: TEXT</P>
         */
        public static final String AUX_APPLIC_ID = Reflector._String(_cls, "AUX_APPLIC_ID");

        /**
         * The drm-content of the message.
         * <P>Type: TEXT</P>
         */
        public static final String DRM_CONTENT = Reflector._String(_cls, "DRM_CONTENT");

        /**
         * The adaptation-allowed of the message.
         * <P>Type: TEXT</P>
         */
        public static final String ADAPTATION_ALLOWED = Reflector._String(_cls, "ADAPTATION_ALLOWED");

        /**
         * The replace-id of the message.
         * <P>Type: TEXT</P>
         */
        public static final String REPLACE_ID = Reflector._String(_cls, "REPLACE_ID");

        /**
         * The cancel-id of the message.
         * <P>Type: TEXT</P>
         */
        public static final String CANCEL_ID = Reflector._String(_cls, "CANCEL_ID");

        /**
         * The cancel-status of the message.
         * <P>Type: INTEGER</P>
         */
        public static final String CANCEL_STATUS = Reflector._String(_cls, "CANCEL_STATUS");

        /**
         * The thread ID of the message
         * <P>Type: INTEGER</P>
         */
        public static final String THREAD_ID = Reflector._String(_cls, "THREAD_ID");

        /**
         * Has the message been locked?
         * <P>Type: INTEGER (boolean)</P>
         */
        public static final String LOCKED = Reflector._String(_cls, "LOCKED");

        /**
         * Meta data used externally.
         * <P>Type: TEXT</P>
         */
        public static final String META_DATA = Reflector._String(_cls, "META_DATA");

    }

    /**
     * Columns for the "canonical_addresses" table used by MMS and
     * SMS."
     */
    public interface CanonicalAddressesColumns extends BaseColumns {

        public static final Class<?> _cls = Reflector._class("android.provider.Telephony$CanonicalAddressesColumns");

        /**
         * An address used in MMS or SMS.  Email addresses are
         * converted to lower case and are compared by string
         * equality.  Other addresses are compared using
         * PHONE_NUMBERS_EQUAL.
         * <P>Type: TEXT</P>
         */
        public static final String ADDRESS = Reflector._String(_cls, "ADDRESS");

    }

    /**
     * Columns for the "threads" table used by MMS and SMS.
     */
    public interface ThreadsColumns extends BaseColumns {

        public static final Class<?> _cls = Reflector._class("android.provider.Telephony$ThreadsColumns");

        /**
         * The date at which the thread was created.
         *
         * <P>Type: INTEGER (long)</P>
         */
        public static final String DATE = Reflector._String(_cls, "DATE");

        /**
         * A string encoding of the recipient IDs of the recipients of
         * the message, in numerical order and separated by spaces.
         * <P>Type: TEXT</P>
         */
        public static final String RECIPIENT_IDS = Reflector._String(_cls, "RECIPIENT_IDS");

        /**
         * The message count of the thread.
         * <P>Type: INTEGER</P>
         */
        public static final String MESSAGE_COUNT = Reflector._String(_cls, "MESSAGE_COUNT");
        /**
         * Indicates whether all messages of the thread have been read.
         * <P>Type: INTEGER</P>
         */
        public static final String READ = Reflector._String(_cls, "READ");

        /**
         * The snippet of the latest message in the thread.
         * <P>Type: TEXT</P>
         */
        public static final String SNIPPET = Reflector._String(_cls, "SNIPPET");
        /**
         * The charset of the snippet.
         * <P>Type: INTEGER</P>
         */
        public static final String SNIPPET_CHARSET = Reflector._String(_cls, "SNIPPET_CHARSET");
        /**
         * Type of the thread, either Threads.COMMON_THREAD or
         * Threads.BROADCAST_THREAD.
         * <P>Type: INTEGER</P>
         */
        public static final String TYPE = Reflector._String(_cls, "TYPE");
        /**
         * Indicates whether there is a transmission error in the thread.
         * <P>Type: INTEGER</P>
         */
        public static final String ERROR = Reflector._String(_cls, "ERROR");
        /**
         * Indicates whether this thread contains any attachments.
         * <P>Type: INTEGER</P>
         */
        public static final String HAS_ATTACHMENT = Reflector._String(_cls, "HAS_ATTACHMENT");

    }

    /**
     * Helper functions for the "threads" table used by MMS and SMS.
     */
    public static final class Threads implements ThreadsColumns {

        public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Threads");

        public static final Uri CONTENT_URI = Reflector._Uri(_cls, "CONTENT_URI");
        public static final Uri OBSOLETE_THREADS_URI = Reflector._Uri(_cls, "OBSOLETE_THREADS_URI");

        public static final int COMMON_THREAD    = Reflector._int(_cls, "COMMON_THREAD", _MISSING);
        public static final int BROADCAST_THREAD = Reflector._int(_cls, "BROADCAST_THREAD", _MISSING);

        // No one should construct an instance of this class.
        private Threads() {
        }

        /**
         * This is a single-recipient version of
         * getOrCreateThreadId.  It's convenient for use with SMS
         * messages.
         */
        public static long getOrCreateThreadId(Context context, String recipient) {
            return Reflector._invokeStaticUnchecked(Long.class, _getOrCreateThreadId_String, context, recipient);
        }
        public static final Method _getOrCreateThreadId_String = Reflector._method(_cls, "getOrCreateThreadId", Context.class, String.class);

        /**
         * Given the recipients list and subject of an unsaved message,
         * return its thread ID.  If the message starts a new thread,
         * allocate a new thread ID.  Otherwise, use the appropriate
         * existing thread ID.
         *
         * Find the thread ID of the same set of recipients (in
         * any order, without any additions). If one
         * is found, return it.  Otherwise, return a unique thread ID.
         */
        public static long getOrCreateThreadId(
                Context context, Set<String> recipients) {
            return Reflector._invokeStaticUnchecked(Long.class, _getOrCreateThreadId_Set, context, recipients);
        }
        public static final Method _getOrCreateThreadId_Set = Reflector._method(_cls, "getOrCreateThreadId", Context.class, Set.class);
    }

    /**
     * Contains all MMS messages.
     */
    public static final class Mms implements BaseMmsColumns {

        public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Mms");

        /**
         * The content:// style URL for this table
         */
        public static final Uri CONTENT_URI = Reflector._Uri(_cls, "CONTENT_URI");

        public static final Uri REPORT_REQUEST_URI = Reflector._Uri(_cls, "REPORT_REQUEST_URI");

        public static final Uri REPORT_STATUS_URI = Reflector._Uri(_cls, "REPORT_STATUS_URI");

        /**
         * The default sort order for this table
         */
        public static final String DEFAULT_SORT_ORDER = Reflector._String(_cls, "DEFAULT_SORT_ORDER");

        /**
         * mailbox         =       name-addr
         * name-addr       =       [display-name] angle-addr
         * angle-addr      =       [CFWS] "<" addr-spec ">" [CFWS]
         */
        public static final Pattern NAME_ADDR_EMAIL_PATTERN = Reflector._fieldValueAsType(Pattern.class, _cls, "NAME_ADDR_EMAIL_PATTERN");

        /**
         * quoted-string   =       [CFWS]
         *                         DQUOTE *([FWS] qcontent) [FWS] DQUOTE
         *                         [CFWS]
         */
        public static final Pattern QUOTED_STRING_PATTERN = Reflector._fieldValueAsType(Pattern.class, _cls, "QUOTED_STRING_PATTERN");

        public static final Cursor query(
                ContentResolver cr, String[] projection) {
            return Reflector._invokeStaticUnchecked(Cursor.class, _query_2,
                    cr, projection);
        }
        public static final Method _query_2 = Reflector._method(_cls, "query", ContentResolver.class, String[].class);

        public static final Cursor query(
                ContentResolver cr, String[] projection,
                String where, String orderBy) {
            return Reflector._invokeStaticUnchecked(Cursor.class, _query_4,
                    cr, projection);
        }
        public static final Method _query_4 = Reflector._method(_cls, "query", ContentResolver.class, String[].class,
                String.class, String.class);

        public static final String getMessageBoxName(int msgBox) {
            return Reflector._invokeStaticUnchecked(String.class, _getMessageBoxName, msgBox);
        }
        public static final Method _getMessageBoxName = Reflector._method(_cls, "getMessageBoxName", int.class);

        public static String extractAddrSpec(String address) {
            return Reflector._invokeStaticUnchecked(String.class, _extractAddrSpec, address);
        }
        public static final Method _extractAddrSpec = Reflector._method(_cls, "extractAddrSpec", String.class);

        /**
         * Returns true if the address is an email address
         *
         * @param address the input address to be tested
         * @return true if address is an email address
         */
        public static boolean isEmailAddress(String address) {
            return Reflector._invokeStaticUnchecked(Boolean.class, _isEmailAddress, address);
        }
        public static final Method _isEmailAddress = Reflector._method(_cls, "isEmailAddress", String.class);

        /**
         * Returns true if the number is a Phone number
         *
         * @param number the input number to be tested
         * @return true if number is a Phone number
         */
        public static boolean isPhoneNumber(String number) {
            return Reflector._invokeStaticUnchecked(Boolean.class, _isPhoneNumber, number);
        }
        public static final Method _isPhoneNumber = Reflector._method(_cls, "isPhoneNumber", String.class);

        /**
         * Contains all MMS messages in the MMS app's inbox.
         */
        public static final class Inbox implements BaseMmsColumns {

            public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Mms$Inbox");

            /**
             * The content:// style URL for this table
             */
            public static final Uri CONTENT_URI = Reflector._Uri(_cls, "CONTENT_URI");

            /**
             * The default sort order for this table
             */
            public static final String DEFAULT_SORT_ORDER = Reflector._String(_cls, "DEFAULT_SORT_ORDER");

        }

        /**
         * Contains all MMS messages in the MMS app's sent box.
         */
        public static final class Sent implements BaseMmsColumns {

            public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Mms$Sent");

            /**
             * The content:// style URL for this table
             */
            public static final Uri CONTENT_URI = Reflector._Uri(_cls, "CONTENT_URI");

            /**
             * The default sort order for this table
             */
            public static final String DEFAULT_SORT_ORDER = Reflector._String(_cls, "DEFAULT_SORT_ORDER");

        }

        /**
         * Contains all MMS messages in the MMS app's drafts box.
         */
        public static final class Draft implements BaseMmsColumns {

            public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Mms$Draft");

            /**
             * The content:// style URL for this table
             */
            public static final Uri CONTENT_URI = Reflector._Uri(_cls, "CONTENT_URI");

            /**
             * The default sort order for this table
             */
            public static final String DEFAULT_SORT_ORDER = Reflector._String(_cls, "DEFAULT_SORT_ORDER");

        }

        /**
         * Contains all MMS messages in the MMS app's outbox.
         */
        public static final class Outbox implements BaseMmsColumns {

            public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Mms$Outbox");

            /**
             * The content:// style URL for this table
             */
            public static final Uri CONTENT_URI = Reflector._Uri(_cls, "CONTENT_URI");

            /**
             * The default sort order for this table
             */
            public static final String DEFAULT_SORT_ORDER = Reflector._String(_cls, "DEFAULT_SORT_ORDER");

        }

        public static final class Addr implements BaseColumns {

            public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Mms$Addr");

            /**
             * The ID of MM which this address entry belongs to.
             */
            public static final String MSG_ID = Reflector._String(_cls, "MSG_ID");

            /**
             * The ID of contact entry in Phone Book.
             */
            public static final String CONTACT_ID = Reflector._String(_cls, "CONTACT_ID");

            /**
             * The address text.
             */
            public static final String ADDRESS = Reflector._String(_cls, "ADDRESS");

            /**
             * Type of address, must be one of PduHeaders.BCC,
             * PduHeaders.CC, PduHeaders.FROM, PduHeaders.TO.
             */
            public static final String TYPE = Reflector._String(_cls, "TYPE");

            /**
             * Character set of this entry.
             */
            public static final String CHARSET = Reflector._String(_cls, "CHARSET");

        }

        public static final class Part implements BaseColumns {

            public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Mms$Part");

            /**
             * The identifier of the message which this part belongs to.
             * <P>Type: INTEGER</P>
             */
            public static final String MSG_ID = Reflector._String(_cls, "MSG_ID");

            /**
             * The order of the part.
             * <P>Type: INTEGER</P>
             */
            public static final String SEQ = Reflector._String(_cls, "SEQ");

            /**
             * The content type of the part.
             * <P>Type: TEXT</P>
             */
            public static final String CONTENT_TYPE = Reflector._String(_cls, "CONTENT_TYPE");

            /**
             * The name of the part.
             * <P>Type: TEXT</P>
             */
            public static final String NAME = Reflector._String(_cls, "NAME");

            /**
             * The charset of the part.
             * <P>Type: TEXT</P>
             */
            public static final String CHARSET = Reflector._String(_cls, "CHARSET");

            /**
             * The file name of the part.
             * <P>Type: TEXT</P>
             */
            public static final String FILENAME = Reflector._String(_cls, "FILENAME");

            /**
             * The content disposition of the part.
             * <P>Type: TEXT</P>
             */
            public static final String CONTENT_DISPOSITION = Reflector._String(_cls, "CONTENT_DISPOSITION");

            /**
             * The content ID of the part.
             * <P>Type: INTEGER</P>
             */
            public static final String CONTENT_ID = Reflector._String(_cls, "CONTENT_ID");

            /**
             * The content location of the part.
             * <P>Type: INTEGER</P>
             */
            public static final String CONTENT_LOCATION = Reflector._String(_cls, "CONTENT_LOCATION");

            /**
             * The start of content-type of the message.
             * <P>Type: INTEGER</P>
             */
            public static final String CT_START = Reflector._String(_cls, "CT_START");

            /**
             * The type of content-type of the message.
             * <P>Type: TEXT</P>
             */
            public static final String CT_TYPE = Reflector._String(_cls, "CT_TYPE");

            /**
             * The location(on filesystem) of the binary data of the part.
             * <P>Type: INTEGER</P>
             */
            public static final String _DATA = Reflector._String(_cls, "_DATA");

            public static final String TEXT = Reflector._String(_cls, "TEXT");

        }

        public static final class Rate {

            public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Mms$Rate");

            public static final Uri CONTENT_URI = Reflector._Uri(_cls, "CONTENT_URI");

            /**
             * When a message was successfully sent.
             * <P>Type: INTEGER</P>
             */
            public static final String SENT_TIME = Reflector._String(_cls, "SENT_TIME");

        }

        public static final class Intents {

            public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Mms$Intents");

            private Intents() {
                // Non-instantiatable.
            }

            /**
             * The extra field to store the contents of the Intent,
             * which should be an array of Uri.
             */
            public static final String EXTRA_CONTENTS = Reflector._String(_cls, "EXTRA_CONTENTS");
            /**
             * The extra field to store the type of the contents,
             * which should be an array of String.
             */
            public static final String EXTRA_TYPES    = Reflector._String(_cls, "EXTRA_TYPES");
            /**
             * The extra field to store the 'Cc' addresses.
             */
            public static final String EXTRA_CC       = Reflector._String(_cls, "EXTRA_CC");
            /**
             * The extra field to store the 'Bcc' addresses;
             */
            public static final String EXTRA_BCC      = Reflector._String(_cls, "EXTRA_BCC");
            /**
             * The extra field to store the 'Subject'.
             */
            public static final String EXTRA_SUBJECT  = Reflector._String(_cls, "EXTRA_SUBJECT");
            /**
             * Indicates that the contents of specified URIs were changed.
             * The application which is showing or caching these contents
             * should be updated.
             */
            public static final String CONTENT_CHANGED_ACTION = Reflector._String(_cls, "CONTENT_CHANGED_ACTION");
            /**
             * An extra field which stores the URI of deleted contents.
             */
            public static final String DELETED_CONTENTS = Reflector._String(_cls, "DELETED_CONTENTS");

        }

    }

    /**
     * Contains all MMS and SMS messages.
     */
    public static final class MmsSms implements BaseColumns {

        public static final Class<?> _cls = Reflector._class("android.provider.Telephony$MmsSms");

        /**
         * The column to distinguish SMS &amp; MMS messages in query results.
         */
        public static final String TYPE_DISCRIMINATOR_COLUMN = Reflector._String(_cls, "TYPE_DISCRIMINATOR_COLUMN");

        public static final Uri CONTENT_URI = Reflector._Uri(_cls, "CONTENT_URI");

        public static final Uri CONTENT_CONVERSATIONS_URI = Reflector._Uri(_cls, "CONTENT_CONVERSATIONS_URI");

        public static final Uri CONTENT_FILTER_BYPHONE_URI = Reflector._Uri(_cls, "CONTENT_FILTER_BYPHONE_URI");

        public static final Uri CONTENT_UNDELIVERED_URI = Reflector._Uri(_cls, "CONTENT_UNDELIVERED_URI");

        public static final Uri CONTENT_DRAFT_URI = Reflector._Uri(_cls, "CONTENT_DRAFT_URI");

        public static final Uri CONTENT_LOCKED_URI = Reflector._Uri(_cls, "CONTENT_LOCKED_URI");

        /***
         * Pass in a query parameter called "pattern" which is the text
         * to search for.
         * The sort order is fixed to be thread_id ASC,date DESC.
         */
        public static final Uri SEARCH_URI = Reflector._Uri(_cls, "SEARCH_URI");

        // Constants for message protocol types.
        public static final int SMS_PROTO = Reflector._int(_cls, "SMS_PROTO", _MISSING);
        public static final int MMS_PROTO = Reflector._int(_cls, "MMS_PROTO", _MISSING);

        // Constants for error types of pending messages.
        public static final int NO_ERROR                      = Reflector._int(_cls, "NO_ERROR", _MISSING);
        public static final int ERR_TYPE_GENERIC              = Reflector._int(_cls, "ERR_TYPE_GENERIC", _MISSING);
        public static final int ERR_TYPE_SMS_PROTO_TRANSIENT  = Reflector._int(_cls, "ERR_TYPE_SMS_PROTO_TRANSIENT", _MISSING);
        public static final int ERR_TYPE_MMS_PROTO_TRANSIENT  = Reflector._int(_cls, "ERR_TYPE_MMS_PROTO_TRANSIENT", _MISSING);
        public static final int ERR_TYPE_TRANSPORT_FAILURE    = Reflector._int(_cls, "ERR_TYPE_TRANSPORT_FAILURE", _MISSING);
        public static final int ERR_TYPE_GENERIC_PERMANENT    = Reflector._int(_cls, "ERR_TYPE_GENERIC_PERMANENT", _MISSING);
        public static final int ERR_TYPE_SMS_PROTO_PERMANENT  = Reflector._int(_cls, "ERR_TYPE_SMS_PROTO_PERMANENT", _MISSING);
        public static final int ERR_TYPE_MMS_PROTO_PERMANENT  = Reflector._int(_cls, "ERR_TYPE_MMS_PROTO_PERMANENT", _MISSING);

        public static final class PendingMessages implements BaseColumns {

            public static final Class<?> _cls = Reflector._class("android.provider.Telephony$MmsSms$PendingMessages");

            public static final Uri CONTENT_URI = Reflector._Uri(_cls, "CONTENT_URI");
            /**
             * The type of transport protocol(MMS or SMS).
             * <P>Type: INTEGER</P>
             */
            public static final String PROTO_TYPE = Reflector._String(_cls, "PROTO_TYPE");
            /**
             * The ID of the message to be sent or downloaded.
             * <P>Type: INTEGER</P>
             */
            public static final String MSG_ID = Reflector._String(_cls, "MSG_ID");
            /**
             * The type of the message to be sent or downloaded.
             * This field is only valid for MM. For SM, its value is always
             * set to 0.
             */
            public static final String MSG_TYPE = Reflector._String(_cls, "MSG_TYPE");
            /**
             * The type of the error code.
             * <P>Type: INTEGER</P>
             */
            public static final String ERROR_TYPE = Reflector._String(_cls, "ERROR_TYPE");
            /**
             * The error code of sending/retrieving process.
             * <P>Type:  INTEGER</P>
             */
            public static final String ERROR_CODE = Reflector._String(_cls, "ERROR_CODE");
            /**
             * How many times we tried to send or download the message.
             * <P>Type:  INTEGER</P>
             */
            public static final String RETRY_INDEX = Reflector._String(_cls, "RETRY_INDEX");
            /**
             * The time to do next retry.
             */
            public static final String DUE_TIME = Reflector._String(_cls, "DUE_TIME");
            /**
             * The time we last tried to send or download the message.
             */
            public static final String LAST_TRY = Reflector._String(_cls, "LAST_TRY");

        }

        public static final class WordsTable {

            public static final Class<?> _cls = Reflector._class("android.provider.Telephony$MmsSms$WordsTable");

            public static final String ID = Reflector._String(_cls, "ID");
            public static final String SOURCE_ROW_ID = Reflector._String(_cls, "SOURCE_ROW_ID");
            public static final String TABLE_ID = Reflector._String(_cls, "TABLE_ID");
            public static final String INDEXED_TEXT = Reflector._String(_cls, "INDEXED_TEXT");

        }

    }

    public static final class Carriers implements BaseColumns {

        public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Carriers");

        /**
         * The content:// style URL for this table
         */
        public static final Uri CONTENT_URI = Reflector._Uri(_cls, "CONTENT_URI");

        /**
         * The default sort order for this table
         */
        public static final String DEFAULT_SORT_ORDER = Reflector._String(_cls, "DEFAULT_SORT_ORDER");

        public static final String NAME = Reflector._String(_cls, "NAME");

        public static final String APN = Reflector._String(_cls, "APN");

        public static final String PROXY = Reflector._String(_cls, "PROXY");

        public static final String PORT = Reflector._String(_cls, "PORT");

        public static final String MMSPROXY = Reflector._String(_cls, "MMSPROXY");

        public static final String MMSPORT = Reflector._String(_cls, "MMSPORT");

        public static final String SERVER = Reflector._String(_cls, "SERVER");

        public static final String USER = Reflector._String(_cls, "USER");

        public static final String PASSWORD = Reflector._String(_cls, "PASSWORD");

        public static final String MMSC = Reflector._String(_cls, "MMSC");

        public static final String MCC = Reflector._String(_cls, "MCC");

        public static final String MNC = Reflector._String(_cls, "MNC");

        public static final String NUMERIC = Reflector._String(_cls, "NUMERIC");

        public static final String AUTH_TYPE = Reflector._String(_cls, "AUTH_TYPE");

        public static final String TYPE = Reflector._String(_cls, "TYPE");

        public static final String INACTIVE_TIMER = Reflector._String(_cls, "INACTIVE_TIMER");

        // Only if enabled try Data Connection.
        public static final String ENABLED = Reflector._String(_cls, "ENABLED");

        // Rules apply based on class.
        public static final String CLASS = Reflector._String(_cls, "CLASS");

        /**
         * The protocol to be used to connect to this APN.
         *
         * One of the PDP_type values in TS 27.007 section 10.1.1.
         * For example, "IP", "IPV6", "IPV4V6", or "PPP".
         */
        public static final String PROTOCOL = Reflector._String(_cls, "PROTOCOL");

        /**
          * The protocol to be used to connect to this APN when roaming.
          *
          * The syntax is the same as protocol.
          */
        public static final String ROAMING_PROTOCOL = Reflector._String(_cls, "ROAMING_PROTOCOL");

        public static final String CURRENT = Reflector._String(_cls, "CURRENT");

        /**
          * Current status of APN
          * true : enabled APN, false : disabled APN.
          */
        public static final String CARRIER_ENABLED = Reflector._String(_cls, "CARRIER_ENABLED");

        /**
          * Radio Access Technology info
          * To check what values can hold, refer to ServiceState.java.
          * This should be spread to other technologies,
          * but currently only used for LTE(14) and EHRPD(13).
          */
        public static final String BEARER = Reflector._String(_cls, "BEARER");

    }

    public static final class Intents {

        public static final Class<?> _cls = Reflector._class("android.provider.Telephony$Intents");

        private Intents() {
            // Not instantiable
        }

        /**
         * Broadcast Action: A "secret code" has been entered in the dialer. Secret codes are
         * of the form *#*#<code>#*#*. The intent will have the data URI:</p>
         *
         * <p><code>android_secret_code://&lt;code&gt;</code></p>
         */
        public static final String SECRET_CODE_ACTION = Reflector._String(_cls, "SECRET_CODE_ACTION");

        /**
         * Broadcast Action: The Service Provider string(s) have been updated.  Activities or
         * services that use these strings should update their display.
         * The intent will have the following extra values:</p>
         * <ul>
         *   <li><em>showPlmn</em> - Boolean that indicates whether the PLMN should be shown.</li>
         *   <li><em>plmn</em> - The operator name of the registered network, as a string.</li>
         *   <li><em>showSpn</em> - Boolean that indicates whether the SPN should be shown.</li>
         *   <li><em>spn</em> - The service provider name, as a string.</li>
         * </ul>
         * Note that <em>showPlmn</em> may indicate that <em>plmn</em> should be displayed, even
         * though the value for <em>plmn</em> is null.  This can happen, for example, if the phone
         * has not registered to a network yet.  In this case the receiver may substitute an
         * appropriate placeholder string (eg, "No service").
         *
         * It is recommended to display <em>plmn</em> before / above <em>spn</em> if
         * both are displayed.
         *
         * <p>Note this is a protected intent that can only be sent
         * by the system.
         */
        public static final String SPN_STRINGS_UPDATED_ACTION = Reflector._String(_cls, "SPN_STRINGS_UPDATED_ACTION");

        public static final String EXTRA_SHOW_PLMN  = Reflector._String(_cls, "EXTRA_SHOW_PLMN");
        public static final String EXTRA_PLMN       = Reflector._String(_cls, "EXTRA_PLMN");
        public static final String EXTRA_SHOW_SPN   = Reflector._String(_cls, "EXTRA_SHOW_SPN");
        public static final String EXTRA_SPN        = Reflector._String(_cls, "EXTRA_SPN");

    }

}
