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
        System.out.println("Indtast medlemmes navn: ");
        Scanner scan = new Scanner(System.in);
        String medlemNavn = scan.nextLine();
        System.out.println("Hvor gammel er medlem? ");
        int alder = scan.nextInt();
        System.out.println("Hvad er medlemmets telefon nummer? ");
        int telefonnummer = scan.nextInt();
        System.out.println("Har brugeren betalt? y/n");
        String input = scan.nextLine();
        if(input.contains("y")){
            betalt = true;
        }else if (input.contains("n")){
        betalt = false;
        }
        Medlem medlem = new Medlem(medlemNavn, alder, telefonnummer, betalt);
        
        try {
            db.opretMedlem(medlemNavn, alder, telefonnummer, betalt);
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