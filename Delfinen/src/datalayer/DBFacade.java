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
            String DATABASE = "mario";
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
    }
    
}