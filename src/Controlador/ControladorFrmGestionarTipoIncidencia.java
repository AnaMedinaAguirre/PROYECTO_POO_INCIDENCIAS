package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import DAO.*;
import Procesos.*;
import Formatos.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ControladorFrmGestionarTipoIncidencia implements ActionListener{

    InterFrameGestionarTipoIncidencia vista;
    DAO_MantenimientoTipoIncidencia crud;
    TipoIncidencia tipoInci;
    
    
    public ControladorFrmGestionarTipoIncidencia(InterFrameGestionarTipoIncidencia ifgti){
        vista = ifgti;
        vista.btnActualizar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        ProcesosFrmGestionarTipoIncidencia.Presentacion(ifgti);
        crud = new DAO_MantenimientoTipoIncidencia(vista);
        crud.cargarCategorias();
        crud.configurarMouseListener();
        crud.EnviarDatosTipoInciSeleccionada(0);
        ActualizarForma();
        addTextChangedListeners();
    }
    
    public void ActualizarForma(){
        crud = new DAO_MantenimientoTipoIncidencia(vista);
        crud.MostrarTipoIncidencia(vista.tblTipoIncidencias);
        ProcesosFrmGestionarTipoIncidencia.Estado1(vista);
        ProcesosFrmGestionarTipoIncidencia.LimpiarEntradas(vista);
    }
    
    private void addTextChangedListeners() {
        vista.txtNombre.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                enableUpdateButton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                enableUpdateButton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                enableUpdateButton();
            }
        });

        vista.cbxCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableUpdateButton();
            }
        });

        vista.txaDescripcion.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                enableUpdateButton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                enableUpdateButton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                enableUpdateButton();
            }
        });

        vista.datecFecha.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    enableUpdateButton();
                }
            }
        });
    }

    private void enableUpdateButton() {
        vista.btnActualizar.setEnabled(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnActualizar){
            tipoInci = ProcesosFrmGestionarTipoIncidencia.LeerDatos(vista);
            tipoInci.setIdTipoInci(Integer.parseInt(vista.txtIDTipoInci.getText()));
            crud = new DAO_MantenimientoTipoIncidencia(vista);
            crud.ActualizarTipoIncidencia(tipoInci);
            ActualizarForma();
        }
        
        if (e.getSource() == vista.btnEliminar) {
            int respuesta = Mensajes.M3("¡CONFIRMAR!", "¿Desea eliminar el registro?");
            if (respuesta == 0) {
                int idcat = Integer.parseInt(vista.txtIDTipoInci.getText());
                crud = new DAO_MantenimientoTipoIncidencia(vista);
                crud.EliminarTipoIncidencia(idcat);
                ActualizarForma();
            }
        }
    }
    
}
