package Formatos;

//librerias
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class ManejadorTablas {
    
    public void centrarYAjustarColumnas(String[][] tabla) {
        // Calculate the maximum width for each column
        int[] columnWidths = new int[tabla[0].length];
        for (String[] row : tabla) {
            for (int i = 0; i < row.length; i++) {
                if (row[i].length() > columnWidths[i]) {
                    columnWidths[i] = row[i].length();
                }
            }
        }
        // Center-align and adjust each column
        for (String[] row : tabla) {
            for (int i = 0; i < row.length; i++) {
                int spacesToAdd = columnWidths[i] - row[i].length();
                int leftPadding = spacesToAdd / 2;
                int rightPadding = spacesToAdd - leftPadding;
                row[i] = " ".repeat(leftPadding) + row[i] + " ".repeat(rightPadding);
            }
        }
    }
}