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
        fm.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
            CentrarForma.CPanel(vista.Escritorio, Main.ifne);
        }
        
        if (e.getSource() == vista.MenuItemTiposIncidencias) {
            Main.ifti = new InterFrameTipoIncidencia();
            Main.controlFrmTipoIncidencia = new ControladorFrmTipoIncidencia(Main.ifti);
            vista.Escritorio.add(Main.ifti);
            CentrarForma.CPanel(vista.Escritorio, Main.ifti);
        }
        
        if (e.getSource() == vista.MenuItemRegistroAreas) {
            Main.ifra = new InterFrameRegistroAreas();
            Main.controlFrmArea = new ControladorFrmArea(Main.ifra);
            vista.Escritorio.add(Main.ifra);
            CentrarForma.CPanel(vista.Escritorio, Main.ifra);
        }
    }
}
