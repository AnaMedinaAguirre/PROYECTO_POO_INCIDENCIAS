package Formatos;

//librerias
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class ManejadorTablas {
    //Metodo que especifica un ancho de las columnas de tabla    
    public static void AnchoColumnas(JTable t, int numcolumna,int ancho) {
        TableColumn column;
        column = t.getColumnModel().getColumn(numcolumna);
        column.setPreferredWidth(ancho);       
    }
    
    //metodo que justifica los datos de una columna
   public static void JustificarCelda(JTable t,int numcolumna){
       DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
       modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
       t.getColumnModel().getColumn(numcolumna).setCellRenderer(modelocentrar);       
   }
   
   public static void FormatoTablaEmpleados(JTable tabla){
       //nro
       AnchoColumnas(tabla,0,80);
       JustificarCelda(tabla,0);
       //id
       AnchoColumnas(tabla,1,80);
       JustificarCelda(tabla,1);
       //nombre
       AnchoColumnas(tabla,2,250);
       //apellido
       AnchoColumnas(tabla,3,250); 
       //genero
       AnchoColumnas(tabla,4,120); 
       //telefono
       AnchoColumnas(tabla,5,200);
       //cargo
       AnchoColumnas(tabla,6,250);
       //area
       AnchoColumnas(tabla,7,250);
       //sueldo
       AnchoColumnas(tabla,8,120);
       JustificarCelda(tabla,8);
       //fecha
       AnchoColumnas(tabla,9,120);
       JustificarCelda(tabla,9);
       //user
       AnchoColumnas(tabla,10,200);
       //password
       AnchoColumnas(tabla,3,200);
   }
   
   public static void FormatoTablaAreas(JTable tabla){
       //nro
       AnchoColumnas(tabla,0,80);
       JustificarCelda(tabla,0);
       //id
       AnchoColumnas(tabla,1,80);
       JustificarCelda(tabla,1);
       //nombre
       AnchoColumnas(tabla,2,250);
       //responsable
       AnchoColumnas(tabla,3,250); 
       //ubicacion
       AnchoColumnas(tabla,4,350); 
       //fecha
       AnchoColumnas(tabla,9,120);
       JustificarCelda(tabla,9);
       //descripcion
       AnchoColumnas(tabla,10,400);
   }
   
   public static void FormatoTablaTipoIncidencia(JTable tabla){
       //nro
       AnchoColumnas(tabla,0,80);
       JustificarCelda(tabla,0);
       //id
       AnchoColumnas(tabla,1,80);
       JustificarCelda(tabla,1);
       //nombre
       AnchoColumnas(tabla,2,250);
       //categoria
       AnchoColumnas(tabla,3,250);  
       //fecha
       AnchoColumnas(tabla,9,120);
       JustificarCelda(tabla,9);
       //descripcion
       AnchoColumnas(tabla,10,400);
   }
   
   public static void FormatoTablaIncidencias(JTable tabla){
       //nro
       AnchoColumnas(tabla,0,80);
       JustificarCelda(tabla,0);
       //id
       AnchoColumnas(tabla,1,80);
       JustificarCelda(tabla,1);
       //nombre
       AnchoColumnas(tabla,2,250);
       //Asignadox
       AnchoColumnas(tabla,3,300);  
       //Asignadoa
       AnchoColumnas(tabla,3,300);
       //prioridad
       AnchoColumnas(tabla,2,150);
       //Tipo
       AnchoColumnas(tabla,3,300);  
       //Area
       AnchoColumnas(tabla,3,300);
       //fecha
       AnchoColumnas(tabla,9,120);
       JustificarCelda(tabla,9);
       //Estado
       AnchoColumnas(tabla,3,120);
       //descripcion
       AnchoColumnas(tabla,10,400);
   }
   
   public static void FormatoTablaDetalleSolucion(JTable tabla){
       //nro
       AnchoColumnas(tabla,0,80);
       JustificarCelda(tabla,0);
       //id
       AnchoColumnas(tabla,1,80);
       JustificarCelda(tabla,1);
       //incidencia
       AnchoColumnas(tabla,2,300);
       //descripcion
       AnchoColumnas(tabla,3,400); 
       //fecha
       AnchoColumnas(tabla,9,120);
       JustificarCelda(tabla,9);
       //encargado
       AnchoColumnas(tabla,10,300);
   }
}