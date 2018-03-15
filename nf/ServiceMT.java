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
public class ServiceMT extends Service {

    private NomSMT nom;
    private static String type = "Medico-Technique";

    public ServiceMT(NomSMT nom, String type) {
        super(nom.toString(),ServiceMT.type);
        this.nom=nom;
    }
    
    public String getType(){
        return type;
    }
}
