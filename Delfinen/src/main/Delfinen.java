package main;

import businesslogic.Controller;
import businesslogic.Medlem;
import datalayer.DBFacade;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import presentation.SystemUI;

public class Delfinen {


    public static void main(String[] args) throws SQLException, ParseException {
        ArrayList<Medlem> medlemmer = new ArrayList();
        SystemUI ui = new SystemUI();
        DBFacade DB = new DBFacade(); 
        Controller ctrl = new Controller(ui, medlemmer);
        
        //ui.opretMedlem();
        
        //ui.restance();
        
        //DB.printRestance();
        //DB.printLeaderboard();;
        ctrl.start();
        //ui.printLeaderboard();
        //ui.printSvømmehold();
        //ui.printRestance();
       // ui.printSvømmehold();
        
        
    }

}
