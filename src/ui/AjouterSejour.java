/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import nf.Date;
import nf.Patient;
import nf.Personnel;
import nf.Sejour;
import nf.Service;

/**
 *
 * @author ANNELAURE
 */
public class AjouterSejour extends javax.swing.JFrame {
    public Personnel utilisateur;
    /**
     * Creates new form AjouterSejour
     */
    public AjouterSejour(Personnel utilisateur) {
        initComponents();
        this.setTitle("Ajouter un séjour");
        this.setSize(1400,740);
        this.utilisateur=utilisateur;
        nomUt.setText(utilisateur.getNom());
        fonctionUt.setText(utilisateur.getFonction().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        nomUt = new javax.swing.JLabel();
        fonctionUt = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        north = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        center = new javax.swing.JPanel();
        east2 = new javax.swing.JPanel();
        west2 = new javax.swing.JPanel();
        north2 = new javax.swing.JPanel();
        south2 = new javax.swing.JPanel();
        centrer2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nomPH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nomP = new javax.swing.JTextField();
        prenomP = new javax.swing.JTextField();
        jour = new javax.swing.JTextField();
        mois = new javax.swing.JTextField();
        annee = new javax.swing.JTextField();
        speBox = new javax.swing.JComboBox(Service.values());
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        numSejour = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jour1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        mois1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        annee1 = new javax.swing.JTextField();
        south = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/logo.png"))); // NOI18N
        jPanel1.add(jLabel22, java.awt.BorderLayout.WEST);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/hachure.png"))); // NOI18N
        jPanel1.add(jLabel23, java.awt.BorderLayout.EAST);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        nomUt.setText("jLabel5");

        fonctionUt.setText("jLabel5");

        jButton2.setText("Déconnexion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Page d'Accueil");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomUt)
                            .addComponent(fonctionUt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 559, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(nomUt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fonctionUt)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.BorderLayout());

        north.setBackground(new java.awt.Color(204, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ajouter un Séjour");

        javax.swing.GroupLayout northLayout = new javax.swing.GroupLayout(north);
        north.setLayout(northLayout);
        northLayout.setHorizontalGroup(
            northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(northLayout.createSequentialGroup()
                .addContainerGap(354, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(354, Short.MAX_VALUE))
        );
        northLayout.setVerticalGroup(
            northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(northLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(15, 15, 15))
        );

        jPanel2.add(north, java.awt.BorderLayout.NORTH);

        center.setLayout(new java.awt.BorderLayout());

        east2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout east2Layout = new javax.swing.GroupLayout(east2);
        east2.setLayout(east2Layout);
        east2Layout.setHorizontalGroup(
            east2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        east2Layout.setVerticalGroup(
            east2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );

        center.add(east2, java.awt.BorderLayout.EAST);

        west2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout west2Layout = new javax.swing.GroupLayout(west2);
        west2.setLayout(west2Layout);
        west2Layout.setHorizontalGroup(
            west2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        west2Layout.setVerticalGroup(
            west2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );

        center.add(west2, java.awt.BorderLayout.WEST);

        north2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout north2Layout = new javax.swing.GroupLayout(north2);
        north2.setLayout(north2Layout);
        north2Layout.setHorizontalGroup(
            north2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 919, Short.MAX_VALUE)
        );
        north2Layout.setVerticalGroup(
            north2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        center.add(north2, java.awt.BorderLayout.NORTH);

        south2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout south2Layout = new javax.swing.GroupLayout(south2);
        south2.setLayout(south2Layout);
        south2Layout.setHorizontalGroup(
            south2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 919, Short.MAX_VALUE)
        );
        south2Layout.setVerticalGroup(
            south2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        center.add(south2, java.awt.BorderLayout.SOUTH);

        centrer2.setBackground(new java.awt.Color(255, 255, 255));
        centrer2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 2));

        jLabel2.setText("Nom du PH responsable : ");

        jLabel3.setText("Service :");

        jButton1.setText("Valider");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Patient :");

        jLabel6.setText("Nom :");

        jLabel7.setText("Prénom :");

        jLabel8.setText("Date de Naissance :");

        jLabel9.setText("/");

        jLabel10.setText("/");

        nomP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nomPFocusGained(evt);
            }
        });

        jour.setText("JJ");
        jour.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jourFocusGained(evt);
            }
        });
        jour.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jourKeyTyped(evt);
            }
        });

        mois.setText("MM");
        mois.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                moisFocusGained(evt);
            }
        });
        mois.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                moisKeyTyped(evt);
            }
        });

        annee.setText("AAAA");
        annee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                anneeFocusGained(evt);
            }
        });
        annee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anneeKeyTyped(evt);
            }
        });

        jLabel11.setText("Informations du séjour :");

        jLabel12.setText("Numéro de séjour :");

        jLabel13.setText("Date d'Arrivée :");

        jour1.setText("JJ");
        jour1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jour1FocusGained(evt);
            }
        });
        jour1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jour1KeyTyped(evt);
            }
        });

        jLabel14.setText("/");

        mois1.setText("MM");
        mois1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mois1FocusGained(evt);
            }
        });
        mois1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mois1KeyTyped(evt);
            }
        });

        jLabel15.setText("/");

        annee1.setText("AAAA");
        annee1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                annee1FocusGained(evt);
            }
        });
        annee1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                annee1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout centrer2Layout = new javax.swing.GroupLayout(centrer2);
        centrer2.setLayout(centrer2Layout);
        centrer2Layout.setHorizontalGroup(
            centrer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centrer2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(33, 33, 33))
            .addGroup(centrer2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(centrer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(centrer2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(centrer2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(centrer2Layout.createSequentialGroup()
                .addGroup(centrer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(centrer2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(centrer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)))
                    .addGroup(centrer2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(centrer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(centrer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(centrer2Layout.createSequentialGroup()
                        .addComponent(jour, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mois, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(annee, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(centrer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(prenomP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addComponent(nomP, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(numSejour, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(centrer2Layout.createSequentialGroup()
                        .addComponent(jour1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mois1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(annee1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nomPH, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(speBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        centrer2Layout.setVerticalGroup(
            centrer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centrer2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(centrer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nomP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(centrer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(prenomP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(centrer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(annee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(centrer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(numSejour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(centrer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jour1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mois1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(annee1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(centrer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomPH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(centrer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(speBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
        );

        center.add(centrer2, java.awt.BorderLayout.CENTER);

        jPanel2.add(center, java.awt.BorderLayout.CENTER);

        south.setBackground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout southLayout = new javax.swing.GroupLayout(south);
        south.setLayout(southLayout);
        southLayout.setHorizontalGroup(
            southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 919, Short.MAX_VALUE)
        );
        southLayout.setVerticalGroup(
            southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel2.add(south, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PageConnexion connex =new PageConnexion();
        connex.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        PageAccueilSec accueil = new PageAccueilSec(utilisateur);
        accueil.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jourKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jourKeyTyped
        if (jour.getText().length() == 1) {
            mois.requestFocus();
        }
    }//GEN-LAST:event_jourKeyTyped

    private void moisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moisKeyTyped
        if (mois.getText().length() == 1) {
            annee.requestFocus();
        }
    }//GEN-LAST:event_moisKeyTyped

    private void anneeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anneeKeyTyped
        if (annee.getText().length() == 1) {
            nomPH.requestFocus();
        }
    }//GEN-LAST:event_anneeKeyTyped

    private void nomPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomPFocusGained
        nomP.setText("");
    }//GEN-LAST:event_nomPFocusGained

    private void jourFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jourFocusGained
        jour.setText("");
    }//GEN-LAST:event_jourFocusGained

    private void moisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_moisFocusGained
        mois.setText("");
    }//GEN-LAST:event_moisFocusGained

    private void anneeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_anneeFocusGained
        annee.setText("");
    }//GEN-LAST:event_anneeFocusGained

    //ajoute un séjour
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //cherche le patient
        Date dateN= new Date(Integer.parseInt(jour.getText()),Integer.parseInt(mois.getText()),Integer.parseInt(annee.getText()));
        String nomPa=new String(nomP.getText());
        String prenomPa = new String(prenomP.getText());
        int i =0;
        boolean trouve=false;
        while(i<utilisateur.getListePatient().size()&& trouve==false){
            if( ! utilisateur.getListePatient().get(i).getNomUsuel().equals(nomPa) &! utilisateur.getListePatient().get(i).getPrenom().equals(prenomPa)  &! utilisateur.getListePatient().get(i).getDateNaissance().equals(dateN)){
            i++;
            }
            else{
                trouve=true;
            }
            
        }
        if (i>utilisateur.getListePatient().size()){
            javax.swing.JOptionPane.showMessageDialog(null, "Ce patient n'existe pas");
        }
        
        
        // ajoute le séjour à la liste des séjours du patient
        String numSejourP = new String(numSejour.getText());
        Date dateArrivee= new Date(Integer.parseInt(jour1.getText()),Integer.parseInt(mois1.getText()),Integer.parseInt(annee1.getText()));
        String nomPhP = new String(nomPH.getText());
        Sejour sejour= new Sejour(numSejourP, dateArrivee, null, nomPhP, null, null);
        int validation = JOptionPane.showConfirmDialog(null, "Voulez-vous ajouter ce sejour ?", "Enregistrement des donnees", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (validation == JOptionPane.YES_OPTION) {
                    utilisateur.getListePatient().get(i).ajouterSejour(sejour);
                    javax.swing.JOptionPane.showMessageDialog(null, "Observation ajoutée");
                }
                
        // ajouter le patient à la liste des patients du ph 
    
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jour1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jour1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jour1FocusGained

    private void jour1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jour1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jour1KeyTyped

    private void mois1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mois1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_mois1FocusGained

    private void mois1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mois1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_mois1KeyTyped

    private void annee1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_annee1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_annee1FocusGained

    private void annee1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_annee1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_annee1KeyTyped

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AjouterSejour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AjouterSejour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AjouterSejour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AjouterSejour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AjouterSejour().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField annee;
    private javax.swing.JTextField annee1;
    private javax.swing.JPanel center;
    private javax.swing.JPanel centrer2;
    private javax.swing.JPanel east2;
    private javax.swing.JLabel fonctionUt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jour;
    private javax.swing.JTextField jour1;
    private javax.swing.JTextField mois;
    private javax.swing.JTextField mois1;
    private javax.swing.JTextField nomP;
    private javax.swing.JTextField nomPH;
    private javax.swing.JLabel nomUt;
    private javax.swing.JPanel north;
    private javax.swing.JPanel north2;
    private javax.swing.JTextField numSejour;
    private javax.swing.JTextField prenomP;
    private javax.swing.JPanel south;
    private javax.swing.JPanel south2;
    private javax.swing.JComboBox<String> speBox;
    private javax.swing.JPanel west2;
    // End of variables declaration//GEN-END:variables
}
