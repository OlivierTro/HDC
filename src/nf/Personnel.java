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
public class Personnel extends Personne {
    private String id;
    private String motDePasse;
    private Service service;
    private Fonction fonction;
    private ArrayList<Patient> listePatients=new ArrayList<Patient>();
    
    public Personnel(String nom, String prenom, String id, String motDePasse, Service service, Fonction fonction, ArrayList<Patient> listePatient){
        super(nom,prenom);
        this.id=id;
        this.motDePasse=motDePasse;
        this.service=service;
        this.fonction=fonction;
        this.listePatients=listePatient;        
    }
    
    public Personnel(String nom, String prenom, String id, String motDePasse, Service service, Fonction fonction){
        super(nom,prenom);
        this.id=id;
        this.motDePasse=motDePasse;
        this.service=service;
        this.fonction=fonction;
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
    public Service getService() {
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
    
     /**
     * @param mdp the mdp to set
     */
    public void setMdp(String mdp) {
        this.motDePasse = mdp;
    }

    /**
     * @param statut the statut to set
     */
    public void setStatut(Fonction fonction) {
        this.fonction = fonction;
    }
}