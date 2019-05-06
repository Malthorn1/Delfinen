package datalayer;

//import businesslogic.Pizza;
import businesslogic.Leaderboard;
import businesslogic.Medlem;
import businesslogic.Træner;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Casper P, Frederik, Mikkel
 */
public interface Facade {

    public void printMedlemmer() throws SQLException;

    public void opretMedlem(Medlem medlem, int trænerid) throws SQLException;

    public void printRestance() throws SQLException;

    public void printLeaderboard() throws SQLException;

    public ArrayList<Medlem> hentSvømmeHold() throws SQLException;

    public ArrayList<Træner> hentTrænere() throws SQLException;
    
    public ArrayList<Leaderboard> hentLeaderboard () throws SQLException; 
}
