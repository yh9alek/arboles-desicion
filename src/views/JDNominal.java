/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views;

import controllers.Controlador;
import static controllers.Controlador.listModel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;

/**
 *
 * @author yh9pl
 */
public class JDNominal extends javax.swing.JDialog implements FocusListener {

    /**
     * Creates new form JDNominal
     */
    public JDNominal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.txt1.addFocusListener(this);
        this.txt2.addFocusListener(this);
        this.txt3.addFocusListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdb1 = new javax.swing.JRadioButton();
        rdb2 = new javax.swing.JRadioButton();
        rdb3 = new javax.swing.JRadioButton();
        btnOk = new javax.swing.JButton();
        txt1 = new javax.swing.JTextField();
        txt2 = new javax.swing.JTextField();
        txt3 = new javax.swing.JTextField();
        background = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        setUndecorated(true);
        getContentPane().setLayout(null);

        rdb1.setSelected(true);
        rdb1.setFocusable(false);
        getContentPane().add(rdb1);
        rdb1.setBounds(15, 18, 19, 20);

        rdb2.setSelected(true);
        rdb2.setEnabled(false);
        rdb2.setFocusable(false);
        getContentPane().add(rdb2);
        rdb2.setBounds(120, 18, 19, 20);

        rdb3.setFocusable(false);
        getContentPane().add(rdb3);
        rdb3.setBounds(227, 18, 19, 20);

        btnOk.setText("Ok");
        btnOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOkMouseEntered(evt);
            }
        });
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        getContentPane().add(btnOk);
        btnOk.setBounds(80, 55, 178, 30);

        txt1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt1.setForeground(new java.awt.Color(153, 153, 153));
        txt1.setText("Desc.");
        getContentPane().add(txt1);
        txt1.setBounds(40, 13, 64, 30);

        txt2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt2.setForeground(new java.awt.Color(153, 153, 153));
        txt2.setText("Desc.");
        getContentPane().add(txt2);
        txt2.setBounds(147, 13, 64, 30);

        txt3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt3.setForeground(new java.awt.Color(153, 153, 153));
        txt3.setText("Desc.");
        getContentPane().add(txt3);
        txt3.setBounds(256, 13, 64, 30);

        background.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(background);
        background.setBounds(0, 0, 340, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseEntered
        // TODO add your handling code here:
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnOkMouseEntered

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        if(!this.rdb1.isSelected() && this.rdb2.isSelected() && !this.rdb3.isSelected()) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar almenos 2 valores nominales", "Arboles de desición", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if((this.txt1.getText().equals("Desc.") || this.txt1.getText().equals("")) ||
          (this.txt2.getText().equals("Desc.") || this.txt2.getText().equals("")) ||
          (this.txt3.getText().equals("Desc.") || this.txt3.getText().equals(""))) {
            JOptionPane.showMessageDialog(this, "Primero asigna todos los valores nominales a considerar", "Arboles de desición", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(!Controlador.valoresNominales.isEmpty())
            Controlador.valoresNominales.clear();
        if(this.rdb1.isSelected() && this.rdb2.isSelected() && this.rdb3.isSelected()) {
            Controlador.valoresNominales.add(this.txt1.getText());
            Controlador.valoresNominales.add(this.txt2.getText());
            Controlador.valoresNominales.add(this.txt3.getText());
        } else if(this.rdb2.isSelected() && this.rdb3.isSelected()) {
            Controlador.valoresNominales.add(this.txt2.getText());
            Controlador.valoresNominales.add(this.txt3.getText());
        } else if(this.rdb1.isSelected() && this.rdb2.isSelected()) {
            Controlador.valoresNominales.add(this.txt1.getText());
            Controlador.valoresNominales.add(this.txt2.getText());
        }
        System.out.println(Controlador.valoresNominales);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnOkActionPerformed

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
            java.util.logging.Logger.getLogger(JDNominal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDNominal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDNominal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDNominal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDNominal dialog = new JDNominal(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel background;
    public javax.swing.JButton btnOk;
    public javax.swing.JRadioButton rdb1;
    public javax.swing.JRadioButton rdb2;
    public javax.swing.JRadioButton rdb3;
    public javax.swing.JTextField txt1;
    public javax.swing.JTextField txt2;
    public javax.swing.JTextField txt3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource() == this.txt1) {
            this.txt1.setForeground(new Color(0x353535));
            this.txt1.setBackground(new Color(0xF9F4E0));
            if(this.txt1.getText().equals("Desc.")) {
                this.txt1.setText("");
            }
        }
        if(e.getSource() == this.txt2) {
            this.txt2.setForeground(new Color(0x353535));
            this.txt2.setBackground(new Color(0xF9F4E0));
            if(this.txt2.getText().equals("Desc.")) {
                this.txt2.setText("");
            }
        }
        if(e.getSource() == this.txt3) {
            this.txt3.setForeground(new Color(0x353535));
            this.txt3.setBackground(new Color(0xF9F4E0));
            if(this.txt3.getText().equals("Desc.")) {
                this.txt3.setText("");
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource() == this.txt1) {
            if(this.txt1.getText().equals("")) {
                this.txt1.setForeground(new Color(0x999999));
                this.txt1.setBackground(new Color(0xFFFFFF));
                this.txt1.setText("Desc.");
            } else {
                this.txt1.setBackground(new Color(0xFBF7E8));
            }
        }
        if(e.getSource() == this.txt2) {
            if(this.txt2.getText().equals("")) {
                this.txt2.setForeground(new Color(0x999999));
                this.txt2.setBackground(new Color(0xFFFFFF));
                this.txt2.setText("Desc.");
            } else {
                this.txt2.setBackground(new Color(0xFBF7E8));
            }
        }
        if(e.getSource() == this.txt3) {
            if(this.txt3.getText().equals("")) {
                this.txt3.setForeground(new Color(0x999999));
                this.txt3.setBackground(new Color(0xFFFFFF));
                this.txt3.setText("Desc.");
            } else {
                this.txt3.setBackground(new Color(0xFBF7E8));
            }
        }
    }
}
