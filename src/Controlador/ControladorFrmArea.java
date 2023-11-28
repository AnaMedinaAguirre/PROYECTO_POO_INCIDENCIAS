package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import DAO.*;
import Procesos.*;

public class ControladorFrmArea implements ActionListener{

    InterFrameRegistroAreas vista;
    DAO_Area crud;
    Area a;
    
    public ControladorFrmArea(InterFrameRegistroAreas f3){
        vista = f3;
        vista.btnGuardar.addActionListener(this);
        ProcesosFrmAreas.Presentacion(vista);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            a = ProcesosFrmAreas.LeerDatos(vista);
            crud = new DAO_Area();
            crud.insertarAreas(a);
            ProcesosFrmAreas.LimpiarEntradas(vista);
        }
        
    }
}
