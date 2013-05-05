==============================================
Android Unhidden: Access Android's hidden APIs
==============================================

This is a library of wrappers that use reflection to provide relatively safe
and convenient access to the Android framework's non-public, "hidden" APIs.

The wrappers allow your application to compile without the presence of the
hidden framework code, and without hardcoding the values of fields and
constants used by the APIs. At load/run time, the wrappers use reflection to
access the device's implementation.

All the usual warnings about using unsupported APIs still apply: see for
example the Android Developers Blog post `Be Careful With Content Providers`_.

.. _`Be Careful With Content Providers`:
    http://android-developers.blogspot.com/2010/05/be-careful-with-content-providers.html


Usage
=====

Generally, using the wrappers is as simple as adding ``unhide.`` in front of
the import of the library you want to use.

For example, instead of::

    import android.provider.Telephony;

use::

    import unhide.android.provider.Telephony;

There are some caveats to be aware of:

* The reflection process delays the initialization of ``static final`` constant
  fields to class load time, rather than compile time: this means that you
  cannot use these constants in ``switch`` blocks. (Using them in ``if`` blocks
  or elsewhere is fine, though.)


Supported APIs
==============

Currently, the following APIs are supported:

* ``android.provider.Telephony``


Running the tests
=================

Make sure the Android SDK is configured and available, either by setting
``$ANDROID_HOME``, or running `android update project`_.

Start the target emulator or device, then run::

    ant -f tests/build.xml debug install test

.. _`android update project`: http://developer.android.com/tools/projects/projects-cmdline.html#UpdatingAProject
