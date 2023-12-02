package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import DAO.*;
import Principal.Main;
import Procesos.*;

public class ControladorFrmGestionarEmpleados implements ActionListener{
    InterFrameGestionarEmpleados vista;
    DAO_MantenimientoEmpleados crud;
    Empleado emp;
    ProcesosFrmGestionarEmpleado procesos;
    
    public ControladorFrmGestionarEmpleados(InterFrameGestionarEmpleados f4){
        vista = f4;
        crud = new DAO_MantenimientoEmpleados(vista); // Pasar la referencia de la vista al DAO
        vista.btnActualizar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        ProcesosFrmGestionarEmpleado.Presentacion(vista);
        crud.CargarComboArea();
        crud.CargarTablaEmpleado();
        procesos = new ProcesosFrmGestionarEmpleado();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
