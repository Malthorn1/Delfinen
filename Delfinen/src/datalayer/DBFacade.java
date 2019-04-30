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
            String password = "rootprejler";
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
        try{
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM MEDLEMMER");
        while (result.next()) {
            String navn = result.getNString(1);
            int alder = result.getInt(2);
            int telefonnummer = result.getInt(3);
            int medlemsnummer = result.getInt(4);
            System.out.print(alder + " ");
            System.out.print(navn + " ");
            System.out.print(telefonnummer + " ");
            System.out.print(medlemsnummer + "\n");
        }
        }catch(SQLException e){
                        System.out.println(e);
                }
    }
    
    @Override
    public void opretBruger() throws SQLException {
    DBFacade db = new DBFacade();
    Connection connection = db.connector();
    
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
    } catch (SQLException e) {
            System.out.println(e);
        }
}
    
}