/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Jokalaria;

/**
 *
 * @author blazquez.asier
 */
public class PuntuazioaGUI extends javax.swing.JFrame {

    ArrayList<Jokalaria> players;

    /**
     * Creates new form PuntuazioaGUI
     */
    public PuntuazioaGUI() {
        initComponents();
        datuakKargatu();

    }

    public static void gorde(ArrayList<Jokalaria> jokalariak) throws FileNotFoundException, IOException {

        FileOutputStream fout = new FileOutputStream("src/resources/puntuazioa.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(jokalariak);
        out.close();
    }

    public static ArrayList<Jokalaria> itzuli() throws FileNotFoundException, IOException, ClassNotFoundException {

        FileInputStream fin = new FileInputStream("src/resources/puntuazioa.txt");
        ObjectInputStream ois = new ObjectInputStream(fin);
        ArrayList<Jokalaria> jokalariak2 = (ArrayList<Jokalaria>) ois.readObject();

        return jokalariak2;

    }

    public void datuakKargatu() {

        try {
            players = itzuli();
           
           Collections.sort(players);
        } catch (Exception e) {
        }
        
        
        for(Jokalaria j: players){
            String s = "\nIZENA: "+ j.getUsername()+ "         PUNTUAZIOA: "+ j.getPuntuazioa()+"        ASMATUTAKOAK:  "+ j.getAsmatutakoak();
        
            System.out.println(s);
        }
        System.out.println(players);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        puntuLabel = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Puntuazioa");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 120, 60));

        puntuLabel.setColumns(20);
        puntuLabel.setRows(5);
        jScrollPane1.setViewportView(puntuLabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 390, 120));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 790, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PuntuazioaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PuntuazioaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PuntuazioaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PuntuazioaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PuntuazioaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea puntuLabel;
    // End of variables declaration//GEN-END:variables
}
