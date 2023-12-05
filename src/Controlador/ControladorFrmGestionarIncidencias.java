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

public class ControladorFrmGestionarIncidencias implements ActionListener {

    InterFrameGestionarIncidencias vista;
    DAO_MantenimientoIncidencia crud;
    Incidencia i;
    DAO_Empleado crud1;
    DAO_TipoIncidencia crud2;
    DAO_Area crud3;

    public ControladorFrmGestionarIncidencias(InterFrameGestionarIncidencias f5) {
        vista = f5;
        vista.btnActualizar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        ProcesosFrmGestionarIncidencia.Presentacion(f5);
        crud = new DAO_MantenimientoIncidencia(vista);
        crud1 = new DAO_Empleado();
        crud2 = new DAO_TipoIncidencia();
        crud3 = new DAO_Area();
        crud.CargarComboEmpleado1();
        crud.CargarComboEmpleado2();
        crud.CargarComboTipoIncidencia();
        crud.CargarComboArea();
        crud.cargarComboPrioridad();
        crud.configurarMouseListener();
        ActualizarForma();
        addTextChangedListeners();
    }

    public void ActualizarForma() {
        crud = new DAO_MantenimientoIncidencia(vista);
        crud.MostrarIncidencia(vista.tblIndicencias);
        ProcesosFrmGestionarIncidencia.Estado1(vista);
        ProcesosFrmGestionarIncidencia.LimpiarEntradas(vista);
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

        vista.cbxAsignadoX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableUpdateButton();
            }
        });

        vista.cbxAsignadoA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableUpdateButton();
            }
        });

        vista.cbxPrioridad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableUpdateButton();
            }
        });

        vista.cbxTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableUpdateButton();
            }
        });

        vista.cbxArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
    }

    private void enableUpdateButton() {
        vista.btnActualizar.setEnabled(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnActualizar){
            i = ProcesosFrmGestionarIncidencia.LeerDatos(vista, crud1, crud2, crud3);
            i.setIdIncidencia(Integer.parseInt(vista.txtIDIncidencia.getText()));
            crud1 = new DAO_Empleado();
            crud2 = new DAO_TipoIncidencia();
            crud3 = new DAO_Area();
            crud = new DAO_MantenimientoIncidencia(vista);
            crud.ActualizarIncidencia(i);
            ActualizarForma();
        }
        
        if (e.getSource() == vista.btnEliminar) {
            int respuesta = Mensajes.M3("¡CONFIRMAR!", "¿Desea eliminar el registro?");
            if (respuesta == 0) {
                int idcat = Integer.parseInt(vista.txtIDIncidencia.getText());
                crud = new DAO_MantenimientoIncidencia(vista);
                crud.EliminarIncidencia(idcat);
                ActualizarForma();
            }
        }
    }
}
