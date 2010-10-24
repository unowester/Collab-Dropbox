package se.webbninja.collabdropbox;

import net.contentobjects.jnotify.JNotify;

public class Main {
  public static void main(String[] args) {
    //runJNotify();

    //runFileTest();

      startTray();
  }

  public static void startTray(){
      Tray tray = new Tray();
      tray.initTray();
  }

  public static void runFileTest(){
        FileManager fm = new FileManager();

        fm.Exists( "test.txt" );
        fm.CreateActiveFileFor( "test.txt" );
        fm.Exists( "test.txt" );
        fm.DeleteActiveFileFor( "test.txt" );

  }
  
  public static void runJNotify() {

    String myHomePath = System.getProperty("user.home");
    String baseP = myHomePath + "/Dropbox/Collab/";

    // dropbox path.. or wherever :/
    String path = baseP;

    //int mask = JNotify.FILE_CREATED | JNotify.FILE_DELETED | JNotify.FILE_MODIFIED | JNotify.FILE_RENAMED;
    int mask = JNotify.FILE_ANY;

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

