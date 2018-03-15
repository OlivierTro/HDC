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
public enum Sexe {
    H("Homme"),
    F("Femme"),
    autre("Autre");
    
    private String sexe;
    
    private Sexe(String sexe){
        this.sexe=sexe;
    }
    
    public String getSexe(){
        return sexe;
    }
    
}
