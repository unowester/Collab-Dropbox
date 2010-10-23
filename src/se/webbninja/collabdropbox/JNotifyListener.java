package se.webbninja.collabdropbox;

public class JNotifyListener implements net.contentobjects.jnotify.JNotifyListener {
  public void fileRenamed(int wd, String rootPath, String oldName, String newName) {
    System.out.println("JNotifyTest.fileRenamed() : wd #" + wd + " root = " + rootPath + ", " + oldName + " -> " + newName);
  }

  public void fileModified(int wd, String rootPath, String name) {
    System.out.println("JNotifyTest.fileModified() : wd #" + wd + " root = " + rootPath + ", " + name);
  }

  public void fileDeleted(int wd, String rootPath, String name) {
    System.out.println("JNotifyTest.fileDeleted() : wd #" + wd + " root = " + rootPath
        + ", " + name);
  }

  public void fileCreated(int wd, String rootPath, String name) {
    System.out.println("JNotifyTest.fileCreated() : wd #" + wd + " root = " + rootPath
        + ", " + name);
  }
}
