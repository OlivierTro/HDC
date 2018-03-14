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
    private LettreDeSortie lettreSortie;
    private ArrayList<Prestation> listePrestation=new ArrayList<Prestation>();
    private ArrayList<Observation> listeObs=new ArrayList<Observation>();
    private ArrayList<SoinsInfirmiers> listeSoinsInf=new ArrayList<SoinsInfirmiers>();
    private ArrayList<String> listePrescription = new ArrayList<String>();
    
    //dma
    public Sejour(String numeroSejour, Date dateArrivee, Date dateSortie, String nomPH, LettreDeSortie lettreSortie, ArrayList<String> listePrescription){
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
    public Sejour(String numSejour, Date dateArrivee, String nomPH){
        this.numSejour=numSejour;
        this.dateArrivee=dateArrivee;
        this.nomPH=nomPH;
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
    
    public ArrayList<SoinsInfirmiers> getListeSoinsInf(){
        return listeSoinsInf;
    }
    
    // permet d'afficher tous les soins infirmiers
    public String afficherListeSoinsInf() {
        String s=new String("");
        for (int i = 0; i < listeSoinsInf.size(); i++) {
            SoinsInfirmiers a = listeSoinsInf.get(i);
            s += "\t \t" + "> " + a.afficherSoinsInf()+ "\n";
        }
        return s;
    }
     // permet d'afficher toutes les observations
    public String afficherListeObs() {
        String s=new String("");
        for (int i = 0; i < listeObs.size(); i++) {
            Observation a = listeObs.get(i);
            s += "\t \t" + "> " + a.afficherObservation()+ "\n";
        }
        return s;
    }
    
    public ArrayList<Prestation> getListePrestation(){
        return listePrestation;
    }
    
    public void ajouterObs(Observation observation){
        listeObs.add(observation);
    }
    
    public void ajouterPrestation(Prestation p){
        listePrestation.add(p);
    }

    public LettreDeSortie getLettreSortie() {
        return lettreSortie;
    }

    
    public void setLettreSortie(LettreDeSortie lettreSortie) {
        this.lettreSortie = lettreSortie;
    }

}
