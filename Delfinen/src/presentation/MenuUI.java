/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import businesslogic.Medlem;
import datalayer.DBFacade;
import datalayer.Facade;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentation.UI;

/**
 *
 * @author Malthorn
 */
public class MenuUI {
    SystemUI ui = new SystemUI();
    
    
    public void start() throws SQLException {
        Scanner scan = new Scanner(System.in);
        boolean quite = false;
        ui.visHovedMenu();
        do {
            String brugerInput = ui.hovedMenuValg();
            switch (brugerInput) {
                case "1":
                    administrerBrugere();
                    break;
                case "2":
                    administrerBetaling();
                    break;
                case "3":
                    ui.printLeaderboard();
                    ui.skrivQForAtKommeTilbage();
                    start(); 
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
                    System.err.print("Input forkert, prøv igen: \n ");
            }
        } while (!quite);

    }
    
    public void administrerBetaling() {
        try {
            ui.udskrivAdministrerBetaling();
            Scanner scan = new Scanner(System.in);
            String brugerInput = scan.nextLine();
            switch (brugerInput) {
                case "1":
                    ui.annulerAbonnement();
                    administrerBetaling();
                    break;
                case "2":
                    ui.printRestance();
                    ui.skrivQForAtKommeTilbage();
                    administrerBetaling();
                    break;
                case "3":
                    ui.setRestanceTilJa();
                    administrerBetaling();
                    break;
                case "4":
                    ui.setRestanceTilNej();
                    administrerBetaling();
                    break;
                case "5":
                    ui.setPassivTilJa();
                    administrerBetaling();
                    break;
                case "6":
                    ui.setPassivTilNej();
                    administrerBetaling();
                    break;
                case "q":
                    ui.visHovedMenu();
                    start(); 
                    break;
                default:
                    ui.forkertInput();
            }
        } catch (Exception e) {
            System.err.println("Fejl ved input. Retunerer tilbage til menu.");
            System.err.println("Fejl: "+e.getMessage());
            try {
                TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException ex) {
                Logger.getLogger(SystemUI.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
    public void redigerBruger() {
        try {
            ui.udskrivRedigerBruger();
            Scanner scan = new Scanner(System.in);
            String brugerInput = scan.nextLine();
            switch (brugerInput) {
                case "1":
                    ui.redigerTelefonnummer();
                    start();
                    break;
                case "2":
                    ui.setKonkurrenceSvømmerJa();
                    start();
                    break;
                case "3":
                    ui.setKonkurrenceSvømmerNej();
                    start();
                case "4":
                    ui.redigerNavn();
                    start();
                    break;
                case "q":
                    start();
                    break;
                default:
                    ui.forkertInput();
            }
        } catch (Exception e) {
            System.err.println("Fejl ved input. Retunerer tilbage til menu.");
            System.err.println("Fejl: "+e.getMessage());
            try {
                TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException ex) {
                Logger.getLogger(SystemUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            redigerBruger();
        }
        }
    
    
    
    public void administrerBrugere() {
        try {
            ui.udskrivAdministrerBrugere();
            
            Scanner scan = new Scanner(System.in);
            String brugerInput = scan.next();
            switch (brugerInput) {
                case "1":
                    ui.opretMedlem();
                    administrerBrugere();
                    break;
                case "2":
                    ui.redigerBruger();
                    break;
                case "3":
                    ui.printTrænere();
                    ui.skrivQForAtKommeTilbage();
                    administrerBrugere();
                    break;
                case "4":
                    ui.printSvømmehold();
                     ui.skrivQForAtKommeTilbage();
                    administrerBrugere();
                    break;
                case "q":
                     start();
                    break;
                default:
                     ui.forkertInput();
            }
        } catch (Exception e) {
            System.err.println("Fejl ved input. Retunerer tilbage til menu.");
            System.err.println("Fejl: "+e.getMessage());
            try {
                TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException ex) {
                Logger.getLogger(SystemUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            administrerBrugere();
        }
    }
    
    

}
