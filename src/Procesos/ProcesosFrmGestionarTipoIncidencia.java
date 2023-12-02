package Procesos;

import Vista.*;
import Modelo.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ProcesosFrmGestionarTipoIncidencia {
    
    public static Calendar cal = new GregorianCalendar();
    
    public static void Presentacion(InterFrameGestionarTipoIncidencia frgti){
        frgti.setVisible(true);
        frgti.setTitle("Gestionar Tipos de Incidencias");
        frgti.datecFecha.setCalendar(cal);
        frgti.txtIDTipoInci.setEnabled(false);
    }
    
    public static void Estado1(InterFrameGestionarTipoIncidencia frgti){
        frgti.btnActualizar.setEnabled(false);
        frgti.btnEliminar.setEnabled(true);  
    }
    
    public static void LimpiarEntradas(InterFrameGestionarTipoIncidencia frgti){
        frgti.txtNombre.setText("");
        frgti.cbxCategoria.setSelectedIndex(0);
        frgti.datecFecha.setCalendar(cal);   
        frgti.txaDescripcion.setText("");    
    }
    
    public static TipoIncidencia LeerDatos(InterFrameGestionarTipoIncidencia frgti){
        TipoIncidencia ti = new TipoIncidencia();
        ti.setNombreTipoInci(frgti.txtNombre.getText());
        ti.setCategoria(frgti.cbxCategoria.getSelectedItem().toString());
        ti.setFechaRegistro(frgti.datecFecha.getDate());
        ti.setDescripcion(frgti.txaDescripcion.getText());
        return ti;
    }
}
