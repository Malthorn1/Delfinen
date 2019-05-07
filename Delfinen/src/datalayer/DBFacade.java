package datalayer;

//import businesslogic.Pizza;
import businesslogic.Konkurrencesvømmer;
import businesslogic.Leaderboard;
import businesslogic.Medlem;
import businesslogic.Træner;
import businesslogic.Restance;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;


public class DBFacade implements Facade {

    public Connection connector() {
        Connection connection = null;
        try {
            String user = "root";
            String password = "frb150195";
            String IP = "localhost";
            String PORT = "3306";
            String DATABASE = "delfinen";
            String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE
                    + "?useUnicode=true&useJDBCcompliantTimezoneShift=true&"
                    + "useLegacyDatetimeCode=false&"
                    + "serverTimezone=UTC";

            connection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
        }
        //Returnerer en connection vi kan bruge hver gang vi laver et metode kald
        return connection;
    }

    @Override
    public void printMedlemmer() throws SQLException {
        Connection connection = connector();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM MEDLEMMER");
            while (result.next()) {
                String navn = result.getNString(1);
                int alder = result.getInt(2);
                int telefonnummer = result.getInt(3);
                int medlemsnummer = result.getInt(4);
                System.out.print("Navn: " + navn);
                System.out.print(", Alder: " + alder);
                System.out.print(", Telefonnummer: " + telefonnummer);
                System.out.print(", Medlemsnummer: " + medlemsnummer + "\n");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }



    /*
    opretMedlem metoden tager variablerne fra et medlemsobjekt som argument,
    og bruger herefter disse variabler i prepared statements
     */
    @Override
    public void opretMedlem(Medlem medlem) throws SQLException {
        DBFacade db = new DBFacade();
        Connection connection = db.connector();

        try {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO MEDLEMMER(NAVN, ALDER, TELEFONNUMMER, RESTANCE, DATOOPRETTET, KONKURRENCESVØMMER, passiv)VALUES(?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, medlem.getNavn());
            statement.setInt(2, medlem.getAge());
            statement.setInt(3, medlem.getTelefonnummer());
            statement.setBoolean(4, medlem.isRestance());
            java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
            statement.setTimestamp(5, sqlDate);
            statement.setBoolean(6, medlem.isKonkurrencesvømmer());
            statement.setBoolean (7, false);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void opretKonkurrenceSvømmer(Konkurrencesvømmer konkurrencesvømmer) throws SQLException {
        DBFacade db = new DBFacade();
        Connection connection = db.connector();

        try {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO MEDLEMMER(NAVN, ALDER, TELEFONNUMMER, RESTANCE, DATOOPRETTET, KONKURRENCESVØMMER, træner_ID)VALUES(?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, konkurrencesvømmer.getNavn());
            statement.setInt(2, konkurrencesvømmer.getAge());
            statement.setInt(3, konkurrencesvømmer.getTelefonnummer());
            statement.setBoolean(4, konkurrencesvømmer.isRestance());
            java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
            statement.setTimestamp(5, sqlDate);
            statement.setBoolean(6, true);
            statement.setInt(7, konkurrencesvømmer.getTrænerID());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
        public ArrayList<Restance> hentRestance() throws SQLException {
            Connection connection = connector();
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
    public  ArrayList<Konkurrencesvømmer> hentSvømmeHold() throws SQLException {
        Connection connection = connector();
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
    
        public ArrayList<Træner> hentTrænere() throws SQLException {
        Connection connection = connector();
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
        Connection connection = connector();
        ArrayList<Leaderboard> leaderboards = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM delfinen.MEDLEM_DISCIPLIN where disciplin = 'crawl' group by medlemsnummer order by tid ASC LIMIT 5");
            while (result.next()) {
                String disciplin = result.getNString(3);
                Time tid = result.getTime(1); 
                LocalTime bedsteTid = tid.toLocalTime();
                int medlemsNummer = result.getInt(2);
                Leaderboard leaderboard1 = new Leaderboard(bedsteTid, medlemsNummer, disciplin);
                
                leaderboards.add(leaderboard1); 
                
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return leaderboards;

}

    @Override
    public ArrayList<Leaderboard> hentLeaderboardRyg() throws SQLException {
        Connection connection = connector();
        ArrayList<Leaderboard> leaderboards = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM delfinen.MEDLEM_DISCIPLIN where disciplin = 'Rygcrawl' group by medlemsnummer order by tid ASC LIMIT 5");
            while (result.next()) {
                String disciplin = result.getNString(3);
                Time tid = result.getTime(1); 
                LocalTime bedsteTid = tid.toLocalTime();
                int medlemsNummer = result.getInt(2);
                Leaderboard leaderboard1 = new Leaderboard(bedsteTid, medlemsNummer, disciplin);
                
                leaderboards.add(leaderboard1); 
                
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return leaderboards;

    }

    @Override
    public ArrayList<Leaderboard> hentLeaderboardBryst() throws SQLException {
        Connection connection = connector();
        ArrayList<Leaderboard> leaderboards = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM delfinen.MEDLEM_DISCIPLIN where disciplin = 'Bryst' group by medlemsnummer order by tid ASC LIMIT 5");
            while (result.next()) {
                String disciplin = result.getNString(3);
                Time tid = result.getTime(1); 
                LocalTime bedsteTid = tid.toLocalTime();
                int medlemsNummer = result.getInt(2);
                Leaderboard leaderboard1 = new Leaderboard(bedsteTid, medlemsNummer, disciplin);
                
                leaderboards.add(leaderboard1); 
                
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return leaderboards;

    }

    @Override
    public ArrayList<Leaderboard> hentLeaderboardFly() throws SQLException {
        Connection connection = connector();
        ArrayList<Leaderboard> leaderboards = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM delfinen.MEDLEM_DISCIPLIN where disciplin = 'butterfly' group by medlemsnummer order by tid ASC LIMIT 5");
            while (result.next()) {
                String disciplin = result.getNString(3);
                Time tid = result.getTime(1); 
                LocalTime bedsteTid = tid.toLocalTime();
                int medlemsNummer = result.getInt(2);
                Leaderboard leaderboard1 = new Leaderboard(bedsteTid, medlemsNummer, disciplin);
                
                leaderboards.add(leaderboard1); 
                
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return leaderboards;

    }
        
    public void indtastTræningstid(int medlemsnummer, Time tid, String disciplin) {

        Connection connection = connector();

        try {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO MEDLEM_DISCIPLIN(MEDLEMSNUMMER, TID, DISCIPLIN)VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, medlemsnummer);
            statement.setTime(2, tid);
            statement.setString(3, disciplin);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void sætMedlemRestanceJa(int medlemsnummer) {
        Connection connection = connector();
        try{
            Statement st = connection.createStatement();
            String query = "update medlemmer set RESTANCE = ? where MEDLEMSNUMMER = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(2, medlemsnummer);
            statement.setBoolean(1, true);
            statement.executeUpdate();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    
    public void sætMedlemRestanceNej(int medlemsnummer) {
        Connection connection = connector();
        try{
            Statement st = connection.createStatement();
            String query = "update medlemmer set RESTANCE = ? where MEDLEMSNUMMER = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(2, medlemsnummer);
            statement.setBoolean(1, false);
            statement.executeUpdate();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    
        public void sætMedlemPassivJa(int medlemsnummer) {
        Connection connection = connector();
        try{
            Statement st = connection.createStatement();
            String query = "update medlemmer set PASSIV = ? where MEDLEMSNUMMER = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(2, medlemsnummer);
            statement.setBoolean(1, true);
            statement.executeUpdate();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
        
        public void sætMedlemPassivNej(int medlemsnummer) {
        Connection connection = connector();
        try{
            Statement st = connection.createStatement();
            String query = "update medlemmer set PASSIV = ? where MEDLEMSNUMMER = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(2, medlemsnummer);
            statement.setBoolean(1, false);
            statement.executeUpdate();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}