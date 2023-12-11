package Modelo;

import java.util.Date;

public class DetalleSolucion {

    //atributos
    private int idDetSolucion;
    private int idIncidencia;
    private String observacion;
    private String estado;
    private Date fechaModificacion;
    private String indicador;

    private String nombreIncidencia;

    //constructor
    public DetalleSolucion() {
    }

    public DetalleSolucion(int aInt, int aInt0, String string, String string0, java.sql.Date date, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //getter and setter
    public int getIdDetSolucion() {
        return idDetSolucion;
    }

    public void setIdDetSolucion(int idDetSolucion) {
        this.idDetSolucion = idDetSolucion;
    }

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public String getNombreIncidencia() {
        return nombreIncidencia;
    }

    public void setNombreIncidencia(String nombreIncidencia) {
        this.nombreIncidencia = nombreIncidencia;
    }

    //registrar detalle solución
    public Object[] RegistrarDetalleSolucion() {
        Object[] row = {
            idDetSolucion, idIncidencia, observacion, estado, fechaModificacion, indicador
        };
        return row;
    }
}
