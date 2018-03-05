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
public class Patient {

    private String ipp;
    private String nomUsuel;
    private String nomNaissance;
    private String prenom;
    private Date dateNaissance;
    private Sexe sexe;
    private Adresse adresse;
    private DPI dpi;
    private String nationalite;
    private MedG medecinG;
    private boolean hospitalise;
    private Service localisationService;
    private Timestamp dateEdition;
    private ArrayList<Sejour> listeSejour;

    public Patient(String ipp, String nomUsuel, String nomNaissance, String prenom, Adresse adresse, Date dateNaissance, Sexe sexe, MedG medecinG) {
        this.ipp = ipp;
        this.nomUsuel = nomUsuel;
        this.nomNaissance = nomNaissance;
        this.prenom = prenom;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.medecinG = medecinG;
    }

    public Patient(String ipp, String nomUsuel, String nomNaissance, String prenom, Adresse adresse, Date dateNaissance, Sexe sexe, MedG medecinG,
            boolean hospitalise, Service localisationService, Timestamp dateEdition) {
        this.ipp = ipp;
        this.nomUsuel = nomUsuel;
        this.nomNaissance = nomNaissance;
        this.prenom = prenom;
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

    public boolean addSejour(int numSejour, Date dateArrive, String lit, String phresponssable, Service service, Personnel auteur) {
        boolean j = false;
        //Sejour sejour= new Sejour();
        if (this.hospitalise == false) {
            try {
                String requete = "INSERT INTO sejour(ipp,numsejour,datearrive,lit,phresponssable,service,auteur,dateEdition,lettredesortie) "
                        + "VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? ) ";
                PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
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
                    Sejour sejour = new Sejour(numSejour, dateArrive, phresponssable, auteur.getIdentifiant(), lit, service, nownow);
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
            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
            state.setInt(1, 1);
            state.setInt(2, this.ipp);
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
            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
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
            Statement state = ConnBD.getInstance().createStatement();
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
            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
            state.setInt(1, this.ipp);
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
            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
            state.setString(1, service.toString());
            state.setInt(2, this.ipp);
            int i = state.executeUpdate();
            if (i == 1) {
                j = true;
            }
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return j;
    }

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

    public static Patient getPatient(int IPP) {
        Patient p = null;
        try {
            String requeteSql = " SELECT * FROM dpi NATURAL JOIN codepostal ";
            requeteSql += " WHERE ipp= ? ";
            PreparedStatement state = ConnBD.getInstance().prepareStatement(requeteSql);
            state.setInt(1, IPP);
            state.execute();
            ResultSet res = state.getResultSet();
            res.next();
            if (res.getString("localisationservice") == null) {
                p = new Patient(res.getInt("ipp"), res.getString("nomusuel"), res.getString("nomdenaissance"), res.getString("prenom"), res.getString("nationalite"), Sexe.valueOf(res.getString("sexe")), res.getDate("datedenaissance"),
                        new Adresse(res.getString("ville"), res.getInt("codepostal"), res.getInt("numadresse"), res.getString("nomrue")), res.getString("medecingeneraliste"), null, res.getInt("hospitalise"), res.getTimestamp("dateedition"));

            } else {
                p = new Patient(res.getInt("ipp"), res.getString("nomusuel"), res.getString("nomdenaissance"), res.getString("prenom"), res.getString("nationalite"), Sexe.valueOf(res.getString("sexe")), res.getDate("datedenaissance"),
                        new Adresse(res.getString("ville"), res.getInt("codepostal"), res.getInt("numadresse"), res.getString("nomrue")), res.getString("medecingeneraliste"), Service.valueOf(res.getString("localisationservice")), res.getInt("hospitalise"), res.getTimestamp("dateedition"));
            }
            res.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

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

}
