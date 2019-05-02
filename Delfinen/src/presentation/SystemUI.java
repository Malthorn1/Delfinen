package presentation;

import businesslogic.Medlem;
import datalayer.DBFacade;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
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
        System.out.println("q: Afslut");
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
        System.out.println("Hvor gammel er medlem? ");
        int alder = scan.nextInt();
        System.out.println("Hvad er medlemmets telefon nummer? ");
        int telefonnummer = scan.nextInt();
        System.out.println("Har brugeren betalt? y/n");
        String input = scan.nextLine();
        if(input.equals("y")){
            betalt = true;
        }else if (input.equals("n")){
        betalt = false;
        }
        System.out.println("Skal medlem være konkurrencesvømmer? y/n");
        String input2 = scan.nextLine();
        if(input2.equals("y")){
            konkurrencesvømmer = true;
            System.out.println("Indtast trænerID på den træner de skal have: ");
            int input3 = scan.nextInt();
            trænerid = input3;
        }else if(input2.equals("n")){
            konkurrencesvømmer = false;
            trænerid = 0;
        }
        Medlem medlem = new Medlem(medlemNavn, alder, telefonnummer, betalt, konkurrencesvømmer);
        
        try {
            db.opretMedlem(medlemNavn, alder, telefonnummer, betalt, konkurrencesvømmer);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(medlem.toString());
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