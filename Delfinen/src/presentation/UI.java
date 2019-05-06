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
    
    public void opretMedlem();
    
    public void restance(); 
    public void printSvømmehold() throws SQLException;

    public String getString(String str);

    public int getInt(String str);

    public String getBoolean(String str);
    
    public void printtrænere() throws SQLException;
    
    public void printLeaderboard() throws SQLException; 
}
