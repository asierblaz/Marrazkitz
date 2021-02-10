package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.Timer;
import model.Jokalaria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author blazquez.asier
 */
public class AsmatuGUI extends javax.swing.JFrame {

    private int puntuazioa = 0;
    private int aleatorio = -1;
    int tiempo = 25; //tiempo
    private int zenbat;

    /**
     * Creates new form Asmatu
     */
    // private ImageIcon icon;
    public AsmatuGUI() {
        initComponents();
        Collections.shuffle(MainGUI.marrazkiak);

        aldatuArgazkia();

    }

    public void aldatuArgazkia() {
        aleatorio++;
        // aleatorio = (int) (Math.random() * MainGUI.marrazkiak.size());           
        if (aleatorio == MainGUI.marrazkiak.size() - 1) {
            try {
                partidaAmaituta();
            } catch (IOException ex) {
                Logger.getLogger(AsmatuGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            argazkia.setIcon(new javax.swing.ImageIcon(getClass().getResource(MainGUI.marrazkiak.get(aleatorio).getImagen())));
            labelzuzena.setVisible(false);
            labelOkerra.setVisible(false);
            palabraIntro.setText("");
            pistaLabel.setVisible(false);
            pistaButton.setVisible(true);
            timer.start();
            tiempo = 25;   //cambiar este valor para cambiar el tiempo
            timeLabel.setText(tiempo + "");
            frogatu.setEnabled(true);
            puntuazioLabel.setText("Puntuazioa: " + puntuazioa);

        }

    }

    public void frogratuHitza() {
        if (palabraIntro.getText().toLowerCase().equals(MainGUI.marrazkiak.get(aleatorio).getIzena())) {
            labelzuzena.setVisible(true);
            frogatu.setEnabled(false);
            pistaButton.setVisible(false);
            labelOkerra.setVisible(false);
            puntuazioa = puntuazioa + 150;
            zenbat = zenbat + 1;
            if (tiempo < 10) {
                puntuazioa = puntuazioa - 20;

            }

            timer.stop();

        } else {
            palabraIntro.setText("");
            labelzuzena.setVisible(false);
            labelOkerra.setVisible(true);
            if (tiempo <= 0) {
                pistaButton.setVisible(false);
                frogatu.setEnabled(false);

            }

        }
        if (tiempo <= 0) {
            pistaLabel.setText(MainGUI.marrazkiak.get(aleatorio).getIzena());
        }

    }

    //..... TEMPORIZADOR....
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            tiempo--;
            timeLabel.setText(tiempo + "");
            if (tiempo == 10) {
                pistaLetra();
            }
            if (tiempo == 0) {
                timer.stop();
                frogratuHitza();
            }

        }
    });

    public void pistaBatEman() {

        puntuazioa = puntuazioa - 30;
        pistaButton.setVisible(false);
        pistaLabel.setVisible(true);
        String guion = "";

        for (int i = 1; i <= MainGUI.marrazkiak.get(aleatorio).getLetraZenbakia(); i++) {

            guion = guion + " _";

        }
        pistaLabel.setText(guion);

    }

    public void pistaLetra() {
        pistaButton.setVisible(false);
        pistaLabel.setVisible(true);

        String izena = MainGUI.marrazkiak.get(aleatorio).getIzena();
        int al = (int) (Math.random() * izena.length());
        String guion = "";

        for (int i = 1; i <= MainGUI.marrazkiak.get(aleatorio).getLetraZenbakia(); i++) {
            if (i == al + 1) {
                guion = guion + " " + izena.charAt(al);
            } else {
                guion = guion + " _";

            }

        }
        pistaLabel.setText(guion);

    }

    public void partidaAmaituta() throws FileNotFoundException, IOException {
        JOptionPane.showMessageDialog(null, "Partida amaituta", "Informazioa", JOptionPane.INFORMATION_MESSAGE);
        timeLabel.setVisible(false);
        cambiar.setVisible(false);

        int input = showConfirmDialog(null, "Zure Puntuazioa Gorde nahi duzu?");
        if (input == 0) {
            String username = JOptionPane.showInputDialog("Sartu zure erabiltzaile izena:");

            try {
                MainGUI.jokalariak = PuntuazioaGUI.itzuli();
                MainGUI.jokalariak.add(new Jokalaria(username, puntuazioa, MainGUI.marrazkiak.size() + ""));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AsmatuGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            PuntuazioaGUI.gorde(MainGUI.jokalariak);

        }

        JOptionPane.showMessageDialog(null, "Eskerrikasko Jolasteagaitik", "Informazioa", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new java.awt.Label();
        palabraIntro = new javax.swing.JTextField();
        frogatu = new javax.swing.JButton();
        argazkia = new javax.swing.JLabel();
        cambiar = new javax.swing.JButton();
        labelOkerra = new javax.swing.JLabel();
        labelzuzena = new javax.swing.JLabel();
        pistaButton = new javax.swing.JButton();
        timeLabel = new java.awt.Label();
        pistaLabel = new javax.swing.JLabel();
        puntuazioLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 153));
        setMinimumSize(new java.awt.Dimension(1400, 1100));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setAlignment(java.awt.Label.CENTER);
        titulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titulo.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        titulo.setForeground(new java.awt.Color(102, 102, 255));
        titulo.setText("ASMATU ");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 420, 80));
        titulo.getAccessibleContext().setAccessibleName("");

        palabraIntro.setBackground(new java.awt.Color(240, 240, 240));
        palabraIntro.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        palabraIntro.setToolTipText("");
        palabraIntro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palabraIntroActionPerformed(evt);
            }
        });
        getContentPane().add(palabraIntro, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 380, 340, 60));

        frogatu.setText("Frogatu");
        frogatu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frogatuActionPerformed(evt);
            }
        });
        getContentPane().add(frogatu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 390, 110, 40));

        argazkia.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(argazkia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 700, 700));

        cambiar.setText("Beste Bat");
        cambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarActionPerformed(evt);
            }
        });
        getContentPane().add(cambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 720, 150, 40));

        labelOkerra.setVisible(false);
        labelOkerra.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        labelOkerra.setForeground(new java.awt.Color(255, 51, 51));
        labelOkerra.setText("OKERRA!!");
        getContentPane().add(labelOkerra, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 620, 250, 70));

        labelzuzena.setVisible(false);
        labelzuzena.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        labelzuzena.setForeground(new java.awt.Color(51, 204, 0));
        labelzuzena.setText("ZUZENA!!!!!");
        getContentPane().add(labelzuzena, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 620, 310, 70));

        pistaButton.setText("Pista bat eman");
        pistaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pistaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pistaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 200, 170, 40));

        timeLabel.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        getContentPane().add(timeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 70, 180, 120));

        pistaLabel.setVisible(false);
        pistaLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        pistaLabel.setText("_ _ _ _ _ _ _ _ _ _ _");
        getContentPane().add(pistaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 350, 60));

        puntuazioLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        puntuazioLabel.setText("Puntuazioa: 0");
        getContentPane().add(puntuazioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 830, 280, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1430, 920));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void palabraIntroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palabraIntroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_palabraIntroActionPerformed

    private void frogatuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frogatuActionPerformed
        // TODO add your handling code here:
        System.out.println(MainGUI.marrazkiak.get(aleatorio).getIzena());
        frogratuHitza();

    }//GEN-LAST:event_frogatuActionPerformed

    private void cambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarActionPerformed
        // TODO add your handling code here:
        aldatuArgazkia();

        System.out.println(MainGUI.marrazkiak);

    }//GEN-LAST:event_cambiarActionPerformed

    private void pistaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pistaButtonActionPerformed
        // TODO add your handling code here:

        pistaBatEman();
    }//GEN-LAST:event_pistaButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AsmatuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsmatuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsmatuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsmatuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsmatuGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel argazkia;
    private javax.swing.JButton cambiar;
    private javax.swing.JButton frogatu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelOkerra;
    private javax.swing.JLabel labelzuzena;
    private javax.swing.JTextField palabraIntro;
    private javax.swing.JButton pistaButton;
    private javax.swing.JLabel pistaLabel;
    private javax.swing.JLabel puntuazioLabel;
    private java.awt.Label timeLabel;
    private java.awt.Label titulo;
    // End of variables declaration//GEN-END:variables
}
