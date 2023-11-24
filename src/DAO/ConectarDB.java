package DAO;

import java.sql.*;
import Formatos.*;

public class ConectarDB implements Parametros{
    
    public Connection conexion;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    ResultSetMetaData mdata;
    
    public ConectarDB() {
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(RUTA, USUARIO, CLAVE);
            st = conexion.createStatement();
        } catch (Exception e) {
            Mensajes.M1("ERROR, no se puede conectar a la BD..." + e);
        }
    }
}
