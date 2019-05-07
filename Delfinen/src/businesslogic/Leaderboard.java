/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;
import java.time.LocalTime;
import java.util.ArrayList;
/**
 *
 * @author Malthorn
 */
public class Leaderboard {
    private int medlemsnummer; 
    private String disciplin; 
    private LocalTime bedsteTid; 
    private ArrayList<Medlem> medlemmer;

   
    
    public Leaderboard (LocalTime bedsteTid, int medlemsnummer, String disciplin) {
        this.disciplin = disciplin;
        this.medlemsnummer = medlemsnummer; 
        this.bedsteTid = bedsteTid;
        medlemmer = new ArrayList<Medlem>();

    
}

    
    public int getMedlemsnummer() {
        return medlemsnummer;
    }

    public void setMedlemsnummer(int medlemsnummer) {
        this.medlemsnummer = medlemsnummer;
    }

    public String getDisciplin() {
        return disciplin;
    }

    public void setDisciplin(String disciplin) {
        this.disciplin = disciplin;
    }

    public LocalTime getBedsteTid() {
        return bedsteTid;
    }

    public void setBedsteTid(LocalTime bedsteTid) {
        this.bedsteTid = bedsteTid;
    }

    public ArrayList<Medlem> getMedlemmer() {
        return medlemmer;
    }

    public void setMedlemmer(ArrayList<Medlem> medlemmer) {
        this.medlemmer = medlemmer;
    }
    
    
}
