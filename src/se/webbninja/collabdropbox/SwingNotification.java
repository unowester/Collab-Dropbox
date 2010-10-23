package se.webbninja.collabdropbox;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import se.webbninja.collabdropbox.MessageImplementation;


/**
 *
 * @author antonberner
 */
public class SwingNotification implements MessageImplementation {

    public SwingNotification(){

    }
 /**
 *  isUsingFile() is a method to notify the dropbox user is staring to use a file
 *  String filename, the name of the file being used
 *  String username, the name of the user hwo is using the file
 */
    public void isUsingFile(String filename, String username) {

        String message = username + " is using " + filename;
        String title = "Dropbox notification";
        JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION);

        
        throw new UnsupportedOperationException("Not supported yet.");
    }
/**
 *  stoppedUsingFile() is a method to notify the dropbox users when someone is stoppes using a file
 *  String filename, the name of the file being used
 *  String username, the name of the user hwo is using the file
 */
    public void stoppedUsingFile(String filename, String username) {

        String message = username + " has stoped using " + filename;
        String title = "Dropbox notification";
        JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION);


        throw new UnsupportedOperationException("Not supported yet.");
    }

}
