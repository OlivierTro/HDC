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
public enum Localisation {
    Cardiologie("cardiologie",Service.Clinique),
    Neurologie("neurologie",Service.Clinique);
    
    
    private String nom;
    private Service type;

    private Localisation(String nom, Service type){
        this.nom=nom;
        this.type=type;
}


    
}
