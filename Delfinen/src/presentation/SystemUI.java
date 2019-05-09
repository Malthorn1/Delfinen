package presentation;

import businesslogic.Konkurrencesvømmer;
import businesslogic.Leaderboard;
import businesslogic.Medlem;
import businesslogic.Træner;
import businesslogic.Restance;
import datalayer.DBFacade;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Casper P, Frederik, Mikkel
 */
public class SystemUI implements UI {

    DBFacade db = new DBFacade();
    Scanner scan = new Scanner(System.in);

    @Override
    public void visHovedMenu() {
        System.out.println("");
        System.out.println("Vælg en af følgende valgmuligheder: ");
        System.out.println("1: Administrer brugere");
        System.out.println("2: Administrer betaling");
        System.out.println("3: Udskriv scoreboard for konkurrence svømmere");
        System.out.println("q: Afslut");
    }

    @Override
    public String hovedMenuValg() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    /*
    Metoden laver et medlemsobjekt med variabler fra scanner input. 
    Herefter opretter vi på samme tid medlemmet i databasen som tager scanner variablerne som argumenter. 
    
     */
    @Override
    public void printSvømmehold() throws SQLException {
        ArrayList<Konkurrencesvømmer> svømmehold = new ArrayList();
        svømmehold = db.hentSvømmeHold();
        Medlem medlem;
        for (int i = 0; i < svømmehold.size(); i++) {
            medlem = svømmehold.get(i);
            int medlem_alder = medlem.getAge();
            String Hold = "";
            if (medlem_alder < 18) {
                Hold = "U18";
            } else if (medlem_alder >= 18) {
                Hold = "VoksenHold";
            }
            String medlems_navn = medlem.getNavn();
            int medlems_nummer = medlem.getMedlemsnummer();
            String navn = medlems_navn.substring(0, 1).toUpperCase() + medlems_navn.substring(1);
            System.out.print("Navn: " + navn);
            System.out.print(", Medlemsnummer: " + medlems_nummer);
            System.out.print(", Alder: " + medlem_alder);
            System.out.print(", Svømmehold: " + Hold + " \n");
        }

    }
    
    @Override
    public String getString(String str) {
        System.out.println(str);
        String emptyString;
        emptyString = scan.next();
        if (emptyString.matches(".*[0-9].*")) {
            do {
            System.err.print("Fejl ved indtastning af input. Fejl: Der blev indtasted andet end bokstaver. Prøv igen:   ");
            emptyString = scan.next();
        } while (emptyString.matches(".*[0-9].*"));
        } return emptyString;
    }
    
    @Override
    public int getInt(String str) {
        System.out.println(str);
        String nextInput = scan.next();
       try {
            int input = Integer.parseInt(nextInput);
           if(input >=0) {
               return input; }
       } 
       catch (NumberFormatException e) {
           System.err.println("Skriv et tal");
       }
   
       return getInt(str);
    }  
        @Override
    public int getIntTræner(String str) {
        System.out.println(str);
        String nextInput = scan.next();
       try {
           int input = Integer.parseInt(nextInput);
           if(input > 10000 && input <10006) {
               return input;
           }
       } catch (NumberFormatException e) {
            System.err.println("Skriv et korrekt træner id.");
       }
        return getIntTræner(str);
    }

    @Override
    public String getBoolean(String str) {
        System.out.println(str);
        String emptyString;
        emptyString = scan.next();
        while (emptyString.matches(".*[0-9].*")) {
            
            System.err.println("Fejl ved indtastning af input. Fejl: Skriv enten y for ja  eller n for nej  ");
            emptyString = scan.next();
        } if (emptyString.matches("y")) {
            return "y"; 
        } else if (emptyString.matches("n")) {
            return "n"; 
        }else {
            System.err.println("Fejl ved indtastning af input. Fejl: Skriv enten y for ja  eller n for nej  ");
            getBoolean(str);
        }
        return emptyString;
    }
    

    @Override
    public void indtastTræningstid() {

        System.out.println("Indtast medlemsnummeret på konkurrenesvømmer:  ");
        int medlemsnummer = scan.nextInt();
        System.out.print("Indtast træningstid HH:MM:SS: ");

        DateTimeFormatter parseFormat = DateTimeFormatter.ofPattern("H:mm:ss");
        String strTid = scan.next();
        LocalTime time = LocalTime.parse(strTid, parseFormat);
        LocalTime timePlusone = time.plusHours(1);
        Time tid = Time.valueOf(timePlusone);

        System.out.println("Indtast navn på Disciplin");
        String disciplin = scan.next();
        db.indtastTræningstid(medlemsnummer, tid, disciplin);

    }

    @Override
    public void printRestance() throws SQLException {
        ArrayList<Restance> Restance = new ArrayList();
        Restance = db.hentRestance();
        Restance restance1;
        for (int i = 0; i < Restance.size(); i++) {
            restance1 = Restance.get(i);
            String medlems_navn = restance1.getMedlems_navn();
            int medlems_Nummer = restance1.getMedlems_Nummer();
            int medlem_alder = restance1.getMedlem_alder();
            boolean passiv = restance1.isPassiv();
            int gæld = 500;

            if (passiv == false) {
                if (medlem_alder < 18) {
                    gæld = 1000;
                } else if (medlem_alder >= 18 && medlem_alder < 60) {
                    gæld = 1600;
                } else if (medlem_alder >= 60) {
                    gæld = 1200;
                }
            }

            System.out.print("Navn: " + medlems_navn);
            System.out.print(", Medlemsnummer: " + medlems_Nummer);
            System.out.print(", Skyldigt beløb : " + gæld + "\n");
        }
    }

    @Override
    public void printTrænere() throws SQLException {
        ArrayList<Træner> trænere = new ArrayList();
        trænere = db.hentTrænere();
        Træner træner;
        for (int i = 0; i < trænere.size(); i++) {
            træner = trænere.get(i);
            String træner_navn = træner.getNavn();
            int træner_id = træner.gettræner_Id();

            System.out.print("Træner navn: " + træner_navn);
            System.out.print(" Træner ID: " + træner_id + " \n");

        }
    }

    @Override
    public void printLeaderboard() throws SQLException {
        ArrayList<Leaderboard> Leaderboard = new ArrayList();

        Leaderboard = getCrawl();

        Leaderboard leaderboard1;
        for (int i = 0; i < Leaderboard.size(); i++) {
            leaderboard1 = Leaderboard.get(i);
            String disciplin = leaderboard1.getDisciplin();
            LocalTime bedsteTid = leaderboard1.getBedsteTid();
            int medlemsnummer = leaderboard1.getMedlemsnummer();
            bedsteTid = bedsteTid.minusHours(1);
            printLnsvømmetid(bedsteTid, disciplin, medlemsnummer);
        }
        Leaderboard = getRyg();
        Leaderboard leaderboard2;
        for (int i = 0; i < Leaderboard.size(); i++) {
            leaderboard2 = Leaderboard.get(i);
            String disciplin = leaderboard2.getDisciplin();
            LocalTime bedsteTid = leaderboard2.getBedsteTid();
            int medlemsnummer = leaderboard2.getMedlemsnummer();
            bedsteTid = bedsteTid.minusHours(1);
            printLnsvømmetid(bedsteTid, disciplin, medlemsnummer);
        }
        Leaderboard = getBryst();
        Leaderboard leaderboard3;
        for (int i = 0; i < Leaderboard.size(); i++) {
            leaderboard3 = Leaderboard.get(i);
            String disciplin = leaderboard3.getDisciplin();
            LocalTime bedsteTid = leaderboard3.getBedsteTid();
            int medlemsnummer = leaderboard3.getMedlemsnummer();
            bedsteTid = bedsteTid.minusHours(1);
            printLnsvømmetid(bedsteTid, disciplin, medlemsnummer);
        }
        Leaderboard = getFly();
        Leaderboard leaderboard4;
        for (int i = 0; i < Leaderboard.size(); i++) {
            leaderboard4 = Leaderboard.get(i);
            String disciplin = leaderboard4.getDisciplin();
            LocalTime bedsteTid = leaderboard4.getBedsteTid();
            bedsteTid = bedsteTid.minusHours(1);
            int medlemsnummer = leaderboard4.getMedlemsnummer();
            printLnsvømmetid(bedsteTid, disciplin, medlemsnummer);
        }
    }

    @Override
    public ArrayList<Leaderboard> getCrawl() throws SQLException {
        ArrayList<Leaderboard> Leaderboard = new ArrayList();
        Leaderboard = db.hentLeaderboardCrawl();
        return Leaderboard;
    }

    @Override
    public ArrayList<Leaderboard> getRyg() throws SQLException {
        ArrayList<Leaderboard> Leaderboard = new ArrayList();
        Leaderboard = db.hentLeaderboardRyg();
        return Leaderboard;
    }

    @Override
    public ArrayList<Leaderboard> getBryst() throws SQLException {
        ArrayList<Leaderboard> Leaderboard = new ArrayList();
        Leaderboard = db.hentLeaderboardBryst();
        return Leaderboard;
    }

    @Override
    public ArrayList<Leaderboard> getFly() throws SQLException {
        ArrayList<Leaderboard> Leaderboard = new ArrayList();
        Leaderboard = db.hentLeaderboardFly();
        return Leaderboard;
    }

    public void printLnsvømmetid(LocalTime bedsteTid, String disciplin, int medlemsnummer) {
        System.out.print("Bedste tid:" + bedsteTid);
        System.out.print(", disciplin: " + disciplin);
        System.out.print(", medlemsnummer: " + medlemsnummer + "\n");
    }

    public void opretMedlem() throws SQLException {
        boolean isRestance = true;
        int trænerID = 0;
        
        String navn = getString("Indtast medlemmes navn: ");
        int age = getInt("Indtast medlemmets alder: ");
        int telefonnummer = getInt("Indtast medlemmets telefonnummer: ");
        String restance = getBoolean("Har medlem betalt? y/n ");
        if (restance.contains("y")) {
            isRestance = false;
        }
        String isKonkurrencesvømmer = getBoolean("Skal medlem være konkurrencesvømmer? y/n");
        if (isKonkurrencesvømmer.contains("y")) {
            printTrænere();
            trænerID = getIntTræner("Indtast ID på trænernen");
            Konkurrencesvømmer konkurrencesvømmer = new Konkurrencesvømmer(navn, age, telefonnummer, isRestance, trænerID);
            db.opretKonkurrenceSvømmer(konkurrencesvømmer);
                   
        if (isRestance == false) {
           isRestance =true; 
            
        } else if (isRestance == true) {
            isRestance= false; 
        }
        konkurrencesvømmer.setRestance(isRestance);
        System.out.println(konkurrencesvømmer.toString());
        System.out.println("\n");
        }
        else if (isKonkurrencesvømmer.contains("n")) {
        Medlem medlem = new Medlem(navn, age, telefonnummer, isRestance);
        try {
            db.opretMedlem(medlem);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        if (isRestance == false) {
           isRestance =true; 
            
        } else if (isRestance == true) {
            isRestance= false; 
        }
        medlem.setRestance(isRestance);
        System.out.println(medlem.toString());
        System.out.println("\n");
        }
    }
    
    public void setRestanceTilJa() {
        int medlemsnummer = getInt("Indtast medlemmets nummer");
        db.sætMedlemRestanceJa(medlemsnummer);
    }

    public void setRestanceTilNej() {
        int medlemsnummer = getInt("Indtast medlemmets nummer");
        db.sætMedlemRestanceNej(medlemsnummer);
    }

    public void setPassivTilJa() {
        int medlemsnummer = getInt("Indtast medlemmets nummer");
        db.sætMedlemPassivJa(medlemsnummer);
    }

    public void setPassivTilNej() {
        int medlemsnummer = getInt("Indtast medlemmets nummer");
        db.sætMedlemPassivNej(medlemsnummer);
    }
    
    public void annulerAbonnement() {
        int medlemsnummer = getInt("Indtast medlemmets nummer");
        db.annulerAbonnement(medlemsnummer);
    }

    public void redigerNavn() {
        String navn = getString("Indtast nyt navn på medlem: ");
        int medlemsnummer = getInt("Indtast medlemmets nummer");
        db.redigerNavn(medlemsnummer, navn);
    }

    public void redigerTelefonnummer() {
        int medlemsnummer = getInt("Indtast medlemmets nummer");
        System.out.print("");
        int telefonnummer = getInt("Indtast det nye telefonnummer: ");
        db.redigerTelefonnummer(medlemsnummer, telefonnummer);
        
    }
    
    public void setKonkurrenceSvømmerJa() throws SQLException{
        int medlemsnummer = getInt("Indtast nummer på medlem: ");
        printTrænere();
        System.out.println("");
        int træner_id = getInt("Indtast træner ID: ");
        db.setKonkurrencesvømmerJa(medlemsnummer, træner_id);
    }
    
    public void setKonkurrenceSvømmerNej(){
        int medlemsnummer = getInt("Indtast nummer på medlem: ");      
        db.setKonkurrencesvømmerNej(medlemsnummer);
    }

    @Override
    public void skrivQForAtKommeTilbage() {
        System.out.println("Skriv q for at gå tilbage");
        String nextInput0 = scan.next();
            while (!nextInput0.contains("q")) {
            forkertInput();
            nextInput0 = scan.next();
    }
    }

    public void forkertInput() {
        System.err.print("Input forkert, prøv igen: \n");
    }

    public void udskrivAdministrerBrugere() {
        System.out.println("");
        System.out.println("Vælg en af følgende valgmuligheder: ");
        System.out.println("1: Opret bruger");
        System.out.println("2: Rediger bruger");
        System.out.println("3: Udskriv trænere");
        System.out.println("4: Udskriv svømmehold");
        System.out.println("q: Tryk q for at gå tilbage");
    }
    
    public void udskrivRedigerBruger(){
        System.out.println("");
        System.out.println("Vælg en af følgende valgmuligheder: ");
        System.out.println("1: Rediger telefonnummer");
        System.out.println("2: Tilføj medlem til at være konkurrencesvømmer");
        System.out.println("3: Fjern medlem fra konkurrencesvømmer");
        System.out.println("4: Rediger navn");
        System.out.println("q: Tryk q for at gå tilbage");
    }

    public void udskrivAdministrerBetaling() {
        System.out.println("");
        System.out.println("Vælg en af følgende valgmuligheder: ");
        System.out.println("1: Annuler abonnement");
        System.out.println("2: Udskriv medlemmere i restance");
        System.out.println("3: Tilføj restance til et medlem");
        System.out.println("4: Fjern restance fra et medlem");
        System.out.println("5: Sæt medlem til passiv");
        System.out.println("6: Fjern medlem fra passiv");
        System.out.println("q: Tryk q for at gå tilbage");
    }

    @Override
    public void printMedlemmer() throws SQLException {
        ArrayList<Medlem> medlemmer = new ArrayList();
        medlemmer = db.hentMedlemmer();
        Medlem medlem;
        for (int i = 0; i < medlemmer.size(); i++) {
            medlem = medlemmer.get(i);
            String medlem_navn = medlem.getNavn();
            int medlem_alder = medlem.getAge();
            int medlemsNummer = medlem.getMedlemsnummer(); 
            int medlem_telefonNummer = medlem.getTelefonnummer();
            Timestamp datoOprettet = medlem.getDatoOprettet();
            boolean restance = medlem.isRestance();
            boolean konkurrenceSvømmer = medlem.isKonkurrencesvømmer();
            boolean passiv = medlem.isPassiv();

            
            int kontigent = 500;
            if (passiv == false) {
                if (medlem_alder < 18) {
                    kontigent = 1000;
                } else if (medlem_alder >= 18 && medlem_alder < 60) {
                    kontigent = 1600;
                } else if (medlem_alder >= 60) {
                    kontigent = 1200;
                }
            }

            String SRestance = "er ikke "; 
            if (restance == true) {
                SRestance= "ER "; 
            }
            System.out.print("Medlemsnummer: " + medlemsNummer +"\n"); 
            System.out.print("Oprettet d. " +datoOprettet + "\n"); 
            System.out.print("Navn: " + medlem_navn + "\n" ) ;
            System.out.print("Telefonnummer: "+ medlem_telefonNummer + "\n");
            System.out.print("Medlemsskabets årlige kontigent er: " + kontigent +"kr."+"\n" );
            System.out.print("Konkurrence Svømmer: " + konkurrenceSvømmer +"\n"); 
            System.out.print("Medlemet " + SRestance +"i restance");  
            System.out.print("\n \n");
        }
    }


}
