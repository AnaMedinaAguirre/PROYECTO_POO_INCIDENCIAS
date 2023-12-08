package Procesos;

import Modelo.*;
import Vista.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import DAO.*;

public class ProcesosFrmDetalleSolucion {
    DAO_Incidencia crud1 = new DAO_Incidencia();
    public static Calendar cal = new GregorianCalendar();
    
    public static void PresentacionNuevoDetalleSolucion(InterFrameNuevoDetallesSolucion ifnds){
        ifnds.setVisible(true);
        ifnds.setTitle("Ingresar nuevo Detalle de Solución");
        ifnds.datecFecha.setCalendar(cal);
    }
    
    public static void LimpiarEntradas(InterFrameNuevoDetallesSolucion ifnds){
        ifnds.cbxIncidencia.setSelectedIndex(0);
        ifnds.cbxEstado.setSelectedIndex(0);
        ifnds.datecFecha.setCalendar(cal);
        ifnds.txaObservacion.setText("");
    }
    
    public DetalleSolucion LeerDatos(InterFrameNuevoDetallesSolucion ifnds){
        DetalleSolucion ds = new DetalleSolucion();
        
        ds.setObservacion(ifnds.txaObservacion.getText());
        ds.setEstado(ifnds.cbxEstado.getSelectedItem().toString());
      
        //INCIDENCIA
        String nombreIncidenciaSeleccionada = ifnds.cbxIncidencia.getSelectedItem().toString();
        int idIncidencia = crud1.obtenerIdIncidenciaPorNombre(nombreIncidenciaSeleccionada);
        ds.setIdIncidencia(idIncidencia);

        ds.setFechaModificacion(ifnds.datecFecha.getDate());
        
        return ds;     
    }
    
    public static void CargarCombos(InterFrameNuevoDetallesSolucion ifnds){
        ifnds.cbxEstado.addItem("En proceso");
        ifnds.cbxEstado.addItem("Atendido");
        ifnds.cbxEstado.addItem("Derivado");
    }
}
