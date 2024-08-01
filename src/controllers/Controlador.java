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
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import views.JDNominal;
import views.JDNumerico;
import views.JDProyecto;

/**
 *
 * @author yh9pl
 */
public class Controlador implements MouseListener, FocusListener, ActionListener, TableModelListener {
    private JDProyecto formulario;
    public static DefaultListModel<String> listModel;
    public static ArrayList<String> valoresNumericos;
    public static ArrayList<String> valoresNominales;
    private Map<String, String> tipoAtributos; // Mapa para almacenar el tipo de cada atributo (nominal o numerico)

    
    public Controlador(JDProyecto formulario) {
        this.formulario = formulario;
        Controlador.listModel = new DefaultListModel<>();
        this.formulario.lblClase.setVisible(false);
        Controlador.valoresNumericos = new ArrayList<>();
        Controlador.valoresNominales = new ArrayList<>();
        tipoAtributos = new HashMap<>();
        
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
    
    private static boolean isAnyButtonSelected(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return true;
            }
        }
        return false;
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
        this.formulario.txtAtributo.setText("Atributo");
        this.formulario.jlItems.setModel(new DefaultListModel<>());
        this.formulario.btnCrearTabla.setEnabled(false);
        this.formulario.jtDatos.setModel(new DefaultTableModel());
        this.formulario.rdbNominal.setEnabled(true);
        this.formulario.rdbNumerico.setEnabled(true);
        this.formulario.lblClase.setVisible(false);
        this.formulario.rdbNominal.setVisible(true);
        this.formulario.rdbNumerico.setVisible(true);
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
            if(this.formulario.txtAtributo.getText().equals("Atributo")) {
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
                this.formulario.txtAtributo.setText("Atributo");
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
            if(this.formulario.txtAtributo.getText().equals("") || this.formulario.txtAtributo.getText().equals("Atributo")) {
                JOptionPane.showMessageDialog(this.formulario, "Debes ingresar un nombre de atributo.", "Arboles de desición", JOptionPane.INFORMATION_MESSAGE);
                this.formulario.txtAtributo.requestFocus();
                return;
            }
            if(this.formulario.jlItems.getModel().getSize() != (Integer.parseInt(this.formulario.txtAtributos.getText()) - 1)) {
                if(!Controlador.isAnyButtonSelected(this.formulario.rdbs)) {
                    JOptionPane.showMessageDialog(this.formulario, "Debes seleccionar un tipo de atributo.", "Arboles de desición", JOptionPane.INFORMATION_MESSAGE);
                    this.formulario.txtAtributo.requestFocus();
                    return;
                }
            }
            if(this.formulario.rdbNominal.isSelected()) {
                JDNominal nominal = new JDNominal(new JFrame(), true);
                nominal.setTitle("Valores nominales");
                nominal.setSize(340, 100);
                nominal.setIconImage(new ImageIcon(getClass().getResource("/sources/upsin-icon.jpg")).getImage());
                nominal.setLocationRelativeTo(null);
                nominal.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                nominal.setVisible(true);
                
                // Añadir tipo de atributo nominal
                tipoAtributos.put(this.formulario.txtAtributo.getText(), "nominal");
            }
            if(this.formulario.rdbNumerico.isSelected()) {
                JDNumerico numerico = new JDNumerico(new JFrame(), true);
                numerico.setTitle("Valores numéricos");
                numerico.setSize(186, 120);
                numerico.setIconImage(new ImageIcon(getClass().getResource("/sources/upsin-icon.jpg")).getImage());
                numerico.setLocationRelativeTo(null);
                numerico.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                numerico.setVisible(true);
                
                // Añadir tipo de atributo numérico
                tipoAtributos.put(this.formulario.txtAtributo.getText(), "numerico");
            }
            // Lógica
            if(this.formulario.jlItems.getModel().getSize() < Integer.parseInt(this.formulario.txtAtributos.getText())) {
                Controlador.listModel.addElement(this.formulario.txtAtributo.getText());
                this.formulario.jlItems.setModel(Controlador.listModel);
                this.formulario.txtAtributo.setText("");
                this.formulario.txtAtributo.requestFocus();
                if(this.formulario.jlItems.getModel().getSize() == (Integer.parseInt(this.formulario.txtAtributos.getText()) - 1)) {
                    this.formulario.rdbs.clearSelection();
                    this.formulario.rdbNominal.setEnabled(false);
                    this.formulario.rdbNumerico.setEnabled(false);
                    this.formulario.rdbNominal.setVisible(false);
                    this.formulario.rdbNumerico.setVisible(false);
                    this.formulario.lblClase.setVisible(true);
                }
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
            if (this.formulario.jlItems.getModel().getSize() < numeroItems) {
                JOptionPane.showMessageDialog(this.formulario, "Faltan atributos por ingresar.", "Árboles de decisión", JOptionPane.INFORMATION_MESSAGE);
                this.formulario.txtAtributo.setText("");
                this.formulario.txtAtributo.requestFocus();
                return;
            }

            // Crear la tabla con los datos
            crearTabla(numeroItems, numeroInstancias);
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
    
    private void crearTabla(int numeroItems, int numeroInstancias) {
        DefaultTableModel tableModel = new DefaultTableModel();

        // Añadir las columnas al modelo de la tabla
        for (int i = 0; i < numeroItems; i++) {
            tableModel.addColumn(this.formulario.jlItems.getModel().getElementAt(i));
        }

        // Generar las filas de datos
        for (int i = 0; i < numeroInstancias; i++) {
            ArrayList<String> rowData = new ArrayList<>();
            for (int j = 0; j < numeroItems - 1; j++) {
                String atributo = this.formulario.jlItems.getModel().getElementAt(j);
                String valor = "";

                if (tipoAtributos.get(atributo).equals("nominal")) {
                    // Seleccionar un valor nominal al azar
                    valor = Controlador.valoresNominales.get((int)(Math.random() * Controlador.valoresNominales.size()));
                } else if (tipoAtributos.get(atributo).equals("numerico")) {
                    int valor1 = Integer.parseInt(Controlador.valoresNumericos.get(0));
                    int valor2 = Integer.parseInt(Controlador.valoresNumericos.get(1));
                    double randomValue = Math.random();
                    if (randomValue < 0.33) {
                        valor = "< " + valor1;
                    } else if (randomValue < 0.66) {
                        valor = valor1 + " - " + valor2;
                    } else {
                        valor = "> " + valor2;
                    }
                }
                rowData.add(valor);
            }
            // Generar un valor aleatorio de 0 o 1 para la clase
            String clase = Math.random() < 0.5 ? "0" : "1";
            rowData.add(clase);
            tableModel.addRow(rowData.toArray());
        }

        // Asignar el modelo al JTable
        this.formulario.jtDatos.setModel(tableModel);
        this.formulario.revalidate();
        this.formulario.repaint();
    }
    
    // Evento que sucede al cambiar alguna celda binaria
    @Override
    public void tableChanged(TableModelEvent e) {
        
    }
}
