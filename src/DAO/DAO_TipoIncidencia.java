package DAO;

import Modelo.*;
import Formatos.*;
import java.sql.Date;
import Vista.InterFrameTipoIncidencia;

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
    
}
