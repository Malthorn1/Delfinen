/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer;

/**
 *
 * @author mikke
 */
class Leaderboard {
       
   public class leaderboard {
       private String name; 
       private String disciplin; 
       private int tid; 
       private int disciplinID;
       
       public leaderboard (String name, String disciplin, int tid, int disciplinID) {
           this.name = name; 
           this.disciplin = disciplin; 
           this.tid  = tid; 
           this.disciplinID = disciplinID; 
                   
                   
           
       }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDisciplin() {
            return disciplin;
        }

        public void setDisciplin(String disciplin) {
            this.disciplin = disciplin;
        }

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }

        public int getDisciplinID() {
            return disciplinID;
        }

        public void setDisciplinID(int disciplinID) {
            this.disciplinID = disciplinID;
        }
       
    
}
}
