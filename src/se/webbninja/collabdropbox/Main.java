package se.webbninja.collabdropbox;

import net.contentobjects.jnotify.JNotify;

public class Main {
  public static void main(String[] args) {

    System.out.println("HELLO WORLD");

    selectNotifyer("file","name");
   
  }

  public static void selectNotifyer(String file, String username){
   
    GrowlNotification gn = new GrowlNotification();
    SwingNotification sw = new SwingNotification();
    String os = System.getProperty("os.name");
    
    if ( os == null ? "Mac OS X" == null : os.equals("Mac OS X")){
        if (gn.isRunning()){
            gn.isUsingFile(file, username);
        }
        else {
           sw.isUsingFile(file, username);
        }
    }
    else{
        sw.isUsingFile(file, username);
    }


  }

  public static void runJNotify() {
    // dropbox path.. or wherever :/
    String path = "/home/inty/Dropbox/Collab";

    int mask = JNotify.FILE_CREATED | JNotify.FILE_DELETED | JNotify.FILE_MODIFIED | JNotify.FILE_RENAMED;
    boolean watchSubtree = true;
    try {
      int watchID = JNotify.addWatch(path, mask, watchSubtree, new JNotifyListener());
      while (true) {
        Thread.sleep(1000000);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}

