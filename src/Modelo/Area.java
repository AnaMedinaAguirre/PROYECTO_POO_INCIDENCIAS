package Modelo;

import java.util.Date;

public class Area {
    //atributos
    private int idArea;
    private String nombreArea;
    private String responsable;
    private String ubicacion;
    private Date fechaRegistro;
    private String descripcion;
    private String indicador;
    
    //constructor
    public Area() {}
    
    //getter and setter

    public int getIdArea() {return idArea;}
    public void setIdArea(int idArea) {this.idArea = idArea;}

    public String getNombreArea() {return nombreArea;}
    public void setNombreArea(String nombreArea) {this.nombreArea = nombreArea;}

    public String getResponsable() {return responsable;}
    public void setResponsable(String responsable) {this.responsable = responsable;}

    public String getUbicacion() {return ubicacion;}
    public void setUbicacion(String ubicacion) {this.ubicacion = ubicacion;}

    public Date getFechaRegistro() {return fechaRegistro;}
    public void setFechaRegistro(Date fechaRegistro) {this.fechaRegistro = fechaRegistro;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public String getIndicador() {return indicador;}
    public void setIndicador(String indicador) {this.indicador = indicador;}
    
    //registrar Area
    public Object[] RegistroArea(int numeracion){
        Object[] row = {
            numeracion, idArea, nombreArea, responsable, ubicacion, fechaRegistro,
            descripcion
        };
        return row;
    }
    
}
