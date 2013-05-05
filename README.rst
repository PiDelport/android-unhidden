============================================================
Android Unhidden: Convenient access to Android's hidden APIs
============================================================

The goal of this library is to provide safe and convenient access to
non-public, "hidden", but useful Android framework APIs, using reflection.


Usage
=====

Using the wrapped libraries is as simple as adding a ``unhide.`` prefix to the
import you want to use.

For example, instead of::

    import android.provider.Telephony;

use::

    import unhide.android.provider.Telephony;


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
