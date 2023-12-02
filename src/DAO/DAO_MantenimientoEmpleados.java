package DAO;

import Modelo.*;
import Formatos.*;
import java.sql.Date;
import Vista.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAO_MantenimientoEmpleados extends ConectarDB{
    
    public DAO_MantenimientoEmpleados(InterFrameGestionarEmpleados vista) {
        this.vista = vista;
    }
    
    InterFrameGestionarEmpleados vista;
    
    //Método para cargar las áreas en el combobox
    public void CargarComboArea() {
        String query = "SELECT * FROM tb_area;";
        try {
            
            st = conexion.createStatement();
            rs = st.executeQuery(query);
            vista.cbxAreaEmpleado.removeAllItems();
            vista.cbxAreaEmpleado.addItem("Seleccione area:");
            
            while (rs.next()) {                
                vista.cbxAreaEmpleado.addItem(rs.getString("nombreArea"));
            }
            conexion.close();
            
        } catch (Exception e) {
            Mensajes.M1("ERROR al cargar categorías."+e);
        }
    }

    String nombreArea = "";
    String genero = "";
    int idEmpleado;
    int obtenerIdAreaCombo = 0;

    //metodo para cargar tabla empleados
    
    public void CargarTablaEmpleado(){
    DefaultTableModel modelo = new DefaultTableModel();

    String query = "SELECT e.idEmpleado, e.nombreEmpleado, e.apellidoEmpleado, "
            + "e.telefono, e.cargo, e.fechaRegistro, e.usuario, e.contraseña, "
            + "a.nombreArea, a.descripcion, e.indicador "
            + "FROM tb_empleado AS e "
            + "INNER JOIN tb_area AS a ON e.idArea = a.idArea;";

    try {
        st = conexion.createStatement();
        rs = st.executeQuery(query);

        modelo.addColumn("N°");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Género");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Cargo");
        modelo.addColumn("Área");
        modelo.addColumn("Fecha registro");
        modelo.addColumn("Sueldo");
        modelo.addColumn("Usuario");
        modelo.addColumn("Contraseña");

        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("idEmpleado"),
                rs.getString("nombreEmpleado"),
                rs.getString("apellidoEmpleado"),
                rs.getString("genero"),
                rs.getString("telefono"),
                rs.getString("cargo"),
                rs.getString("nombreArea"),
                rs.getDate("fechaRegistro"),
                rs.getString("sueldo"),
                rs.getString("usuario"),
                rs.getString("contraseña")
            });
        }

        // Configurar el modelo del JTable
        vista.tblEmpleado.setModel(modelo);

        // Añadir el MouseListener después de inicializar la tabla
        vista.tblEmpleado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = vista.tblEmpleado.rowAtPoint(e.getPoint());
                int columna = 0;

                if (fila > -1) {
                    idEmpleado = (int) modelo.getValueAt(fila, columna);
                    //EnviarDatosEmpleadoSeleccionado(idEmpleado);
                }
            }
        });

    } catch (Exception e) {
        Mensajes.M1("ERROR al llenar la tabla empleados" + e);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException ex) {
            Mensajes.M1("Error al cerrar la conexión: " + ex.getMessage());
        }
    }
}

private void EnviarDatosEmpleadoSeleccionado(int idEmpleado){
    try {
        ps = conexion.prepareStatement("SELECT * FROM tb_empleado WHERE idEmpleado = ?");
        ps.setInt(1, idEmpleado);
        rs = ps.executeQuery();

        if (rs.next()) {
            vista.txtNombreEmpleado.setText(rs.getString("nombreEmpleado"));
            vista.txtApellidoEmpleado.setText(rs.getString("apellidoEmpleado"));
            vista.txtCargoEmpleado.setText(rs.getString("cargo"));
            vista.txtTelefonoEmpleado.setText(rs.getString("telefono"));
            vista.txtUsuarioEmpleado.setText(rs.getString("usuario"));
            vista.txtContraseñaEmpleado.setText(rs.getString("contraseña"));
            vista.datecFechaEmpleado.setDate(rs.getDate("fechaRegistro"));
            double sueldo = rs.getDouble("sueldo");
            int idArea = rs.getInt("idArea");
            vista.cbxAreaEmpleado.setSelectedItem(relacionarAreas(idArea));
        }

        conexion.close();
    } catch (Exception e) {
        Mensajes.M1("ERROR al seleccionar empleado");
    }
}

    
    //metodo para relacionar areas
    public String relacionarAreas(int idArea){
        String query = "SELECT nombreArea FROM tb_area WHERE idArea = '" + idArea + "'";
        try {
            
            st = conexion.createStatement();
            rs = st.executeQuery(query);
            
            while (rs.next()) {                
                nombreArea = rs.getString("nombreArea");
            }
            conexion.close();
            
        } catch (Exception e) {
            Mensajes.M1("ERROR al obtener el id del área."+e);
        }
        return nombreArea;
    }
    
    
}
