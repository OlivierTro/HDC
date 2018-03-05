/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

/**
 *
 * @author ANNELAURE
 */
public class MedG {
    private String nom;
    private String prenom;
    private String adresseMail;
    
    public MedG(String nom, String prenom, String adresseMail){
        this.nom=nom;
        this.prenom=prenom;
        this.adresseMail=adresseMail;
    }
    
    public String getAdresseMail(){
        return adresseMail;
    }
    
    public String getPrenom(){
        return prenom;
    }
    
    public String getNom(){
        return nom;
    }
}
