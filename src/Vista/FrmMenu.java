package Vista;

public class FrmMenu extends javax.swing.JFrame {

    public FrmMenu() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuItemNuevoEmpleado = new javax.swing.JMenuItem();
        MenuItemGestionarEmpleados = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MenuItemTiposIncidencias = new javax.swing.JMenuItem();
        MenuItemGestionarTipos = new javax.swing.JMenuItem();
        MenuItemNuevaIncidencia = new javax.swing.JMenuItem();
        MenuItemGestionarIncidencias = new javax.swing.JMenuItem();
        MenuItemNuevoDetalleSolucion = new javax.swing.JMenuItem();
        MenuItemGestionarDetalleSolucion = new javax.swing.JMenuItem();
        MenuItemSeguimiento = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        MenuItemRegistroAreas = new javax.swing.JMenuItem();
        MenuItemGestionarAreas = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        MenuItemExportarPDF = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        MenuItemCerrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));

        Escritorio.setBackground(new java.awt.Color(0, 84, 84));

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1355, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
        );

        jMenu1.setBackground(new java.awt.Color(204, 204, 255));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/employee.png"))); // NOI18N
        jMenu1.setText("Empleados");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(210, 50));

        MenuItemNuevoEmpleado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MenuItemNuevoEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/newEmployee.png"))); // NOI18N
        MenuItemNuevoEmpleado.setText("Nuevo Empleado");
        MenuItemNuevoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemNuevoEmpleadoActionPerformed(evt);
            }
        });
        jMenu1.add(MenuItemNuevoEmpleado);

        MenuItemGestionarEmpleados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MenuItemGestionarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/gestion.png"))); // NOI18N
        MenuItemGestionarEmpleados.setText("Gestionar Empleados");
        MenuItemGestionarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemGestionarEmpleadosActionPerformed(evt);
            }
        });
        jMenu1.add(MenuItemGestionarEmpleados);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(204, 204, 255));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/alarm.png"))); // NOI18N
        jMenu2.setText("Incidencias");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(210, 50));

        MenuItemTiposIncidencias.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MenuItemTiposIncidencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/tipoIncidencia.png"))); // NOI18N
        MenuItemTiposIncidencias.setText("Tipos de Incidencias");
        MenuItemTiposIncidencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemTiposIncidenciasActionPerformed(evt);
            }
        });
        jMenu2.add(MenuItemTiposIncidencias);

        MenuItemGestionarTipos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MenuItemGestionarTipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/gestionTipoIncid.png"))); // NOI18N
        MenuItemGestionarTipos.setText("Gestionar Tipos de Incidencias");
        MenuItemGestionarTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemGestionarTiposActionPerformed(evt);
            }
        });
        jMenu2.add(MenuItemGestionarTipos);

        MenuItemNuevaIncidencia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MenuItemNuevaIncidencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/newIncidencia.png"))); // NOI18N
        MenuItemNuevaIncidencia.setLabel("Nueva Incidencia");
        MenuItemNuevaIncidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemNuevaIncidenciaActionPerformed(evt);
            }
        });
        jMenu2.add(MenuItemNuevaIncidencia);

        MenuItemGestionarIncidencias.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MenuItemGestionarIncidencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/gestionIncidencia.png"))); // NOI18N
        MenuItemGestionarIncidencias.setLabel("Gestionar Incidencias");
        MenuItemGestionarIncidencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemGestionarIncidenciasActionPerformed(evt);
            }
        });
        jMenu2.add(MenuItemGestionarIncidencias);

        MenuItemNuevoDetalleSolucion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MenuItemNuevoDetalleSolucion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/solucion.png"))); // NOI18N
        MenuItemNuevoDetalleSolucion.setText("Nuevo destalle de Solución");
        MenuItemNuevoDetalleSolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemNuevoDetalleSolucionActionPerformed(evt);
            }
        });
        jMenu2.add(MenuItemNuevoDetalleSolucion);

        MenuItemGestionarDetalleSolucion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MenuItemGestionarDetalleSolucion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/solution.png"))); // NOI18N
        MenuItemGestionarDetalleSolucion.setText("Gestionar detalle de Solución");
        jMenu2.add(MenuItemGestionarDetalleSolucion);

        MenuItemSeguimiento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MenuItemSeguimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/follow-up.png"))); // NOI18N
        MenuItemSeguimiento.setLabel("Seguimiento de Incidencia");
        MenuItemSeguimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemSeguimientoActionPerformed(evt);
            }
        });
        jMenu2.add(MenuItemSeguimiento);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(204, 204, 255));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/area.png"))); // NOI18N
        jMenu3.setText("Áreas");
        jMenu3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(210, 50));

        MenuItemRegistroAreas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MenuItemRegistroAreas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/register.png"))); // NOI18N
        MenuItemRegistroAreas.setText("Registro de Áreas");
        MenuItemRegistroAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemRegistroAreasActionPerformed(evt);
            }
        });
        jMenu3.add(MenuItemRegistroAreas);

        MenuItemGestionarAreas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MenuItemGestionarAreas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/hospital.png"))); // NOI18N
        MenuItemGestionarAreas.setText("Gestionar Áreas");
        MenuItemGestionarAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemGestionarAreasActionPerformed(evt);
            }
        });
        jMenu3.add(MenuItemGestionarAreas);

        jMenuBar1.add(jMenu3);

        jMenu9.setBackground(new java.awt.Color(204, 204, 255));
        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf.png"))); // NOI18N
        jMenu9.setText("Exportar PDF");
        jMenu9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu9.setPreferredSize(new java.awt.Dimension(210, 50));

        MenuItemExportarPDF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MenuItemExportarPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/export.png"))); // NOI18N
        MenuItemExportarPDF.setText("Detalles de la Incidencia");
        MenuItemExportarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemExportarPDFActionPerformed(evt);
            }
        });
        jMenu9.add(MenuItemExportarPDF);

        jMenuBar1.add(jMenu9);

        jMenu10.setBackground(new java.awt.Color(204, 204, 255));
        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logout.png"))); // NOI18N
        jMenu10.setText("Cerrar Sesión");
        jMenu10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu10.setPreferredSize(new java.awt.Dimension(210, 50));

        MenuItemCerrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MenuItemCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logout2.png"))); // NOI18N
        MenuItemCerrar.setText("Cerrar Sesión");
        MenuItemCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCerrarActionPerformed(evt);
            }
        });
        jMenu10.add(MenuItemCerrar);

        jMenuBar1.add(jMenu10);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItemTiposIncidenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemTiposIncidenciasActionPerformed

    }//GEN-LAST:event_MenuItemTiposIncidenciasActionPerformed

    private void MenuItemNuevoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemNuevoEmpleadoActionPerformed
        
    }//GEN-LAST:event_MenuItemNuevoEmpleadoActionPerformed

    private void MenuItemGestionarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemGestionarEmpleadosActionPerformed

    }//GEN-LAST:event_MenuItemGestionarEmpleadosActionPerformed

    private void MenuItemCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MenuItemCerrarActionPerformed

    private void MenuItemGestionarTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemGestionarTiposActionPerformed

    }//GEN-LAST:event_MenuItemGestionarTiposActionPerformed

    private void MenuItemRegistroAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemRegistroAreasActionPerformed

    }//GEN-LAST:event_MenuItemRegistroAreasActionPerformed

    private void MenuItemGestionarAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemGestionarAreasActionPerformed

    }//GEN-LAST:event_MenuItemGestionarAreasActionPerformed

    private void MenuItemNuevaIncidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemNuevaIncidenciaActionPerformed

    }//GEN-LAST:event_MenuItemNuevaIncidenciaActionPerformed

    private void MenuItemNuevoDetalleSolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemNuevoDetalleSolucionActionPerformed
    }//GEN-LAST:event_MenuItemNuevoDetalleSolucionActionPerformed

    private void MenuItemSeguimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemSeguimientoActionPerformed

    }//GEN-LAST:event_MenuItemSeguimientoActionPerformed

    private void MenuItemExportarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemExportarPDFActionPerformed

    }//GEN-LAST:event_MenuItemExportarPDFActionPerformed

    private void MenuItemGestionarIncidenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemGestionarIncidenciasActionPerformed

    }//GEN-LAST:event_MenuItemGestionarIncidenciasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuItem MenuItemCerrar;
    public javax.swing.JMenuItem MenuItemExportarPDF;
    public javax.swing.JMenuItem MenuItemGestionarAreas;
    public javax.swing.JMenuItem MenuItemGestionarDetalleSolucion;
    public javax.swing.JMenuItem MenuItemGestionarEmpleados;
    public javax.swing.JMenuItem MenuItemGestionarIncidencias;
    public javax.swing.JMenuItem MenuItemGestionarTipos;
    public javax.swing.JMenuItem MenuItemNuevaIncidencia;
    public javax.swing.JMenuItem MenuItemNuevoDetalleSolucion;
    public javax.swing.JMenuItem MenuItemNuevoEmpleado;
    public javax.swing.JMenuItem MenuItemRegistroAreas;
    public javax.swing.JMenuItem MenuItemSeguimiento;
    public javax.swing.JMenuItem MenuItemTiposIncidencias;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    public javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
