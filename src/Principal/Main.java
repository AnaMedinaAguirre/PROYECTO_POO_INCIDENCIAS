package Principal;

import Vista.*;
import Controlador.*;

public class Main {
    
    public static FrmLogin frmLogin;
    public static FrmMenu frmMenu;
    public static InterFrameNuevoEmpleado ifne;
    public static InterFrameTipoIncidencia ifti;
    public static InterFrameRegistroAreas ifra;
    
    public static ControladorLogin controlFrmLogin;
    public static ControladorMenu controlFrmMenu;
    public static ControladorFrmEmpleados controlFrmEmpleados;
    public static ControladorFrmTipoIncidencia controlFrmTipoIncidencia;
    public static ControladorFrmArea controlFrmArea;
    
    
    public static void main(String[] args) {
        frmMenu = new FrmMenu();
        controlFrmMenu = new ControladorMenu(frmMenu);
        
        //frmLogin = new FrmLogin();
        //controlFrmLogin = new ControladorLogin(frmLogin);
        
    }
    
}
