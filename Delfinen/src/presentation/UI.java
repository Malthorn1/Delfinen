package presentation;

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

    public void opretMedlem();

    public void restance();

    public void printSvømmehold() throws SQLException;

    public String getString(String str);

    public int getInt(String str);

    public String getBoolean(String str);

    public void printtrænere() throws SQLException;

    public void printLeaderboard() throws SQLException;

    public ArrayList<Leaderboard> getCrawl() throws SQLException;

    public ArrayList<Leaderboard> getRyg() throws SQLException;

    public ArrayList<Leaderboard> getBryst() throws SQLException;

    public ArrayList<Leaderboard> getFly() throws SQLException;
}
