package Modelo;

import java.util.Date;

public class Empleado {
    //atributos
    private int idEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String genero;
    private String telefono;
    private String cargo;
    private int area;			
    private Date fechaRegistro;
    private double sueldo;
    private String usuario;
    private String contraseña;
    private String indicador;
    private String nombreArea;
    
    //constructor
    public Empleado(){}
    
    //getter and setter

    public int getIdEmpleado() {return idEmpleado;}
    public void setIdEmpleado(int idEmpleado) {this.idEmpleado = idEmpleado;}

    public String getNombreEmpleado() {return nombreEmpleado;}
    public void setNombreEmpleado(String nombreEmpleado) {this.nombreEmpleado = nombreEmpleado;}

    public String getApellidoEmpleado() {return apellidoEmpleado;}
    public void setApellidoEmpleado(String apellidoEmpleado) {this.apellidoEmpleado = apellidoEmpleado;}

    public String getGenero() {return genero;}
    public void setGenero(String genero) {this.genero = genero;}

    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}

    public String getCargo() {return cargo;}
    public void setCargo(String cargo) {this.cargo = cargo;}

    public int getArea() {return area;}
    public void setArea(int area) {this.area = area;}

    public Date getFechaRegistro() {return fechaRegistro;}
    public void setFechaRegistro(Date fechaRegistro) {this.fechaRegistro = fechaRegistro;}

    public double getSueldo() {return sueldo;}
    public void setSueldo(double sueldo) {this.sueldo = sueldo;}

    public String getUsuario() {return usuario;}
    public void setUsuario(String usuario) {this.usuario = usuario;}

    public String getContraseña() {return contraseña;}
    public void setContraseña(String contraseña) {this.contraseña = contraseña;}

    public String getIndicador() {return indicador;}
    public void setIndicador(String indicador) {this.indicador = indicador;}

    public String getNombreArea() {return nombreArea;}
    public void setNombreArea(String nombreArea) {this.nombreArea = nombreArea;}
    
    
    //registrar Empleado
    public Object[] RegistarEmpleado(){
        Object[] row = {
            idEmpleado, nombreEmpleado, apellidoEmpleado, genero, telefono,
            cargo, area, fechaRegistro, sueldo, usuario, contraseña
            };
        return row;
    }
}