package DAO;

import Formatos.Mensajes;
import Modelo.Area;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import Vista.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class DAO_MantenimientoAreas extends ConectarDB {

    public DAO_MantenimientoAreas(InterFrameGestionarAreas vista) {
        this.vista = vista;
    }

    InterFrameGestionarAreas vista;

    public void MostrarArea(JTable tabla) {
        String[] titulos = {
            "ID Area", "Nombre", "Responsable", "Ubicacion", "Fecha Registro",
            "Descripcion"
        };
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        Area a = new Area();

        try {
            rs = st.executeQuery("SELECT idArea, nombreArea, responsable, ubicacion, fechaRegistro, "
                    + "descripcion, indicador FROM tb_area WHERE indicador='S';");
            while (rs.next()) {
                a.setIdArea(rs.getInt("idArea"));
                a.setNombreArea(rs.getString("nombreArea"));
                a.setResponsable(rs.getString("responsable"));
                a.setUbicacion(rs.getString("ubicacion"));
                a.setFechaRegistro(rs.getDate("fechaRegistro"));
                a.setDescripcion(rs.getString("descripcion"));
                a.setIndicador(rs.getString("indicador"));
                modelo.addRow(a.RegistroArea());
            }
            conexion.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se pueden mostrar las áreas" + e);
        }
    }

    public void ActualizarArea(Area a) {
        try {
            ps = conexion.prepareStatement("UPDATE tb_area SET nombreArea=?,responsable=?,ubicacion=?,fechaRegistro=?, descripcion=? WHERE idArea=?");
            ps.setString(1, a.getNombreArea());
            ps.setString(2, a.getResponsable());
            ps.setString(3, a.getUbicacion());
            java.sql.Date sqlDate = new java.sql.Date(a.getFechaRegistro().getTime());
            ps.setDate(4, sqlDate);
            ps.setString(5, a.getDescripcion());
            ps.setInt(6, a.getIdArea());
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

    public void EliminarArea(int idCat) {
        try {
            ps = conexion.prepareStatement("UPDATE tb_area SET indicador='N' "
                    + "WHERE idArea=?;");
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

    public void EnviarDatosAreaSeleccionada(int idArea) {
        try {
            ps = conexion.prepareStatement("SELECT * FROM tb_area WHERE idArea = ?");
            ps.setInt(1, idArea);
            rs = ps.executeQuery();
            if (rs.next()) {
                vista.txtIDArea.setText(String.valueOf(rs.getInt("idArea")));
                vista.txtNombreArea.setText(rs.getString("nombreArea"));
                vista.txtResponsableArea.setText(rs.getString("responsable"));
                vista.txtUbicacionArea.setText(rs.getString("ubicacion"));
                vista.txaDescripcionArea.setText(rs.getString("descripcion"));
                vista.datecFechaArea.setDate(rs.getDate("fechaRegistro"));
            }
        } catch (Exception e) {
            Mensajes.M1("ERROR al seleccionar área" + e);
        }
    }

    public void configurarMouseListener() {
        vista.tblAreas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable tabla = (JTable) e.getSource();
                    int row = tabla.getSelectedRow();
                    int idArea = (int) tabla.getValueAt(row, 0);
                    EnviarDatosAreaSeleccionada(idArea);
                }
            }
        });
    }
}
