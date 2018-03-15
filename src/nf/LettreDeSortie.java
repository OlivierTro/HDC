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
<<<<<<< HEAD
    private Personnel auteur;
    private Date delivrance;
    private String diagnostic;
    private String traitement;
    
    public LettreDeSortie(Personnel auteur, Date delivrance, String diagnostic, String traitement){
=======
    private String auteur;
    private java.util.Date delivrance;
    private String diagnostic;
    private String traitement;
    
    public LettreDeSortie(String auteur, java.util.Date delivrance, String diagnostic, String traitement){
>>>>>>> master3
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
<<<<<<< HEAD
    public Personnel getAuteur() {
=======
    public String getAuteur() {
>>>>>>> master3
        return auteur;
    }

    /**
     * @param auteur the auteur to set
     */
<<<<<<< HEAD
    public void setAuteur(Personnel auteur) {
=======
    public void setAuteur(String auteur) {
>>>>>>> master3
        this.auteur = auteur;
    }

    /**
     * @return the delivrance
     */
<<<<<<< HEAD
    public Date getDelivrance() {
=======
    public java.util.Date getDelivrance() {
>>>>>>> master3
        return delivrance;
    }

    /**
     * @param delivrance the delivrance to set
     */
<<<<<<< HEAD
    public void setDelivrance(Date delivrance) {
=======
    public void setDelivrance(java.util.Date delivrance) {
>>>>>>> master3
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
