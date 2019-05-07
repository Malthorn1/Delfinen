
package datalayer;

import businesslogic.Konkurrencesvømmer;
import businesslogic.Leaderboard;
import businesslogic.Medlem;
import businesslogic.Restance;
import businesslogic.Træner;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author prejl
 */
public class MockFacade implements Facade {
    
    public ArrayList<Medlem> database = new ArrayList();

    @Override
    public void printMedlemmer() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void opretMedlem(Medlem medlem) throws SQLException {
        database.add(medlem);
        
    }

    @Override
    public void opretKonkurrenceSvømmer(Konkurrencesvømmer konkurrencesvømmer) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Restance> hentRestance() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Konkurrencesvømmer> hentSvømmeHold() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Træner> hentTrænere() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Leaderboard> hentLeaderboardCrawl() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Leaderboard> hentLeaderboardRyg() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Leaderboard> hentLeaderboardBryst() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Leaderboard> hentLeaderboardFly() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
