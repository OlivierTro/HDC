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
public class Date {
    
    private int jour;
    private int mois;
    private int annee;
    private int heure;
    private int minute;
    
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

     
}
