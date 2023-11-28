package Procesos;
import Vista.*;
import Modelo.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
    public class ProcesosFrmAreas {
        
    public static Calendar cal = new GregorianCalendar();
        
    public static void Presentacion(InterFrameRegistroAreas frm){
        frm.setVisible(true);
        frm.setTitle("Ingresar nueva Area");
        frm.datecFecha.setCalendar(cal);
    }
    public static void Estado1(InterFrameGestionarAreas frm){
        frm.btnActualizar.setEnabled(true);
        frm.btnEliminar.setEnabled(true);  
    }

    public static void LimpiarEntradas(InterFrameRegistroAreas frm){
        frm.txtNombreArea.setText("");
        frm.txtResponsable.setText("");
        frm.txtUbicacion.setText("");
        frm.datecFecha.setCalendar(cal);   
        frm.txaDescripcion.setText("");    
    }
    
    public static Area LeerDatos(InterFrameRegistroAreas frm){
        Area a=new Area();
        a.setNombreArea(frm.txtNombreArea.getText());
        a.setResponsable(frm.txtResponsable.getText());
        a.setUbicacion(frm.txtUbicacion.getText());
        a.setFechaRegistro(frm.datecFecha.getDate());
        a.setDescripcion(frm.txaDescripcion.getText());
        return a;
    }
    
}