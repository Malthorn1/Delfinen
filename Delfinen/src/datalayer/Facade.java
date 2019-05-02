package datalayer;

//import businesslogic.Pizza;
import java.sql.SQLException;

/**
 *
 * @author Casper P, Frederik, Mikkel
 */
public interface Facade {
    
     public void printMedlemmer() throws SQLException;
     
     public void opretMedlem(String navn, int alder, int telefonnummer, boolean restance, boolean konkurrencesvømmer) throws SQLException;
     
     public void printRestance() throws SQLException; 
     
    public void printLeaderboard() throws SQLException; 
    
    public void PrintSvømmeHold() throws SQLException;
}
