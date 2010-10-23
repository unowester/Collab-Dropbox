package se.webbninja.collabdropbox;

import net.contentobjects.jnotify.JNotify;

public class Main {
  public static void main(String[] args) {
    runJNotify();
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

