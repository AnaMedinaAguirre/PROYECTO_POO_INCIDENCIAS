package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import DAO.*;
import Principal.Main;
import Procesos.*;
import java.util.ArrayList;

public class ControladorFrmDetalleSolucion implements ActionListener{

    InterFrameNuevoDetallesSolucion vista;
    DAO_DetalleSolucion crud;
    DetalleSolucion ds;
    ProcesosFrmDetalleSolucion procesos;
    
    public ControladorFrmDetalleSolucion(InterFrameNuevoDetallesSolucion f7){
        crud  = new DAO_DetalleSolucion();
        vista = f7;
        vista.btnGuardar.addActionListener(this);
        Procesos.ProcesosFrmDetalleSolucion.PresentacionNuevoDetalleSolucion(vista);
        ProcesosFrmDetalleSolucion.CargarCombos(vista);
        cargarIncidenciasEnComboBox();
        procesos = new ProcesosFrmDetalleSolucion();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnGuardar){
            ds = procesos.LeerDatos(vista);
            crud.insertarDetalleSolucion(ds);
            ProcesosFrmDetalleSolucion.LimpiarEntradas(vista);
        }
    }
    
    //incidencia
    public void cargarIncidenciasEnComboBox() {
        ArrayList<String> Incidencias = this.crud.obtenerIncidencias();
        // Limpia y llena el JComboBox con las incidencias obtenidas
        Main.ifnds.cbxIncidencia.removeAllItems();
        for (String Incidencia : Incidencias) {
            Main.ifnds.cbxIncidencia.addItem(Incidencia);
        }
    }
}
