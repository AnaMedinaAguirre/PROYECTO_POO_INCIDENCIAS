package Principal;

import Vista.*;
import Controlador.*;
import javax.swing.JFrame;

public class Main {
    
    public static FrmLogin frmLogin;
    public static FrmMenu frmMenu;
    public static InterFrameNuevoEmpleado ifne;
    public static InterFrameTipoIncidencia ifti;
    public static InterFrameRegistroAreas ifra;
    public static InterFrameNuevaIncidencia ifni;
    public static InterFrameGestionarAreas ifga;
    public static InterFrameGestionarEmpleados ifge;
    public static InterFrameGestionarTipoIncidencia ifgti;
    
    public static ControladorLogin controlFrmLogin;
    public static ControladorMenu controlFrmMenu;
    public static ControladorFrmEmpleados controlFrmEmpleados;
    public static ControladorFrmTipoIncidencia controlFrmTipoIncidencia;
    public static ControladorFrmArea controlFrmArea;
    public static ControladorFrmIncidencias controlFrmIncidencias;
    public static ControladorFrmGestionarArea controlFrmGestionarArea;
    public static ControladorFrmGestionarEmpleados controlFrmGestionarEmpleados;
    public static ControladorFrmGestionarTipoIncidencia controlFrmGestionarTipoIncidencia;
    
    
    public static void main(String[] args) {
        //frmLogin = new FrmLogin();
        //controlFrmLogin = new ControladorLogin(frmLogin);
        frmMenu = new FrmMenu();
        controlFrmMenu = new ControladorMenu(frmMenu);
    }
    
}
