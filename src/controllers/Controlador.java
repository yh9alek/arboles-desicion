package controllers;

import helpers.Excel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import views.JDProyecto;

/**
 *
 * @author yh9pl
 */
public class Controlador implements MouseListener, FocusListener, ActionListener, TableModelListener {
    private JDProyecto formulario;
    public static DefaultListModel<String> listModel;
    
    public Controlador(JDProyecto formulario) {
        this.formulario = formulario;
        Controlador.listModel = new DefaultListModel<>();
        
        // Listeners
        this.formulario.txtAtributos.addFocusListener(this);
        this.formulario.txtInstancias.addFocusListener(this);
        this.formulario.txtAtributo.addFocusListener(this);
        this.formulario.background.addMouseListener(this);
        this.formulario.btnLimpiarItems.addMouseListener(this);
        this.formulario.btnLimpiarItems.addActionListener(this);
        this.formulario.btnAgregar.addMouseListener(this);
        this.formulario.btnAgregar.addActionListener(this);
        this.formulario.btnCrearTabla.addMouseListener(this);
        this.formulario.btnCrearTabla.addActionListener(this);
        this.formulario.btnExcel.addMouseListener(this);
        this.formulario.btnExcel.addActionListener(this);
    }
    
    // Iniciar el formulario
    public void iniciarVista() {
        this.formulario.setTitle("Arboles de desición");
        this.formulario.setSize(1084, 540);
        this.formulario.setIconImage(new ImageIcon(getClass().getResource("/sources/upsin-icon.jpg")).getImage());
        this.formulario.setLocationRelativeTo(null);
        this.formulario.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.formulario.show();
    }
    
    private void limpiar() {
        Controlador.listModel.clear();
        this.formulario.txtAtributo.setForeground(new Color(0x999999));
        this.formulario.txtAtributo.setBackground(new Color(0xFFFFFF));
        this.formulario.txtAtributo.setText("Nombre Item");
        this.formulario.jlItems.setModel(new DefaultListModel<>());
        this.formulario.btnCrearTabla.setEnabled(false);
        this.formulario.jtDatos.setModel(new DefaultTableModel());
        this.formulario.txtAtributo.requestFocus();
    }
    
    // Manejar evento del focus entrante
    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource() == this.formulario.txtAtributos) {
            this.formulario.txtAtributos.setForeground(new Color(0x353535));
            this.formulario.txtAtributos.setBackground(new Color(0xF9F4E0));
            if(this.formulario.txtAtributos.getText().equals("0")) {
                this.formulario.txtAtributos.setText("");
            }
        }
        if(e.getSource() == this.formulario.txtInstancias) {
            this.formulario.txtInstancias.setForeground(new Color(0x353535));
            this.formulario.txtInstancias.setBackground(new Color(0xF9F4E0));
            if(this.formulario.txtInstancias.getText().equals("0")) {
                this.formulario.txtInstancias.setText("");
            }
        }
        if(e.getSource() == this.formulario.txtAtributo) {
            this.formulario.txtAtributo.setForeground(new Color(0x353535));
            this.formulario.txtAtributo.setBackground(new Color(0xF9F4E0));
            if(this.formulario.txtAtributo.getText().equals("Nombre Item")) {
                this.formulario.txtAtributo.setText("");
            }
        }
    }
    
    // Manejar evento cuando salgamos del foco
    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource() == this.formulario.txtAtributos) {
            if(this.formulario.txtAtributos.getText().equals("") ||
               this.formulario.txtAtributos.getText().equals("0")) {
                this.formulario.txtAtributos.setForeground(new Color(0x999999));
                this.formulario.txtAtributos.setBackground(new Color(0xFFFFFF));
                this.formulario.txtAtributos.setText("0");
            } else {
                this.formulario.txtAtributos.setBackground(new Color(0xFBF7E8));
            }
        }
        if(e.getSource() == this.formulario.txtInstancias) {
            if(this.formulario.txtInstancias.getText().equals("") || 
               this.formulario.txtInstancias.getText().equals("0")) {
                this.formulario.txtInstancias.setForeground(new Color(0x999999));
                this.formulario.txtInstancias.setBackground(new Color(0xFFFFFF));
                this.formulario.txtInstancias.setText("0");
            } else {
                this.formulario.txtInstancias.setBackground(new Color(0xFBF7E8));
            }
        }
        if(e.getSource() == this.formulario.txtAtributo) {
            if(this.formulario.txtAtributo.getText().equals("")) {
                this.formulario.txtAtributo.setForeground(new Color(0x999999));
                this.formulario.txtAtributo.setBackground(new Color(0xFFFFFF));
                this.formulario.txtAtributo.setText("Nombre Item");
            } else {
                this.formulario.txtAtributo.setBackground(new Color(0xFBF7E8));
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Restablecer el foco
        if(e.getSource() == this.formulario.background) {
            KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
    // Manejar evento cuando el mouse pasa por encima (lit solo es para ponerle el HAND cursor)
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == this.formulario.btnLimpiarItems) {
            this.formulario.btnLimpiarItems.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        if(e.getSource() == this.formulario.btnAgregar) {
            this.formulario.btnAgregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        if(e.getSource() == this.formulario.btnCrearTabla) {
            this.formulario.btnCrearTabla.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        if(e.getSource() == this.formulario.btnExcel) {
            this.formulario.btnExcel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    // Manejar evento click
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.formulario.btnAgregar) {
            // Validaciones
            if((this.formulario.txtAtributos.getText().equals("0") || this.formulario.txtAtributos.getText().equals("")) ||
               (this.formulario.txtInstancias.getText().equals("0") || this.formulario.txtInstancias.getText().equals(""))) {
                JOptionPane.showMessageDialog(this.formulario, "Debes ingresar valores validos de atributos e instancias.", "Arboles de desición", JOptionPane.INFORMATION_MESSAGE);
                this.formulario.txtAtributos.requestFocus();
                return;
            }
            if(this.formulario.txtAtributo.getText().equals("") || this.formulario.txtAtributo.getText().equals("Nombre Item")) {
                JOptionPane.showMessageDialog(this.formulario, "Debes ingresar un nombre de atributo.", "Arboles de desición", JOptionPane.INFORMATION_MESSAGE);
                this.formulario.txtAtributo.requestFocus();
                return;
            }
            // Lógica
            if(this.formulario.jlItems.getModel().getSize() < Integer.parseInt(this.formulario.txtAtributos.getText())) {
                Controlador.listModel.addElement(this.formulario.txtAtributo.getText());
                this.formulario.jlItems.setModel(Controlador.listModel);
                this.formulario.txtAtributo.setText("");
                this.formulario.txtAtributo.requestFocus();
                if(this.formulario.jlItems.getModel().getSize() == Integer.parseInt(this.formulario.txtAtributos.getText())) {
                    this.formulario.btnCrearTabla.setEnabled(true);
                }
            } else {
                JOptionPane.showMessageDialog(this.formulario, "Aumenta el número de atributos para agregar más.", "Arboles de desición", JOptionPane.INFORMATION_MESSAGE);
                this.formulario.txtAtributos.requestFocus();
                return;
            }
        }
        if(e.getSource() == this.formulario.btnLimpiarItems) {
            this.limpiar();
            this.formulario.txtAtributo.requestFocus();
        }
        if(e.getSource() == this.formulario.btnCrearTabla) {
            int numeroItems = Integer.parseInt(this.formulario.txtAtributos.getText());
            int numeroInstancias = Integer.parseInt(this.formulario.txtInstancias.getText());
            
            // Validaciones
            if(this.formulario.jlItems.getModel().getSize() < numeroItems) {
                JOptionPane.showMessageDialog(this.formulario, "Faltan atributos por ingresar.", "Arboles de desición", JOptionPane.INFORMATION_MESSAGE);
                this.formulario.txtAtributo.setText("");
                this.formulario.txtAtributo.requestFocus();
                return;
            }
            
            this.formulario.revalidate();
            this.formulario.repaint();
        }
        if(e.getSource() == this.formulario.btnExcel) {
            this.limpiar();
            DefaultTableModel modelo = Excel.cargar(this.formulario);
            if(modelo == null) {
                return;
            }
            if(modelo.getColumnCount() > 5) {
                JOptionPane.showMessageDialog(this.formulario, "No se admiten tablas con más de 5 atributos.", "Arboles de desición", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(modelo.getColumnCount() < 3) {
                JOptionPane.showMessageDialog(this.formulario, "Debe haber mínimo 3 atributos en la tabla.", "Arboles de desición", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            this.formulario.jtDatos.setModel(modelo);
            this.formulario.revalidate();
            this.formulario.repaint();
        }
    }
    
    // Evento que sucede al cambiar alguna celda binaria
    @Override
    public void tableChanged(TableModelEvent e) {
        
    }
}
