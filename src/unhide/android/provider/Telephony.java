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

}
