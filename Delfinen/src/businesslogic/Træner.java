
package businesslogic;

import java.util.ArrayList;


public class Træner {
    private String navn;
    private ArrayList<Medlem> medlemmer;
    private int id;

    public Træner(String navn, int id) {
        this.navn = navn;
        this.id = id;
        medlemmer = new ArrayList<Medlem>();
        
    }
    
    
    
}
