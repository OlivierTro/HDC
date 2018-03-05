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
    private int id;
    private String motDePasse;
    private Localisation service;
    private Fonction fonction;
    private ArrayList<Patient> listePatients=new ArrayList<Patient>();
    
    public Personnel(String nom, String prenom, int id, String motDePasse, Localisation service, Fonction fonction, ArrayList<Patient> listePatient){
        this.nom=nom;
        this.prenom=prenom;
        this.id=id;
        this.motDePasse=motDePasse;
        this.service=service;
        this.fonction=fonction;
        this.listePatients=listePatient;
        
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
    public int getId() {
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
    public Localisation getService() {
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
