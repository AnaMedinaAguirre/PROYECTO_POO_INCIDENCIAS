package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Formatos.*;
import Vista.*;
import DAO.*;
import Modelo.Empleado;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Toolkit;

public class ControladorLogin implements ActionListener, KeyListener {

    FrmLogin vista;
    DAO_Login crud;
    
    public ControladorLogin(FrmLogin f1){
        vista = f1;
        crud = new DAO_Login();
        vista.btnIniciarSesion.addActionListener(this);
        vista.txtUsuario.addKeyListener(this);
        vista.txtContraseña.addKeyListener(this);
        vista.setIconImage(getIconImage());
        vista.setLocationRelativeTo(null);
        vista.setTitle("login - GESTOR DE INCIDENCIAS");
        vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.Login();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == vista.txtUsuario && e.getKeyCode() == KeyEvent.VK_ENTER) {
            vista.txtContraseña.requestFocus();
        } else if (e.getSource() == vista.txtContraseña && e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.Login();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource
        ("Img/MediCare2.png"));
        return retValue;
    }
    
    private void Login() {
        if (!vista.txtUsuario.getText().isEmpty() && !vista.txtContraseña.getText().isEmpty()) {
            
            Empleado empleado = new Empleado();
            empleado.setUsuario(vista.txtUsuario.getText().trim());
            empleado.setContraseña(vista.txtContraseña.getText().trim());
            
            if(crud.verificarCredenciales(empleado)){
                FrmMenu menu = new FrmMenu();
                ControladorMenu controladorMenu = new ControladorMenu(menu);
                menu.setVisible(true);
                
                vista.dispose();
            }else{
                Mensajes.M1("Usuario o clave incorrectos. Inténtalo de nuevo.");
            }
            
        } else {
            Mensajes.M1("Por favor ingrese sus credenciales.");
        }
    }

}