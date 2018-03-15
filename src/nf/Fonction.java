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
public enum Fonction {
    DECO("Deconnecte"),
    ph("ph"),
    chefPh("chefPh"),
    infirmiere("inf"),
    interne("int"),
    secretaireM("secM"),
    secretaireAdm("secA");
    
    private String fonction;
    
    private Fonction(String fonction){
        this.fonction=fonction;
    }    

    /**
     * @return the fonction
     */
    public String getFonction() {
        return fonction;
    }

    /**
     * @param fonction the fonction to set
     */
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    /**
     * Permet d'obtenir la fonction d'un personnel
     *
     * @return un String, la fonction
     */
    public String toString() {
        return fonction;
    }
    
}