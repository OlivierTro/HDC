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
public class Prescription {
    private Patient patient;
    private Sejour sejour;
    private PraticienHospitalier prescripteur;
    private String objet;
    private java.util.Date dateDebut;
    private java.util.Date dateFin;
            
    public Prescription (Patient patient, Sejour sejour ,PraticienHospitalier prescripteur, String objet,java.util.Date dateDebut, java.util.Date dateFin) {
        this.patient=patient;
        this.sejour=sejour;
        this.prescripteur=prescripteur;
        this.objet=objet;
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
    }

    public Patient getPatient() {
        return patient;
    }

    public PraticienHospitalier getPrescripteur() {
        return prescripteur;
    }

    public String getObjet() {
        return objet;
    }

    public java.util.Date getDateDebut() {
        return dateDebut;
    }

    public java.util.Date getDateFin() {
        return dateFin;
    }

    public Sejour getSejour() {
        return sejour;
    }
}
