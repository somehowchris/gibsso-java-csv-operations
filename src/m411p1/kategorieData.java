package m411p1;

public class kategorieData {
    private String kategorie;
    private int anzahl;
    
    public kategorieData(String kategorie, int anzahl) {
        this.kategorie = kategorie;
        this.anzahl = anzahl;
    }
    public kategorieData(String kategorie) {
        this.kategorie = kategorie;
    }
    
    public String getKategorie() {
        return this.kategorie;
    }
    
    public int getAnzahl() {
        return this.anzahl;
    }
    public void add(){
        this.anzahl++;
    }
}
