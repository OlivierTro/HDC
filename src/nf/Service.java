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
public enum Service {
    MedicoTechnique("Medico-Technique"),
    Clinique("Clinique"),
    Anesthesie("Anesthésie");
    
    private String service;
    
    private Service(String service){
        this.service=service;
    }
}
