package presentation;

import datalayer.DBFacade;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;


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
        System.out.println("2: Slet bruger");
        System.out.println("3: Rediger bruger");
        System.out.println("q: Afslut");
    }
    
    @Override
    public void administrerBetaling() {
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



}
