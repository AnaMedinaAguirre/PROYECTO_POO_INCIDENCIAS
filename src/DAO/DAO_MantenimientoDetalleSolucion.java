package DAO;

import Modelo.*;
import Formatos.*;
import java.sql.Date;
import Vista.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAO_MantenimientoDetalleSolucion extends ConectarDB {

    public DAO_MantenimientoDetalleSolucion(InterFrameGestionarDetalleSolucion vista) {
        this.vista = vista;
    }

    InterFrameGestionarDetalleSolucion vista;

    public void MostrarDetalleSolucion(JTable tabla) {
        String[] titulos = {
            "ID Detalle Solucion", "Incidencia", "Observación", "Estado", "Fecha de Modificación"
        };

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        DetalleSolucion ds = new DetalleSolucion();

        try {

            String query = "SELECT ds.idDetSolucion, i.nombreIncidencia, ds.observacion, "
                    + "ds.estado, ds.fechaModificacion "
                    + "FROM tb_detsolucion ds "
                    + "INNER JOIN tb_incidencia i ON ds.idIncidencia = i.idIncidencia "
                    + "WHERE ds.indicador = 'S';";

            rs = st.executeQuery(query);

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("idDetSolucion"),
                    rs.getString("nombreIncidencia"), //Nombre de la incidencia en vez del ID
                    rs.getString("observacion"),
                    rs.getString("estado"),
                    rs.getDate("fechaModificacion"),};
                modelo.addRow(fila);
            }

        } catch (Exception e) {
            Mensajes.M1("ERROR al mostrar los detalles de solución" + e);
        } finally {
            // Cerrar el Statement y el ResultSet
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Mensajes.M1("Error al cerrar el ResultSet o Statement" + ex);
            }
        }
    }

    public void ActualizarDetalleSolucion(DetalleSolucion ds) {
        try {
            ps = conexion.prepareStatement("UPDATE tb_detsolucion SET idIncidencia=?,observacion=?,estado=?,"
                    + "fechaModificacion=? WHERE idDetSolucion=?");
            ps.setInt(1, ds.getIdIncidencia());
            ps.setString(2, ds.getObservacion());
            ps.setString(3, ds.getEstado());
            java.sql.Date sqlDate = new java.sql.Date(ds.getFechaModificacion().getTime());
            ps.setDate(4, sqlDate);
            ps.setInt(5, ds.getIdDetSolucion());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente.");
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede actualizar el registro." + e);
        } finally {
            // Cerrar el PreparedStatement
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    public void EliminarDetalleSolucion(int idCat) {
        try {
            ps = conexion.prepareStatement("UPDATE tb_detsolucion SET indicador='N' "
                    + "WHERE idDetSolucion=?;");
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
            } catch (SQLException e) {
                // Manejo de excepciones para cerrar el PreparedStatement
            }
        }
    }

    public void EnviarDatosDetalleSolucionSeleccionado(int idDetSolucion) {
        try {

            ps = conexion.prepareStatement("SELECT ds.idDetSolucion, i.nombreIncidencia, "
                    + "ds.observacion, ds.estado, ds.fechaModificacion "
                    + "FROM tb_detsolucion ds "
                    + "INNER JOIN tb_incidencia i ON ds.idIncidencia = i.idIncidencia "
                    + "WHERE ds.idDetSolucion = ?");
            ps.setInt(1, idDetSolucion);
            rs = ps.executeQuery();
            if (rs.next()) {
                vista.txtID.setText(String.valueOf(rs.getInt("idDetSolucion")));
                String nombreIncidencia = rs.getString("nombreIncidencia");
                vista.cbxIncidencia.setSelectedItem(nombreIncidencia);
                vista.txaObservacion.setText(rs.getString("observacion"));
                vista.cbxEstado.setSelectedItem(rs.getString("estado"));
                vista.datecFecha.setDate(rs.getDate("fechaModificacion"));
            }
        } catch (SQLException e) {
            Mensajes.M1("ERROR al seleccionar el Detalle de Solución" + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Mensajes.M1("Error al cerrar el ResultSet o PreparedStatement" + ex);
            }
        }
    }

    public void configurarMouseListener() {
        vista.tblDetalleSolucion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable tabla = (JTable) e.getSource();
                    int row = tabla.getSelectedRow();
                    int idDetSolucion = (int) tabla.getValueAt(row, 0);
                    EnviarDatosDetalleSolucionSeleccionado(idDetSolucion);
                }
            }
        });
    }

    public void cargarComboEstado() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        modelo.addElement("En proceso");
        modelo.addElement("Atendido");
        modelo.addElement("Derivado");
        vista.cbxEstado.setModel(modelo);
    }

    //Método para cargar las incidencias en el combobox
    public void CargarComboIncidencia() {
        String query = "SELECT * FROM tb_incidencia;";
        try {

            st = conexion.createStatement();
            rs = st.executeQuery(query);
            vista.cbxIncidencia.removeAllItems();

            while (rs.next()) {
                vista.cbxIncidencia.addItem(rs.getString("nombreIncidencia"));
            }

        } catch (Exception e) {
            Mensajes.M1("ERROR al cargar Tipo Incidencia" + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Mensajes.M1("Error al cerrar el ResultSet o Statement" + ex);
            }
        }
    }

    public ArrayList<String> obtenerIncidencias() {
        DAO_Incidencia daoIncidencia = new DAO_Incidencia();
        return daoIncidencia.obtenerNombresIncidencia();
    }
}
