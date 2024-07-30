/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author yh9pl
 * Clase utilizada para aplicar un estilo personalizado a las filas de los JTables
 * (estilo tipo Excel, gris, blanco)
 */
public class EstiloFilas extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if (row % 2 == 0) {
            cell.setBackground(new Color(0xEEEDED));
        } else {
            cell.setBackground(Color.WHITE);
        }
        
        return cell;
    }
}