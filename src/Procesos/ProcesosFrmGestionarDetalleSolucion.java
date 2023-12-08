package Procesos;

import Vista.*;
import Modelo.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import DAO.*;

public class ProcesosFrmGestionarDetalleSolucion {

    public static Calendar cal = new GregorianCalendar();
    DAO_Incidencia crud1 = new DAO_Incidencia();

    public static void Presentacion(InterFrameGestionarDetalleSolucion frgds) {
        frgds.setVisible(true);
        frgds.setTitle("Gestionar Detalle de Solución");
        frgds.datecFecha.setCalendar(cal);
        frgds.txtID.setEnabled(false);
    }

    public static void Estado1(InterFrameGestionarDetalleSolucion frgds) {
        frgds.btnActualizar.setEnabled(false);
        frgds.btnEliminar.setEnabled(true);
    }

    public static void LimpiarEntradas(InterFrameGestionarDetalleSolucion frgds) {
        frgds.cbxIncidencia.setSelectedIndex(0);
        frgds.txaObservacion.setText("");
        frgds.cbxEstado.setSelectedIndex(0);
        frgds.datecFecha.setCalendar(cal);
    }

    public static DetalleSolucion LeerDatos(InterFrameGestionarDetalleSolucion frgds, DAO_Incidencia crud1) {
        DetalleSolucion ds = new DetalleSolucion();

        String IncidenciaSeleccionada = frgds.cbxIncidencia.getSelectedItem().toString();
        int IncidenciaId = crud1.obtenerIdIncidenciaPorNombre(IncidenciaSeleccionada);
        ds.setIdIncidencia(IncidenciaId);

        ds.setObservacion(frgds.txaObservacion.getText());

        ds.setEstado(frgds.cbxEstado.getSelectedItem().toString());

        ds.setFechaModificacion(frgds.datecFecha.getDate());

        return ds;
    }
}
