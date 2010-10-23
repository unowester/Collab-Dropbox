Running
=======

To test this app do...

    $ ant run

JNotify
=======

How to compile libjnotify.so on linux from source.

    $ gcc -I $JAVA_HOME/include/linux -I $JAVA_HOME/include/ net_contentobjects_jnotify_linux_JNotify_linux.c -shared -fPIC -o libjnotify.so

