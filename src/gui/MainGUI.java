package gui;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import model.Jokalaria;
import model.Marrazkia;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author blazquez.asier
 */
public class MainGUI extends javax.swing.JFrame {

      static ArrayList<Marrazkia> marrazkiak;
      
      static ArrayList<Jokalaria> jokalariak= new ArrayList<>();


    public MainGUI() {
        initComponents();
        sortu();
        this.setResizable(false);
        adminButton.setVisible(false);
    }

    
    
    public  void sortu() {
          try {
              int id = 0;
              marrazkiak = new ArrayList<>();
              
              
              marrazkiak= itzuli();
          } catch (IOException ex) {
              Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
          }
       
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        marraztuButton = new javax.swing.JButton();
        asmatuButton = new javax.swing.JButton();
        titulolabel = new javax.swing.JLabel();
        puntuazioaButton = new javax.swing.JButton();
        pintura = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        adminButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        marraztuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/marraztu.png"))); // NOI18N
        marraztuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marraztuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(marraztuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 280, 300));

        asmatuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/asmatu.png"))); // NOI18N
        asmatuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asmatuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(asmatuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, 270, 300));

        titulolabel.setFont(new java.awt.Font("Comic Sans MS", 0, 58)); // NOI18N
        titulolabel.setForeground(new java.awt.Color(0, 51, 255));
        titulolabel.setText("MARRAZKITZ");
        getContentPane().add(titulolabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 440, 90));

        puntuazioaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/puntuazioa.png"))); // NOI18N
        puntuazioaButton.setText("Puntuazioa");
        puntuazioaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puntuazioaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(puntuazioaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, 240, 140));

        pintura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pintura.png"))); // NOI18N
        getContentPane().add(pintura, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 460, 180));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 260, 40, 10));

        adminButton.setText("Administrazioa");
        adminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminButtonActionPerformed(evt);
            }
        });
        getContentPane().add(adminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void marraztuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marraztuButtonActionPerformed
                     
        JFrame entrar = new MarraztuGUI();
        entrar.setVisible(true);
        
    }//GEN-LAST:event_marraztuButtonActionPerformed

    private void asmatuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asmatuButtonActionPerformed
        
             
        JFrame entrar = new AsmatuGUI();
        entrar.setVisible(true);
    }//GEN-LAST:event_asmatuButtonActionPerformed

    private void puntuazioaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puntuazioaButtonActionPerformed
        // TODO add your handling code here:
              JFrame entrar = new PuntuazioaGUI();
        entrar.setVisible(true);
    }//GEN-LAST:event_puntuazioaButtonActionPerformed

    private void adminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminButtonActionPerformed
      
           JFrame entrar = new AdministrazioaGUI();
        entrar.setVisible(true);
    }//GEN-LAST:event_adminButtonActionPerformed

public static void gorde(ArrayList<Marrazkia> marrazkiak) throws FileNotFoundException, IOException {

        FileOutputStream fout = new FileOutputStream("src/resources/marraz.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(marrazkiak);
        out.close();
    }

 public static ArrayList<Marrazkia> itzuli() throws FileNotFoundException, IOException, ClassNotFoundException {

        FileInputStream fin = new FileInputStream("src/resources/marraz.txt");
        ObjectInputStream ois = new ObjectInputStream(fin);
        ArrayList<Marrazkia> marrazkiak2 = (ArrayList<Marrazkia>) ois.readObject();

        return marrazkiak2;

    }
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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminButton;
    private javax.swing.JButton asmatuButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton marraztuButton;
    private javax.swing.JLabel pintura;
    private javax.swing.JButton puntuazioaButton;
    private javax.swing.JLabel titulolabel;
    // End of variables declaration//GEN-END:variables
}
