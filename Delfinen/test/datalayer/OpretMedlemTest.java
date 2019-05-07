
package datalayer;

import businesslogic.Medlem;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prejl
 */
public class OpretMedlemTest {
    
    MockFacade db = new MockFacade();
    @Test
    public void testOpretMedlem() throws SQLException{
        Medlem medlem = new Medlem("Casper", 25, 42588508,false);
        
        db.opretMedlem(medlem);
        
        assertTrue(db.database.size()==1);
        
        
    }
    
    
}
