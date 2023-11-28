package Procesos;

import Modelo.*;
import Vista.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ProcesosFrmTipoIncidencia {
    public static Calendar cal = new GregorianCalendar();
    
    public static void PresentacionTipoIncidencia(InterFrameTipoIncidencia ifti){
        ifti.setVisible(true);
        ifti.setTitle("Ingresar tipo de incidencia");
        ifti.datecFecha.setCalendar(cal);
    }
    
    public static void LimpiarEntradas(InterFrameTipoIncidencia ifti){
        ifti.txtNombre.setText("");
        ifti.cbxCategoria.setSelectedIndex(0);
        ifti.datecFecha.setCalendar(cal);
        ifti.txaDescripcion.setText("");
    }
    
    public static TipoIncidencia LeerDatos(InterFrameTipoIncidencia ifti){
        TipoIncidencia ti = new TipoIncidencia();
        
        ti.setNombreTipoInci(ifti.txtNombre.getText());
        ti.setCategoria(ifti.cbxCategoria.getSelectedItem().toString());
        ti.setFechaRegistro(ifti.datecFecha.getDate());
        ti.setDescripcion(ifti.txaDescripcion.getText());
        
        return ti;
     }
    
    public static void CargarCombos(InterFrameTipoIncidencia ifti){
        ifti.cbxCategoria.addItem("Software");
        ifti.cbxCategoria.addItem("Redes");
        ifti.cbxCategoria.addItem("Hardware");
        ifti.cbxCategoria.addItem("Seguridad");
    }
}
