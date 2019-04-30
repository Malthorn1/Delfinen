
package businesslogic;

/**
 *
 * @author prejl
 */
public class Medlem {
    private String navn;
    private int age;
    private int telefonnummer;
    private boolean betalt;
    private boolean konkurrencesvømmer;
    private String træner;

    public Medlem(String navn, int age, int telefonnummer, boolean betalt, boolean konkurrencesvømmer, String træner) {
        this.navn = navn;
        this.age = age;
        this.telefonnummer = telefonnummer;
        this.betalt = betalt;
        this.konkurrencesvømmer = konkurrencesvømmer;
        this.træner = træner;
    }

    public String getNavn() {
        return navn;
    }

    public int getAge() {
        return age;
    }

    public int getTelefonnummer() {
        return telefonnummer;
    }

    public boolean isBetalt() {
        return betalt;
    }

    public boolean isKonkurrencesvømmer() {
        return konkurrencesvømmer;
    }

    public String getTræner() {
        return træner;
    }
    
    
}
