package datalayer;

import businesslogic.Træner;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prejl
 */
public class HentTrænereTest {
    
    MockFacade db = new MockFacade();
    @Test
    public void testHentRestance() throws SQLException{
        ArrayList<Træner> trænere = db.hentTrænere();
        assertFalse(trænere.isEmpty());
        
        //Denne test fejler hvis man ikke har en connection
    }
}
