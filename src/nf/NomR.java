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
public enum NomR {    
    Radiodiagnostic_et_imagerie_medicale("Radiodiagnostic et imagerie médicale"),
    Radiologie("Radiologie");
    
    private String service;

    NomR(String service) {
        this.service = service;
    }

    public String toString() {
        return service;
    }
    
}
