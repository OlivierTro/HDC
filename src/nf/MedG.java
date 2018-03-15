<<<<<<< HEAD
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
    
    /**
     * Permet d'obtenir le prenom, le nom d'un medecin
     * généraliste
     * 
     * @return un String
     */
    public String toString() {
        return getPrenom() + " " + getNom();
    }

    /**
     * Permet d'obtenir le prenom, le nom et le mail d'un medecin
     *
     * @return un String
     */
    public String toStringF() {
        return getPrenom() + " " + getNom() + ", " + getAdresseMail();
    }

    /**
     * Permet de verifier si un objet est de type MedG
     *
     * @param o prend un objet
     * @return true si l'objet est un medecin, false sinon
     */
    public boolean equals(Object o) {
        if (o instanceof MedG) {
            MedG p = (MedG) o;
            return getNom().equals(p.getNom()) && getPrenom().equals(p.getPrenom());
        } else {
            return false;
        }
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
=======
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
    
    /**
     * Permet d'obtenir le prenom, le nom d'un medecin
     * généraliste
     * 
     * @return un String
     */
    public String toString() {
        return getPrenom() + " " + getNom();
    }

    /**
     * Permet d'obtenir le prenom, le nom et le mail d'un medecin
     *
     * @return un String
     */
    public String toStringF() {
        return getPrenom() + " " + getNom() + ", " + getAdresseMail();
    }

    /**
     * Permet de verifier si un objet est de type MedG
     *
     * @param o prend un objet
     * @return true si l'objet est un medecin, false sinon
     */
    public boolean equals(Object o) {
        if (o instanceof MedG) {
            MedG p = (MedG) o;
            return getNom().equals(p.getNom()) && getPrenom().equals(p.getPrenom());
        } else {
            return false;
        }
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
>>>>>>> 18c44281185988e0f340a093422516ed4d5c089c
