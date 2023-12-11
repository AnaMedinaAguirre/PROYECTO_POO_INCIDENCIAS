package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import DAO.*;
import Procesos.*;
import Formatos.*;
import javax.swing.table.DefaultTableModel;

public class ControladorFrmSeguimientoIncidencia implements ActionListener {

    InterFrameSeguimientoIncidencia vista;
    DAO_SeguimientoIncidencia crud;
    Incidencia i;
    DetalleSolucion ds;
    DAO_Empleado crud1;
    DAO_TipoIncidencia crud2;
    DAO_Area crud3;
    DAO_Incidencia crud4;

    public ControladorFrmSeguimientoIncidencia(InterFrameSeguimientoIncidencia f10) {
        vista = f10;
        vista.btnBuscar.addActionListener(this);
        vista.btnTodos.addActionListener(this);
        ProcesosFrmSeguimientoIncidencia.Presentacion(f10);
        crud = new DAO_SeguimientoIncidencia();
        crud.MostrarIncidencias(vista.tblSeguimiento);
        ActualizarTabla();
    }

    public void ActualizarTabla() {
        crud = new DAO_SeguimientoIncidencia();
        crud.MostrarIncidencias(vista.tblSeguimiento);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.btnTodos) {
            ActualizarTabla();
        }

        if (e.getSource() == vista.btnBuscar) {
            String idText = vista.txtID.getText(); // Obtener el texto del JTextField

            if (!idText.isEmpty()) {
                try {
                    int idcat = Integer.parseInt(idText);
                    crud = new DAO_SeguimientoIncidencia();
                    Incidencia seguimientoIncidencia = crud.ConsultarRegistro(idcat);

                    if (seguimientoIncidencia == null) {
                        Mensajes.M1("El ID " + idcat + " no existe en la tabla de seguimiento");
                    } else {
                        DefaultTableModel modelo = (DefaultTableModel) vista.tblSeguimiento.getModel();
                        modelo.setRowCount(0); // Limpiar todas las filas

                        // Obtener el detalle de solución asociado a la incidencia
                        DetalleSolucion detalleSolucion = crud.obtenerDetalleSolucionPorIdIncidencia(idcat); // Implementa este método para obtener el DetalleSolucion

                        // Instancias de los DAOs
                        DAO_Empleado daoEmpleado = new DAO_Empleado();
                        DAO_TipoIncidencia daoTipoIncidencia = new DAO_TipoIncidencia();
                        DAO_Area daoArea = new DAO_Area();

                        // Obtener nombres correspondientes a los IDs
                        int idEmpleado = seguimientoIncidencia.getAsignadoa();
                        String nombreEmpleado = daoEmpleado.obtenerNombreEmpleadoPorId(idEmpleado);

                        int idTipoIncidencia = seguimientoIncidencia.getIdTipoInci();
                        String nombreTipoIncidencia = daoTipoIncidencia.obtenerNombreTipoIncidenciaPorId(idTipoIncidencia);

                        int idArea = seguimientoIncidencia.getIdArea();
                        String nombreArea = daoArea.obtenerNombreAreaPorId(idArea);

                        // Agregar la fila con los nombres correspondientes
                        Object[] fila = {
                            seguimientoIncidencia.getIdIncidencia(),
                            seguimientoIncidencia.getNombreIncidencia(),
                            nombreEmpleado,
                            detalleSolucion.getEstado(), // Obtener el estado del detalle de solución
                            seguimientoIncidencia.getPrioridad(),
                            nombreTipoIncidencia,
                            nombreArea,
                            detalleSolucion.getFechaModificacion()
                        };
                        modelo.addRow(fila);
                    }
                } catch (NumberFormatException ex) {
                    Mensajes.M1("Ingrese un número válido para el ID");
                }
            } else {
                Mensajes.M1("Ingrese un ID para buscar");
            }
        }
    }
}
