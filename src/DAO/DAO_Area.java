package DAO;

import Modelo.*;
import Formatos.*;
import java.sql.Date;
import Vista.InterFrameRegistroAreas;
import java.util.ArrayList;

public class DAO_Area extends ConectarDB{
    
    public DAO_Area(){}
    
    InterFrameRegistroAreas vista;
    
    //metodo para registrar areas
    public void insertarAreas(Area a){
        try {
            
            String query = "INSERT INTO tb_area(nombreArea,responsable,ubicacion,fechaRegistro,"
                    + "descripcion,indicador) VALUES(?,?,?,?,?,'S');";
            ps = conexion.prepareStatement(query);
            
            ps.setString(1, a.getNombreArea());
            ps.setString(2, a.getResponsable());
            ps.setString(3, a.getUbicacion());
            // Convertir java.util.Date a java.sql.Date
            java.util.Date fechaUtil = a.getFechaRegistro();
            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
            ps.setDate(4, fechaSql);
            ps.setString(5, a.getDescripcion());
            
            ps.executeUpdate();
            
            Mensajes.M1("Datos insertados correctamente");

            conexion.close();
            
        } catch (Exception e) {
            
            Mensajes.M1("ERROR no se puede insetar Area" + e);
            
        }
    }
    
    public ArrayList<String> obtenerNombresAreas() {
        ArrayList<String> nombresAreas = new ArrayList<>();

        try {
            String query = "SELECT nombreArea FROM tb_area;"; // Query para obtener los 
                                                              // nombres de áreas
            st = conexion.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                nombresAreas.add(rs.getString("nombreArea")); // Agregar el nombre del área 
                                                              // a la lista
            }

            // Cerrar la conexión
            conexion.close();
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir al obtener los nombres de áreas
            Mensajes.M1("Error al obtener nombres de áreas: " + e.getMessage());
        }

        return nombresAreas; // Devolver la lista de nombres de áreas
    }
    
    public int obtenerIdAreaPorNombre(String nombreArea) {
        int idArea = 0; // Valor predeterminado si no se encuentra el área
        
        try {
            String query = "SELECT idArea FROM tb_area WHERE nombreArea = ?;";
            ps = conexion.prepareStatement(query);
            ps.setString(1, nombreArea);
            rs = ps.executeQuery();

            if (rs.next()) {
                idArea = rs.getInt("idArea");
            }

            conexion.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR al obtener ID del área." + e);
        }

        return idArea;
    }
    
    //agregado
    public String obtenerNombreAreaPorId(int idArea) {
    String nombreArea = null;

    try {
        String query = "SELECT nombreArea FROM tb_area WHERE idArea = ?;";
        ps = conexion.prepareStatement(query);
        ps.setInt(1, idArea);
        rs = ps.executeQuery();

        if (rs.next()) {
            nombreArea = rs.getString("nombreArea");
        }
    } catch (Exception e) {
        Mensajes.M1("ERROR al obtener nombre del área." + e);
    }

    return nombreArea;
}

}