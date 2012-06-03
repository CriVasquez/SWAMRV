/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soprafamrv.SISTEMA;

import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.jdesktop.swingbinding.JTableBinding.ColumnBinding;

/**
 *
 * @author Administrador
 */
public class ot {
    
    private int ID_OT;
    private String PATENTE;
    private String RUT_ADMINISTRADOR;
    private String RUT_MECANICO;
    private Date FECHA_INICIO;
    private Date FECHA_TERMINO;
    private String TIPOTRABAJO;
    
    public Date getFECHA_INICIO() {
        return FECHA_INICIO;
    }

    public void setFECHA_INICIO(Date FECHA_INICIO) {
        this.FECHA_INICIO = FECHA_INICIO;
    }

    public Date getFECHA_TERMINO() {
        return FECHA_TERMINO;
    }

    public void setFECHA_TERMINO(Date FECHA_TERMINO) {
        this.FECHA_TERMINO = FECHA_TERMINO;
    }

    public int getID_OT() {
        return ID_OT;
    }

    public void setID_OT(int ID_OT) {
        this.ID_OT = ID_OT;
    }

    public String getTIPOTRABAJO() {
        return TIPOTRABAJO;
    }

    public void setTIPOTRABAJO(String TIPOTRABAJO) {
        this.TIPOTRABAJO = TIPOTRABAJO;
    }

    public String getPATENTE() {
        return PATENTE;
    }

    public void setPATENTE(String PATENTE) {
        this.PATENTE = PATENTE;
    }

    public String getRUT_ADMINISTRADOR() {
        return RUT_ADMINISTRADOR;
    }

    public void setRUT_ADMINISTRADOR(String RUT_ADMINISTRADOR) {
        this.RUT_ADMINISTRADOR = RUT_ADMINISTRADOR;
    }

    public String getRUT_MECANICO() {
        return RUT_MECANICO;
    }

    public void setRUT_MECANICO(String RUT_MECANICO) {
        this.RUT_MECANICO = RUT_MECANICO;
    }
    
    public static void llenarTablaOT(JTable tabla, ResultSet resultadoMostrarOT) throws SQLException {
        tabla.removeAll();
        System.out.println("INICIO LLENADO TABLA");
        int cantidadColumnas = resultadoMostrarOT.getMetaData().getColumnCount();
        
        DefaultTableModel modelo = new DefaultTableModel(){
            public boolean isCellEditable(int x, int y) {            
            return false; //Disallow the editing of any cell
    
        }
            
        };
        
        modelo.setColumnCount(cantidadColumnas);
        ArrayList cabeceras = new ArrayList();
        for(int z=0;z<cantidadColumnas;z++){
            //Esto imprime el nombre de las columnas
            cabeceras.add(resultadoMostrarOT.getMetaData().getColumnName(z+1));
            
        }
        modelo.setColumnIdentifiers(cabeceras.toArray()); 
        while(resultadoMostrarOT.next()){
            ArrayList lista = new ArrayList();            
            for(int i=0;i<cantidadColumnas;i++){
                lista.add(i,resultadoMostrarOT.getString(i+1));                    
            }
            modelo.addRow(lista.toArray());
        }
    
        tabla.setModel(modelo);
        tabla.setAutoCreateRowSorter(true);
        tabla.setAutoscrolls(true);
        
    }
    
     public static void llenarTablaOT2(JTable tabla, ResultSet resultadoMostrarOT) throws SQLException {
        tabla.removeAll();
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int cantidadColumnas = resultadoMostrarOT.getMetaData().getColumnCount();

        DefaultTableModel modelo = new DefaultTableModel(){
            public boolean isCellEditable(int x, int y) {            
            return false; //Disallow the editing of any cell
            }            
        };
        
        
        modelo.setColumnCount(cantidadColumnas);
        ArrayList cabeceras = new ArrayList();
        for(int z=0;z<cantidadColumnas;z++){
            //Esto imprime el nombre de las columnas
            cabeceras.add(resultadoMostrarOT.getMetaData().getColumnName(z+1));
            System.out.println("imprimiendo cabeceras:" +cabeceras);     
        }
        
        modelo.setColumnIdentifiers(cabeceras.toArray()); 
                
        while(resultadoMostrarOT.next()){
            ArrayList lista = new ArrayList();            
            for(int i=0;i<cantidadColumnas;i++){
                lista.add(i,resultadoMostrarOT.getString(i+1));                    
                
            }
            modelo.addRow(lista.toArray());                        
        }
        tabla.setModel(modelo);
        tabla.setAutoCreateRowSorter(true);
        tabla.setAutoscrolls(true);        
        System.out.println("FIN LLENADO TABLA");
        
    }
     
    
}
