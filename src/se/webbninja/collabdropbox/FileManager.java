package se.webbninja.collabdropbox;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.VFS;
import org.apache.commons.vfs.FileSystemManager;

/**
 *
 * @author unolarsson
 */
public class FileManager {

    FileSystemManager fsManager;

    private String myHomePath = System.getProperty("user.home");
    private String baseP = myHomePath + "/Dropbox/Collab/";

    public FileManager(){

        try {
            fsManager = VFS.getManager();
        } catch (FileSystemException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *  Maby we should check every new hidden file created
     *  so it is a Collab-DropBox hidden file.
     *
     * @param hiddenFile
     * @return
     */
    public Boolean checkMainFileExist( String hiddenFile ){

        Boolean isCDBfile = false;

        // Check that the first char is a . so we know its hidden
        if (!hiddenFile.substring(0,1).equals(".")){
            System.out.println( "file not hidden." );
            return false;
        }

        // Remove the first charachter
        String myFile = hiddenFile.substring(1);

        // Return if it exists or not
        Boolean existanze = this.checkFileExists( myFile );
        if (existanze == true) {
            isCDBfile = true;
        }

        // Just tell ut what we have learned
        System.out.println("myFile: " + myFile + " - " + existanze);

        // I ques we are going to do some more checks when we have
        // decided what to name our files.


        // Return it
        return isCDBfile;
        
    }

    public void Exists( String myFile ){

        if (this.checkFileExists( myFile )){
            System.out.println("yeah it exists");
        } else {
            System.out.println("nope it doesnt exist");
        }
        
    }

    private Boolean checkFileExists(String Path){

        Path = baseP + "." + Path;

        try{
            System.out.println("checkFileExists: " + fsManager.resolveFile(Path).getURL());
        
            if (fsManager.resolveFile(Path).exists()){
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());

            return false;
        }
    }

    public void CreateActiveFileFor(String myFile){

        String myHiddenActiveFile = baseP + "." + myFile;

        try {
            this.CreateFile(myHiddenActiveFile);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void CreateFile(String myHiddenActiveFile) throws IOException{

        System.out.println("*CreateFile");

        String theFileToCreate = myHiddenActiveFile;

        try{
            // Create file
            FileWriter fstream = new FileWriter( theFileToCreate );
                BufferedWriter out = new BufferedWriter(fstream);
            out.write("Hello Java");
            //Close the output stream
            out.close();

            System.out.println("skriver fil.");
        } catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void DeleteActiveFileFor(String myFile){

        String myHiddenActiveFile = baseP + "." + myFile;

        FileObject f;

        try {
            if(fsManager.resolveFile(myHiddenActiveFile).delete()){
                System.out.println( myHiddenActiveFile + " is deleted.");
            } else {
                System.out.println( myHiddenActiveFile + " is not deleted.");
            }

        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }

    }

    public void HideFilePC(String myFileToHide){

        String myOs = System.getProperty("os.name");

        FileObject f;

        try {
            f = fsManager.resolveFile(myFileToHide);
            
            if ( !myOs.equals("Mac OS X") ){
                
                Boolean hidden = (Boolean) f.getFileSystem().getAttribute("dos:hidden");
                if (hidden != null && !hidden) {
                    f.getFileSystem().setAttribute("dos:hidden", Boolean.TRUE);
                } else {
                    System.out.println( "File is already hidden." );
                }
                
            } else {
                System.out.println( "This is a Mac, file is already hidden." );
            }
            
        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }

    }


    
}
