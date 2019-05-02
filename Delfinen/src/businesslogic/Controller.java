package businesslogic;

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
    private Facade facade;
    private UI ui;
    private ArrayList<Medlem> medlemmer;
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
                    opretMedlem();
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
        ui.opretMedlem();
    }

}
