package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import DAO.*;
import Principal.Main;
import Procesos.*;
import java.util.ArrayList;

public class ControladorFrmIncidencias implements ActionListener{

    InterFrameNuevaIncidencia vista;
    DAO_Incidencia crud;
    Incidencia i;
    ProcesosFrmIncidencia procesos;
    
    public ControladorFrmIncidencias(InterFrameNuevaIncidencia fi){
        crud  = new DAO_Incidencia();
        vista = fi;
        vista.btnGuardar.addActionListener(this);
        Procesos.ProcesosFrmIncidencia.PresentacionNuevaIncidencia(vista);
        ProcesosFrmIncidencia.CargarCombos(vista);
        cargarEmpleados1EnComboBox();
        cargarEmpleados2EnComboBox();
        cargarTiposIncidenciasEnComboBox();
        cargarAreasEnComboBox();
        procesos = new ProcesosFrmIncidencia();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnGuardar){
            i = procesos.LeerDatos(vista);
            crud.insertarIncidencia(i);
            ProcesosFrmIncidencia.LimpiarEntradas(vista);
        }
    }
    
    //asignadoX
    public void cargarEmpleados1EnComboBox(){
        ArrayList<String> empleados = crud.obtenerEmpleados();
        // Limpia y llena el JComboBox con los empleados obtenidos
        Main.ifni.cbxAsignadoX.removeAllItems();
        for (String empleado : empleados) {
            Main.ifni.cbxAsignadoX.addItem(empleado);
        }
    }
    
    //asignadoA
    public void cargarEmpleados2EnComboBox(){
        ArrayList<String> empleados = this.crud.obtenerEmpleados();
        // Limpia y llena el JComboBox con los empleados obtenidas
        Main.ifni.cbxAsignadoA.removeAllItems();
        for (String empleado : empleados) {
            Main.ifni.cbxAsignadoA.addItem(empleado);
        }
    }
    
    //tipo incidencia
    public void cargarTiposIncidenciasEnComboBox() {
        ArrayList<String> tiposIncidencias = this.crud.obtenerTiposIncidencias();
        // Limpia y llena el JComboBox con los tipos de incidencias obtenidas
        Main.ifni.cbxTipo.removeAllItems();
        for (String tipoIncidencia : tiposIncidencias) {
            Main.ifni.cbxTipo.addItem(tipoIncidencia);
        }
    }

    
    //area
    public void cargarAreasEnComboBox() {
        ArrayList<String> areas = this.crud.obtenerAreas();
        // Limpia y llena el JComboBox con las áreas obtenidas
        Main.ifni.cbxArea.removeAllItems();
        for (String area : areas) {
            Main.ifni.cbxArea.addItem(area);
        }
    }
}
