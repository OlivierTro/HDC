<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

/**
 *
 * @author ANNELAURE
 */
public class Observation {
    private java.util.Date date;
    private String obs;
    private String auteur;
    
    public Observation(java.util.Date date, String obs, String auteur){
        this.date=date;
        this.auteur=auteur;
        this.obs=obs;
    }

    /**
     * @return the date
     */
    public java.util.Date getDate() {
        return date;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @return the auteur
     */
    public String getAuteur() {
        return auteur;
    }
    
    // affiche l'observation
    public String afficherObservation() {
        String s = "Date " + date.toString() + "\n"
                + "\t" + "Auteur : " + auteur + "\n"
                + "\t" + "Observation : " + obs + "\n";
        return s;
    }
    
    
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

/**
 *
 * @author ANNELAURE
 */
public class Observation {
    private java.util.Date date;
    private String obs;
    private String auteur;
    
    public Observation(java.util.Date date, String obs, String auteur){
        this.date=date;
        this.auteur=auteur;
        this.obs=obs;
    }

    /**
     * @return the date
     */
    public java.util.Date getDate() {
        return date;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @return the auteur
     */
    public String getAuteur() {
        return auteur;
    }
    
    // affiche l'observation
    public String afficherObservation() {
        String s = "Date " + date.toString() + "\n"
                + "\t" + "Auteur : " + auteur + "\n"
                + "\t" + "Observation : " + obs + "\n";
        return s;
    }
    
    
    
}
>>>>>>> 18c44281185988e0f340a093422516ed4d5c089c
