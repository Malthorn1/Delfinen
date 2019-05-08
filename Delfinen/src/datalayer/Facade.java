package datalayer;

//import businesslogic.Pizza;
import businesslogic.Konkurrencesvømmer;
import businesslogic.Leaderboard;
import businesslogic.Medlem;
import businesslogic.Restance;
import businesslogic.Træner;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Casper P, Frederik, Mikkel
 */
public interface Facade {

    public void printMedlemmer() throws SQLException;

    public void opretMedlem(Medlem medlem) throws SQLException;
    
    public void opretKonkurrenceSvømmer(Konkurrencesvømmer konkurrencesvømmer) throws SQLException;

    public ArrayList<Restance> hentRestance() throws SQLException;

//    public void printLeaderboard() throws SQLException;

    public ArrayList<Konkurrencesvømmer> hentSvømmeHold() throws SQLException;

    public ArrayList<Træner> hentTrænere() throws SQLException;

    
        public ArrayList<Leaderboard> hentLeaderboardCrawl() throws SQLException;

    public ArrayList<Leaderboard> hentLeaderboardRyg() throws SQLException;

    public ArrayList<Leaderboard> hentLeaderboardBryst() throws SQLException;

    public ArrayList<Leaderboard> hentLeaderboardFly() throws SQLException;
    
    public ArrayList<Medlem> hentMedlemmer() throws SQLException ; 
}

