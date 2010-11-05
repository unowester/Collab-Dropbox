package se.webbninja.collabdropbox;

import javax.swing.JOptionPane;

import se.webbninja.collabdropbox.MessageImplementation;

/**
 *
 * @author antonberner
 */
public class SwingNotification implements MessageImplementation {

    public void isUsingFile(String filename, String username) {
        String message = username + " is using " + filename;
        String title = "Dropbox notification";
        JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION);
    }

    public void stoppedUsingFile(String filename, String username) {
        String message = username + " has stoped using " + filename;
        String title = "Dropbox notification";
        JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION);
    }

}
