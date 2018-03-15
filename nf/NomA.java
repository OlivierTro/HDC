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
public enum NomA {
    Anesthesiologie_réanimation_chirurgicale("Anesthésiologie réanimation chirurgicale");
    
    private String service;

    NomA(String service) {
        this.service = service;
    }

    public String toString() {
        return service;
    }
}
