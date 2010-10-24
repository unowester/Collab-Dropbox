package se.webbninja.collabdropbox;

import com.growl.GrowlWrapper;

/*
 * GrowlConnetion is a class to notify users who is using mac and got growl installed
 */

/**
 *
 * @author antonberner
 */
public class GrowlNotification implements MessageImplementation {

    public GrowlNotification(){

    }
 /**
 *  isRunning() is a mesthod to check if growl is running and running ok on the your mac
 */
    public boolean isRunning(){

        String FUN_NOTIFICATION="Fun notification", BORING_NOTIFICATION="Boring notification";

        GrowlWrapper gw=new GrowlWrapper("myApp","dropbox",
        new String[] {FUN_NOTIFICATION,BORING_NOTIFICATION},
        new String[] {FUN_NOTIFICATION});

        boolean gwOk= false;
        if (gw.getState() == GrowlWrapper.GROWL_OK)
        {
            gwOk= true;
        }
        else{
            gwOk= false;
        }

        return gwOk;
    }
/**
 *  isUsingFile() is a method to notify the dropbox user is staring to use a file
 *  String filename, the name of the file being used
 *  String username, the name of the user hwo is using the file
 */
    public void isUsingFile(String filename, String username) {

        String FUN_NOTIFICATION="Fun notification", BORING_NOTIFICATION="Boring notification";

        GrowlWrapper gw=new GrowlWrapper("MyApp","dropbox",
        new String[] {FUN_NOTIFICATION,BORING_NOTIFICATION},
        new String[] {FUN_NOTIFICATION});

        String myMessage = username  + " is using " + filename;

       gw.notify(FUN_NOTIFICATION,"Dropbox notifikation",myMessage);

       //gw.notify(BORING_NOTIFICATION,"Boring stuff",myMessage);


        throw new UnsupportedOperationException("Not supported yet.");
    }
/**
 *  stoppedUsingFile() is a method to notify the dropbox users when someone is stoppes using a file 
 *  String filename, the name of the file being used 
 *  String username, the name of the user hwo is using the file 
 */
    public void stoppedUsingFile(String filename, String username) {

        String FUN_NOTIFICATION="Fun notification", BORING_NOTIFICATION="Boring notification";

        GrowlWrapper gw=new GrowlWrapper("MyApp","dropbox",
        new String[] {FUN_NOTIFICATION,BORING_NOTIFICATION},
        new String[] {FUN_NOTIFICATION});

        String myMessage = username  + " has stoped using " + filename;

        gw.notify(FUN_NOTIFICATION,"DropBox notifikation",myMessage);

     //   gw.notify(BORING_NOTIFICATION,"Boring stuff","I bet you regret seeing this!");


        throw new UnsupportedOperationException("Not supported yet.");
    }
}