package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import DAO.*;
import Principal.Main;
import Procesos.*;
import java.util.ArrayList;

public class ControladorFrmEmpleados implements ActionListener{

    InterFrameNuevoEmpleado vista;
    DAO_Empleado crud;
    Empleado emp;
    ProcesosFrmEmpleado procesos;
    
    public ControladorFrmEmpleados(InterFrameNuevoEmpleado f1){
        crud = new DAO_Empleado();
        vista = f1;
        vista.btnGuardar.addActionListener(this);
        Procesos.ProcesosFrmEmpleado.PresentacionNuevoEmpleado(vista);
        cargarAreasEnComboBox();
        procesos = new ProcesosFrmEmpleado();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.btnGuardar) {
            emp = procesos.LeerDatos(vista); // Llama al método de instancia
            crud.insertarEmpleado(emp);
        }
        
    }
    
    public void cargarAreasEnComboBox() {
        ArrayList<String> areas = this.crud.obtenerAreas();
        // Limpia y llena el JComboBox con las áreas obtenidas
        Main.ifne.cbxArea.removeAllItems();
        for (String area : areas) {
            Main.ifne.cbxArea.addItem(area);
        }
    }
}
