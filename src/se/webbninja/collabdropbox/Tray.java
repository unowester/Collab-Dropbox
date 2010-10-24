package se.webbninja.collabdropbox;

import java.awt.*;
import java.awt.event.*;
//import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author unolarsson
 */
public class Tray {

    public void initTray() {

        /* Use an appropriate Look and Feel */
        /* I can't see any difference? */
        try {
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());
            //UIManager.setLookAndFeel("javax.swing.plaf.mac.MacLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }



        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for the event-dispatching thread:
        //adding TrayIcon.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        //Check the SystemTray support
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }


        final PopupMenu popup = new PopupMenu();
        //final TrayIcon trayIcon = new TrayIcon(createImage("images/box_red.png", "tray icon"));

        final TrayIcon trayIcon = new TrayIcon(createImage("images/box_red.png", "tray icon"));
        //final TrayIcon trayIcon = new TrayIcon(java.awt.Toolkit.getDefaultToolkit().getImage("images/box_red.png"));

        final SystemTray tray = SystemTray.getSystemTray();

        trayIcon.setToolTip(returnToolTip());
        trayIcon.setImageAutoSize(true);

        // Create a popup menu components
        MenuItem aboutItem = new MenuItem("About");
        CheckboxMenuItem cb1 = new CheckboxMenuItem("Activated");
        MenuItem exitItem = new MenuItem("Exit");

        //Add components to popup menu
        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(cb1);
        popup.add(exitItem);

        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }

        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "This program checks if a shared dropbox file is active.\nOn your or your collaborators computer.");
            }
        });

        cb1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int cb1Id = e.getStateChange();
                if (cb1Id == ItemEvent.SELECTED){
                    // Displays a popup
                    // TrayIcon.MessageType.XXXX decides how the pop-up will look
                    //trayIcon.displayMessage("Collab DropBox", "Activated", TrayIcon.MessageType.INFO);

                    // Change icon image
                    trayIcon.setImage(createImage("images/box_green.png", "tray icon"));

                } else {
                    // Displays a popup
                    // TrayIcon.MessageType.XXXX decides how the pop-up will look
                    //trayIcon.displayMessage("Collab DropBox", "Deactivated", TrayIcon.MessageType.INFO);

                    // Change icon image
                    trayIcon.setImage(createImage("images/box_red.png", "tray icon"));
                    

                }
            }
        });

        // Adds the exit button
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
    }
    
    //Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = Main.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }

    private static String returnToolTip(){

        String output = "Active Files:\n";
        String ActiveFiles = "";

        if (!ActiveFiles.equals("")){
            output += ActiveFiles;
        } else {
            output += "No Active Files";
        }

        return output;
    }

}
