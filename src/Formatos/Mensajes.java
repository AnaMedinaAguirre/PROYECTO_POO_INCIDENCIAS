package Formatos;

//liberia
import javax.swing.JOptionPane;

public class Mensajes {

    public static void M1(String mensaje) {
        JOptionPane.showInputDialog(null, mensaje);
    }

    public static int M2(String mensaje) {
        return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
    }

    //si el usuario ingresa OK representa el valor de 0
    public static int M3(String titulo, String mensaje) {
        return JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.OK_CANCEL_OPTION);
    }
}
