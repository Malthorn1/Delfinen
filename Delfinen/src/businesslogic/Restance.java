package businesslogic;

import java.util.ArrayList;


public class Restance {
    String medlems_navn;
    int medlems_Nummer;
    int medlem_alder;
    int gæld;
    boolean passiv;
    private ArrayList<Medlem> medlemmer;
    
    public Restance (String medlems_navn, int medlems_Nummer, int medlem_alder, boolean passiv) {
        this.medlems_navn = medlems_navn;
        this.medlems_Nummer = medlems_Nummer;
        this.medlem_alder = medlem_alder;
        this.passiv = passiv;
        medlemmer = new ArrayList<Medlem>();
    }

    public boolean isPassiv() {
        return passiv;
    }

    public void setPassiv(boolean passiv) {
        this.passiv = passiv;
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
