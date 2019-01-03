package m411p1;
import java.awt.PageAttributes;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.*;
import java.text.*;

/**
 * Daten eines Ticket-Systems aus einen CSV lesen und in einer ArrayList speichern.
 * Anzahl Tickets pro Kategorie berechnen.
 * 
 * @author gibs
 */
public class csysReader {
    final static String csys = "csys_export.csv";      // Name der CSV-Datei
    ArrayList<csysData> al=null;                       // Liste mit den Daten
    FileReader fr;                                     // Instanz von FileReader
    
    /**
     * Konstruktor. Initialisiert den FileReader und die Liste
     */
    public csysReader() {
        this.fr = new FileReader(csys);
        this.al = new ArrayList();
    }
    
    /**
     * Liest Daten aus dem CSV und spechert diese in der Liste (ArrayList)
     */
    public void readCsys() {
        fr = new FileReader(csys);
        String line;
        String header = fr.readNext();
        while ( (line = fr.readNext()) != null ) {
            String[] datasplit = line.split(";");
            
            int id = new Integer(datasplit[0]);
            String benutzer = datasplit[1];
            String kategorie = datasplit[2];
            int prio = new Integer(datasplit[3]);
            String sachbearbeiter = datasplit[4];
            String datum = datasplit[5];
            String titel = datasplit[6];
            
            csysData data = new csysData(id, benutzer, kategorie, prio, sachbearbeiter, datum, titel);
            
            al.add(data);
        }
        Collections.sort(al, new ComparecsysDataKatgoire());
    }
    
    /**
     * Gibt die Datenliste zurück.
     * 
     * @return ArrayList mit den Daten des Ticket-Systems 
     */
    public ArrayList<csysData> getCsys() {
        return this.al;
    }
    
    /**
     * Berechnet die Anzahl Tickets pro Kategorie, speichert die
     * Ergebnisse in einer Liste (ArrayList) und gibt diese Liste zurück.
     * 
     * @return ArrayList mit der Anzahl Tickets pro Kategorie 
     */
    public ArrayList<kategorieData> getKategorieStatistik() {
        ArrayList<kategorieData> kd = new ArrayList();
        
        for(csysData data : al){
            String cat = data.getKategorie();
            boolean found = false;
            for(kategorieData currentcat : kd){
                if(currentcat.getKategorie().equalsIgnoreCase(cat)){
                    currentcat.add();
                    found = true;
                }
            }
            if(!found){
                kd.add(new kategorieData(cat,1));
            }
        }
        
        return kd;
    }
    
}
