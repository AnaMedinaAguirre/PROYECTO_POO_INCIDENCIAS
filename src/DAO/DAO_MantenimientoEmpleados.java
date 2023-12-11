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

public class DAO_MantenimientoEmpleados extends ConectarDB {

    public DAO_MantenimientoEmpleados(InterFrameGestionarEmpleados vista) {
        this.vista = vista;
    }

    InterFrameGestionarEmpleados vista;

    public void MostrarEmpleado(JTable tabla) {
        String[] titulos = {
            "ID Empleado", "Nombre", "Apellido", "Género", "Teléfono", "Cargo",
            "Área", "Fecha Registro", "Sueldo", "Usuario", "Contraseña"
        };

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        Empleado em = new Empleado();

        try {
            String query = "SELECT e.idEmpleado, e.nombreEmpleado, e.apellidoEmpleado, e.genero, "
                    + "e.telefono, e.cargo, a.nombreArea, e.fechaRegistro, e.sueldo, e.usuario, "
                    + "e.contraseña, e.indicador "
                    + "FROM tb_empleado e "
                    + "INNER JOIN tb_area a ON e.idArea = a.idArea "
                    + "WHERE e.indicador = 'S';";

            rs = st.executeQuery(query);

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("idEmpleado"),
                    rs.getString("nombreEmpleado"),
                    rs.getString("apellidoEmpleado"),
                    rs.getString("genero"),
                    rs.getString("telefono"),
                    rs.getString("cargo"),
                    rs.getString("nombreArea"), // Nombre del área en vez de ID
                    rs.getDate("fechaRegistro"),
                    rs.getDouble("sueldo"),
                    rs.getString("usuario"),
                    rs.getString("contraseña")
                };

                modelo.addRow(fila);
            }
        } catch (Exception e) {
            Mensajes.M1("ERROR al mostrar los Empleados" + e);
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

    public void ActualizarEmpleado(Empleado em) {
        try {
            ps = conexion.prepareStatement("UPDATE tb_empleado SET nombreEmpleado=?,apellidoEmpleado=?,genero=?,"
                    + "telefono=?,cargo=?,idArea=?,fechaRegistro=?,sueldo=?,usuario=?,contraseña=? WHERE idEmpleado=?");
            ps.setString(1, em.getNombreEmpleado());
            ps.setString(2, em.getApellidoEmpleado());
            ps.setString(3, em.getGenero());
            ps.setString(4, em.getTelefono());
            ps.setString(5, em.getCargo());
            ps.setInt(6, em.getArea());
            java.sql.Date sqlDate = new java.sql.Date(em.getFechaRegistro().getTime());
            ps.setDate(7, sqlDate);
            ps.setDouble(8, em.getSueldo());
            ps.setString(9, em.getUsuario());
            ps.setString(10, em.getContraseña());
            ps.setInt(11, em.getIdEmpleado());
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

    public void EliminarEmpleado(int idCat) {
        try {
            ps = conexion.prepareStatement("UPDATE tb_empleado SET indicador='N' "
                    + "WHERE idEmpleado=?;");
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

    public void EnviarDatosEmpleadoSeleccionado(int idEmpleado) {
        try {
            //ps = conexion.prepareStatement("SELECT * FROM tb_empleado WHERE idEmpleado = ?");
            ps = conexion.prepareStatement("SELECT e.*, a.nombreArea FROM tb_empleado e INNER JOIN tb_area a ON e.idArea = a.idArea WHERE e.idEmpleado = ?");
            ps.setInt(1, idEmpleado);
            rs = ps.executeQuery();
            if (rs.next()) {
                vista.txtIDEmpleado.setText(String.valueOf(rs.getInt("idEmpleado")));
                vista.txtNombreEmpleado.setText(rs.getString("nombreEmpleado"));
                vista.txtApellidoEmpleado.setText(rs.getString("apellidoEmpleado"));
                vista.cbxGeneroEmpleado.setSelectedItem(rs.getString("genero"));
                vista.txtTelefonoEmpleado.setText(rs.getString("telefono"));
                vista.txtCargoEmpleado.setText(rs.getString("cargo"));
                //vista.cbxAreaEmpleado.setSelectedItem(rs.getString("idArea"));
                String nombreArea = rs.getString("nombreArea"); // Obtener nombre del área
                vista.cbxAreaEmpleado.setSelectedItem(nombreArea);
                vista.cbxAreaEmpleado.setSelectedItem(nombreArea);
                vista.datecFechaEmpleado.setDate(rs.getDate("fechaRegistro"));
                vista.txtSueldoEmpleado.setText(String.valueOf(rs.getDouble("sueldo")));
                vista.txtUsuarioEmpleado.setText(rs.getString("usuario"));
                vista.txtContraseñaEmpleado.setText(rs.getString("contraseña"));
            }
        } catch (SQLException e) {
            Mensajes.M1("ERROR al seleccionar el empleado" + e);
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
        vista.tblEmpleado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable tabla = (JTable) e.getSource();
                    int row = tabla.getSelectedRow();
                    int idEmpleado = (int) tabla.getValueAt(row, 0);
                    EnviarDatosEmpleadoSeleccionado(idEmpleado);
                }
            }
        });
    }

    public void cargarComboGenero() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        modelo.addElement("M");
        modelo.addElement("F");
        vista.cbxGeneroEmpleado.setModel(modelo);
    }

    //Método para cargar las áreas en el combobox
    public void CargarComboArea() {
        String query = "SELECT * FROM tb_area;";
        try {

            st = conexion.createStatement();
            rs = st.executeQuery(query);
            vista.cbxAreaEmpleado.removeAllItems();

            while (rs.next()) {
                vista.cbxAreaEmpleado.addItem(rs.getString("nombreArea"));
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

    public ArrayList<String> obtenerAreas() {
        DAO_Area daoArea = new DAO_Area();
        return daoArea.obtenerNombresAreas();
    }

}
