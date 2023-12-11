package Principal;

import Vista.*;
import Controlador.*;

public class Main {
    
    public static FrmLogin frmLogin;
    public static FrmMenu frmMenu;
    public static InterFrameNuevoEmpleado ifne;
    public static InterFrameTipoIncidencia ifti;
    public static InterFrameRegistroAreas ifra;
    public static InterFrameNuevaIncidencia ifni;
    public static InterFrameNuevoDetallesSolucion ifnds;
    public static InterFrameGestionarAreas ifga;
    public static InterFrameGestionarEmpleados ifge;
    public static InterFrameGestionarTipoIncidencia ifgti;
    public static InterFrameGestionarIncidencias ifgi;
    public static InterFrameGestionarDetalleSolucion ifgds;
    public static InterFrameSeguimientoIncidencia ifsi;
    
    public static ControladorLogin controlFrmLogin;
    public static ControladorMenu controlFrmMenu;
    public static ControladorFrmEmpleados controlFrmEmpleados;
    public static ControladorFrmTipoIncidencia controlFrmTipoIncidencia;
    public static ControladorFrmArea controlFrmArea;
    public static ControladorFrmIncidencias controlFrmIncidencias;
    public static ControladorFrmDetalleSolucion controlFrmDetalleSolucion;
    public static ControladorFrmGestionarArea controlFrmGestionarArea;
    public static ControladorFrmGestionarEmpleados controlFrmGestionarEmpleados;
    public static ControladorFrmGestionarTipoIncidencia controlFrmGestionarTipoIncidencia;
    public static ControladorFrmGestionarIncidencias controlFrmGestionarIncidencias;
    public static ControladorFrmGestionarDetalleSolucion controlFrmGestionarDetalleSolucion;
    public static ControladorFrmSeguimientoIncidencia controlFrmSeguimientoIncidencia;
    
    
    public static void main(String[] args) {
        frmLogin = new FrmLogin();
        controlFrmLogin = new ControladorLogin(frmLogin);
    }
    
}
