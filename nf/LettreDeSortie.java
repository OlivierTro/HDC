/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

/**
 *
 * @author Pauline
 */
public class LettreDeSortie {

    private String auteur;
    private java.util.Date delivrance;
    private String diagnostic;
    private String traitement;
    
    public LettreDeSortie(String auteur, java.util.Date delivrance, String diagnostic, String traitement){

        this.auteur = auteur;
        this.delivrance = delivrance;
        this.diagnostic = diagnostic;
        this.traitement = traitement;
    }
    
    public boolean isLettreDeSortie(){
        boolean sortie = false;
        if(this.getDelivrance() != null){
            sortie = true;
        }
        return sortie;
    }

    /**
     * @return the auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * @param auteur the auteur to set
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    /**
     * @return the delivrance
     */
    public java.util.Date getDelivrance() {
        return delivrance;
    }

    /**
     * @param delivrance the delivrance to set
     */
    public void setDelivrance(java.util.Date delivrance) {
        this.delivrance = delivrance;
    }

    /**
     * @return the diagnostic
     */
    public String getDiagnostic() {
        return diagnostic;
    }

    /**
     * @param diagnostic the diagnostic to set
     */
    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    /**
     * @return the traitement
     */
    public String getTraitement() {
        return traitement;
    }

    /**
     * @param traitement the traitement to set
     */
    public void setTraitement(String traitement) {
        this.traitement = traitement;
    }
}
