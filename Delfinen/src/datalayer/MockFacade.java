
package datalayer;

import businesslogic.Konkurrencesvømmer;
import businesslogic.Leaderboard;
import businesslogic.Medlem;
import businesslogic.Restance;
import businesslogic.Træner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author prejl
 */
public class MockFacade implements Facade {
    
    public ArrayList<Medlem> database = new ArrayList();
    DBFacade db = new DBFacade();

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
        database.add(konkurrencesvømmer);
    }

    @Override
    public ArrayList<Restance> hentRestance() throws SQLException {
        Connection connection = db.connector();
            ArrayList<Restance> restance1 = new ArrayList();
            try {
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM delfinen.medlemmer where restance = '0';");
                while (result.next()) {
                    String medlems_navn = result.getNString(1);
                    int medlems_Nummer = result.getInt(4);
                    int medlem_alder = result.getInt(2);
                    int gæld = 0;
                    if (medlem_alder < 18) {
                    gæld = 1000;
                } else if (medlem_alder >= 18 && medlem_alder < 60) {
                    gæld = 1600;
                } else if (medlem_alder >= 60) {
                    gæld = 1200;
                } else {
                    gæld = 500;
                }
                    Restance restance = new Restance(medlems_navn, medlems_Nummer, medlem_alder);
                    restance1.add(restance);
                }
            }catch (SQLException e) {
            System.out.println(e);
        }
            return restance1;
        }

    @Override
    public ArrayList<Konkurrencesvømmer> hentSvømmeHold() throws SQLException {
        Connection connection = db.connector();
        ArrayList<Konkurrencesvømmer> svømmehold = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM delfinen.medlemmer where KONKURRENCESVØMMER = '1' order by alder asc;");
            while (result.next()) {
                String medlemsNavn = result.getNString(1);
                int alder = result.getInt(2);
                int telefonnummer = result.getInt(3);
                int medlemsNummer = result.getInt(4);
                Timestamp datoprettet = result.getTimestamp(5);
                boolean restance = result.getBoolean(6);
                boolean isKonkurrencesvømmer = result.getBoolean(7);
                int trænerid = result.getInt(8);
                
                Konkurrencesvømmer konkurrencesvømmer = new Konkurrencesvømmer (medlemsNavn, alder, telefonnummer, restance, trænerid);
                konkurrencesvømmer.setMedlemsnummer(medlemsNummer);
                svømmehold.add(konkurrencesvømmer);
                
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return svømmehold;
    }

    @Override
    public ArrayList<Træner> hentTrænere() throws SQLException {
        Connection connection = db.connector();
        ArrayList<Træner> trænere = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM TRÆNER");
            while (result.next()) {
                String træner_navn = result.getNString(2);
                int træner_id = result.getInt(1);
                Træner træner = new Træner(træner_navn, træner_id);
                
                trænere.add(træner);
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return trænere;
    }

    @Override
    public ArrayList<Leaderboard> hentLeaderboardCrawl() throws SQLException {
        Connection connection = db.connector();
        ArrayList<Leaderboard> leaderboards = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM delfinen.MEDLEM_DISCIPLIN where disciplinID = '1' group by medlemsnummer order by tid ASC LIMIT 5");
            while (result.next()) {
                String disciplin = result.getNString(3);
                Time tid = result.getTime(1);
                LocalTime bedsteTid = tid.toLocalTime();
                int medlemsNummer = result.getInt(2);
                int disciplinId = result.getInt(4);
                Leaderboard leaderboard1 = new Leaderboard(bedsteTid, medlemsNummer, disciplin, disciplinId);

                leaderboards.add(leaderboard1);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return leaderboards;

    }

    @Override
    public ArrayList<Leaderboard> hentLeaderboardRyg() throws SQLException {
        Connection connection = db.connector();
        ArrayList<Leaderboard> leaderboards = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM delfinen.MEDLEM_DISCIPLIN where disciplinID = '2' group by medlemsnummer order by tid ASC LIMIT 5");
            while (result.next()) {
                String disciplin = result.getNString(3);
                Time tid = result.getTime(1);
                LocalTime bedsteTid = tid.toLocalTime();
                int medlemsNummer = result.getInt(2);
                int disciplinId = result.getInt(4);
                Leaderboard leaderboard1 = new Leaderboard(bedsteTid, medlemsNummer, disciplin, disciplinId);

                leaderboards.add(leaderboard1);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return leaderboards;

    }

    @Override
    public ArrayList<Leaderboard> hentLeaderboardBryst() throws SQLException {
        Connection connection = db.connector();
        ArrayList<Leaderboard> leaderboards = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM delfinen.MEDLEM_DISCIPLIN where disciplinID = '3' group by medlemsnummer order by tid ASC LIMIT 5");
            while (result.next()) {
                String disciplin = result.getNString(3);
                Time tid = result.getTime(1);
                LocalTime bedsteTid = tid.toLocalTime();
                int medlemsNummer = result.getInt(2);
                int disciplinId = result.getInt(4);
                Leaderboard leaderboard1 = new Leaderboard(bedsteTid, medlemsNummer, disciplin, disciplinId);

                leaderboards.add(leaderboard1);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return leaderboards;
    }

    @Override
    public ArrayList<Leaderboard> hentLeaderboardFly() throws SQLException {
        Connection connection = db.connector();
        ArrayList<Leaderboard> leaderboards = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM delfinen.MEDLEM_DISCIPLIN where disciplinID = '4' group by medlemsnummer order by tid ASC LIMIT 5");
            while (result.next()) {
                String disciplin = result.getNString(3);
                Time tid = result.getTime(1);
                LocalTime bedsteTid = tid.toLocalTime();
                int medlemsNummer = result.getInt(2);
                int disciplinId = result.getInt(4);
                Leaderboard leaderboard1 = new Leaderboard(bedsteTid, medlemsNummer, disciplin,);

                leaderboards.add(leaderboard1);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return leaderboards;
    }

    

    
}
