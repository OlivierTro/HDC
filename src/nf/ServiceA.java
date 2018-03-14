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
public class ServiceA extends Service {
    private NomA nom;
    private static String type = "Anesthesie";

    public ServiceA(NomA nom, String type) {
        super(nom.toString(),ServiceA.type);
        this.nom=nom;
    }
    
    public String getType(){
        return type;
    }
}
