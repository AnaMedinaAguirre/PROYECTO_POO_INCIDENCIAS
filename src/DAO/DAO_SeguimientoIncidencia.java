package DAO;

import Modelo.*;
import Formatos.*;
import java.sql.Date;
import Vista.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAO_SeguimientoIncidencia extends ConectarDB {

    public DAO_SeguimientoIncidencia() {
    }

    InterFrameSeguimientoIncidencia vista;

    public void MostrarIncidencias(JTable tabla) {
        String[] titulos = {
            "ID Incidencia", "Nombre Incidencia", "Encargado", "Estado", "Prioridad", "Tipo Incidencia",
            "Área", "Fecha de Modificación"
        };

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        //Incidencia i = new Incidencia();

        try {

            String query = "SELECT i.idIncidencia, i.nombreIncidencia, e1.nombreEmpleado AS nombreEmpleado1, "
                    + "ds.estado, i.prioridad, ti.nombreTipoInci, a.nombreArea, ds.fechaModificacion "
                    + "FROM tb_incidencia i "
                    + "INNER JOIN tb_area a ON i.idArea = a.idArea "
                    + "INNER JOIN tb_tipoincidencia ti ON i.idTipoInci = ti.idTipoInci "
                    + "INNER JOIN tb_empleado e1 ON i.asignadoa = e1.idEmpleado "
                    + "INNER JOIN tb_detsolucion ds ON i.idIncidencia = ds.idIncidencia "
                    + "WHERE i.indicador = 'S';";

            rs = st.executeQuery(query);

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("idIncidencia"),
                    rs.getString("nombreIncidencia"),
                    rs.getString("nombreEmpleado1"), // Nombre del empleado en vez de la ID
                    rs.getString("estado"),
                    rs.getString("prioridad"),
                    rs.getString("nombreTipoInci"), //Nombre del tipo de incidencia en vez del ID
                    rs.getString("nombreArea"), // Nombre del área en vez de ID
                    rs.getDate("fechaModificacion")
                };
                modelo.addRow(fila);
            }

        } catch (Exception e) {
            Mensajes.M1("ERROR al mostrar las Incidencias" + e);
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

    public ArrayList<String> obtenerEmpleados() {
        DAO_Empleado daoEmpleado = new DAO_Empleado();
        return daoEmpleado.obtenerNombresEmpleados();
    }

    public ArrayList<String> obtenerTiposIncidencias() {
        DAO_TipoIncidencia daoTipoIncidencia = new DAO_TipoIncidencia();
        return daoTipoIncidencia.obtenerNombresTipoIncidencia();
    }

    public ArrayList<String> obtenerAreas() {
        DAO_Area daoArea = new DAO_Area();
        return daoArea.obtenerNombresAreas();
    }

    public ArrayList<String> obtenerEstado() {
        DAO_DetalleSolucion daoDetalleSolucion = new DAO_DetalleSolucion();
        return daoDetalleSolucion.obtenerEstado();
    }

    public ArrayList<String> obtenerFechaModificacion() {
        DAO_DetalleSolucion daoDetalleSolucion = new DAO_DetalleSolucion();
        return daoDetalleSolucion.obtenerFechaModificacion();
    }

    public Incidencia ConsultarRegistro(int idcat) {
        Incidencia incidencia = null;
        DetalleSolucion detalleSolucion = null;
        try {
            String query = "SELECT i.idIncidencia, i.nombreIncidencia, e1.nombreEmpleado AS nombreEmpleado1, "
                    + "ds.estado, i.prioridad, i.idTipoInci, a.nombreArea, ds.fechaModificacion, i.asignadoa, i.idArea, i.indicador "
                    + "FROM tb_incidencia i "
                    + "INNER JOIN tb_area a ON i.idArea = a.idArea "
                    + "INNER JOIN tb_tipoincidencia ti ON i.idTipoInci = ti.idTipoInci "
                    + "INNER JOIN tb_empleado e1 ON i.asignadoa = e1.idEmpleado "
                    + "INNER JOIN tb_detsolucion ds ON i.idIncidencia = ds.idIncidencia "
                    + "WHERE i.indicador = 'S' AND i.idIncidencia = ?";

            // Preparar la consulta SQL
            ps = conexion.prepareStatement(query);
            ps.setInt(1, idcat);

            // Ejecutar la consulta y obtener el resultado
            rs = ps.executeQuery();

            // Verificar si se encontró un resultado
            if (rs.next()) {
                incidencia = new Incidencia();
                detalleSolucion = new DetalleSolucion();

                // Configurar los valores de Incidencia y DetalleSolucion desde el ResultSet
                incidencia.setIdIncidencia(rs.getInt("idIncidencia"));
                incidencia.setNombreIncidencia(rs.getString("nombreIncidencia"));
                incidencia.setAsignadoa(rs.getInt("asignadoa"));
                detalleSolucion.setEstado(rs.getString("estado"));
                incidencia.setPrioridad(rs.getString("prioridad"));
                incidencia.setIdTipoInci(rs.getInt("idTipoInci"));
                incidencia.setIdArea(rs.getInt("idArea"));
                detalleSolucion.setFechaModificacion(rs.getDate("fechaModificacion"));
                incidencia.setIndicador(rs.getString("indicador"));
            }

            // Cerrar recursos
            if (rs != null) {
                rs.close();
            }
            ps.close();
        } catch (SQLException e) {
            Mensajes.M1("ERROR al consultar el registro: " + e);
        }
        return incidencia;
    }

    public DetalleSolucion obtenerDetalleSolucionPorIdIncidencia(int idIncidencia) {
        DetalleSolucion detalleSolucion = null;

        try {
            String query = "SELECT idDetSolucion, idIncidencia, observacion, estado, fechaModificacion, indicador FROM tb_detsolucion WHERE idIncidencia = ?";
            ps = conexion.prepareStatement(query);
            ps.setInt(1, idIncidencia);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Aquí asumiendo que DetalleSolucion tiene un constructor que toma los campos necesarios
                detalleSolucion = new DetalleSolucion();
                detalleSolucion.setIdDetSolucion(rs.getInt("idDetSolucion"));
                detalleSolucion.setIdIncidencia(rs.getInt("idIncidencia"));
                detalleSolucion.setObservacion(rs.getString("observacion"));
                detalleSolucion.setEstado(rs.getString("estado"));
                detalleSolucion.setFechaModificacion(rs.getDate("fechaModificacion"));
                detalleSolucion.setIndicador(rs.getString("indicador"));
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            // Manejar cualquier excepción que pueda ocurrir al consultar la base de datos
            e.printStackTrace(); // Por lo general, es buena práctica manejar los errores correctamente
        }

        return detalleSolucion;
    }

}
