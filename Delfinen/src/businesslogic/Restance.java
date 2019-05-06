package businesslogic;

import java.util.ArrayList;


public class Restance {
    String medlems_navn;
    int medlems_Nummer;
    int medlem_alder;
    int gæld;
    private ArrayList<Medlem> medlemmer;
    
    public Restance (String medlems_navn, int medlems_Nummer, int medlem_alder) {
        this.medlems_navn = medlems_navn;
        this.medlems_Nummer = medlems_Nummer;
        this.medlem_alder = medlem_alder;
        medlemmer = new ArrayList<Medlem>();
    }

    public ArrayList<Medlem> getMedlemmer() {
        return medlemmer;
    }

    public String getMedlems_navn() {
        return medlems_navn;
    }

    public int getMedlems_Nummer() {
        return medlems_Nummer;
    }

    public int getMedlem_alder() {
        return medlem_alder;
    }

    public int getGæld() {
        return gæld;
    }

    
}
