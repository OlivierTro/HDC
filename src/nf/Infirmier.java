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
public class Infirmier extends Personnel {

    public Infirmier(String nom, String prenom, String id, String mdp, Service service, Fonction fonction) {
        super(nom, prenom, id, mdp, service, fonction);
    }

    public boolean equals(Personnel p) {
        boolean b = false;
        if (p instanceof Infirmier && this.getId().equals(p.getId())) {
            b = true;
        }
        return b;
    }

}
