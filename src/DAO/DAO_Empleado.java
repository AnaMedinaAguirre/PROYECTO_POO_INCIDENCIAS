package DAO;

import Modelo.*;
import Formatos.*;
import java.sql.Date;
import Vista.InterFrameNuevoEmpleado;
import java.util.ArrayList;

public class DAO_Empleado extends ConectarDB {

    public DAO_Empleado() {
    }

    InterFrameNuevoEmpleado vista;

    //método para registrar empleados
    public void insertarEmpleado(Empleado em) {

        try {
            String query = "INSERT INTO tb_empleado(nombreEmpleado,apellidoEmpleado,genero,telefono,"
                    + "cargo,idArea,fechaRegistro,sueldo,usuario,contraseña,indicador) VALUES(?,?,?,?,?,?,?,?,?,?,'S');";
            ps = conexion.prepareStatement(query);

            ps.setString(1, em.getNombreEmpleado());
            ps.setString(2, em.getApellidoEmpleado());
            ps.setString(3, em.getGenero());
            ps.setString(4, em.getTelefono());
            ps.setString(5, em.getCargo());
            ps.setInt(6, em.getArea());
            // Convertir java.util.Date a java.sql.Date
            java.util.Date fechaUtil = em.getFechaRegistro();
            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
            ps.setDate(7, fechaSql);
            ps.setDouble(8, em.getSueldo());
            ps.setString(9, em.getUsuario());
            ps.setString(10, em.getContraseña());

            ps.executeUpdate();

            Mensajes.M1("Datos insertados correctamente");

            conexion.close();

        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede insetar empleados" + e);
        }
    }

    public ArrayList<String> obtenerAreas() {
        DAO_Area daoArea = new DAO_Area();
        return daoArea.obtenerNombresAreas();
    }

    public ArrayList<String> obtenerNombresEmpleados() {
        ArrayList<String> nombreEmpleados = new ArrayList<>();

        try {
            String query = "SELECT nombreEmpleado FROM tb_empleado;";
            st = conexion.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                nombreEmpleados.add(rs.getString("nombreEmpleado"));
            }

        } catch (Exception e) {
            Mensajes.M1("Error al obtener los nombres de los empleados: " + e.getMessage());
        }

        return nombreEmpleados;
    }

    public int obtenerIdEmpleadoPorNombre(String nombreEmpleado) {

        int idEmpleado = 0; // Valor predeterminado si no se encuentra el empleado

        try {
            String query = "SELECT idEmpleado FROM tb_empleado WHERE nombreEmpleado = ?;";
            ps = conexion.prepareStatement(query);
            ps.setString(1, nombreEmpleado);
            rs = ps.executeQuery();

            if (rs.next()) {
                idEmpleado = rs.getInt("idEmpleado");
            }

            //conexion.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR al obtener ID del empleado." + e);
        }

        return idEmpleado;
    }
    
    //agregado
    public String obtenerNombreEmpleadoPorId(int idEmpleado) {
    String nombreEmpleado = null; // Valor predeterminado si no se encuentra el nombre del empleado

    try {
        String query = "SELECT nombreEmpleado FROM tb_empleado WHERE idEmpleado = ?;";
        ps = conexion.prepareStatement(query);
        ps.setInt(1, idEmpleado);
        rs = ps.executeQuery();

        if (rs.next()) {
            nombreEmpleado = rs.getString("nombreEmpleado");
        }

        //conexion.close();
    } catch (Exception e) {
        Mensajes.M1("ERROR al obtener nombre del empleado." + e);
    }

    return nombreEmpleado;
}

}
