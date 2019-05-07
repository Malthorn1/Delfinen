package presentation;

import businesslogic.Controller;
import businesslogic.Leaderboard;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Casper P, Frederik, Mikkel
 */
public interface UI {

    public void visHovedMenu();

    public String hovedMenuValg();

    public void administrerBrugere();

    public void administrerBetaling();

    public void printSvømmehold() throws SQLException;

    public String getString(String str);

    public int getInt(String str);

    public String getBoolean(String str);

    public void printTrænere() throws SQLException;

    public void printLeaderboard() throws SQLException;
    
    public void printRestance() throws SQLException;

    public ArrayList<Leaderboard> getCrawl() throws SQLException;

    public ArrayList<Leaderboard> getRyg() throws SQLException;

    public ArrayList<Leaderboard> getBryst() throws SQLException;

    public ArrayList<Leaderboard> getFly() throws SQLException;
    
    public void opretMedlem() throws SQLException;
    
    public void skrivQForAtKommeTilbage();
    
    public void indtastTræningstid();
}
