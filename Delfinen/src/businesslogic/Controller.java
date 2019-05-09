package businesslogic;

import datalayer.DBFacade;
import datalayer.Facade;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import presentation.UI;


/**
 *
 * @author Casper P, Frederik, Mikkel
 */

public class Controller {
    DBFacade db = new DBFacade();
    private Facade facade;
    private UI ui;
    private ArrayList<Medlem> medlemmer;
    public Controller(){
        //tom controller
    }
    public Controller(UI ui, ArrayList<Medlem> medlemmer) {
        this.facade=facade;
        this.ui = ui;
        medlemmer = new ArrayList<Medlem>();
    }

  
}
