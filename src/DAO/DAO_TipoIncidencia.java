package DAO;

import Modelo.*;
import Formatos.*;
import java.sql.Date;
import Vista.InterFrameTipoIncidencia;
import java.util.ArrayList;

public class DAO_TipoIncidencia extends ConectarDB{
    
    public DAO_TipoIncidencia(){}
    
    InterFrameTipoIncidencia vista;
    
    //metodo para registrar Tipo Incidenia
    public void insertarTipoIncidencia(TipoIncidencia ti){
        try {
            String query = "INSERT INTO tb_tipoincidencia(nombreTipoInci,categoria,fechaRegistro,"
                    + "descripcion,indicador) VALUES(?,?,?,?,'S');";
            ps = conexion.prepareStatement(query);
            
            ps.setString(1, ti.getNombreTipoInci());
            ps.setString(2, ti.getCategoria());
            // Convertir java.util.Date a java.sql.Date
            java.util.Date fechaUtil = ti.getFechaRegistro();
            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
            ps.setDate(3, fechaSql);
            ps.setString(4, ti.getDescripcion());
            
            ps.executeUpdate();

            Mensajes.M1("Datos insertados correctamente");

            conexion.close();
            
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede insetar Tipo Incidencia" + e);
        }
    }
    
    public ArrayList<String> obtenerNombresTipoIncidencia(){
        ArrayList<String> nombreTiposIncidencias = new ArrayList<>();
        
        try {
            String query = "SELECT nombreTipoInci FROM tb_tipoincidencia;"; // Query para obtener los 
                                                                            // nombres de los tipos de
                                                                            //incidencia
            st = conexion.createStatement();
            rs = st.executeQuery(query);
            
            while (rs.next()) {                
                nombreTiposIncidencias.add(rs.getString("nombreTipoInci")); // Agregar el nombre del tipo de
                                                                            // incidencia a la lista
            }
            
            // Cerrar la conexión
            conexion.close();
            
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir al obtener los nombres de tipos de incidencia
            Mensajes.M1("Error al obtener nombres de los tipos de incidencia: " + e.getMessage());
        }
        
        return nombreTiposIncidencias;
    }
    
    public int obtenerIdTipoIncidenciaPorNombre(String nombreTipoInci){
        
        int idTipoInci = 0; // Valor predeterminado si no se encuentra el tipo de incidencia
        
        try {
            String query = "SELECT idTipoInci FROM tb_tipoincidencia WHERE nombreTipoInci = ?;";
            ps = conexion.prepareStatement(query);
            ps.setString(1, nombreTipoInci);
            rs = ps.executeQuery();

            if (rs.next()) {
                idTipoInci = rs.getInt("idTipoInci");
            }

            conexion.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR al obtener ID del tipo de incidencia." + e);
        }
        
        return idTipoInci;
    }
    
    //agregado
    public String obtenerNombreTipoIncidenciaPorId(int idTipoIncidencia) {
    String nombreTipoIncidencia = null;

    try {
        String query = "SELECT nombreTipoInci FROM tb_tipoincidencia WHERE idTipoInci = ?;";
        ps = conexion.prepareStatement(query);
        ps.setInt(1, idTipoIncidencia);
        rs = ps.executeQuery();

        if (rs.next()) {
            nombreTipoIncidencia = rs.getString("nombreTipoInci");
        }
    } catch (Exception e) {
        Mensajes.M1("ERROR al obtener nombre del tipo de incidencia." + e);
    }

    return nombreTipoIncidencia;
}

}
