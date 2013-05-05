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

}
