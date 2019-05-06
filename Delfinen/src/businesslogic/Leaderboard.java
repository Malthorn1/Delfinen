/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;
import java.util.ArrayList;
/**
 *
 * @author Malthorn
 */
public class Leaderboard {
    private int disciplinId; 
    private int medlemsnummer; 
    private String disciplin; 
    private int bedsteTid; 
    private ArrayList<Medlem> medlemmer;

    public int getBedsteTId() {
        return bedsteTid;
    }

    public void setBedsteTId(int bedsteTId) {
        this.bedsteTid = bedsteTid;
    }
    
    public Leaderboard (int bedsteTid, int medlemsnummer, String disciplin, int disciplinId) {
        this.disciplinId = disciplinId; 
        this.disciplin = disciplin;
        this.medlemsnummer = medlemsnummer; 
        this.bedsteTid = bedsteTid;
        medlemmer = new ArrayList<Medlem>();

    
}

    public int getDisciplinId() {
        return disciplinId;
    }

    public void setDisciplinId(int disciplinId) {
        this.disciplinId = disciplinId;
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
    
    
}
