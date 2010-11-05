package se.webbninja.collabdropbox;

public class JNotifyListener implements net.contentobjects.jnotify.JNotifyListener {

    private MessageImplementation messageImpl;

    public JNotifyListener(MessageImplementation messageImpl) {
        this.messageImpl = messageImpl;
    }

    public void fileRenamed(int wd, String rootPath, String oldName, String newName) {
        messageImpl.isUsingFile(oldName, "someidiot");
        System.out.println("JNotifyTest.fileRenamed() : wd #" + wd + " root = " + rootPath + ", " + oldName + " -> " + newName);
    }

    public void fileModified(int wd, String rootPath, String name) {
        messageImpl.isUsingFile(name, "someidiot");
        System.out.println("JNotifyTest.fileModified() : wd #" + wd + " root = " + rootPath + ", " + name);
    }

    public void fileDeleted(int wd, String rootPath, String name) {
        messageImpl.isUsingFile(name, "someidiot");
        System.out.println("JNotifyTest.fileDeleted() : wd #" + wd + " root = " + rootPath
                + ", " + name);
    }

    public void fileCreated(int wd, String rootPath, String name) {
        messageImpl.isUsingFile(name, "someidiot");
        System.out.println("JNotifyTest.fileCreated() : wd #" + wd + " root = " + rootPath
                + ", " + name);
    }
}
