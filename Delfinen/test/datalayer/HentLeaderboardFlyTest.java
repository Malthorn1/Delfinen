/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class HentLeaderboardFlyTest {

    MockFacade db = new MockFacade();

    @Test
    public void testHentLeaderboardFly() throws SQLException {
        ArrayList<Leaderboard> leaderboard = db.hentLeaderboardFly();
        assertFalse(leaderboard.isEmpty());

        //Denne test fejler hvis man ikke har en connection
    }
}
