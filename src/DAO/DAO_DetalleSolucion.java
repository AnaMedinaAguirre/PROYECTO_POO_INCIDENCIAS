package DAO;

import Modelo.*;
import Formatos.*;
import java.sql.Date;
import Vista.*;
import java.util.ArrayList;

public class DAO_DetalleSolucion extends ConectarDB{
    
    public DAO_DetalleSolucion(){}
    
    InterFrameNuevoDetallesSolucion vista;
    
    //método para registrar Detalle Solución
    public void insertarDetalleSolucion(DetalleSolucion ds){
        try {
            String query = "INSERT INTO tb_detsolucion(idIncidencia, observacion, estado, "
                    + "fechaModificacion, indicador) VALUES(?,?,?,?,'S');";
            
            ps = conexion.prepareStatement(query);
            
            ps.setInt(1, ds.getIdIncidencia());
            ps.setString(2, ds.getObservacion());
            ps.setString(3, ds.getEstado());
            // Convertir java.util.Date a java.sql.Date
            java.util.Date fechaUtil = ds.getFechaModificacion();
            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
            ps.setDate(4, fechaSql);
            
            ps.executeUpdate();
            
            Mensajes.M1("Datos insertados correctamente");

            conexion.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede insertar el detalle de solución" + e);
        }
    }
    
    //incidencia
    public ArrayList<String> obtenerIncidencias() {
        DAO_Incidencia daoIncidencia = new DAO_Incidencia();
        return daoIncidencia.obtenerNombresIncidencia();
    }
}
