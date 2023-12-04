package Procesos;

import Modelo.*;
import Vista.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import DAO.*;

public class ProcesosFrmEmpleado {
    
    DAO_Area crud = new DAO_Area();
    public static Calendar cal = new GregorianCalendar();
    
    public static void PresentacionNuevoEmpleado(InterFrameNuevoEmpleado ifne){
        ifne.setVisible(true);
        ifne.setTitle("Ingresar nuevo empleado");
        ifne.datecFecha.setCalendar(cal);
    }
    
    public static void LimpiarEntradas(InterFrameNuevoEmpleado ifne){
        ifne.txtNombres.setText("");
        ifne.txtApellidos.setText("");
        ifne.cbxGenero.setSelectedIndex(0);
        ifne.txtTelefono.setText("");
        ifne.txtCargo.setText("");
        ifne.cbxArea.setSelectedIndex(0);
        ifne.datecFecha.setCalendar(cal);
        ifne.txtSueldo.setText("");
        ifne.txtUsuario.setText("");  
        ifne.txtContraseña.setText("");
    }
    
    public Empleado LeerDatos(InterFrameNuevoEmpleado ifne){
        Empleado emp = new Empleado();
        
        emp.setNombreEmpleado(ifne.txtNombres.getText());
        emp.setApellidoEmpleado(ifne.txtApellidos.getText());
        emp.setGenero(ifne.cbxGenero.getSelectedItem().toString());
        emp.setTelefono(ifne.txtTelefono.getText());
        emp.setCargo(ifne.txtCargo.getText());
      
        String nombreAreaSeleccionada = ifne.cbxArea.getSelectedItem().toString();
        int idArea = crud.obtenerIdAreaPorNombre(nombreAreaSeleccionada);
        emp.setArea(idArea);

        emp.setFechaRegistro(ifne.datecFecha.getDate());
        emp.setSueldo(Double.parseDouble(ifne.txtSueldo.getText()));
        emp.setUsuario(ifne.txtUsuario.getText());
        emp.setContraseña(ifne.txtContraseña.getText());
        return emp;
     }
}

