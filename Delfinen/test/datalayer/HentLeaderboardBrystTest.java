package datalayer;

import businesslogic.Leaderboard;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prejl
 */
public class HentLeaderboardBrystTest {
    

    MockFacade db = new MockFacade();

    @Test
    public void testHentLeaderboardBryst() throws SQLException {
        ArrayList<Leaderboard> leaderboard = db.hentLeaderboardBryst();
        assertFalse(leaderboard.isEmpty());

        //Denne test fejler hvis man ikke har en connection
    }
}
