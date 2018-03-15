/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author OlivierTroussard
 */
public enum TypeService {

    Addictologie("Addictologie", Service.Clinique),
    Alcoologie("Alcoologie", Service.Clinique),
    Algologie("Algologie", Service.Clinique),
    Allergologie("Allergologie", Service.Clinique),
    Anatomie_et_cytologie_pathologiques("Anatomie et cytologie pathologiques", Service.Clinique),
    Andrologie("Andrologie", Service.Clinique),
    Anesthesiologie_réanimation_chirurgicale("Anesthésiologie réanimation chirurgicale", Service.Anesthesie),
    Angiologie("Angiologie", Service.Clinique),
    Biochimie("Biochimie", Service.Clinique),
    Biologie_medicale_et_physiologie("Biologie médicale et physiologie", Service.MedicoTechnique),
    Cardiologie("Cardiologie", Service.Clinique),
    Chirurgie("Chirurgie", Service.MedicoTechnique),
    Chirurgie_digestive("Chirurgie digestive", Service.MedicoTechnique),
    Chirurgie_infantile("Chirurgie_infantile", Service.MedicoTechnique),
    Chirurgie_maxillo_faciale_et_stomatologie("Chirurgie maxillo faciale et stomatologie", Service.MedicoTechnique),
    Chirurgie_orthopédique_et_traumatologique("Chirurgie orthopédique et traumatologique", Service.MedicoTechnique),
    Chirurgie_plastique("Chirurgie plastique", Service.MedicoTechnique),
    Chirurgie_plastique_reconstructrice_et_esthetique("Chirurgie plastique reconstructrice et esthétique", Service.MedicoTechnique),
    Chirurgie_thoracique_et_cardio_vasculaire("Chirurgie thoracique et cardio vasculaire", Service.MedicoTechnique),
    Chirurgie_urologique("Chirurgie urologique", Service.MedicoTechnique),
    Chirurgie_vasculaire("Chirurgie vasculaire", Service.MedicoTechnique),
    Chirurgie_viscerale_A("Chirurgie viscérale A", Service.MedicoTechnique),
    Chirurgie_viscerale_B("Chirurgie viscérale B", Service.MedicoTechnique),
    Contactologie("Contactologie", Service.Clinique),
    Coronarographie("Coronarographie", Service.Clinique),
    Dentisterie("Dentisterie", Service.MedicoTechnique),
    Dermatologie_et_vénereologie("Dermatologie et vénéréologie", Service.Clinique),
    Endocrinologie_et_metabolisme("Endocrinologie et métabolisme", Service.Clinique),
    Explorations_fonctionnelles("Explorations fonctionnelles", Service.MedicoTechnique),
    Gastro_enterologie_et_hepatologie("Gastro entérologie et hépatologie", Service.Clinique),
    Genetique("Génétique", Service.Clinique),
    Geriatrie("Gériatrie", Service.Clinique),
    Gynecologie_obstétrique("Gynécologie obstétrique", Service.Clinique),
    Hematologie("Hématologie", Service.Clinique),
    Hygiene_hospitaliere("Hygiène hospitalière", Service.MedicoTechnique),
    Information_medicale("Information médicale", Service.MedicoTechnique),
    Maladies_infectieuses_et_tropicales("Maladies infectieuses et tropicales", Service.Clinique),
    Medecine_du_travail("Médecine du travail", Service.Clinique),
    Medecine_interne("Médecine interne", Service.Clinique),
    Medecine_legale("Médecine légale", Service.Clinique),
    Medecine_nucleaire("Médecine nucléaire", Service.Clinique),
    Medecine_physique_et_de_readaptation("Médecine physique et de réadaptation", Service.Clinique),
    Neonatologie("Néonatologie", Service.Clinique),
    Nephrologie("Néphrologie", Service.Clinique),
    Neurochirurgie("Neurochirurgie", Service.MedicoTechnique),
    Neurologie_A("Neurologie A", Service.Clinique),
    Neurologie_B("Neurologie B", Service.Clinique),
    Neuropédiatrie("Neuropédiatrie", Service.Clinique),
    Neuropsychiatrie("Neuropsychiatrie", Service.Clinique),
    Odontologie_A("Odontologie A", Service.Clinique),
    Odontologie_B("Odontologie B", Service.Clinique),
    Oncologie("Oncologie", Service.Clinique),
    Ophtalmologie("Ophtalmologie", Service.Clinique),
    Orthodontie("Orthodontie", Service.MedicoTechnique),
    Orthopedie("Orthopédie", Service.Clinique),
    Orthophonie("Orthophonie", Service.Clinique),
    Orthoptie("Orthoptie", Service.Clinique),
    Osteopathie("Ostéopathie", Service.Clinique),
    ORL("ORL", Service.Clinique),
    Otologie("Otologie", Service.Clinique),
    Otoneurologie("Otoneurologie", Service.Clinique),
    Parodontie("Parodontie", Service.Clinique),
    Parodontologie("Parodontologie", Service.Clinique),
    Pediatrie("Pédiatrie", Service.Clinique),
    Pedodontie("Pédodontie", Service.Clinique),
    Pedopsychiatrie("Pédopsychiatrie", Service.Clinique),
    Pharmacie("Pharmacie", Service.MedicoTechnique),
    Pharmacologie("Pharmacologie", Service.Clinique),
    Phlebologie("Phlébologie", Service.Clinique),
    Pneumologie("Pneumologie", Service.Clinique),
    Posturologie("Posturologie", Service.Clinique),
    Proctologie("Proctologie", Service.Clinique),
    Psychiatrie("Psychiatrie", Service.Clinique),
    Radiodiagnostic_et_imagerie_medicale("Radiodiagnostic et imagerie médicale", Service.Radiologie),
    Radiologie("Radiologie", Service.Radiologie),
    Radiotherapie("Radiothérapie", Service.MedicoTechnique),
    Reanimation_medicale("Réanimation médicale", Service.MedicoTechnique),
    Rhumatologie_A("Rhumatologie A", Service.Clinique),
    Rhumatologie_B("Rhumatologie B", Service.Clinique),
    SAMU_SMUR("SAMU SMUR", Service.MedicoTechnique),
    Sante_publique_et_medecine_sociale("Santé publique et médecine sociale", Service.Clinique),
    Soins_palliatifs("Soins palliatifs", Service.Clinique),
    Stomatologie("Stomatologie", Service.Clinique),
    Strabologie("Strabologie", Service.Clinique),
    Tabacologie("Tabacologie", Service.Clinique),
    Urgences("Urgences", Service.Clinique),
    Urologie("Urologie", Service.Clinique),
    Venereologie("Vénéréologie", Service.Clinique);

    private String nom;
    private Service type;

    private TypeService(String nom, Service type) {
        this.nom = nom;
        this.type = type;
    }

    public String toString() {
        return nom;
    }

    public String getType() {
        return this.type.toString();
    }

    public String toText() {
        return super.toString() + " (service " + type + ")";
    }

    public ArrayList<Personnel> getListPersonnelMed() {
        ArrayList<Personnel> p = new ArrayList<Personnel>();
        try {
            String requete = "SELECT * FROM personnel";
            requete += " WHERE Service = ? ";
            requete += " AND fonction = ? ";
            requete += " OR fonction = ? ";
            PreparedStatement state = ConnexionBD.getInstance().prepareStatement(requete);
            state.setString(1, this.nom);
            state.setString(2, "ph");
            state.setString(3, "phChef");
            state.execute();
            ResultSet res = state.getResultSet();
            while (res.next()) {
                Personnel med;
                med = new Personnel(res.getString("nom"),
                        res.getString("prenom"), res.getString("id"), res.getString("motDePasse"), valueOf(res.getString("service")).getType()
                        , Fonction.valueOf(res.getString("fonction"))
                );
                p.add(med);
            }
            state.close();
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
}
