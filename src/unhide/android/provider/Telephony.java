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
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

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

    }

}
