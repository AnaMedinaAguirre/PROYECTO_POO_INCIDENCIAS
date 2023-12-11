package DAO;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;

public class GenerarPDF extends ConectarDB{
    
    public void GenerarPDFIncidencias() throws FileNotFoundException{
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Incidencias.pdf"));
            
            //formato de texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Incidencias \n\n");
            
            documento.open();
            
            //agregamos los datos
            documento.add(parrafo);
            
            PdfPTable tabla = new PdfPTable(8);
            tabla.addCell("ID Incidencia");
            tabla.addCell("Nombre Incidencia");
            tabla.addCell("Encargado");
            tabla.addCell("Estado");
            tabla.addCell("Prioridad");
            tabla.addCell("Tipo Incidencia");
            tabla.addCell("Área");
            tabla.addCell("Fecha de Modificación");
            
            try {
                ps = conexion.prepareStatement(
                        "SELECT i.idIncidencia, i.nombreIncidencia, e1.nombreEmpleado AS nombreEmpleado1, "
                    + "ds.estado, i.prioridad, ti.nombreTipoInci, a.nombreArea, ds.fechaModificacion "
                    + "FROM tb_incidencia i "
                    + "INNER JOIN tb_area a ON i.idArea = a.idArea "
                    + "INNER JOIN tb_tipoincidencia ti ON i.idTipoInci = ti.idTipoInci "
                    + "INNER JOIN tb_empleado e1 ON i.asignadoa = e1.idEmpleado "
                    + "INNER JOIN tb_detsolucion ds ON i.idIncidencia = ds.idIncidencia "
                    + "WHERE i.indicador = 'S';");
                
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    do {                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                        tabla.addCell(rs.getString(8));
                    } while (rs.next());
                    documento.add(tabla);
                }
                
            } catch (SQLException e) {
                System.out.println("ERROR 4 en: "+e);
            } catch (DocumentException ex) {
                java.util.logging.Logger.getLogger(GenerarPDF.class.getName()).log(Level.SEVERE, null, ex);
            }
            documento.close();
            
            JOptionPane.showMessageDialog(null, "Reporte creado");
        } catch (DocumentException ex) {
            java.util.logging.Logger.getLogger(GenerarPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
