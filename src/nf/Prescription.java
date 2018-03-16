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
    
    public String afficherPrescription() {
        String s=new String("");
        s=s+"Prescripteur : " + prescripteur + "\n"
        + "\t" + "Date de début :" + dateDebut + "\n";
        if (dateFin==null){
        s=s+ "\t" + "Date de fin : la prescription n'a pas été réalisée" + "\n"; 
        }
        else{
            s=s+ "\t" + "Date de fin : "+ dateFin + "\n"; 
        }
        s=s+"\t" + "Prescription : "+ objet + "\n";
        return s;
    }
}
