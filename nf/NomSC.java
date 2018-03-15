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
public enum NomSC {
    Addictologie("Addictologie"),
    Alcoologie("Alcoologie"),
    Algologie("Algologie"),
    Allergologie("Allergologie"),
    Anatomie_et_cytologie_pathologiques("Anatomie et cytologie pathologiques"),
    Andrologie("Andrologie"),
    Angiologie("Angiologie"),
    Biochimie("Biochimie"),
    Cardiologie("Cardiologie"),
    Contactologie("Contactologie"),
    Coronarographie("Coronarographie"),
    Dermatologie_et_vénereologie("Dermatologie et vénéréologie"),
    Endocrinologie_et_metabolisme("Endocrinologie et métabolisme"),
    Gastro_enterologie_et_hepatologie("Gastro entérologie et hépatologie"),
    Genetique("Génétique"),
    Geriatrie("Gériatrie"),
    Gynecologie_obstétrique("Gynécologie obstétrique"),
    Hematologie("Hématologie"),
    Maladies_infectieuses_et_tropicales("Maladies infectieuses et tropicales"),
    Medecine_du_travail("Médecine du travail"),
    Medecine_interne("Médecine interne"),
    Medecine_legale("Médecine légale"),
    Medecine_nucleaire("Médecine nucléaire"),
    Medecine_physique_et_de_readaptation("Médecine physique et de réadaptation"),
    Neonatologie("Néonatologie"),
    Nephrologie("Néphrologie"),
    Neurologie_A("Neurologie A"),
    Neurologie_B("Neurologie B"),
    Neuropédiatrie("Neuropédiatrie"),
    Neuropsychiatrie("Neuropsychiatrie"),
    Odontologie_A("Odontologie A"),
    Odontologie_B("Odontologie B"),
    Oncologie("Oncologie"),
    Ophtalmologie("Ophtalmologie"),
    Orthopedie("Orthopédie"),
    Orthophonie("Orthophonie"),
    Orthoptie("Orthoptie"),
    Osteopathie("Ostéopathie"),
    ORL("ORL"),
    Otologie("Otologie"),
    Otoneurologie("Otoneurologie"),
    Parodontie("Parodontie"),
    Parodontologie("Parodontologie"),
    Pediatrie("Pédiatrie"),
    Pedodontie("Pédodontie"),
    Pedopsychiatrie("Pédopsychiatrie"),
    Pharmacologie("Pharmacologie"),
    Phlebologie("Phlébologie"),
    Pneumologie("Pneumologie"),
    Posturologie("Posturologie"),
    Proctologie("Proctologie"),
    Psychiatrie("Psychiatrie"),
    Rhumatologie_A("Rhumatologie A"),
    Rhumatologie_B("Rhumatologie B"),
    Sante_publique_et_medecine_sociale("Santé publique et médecine sociale"),
    Soins_palliatifs("Soins palliatifs"),
    Stomatologie("Stomatologie"),
    Strabologie("Strabologie"),
    Tabacologie("Tabacologie"),
    Urgences("Urgences"),
    Urologie("Urologie"),
    Venereologie("Vénéréologie");
    
    private String service;

    NomSC(String service) {
        this.service = service;
    }

    public String toString() {
        return service;
    }
}
