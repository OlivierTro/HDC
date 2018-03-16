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
public class SoinsInfirmiers {
    private String nomSoins;
    private String description;
    private Date dateRealSoins;
    private String auteur;
    private Timestamp dateEdition;
    
    public SoinsInfirmiers(String nomSoins, String description, Date dateRealSoins, String auteur, Timestamp dateEdition){
        this.nomSoins=nomSoins;
        this.description=description;
        this.dateRealSoins=dateRealSoins;
        this.auteur=auteur;
        this.dateEdition=dateEdition;
    }

    /**
     * @return the nomSoins
     */
    public String getNomSoins() {
        return nomSoins;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the dateRealSoins
     */
    public Date getDateRealSoins() {
        return dateRealSoins;
    }

    /**
     * @return the auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * @return the dateEdition
     */
    public Timestamp getDateEdition() {
        return dateEdition;
    }
    
    //permet de verifier si le soins a été réalisé.
    public boolean SoinsReal(){
        boolean r;
        if(this.dateRealSoins==null){
            r=false;
        }
        else{
            r=true;
        }
        return r;
    }

    /**
     * @param dateRealSoins the dateRealSoins to set
     */
    public void setDateRealSoins(Date dateRealSoins) {
        this.dateRealSoins = dateRealSoins;
    }
    
    // affiche un soins infirmier
    public String afficherSoinsInf() {
        String s = "Date du soin " + dateRealSoins.toString() + "\n"
                + "\t" + "Nom du soin : " + nomSoins + "\n"
                + "\t" + "Description : " + description + "\n"
                + "\t" + "Auteur :" + auteur + "\n"
                + "\t" + "Date édition :" + dateEdition + "\n";
        return s;
    }
    
    
}
