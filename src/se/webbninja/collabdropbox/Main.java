package se.webbninja.collabdropbox;

import net.contentobjects.jnotify.JNotify;

public class Main {
    public static void main(String[] args) {
        runJNotify(getMessageImpl());
    }

    public static Tray startTray() {
        Tray tray = new Tray();
        tray.initTray();
        return tray;
    }

    public static MessageImplementation getMessageImpl() {

        MessageImplementation messageImpl;

        String os = System.getProperty("os.name");

        if (os.equals("Mac OS X")) {
            messageImpl = new GrowlNotification();
        } else {
            messageImpl = new SwingNotification();
        }

        return messageImpl;
    }

    public static void runFileTest(){
        FileManager fm = new FileManager();

        fm.Exists( "test.txt" );
        fm.CreateActiveFileFor( "test.txt" );
        fm.Exists( "test.txt" );
        fm.DeleteActiveFileFor( "test.txt" );
    }

    public static void runJNotify(MessageImplementation messageImpl) {

        String myHomePath = System.getProperty("user.home");
        String baseP = myHomePath + "/Dropbox/Collab/";

        // dropbox path.. or wherever :/
        String path = baseP;

        //int mask = JNotify.FILE_CREATED | JNotify.FILE_DELETED | JNotify.FILE_MODIFIED | JNotify.FILE_RENAMED;
        int mask = JNotify.FILE_ANY;

        boolean watchSubtree = true;
        try {
            int watchID = JNotify.addWatch(path, mask, watchSubtree, new JNotifyListener(messageImpl));
            while (true) {
                Thread.sleep(1000000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

