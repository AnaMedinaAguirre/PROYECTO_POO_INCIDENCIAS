package Principal;

import Vista.FrmLogin;

public class Main {
    
    public static FrmLogin fl;

    public static void main(String[] args) {
        fl = new FrmLogin();
        fl.setVisible(true);
        fl.setLocationRelativeTo(null);
        fl.setTitle("login - GESTOR DE INCIDENCIAS");
    }
    
}
