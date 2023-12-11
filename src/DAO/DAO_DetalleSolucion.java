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
    
    public ArrayList<String> obtenerEstado() {
        ArrayList<String> estado = new ArrayList<>();

        try {
            String query = "SELECT estado FROM tb_detsolucion;";
            st = conexion.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                estado.add(rs.getString("estado"));
            }

        } catch (Exception e) {
            Mensajes.M1("Error al obtener los estados: " + e.getMessage());
        }

        return estado;
    }
    
    public ArrayList<String> obtenerFechaModificacion() {
        ArrayList<String> fechaModificacion = new ArrayList<>();

        try {
            String query = "SELECT fechaModificacion FROM tb_detsolucion;";
            st = conexion.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                fechaModificacion.add(rs.getString("fechaModificacion"));
            }

        } catch (Exception e) {
            Mensajes.M1("Error al obtener las fechas de modificacion: " + e.getMessage());
        }

        return fechaModificacion;
    }
}