package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import DAO.*;
import Procesos.*;

public class ControladorFrmTipoIncidencia implements ActionListener{

    InterFrameTipoIncidencia vista;
    DAO_TipoIncidencia crud;
    TipoIncidencia ti;
    
    public ControladorFrmTipoIncidencia(InterFrameTipoIncidencia f2){
        vista = f2;
        vista.btnGuardar.addActionListener(this);
        Procesos.ProcesosFrmTipoIncidencia.PresentacionTipoIncidencia(vista);
        ProcesosFrmTipoIncidencia.CargarCombos(vista);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnGuardar){
            ti = ProcesosFrmTipoIncidencia.LeerDatos(vista);
            crud = new DAO_TipoIncidencia();
            crud.insertarTipoIncidencia(ti);
        }
        
    }
    
}
