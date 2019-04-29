package main;

import businesslogic.Controller;
import datalayer.DBFacade;
import java.sql.SQLException;

public class Delfinen {


    public static void main(String[] args) throws SQLException {
        DBFacade db = new DBFacade();
        db.printMedlemmer();
    }

}
