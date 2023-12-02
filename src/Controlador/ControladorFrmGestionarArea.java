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

public class ControladorFrmGestionarArea implements ActionListener{

    InterFrameGestionarAreas vista;
    DAO_MantenimientoAreas crud;
    Area area;
    
    public ControladorFrmGestionarArea(InterFrameGestionarAreas ifga){
        vista = ifga;
        vista.btnActualizar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        ProcesosFrmGestionarArea.Presentacion(ifga);
        crud = new DAO_MantenimientoAreas(vista);
        crud.configurarMouseListener();
        crud.EnviarDatosAreaSeleccionada(0);
        ActualizarForma();
        addTextChangedListeners();
    }
    
    public void ActualizarForma(){
        crud = new DAO_MantenimientoAreas(vista);
        crud.MostrarArea(vista.tblAreas);
        ProcesosFrmGestionarArea.Estado1(vista);
        ProcesosFrmGestionarArea.LimpiarEntradas(vista);
    }
    
    private void addTextChangedListeners() {
    vista.txtNombreArea.getDocument().addDocumentListener(new DocumentListener() {
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
    
    vista.txtResponsableArea.getDocument().addDocumentListener(new DocumentListener() {
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
    
    vista.txtUbicacionArea.getDocument().addDocumentListener(new DocumentListener() {
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
    
    vista.txaDescripcionArea.getDocument().addDocumentListener(new DocumentListener() {
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
    
    vista.datecFechaArea.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
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
            area = ProcesosFrmGestionarArea.LeerDatos(vista);
            area.setIdArea(Integer.parseInt(vista.txtIDArea.getText()));
            crud = new DAO_MantenimientoAreas(vista);
            crud.ActualizarArea(area);
            ActualizarForma();
        }
        
        if (e.getSource() == vista.btnEliminar) {
            int respuesta = Mensajes.M3("¡CONFIRMAR!", "¿Desea eliminar el registro?");
            if (respuesta == 0) {
                int idcat = Integer.parseInt(vista.txtIDArea.getText());
                crud = new DAO_MantenimientoAreas(vista);
                crud.EliminarArea(idcat);
                ActualizarForma();
            }
        }
    }
    
}
