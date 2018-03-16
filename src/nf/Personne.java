/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

/**
 *
 * @author OlivierTroussard
 */
public class Personne {

    private String nomUsuel;
    private String nomDeNaissance;

    private String prenom;

    public Personne(String nom, String prenom) {
        this.nomUsuel = nom;
        this.prenom = prenom;
    }

    public String getNomUsuel() {
        return nomUsuel;
    }
    
    public String getNomNaissance() {
        return nomDeNaissance;
    }

    public String getPrenom() {
        return prenom;
    }
}
