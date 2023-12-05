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

public class DAO_MantenimientoIncidencia extends ConectarDB {

    public DAO_MantenimientoIncidencia(InterFrameGestionarIncidencias vista) {
        this.vista = vista;
    }

    InterFrameGestionarIncidencias vista;

    public void MostrarIncidencia(JTable tabla) {
        String[] titulos = {
            "ID Incidencia", "Nombre", "Asigando por", "Asigando a", "Prioridad", "Tipo Incidencia",
            "Área", "Fecha Registro", "Descripción"
        };

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        Incidencia i = new Incidencia();

        try {

            String query = "SELECT i.idIncidencia, i.nombreIncidencia, e1.nombreEmpleado AS nombreEmpleado1, e2.nombreEmpleado AS nombreEmpleado2, "
                    + "i.prioridad, ti.nombreTipoInci, a.nombreArea, i.fechaRegistro, i.descripcion "
                    + "FROM tb_incidencia i "
                    + "INNER JOIN tb_area a ON i.idArea = a.idArea "
                    + "INNER JOIN tb_tipoincidencia ti ON i.idTipoInci = ti.idTipoInci "
                    + "INNER JOIN tb_empleado e1 ON i.asignadox = e1.idEmpleado "
                    + "INNER JOIN tb_empleado e2 ON i.asignadoa = e2.idEmpleado "
                    + "WHERE i.indicador = 'S';";

            rs = st.executeQuery(query);

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("idIncidencia"),
                    rs.getString("nombreIncidencia"),
                    rs.getString("nombreEmpleado1"), // Nombre del empleado en vez de la ID
                    rs.getString("nombreEmpleado2"), // Nombre del empleado en vez de la ID
                    rs.getString("prioridad"),
                    rs.getString("nombreTipoInci"), //Nombre del tipo de incidencia en vez del ID
                    rs.getString("nombreArea"), // Nombre del área en vez de ID
                    rs.getDate("fechaRegistro"),
                    rs.getString("descripcion")

                };
                modelo.addRow(fila);
            }

        } catch (Exception e) {
            Mensajes.M1("ERROR al mostrar las Incidencias" + e);
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

    public void ActualizarIncidencia(Incidencia i) {
        try {
            ps = conexion.prepareStatement("UPDATE tb_incidencia SET nombreIncidencia=?,asignadox=?,asignadoa=?,"
                    + "prioridad=?,idTipoInci=?,idArea=?,fechaRegistro=?,descripcion=? WHERE idIncidencia=?");
            ps.setString(1, i.getNombreIncidencia());
            ps.setInt(2, i.getAsignadox());
            ps.setInt(3, i.getAsignadoa());
            ps.setString(4, i.getPrioridad());
            ps.setInt(5, i.getIdTipoInci());
            ps.setInt(6, i.getIdArea());
            java.sql.Date sqlDate = new java.sql.Date(i.getFechaRegistro().getTime());
            ps.setDate(7, sqlDate);
            ps.setString(8, i.getDescripcion());
            ps.setInt(9, i.getIdIncidencia());
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

    public void EliminarIncidencia(int idCat) {
        try {
            ps = conexion.prepareStatement("UPDATE tb_incidencia SET indicador='N' "
                    + "WHERE idIncidencia=?;");
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

    public void EnviarDatosIncidenciaSeleccionada(int idIncidencia) {
        try {

            ps = conexion.prepareStatement("SELECT i.idIncidencia, i.nombreIncidencia, "
                    + "e1.nombreEmpleado AS nombreEmpleado1, e2.nombreEmpleado AS nombreEmpleado2, "
                    + "i.prioridad, ti.nombreTipoInci, a.nombreArea, i.fechaRegistro, i.descripcion "
                    + "FROM tb_incidencia i "
                    + "INNER JOIN tb_area a ON i.idArea = a.idArea "
                    + "INNER JOIN tb_tipoincidencia ti ON i.idTipoInci = ti.idTipoInci "
                    + "INNER JOIN tb_empleado e1 ON i.asignadox = e1.idEmpleado "
                    + "INNER JOIN tb_empleado e2 ON i.asignadoa = e2.idEmpleado "
                    + "WHERE i.idIncidencia = ?");
            ps.setInt(1, idIncidencia);
            rs = ps.executeQuery();
            if (rs.next()) {
                vista.txtIDIncidencia.setText(String.valueOf(rs.getInt("idIncidencia")));
                vista.txtNombre.setText(rs.getString("nombreIncidencia"));
                String nombreEmpleado1 = rs.getString("nombreEmpleado1");
                vista.cbxAsignadoX.setSelectedItem(nombreEmpleado1);
                String nombreEmpleado2 = rs.getString("nombreEmpleado2");
                vista.cbxAsignadoA.setSelectedItem(nombreEmpleado2);
                vista.cbxPrioridad.setSelectedItem(rs.getString("prioridad"));
                String nombreTipoInci = rs.getString("nombreTipoInci");
                vista.cbxTipo.setSelectedItem(nombreTipoInci);
                String nombreArea = rs.getString("nombreArea");
                vista.cbxArea.setSelectedItem(nombreArea);
                vista.datecFecha.setDate(rs.getDate("fechaRegistro"));
                vista.txaDescripcion.setText(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            Mensajes.M1("ERROR al seleccionar la Incidencia" + e);
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
        vista.tblIndicencias.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable tabla = (JTable) e.getSource();
                    int row = tabla.getSelectedRow();
                    int idIncidencia = (int) tabla.getValueAt(row, 0);
                    EnviarDatosIncidenciaSeleccionada(idIncidencia);
                }
            }
        });
    }

    public void cargarComboPrioridad() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        modelo.addElement("Alta");
        modelo.addElement("Media");
        modelo.addElement("Baja");
        vista.cbxPrioridad.setModel(modelo);
    }

    //Método para cargar las áreas en el combobox
    public void CargarComboEmpleado1() {
        String query = "SELECT idEmpleado, nombreEmpleado FROM tb_empleado;";
        try {

            st = conexion.createStatement();
            rs = st.executeQuery(query);
            vista.cbxAsignadoX.removeAllItems();

            while (rs.next()) {
                vista.cbxAsignadoX.addItem(rs.getString("nombreEmpleado"));
            }

        } catch (Exception e) {
            Mensajes.M1("ERROR al cargar empleado1" + e);
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

    //Método para cargar las áreas en el combobox
    public void CargarComboEmpleado2() {
        String query = "SELECT idEmpleado, nombreEmpleado FROM tb_empleado;";
        try {

            st = conexion.createStatement();
            rs = st.executeQuery(query);
            vista.cbxAsignadoA.removeAllItems();

            while (rs.next()) {
                vista.cbxAsignadoA.addItem(rs.getString("nombreEmpleado"));
            }

        } catch (Exception e) {
            Mensajes.M1("ERROR al cargar empleado2" + e);
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

    //Método para cargar las áreas en el combobox
    public void CargarComboTipoIncidencia() {
        String query = "SELECT * FROM tb_tipoincidencia;";
        try {

            st = conexion.createStatement();
            rs = st.executeQuery(query);
            vista.cbxTipo.removeAllItems();

            while (rs.next()) {
                vista.cbxTipo.addItem(rs.getString("nombreTipoInci"));
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

    //Método para cargar las áreas en el combobox
    public void CargarComboArea() {
        String query = "SELECT * FROM tb_area;";
        try {

            st = conexion.createStatement();
            rs = st.executeQuery(query);
            vista.cbxArea.removeAllItems();

            while (rs.next()) {
                vista.cbxArea.addItem(rs.getString("nombreArea"));
            }

        } catch (Exception e) {
            Mensajes.M1("ERROR al cargar áreas" + e);
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

    public ArrayList<String> obtenerEmpleados() {
        DAO_Empleado daoEmpleado = new DAO_Empleado();
        return daoEmpleado.obtenerNombresEmpleados();
    }

    public ArrayList<String> obtenerTiposIncidencias() {
        DAO_TipoIncidencia daoTipoIncidencia = new DAO_TipoIncidencia();
        return daoTipoIncidencia.obtenerNombresTipoIncidencia();
    }

    public ArrayList<String> obtenerAreas() {
        DAO_Area daoArea = new DAO_Area();
        return daoArea.obtenerNombresAreas();
    }
}
