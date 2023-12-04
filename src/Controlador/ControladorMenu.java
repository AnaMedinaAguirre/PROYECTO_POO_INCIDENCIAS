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
        vista.MenuItemTiposIncidencias.addActionListener(this);
        vista.MenuItemRegistroAreas.addActionListener(this);
        vista.MenuItemNuevaIncidencia.addActionListener(this);
        vista.MenuItemGestionarAreas.addActionListener(this);
        vista.MenuItemGestionarEmpleados.addActionListener(this);
        vista.MenuItemGestionarTipos.addActionListener(this);
        vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fm.setDefaultCloseOperation(fm.EXIT_ON_CLOSE);
        fm.setLocationRelativeTo(null);
        fm.setVisible(true);
        fm.setTitle("GESTOR DE INCIDENCIAS");
        
        fm.setIconImage(getIconImage());
    }
    
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage
        (ClassLoader.getSystemResource("Img/MediCare2.png"));
        return retValue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.MenuItemNuevoEmpleado){
            Main.ifne = new InterFrameNuevoEmpleado();
            Main.controlFrmEmpleados = new ControladorFrmEmpleados(Main.ifne);
            vista.Escritorio.add(Main.ifne);
        }
        
        if (e.getSource() == vista.MenuItemTiposIncidencias) {
            Main.ifti = new InterFrameTipoIncidencia();
            Main.controlFrmTipoIncidencia = new ControladorFrmTipoIncidencia(Main.ifti);
            vista.Escritorio.add(Main.ifti);
        }
        
        if (e.getSource() == vista.MenuItemRegistroAreas) {
            Main.ifra = new InterFrameRegistroAreas();
            Main.controlFrmArea = new ControladorFrmArea(Main.ifra);
            vista.Escritorio.add(Main.ifra);
        }
        
        if (e.getSource() == vista.MenuItemNuevaIncidencia) {
            Main.ifni = new InterFrameNuevaIncidencia();
            Main.controlFrmIncidencias = new ControladorFrmIncidencias(Main.ifni);
            vista.Escritorio.add(Main.ifni);
        }
        
        if (e.getSource() == vista.MenuItemGestionarAreas) {
            Main.ifga = new InterFrameGestionarAreas();
            Main.controlFrmGestionarArea = new ControladorFrmGestionarArea(Main.ifga);
            vista.Escritorio.add(Main.ifga);
        }
        
        if (e.getSource() == vista.MenuItemGestionarEmpleados) {
            Main.ifge = new InterFrameGestionarEmpleados();
            Main.controlFrmGestionarEmpleados = new ControladorFrmGestionarEmpleados(Main.ifge);
            vista.Escritorio.add(Main.ifge);
        }
        
        if (e.getSource() == vista.MenuItemGestionarTipos) {
            Main.ifgti = new InterFrameGestionarTipoIncidencia();
            Main.controlFrmGestionarTipoIncidencia = new ControladorFrmGestionarTipoIncidencia(Main.ifgti);
            vista.Escritorio.add(Main.ifgti);
        }
    }
}
