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
public class Patient {
    private String ipp;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Sexe sexe;
    private Adresse adresse;
    private DPI dpi;
    private String nationalite;
    private MedG medecinG;
    private boolean hospitalise;
    private Timestamp dateEdition;
    
    public Patient(String ipp, String nom, String prenom, Adresse adresse, Date dateDeNaissance, Sexe sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        }

    public DPI getDpi(){
        return dpi;
    }
    
    /**
     * @return the ipp
     */
    public String getIpp() {
        return ipp;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @return the dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @return the sexe
     */
    public Sexe getSexe() {
        return sexe;
    }

    /**
     * @return the adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * @return the nationnalité
     */
    public String getNationalite() {
        return nationalite;
    }

    /**
     * @return the medecinG
     */
    public MedG getMedecinG() {
        return medecinG;
    }

    /**
     * @return the hospitalise
     */
    public boolean getHospitalise() {
        return hospitalise;
    }

    /**
     * @return the dateEdition
     */
    public Timestamp getDateEdition() {
        return dateEdition;
    }

    /**
     * @param hospitalise the hospitalise to set
     */
    public void setHospitalise(boolean hospitalise) {
        this.hospitalise = hospitalise;
    }

    /**
     * @param dateEdition the dateEdition to set
     */
    public void setDateEdition(Timestamp dateEdition) {
        this.dateEdition = dateEdition;
    }
    

    
    
}
