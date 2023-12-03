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

public class ControladorFrmGestionarEmpleados implements ActionListener{
    InterFrameGestionarEmpleados vista;
    DAO_MantenimientoEmpleados crud;
    Empleado emp;
    DAO_Area cru2;
    
    public ControladorFrmGestionarEmpleados(InterFrameGestionarEmpleados f4){
        vista = f4;
        vista.btnActualizar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        ProcesosFrmGestionarEmpleado.Presentacion(f4);
        crud = new DAO_MantenimientoEmpleados(vista);
        cru2 = new DAO_Area();
        crud.CargarComboArea();
        crud.cargarComboGenero();
        crud.configurarMouseListener();
        ActualizarForma();
        addTextChangedListeners();
    }
    
    public void ActualizarForma(){
        crud = new DAO_MantenimientoEmpleados(vista);
        crud.MostrarEmpleado(vista.tblEmpleado);
        ProcesosFrmGestionarEmpleado.Estado1(vista);
        ProcesosFrmGestionarEmpleado.LimpiarEntradas(vista);
    }
    
    
    private void addTextChangedListeners() {
        vista.txtNombreEmpleado.getDocument().addDocumentListener(new DocumentListener() {
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
        
        vista.txtApellidoEmpleado.getDocument().addDocumentListener(new DocumentListener() {
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
        

        vista.cbxGeneroEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableUpdateButton();
            }
        });

        vista.txtTelefonoEmpleado.getDocument().addDocumentListener(new DocumentListener() {
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
        
        vista.txtCargoEmpleado.getDocument().addDocumentListener(new DocumentListener() {
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
        
        vista.cbxAreaEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableUpdateButton();
            }
        });

        vista.datecFechaEmpleado.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    enableUpdateButton();
                }
            }
        });
        
        vista.txtSueldoEmpleado.getDocument().addDocumentListener(new DocumentListener() {
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
        
        vista.txtUsuarioEmpleado.getDocument().addDocumentListener(new DocumentListener() {
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
        
        vista.txtContraseñaEmpleado.getDocument().addDocumentListener(new DocumentListener() {
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
    }

    private void enableUpdateButton() {
        vista.btnActualizar.setEnabled(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnActualizar){
            emp = ProcesosFrmGestionarEmpleado.LeerDatos(vista, cru2);
            emp.setIdEmpleado(Integer.parseInt(vista.txtIDEmpleado.getText()));
            cru2 = new DAO_Area();
            crud = new DAO_MantenimientoEmpleados(vista);
            crud.ActualizarEmpleado(emp);
            ActualizarForma();
        }
        
        if (e.getSource() == vista.btnEliminar) {
            int respuesta = Mensajes.M3("¡CONFIRMAR!", "¿Desea eliminar el registro?");
            if (respuesta == 0) {
                int idcat = Integer.parseInt(vista.txtIDEmpleado.getText());
                crud = new DAO_MantenimientoEmpleados(vista);
                crud.EliminarEmpleado(idcat);
                ActualizarForma();
            }
        }
    }
}
