package views;

import controllers.Controlador;
import helpers.EstiloFilas;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author yh9pl
 */
public class JDProyecto extends javax.swing.JDialog {

    /**
     * Creates new form JDProyecto
     */
    public JDProyecto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // Aplicar estilo de filas tipo Excel a la tabla
        this.jtDatos.setDefaultRenderer(Object.class, new EstiloFilas());
        // Personalizar el renderer para centrar las celdas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                setBorder(new EmptyBorder(20, 10, 10, 10)); // Establecer el padding (arriba, izquierda, abajo, derecha)
                return this;
            }
        };
    }
    
    // Clase estática para personalizar el renderer del header
    static class CustomHeaderRenderer implements TableCellRenderer {
        private final TableCellRenderer delegate;

        public CustomHeaderRenderer(TableCellRenderer delegate) {
            this.delegate = delegate;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = delegate.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            c.setBackground(new Color(0xFFFF99)); // Cambia el color de fondo aquí
            c.setForeground(Color.BLACK); // Cambia el color del texto aquí si es necesario
            return c;
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

        rdbs = new javax.swing.ButtonGroup();
        background = new javax.swing.JPanel();
        txtAtributos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtInstancias = new javax.swing.JTextField();
        btnLimpiarItems = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlItems = new javax.swing.JList<>();
        txtAtributo = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnCrearTabla = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        btnExcel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rdbNominal = new javax.swing.JRadioButton();
        rdbNumerico = new javax.swing.JRadioButton();
        lblClase = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setFocusable(false);
        background.setLayout(null);

        txtAtributos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAtributos.setForeground(new java.awt.Color(153, 153, 153));
        txtAtributos.setText("0");
        txtAtributos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAtributosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAtributosKeyTyped(evt);
            }
        });
        background.add(txtAtributos);
        txtAtributos.setBounds(20, 70, 70, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Atributos");
        jLabel1.setFocusable(false);
        background.add(jLabel1);
        jLabel1.setBounds(20, 40, 80, 20);

        txtInstancias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtInstancias.setForeground(new java.awt.Color(153, 153, 153));
        txtInstancias.setText("0");
        txtInstancias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtInstanciasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtInstanciasKeyTyped(evt);
            }
        });
        background.add(txtInstancias);
        txtInstancias.setBounds(100, 70, 70, 30);

        btnLimpiarItems.setText("Limpiar Datos");
        background.add(btnLimpiarItems);
        btnLimpiarItems.setBounds(20, 270, 150, 30);

        jlItems.setFocusable(false);
        jScrollPane1.setViewportView(jlItems);

        background.add(jScrollPane1);
        jScrollPane1.setBounds(20, 190, 150, 70);

        txtAtributo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAtributo.setForeground(new java.awt.Color(153, 153, 153));
        txtAtributo.setText("Atributo");
        txtAtributo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAtributoKeyPressed(evt);
            }
        });
        background.add(txtAtributo);
        txtAtributo.setBounds(20, 120, 110, 30);

        btnAgregar.setText("+");
        background.add(btnAgregar);
        btnAgregar.setBounds(140, 120, 30, 30);

        btnCrearTabla.setBackground(new java.awt.Color(102, 102, 255));
        btnCrearTabla.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCrearTabla.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearTabla.setText("Crear tabla");
        btnCrearTabla.setEnabled(false);
        background.add(btnCrearTabla);
        btnCrearTabla.setBounds(20, 310, 150, 30);

        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtDatos.setFocusable(false);
        jtDatos.setShowVerticalLines(true);
        jtDatos.getTableHeader().setResizingAllowed(false);
        jtDatos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtDatos);

        background.add(jScrollPane2);
        jScrollPane2.setBounds(180, 70, 360, 240);

        btnExcel.setBackground(new java.awt.Color(33, 163, 102));
        btnExcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExcel.setText("Cargar tabla Excel");
        background.add(btnExcel);
        btnExcel.setBounds(20, 350, 150, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Instancias");
        jLabel3.setFocusable(false);
        background.add(jLabel3);
        jLabel3.setBounds(100, 40, 80, 20);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("TABLA");
        jLabel4.setFocusable(false);
        background.add(jLabel4);
        jLabel4.setBounds(180, 40, 110, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("...");
        jLabel7.setFocusable(false);
        background.add(jLabel7);
        jLabel7.setBounds(560, 40, 180, 20);

        rdbs.add(rdbNominal);
        rdbNominal.setText("Nominal");
        background.add(rdbNominal);
        rdbNominal.setBounds(17, 160, 68, 21);

        rdbs.add(rdbNumerico);
        rdbNumerico.setText("Numérico");
        background.add(rdbNumerico);
        rdbNumerico.setBounds(94, 160, 74, 21);

        lblClase.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblClase.setText("Atributo Clase");
        background.add(lblClase);
        lblClase.setBounds(20, 160, 90, 16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void txtAtributoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAtributoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if((this.txtAtributos.getText().equals("0") || this.txtAtributos.getText().equals("")) ||
                (this.txtInstancias.getText().equals("0") || this.txtInstancias.getText().equals(""))) {
                JOptionPane.showMessageDialog(this, "Debes ingresar valores validos de items e instancias.", "Reglas de Asociación", JOptionPane.INFORMATION_MESSAGE);
                this.txtAtributos.requestFocus();
                return;
            }
            if(this.txtAtributo.getText().equals("") || this.txtAtributo.getText().equals("Atributo")) {
                JOptionPane.showMessageDialog(this, "Debes ingresar un nombre de item.", "Reglas de Asociación", JOptionPane.INFORMATION_MESSAGE);
                this.txtAtributo.requestFocus();
                return;
            }
            if(this.jlItems.getModel().getSize() < Integer.parseInt(this.txtAtributos.getText())) {
                Controlador.listModel.addElement(this.txtAtributo.getText());
                this.jlItems.setModel(Controlador.listModel);
                this.txtAtributo.setText("");
                this.txtAtributo.requestFocus();
                if(this.jlItems.getModel().getSize() == Integer.parseInt(this.txtAtributos.getText())) {
                    this.btnCrearTabla.setEnabled(true);
                    this.btnCrearTabla.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Aumenta el número de items para agregar más.", "Reglas de Asociación", JOptionPane.INFORMATION_MESSAGE);
                this.txtAtributos.requestFocus();
            }
        }
    }//GEN-LAST:event_txtAtributoKeyPressed

    private void txtInstanciasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInstanciasKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)) {
            evt.consume();
        }
        if(this.txtInstancias.getText().indexOf('0') == 0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtInstanciasKeyTyped

    private void txtInstanciasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInstanciasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(this.txtInstancias.getText().equals("") ||
                this.txtInstancias.getText().equals("0")) {
                this.txtInstancias.setForeground(new Color(0x999999));
                this.txtInstancias.setBackground(new Color(0xFFFFFF));
                this.txtInstancias.setText("0");
            } else {
                this.txtInstancias.setBackground(new Color(0xFBF7E8));
            }
            this.txtAtributo.requestFocus();
        }
    }//GEN-LAST:event_txtInstanciasKeyPressed

    private void txtAtributosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAtributosKeyTyped
        char c = evt.getKeyChar();
        if (!(c >= '3' && c <= '5')) {
            evt.consume(); // Consume el evento para evitar que se procese
        }
        // Verifica que el campo tenga solo un carácter
        if (this.txtAtributos.getText().length() >= 1) {
            evt.consume(); // Consume el evento si ya hay un carácter
        }
    }//GEN-LAST:event_txtAtributosKeyTyped

    private void txtAtributosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAtributosKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(this.txtAtributos.getText().equals("") ||
                this.txtAtributos.getText().equals("0")) {
                this.txtAtributos.setForeground(new Color(0x999999));
                this.txtAtributos.setBackground(new Color(0xFFFFFF));
                this.txtAtributos.setText("0");
            } else {
                this.txtAtributos.setBackground(new Color(0xFBF7E8));
            }
            this.txtInstancias.requestFocus();
            return;
        }
        if (evt.getKeyCode() == KeyEvent.VK_3) {
            if(this.jlItems.getModel().getSize() != 3) {
                this.jlItems.setModel(new DefaultListModel());
                this.rdbNominal.setEnabled(true);
                this.rdbNumerico.setEnabled(true);
                this.lblClase.setVisible(false);
                this.rdbNominal.setVisible(true);
                this.rdbNumerico.setVisible(true);
                Controlador.listModel = new DefaultListModel();
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_4) {
            if(this.jlItems.getModel().getSize() != 4) {
                this.jlItems.setModel(new DefaultListModel());
                this.rdbNominal.setEnabled(true);
                this.rdbNumerico.setEnabled(true);
                this.lblClase.setVisible(false);
                this.rdbNominal.setVisible(true);
                this.rdbNumerico.setVisible(true);
                Controlador.listModel = new DefaultListModel();
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_5) {
            if(this.jlItems.getModel().getSize() != 5) {
                this.jlItems.setModel(new DefaultListModel());
                this.rdbNominal.setEnabled(true);
                this.rdbNumerico.setEnabled(true);
                this.lblClase.setVisible(false);
                this.rdbNominal.setVisible(true);
                this.rdbNumerico.setVisible(true);
                Controlador.listModel = new DefaultListModel();
            }
        }
    }//GEN-LAST:event_txtAtributosKeyPressed

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
            java.util.logging.Logger.getLogger(JDProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDProyecto dialog = new JDProyecto(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnCrearTabla;
    public javax.swing.JButton btnExcel;
    public javax.swing.JButton btnLimpiarItems;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JList<String> jlItems;
    public javax.swing.JTable jtDatos;
    public javax.swing.JLabel lblClase;
    public javax.swing.JRadioButton rdbNominal;
    public javax.swing.JRadioButton rdbNumerico;
    public javax.swing.ButtonGroup rdbs;
    public javax.swing.JTextField txtAtributo;
    public javax.swing.JTextField txtAtributos;
    public javax.swing.JTextField txtInstancias;
    // End of variables declaration//GEN-END:variables
}
