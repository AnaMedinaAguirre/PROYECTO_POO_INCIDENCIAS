package DAO;

import Formatos.*;
import Modelo.*;

public class DAO_Login extends ConectarDB {

    public DAO_Login() {
    }

    // Método para verificar las credenciales de inicio de sesión
    public boolean verificarCredenciales(Empleado objeto) {
        boolean respuesta = false;
        try {
            String query = "SELECT usuario, contraseña FROM tb_empleado WHERE usuario = ? AND contraseña = ?";
            ps = conexion.prepareStatement(query);

            ps.setString(1, objeto.getUsuario());
            ps.setString(2, objeto.getContraseña());

            rs = ps.executeQuery();

            if (rs.next()) {
                respuesta = true; // Si encuentra el usuario con las credenciales proporcionadas
            }
        } catch (Exception e) {
            Mensajes.M1("Error en el inicio de sesión: " + e);
        } finally {
            // Cerrar recursos si es necesario
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex) {
                Mensajes.M1("Error al cerrar recursos: " + ex);
            }
        }
        return respuesta;
    }

}
