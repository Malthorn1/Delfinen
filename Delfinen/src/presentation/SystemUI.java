package presentation;

import businesslogic.Medlem;
import datalayer.DBFacade;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Casper P, Frederik, Mikkel
 */
public class SystemUI implements UI {


    @Override
    public void visHovedMenu() {
        System.out.println("");
        System.out.println("Vælg en af følgende valgmuligheder: ");
        System.out.println("1: Administrer brugere");
        System.out.println("2: Administrer betaling");
        System.out.println("q: Afslut");
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
        switch(brugerInput){
            case "1":
                opretMedlem();
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
        DBFacade db = new DBFacade();
        boolean betalt = false;
        boolean konkurrencesvømmer = false;
        int trænerid = 0;
        System.out.println("Indtast medlemmes navn: ");
        Scanner scan = new Scanner(System.in);
        String medlemNavn = scan.nextLine();
            boolean isString;
            do {
                if (medlemNavn.matches(".*[1-9].*")) {
                    System.err.print("Fejl ved indtastning af navn. Fejl: Der blev indtasted andet end bokstaver.");
                    try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(SystemUI.class.getName()).log(Level.SEVERE, null, ex);
            }
                    System.out.println("\n" + "Indtast medlemmes navn: "); 
                    medlemNavn = scan.nextLine();
                isString = false;
            }else { 
                    isString = true;
                    }
            } while (!(isString));
            System.out.println("");
        
        System.out.println("Hvor gammel er medlem? ");
        int alder = scan.nextInt();
//        boolean isNumber;
//        do {
//            System.out.println("Hvor gammel er medlem? ");
//            if (alder.nextInt()) {
//                alder = scan.nextInt();
//                isNumber = true;
//            } else {
//                System.err.print("Fejl ved indtastning af alder. Fejl: Der blev indtasted andet end tal.");
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(SystemUI.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                isNumber = false;
//            }
//        } while (!(isNumber));
        
        System.out.println("Hvad er medlemmets telefon nummer? ");
        int telefonnummer = scan.nextInt();
        
        System.out.println("Har brugeren betalt? y/n");
        String input = scan.next();
        if(input.equals("y")){
            betalt = true;
        }else if (input.equals("n")){
        betalt = false;
        }
        
        System.out.println("Skal medlem være konkurrencesvømmer? y/n");
        String input2 = scan.next();
        if(input2.equals("y")){
            konkurrencesvømmer = true;
            try {
                db.printTrænere();
            } catch (SQLException ex) {
                Logger.getLogger(SystemUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Indtast trænerID på den træner de skal have: ");
            
            int input3 = scan.nextInt();
            trænerid = input3;
        }else if(input2.equals("n")){
            konkurrencesvømmer = false;
            trænerid = 0;
        }
        Medlem medlem = new Medlem(medlemNavn, alder, telefonnummer, betalt, konkurrencesvømmer);
        
        try {
            db.opretMedlem(medlem, trænerid);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(medlem.toString());
        System.out.println("\n");
        administrerBrugere();
        
        }
        
    @Override
    public String hovedMenuValg() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    
 


    public String getQ() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if (input.equals("q")) {
            visHovedMenu();
        } else if (input != "q") {
            System.err.print("Input forkert, prøv igen: ");
            return getQ();
        }
        return "";
    }

    @Override
    public void restance() {
        
        
        
        
    }
    
}