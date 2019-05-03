
package businesslogic;

/**
 *
 * @author prejl
 */
public class Medlem {
    private String navn;
    private int age;
    private int telefonnummer;
    private boolean restance;
    private boolean konkurrencesvømmer;
    private int medlemsnummer;

    public Medlem(String navn, int age, int telefonnummer, boolean restance, boolean konkurrencesvømmer) {
        this.navn = navn;
        this.age = age;
        this.telefonnummer = telefonnummer;
        this.restance = restance;
        this.konkurrencesvømmer = konkurrencesvømmer;
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
        return restance;
    }

   @Override
   public String toString(){
       return "Medlem oprettet: Navn: "+navn+" Alder: " + age + " Telefon nummer: " + telefonnummer + " Medlem har betalt: " + restance;
   }

    public boolean isRestance() {
        return restance;
    }

    public boolean isKonkurrencesvømmer() {
        return konkurrencesvømmer;
    }

    public int getMedlemsnummer() {
        return medlemsnummer;
    }

    
    
    
}
