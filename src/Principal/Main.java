package Principal;

import Vista.*;
import Controlador.*;

public class Main {
    
    //frm de los manteniemientos
    public static FrmLogin frmLogin;
    public static FrmMenu frmMenu;
    public static InterFrameSeguimientoIncidencia f66;
    public static InterFrameGestionarAreas f22;
    public static InterFrameGestionarDetalleSolucion f55;
    public static InterFrameGestionarEmpleados f11;
    public static InterFrameGestionarIncidencias f44;
    public static InterFrameGestionarTipoIncidencia f33;
    public static InterFrameExportarIncidencia f77;
    
    //controlador de los mantenimientos
    public static ControladorLogin controlFrmLogin;
    public static ControladorMenu controlFrmMenu;
    public static ControladorSeguimiento controlF66;
    public static ControladorGestorAreas controlF22;
    public static ControladorGestorDetalleSolucion controlF55;
    public static ControladorFrmGestorEmpleados controlF11;
    public static ControladorGestorIncidencia controlF44;
    public static ControladorGestorTipoIncidencia controlF33;
    public static ControladorExportarPDF controlF77;
    
    
    public static void main(String[] args) {
        frmLogin = new FrmLogin();
        controlFrmLogin = new ControladorLogin();
        frmLogin.setVisible(true);
        frmLogin.setLocationRelativeTo(null);
        frmLogin.setTitle("login - GESTOR DE INCIDENCIAS");
    }
    
}
