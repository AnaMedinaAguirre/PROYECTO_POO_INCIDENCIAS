package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import Modelo.*;
import Vista.*;
//import Procesos.*;
import DAO.*;

public class ControladorFrmEmpleados implements ActionListener{

    InterFrameNuevoEmpleado vista;
    
    public ControladorFrmEmpleados(InterFrameNuevoEmpleado f1){
        vista = f1;
        vista.jbtnGuardar.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.jbtnGuardar){
           
       } 
    }
    
}
