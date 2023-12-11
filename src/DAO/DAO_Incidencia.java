package DAO;

import Modelo.*;
import Formatos.*;
import java.sql.Date;
import Vista.*;
import java.util.ArrayList;

public class DAO_Incidencia extends ConectarDB {

    public DAO_Incidencia() {
    }

    InterFrameNuevaIncidencia vista;

    //método para registrar incidencias
    public void insertarIncidencia(Incidencia i) {
        try {
            String query = "INSERT INTO tb_incidencia(nombreIncidencia,asignadox,asignadoa,prioridad,"
                    + "idTipoInci,idArea,fechaRegistro,descripcion, indicador) VALUES(?,?,?,?,?,?,?,?,'S');";

            ps = conexion.prepareStatement(query);

            ps.setString(1, i.getNombreIncidencia());
            ps.setInt(2, i.getAsignadox());
            ps.setInt(3, i.getAsignadoa());
            ps.setString(4, i.getPrioridad());
            ps.setInt(5, i.getIdTipoInci());
            ps.setInt(6, i.getIdArea());
            // Convertir java.util.Date a java.sql.Date
            java.util.Date fechaUtil = i.getFechaRegistro();
            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
            ps.setDate(7, fechaSql);
            ps.setString(8, i.getDescripcion());

            ps.executeUpdate();

            Mensajes.M1("Datos insertados correctamente");

            conexion.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede insertar incidencias" + e);
        }
    }

    //empleado
    public ArrayList<String> obtenerEmpleados() {
        DAO_Empleado daoEmpleado = new DAO_Empleado();
        return daoEmpleado.obtenerNombresEmpleados();
    }

    //tipo incidencia
    public ArrayList<String> obtenerTiposIncidencias() {
        DAO_TipoIncidencia daoTipoIncidencia = new DAO_TipoIncidencia();
        return daoTipoIncidencia.obtenerNombresTipoIncidencia();
    }

    //area
    public ArrayList<String> obtenerAreas() {
        DAO_Area daoArea = new DAO_Area();
        return daoArea.obtenerNombresAreas();
    }

    public ArrayList<String> obtenerNombresIncidencia() {
        ArrayList<String> nombreIncidencia = new ArrayList<>();

        try {
            String query = "SELECT nombreIncidencia FROM tb_incidencia;"; // Query para obtener los 
            // nombres de las
            //incidencias
            st = conexion.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                nombreIncidencia.add(rs.getString("nombreIncidencia")); // Agregar el nombre de la
                // incidencia a la lista
            }

            // Cerrar la conexión
            conexion.close();

        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir al obtener los nombres de incidencia
            Mensajes.M1("Error al obtener nombres de las incidencias: " + e.getMessage());
        }

        return nombreIncidencia;
    }

    public int obtenerIdIncidenciaPorNombre(String nombreIncidencia) {

        int idIncidencia = 0; // Valor predeterminado si no se encuentra la incidencia

        try {
            String query = "SELECT idIncidencia FROM tb_incidencia WHERE nombreIncidencia = ?;";
            ps = conexion.prepareStatement(query);
            ps.setString(1, nombreIncidencia);
            rs = ps.executeQuery();

            if (rs.next()) {
                idIncidencia = rs.getInt("idIncidencia");
            }

            conexion.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR al obtener ID de la incidencia." + e);
        }

        return idIncidencia;
    }
}
