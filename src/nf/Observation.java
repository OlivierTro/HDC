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
    private DateE date;
    private String obs;
    private String auteur;
    
    public Observation(DateE date, String obs, String auteur){
        this.date=date;
        this.auteur=auteur;
        this.obs=obs;
    }

    /**
     * @return the date
     */
    public DateE getDate() {
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
    
    
    
}
