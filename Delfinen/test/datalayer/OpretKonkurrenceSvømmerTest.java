/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer;

import businesslogic.Konkurrencesvømmer;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prejl
 */
public class OpretKonkurrenceSvømmerTest {
    
    
    MockFacade db = new MockFacade();
    @Test
    public void testOpretKonkurrenceSvømmer() throws SQLException{
        Konkurrencesvømmer konkurrencesvømmer = new Konkurrencesvømmer("Casper", 25, 42588508, true, 10001);
        
        db.opretMedlem(konkurrencesvømmer);
        
        assertTrue(db.database.size()==1);
        
        
    }
}
