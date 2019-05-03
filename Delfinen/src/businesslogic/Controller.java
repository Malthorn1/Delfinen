package businesslogic;

import datalayer.DBFacade;
import datalayer.Facade;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import presentation.UI;


/**
 *
 * @author Casper P, Frederik, Mikkel
 */

public class Controller {
    DBFacade db = new DBFacade();
    private Facade facade;
    private UI ui;
    private ArrayList<Medlem> medlemmer;
    public Controller(){
        //tom controller
    }
    public Controller(UI ui, ArrayList<Medlem> medlemmer) {
        this.facade=facade;
        this.ui = ui;
        medlemmer = new ArrayList<Medlem>();
    }

    public void start() {
        boolean quite = false;
        ui.visHovedMenu();
        do {
            String brugerInput = ui.hovedMenuValg();
            switch (brugerInput) {
                case "1":
                    administrerBrugere();
                    break;
                case "2":
                    //opretBestilling();
                    break;
                case "3":
                    //redigerBestilling();
                    break;
                case "4":
                    //visAktiveOrdrer();
                    break;
                case "5":
                    //visOrdreHistorik();
                    break;
                case "q":
                    Runtime.getRuntime().exit(0);
                    break;
                default:
                    System.err.print("Input forkert, prøv igen: ");
            }
        } while (!quite);

    }

    
    public void opretMedlem(){
        boolean isKonkurrencesvømmer = false;
        boolean isRestance = false;
        int trænerID = 0;
        String navn = ui.getString("Indtast medlemmes navn: ");
        int age = ui.getInt("Indtast medlemmets alder: ");
        int telefonnummer = ui.getInt("Indtast medlemmets telefonnummer: ");
        String restance = ui.getBoolean("Har medlem betalt? y/n ");
        if(restance.contains("y")){
            isRestance = true;
        }
        String konkurrencesvømmer = ui.getBoolean("Skal medlem være konkurrencesvømmer? y/n");
        if(konkurrencesvømmer.contains("y")){
            trænerID = ui.getInt("Indtast ID på trænernen");
            isKonkurrencesvømmer = true;
        }
        
        
        Medlem medlem = new Medlem(navn, age, telefonnummer, isRestance, isKonkurrencesvømmer);

        try {
            db.opretMedlem(medlem, trænerID);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(medlem.toString());
        System.out.println("\n");
        ui.administrerBrugere();
    }

    
    public void administrerBrugere() {
          int brugerInput =  ui.getInt(" \n" + "vælg en af følgende valgmuligheder: " + "\n 1: Opret bruger" + "\n 2: Rediger bruger" + "\n q: Tryk q for at gå tilbage") ;
//        System.out.println("");
//        System.out.println("Vælg en af følgende valgmuligheder: ");
//        System.out.println("1: Opret bruger");
//        System.out.println("2: Rediger bruger");
//        System.out.println("q: Tryk q for at gå tilbage");
        switch (brugerInput) {
            case 1:
                opretMedlem();
                break;
            case 2:
                //
                break;
            case 3:
                ui.visHovedMenu();
                break;
            default:
                System.err.print("Input forkert, prøv igen: ");
        }
    }
}
