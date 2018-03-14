/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OlivierTroussard
 */
public class ConnexionBD {

    private static String urlPilote = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://mysql-hdc.alwaysdata.net:3306/hdc";
    private static String user = "hdc_db";
    private static String passwd = "java";
    private static Connection connect;

    //Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
    public static Connection getInstance() {
        if (connect == null) {
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }

    Statement state;

    public ConnexionBD() {
        try {
            this.state = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Chargement du pilote
        try {
            Class.forName(urlPilote);
            System.out.println("Pilote chargé.");
        } catch (ClassNotFoundException e) {
            System.out.println("Pilote non trouvé.");
        }
        //Connexion a la BD
        try {
            connect = DriverManager.getConnection(url, "root", "");
            System.out.println("Base de donnée connectée.");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //Renvoie le service clinique ou service médico-technique correspondant au nom donné en paramètre
    public Service getService(String nomService) {
        Service service = null;
        if (nomService != null) {
            nomService = formatBD(nomService);
            try {
                service = (Service) (new ServiceC(NomSC.valueOf(nomService)));
            } catch (IllegalArgumentException e1) {
                try {
                    service = (Service) (new ServiceMT(NomSMT.valueOf(nomService)));
                } catch (IllegalArgumentException e2) {
                }
            }
        }
        return service;
    }

    //Change les consultations en hospitalisations lorsque la date d'entrée est inférieure à la date du jour
    public void miseAJourVisites() {
        ArrayList<Visite> visitesEnCours = getVisites("Select * from visites where lettresortie is null;");
        TypeVisite typeVisite = null;
        if (visitesEnCours != null) {
            for (Visite v : visitesEnCours) {
                if (v.getDateEntree().before(new java.util.Date()) && v.getService() instanceof ServiceC) {
                    typeVisite = TypeVisite.Hospitalisation;
                    try {
                        Statement st = connect.createStatement();
                        st.executeUpdate("update visites "
                                + "set typevisite='" + typeVisite.toString()
                                + "' where nosj='" + v.getNumeroDeSejour() + "';");
                    } catch (SQLException e) {
                        System.out.println("Echec de la mise a jour des types de visite");
                    }
                }
            }
        }
    }

    //Met à jour la prestation donnée en paramètre en y ajoutant le résultat, le praticien opérateur 
    //et la date de réalisation de la prestation dans la base de données
    public boolean envoyerResultat(Prestation p, String resultat, PraticienHospitalier ph) {
        boolean succes = false;
        try {
            Statement st = connect.createStatement();
            st.executeUpdate("update prestations "
                    + "set operateur='" + ph.getIdentifiant()
                    + "' , resultat='" + resultat
                    + "' , daterealisation='" + new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())
                    + "' where ipppatient='" + p.getPatient().getIPP() + "' and service='" + formatBD(ph.getService().getNom()) + "';");
            succes = true;
        } catch (SQLException e) {
            System.out.println("Echec de l'ajout du résultat dans la BD");
            System.out.println(e);
        }
        return succes;
    }

    //Renvoie un String ("Clinique" ou "Médico-Technique") correspondant au type du service dont le nom est donné en paramètre
    public String getTypeService(String nomService) {
        Service s = getService(nomService);        
        return s.getType();
    }

    //Renvoie l'instance de PraticienHospitalier dont les données correspondent à l'identifiant donné en paramètre
    public PraticienHospitalier getPH(String idPH) {
        PraticienHospitalier pHRespo = null;
        if (idPH != null) {
            try {
                Statement st = cnx.createStatement();
                ResultSet rst = st.executeQuery("select * from utilisateurs where profession='Praticien hospitalier' and id='" + idPH + "';");
                while (rst.next()) {
                    String nom = rst.getString("nom");
                    String prenom = rst.getString("prenom");
                    String mdp = rst.getString("mdp");
                    Service service = getService(rst.getString("service"));
                    pHRespo = new PraticienHospitalier(nom, prenom, idPH, mdp, service);
                }
            } catch (SQLException e) {
                System.out.println("Aucun PH trouvé pour l'id " + idPH);
            }
        }
        return pHRespo;
    }

    //Renvoie les identifiants des PraticiensHospitalier correspondants au nom et au prénom donnés en paramètres
    public ArrayList<String> getIDsPH(String nom, String prenom) {
        ArrayList<String> idsPH = new ArrayList<String>();
        if (!nom.equals("") || !prenom.equals("")) {
            String requete = "select id from utilisateurs where profession='Praticien hospitalier'";
            if (!nom.equals("")) {
                requete += " and nom='" + nom + "'";
            }
            if (!prenom.equals("")) {
                requete += " and prenom='" + prenom + "'";
            }
            requete += ";";
            try {
                Statement st = cnx.createStatement();
                ResultSet rst = st.executeQuery(requete);
                while (rst.next()) {
                    idsPH.add(rst.getString("id"));
                }
            } catch (SQLException e) {
                System.out.println("Aucun PH trouvé pour le nom " + nom + " et le prenom " + prenom);
            }
        }
        return idsPH;
    }

    //Renvoie les instances de PraticienHospitalier dont le nom de service est donné en paramètre
    public ArrayList<PraticienHospitalier> getPHsService(String nomService) {
        ArrayList<PraticienHospitalier> pHsService = new ArrayList<PraticienHospitalier>();
        if (nomService != null & !nomService.equals("")) {
            try {
                Statement st = cnx.createStatement();
                ResultSet rst = st.executeQuery("select * from utilisateurs where profession='Praticien hospitalier' and service='" + formatBD(nomService) + "';");
                while (rst.next()) {
                    String nom = rst.getString("nom");
                    String prenom = rst.getString("prenom");
                    String id = rst.getString("id");
                    String mdp = rst.getString("mdp");
                    Service service = getService(rst.getString("service"));
                    PraticienHospitalier pH = new PraticienHospitalier(nom, prenom, id, mdp, service);
                    pHsService.add(pH);
                }
            } catch (SQLException e) {
                System.out.println("Aucun PH trouvé pour le service " + nomService);
            }
        }
        return pHsService;
    }

    //Adapte la chaîne de caractères donnée en paramètre 
    //pour qu'elle soit compatible avec la base de données
    //et les requêtes SQL et supprime les caractères non acceptés
    //(espaces, apostrophes,accents,...)
    public String formatBD(String s) {
        s = s.replaceAll("[èéêë]", "e");
        s = s.replaceAll("[ûù]", "u");
        s = s.replaceAll("[ïî]", "i");
        s = s.replaceAll("[àâ]", "a");
        s = s.replaceAll("Ô", "o");
        s = s.replaceAll("[ÈÉÊË]", "E");
        s = s.replaceAll("[ÛÙ]", "U");
        s = s.replaceAll("[ÏÎ]", "I");
        s = s.replaceAll("[ÀÂ]", "A");
        s = s.replaceAll("Ô", "O");
        s = s.replaceAll("-", "");
        s = s.replaceAll("'", "");
        s = s.replaceAll(" ", "");
        return s;
    }

    public String formatStringAccepte(String s) {
        s = s.replaceAll("'", "");
        return s;
    }

    //Génère un IPP automatiquement en fonction de ceux déjà présent dans la base de données et en respectant le format imposé dans l'appel d'offre
    public String genererIPP() {
        String dateAA = new SimpleDateFormat("yy").format(new java.util.Date()).toUpperCase();
        ArrayList<Patient> patients = getPatients("Select * from patients where ipp like '" + dateAA + "%';");
        String IPP = null;
        if (patients != null) {
            IPP = dateAA + String.format("%07d", patients.size());
        }
        return IPP;
    }

    //Génère un numéro de séjour automatiquement en fonction de ceux déjà présent dans la base de données et en respectant le format imposé dans l'appel d'offre
    public String genererNumSejour() {
        String dateAA = new SimpleDateFormat("yyMM").format(new java.util.Date()).toUpperCase();
        ArrayList<Visite> visites = getVisites("Select * from visites where nosj like '" + dateAA + "%';");
        String numSejour = null;
        numSejour = dateAA + String.format("%05d", visites.size());
        return numSejour;
    }

    //Renvoie une instance de Visite correspondant à la visite en cours du patient donné en paramètre
    public Sejour getSejourCourant(Patient p) {
        ArrayList<Sejour> sejours = getSejour("Select * from sejour where ipp='" + p.getIpp() + "' and lettreSortie is null and dateSortie is null order by dateEntree desc;");
        Sejour s = null;
        if (sejours.size() > 0) {
            s = sejours.get(0);
        }
        return s;
    }

    //Renvoie une instance de Visite correspondant au numéro de séjour donné en paramètre
    public Sejour getSejour(String numSejour) {
        ArrayList<Sejour> sejours = getSejours("Select * from sejour where numSejour='" + numSejour + "';");
        Sejour s = null;
        if (sejours.size() == 1) {
            s = sejours.get(0);
        } else {
            System.out.println("Visite introuvable pour le nosj " + numSejour);
        }
        return s;
    }

    //Renvoie la date d'entrée de la visite courante du patient donné en paramètre
    public java.util.Date getDateEntree(Patient p) {
        java.util.Date d = null;
        Visite v = getVisiteCourante(p);
        if (v != null) {
            d = v.getDateEntree();
        }
        return d;
    }

    //Provoque la fermeture du dossier du patient donné en paramètre en mettant à jour les informations relatives
    //à sa visite et en ajoutant la lettre de sortie donnée en paramètre (renvoie un booléen qui est vrai si la manipulation a bien été effectuée)
    public boolean fermerDossier(Patient p, String lettreSortie) {
        boolean fermetureOK = false;
        Visite v = getVisiteCourante(p);
        TypeVisite typeVisite = null;
        if (v.getDateEntree().before(new java.util.Date()) && v.getService() instanceof ServiceClinique) {
            typeVisite = TypeVisite.Hospitalisation;
        } else if (v.getDateEntree().equals(v.getDateSortie())) {
            typeVisite = TypeVisite.Consultation;
        } else {
            typeVisite = v.getType();
        }
        if (v != null) {
            try {
                Statement st = cnx.createStatement();
                st.executeUpdate("update visites "
                        + "set datesortie='" + new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())
                        + "' ,  lettreSortie='" + lettreSortie
                        + "' , typevisite='" + typeVisite.toString()
                        + "' where nosj='" + v.getNumeroDeSejour() + "';");
                fermetureOK = true;
            } catch (SQLException e) {
                System.out.println("Echec de l'ajout Date et Lettre de sortie");
            }
            try {
                Statement st = cnx.createStatement();
                st.executeUpdate("update patients set service=null ,  phresponsable=null where ipp='" + p.getIPP() + "';");
            } catch (SQLException e) {
                fermetureOK = false;
                System.out.println("Echec de la sortie du patient du service");
            }
        }
        return fermetureOK;
    }

    //Permet d'ajouter une nature de soin dans la base de données
    public void ajouterNatureSoin(String natureSoin) {
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate("insert into naturessoin (naturesoin) values ('" + natureSoin + "');");
        } catch (SQLException e) {
            System.out.println("Echec de l'ajout de la nature de soin.");
        }
    }

    //Permet d'ajouter un soin dans la base de données (renvoie un booléen vrai si l'ajout a bien été effectué)
    public boolean ajouterSoin(Soin s) {
        boolean b = false;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate("insert into soins (ipppatient,visite,soignant,naturesoin,date)"
                    + " values ('" + s.getPatient().getIPP() + "','"
                    + s.getVisite().getNumeroDeSejour() + "','"
                    + s.getSoignant().getIdentifiant() + "','"
                    + s.getNatureSoin() + "','"
                    + new SimpleDateFormat("yyyy-MM-dd hh:mm").format(s.getDate()) + "');");
            b = true;
        } catch (SQLException e) {
            System.out.println("Echec de l'ajout du soin.");
            System.out.println(e);
        }
        return b;
    }

    //Renvoie l'instance de Professionnel correspondant à l'identifiant et au mot de passe donnés en paramètres
    public Professionnel trouverUtilisateur(String id, String mdp) {
        Professionnel p = null;
        try {
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery("select * from utilisateurs where ID='" + id + "' and MDP='" + mdp + "';");
            rst.last();
            String profession = rst.getString("PROFESSION");
            Service service = null;
            if (!profession.equals("Secrétaire médicale")) {
                service = getService(rst.getString("SERVICE"));
            }
            switch (profession) {
                case "Interne":
                    p = new Interne(rst.getString("Nom"), rst.getString("Prenom"), id, mdp, service);
                    break;
                case "Praticien hospitalier":
                    p = new PraticienHospitalier(rst.getString("Nom"), rst.getString("Prenom"), id, mdp, service);
                    break;
                case "Secrétaire médicale":
                    p = new SecretaireMedicale(rst.getString("Nom"), rst.getString("Prenom"), id, mdp);
                    break;
                case "Infirmier(e)":
                    p = new Infirmier(rst.getString("Nom"), rst.getString("Prenom"), id, mdp, service);
                    break;
            }
        } catch (SQLException e) {
            System.out.println("Probleme de lecture des données utilisateurs dans la BD");
        }
        return p;
    }

    //Met à jour le service et le praticien responsable du patient selon les instances données en paramètres
    //(et renvoie un booléen vrai si la mise à jour a bien été effectuée)
    public boolean admettrePatientService(Patient p, Service s, PraticienHospitalier phResp) {
        boolean admis = false;
        ArrayList<Patient> patientsNonAdmis = getPatientsService(null);
        if (p.estDansListe(patientsNonAdmis)) {
            try {
                Statement st = cnx.createStatement();
                String requete = "UPDATE patients SET service='" + formatBD(s.getNom());
                if (!formatBD(s.getNom()).equals(NomSMT.Radiologie.toString())) {
                    requete += "' ,  phresponsable='" + phResp.getIdentifiant();
                }
                requete += "' where ipp='" + p.getIPP() + "';";
                st.executeUpdate(requete);
                admis = true;
            } catch (SQLException e) {
                System.out.println("Echec de la modification");
            }
        }
        return admis;
    }

    //Renvoie une liste des patients admis dans le service donné en paramètre
    public ArrayList<Patient> getPatientsService(Service service) {
        ArrayList<Patient> patients = new ArrayList<Patient>();
        try {
            Statement st = cnx.createStatement();
            ResultSet rst;
            if (service == null) {
                rst = st.executeQuery("select * from patients where service is null;");
            } else {
                rst = st.executeQuery("select * from patients where service='" + formatBD(service.getNom()) + "';");
            }
            while (rst.next()) {
                String ipp = rst.getString("ipp");
                String nom = rst.getString("nom");
                String prenom = rst.getString("prenom");
                java.util.Date d = rst.getDate("datenaissance");
                PraticienHospitalier responsable = null;
                String adresse = rst.getString("adresse");
                Sexe sexe = Sexe.valueOf(rst.getString("sexe"));

                Patient p = new Patient(ipp, nom, prenom, d, responsable, adresse, sexe, service);
                patients.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Aucun patient trouvé pour le service " + service.getNom());
        }
        return patients;
    }

    //Renvoie une liste des patients admis dans le service donné en paramètre pour une prestation
    public ArrayList<Patient> getPatientsPrestationService(Service service) {
        ArrayList<Patient> patients = new ArrayList<Patient>();
        try {
            Statement st = cnx.createStatement();
            String requete = "select * from patients where ipp in (select ipppatient from prestations where service='" + formatBD(service.getNom()) + "' and resultat is null);";
            ResultSet rst = st.executeQuery(requete);
            while (rst.next()) {
                String ipp = rst.getString("ipp");
                String nom = rst.getString("nom");
                String prenom = rst.getString("prenom");
                java.util.Date d = rst.getDate("datenaissance");
                PraticienHospitalier responsable = null;
                String adresse = rst.getString("adresse");
                Sexe sexe = Sexe.valueOf(rst.getString("sexe"));
                Patient p = new Patient(ipp, nom, prenom, d, responsable, adresse, sexe, service);
                patients.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Aucun patient trouvé pour le service " + service.getNom());
        }
        return patients;
    }

    //Renvoie la liste des services cliniques enregistrés dans la base de données
    public ArrayList<ServiceClinique> getServicesCliniques() {
        ArrayList<ServiceClinique> servicesC = new ArrayList<ServiceClinique>();
        try {
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery("select * from services where TYPE='Clinique';");
            while (rst.next()) {
                Service s = getService(rst.getString("NOM"));
                servicesC.add((ServiceClinique) s);
            }
        } catch (SQLException e) {
            System.out.println("Aucun service clinique trouvé dans la BD");
            servicesC = null;
        }
        return servicesC;
    }

    //Renvoie la liste des services médico-techniques enregistrés dans la base de données
    public ArrayList<ServiceMedicoTechnique> getServicesMedicoTechniques() {
        ArrayList<ServiceMedicoTechnique> servicesMT = new ArrayList<ServiceMedicoTechnique>();
        try {
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery("select * from services where TYPE='Médico-technique';");
            while (rst.next()) {
                Service s = getService(rst.getString("NOM"));
                servicesMT.add((ServiceMedicoTechnique) s);
            }
        } catch (SQLException e) {
            System.out.println("Aucun service médico-technique trouvé dans la BD");
            servicesMT = null;
        }
        return servicesMT;
    }

    //Renvoie la liste de tous les services enregistrés dans la base de données
    public ArrayList<Service> getAllServices() {
        ArrayList<Service> services = new ArrayList<Service>();
        try {
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery("select * from services;");
            while (rst.next()) {
                Service s = getService(rst.getString("NOM"));
                services.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Aucun service trouvé dans la BD");
            services = null;
        }
        return services;
    }

    //Renvoie la liste de tous les patients enregistrés dans la base de données
    public ArrayList<Patient> getAllPatients() {
        ArrayList<Patient> patients = getPatients("select * from patients;");
        return patients;
    }

    //Renvoie la liste des patients correspondant à la requête SQL donnée en paramètre
    public ArrayList<Patient> getPatients(String requete) {
        ArrayList<Patient> patients = new ArrayList<Patient>();
        try {
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery(requete);
            int i = 0;
            while (rst.next()) {
                String ipp = rst.getString("ipp");
                String nom = rst.getString("nom");
                String prenom = rst.getString("prenom");
                java.util.Date d = rst.getDate("datenaissance");
                String adresse = rst.getString("adresse");
                Sexe sexe = Sexe.valueOf(rst.getString("sexe"));
                Service service = getService(rst.getString("service"));
                PraticienHospitalier responsable = getPH(rst.getString("phresponsable"));
                Patient p = new Patient(ipp, nom, prenom, d, responsable, adresse, sexe, service);
                patients.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Aucun patient trouvé dans la BD");
            patients = null;
        }
        return patients;
    }

    //Renvoie le Patient dont l'ipp est donné en paramètre
    public Patient getPatient(String ipp) {
        ArrayList<Patient> patients = getPatients("Select * from patients where ipp='" + ipp + "';");
        Patient p = null;
        if (patients.size() == 1) {
            p = patients.get(0);
        }
        return p;
    }

    //Renvoie la liste des visites du patient donné en paramètre ordonnée de la date d'entrée la plus récente à la plus ancienne
    public ArrayList<Sejour> getVisitesOrdre(Patient p) {
        return getSejours("Select * from visites where ipp='" + p.getIpp() + "' order by dateEntree desc;");
    }

    //Renvoie la liste des visites correspondant à la requête SQL donnée en paramètre
    public ArrayList<Sejour> getSejours(String requete) {
        ArrayList<Sejour> sejours = new ArrayList<Sejour>();
        try {
            Statement st = connect.createStatement();
            ResultSet rst = st.executeQuery(requete);
            int i = 0;
            while (rst.next()) {
                String numSejour = rst.getString("nosj");
                java.util.Date dateEntree = rst.getDate("dateentree");
                String nomPH = getPH(rst.getString("phresponsable"));
                String ippPatient = rst.getString("ipppatient");
                TypeSejour typeVisite = TypeSejour.valueOf(rst.getString("typevisite"));
                java.util.Date dateSortie = rst.getDate("datesortie");
                String lettreSortie = rst.getString("lettresortie");
                Service service = getService(rst.getString("service"));
                ArrayList<String> listePrescription = getPrescriptions
                Sejour s = new Sejour(numSejour, dateEntree, dateSortie, nomPH, service, lettreSortie, listePrecription);
                sejours.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Aucun patient trouvé dans la BD");
            sejours = null;
        }
        return sejours;
    }

    //Renvoie la liste des prescriptions pour le patient et sa visite donnés en paramètres
    public ArrayList<Prescription> getPrescriptions(Patient patient, Sejour Sejour) {
        ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();
        try {
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery("Select * from prescriptions where ipppatient='" + patient.getIPP() + "' and visite='" + visite.getNumeroDeSejour() + "';");
            while (rst.next()) {
                PraticienHospitalier prescripteur = getPH(rst.getString("prescripteur"));
                String objet = rst.getString("objet");
                java.util.Date dateDebut = rst.getDate("datedebut");
                java.util.Date dateFin = rst.getDate("datefin");
                Prescription p = new Prescription(patient, visite, prescripteur, objet, dateDebut, dateFin);
                prescriptions.add(p);
            }
        } catch (SQLException e) {
            prescriptions = null;
            System.out.println("Aucune prescription dans la BD pour le patient");
        }
        return prescriptions;
    }

    //Renvoie la liste des prestations pour le patient et sa visite donnés en paramètres
    public ArrayList<Prestation> getPrestations(Patient p, Sejour v) {
        ArrayList<Prestation> prestations = new ArrayList<Prestation>();
        try {
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery("Select * from prestations where ipppatient='" + p.getIPP() + "' and visite='" + v.getNumeroDeSejour() + "';");
            while (rst.next()) {
                PraticienHospitalier demandeur = getPH(rst.getString("demandeur"));
                Service s = getService(rst.getString("service"));
                String demande = rst.getString("demande");
                java.util.Date dateDemande = rst.getDate("datedemande");
                PraticienHospitalier operateur = getPH(rst.getString("operateur"));
                String resultat = rst.getString("resultat");
                java.util.Date dateRealisation = rst.getDate("daterealisation");
                Prestation presta = new Prestation(p, v, demandeur, s, demande, dateDemande, operateur, resultat, dateRealisation);
                prestations.add(presta);
            }
        } catch (SQLException e) {
            prestations = null;
            System.out.println("Aucune prestation dans la BD pour cette visite");
        }
        return prestations;
    }

    //Renvoie la liste des prestations pour le patient dans le service donnés en paramètres
    public ArrayList<Prestation> getPrestations(Patient p, Service s) {
        ArrayList<Prestation> prestations = new ArrayList<Prestation>();
        try {
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery("Select * from prestations where ipppatient='" + p.getIPP() + "' and service='" + formatBD(s.getNom()) + "';");
            while (rst.next()) {
                PraticienHospitalier demandeur = getPH(rst.getString("demandeur"));
                Visite v = getVisite(rst.getString("visite"));
                String demande = rst.getString("demande");
                java.util.Date dateDemande = rst.getDate("datedemande");
                PraticienHospitalier operateur = getPH(rst.getString("operateur"));
                String resultat = rst.getString("resultat");
                java.util.Date dateRealisation = rst.getDate("daterealisation");
                Prestation presta = new Prestation(p, v, demandeur, s, demande, dateDemande, operateur, resultat, dateRealisation);
                prestations.add(presta);
            }
        } catch (SQLException e) {
            prestations = null;
            System.out.println("Aucune prestation dans la BD pour cette visite");
        }
        return prestations;
    }

    //Renvoie la liste des soins pour le patient et sa visite donnés en paramètres
    public ArrayList<Soin> getSoins(Patient patient, Visite visite) {
        ArrayList<Soin> soins = new ArrayList<Soin>();
        try {
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery("Select * from soins where ipppatient='" + patient.getIPP() + "' and visite='" + visite.getNumeroDeSejour() + "';");
            while (rst.next()) {
                Professionnel soignant = getPH(rst.getString("soignant"));
                String natureSoin = rst.getString("naturesoin");
                Timestamp timestamp = rst.getTimestamp("date");
                java.util.Date date = null;
                if (timestamp != null) {
                    date = new java.util.Date(timestamp.getTime());
                }
                Soin s = new Soin(patient, visite, soignant, natureSoin, date);
                soins.add(s);
            }
        } catch (SQLException e) {
            soins = null;
            System.out.println("Aucun soin dans la BD pour le patient");
        }
        return soins;
    }

    //Renvoie la liste de toutes les natures de soin enregistrées dans la base de données
    public ArrayList<String> getNaturesSoin() {
        ArrayList<String> naturesSoin = new ArrayList<String>();
        try {
            Statement st = cnx.createStatement();
            ResultSet rst = st.executeQuery("Select * from naturessoin;");
            while (rst.next()) {
                naturesSoin.add(rst.getString("naturesoin"));
            }
        } catch (SQLException e) {
            naturesSoin = null;
            System.out.println("Aucune nature de soin trouvé");
        }
        return naturesSoin;
    }

    //Ajoute dans la base de données le patient donné en paramètre (et renvoie un booléen vrai si l’ajout a bien été effectué)
    public boolean ajouterPatient(Patient p) {
        ArrayList<Patient> patients = getAllPatients();
        boolean patientExisteDeja = p.estDansListe(patients);
        if (!patientExisteDeja) {
            String requete = "insert into "
                    + "patients (ipp,nom,prenom,sexe,datenaissance,adresse,service)"
                    + " values ('"
                    + p.getIPP() + "','"
                    + p.getNom() + "','"
                    + p.getPrenom() + "','"
                    + p.getSexe().toString() + "','"
                    + (new SimpleDateFormat("yyyy-MM-dd").format(p.getDateDeNaissance())) + "','"
                    + p.getAdresse() + "',"
                    + null
                    + ");";
            try {
                Statement st = cnx.createStatement();
                st.executeUpdate(requete);
            } catch (SQLException e) {
                System.out.println("Echec de l'ajout du patient.");
            }
        }
        return (!patientExisteDeja);
    }

    //Ajoute dans la base de données la prescription donnée en paramètre (et renvoie un booléen vrai si l’ajout a bien été effectué)
    public boolean ajouterPrescription(Prescription p) {
        boolean succesAjout = false;
        try {
            Statement st = cnx.createStatement();
            String requete = "insert into "
                    + "prescriptions (ipppatient,visite,prescripteur,objet,datedebut,datefin)"
                    + " values ('"
                    + p.getPatient().getIPP() + "','"
                    + p.getVisite().getNumeroDeSejour() + "','"
                    + p.getPrescripteur().getIdentifiant() + "','"
                    + p.getObjet() + "','"
                    + (new SimpleDateFormat("yyyy-MM-dd").format(p.getDateDebut())) + "','"
                    + (new SimpleDateFormat("yyyy-MM-dd").format(p.getDateFin()))
                    + "');";
            st.executeUpdate(requete);
            succesAjout = true;
        } catch (SQLException e) {
            System.out.println("Echec de l'ajout de prescription");
            System.out.println(e);
        }
        return succesAjout;
    }

    //Ajoute dans la base de données la prestation donnée en paramètre (et renvoie un booléen vrai si l’ajout a bien été effectué)
    public boolean ajouterPrestation(Prestation p) {
        boolean succesAjout = false;
        try {
            Statement st = cnx.createStatement();
            String requete = "insert into "
                    + "prestations (ipppatient,visite,demandeur,service,demande,datedemande)"
                    + " values ('"
                    + p.getPatient().getIPP() + "','"
                    + p.getVisite().getNumeroDeSejour() + "','"
                    + p.getDemandeur().getIdentifiant() + "','"
                    + formatBD(p.getService().getNom()) + "','"
                    + p.getDemande() + "','"
                    + (new SimpleDateFormat("yyyy-MM-dd").format(p.getDateDemande())) + "');";
            st.executeUpdate(requete);
            succesAjout = true;
        } catch (SQLException e) {
            System.out.println("Echec de l'ajout de prestation");
            System.out.println(e);
        }
        return succesAjout;
    }

    //Ajoute dans la base de données la visite pour le patient donnés en paramètres (et renvoie un booléen vrai si l’ajout a bien été effectué)
    public boolean ajouterVisite(Visite v, Patient p) {
        boolean ajoutOK = true;
        String requete = "insert into "
                + "visites (nosj,dateentree,phresponsable,service,ipppatient,typevisite)"
                + " values ('"
                + v.getNumeroDeSejour() + "','"
                + (new SimpleDateFormat("yyyy-MM-dd").format(v.getDateEntree())) + "',";
        if (v.getService().getNom().equals(NomSMT.Radiologie.toString()) || v.getPhResponsable() == null) {
            requete += null + ",'";
        } else {
            requete += "'" + v.getPhResponsable().getIdentifiant() + "','";
        }
        requete += formatBD(v.getService().getNom()) + "','"
                + p.getIPP() + "','"
                + v.getType()
                + "');";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException e) {
            System.out.println("Echec de l'ajout.");
            ajoutOK = false;
        }
        return ajoutOK;
    }
}
