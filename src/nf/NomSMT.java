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
public enum NomSMT {

    Anapathologie("Anapathologie"),    
    Anesthesie("Anesthésie"),
    Biologie_medicale_et_physiologie("Biologie médicale et physiologie"),    
    Chirurgie("Chirurgie"),
    Chirurgie_digestive("Chirurgie digestive"),
    Chirurgie_infantile("Chirurgie_infantile"),
    Chirurgie_maxillo_faciale_et_stomatologie("Chirurgie maxillo faciale et stomatologie"),
    Chirurgie_orthopédique_et_traumatologique("Chirurgie orthopédique et traumatologique"),
    Chirurgie_plastique("Chirurgie plastique"),
    Chirurgie_plastique_reconstructrice_et_esthetique("Chirurgie plastique reconstructrice et esthétique"),
    Chirurgie_thoracique_et_cardio_vasculaire("Chirurgie thoracique et cardio vasculaire"),
    Chirurgie_urologique("Chirurgie urologique"),
    Chirurgie_vasculaire("Chirurgie vasculaire"),
    Chirurgie_viscerale_A("Chirurgie viscérale A"),
    Chirurgie_viscerale_B("Chirurgie viscérale B"),
    Dentisterie("Dentisterie"),
    Explorations_fonctionnelles("Explorations fonctionnelles"),
    Hemathologie("Hémathologie"), 
    Hygiene_hospitaliere("Hygiène hospitalière"),
    Information_medicale("Information médicale"),
    LaboratoireDAnalyse("Laboratoire D'Analyse"),
    Neurochirurgie("Neurochirurgie"),
    Orthodontie("Orthodontie"),    
    Pharmacie("Pharmacie"),
    Radiologie("Radiologie"),
    Reanimation_medicale("Réanimation médicale"),
    SAMU_SMUR("SAMU SMUR");
    
    private String service;

    NomSMT(String service) {
        this.service = service;
    }

    public String toString() {
        return service;
    }

}
