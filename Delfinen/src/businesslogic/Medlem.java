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
    
    public Medlem(String navn, int age, int telefonnummer, boolean restance) {
        this.navn = navn;
        this.age = age;
        this.telefonnummer = telefonnummer;
        this.restance = restance;
    }
    
     public Medlem() {
        // tom constructor
    }


    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTelefonnummer(int telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public void setRestance(boolean restance) {
        this.restance = restance;
    }

    public void setKonkurrencesvømmer(boolean konkurrencesvømmer) {
        this.konkurrencesvømmer = konkurrencesvømmer;
    }

    public void setMedlemsnummer(int medlemsnummer) {
        this.medlemsnummer = medlemsnummer;
    }

    public void setTræner(Træner træner) {
        this.træner = træner;
    }
    private Træner træner;

   

    
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
    public String toString() {
        return "Medlem oprettet: Navn: " + navn + " Alder: " + age + " Telefon nummer: " + telefonnummer + " Medlem har betalt: " + restance;
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
