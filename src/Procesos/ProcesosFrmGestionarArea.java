package Procesos;

import Vista.*;
import Modelo.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ProcesosFrmGestionarArea {
    
    public static Calendar cal = new GregorianCalendar();
    
    public static void Presentacion(InterFrameGestionarAreas frmg){
        frmg.setVisible(true);
        frmg.setTitle("Gestionar Áreas");
        frmg.datecFechaArea.setCalendar(cal);
        frmg.txtIDArea.setEnabled(false);
    }
    
    public static void Estado1(InterFrameGestionarAreas frmg){
        frmg.btnActualizar.setEnabled(false);
        frmg.btnEliminar.setEnabled(true);  
    }
    
    public static void LimpiarEntradas(InterFrameGestionarAreas frma){
        frma.txtNombreArea.setText("");
        frma.txtResponsableArea.setText("");
        frma.txtUbicacionArea.setText("");
        frma.datecFechaArea.setCalendar(cal);   
        frma.txaDescripcionArea.setText("");    
    }
    
    public static Area LeerDatos(InterFrameGestionarAreas frma){
        Area a=new Area();
        a.setNombreArea(frma.txtNombreArea.getText());
        a.setResponsable(frma.txtResponsableArea.getText());
        a.setUbicacion(frma.txtUbicacionArea.getText());
        a.setFechaRegistro(frma.datecFechaArea.getDate());
        a.setDescripcion(frma.txaDescripcionArea.getText());
        return a;
    }
}
