/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.security.Timestamp;

/**
 *
 * @author ANNELAURE
 */
public class Prestation {
    private String nomPrestation;
    private Timestamp dateD;
    private Timestamp dateR;
    private String auteurD;
    private String auteurR;
    private String resultat;
    private String prestation;
    private Localisation service;
    
    public Prestation(String prestation){
        this.prestation=prestation;
    }
    
    public Prestation(String nomPrestation, Timestamp dateD, Timestamp dateR, String auteurD, String auteurR, String resultat, String prestation, Localisation service){
        this.nomPrestation=nomPrestation;
        this.dateD=dateD;
        this.dateR=dateR;
        this.auteurD=auteurD;
        this.auteurR=auteurR;
        this.resultat=resultat;
        this.prestation=prestation;
        this.service=service;
    }

    /**
     * @return the nomPrestation
     */
    public String getNomP() {
        return nomPrestation;
    }

    /**
     * @return the dateD
     */
    public Timestamp getDateD() {
        return dateD;
    }

    /**
     * @return the dateR
     */
    public Timestamp getDateR() {
        return dateR;
    }

    /**
     * @return the auteurD
     */
    public String getAuteurD() {
        return auteurD;
    }

    /**
     * @return the auteurR
     */
    public String getAuteurR() {
        return auteurR;
    }

    /**
     * @return the resultat
     */
    public String getResultat() {
        return resultat;
    }

    /**
     * @return the prestation
     */
    public String getPrestation() {
        return prestation;
    }

    /**
     * @return the service
     */
    public Localisation getService() {
        return service;
    }


    //verifier que la prescription a été réalisée; donc si elle a un resultat.
    public boolean pRealisee(){
        boolean r;
        if(this.resultat==null){
            r=false;
        }
        else{
            r=true;
        }
        return r;
    }
    
}

