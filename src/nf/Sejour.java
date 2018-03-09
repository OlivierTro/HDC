/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author ANNELAURE
 */
public class Sejour {
    private String numSejour;
    private Date dateArrivee;
    private Date dateSortie;
    private Timestamp dateEdition;
    private String numeroDeLit;
    private Service service;
    private String nomPH;
    private String idAuteur;
    private String lettreSortie;
    private ArrayList<Prestation> listePrestation=new ArrayList<Prestation>();
    private ArrayList<Observation> listeObs=new ArrayList<Observation>();
    private ArrayList<SoinsInfirmiers> listeSoinsInf=new ArrayList<SoinsInfirmiers>();
    private ArrayList<String> listePrescription = new ArrayList<String>();
    
    //dma
    public Sejour(String numeroSejour, Date dateArrivee, Date dateSortie, String nomPH, String lettreSortie, ArrayList<String> listePrescription){
        this.numSejour=numSejour;
        this.dateArrivee=dateArrivee;
        this.dateSortie=dateSortie;
        this.nomPH=nomPH;
        this.lettreSortie=lettreSortie;
        int i=0;
        while(i<this.listePrestation.size()){
            listePrescription.add(listePrestation.get(i).getPrestation());
            i++;
        }
        
        this.listePrescription=listePrescription;
    }
    
    //dm clinique
    public Sejour(ArrayList<Observation> listeObs, ArrayList<Prestation> listePrestation, ArrayList<SoinsInfirmiers> listeSoinsInf){
        this.listeObs=listeObs;
        this.listePrestation=listePrestation;
        this.listeSoinsInf=listeSoinsInf;
    }
    
    public Sejour(String numSejour, Date dateA, String phresponsable, String auteur, String lit, Service service, Timestamp dateE){
        this.numSejour = numSejour;
        this.dateArrivee = dateA;
        this.nomPH = phresponsable;
        this.idAuteur = auteur;
        this.numeroDeLit = lit;
        this.service = service;
        this.dateEdition = dateE;
    }
            
    public Sejour(String numsejour, Date dateA, String phresponsable, String auteur, String lit, Service service, Timestamp dateE, String lettreDeSortie, Date dateSortie){
        this.numSejour = numSejour;
        this.dateArrivee = dateA;
        this.nomPH = phresponsable;
        this.idAuteur = auteur;
        this.numeroDeLit = lit;
        this.service = service;
        this.dateEdition = dateE;
        this.lettreSortie = lettreDeSortie;
        this.dateSortie = dateSortie;
    }
                            
    //dm anesthésie et medico-technique
    public Sejour(ArrayList<Observation> listeObs, ArrayList<Prestation> listePrestation){
        this.listeObs=listeObs;
        this.listePrestation=listePrestation;
    }

    
    /**
     * @return the nDeSejour
     */
    public String getNumSejour() {
        return this.numSejour;
    }

    /**
     * @return the dateArrivee
     */
    public Date getDateArrivee() {
        return dateArrivee;
    }

    /**
     * @return the dateSortie
     */
    public Date getDateSortie() {
        return dateSortie;
    }

    /**
     * @return the dateEdition
     */
    public Timestamp getDateEdition() {
        return dateEdition;
    }

    /**
     * @return the numeroDeLit
     */
    public String getNumeroDeLit() {
        return numeroDeLit;
    }

    /**
     * @return the service
     */
    public Service getService() {
        return service;
    }

    /**
     * @return the nomPH
     */
    public String getNomPH() {
        return nomPH;
    }

    /**
     * @return the idAuteur
     */
    public String getIdAuteur() {
        return idAuteur;
    }

    /**
     * @return the lettreSortie
     */
    public String getLettreSortie() {
        return lettreSortie;
    }

    /**
     * @return the listePrestation
     */
    public ArrayList<Prestation> getListePrestation() {
        return listePrestation;
    }

    /**
     * @return the listeObs
     */
    public ArrayList<Observation> getListeObs() {
        return listeObs;
    }

    /**
     * @return the listeSoinsInf
     */
    public ArrayList<SoinsInfirmiers> getListeSoinsInf() {
        return listeSoinsInf;
    }

    /**
     * @return the listePrescription
     */
    public ArrayList<String> getListePrescription() {
        return listePrescription;
    }
    
   
    
}
