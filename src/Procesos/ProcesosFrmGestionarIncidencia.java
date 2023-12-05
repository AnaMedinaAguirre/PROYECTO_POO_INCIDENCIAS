package Procesos;

import Vista.*;
import Modelo.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import DAO.*;

public class ProcesosFrmGestionarIncidencia {
    public static Calendar cal = new GregorianCalendar();
    DAO_Empleado crud1 = new DAO_Empleado();
    DAO_TipoIncidencia crud2 = new DAO_TipoIncidencia();
    DAO_Area crud3 = new DAO_Area();
    
    public static void Presentacion(InterFrameGestionarIncidencias frgi){
        frgi.setVisible(true);
        frgi.setTitle("Gestionar Incidencias");
        frgi.datecFecha.setCalendar(cal);
        frgi.txtIDIncidencia.setEnabled(false);
    }
    
    public static void Estado1(InterFrameGestionarIncidencias frgi){
        frgi.btnActualizar.setEnabled(false);
        frgi.btnEliminar.setEnabled(true);  
    }
    
    public static void LimpiarEntradas(InterFrameGestionarIncidencias frgi){
        frgi.txtNombre.setText("");
        frgi.cbxAsignadoX.setSelectedIndex(0);
        frgi.cbxAsignadoA.setSelectedIndex(0);
        frgi.cbxPrioridad.setSelectedIndex(0);
        frgi.cbxTipo.setSelectedIndex(0);
        frgi.cbxArea.setSelectedIndex(0);
        frgi.datecFecha.setCalendar(cal);  
        frgi.txaDescripcion.setText("");
    }
    
    public static Incidencia LeerDatos(InterFrameGestionarIncidencias frgi, DAO_Empleado crud1, DAO_TipoIncidencia crud2, DAO_Area crud3){
        Incidencia i = new Incidencia();
        i.setNombreIncidencia(frgi.txtNombre.getText());
        
        String empleadoSeleccionado1 = frgi.cbxAsignadoX.getSelectedItem().toString();
        int empleado1Id = crud1.obtenerIdEmpleadoPorNombre(empleadoSeleccionado1);
        i.setAsignadox(empleado1Id);
        
        String empleadoSeleccionado2 = frgi.cbxAsignadoA.getSelectedItem().toString();
        int empleado2Id = crud1.obtenerIdEmpleadoPorNombre(empleadoSeleccionado2);
        i.setAsignadoa(empleado2Id);
        
        i.setPrioridad(frgi.cbxPrioridad.getSelectedItem().toString());
        
        String TipoIncidenciaSeleccionada = frgi.cbxTipo.getSelectedItem().toString();
        int TipoInciId = crud2.obtenerIdTipoIncidenciaPorNombre(TipoIncidenciaSeleccionada);
        i.setIdTipoInci(TipoInciId);
        
        String areaSeleccionada = frgi.cbxArea.getSelectedItem().toString();
        int areaId = crud3.obtenerIdAreaPorNombre(areaSeleccionada);
        i.setIdArea(areaId);
        
        i.setFechaRegistro(frgi.datecFecha.getDate());
        i.setDescripcion(frgi.txaDescripcion.getText());
        return i;
    }
}
