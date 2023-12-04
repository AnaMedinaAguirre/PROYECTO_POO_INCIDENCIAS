package Modelo;

import java.util.Date;

public class Incidencia {
    
    //atributos
    private int idIncidencia;
    private String nombreIncidencia;
    private int asignadox;
    private int asignadoa;
    private String prioridad;
    private int idTipoInci;
    private int idArea;
    private Date fechaRegistro;
    private String descripcion;
    private String indicador;
    
    private String nombreAsignadoX;
    private String nombreAsignadoA;
    private String nombreTipoIncidencia;
    private String nombreArea;
    
    //constructor
    public Incidencia(){}
    
    //getter and setter
    public int getIdIncidencia() {return idIncidencia;}
    public void setIdIncidencia(int idIncidencia) {this.idIncidencia = idIncidencia;}

    public String getNombreIncidencia() {return nombreIncidencia;}
    public void setNombreIncidencia(String nombreIncidencia) {this.nombreIncidencia = nombreIncidencia;}

    public int getAsignadox() {return asignadox;}
    public void setAsignadox(int asignadox) {this.asignadox = asignadox;}

    public int getAsignadoa() {return asignadoa;}
    public void setAsignadoa(int asignadoa) {this.asignadoa = asignadoa;}

    public String getPrioridad() {return prioridad;}
    public void setPrioridad(String prioridad) {this.prioridad = prioridad;}

    public int getIdTipoInci() {return idTipoInci;}
    public void setIdTipoInci(int idTipoInci) {this.idTipoInci = idTipoInci;}

    public int getIdArea() {return idArea;}
    public void setIdArea(int idArea) {this.idArea = idArea;}

    public Date getFechaRegistro() {return fechaRegistro;}
    public void setFechaRegistro(Date fechaRegistro) {this.fechaRegistro = fechaRegistro;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public String getIndicador() {return indicador;}
    public void setIndicador(String indicador) {this.indicador = indicador;}
    
    public String getNombreAsignadoX() {return nombreAsignadoX;}
    public void setNombreAsignadoX(String nombreAsignadoX) {this.nombreAsignadoX = nombreAsignadoX;}

    public String getNombreAsignadoA() {return nombreAsignadoA;}
    public void setNombreAsignadoA(String nombreAsignadoA) {this.nombreAsignadoA = nombreAsignadoA;}

    public String getNombreTipoIncidencia() {return nombreTipoIncidencia;}
    public void setNombreTipoIncidencia(String nombreTipoIncidencia) {this.nombreTipoIncidencia = nombreTipoIncidencia;}

    public String getNombreArea() {return nombreArea;}
    public void setNombreArea(String nombreArea) {this.nombreArea = nombreArea;}
    
    
    //registrar incidencia
    public Object[] RegistrarIncidencia(){
        Object[] row = {
            idIncidencia, nombreIncidencia, asignadox, asignadoa, prioridad, idTipoInci,
            idArea, fechaRegistro, descripcion
        };
        return row;
    }
}
