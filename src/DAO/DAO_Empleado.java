package DAO;

import Modelo.*;
import Formatos.*;
import java.sql.Date;
import Vista.InterFrameNuevoEmpleado;
import java.util.ArrayList;

public class DAO_Empleado extends ConectarDB {

    public DAO_Empleado() {}
    
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
}