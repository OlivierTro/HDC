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
public class ServiceR extends Service {

    private NomR nom;
    private static String type = "Radiologie";

    public ServiceR(NomR nom, String type) {
        super(nom.toString(),ServiceR.type);
        this.nom=nom;
    }
    
    public String getType(){
        return type;
    }
    
}
