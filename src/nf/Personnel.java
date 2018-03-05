/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.util.ArrayList;

/**
 *
 * @author ANNELAURE
 */
public class Personnel {
    private String nom;
    private String prenom;
    private String id;
    private String motDePasse;
    private String service;
    private Fonction fonction;
    private ArrayList<Patient> listePatients=new ArrayList<Patient>();
    
    public Personnel(String nom, String prenom, String id, String motDePasse, String service, Fonction fonction, ArrayList<Patient> listePatient){
        this.nom=nom;
        this.prenom=prenom;
        this.id=id;
        this.motDePasse=motDePasse;
        this.service=service;
        this.fonction=fonction;
        this.listePatients=listePatient;        
    }
    
    public Personnel(String nom, String prenom, String id, String motDePasse, String service, Fonction fonction){
        this.nom=nom;
        this.prenom=prenom;
        this.id=id;
        this.motDePasse=motDePasse;
        this.service=service;
        this.fonction=fonction;
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
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the motDePasse
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * @return the service
     */
    public String getService() {
        return service;
    }

    /**
     * @return the fonction
     */
    public Fonction getFonction() {
        return fonction;
    }

    /**
     * @return the listePatient
     */
    public ArrayList<Patient> getListePatient() {
        return listePatients;
    }
}
