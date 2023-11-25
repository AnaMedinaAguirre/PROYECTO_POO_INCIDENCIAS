package Controlador;

//librerias
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.*;
import Formatos.*;
import Principal.*;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Toolkit;

public class ControladorMenu implements ActionListener {

    FrmMenu vista;

    public ControladorMenu(FrmMenu fm) {
        vista = fm;
        vista.MenuItemNuevoEmpleado.addActionListener(this);
        vista.MenuItemGestionarEmpleados.addActionListener(this);
        vista.MenuItemTiposIncidencias.addActionListener(this);
        vista.MenuItemGestionarTipos.addActionListener(this);
        vista.MenuItemNuevaIncidencia.addActionListener(this);
        vista.MenuItemGestionarIncidencias.addActionListener(this);
        vista.MenuItemNuevoDetalleSolucion.addActionListener(this);
        vista.MenuItemGestionarDetalleSolucion.addActionListener(this);
        vista.MenuItemSeguimiento.addActionListener(this);
        vista.MenuItemRegistroAreas.addActionListener(this);
        vista.MenuItemGestionarAreas.addActionListener(this);
        vista.MenuItemExportarPDF.addActionListener(this);

        fm.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fm.setDefaultCloseOperation(fm.EXIT_ON_CLOSE);
        fm.setVisible(true);
        fm.setTitle("GESTOR DE INCIDENCIAS");
        fm.setIconImage(getIconImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //empleado
        if(e.getSource()== vista.MenuItemNuevoEmpleado){
          InterFrameNuevoEmpleado f1 = new InterFrameNuevoEmpleado();
          ControladorFrmEmpleados controlf1 = new ControladorFrmEmpleados(f1);
          vista.Escritorio.add(f1);
          CentrarForma.CPanel(vista.Escritorio,f1);
        }
        
        if(e.getSource()== vista.MenuItemGestionarEmpleados){
          Main.f11 = new InterFrameGestionarEmpleados();
          //Main.controlF11 = new ControladorFrmGestorEmpleados(Main.f11);
          vista.Escritorio.add(Main.f11);
          CentrarForma.CPanel(vista.Escritorio,Main.f11);
        }
        
        //Areas
        if(e.getSource()== vista.MenuItemRegistroAreas){
          InterFrameRegistroAreas f2 = new InterFrameRegistroAreas();
          //ControladorAreas controlf2 = new ControladorAreas(f2);
          vista.Escritorio.add(f2);
          CentrarForma.CPanel(vista.Escritorio,f2);
        }
        
        if(e.getSource()== vista.MenuItemGestionarAreas){
          Main.f22 = new InterFrameGestionarAreas();
          //Main.controlF22 = new ControladorGestorAreas(Main.f22);
          vista.Escritorio.add(Main.f22);
          CentrarForma.CPanel(vista.Escritorio,Main.f22);
        }
        
        //Tipo Incidencia
        if(e.getSource()== vista.MenuItemTiposIncidencias){
          InterFrameTipoIncidencia f3 = new InterFrameTipoIncidencia();
          //ControladorTipoIncidencia controlf3 = new ControladorTipoIncidencia(f3);
          vista.Escritorio.add(f3);
          CentrarForma.CPanel(vista.Escritorio,f3);
        }
        
        if(e.getSource()== vista.MenuItemGestionarTipos){
          Main.f33 = new InterFrameGestionarTipoIncidencia();
          //Main.controlF33 = new ControladorGestorTipoIncidencia(Main.f33);
          vista.Escritorio.add(Main.f33);
          CentrarForma.CPanel(vista.Escritorio,Main.f33);
        }
    }
    
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Img/MediCare2.png"));
        return retValue;
    }

}
