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

public class ControladorFrmGestionarDetalleSolucion implements ActionListener {

    InterFrameGestionarDetalleSolucion vista;
    DAO_MantenimientoDetalleSolucion crud;
    DetalleSolucion ds;
    DAO_Incidencia crud1;

    public ControladorFrmGestionarDetalleSolucion(InterFrameGestionarDetalleSolucion f9) {
        vista = f9;
        vista.btnActualizar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        ProcesosFrmGestionarDetalleSolucion.Presentacion(f9);
        crud = new DAO_MantenimientoDetalleSolucion(vista);
        crud1 = new DAO_Incidencia();
        crud.CargarComboIncidencia();
        crud.cargarComboEstado();
        crud.configurarMouseListener();
        ActualizarForma();
        addTextChangedListeners();
    }

    public void ActualizarForma() {
        crud = new DAO_MantenimientoDetalleSolucion(vista);
        crud.MostrarDetalleSolucion(vista.tblDetalleSolucion);
        ProcesosFrmGestionarDetalleSolucion.Estado1(vista);
        ProcesosFrmGestionarDetalleSolucion.LimpiarEntradas(vista);
    }

    private void addTextChangedListeners() {

        vista.cbxIncidencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableUpdateButton();
            }
        });

        vista.txaObservacion.getDocument().addDocumentListener(new DocumentListener() {
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

        vista.cbxEstado.addActionListener(new ActionListener() {
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
    }

    private void enableUpdateButton() {
        vista.btnActualizar.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnActualizar) {
            ds = ProcesosFrmGestionarDetalleSolucion.LeerDatos(vista, crud1);
            ds.setIdDetSolucion(Integer.parseInt(vista.txtID.getText()));
            crud1 = new DAO_Incidencia();
            crud = new DAO_MantenimientoDetalleSolucion(vista);
            crud.ActualizarDetalleSolucion(ds);
            ActualizarForma();
        }

        if (e.getSource() == vista.btnEliminar) {
            int respuesta = Mensajes.M3("¡CONFIRMAR!", "¿Desea eliminar el registro?");
            if (respuesta == 0) {
                int idcat = Integer.parseInt(vista.txtID.getText());
                crud = new DAO_MantenimientoDetalleSolucion(vista);
                crud.EliminarDetalleSolucion(idcat);
                ActualizarForma();
            }
        }
    }
}
