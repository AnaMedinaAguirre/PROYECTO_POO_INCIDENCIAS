package DAO;

import Formatos.Mensajes;
import Modelo.TipoIncidencia;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import Vista.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;

public class DAO_MantenimientoTipoIncidencia extends ConectarDB{
    
    public DAO_MantenimientoTipoIncidencia(InterFrameGestionarTipoIncidencia vista){
        this.vista = vista;
    }
    
    InterFrameGestionarTipoIncidencia vista;
    
    public void MostrarTipoIncidencia(JTable tabla){
        String[] titulos = {
            "ID Tipo Inci.", "Nombre", "Categoría", "Fecha Registro",
            "Descripcion"
        };
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        TipoIncidencia ti= new TipoIncidencia();
        
        try {
            rs = st.executeQuery("SELECT idTipoInci,nombreTipoInci,categoria,fechaRegistro,"
                    + "descripcion,indicador FROM tb_tipoincidencia WHERE indicador='S';");
            
            while (rs.next()) {
                ti.setIdTipoInci(rs.getInt("idTipoInci"));
                ti.setNombreTipoInci(rs.getString("nombreTipoInci"));
                ti.setCategoria(rs.getString("categoria"));
                ti.setFechaRegistro(rs.getDate("fechaRegistro"));
                ti.setDescripcion(rs.getString("descripcion"));
                ti.setIndicador(rs.getString("indicador"));
                modelo.addRow(ti.RegistrarTipoIncidencia());
            }
            
            conexion.close();
            
        } catch (Exception e) {
            Mensajes.M1("ERROR no se pueden mostrar los Tipos de Incidencia" + e);
        }
    }
    
    public void ActualizarTipoIncidencia(TipoIncidencia ti) {
        try {
            ps = conexion.prepareStatement("UPDATE tb_tipoincidencia SET nombreTipoInci=?,categoria=?,fechaRegistro=?, "
                                           + "descripcion=? WHERE idTipoInci=?");
            ps.setString(1, ti.getNombreTipoInci());
            ps.setString(2, ti.getCategoria());
            java.sql.Date sqlDate = new java.sql.Date(ti.getFechaRegistro().getTime());
            ps.setDate(3, sqlDate);
            ps.setString(4, ti.getDescripcion());
            ps.setInt(5, ti.getIdTipoInci());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente.");
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede actualizar el registro." + e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                Mensajes.M1("Error al cerrar la conexión" + ex);
            }
        }
    }
    
    public void EliminarTipoIncidencia(int idCat) {
        try {
            ps = conexion.prepareStatement("UPDATE tb_tipoincidencia SET indicador='N' "
                    + "WHERE idTipoInci=?;");
            ps.setInt(1, idCat);
            ps.executeUpdate();
            Mensajes.M1("Registro eliminado correctamente.");
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede eliminar el registro" + e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                Mensajes.M1("Error al cerrar la conexión" + ex);
            }
        }
    }
    
    public void EnviarDatosTipoInciSeleccionada(int idTipoInci) {
        try {
            ps = conexion.prepareStatement("SELECT * FROM tb_tipoincidencia WHERE idTipoInci = ?");
            ps.setInt(1, idTipoInci);
            rs = ps.executeQuery();
            if (rs.next()) {
                vista.txtIDTipoInci.setText(String.valueOf(rs.getInt("idTipoInci")));
                vista.txtNombre.setText(rs.getString("nombreTipoInci"));
                vista.cbxCategoria.setSelectedItem(rs.getString("categoria"));
                vista.datecFecha.setDate(rs.getDate("fechaRegistro"));
                vista.txaDescripcion.setText(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            Mensajes.M1("ERROR al seleccionar tipo de incidencia" + e);
        }
    }
    
    public void configurarMouseListener() {
        vista.tblTipoIncidencias.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable tabla = (JTable) e.getSource();
                    int row = tabla.getSelectedRow();
                    int idTipoInci = (int) tabla.getValueAt(row, 0); 
                    EnviarDatosTipoInciSeleccionada(idTipoInci);
                }
            }
        });
    }
    
    public void cargarCategorias() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        modelo.addElement("Software");
        modelo.addElement("Redes");
        modelo.addElement("Hardware");
        modelo.addElement("Seguridad");
        vista.cbxCategoria.setModel(modelo);
    }
}
