package datalayer;

//import businesslogic.Pizza;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

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

    public void printTrænere() throws SQLException {
        Connection connection = connector();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM TRÆNER");
            while (result.next()) {
                String træner_navn = result.getNString(2);
                int træner_id = result.getInt(1);
                System.out.print("Navn: " + træner_navn);
                System.out.print(", Medlemsnummer: " + træner_id + "\n");

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
    public void opretMedlem(String navn, int alder, int telefonnummer, boolean restance, boolean konkurrencesvømmer, int trænerid) throws SQLException {
        DBFacade db = new DBFacade();
        Connection connection = db.connector();

        try {
            Statement st = connection.createStatement();
            String sql = "INSERT INTO MEDLEMMER(NAVN, ALDER, TELEFONNUMMER, RESTANCE, DATOOPRETTET, KONKURRENCESVØMMER, træner_ID)VALUES(?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, navn);
            statement.setInt(2, alder);
            statement.setInt(3, telefonnummer);
            statement.setBoolean(4, restance);
            java.sql.Timestamp  sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
            statement.setTimestamp(5, sqlDate);
            statement.setBoolean(6, konkurrencesvømmer);
            statement.setInt(7, trænerid);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void printRestance() throws SQLException {
        Connection connection = connector();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM delfinen.medlemmer where restance = '0';");
            while (result.next()) {
                String medlems_navn = result.getNString(1);
                int medlems_Nummer = result.getInt(4); 
                int medlem_alder = result.getInt(2);
                int gæld = 0;
                if (medlem_alder < 18) {
                    gæld =1000;  
                } else if (medlem_alder >=18 && medlem_alder <60)  {
                    gæld =1600; 
                } else if (medlem_alder >=60) {
                    gæld = 1200;
                }else {
                    gæld = 500; 
                }
                
                System.out.print("Navn: " + medlems_navn);
                System.out.print(", Medlemsnummer: " + medlems_Nummer);
                System.out.print(", Skyldigt beløb : " + gæld + "\n");
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        
    }

    @Override
    public void printLeaderboard() throws SQLException {       
        Connection connection = connector();
    
        try {
            Statement statement = connection.createStatement();
            
            ResultSet crawlresult = statement.executeQuery("SELECT * FROM delfinen.MEDLEM_DISCIPLIN where disciplinID = '1' group by medlemsnummer order by bedstetid ASC LIMIT 5");
            while (crawlresult.next()) {
                int bedstetid = crawlresult.getInt(1);
                int medlems_Nummer = crawlresult.getInt(2);
                String Disciplin = crawlresult.getNString(3); 
                
                System.out.print("Disciplin: " + Disciplin );
                System.out.print(", Tid: " + bedstetid);
                System.out.print(" Medlemsnummer: " + medlems_Nummer+ "\n");

            }
            
            ResultSet rygresult = statement.executeQuery("SELECT * FROM delfinen.MEDLEM_DISCIPLIN where disciplinID = '2' group by medlemsnummer order by bedstetid ASC LIMIT 5");
            while (rygresult.next()) {
                int bedstetid = rygresult.getInt(1);
                int medlems_Nummer = rygresult.getInt(2);
                String Disciplin = rygresult.getNString(3); 
                
                        
               System.out.print("Disciplin: " + Disciplin );
                System.out.print(", Tid: " + bedstetid);
                System.out.print(" Medlemsnummer: " + medlems_Nummer+ "\n");
            }
            
            ResultSet brystresult = statement.executeQuery("SELECT * FROM delfinen.MEDLEM_DISCIPLIN where disciplinID = '3' group by medlemsnummer order by bedstetid ASC LIMIT 5");
            while (brystresult.next()) {
                int bedstetid = brystresult.getInt(1);
                int medlems_Nummer = brystresult.getInt(2);
                String Disciplin = brystresult.getNString(3); 
                
                        
               System.out.print("Disciplin: " + Disciplin );
                System.out.print(", Tid: " + bedstetid);
                System.out.print(" Medlemsnummer: " + medlems_Nummer+ "\n");
            }
            ResultSet flyresult = statement.executeQuery("SELECT * FROM delfinen.MEDLEM_DISCIPLIN where disciplinID = '4' group by medlemsnummer order by bedstetid ASC LIMIT 5");
                while (flyresult.next()) {
                int bedstetid = flyresult.getInt(1);
                int medlems_Nummer = flyresult.getInt(2);
                String Disciplin = flyresult.getNString(3); 
                
                        
               System.out.print("Disciplin: " + Disciplin );
                System.out.print(", Tid: " + bedstetid);
                System.out.print(" Medlemsnummer: " + medlems_Nummer+ "\n");
            }
        } catch (SQLException e) {
            System.out.println(e);

        }

    }

    @Override
    public void PrintSvømmeHold() throws SQLException {
          Connection connection = connector();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM delfinen.medlemmer where KONKURRENCESVØMMER = '1' order by alder asc;");
            while (result.next()) {
                String medlems_navn = result.getNString(1);
                int medlems_Nummer = result.getInt(4); 
                int medlem_alder = result.getInt(2);
                String Hold =""; 
                if (medlem_alder < 18) {
                    Hold ="U18";  
                } else if (medlem_alder >=18)  {
                    Hold ="VoksenHold"; 
                }
                
                
                System.out.print("Navn: " + medlems_navn);
                System.out.print(", Medlemsnummer: " + medlems_Nummer);
                System.out.print(", Svømmehold: " + Hold + "\n");
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        
        
        
    }

}
    
/*
try {
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from aktiveordrer");
        if (rs.next()) {
            String navn = rs.getString("NAVN");
            int alder = rs.getInt("ALDER");
            int telefonnummer = rs.getInt("TELEFONNUMMER");
            //Vi springer første medlemsnummeret over da den er sat til AUTO_INCREMENT i SQL.
            Timestamp DATOOPRETTET = rs.getTimestamp("DATOOPRETTET");
            boolean betalt = rs.getBoolean("BETALT");
            boolean konkurrencesvømmer = rs.getBoolean("KONKURRENCESVØMMER");
            String træner = rs.getString("TRÆNER");
            String sql = "INSERT INTO MEDLEMMER(NAVN, ALDER, TELEFONNUMMER, DATOOPRETTET, BETALT, KONKURRENCESVØMMER, TRÆNER)VALUES(?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,navn);
            statement.setInt(2, alder);
            statement.setTimestamp(3, DATOOPRETTET);
            statement.setBoolean(4, betalt);
            statement.setBoolean(5, konkurrencesvømmer);
            statement.setString(6, træner);
        } 
*/
