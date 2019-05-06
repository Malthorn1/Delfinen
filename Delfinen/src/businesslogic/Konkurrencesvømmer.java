package businesslogic;

/**
 *
 * @author prejl
 */
public class Konkurrencesvømmer extends Medlem{
    
    public int trænerID;

    public Konkurrencesvømmer(String navn, int age, int telefonnummer, boolean restance, int trænerID) {
        super(navn, age, telefonnummer, restance);
        this.trænerID=trænerID;
    }

    public int getTrænerID() {
        return trænerID;
    }
    
    

    

    
    
    
    
    
    
}
