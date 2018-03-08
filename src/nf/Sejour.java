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
public class Sejour {
    private String numSejour;
    private Date dateArrivee;
    private Date dateSortie;
    private String numeroDeLit;
    private String nomPH;
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
}
