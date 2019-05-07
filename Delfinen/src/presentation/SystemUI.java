package presentation;

import businesslogic.Controller;
import businesslogic.Konkurrencesvømmer;
import businesslogic.Leaderboard;
import businesslogic.Medlem;
import businesslogic.Træner;
import businesslogic.Restance;
import datalayer.DBFacade;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalTime;
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

    @Override
    public void administrerBrugere() {
        try {
            udskrivAdministrerBrugere();
            Scanner scan = new Scanner(System.in);
            String brugerInput = scan.nextLine();
            switch (brugerInput) {
                case "1":
                    opretMedlem();
                    break;
                case "2":
                    //
                    break;
                case "3":
                    printtrænere();
                    skrivQForAtKommeTilbage();
                    String nextInput = scan.next();
                    if (nextInput == "q"){
                        administrerBrugere();
                    }
                case "4":
                    printSvømmehold();
                    skrivQForAtKommeTilbage();
                    String nextInput1 = scan.next();
                    if (nextInput1 == "q"){
                        administrerBrugere();
                        break;
                    }
                case "q":
                    visHovedMenu();
                    break;
                default:
                    forkertInput();
            }
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void administrerBetaling() {
       try {
            udskrivAdministrerBetaling();
            Scanner scan = new Scanner(System.in);
            String brugerInput = scan.nextLine();
            switch (brugerInput) {
                case "1":
                    //
                    break;
                case "2":
                    //
                    break;
                case "3":
                    //
                case "4":
                    setRestanceTilJa();
                    skrivQForAtKommeTilbage();
                    String nextInput1 = scan.next();
                    if (nextInput1 == "q"){
                        administrerBetaling();
                        break;
                    }
                case "5":
                    setRestanceTilNej();
                    skrivQForAtKommeTilbage();
                    String nextInput2 = scan.next();
                    if (nextInput2 == "q"){
                        administrerBetaling();
                        break;
                    }
                case "q":
                    visHovedMenu();
                    break;
                default:
                    forkertInput();
            }
        } catch(Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
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
        boolean isString;
        String input = scan.next();
        do {
            if (input.matches(".*[1-9].*")) {
                System.err.print("Fejl ved indtastning af input. Fejl: Der blev indtasted andet end bokstaver.");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SystemUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("\n" + "Prøv igen: ");
                input = scan.nextLine();
                isString = false;
            } else {
                isString = true;
            }
        } while (!(isString));
        return input;
    }

    @Override
    public int getInt(String str) {
        System.out.println(str);
        return scan.nextInt();
    }

    @Override
    public String getBoolean(String str) {
        System.out.println(str);
        return scan.next();
    }
    
    public void indtastTræningstid() throws ParseException {
        System.out.println("Indtast medlemsnummeret på konkurrenesvømmer:  ");
        int medlemsnummer = scan.nextInt();
        System.out.print("Indtast træningstid HH:MM:SS: ");
        String strTid = scan.next();
        Time tid = Time.valueOf(strTid);
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
                int gæld = 0;
                if (medlem_alder < 18) {
                    gæld = 1000;
                } else if (medlem_alder >= 18 && medlem_alder < 60) {
                    gæld = 1600;
                } else if (medlem_alder >= 60) {
                    gæld = 1200;
                } else {
                    gæld = 500;
                }

                System.out.print("Navn: " + medlems_navn);
                System.out.print(", Medlemsnummer: " + medlems_Nummer);
                System.out.print(", Skyldigt beløb : " + gæld + "\n");
        
                }

    }
    

    @Override
    public void printtrænere() throws SQLException {
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

        //Leaderboard = db.hentLeaderboardCrawl(); 
        Leaderboard = getCrawl();

        Leaderboard leaderboard1;
        for (int i = 0; i < Leaderboard.size(); i++) {
            leaderboard1 = Leaderboard.get(i);
            String disciplin = leaderboard1.getDisciplin();
            int disciplinId = leaderboard1.getDisciplinId();
            LocalTime bedsteTid = leaderboard1.getBedsteTid();
            int medlemsnummer = leaderboard1.getMedlemsnummer();
            bedsteTid = bedsteTid.minusHours(1);
            printLnsvømmetid(bedsteTid, disciplin, disciplinId, medlemsnummer);
        }
        Leaderboard = getRyg();
        Leaderboard leaderboard2;
        for (int i = 0; i < Leaderboard.size(); i++) {
            leaderboard2 = Leaderboard.get(i);
            String disciplin = leaderboard2.getDisciplin();
            int disciplinId = leaderboard2.getDisciplinId();
            LocalTime bedsteTid = leaderboard2.getBedsteTid();
            int medlemsnummer = leaderboard2.getMedlemsnummer();
            printLnsvømmetid(bedsteTid, disciplin, disciplinId, medlemsnummer);
        }
        Leaderboard = getBryst();
        Leaderboard leaderboard3;
        for (int i = 0; i < Leaderboard.size(); i++) {
            leaderboard3 = Leaderboard.get(i);
            String disciplin = leaderboard3.getDisciplin();
            int disciplinId = leaderboard3.getDisciplinId();
            LocalTime bedsteTid = leaderboard3.getBedsteTid();
            int medlemsnummer = leaderboard3.getMedlemsnummer();
            printLnsvømmetid(bedsteTid, disciplin, disciplinId, medlemsnummer);
        }
        Leaderboard = getFly();
        Leaderboard leaderboard4;
        for (int i = 0; i < Leaderboard.size(); i++) {
            leaderboard4 = Leaderboard.get(i);
            String disciplin = leaderboard4.getDisciplin();
            int disciplinId = leaderboard4.getDisciplinId();
            LocalTime bedsteTid = leaderboard4.getBedsteTid();
            bedsteTid = bedsteTid.minusHours(1);
            
            int medlemsnummer = leaderboard4.getMedlemsnummer();
            printLnsvømmetid(bedsteTid, disciplin, disciplinId, medlemsnummer);
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
    
    public void printLnsvømmetid (LocalTime bedsteTid, String disciplin, int disciplinId, int medlemsnummer) {
            System.out.print("Bedste tid:" + bedsteTid);
            System.out.print(", disciplin: " + disciplin);
            System.out.print(", disciplinID: " + disciplinId);
            System.out.print(", medlemsnummer: " + medlemsnummer + "\n");
    }
    
    public void opretMedlem() throws SQLException{
        boolean isRestance = false;
        int trænerID = 0;
        String navn = getString("Indtast medlemmes navn: ");
        int age = getInt("Indtast medlemmets alder: ");
        int telefonnummer = getInt("Indtast medlemmets telefonnummer: ");
        String restance = getBoolean("Har medlem betalt? y/n ");
        if(restance.contains("y")){
            isRestance = true;
        }
        String isKonkurrencesvømmer = getBoolean("Skal medlem være konkurrencesvømmer? y/n");
        if(isKonkurrencesvømmer.contains("y")){
            printtrænere();
            trænerID = getInt("Indtast ID på trænernen");
            Medlem medlem = new Medlem(navn, age, telefonnummer, isRestance);
            Konkurrencesvømmer konkurrencesvømmer = new Konkurrencesvømmer(navn, age , telefonnummer, isRestance, trænerID);
            db.opretKonkurrenceSvømmer(konkurrencesvømmer); 
        }
        Medlem medlem = new Medlem(navn, age, telefonnummer, isRestance);
        try {
            db.opretMedlem(medlem);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(medlem.toString());
        System.out.println("\n");
        administrerBrugere();
        }
        
        public void setRestanceTilJa() {
            int medlemsnummer = getInt("Indtast medlemmets nummer");
            db.sætMedlemRestanceJa(medlemsnummer); 
            administrerBrugere();
        }
        
        public void setRestanceTilNej() {
            int medlemsnummer = getInt("Indtast medlemmets nummer");
            db.sætMedlemRestanceNej(medlemsnummer); 
            administrerBrugere();
        }
        
        
        @Override
        public void skrivQForAtKommeTilbage() {
            System.out.println("Skriv q for at gå tilbage");
        }
        
        public void forkertInput() {
            System.err.print("Input forkert, prøv igen: ");
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
        
        public void udskrivAdministrerBetaling() {
        System.out.println("");
        System.out.println("Vælg en af følgende valgmuligheder: ");
        System.out.println("1: Tilføj ny betaling");
        System.out.println("2: Annuler abonnement");
        System.out.println("3: Udskriv medlemmere i restance");
        System.out.println("4: Tilføj restance til et medlem");
        System.out.println("5: Fjern restance fra et medlem");
        System.out.println("q: Afslut");
        }
        
    }



