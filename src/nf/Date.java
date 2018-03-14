package nf;

public class Date implements Comparable {

    private int jour;
    private int mois;
    private int annee;
    private int heure;
    private int minute;

    /**
     * Permet de creer une instance de Date, selon un jour, un mois, une annee
     *
     * @param jour prend un int, le jour
     * @param mois prend un int, le mois
     * @param annee prend un int, l'annee
     */
    public Date(int jour, int mois, int annee) {
        boolean dateValide = false;
        if ((mois >= 1 && mois <= 12) && (jour >= 1 && jour <= 31)) {
            //Mois avec 30 jour
            if ((mois == 4 || mois == 6 || mois == 9 || mois == 11) && (jour <= 30)) {
                dateValide = true;
            }

            //Mois avec 31 jour
            if ((mois == 1 || mois == 2 || mois == 3 || mois == 5 || mois == 7 || mois == 8 || mois == 10 || mois == 12) && (jour <= 31)) {
                dateValide = true;
            }

            //Février
            if ((mois == 2) && (jour < 30)) {
                //vérif année bisextile
                boolean anneeBisextileValide = false;

                //vérif année bisextile est divisible par 4 mais pas par 100 sauf si divisible par 400
                if ((annee % 400 == 0) || ((annee % 4 == 0) && (annee % 100 != 0))) {
                    anneeBisextileValide = true;
                }

                if (anneeBisextileValide == true && jour <= 29) {
                    dateValide = true;
                } else if (anneeBisextileValide == false && jour <= 28) {
                    dateValide = true;
                }
            }
        }

        if (dateValide == true) {
            this.annee = annee;
            this.mois = mois;
            this.jour = jour;
        } else {
            throw new IllegalArgumentException("La date est invalide");
        }
    }

    /**
     * Permet de creer une instance de Date selon un jour, un mois, une annee,
     * des heures, des minutes
     *
     * @param jour prend un int, le jour
     * @param mois prend un int, le mois
     * @param annee prend un int, l'annee
     * @param heure prend un int, l'heure
     * @param minute prend un int, les minutes
     */
    public Date(int jour, int mois, int annee, int heure, int minute) {
        boolean dateValide = false;
        if ((mois >= 1 && mois <= 12) && (jour >= 1 && jour <= 31)) {
            //Mois avec 30 jour
            if ((mois == 4 || mois == 6 || mois == 9 || mois == 11) && (jour <= 30)) {
                dateValide = true;
            }

            //Mois avec 31 jour
            if ((mois == 1 || mois == 2 || mois == 3 || mois == 5 || mois == 7 || mois == 8 || mois == 10 || mois == 12) && (jour <= 31)) {
                dateValide = true;
            }

            //Fevrier
            if ((mois == 2) && (jour < 30)) {
                //vérif année bissextile
                boolean anneeBisextileValide = false;

                //vérif année bissextile est divisible par 4 mais pas par 100 sauf si divisible par 400
                if ((annee % 400 == 0) || ((annee % 4 == 0) && (annee % 100 != 0))) {
                    anneeBisextileValide = true;
                }

                if (anneeBisextileValide == true && jour <= 29) {
                    dateValide = true;
                } else if (anneeBisextileValide == false && jour <= 28) {
                    dateValide = true;
                }
            }
        }

        if (dateValide == true) {
            this.annee = annee;
            this.mois = mois;
            this.jour = jour;
        } else {
            throw new IllegalArgumentException("La date est invalide");
        }

        if (heure <= 23 || heure >= 0) {
            this.heure = heure;
        } else {
            throw new IllegalArgumentException("La date est invalide");
        }
        if (minute <= 59 || minute >= 0) {
            this.minute = minute;
        } else {
            throw new IllegalArgumentException("La date est invalide");
        }
    }

    /**
     * Permet d'obtenir l'annee, le mois, le jour, l'heure et les minutes
     *
     * @return un String
     */
    public String toString() {
        String s = "";
        s += getAnnee() + "-";
        if (getMois() < 10) {
            s += "0" + getMois() + "-";
        } else {
            s += getMois() + "-";
        }
        if (getJour() < 10) {
            s += "0" + getJour() + "/";
        } else {
            s += getJour() + "/";
        }
        if (heure < 10) {
            s += "0" + heure + ":";
        } else {
            s += heure + ":";
        }
        if (minute < 10) {
            s += "0" + minute;
        } else {
            s += minute;
        }
        return s;
    }

    /**
     * Permet d'obtenir l'annee, le mois et le jour
     *
     * @return un String
     */
    public String toStringN() {
        String s = "";
        s += getAnnee() + "-";
        if (getMois() < 10) {
            s += "0" + getMois() + "-";
        } else {
            s += getMois() + "-";
        }
        if (getJour() < 10) {
            s += "0" + getJour();
        } else {
            s += getJour();
        }
        return s;
    }

    /**
     * Permet de verifier si deux objets sont identiques, ici des dates
     * @param o prend un objet
     * @return true si les deux dates correspondent, false sinon
     */
    public boolean equals(Object o) {
        if (o instanceof Date) {
            Date d = (Date) o;
            return (getAnnee() == d.getAnnee()) && (getMois() == d.getMois()) && (getJour() == d.getJour()) && (heure == d.heure) && (minute == d.minute);
        } else {
            return false;
        }
    }

    // precondition : 'o' est une instance de 'Date' :
    public int compareTo(Object o) {
        Date d = (Date) o;
        if (getAnnee() != d.getAnnee()) {
            return getAnnee() - d.getAnnee();
        }
        // ici on a forcement annee == d.annee :
        if (getMois() != d.getMois()) {
            return getMois() - d.getMois();
        }
        // ici on a forcement annee == d.annee et mois == d.mois :
        if (getJour() != d.getJour()) {
            return getJour() - d.getJour();
        }
        if (heure != d.heure) {
            return heure - d.heure;
        }
        return minute - d.minute;
    }

    /**
     * @return the jour
     */
    public int getJour() {
        return jour;
    }

    /**
     * @return the mois
     */
    public int getMois() {
        return mois;
    }

    /**
     * @return the annee
     */
    public int getAnnee() {
        return annee;
    }

}
