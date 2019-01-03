package m411p1;
import com.sun.org.apache.xml.internal.resolver.readers.CatalogReader;
import java.util.Comparator;

public class csysData {
    private int id;
    private String benutzer;
    private String kategorie;
    private int prio;
    private String sachbearbeiter;
    private String datum;
    private String titel;
    
    public csysData(int id, String benutzer, String kategorie, int prio, String sachbearbeiter, String datum, String titel) {
        this.id = id;
        this.benutzer = benutzer;
        this.kategorie = kategorie;
        this.prio = prio;
        this.sachbearbeiter = sachbearbeiter;
        this.datum = datum;
        this.titel = titel;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getBenutzer() {
        return this.benutzer;
    }

    public String getKategorie() {
        return this.kategorie;
    }

    public int getPrio() {
        return this.prio;
    }

    public String getSachbearbeiter() {
        return this.sachbearbeiter;
    }

    public String getDatum() {
        return this.datum;
    }   
    
    public String getTitel() {
        return this.titel;
    }
}

class ComparecsysDataKatgoire implements Comparator<csysData>{

    @Override
    public int compare(csysData d1, csysData d2) {
        return d1.getKategorie().compareTo(d2.getKategorie());
    }

}
