package Procesos;

import Vista.*;
import Modelo.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import DAO.*;

public class ProcesosFrmGestionarEmpleado {
    public static Calendar cal = new GregorianCalendar();
    DAO_Area crud = new DAO_Area();
    public static void Presentacion(InterFrameGestionarEmpleados frge){
        frge.setVisible(true);
        frge.setTitle("Gestionar Áreas");
        frge.datecFechaEmpleado.setCalendar(cal);
        frge.txtIDEmpleado.setEnabled(false);
    }
    
    public static void Estado1(InterFrameGestionarEmpleados frge){
        frge.btnActualizar.setEnabled(false);
        frge.btnEliminar.setEnabled(true);  
    }
    
    public static void LimpiarEntradas(InterFrameGestionarEmpleados frge){
        frge.txtNombreEmpleado.setText("");
        frge.txtApellidoEmpleado.setText("");
        frge.cbxGeneroEmpleado.setSelectedIndex(0);
        frge.datecFechaEmpleado.setCalendar(cal);   
        frge.txtCargoEmpleado.setText("");
        frge.cbxAreaEmpleado.setSelectedIndex(0);
        frge.txtSueldoEmpleado.setText("");
        frge.txtTelefonoEmpleado.setText(""); 
        frge.txtUsuarioEmpleado.setText(""); 
        frge.txtContraseñaEmpleado.setText(""); 
    }
    
    public Empleado LeerDatos(InterFrameGestionarEmpleados frge){
        Empleado emp = new Empleado();
        emp.setNombreEmpleado(frge.txtNombreEmpleado.getText());
        emp.setApellidoEmpleado(frge.txtApellidoEmpleado.getText());
        emp.setGenero(frge.cbxGeneroEmpleado.getSelectedItem().toString());
        emp.setTelefono(frge.txtTelefonoEmpleado.getText());
        emp.setCargo(frge.txtCargoEmpleado.getText());
        String nombreAreaSeleccionada = frge.cbxAreaEmpleado.getSelectedItem().toString();
        int idArea = crud.obtenerIdAreaPorNombre(nombreAreaSeleccionada);
        emp.setArea(idArea);
        emp.setFechaRegistro(frge.datecFechaEmpleado.getDate());
        emp.setSueldo(Double.parseDouble(frge.txtSueldoEmpleado.getText()));
        emp.setUsuario(frge.txtUsuarioEmpleado.getText());
        emp.setContraseña(frge.txtContraseñaEmpleado.getText());
        return emp;
    }
}
