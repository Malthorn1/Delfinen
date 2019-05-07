package datalayer;

import businesslogic.Konkurrencesvømmer;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prejl
 */
public class HentSvømmeholdTest {

    MockFacade db = new MockFacade();

    @Test
    public void testHentSvømmehold() throws SQLException {
        ArrayList<Konkurrencesvømmer> svømmehold = db.hentSvømmeHold();
        assertFalse(svømmehold.isEmpty());

        //Denne test fejler hvis man ikke har en connection
    }

}
