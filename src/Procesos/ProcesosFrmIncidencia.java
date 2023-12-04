package Procesos;

import Modelo.*;
import Vista.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import DAO.*;

public class ProcesosFrmIncidencia {
    
    DAO_Empleado crud1 = new DAO_Empleado();
    DAO_TipoIncidencia crud2 = new DAO_TipoIncidencia();
    DAO_Area crud3 = new DAO_Area();
    public static Calendar cal = new GregorianCalendar();
    
    public static void PresentacionNuevaIncidencia(InterFrameNuevaIncidencia ifni){
        ifni.setVisible(true);
        ifni.setTitle("Ingresar nueva incidencia");
        ifni.datecFecha.setCalendar(cal);
    }
    
    public static void LimpiarEntradas(InterFrameNuevaIncidencia ifni){
        ifni.txtNombre.setText("");
        ifni.cbxAsignadoX.setSelectedIndex(0);
        ifni.cbxAsignadoA.setSelectedIndex(0);
        ifni.cbxPrioridad.setSelectedIndex(0);
        ifni.cbxTipo.setSelectedIndex(0);
        ifni.cbxArea.setSelectedIndex(0);
        ifni.datecFecha.setCalendar(cal);
        ifni.txaDescripcion.setText("");
    }
    
    public Incidencia LeerDatos(InterFrameNuevaIncidencia ifni){
        Incidencia i = new Incidencia();
        
        i.setNombreIncidencia(ifni.txtNombre.getText());
        i.setPrioridad(ifni.cbxPrioridad.getSelectedItem().toString());
      
        
        //EMPLEADO
        //asignadoX
        String nombreEmpleado1Seleccionado = ifni.cbxAsignadoX.getSelectedItem().toString();
        int idEmpleado = crud1.obtenerIdEmpleadoPorNombre(nombreEmpleado1Seleccionado);
        i.setAsignadox(idEmpleado);
        
        //asignadoA
        String nombreEmpleado2Seleccionado = ifni.cbxAsignadoA.getSelectedItem().toString();
        int idEmpleado2 = crud1.obtenerIdEmpleadoPorNombre(nombreEmpleado2Seleccionado);
        i.setAsignadoa(idEmpleado2);
        
        
        //TIPO INCIDENCIA
        String nombreTipoIncidenciaSeleccionada = ifni.cbxTipo.getSelectedItem().toString();
        int idTipoInci = crud2.obtenerIdTipoIncidenciaPorNombre(nombreTipoIncidenciaSeleccionada);
        i.setIdTipoInci(idTipoInci);
        
        //ÁREA
        String nombreAreaSeleccionada = ifni.cbxArea.getSelectedItem().toString();
        int idArea = crud3.obtenerIdAreaPorNombre(nombreAreaSeleccionada);
        i.setIdArea(idArea);

        i.setFechaRegistro(ifni.datecFecha.getDate());
        i.setDescripcion(ifni.txaDescripcion.getText());
        
        return i;
    }
    
    public static void CargarCombos(InterFrameNuevaIncidencia ifni){
        ifni.cbxPrioridad.addItem("Alta");
        ifni.cbxPrioridad.addItem("Media");
        ifni.cbxPrioridad.addItem("Baja");
    }
    
}
