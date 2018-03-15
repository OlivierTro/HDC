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
public class ServiceC extends Service {
    private NomSC nom;
    private static String type = "Clinique";

    public ServiceC(NomSC nom, String type) {
        super(nom.toString(),ServiceC.type);
        this.nom=nom;
    }
    
    public String getType(){
        return type;
    }
}
