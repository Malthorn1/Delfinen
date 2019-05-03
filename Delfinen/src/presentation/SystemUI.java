package presentation;

import businesslogic.Controller;
import businesslogic.Medlem;
import datalayer.DBFacade;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
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
    Controller ctrl = new Controller();
    

    @Override
    public void visHovedMenu() {
        System.out.println("");
        System.out.println("Vælg en af følgende valgmuligheder: ");
        System.out.println("1: Administrer brugere");
        System.out.println("2: Administrer betaling");
        System.out.println("q: Afslut");
    }

    @Override
    public String hovedMenuValg() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    @Override
    public void administrerBrugere() {
        System.out.println("");
        System.out.println("Vælg en af følgende valgmuligheder: ");
        System.out.println("1: Opret bruger");
        System.out.println("2: Rediger bruger");
        System.out.println("q: Tryk q for at gå tilbage");
        Scanner scan = new Scanner(System.in);
        String brugerInput = scan.nextLine();
        switch (brugerInput) {
            case "1":
                ctrl.opretMedlem();
                break;
            case "2":
                //
                break;
            case "q":
                visHovedMenu();
                break;
            default:
                System.err.print("Input forkert, prøv igen: ");
        }
    }

    @Override
    public void administrerBetaling() {
        System.out.println("");
        System.out.println("Vælg en af følgende valgmuligheder: ");
        System.out.println("1: Tilføj ny betaling");
        System.out.println("2: Annuler abonnement");
        System.out.println("q: Afslut");
    }

    /*
    Metoden laver et medlemsobjekt med variabler fra scanner input. 
    Herefter opretter vi på samme tid medlemmet i databasen som tager scanner variablerne som argumenter. 
    
     */
    @Override
    public void opretMedlem() {
//        DBFacade db = new DBFacade();
//        boolean betalt = false;
//        boolean konkurrencesvømmer = false;
//        int trænerid = 0;
//        
//        
//        boolean isNumber;
//        do {
//            System.out.println("Hvor gammel er medlem? ");
//            if () {
//                System.err.print("Fejl ved indtastning af alder. Fejl: Der blev indtasted andet end tal.");
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(SystemUI.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                alder = scan.nextInt();
//                isNumber = false;
//            } else {
//                isNumber = true;
//            }
//        } while (!(isNumber));
//
//        System.out.println("Hvad er medlemmets telefon nummer? ");
//        int telefonnummer = scan.nextInt();
//        System.out.println("Har brugeren betalt? y/n");
//        String input = scan.next();
//
//        if (input.equals("y")) {
//            betalt = true;
//        } else if (input.equals("n")) {
//            betalt = false;
//        }
//
//        System.out.println("Skal medlem være konkurrencesvømmer? y/n");
//        String input2 = scan.next();
//        if (input2.equals("y")) {
//            konkurrencesvømmer = true;
//            try {
//                db.printTrænere();
//            } catch (SQLException ex) {
//                Logger.getLogger(SystemUI.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            System.out.println("Indtast trænerID på den træner de skal have: ");
//
//            int input3 = scan.nextInt();
//            trænerid = input3;
//        } else if (input2.equals("n")) {
//            konkurrencesvømmer = false;
//            trænerid = 0;
//        }
//        Medlem medlem = new Medlem(medlemNavn, alder, telefonnummer, betalt, konkurrencesvømmer);
//
//        try {
//            db.opretMedlem(medlem, trænerid);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        System.out.println(medlem.toString());
//        System.out.println("\n");
//        administrerBrugere();
//
//    }
//
//    
//

//
    }

    @Override
    public void printSvømmehold() throws SQLException {
        ArrayList<Medlem> svømmehold = new ArrayList();
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

    @Override
    public void restance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
