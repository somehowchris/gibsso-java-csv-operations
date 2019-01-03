package m411p1;
import java.io.*;

/**
 * Liest eine Datei zeilenweise.
 * 
 * @author D. Mosimann
 */
public class FileReader  {
    BufferedReader f1=null;

    /**
     * Konstruktor. �ffnet den Filestream.
     * @param filename Name der zu lesenden Datei
     */
    public FileReader(String filename) {
        try {
            f1  = new BufferedReader( new java.io.FileReader(filename));
        } catch ( FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }        
    }
    
    /**
     * Wird mehrmahls aufgerufen. Ist das Ende der Datei erreicht, wird Null zur�ckgegeben.
     * 
     * @return String mit del gelesenen Zeile oder Null
     */
    public String readNext() {
        String line=null;
        
        try {
            line =  f1.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return line;
    }
}
