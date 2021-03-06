/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.security.Timestamp;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author ANNELAURE
 */
public class Patient extends Personne {

    private String ipp;
    private String nomUsuel;
    private String nomNaissance;
    private String prenom;
    private Date dateNaissance;
    private Sexe sexe;
    private Adresse adresse;
    private DPI dpi;
    private String nationalite;
    private PraticienHospitalier PHResponsable;
    private MedG medecinG;
    private boolean hospitalise;
    private Service localisationService;
    private Timestamp dateEdition;
    private ArrayList<Sejour> listeSejour;

    public Patient(String ipp, String nomUsuel, String nomNaissance, String prenom, Adresse adresse, Date dateNaissance, Sexe sexe, MedG medecinG, PraticienHospitalier ph) {
        super(nomUsuel, prenom);
        this.ipp = ipp;
        this.nomNaissance = nomNaissance;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.medecinG = medecinG;
        this.PHResponsable = ph;
    }
    
    public Patient(String nomUsuel, String prenom, Date dateNaissance){
        super(nomUsuel, prenom);
        this.dateNaissance=dateNaissance;
    }

    public Patient(String ipp, String nomUsuel, String nomNaissance, String prenom, Adresse adresse, Date dateNaissance, Sexe sexe, MedG medecinG,
            boolean hospitalise, Service localisationService, Timestamp dateEdition) {
        super(nomUsuel, prenom);
        this.ipp = ipp;
        this.nomNaissance = nomNaissance;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.medecinG = medecinG;
        this.localisationService = localisationService;
        if (hospitalise == true) {
            this.hospitalise = true;
        } else {
            this.hospitalise = false;
        }
        this.dateEdition = dateEdition;
        this.listeSejour = new ArrayList<Sejour>();
    }

    public boolean equals(Patient p) {
        return (this.ipp.equalsIgnoreCase(p.getIpp()));
    }

     /**
     * Renvoie le prenom, le nom, la date de naissance, le sexe et le numero de
     * securite sociale d'un patient
     * @return Retourne un paramètre de type String
     */
    public String toString() {
        return getPrenom() + " " + getNomUsuel() + " - " + getDateNaissance().toStringN() + " / " + getSexe()+ " / " + getIpp();
        }
    
    /**
     * Renvoie le prenom, le nom usuel, la date de naissance, le sexe et le numero d'un patient
     * @return Retourne un paramètre de type String
     */
    public String toStringF() {
        return getPrenom() + " " + getNomUsuel() + " - " + getDateNaissance().toStringN() + " / " + getSexe() + " / Numero id : " + getIpp();
        }
    
    /**
     * Renvoie le prenom et le nom usuel d'un patient
     * @return un String, le prenom et le nom
     */
    public String toStringT() {
        return getPrenom() + " " + getNomUsuel();
        }
    
    /**
     * Permet de verifier si un objet est de type Patient
     * @param o prend un objet
     * @return true si l'objet est de type patient, false sinon
     */
    public boolean equals(Object o) {
        if (o instanceof Patient) {
            Patient p = (Patient)o;
            return getNomUsuel().equals(p.getNomUsuel()) && getPrenom().equals(p.getPrenom()) && (this.ipp == p.getIpp());
            }
        else
            return false;
        }    
    
    
    /*public boolean addSejour(int numSejour, Date dateArrive, String lit, String phresponssable, Service service, Personnel auteur) {
        boolean j = false;
        Sejour sejour= new Sejour();
        if (this.hospitalise == false) {
            try {
                String requete = "INSERT INTO sejour(ipp,numsejour,datearrive,lit,phresponssable,service,auteur,dateEdition,lettredesortie) "
                        + "VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? ) ";
                PreparedStatement state = ConnexionBD.getInstance().prepareStatement(requete);
                state.setString(1, this.ipp);
                state.setInt(2, numSejour);
                state.setDate(3, dateArrive);
                state.setString(4, lit);
                state.setString(5, phresponssable);
                state.setString(6, service.toString());
                state.setString(7, auteur.getId());
                java.util.Date now = new java.util.Date();
                java.sql.Timestamp nownow = new java.sql.Timestamp(now.getTime());
                state.setTimestamp(8, nownow);
                state.setString(9, "");
                int i = state.executeUpdate();
                if (i == 1) {
                    j = true;
                    Sejour sejour = new Sejour(numSejour, dateArrive, dateSortie, phresponssable, auteur.getId(), lit, service, nownow);
                    this.listeSejour.add(sejour);
                    setLocalisationService(service);
                    setHospitalise();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            j = false;
        }
        setHospitalise();
        return j;
    }

    public void setHospitalise() {
        try {
            String requete = "UPDATE dpi SET hospitalise = ? ";
            requete += " WHERE ipp= ? ";
            PreparedStatement state = ConnexionBD.getInstance().prepareStatement(requete);
            state.setInt(1, 1);
            state.setString(2, this.ipp);
            state.executeUpdate();
            state.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setNonHospitalise() {
        try {
            String requete = "UPDATE dpi SET hospitalise = ? ";
            requete += " WHERE ipp= ? ";
            PreparedStatement state = ConnexionBD.getInstance().prepareStatement(requete);
            state.setInt(1, 0);
            state.setInt(2, this.ipp);
            state.executeUpdate();
            state.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getNewNumSejour() {
        int numSejour = 0;
        try {

            String requete = "SELECT count(numsejour) FROM sejour;";
            Statement state = ConnexionBD.getInstance().createStatement();
            ResultSet res = state.executeQuery(requete);
            if (res.next()) {
                java.util.Date now = new java.util.Date();
                java.sql.Date nownow = new java.sql.Date(now.getTime());
                numSejour = (res.getInt(1) + 1) + (nownow.getYear() % 100) * 10000000 + (nownow.getMonth() + 1) * 100000;
            } else {
                numSejour = 0;
            }
            res.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numSejour;
    }

    public void updateSejour() {
        this.listeSejour.clear();
        try {
            String requete = "SELECT * FROM sejour";
            requete += " WHERE ipp= ? ";
            PreparedStatement state = ConnexionBD.getInstance().prepareStatement(requete);
            state.setString(1, this.ipp);
            state.execute();
            ResultSet res = state.getResultSet();
            while (res.next()) {
                if (res.getString("lettredesortie").equals("")) {
                    Sejour sejour = new Sejour(res.getInt("numsejour"), res.getDate("datearrive"), res.getString("phresponssable"),
                            res.getString("auteur"), res.getString("lit"), Service.valueOf(res.getString("service")), res.getTimestamp("dateEdition"));
                    getListeSejour().add(sejour);
                } else {
                    Sejour sejour = new Sejour(res.getInt("numsejour"), res.getDate("datearrive"), res.getString("phresponssable"),
                            res.getString("auteur"), res.getString("lit"), Service.valueOf(res.getString("service")), res.getTimestamp("dateEdition"), res.getString("lettredesortie"), res.getTimestamp("datesortie"));
                    getListeSejour().add(sejour);
                }

            }
            state.close();
            res.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean setLocalisationService(Service service) {
        boolean j = false;
        this.localisationService = service;
        try {
            String requete = "UPDATE dpi SET localisationservice = ? ";
            requete += " WHERE ipp = ? ";
            PreparedStatement state = ConnexionBD.getInstance().prepareStatement(requete);
            state.setString(1, service.toString());
            state.setString(2, this.ipp);
            int i = state.executeUpdate();
            if (i == 1) {
                j = true;
            }
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return j;
    } */

    // GETTERS & SETTERS
    /**
     * @return the ipp
     */
    public String getIpp() {
        return ipp;
    }

    public DPI getDpi() {
        return dpi;
    }

    /**
     * @return the nom
     */
    public String getNomUsuel() {
        return nomUsuel;
    }

    public String getNomNaissance() {
        return nomNaissance;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @return the dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @return the sexe
     */
    public Sexe getSexe() {
        return sexe;
    }

    /**
     * @return the adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * @return the nationnalité
     */
    public String getNationalite() {
        return nationalite;
    }

    /**
     * @return the medecinG
     */
    public MedG getMedecinG() {
        return medecinG;
    }
/*
    public static Patient getPatient(int IPP) {
        Patient p = null;
        try {
            String requeteSql = " SELECT * FROM dpi NATURAL JOIN codepostal ";
            requeteSql += " WHERE ipp= ? ";
            PreparedStatement state = ConnexionBD.getInstance().prepareStatement(requeteSql);
            state.setInt(1, IPP);
            state.execute();
            ResultSet res = state.getResultSet();
            res.next();
            if (res.getString("localisationservice") == null) {
                p = new Patient(res.getString("ipp"), res.getString("nomusuel"), res.getString("nomdenaissance"), res.getString("prenom"), res.getString("nationalite"), Sexe.valueOf(res.getString("sexe")), res.getDate("datedenaissance"),
                        new Adresse(res.getString("ville"), res.getInt("codepostal"), res.getString("nomrue"), res.getInt("numadresse")), res.getString("medecingeneraliste"), null, res.getInt("hospitalise"), res.getTimestamp("dateedition"));

            } else {
                p = new Patient(res.getString("ipp"), res.getString("nomusuel"), res.getString("nomdenaissance"), res.getString("prenom"), res.getString("nationalite"), Sexe.valueOf(res.getString("sexe")), res.getDate("datedenaissance"),
                        new Adresse(res.getString("ville"), res.getInt("codepostal"), res.getString("nomrue"),res.getInt("numadresse")), res.getString("medecingeneraliste"), Service.valueOf(res.getString("localisationservice")), res.getInt("hospitalise"), res.getTimestamp("dateedition"));
            }
            res.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }*/

    /**
     * @return the hospitalise
     */
    public boolean getHospitalise() {
        return hospitalise;
    }

    /**
     * @return the dateEdition
     */
    public Timestamp getDateEdition() {
        return dateEdition;
    }

    /**
     * @param hospitalise the hospitalise to set
     */
    public void setHospitalise(boolean hospitalise) {
        this.hospitalise = hospitalise;
    }

    /**
     * @param dateEdition the dateEdition to set
     */
    public void setDateEdition(Timestamp dateEdition) {
        this.dateEdition = dateEdition;
    }
    
    public ArrayList<Sejour> getListeSejour(){
        return listeSejour;
    }
    
    //ajoute un sejour
    public void ajouterSejour(Sejour sejour){
        listeSejour.add(sejour);
    }
}
