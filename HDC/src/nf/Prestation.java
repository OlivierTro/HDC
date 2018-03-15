/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author ANNELAURE
 */
public class Prestation {
    private String nomPrestation;
    private java.util.Date dateD;
    private java.util.Date dateR;
    private String auteurD;
    private String auteurR;
    private String resultat;
    private String prestation;
    private Service service;
    
    public Prestation(String prestation){
        this.prestation=prestation;
    }
    
    public Prestation(String nomPrestation, java.util.Date dateD, String auteurD, String prestation, Service service){
        this.nomPrestation=nomPrestation;
        this.dateD=dateD;
        this.auteurD=auteurD;
        this.prestation=prestation;
        this.service=service;
    }
    
    public Prestation(String nomPrestation, java.util.Date dateD, java.util.Date dateR, String auteurD, String auteurR, String resultat, String prestation, Service service){
        this.nomPrestation=nomPrestation;
        this.dateD=dateD;
        this.dateR=dateR;
        this.auteurD=auteurD;
        this.auteurR=auteurR;
        this.resultat=resultat;
        this.prestation=prestation;
        this.service=service;
    }

    public void ajouterResultat(Sejour sejour, String resultat, String auteurR) {
        this.resultat = resultat;
        this.auteurR = auteurR;
        Calendar now = new Calendar();
        this.dateR = now.getTime();
        boolean j=false;
         try {
            String requete = "UPDATE prestation SET resultat = ? , dateresultat = ? , auteurresultat = ? ";
            requete += " WHERE numsejour= ? ";
            requete += " AND datedemande= ? ";
            PreparedStatement state = ConnexionBD.getInstance().prepareStatement(requete);
            state.setString(1,resultat);
            state.toString(2,this.dateR);
            state.setString(3,auteurR);
            state.setString(4,sejour.getNumSejour());
            state.setDate(this.dateD);
            int i = state.executeUpdate();
            if (i == 1) {
                j = true;
            }
            state.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    public java.util.Date getDateD() {
        return dateD;
    }

    /**
     * @return the dateR
     */
    public java.util.Date getDateR() {
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
    public Service getService() {
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
    
    
    public String afficherPresDMA(){
        String s=new String("");
        s= "- " + nomPrestation + "\n";
        return s;
    }
    
    public String afficherPresDM(){
        String s;
        s="Nom de la prestation : " + nomPrestation + "\n"
        + "\t" + "Date de la demande : " + dateD + "\n";
        if (dateR==null){
         s=s+"\t" + "Date de la réalisation : la prestation n'a pas encore été réalisée"  + "\n"; 
        }
        else{
        s=s+ "\t" + "Date de la réalisation : " + dateD + "\n";
        } 
        s=s+ "\t" + "Auteur de la demande : " + auteurD + "\n";
        if(auteurR!=null){
            s=s+"\t" + "Auteur de la réalisation : " + auteurR + "\n";
        }
        s=s+"\t" + "Prestation : " + prestation + "\n"
        +"\t" + "Resultat : " + resultat + "\n"
        +"\t" + "Service : " + service + "\n";
        return s;
    }

    
}

