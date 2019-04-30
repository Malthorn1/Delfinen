package presentation;


import java.sql.SQLException;

/**
 *
 * @author Casper P, Frederik, Mikkel
 */


public interface UI {

    public void visHovedMenu();

    public String hovedMenuValg(); 
    
    public void administrerBrugere();
    
    public void administrerBetaling();
    
    public void opretBrugerDB();
    
}
