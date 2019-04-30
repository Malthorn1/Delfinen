
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

    public Medlem(String navn, int age, int telefonnummer, boolean betalt) {
        this.navn = navn;
        this.age = age;
        this.telefonnummer = telefonnummer;
        this.betalt = betalt;
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

   @Override
   public String toString(){
       return "Medlem oprettet: Navn: "+navn+" Alder: " + age + " Telefon nummer: " + telefonnummer + " Medlem har betalt: " + betalt;
   }

    
    
    
}
