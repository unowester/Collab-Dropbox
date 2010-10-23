package se.webbninja.collabdropbox;

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
}

