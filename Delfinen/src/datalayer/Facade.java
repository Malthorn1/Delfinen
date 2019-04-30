package datalayer;

//import businesslogic.Pizza;
import java.sql.SQLException;

/**
 *
 * @author Casper P, Frederik, Mikkel
 */
public interface Facade {
    
     public void printMedlemmer() throws SQLException;
     
     public void opretMedlem(String navn, int alder, int telefonnummer, boolean betalt) throws SQLException;
    
}
