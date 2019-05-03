
package businesslogic;

import java.util.ArrayList;


public class Træner {
    private String navn;
    private ArrayList<Medlem> medlemmer;
    private int id;

    public Træner(String navn, int træner_id) {
        this.navn = navn;
        this.id = træner_id;
        medlemmer = new ArrayList<Medlem>();
        
    }
  

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public ArrayList<Medlem> getMedlemmer() {
        return medlemmer;
    }

    public void setMedlemmer(ArrayList<Medlem> medlemmer) {
        this.medlemmer = medlemmer;
    }

    public int gettræner_Id() {
        return id;
    }

    public void settræner_Id(int id) {
        this.id = id;
    }
    
    
    
}
