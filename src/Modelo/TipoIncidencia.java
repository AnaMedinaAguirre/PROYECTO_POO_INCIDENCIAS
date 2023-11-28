package Modelo;

import java.util.Date;

public class TipoIncidencia {
    
    //atributos
    private int idTipoInci;
    private String nombreTipoInci;
    private String categoria;
    private Date fechaRegistro;
    private String descripcion;
    private String indicador;
    
    //constructor
    public TipoIncidencia(){}
    
    //getter and setter

    public int getIdTipoInci() {return idTipoInci;}
    public void setIdTipoInci(int idTipoInci) {this.idTipoInci = idTipoInci;}

    public String getNombreTipoInci() {return nombreTipoInci;}
    public void setNombreTipoInci(String nombreTipoInci) {this.nombreTipoInci = nombreTipoInci;}

    public String getCategoria() {return categoria;}
    public void setCategoria(String categoria) {this.categoria = categoria;}

    public Date getFechaRegistro() {return fechaRegistro;}
    public void setFechaRegistro(Date fechaRegistro) {this.fechaRegistro = fechaRegistro;}

    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public String getIndicador() {return indicador;}
    public void setIndicador(String indicador) {this.indicador = indicador;}
    
    //registrar Tipod de incidencia
    public Object[] RegistrarTipoIncidencia(int numeracion){
        Object[] row = {
            numeracion, idTipoInci, nombreTipoInci, categoria, fechaRegistro, descripcion
        };
        return row;
    }
}