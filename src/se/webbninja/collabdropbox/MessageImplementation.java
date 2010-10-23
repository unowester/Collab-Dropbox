package se.webbninja.collabdropbox;

/**
 * interface for message notifications
 * @author antonberner
 */
public interface MessageImplementation {

    public void isUsingFile(String filename, String username);
    public void stoppedUsingFile(String filename, String username);
}

