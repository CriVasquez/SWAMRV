/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soprafamrv.SISTEMA;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cri
 */
public class vehiculo {

//    vehiculo v = new vehiculo();
    
    //si quiero llamar con el GET desde otra clase con un objeto q no ha participado en un setter, debo declarar las variables
    //de abajo estaticas, como x ejemplo private String ANO a static String ano;
    private String PATENTE;
    private String CHASIS;
    private String COLOR;
    private String MARCA;
    private int ANO;
    private String MODELO;
    private Date FECHA_INGRESO;
    private Date FECHA_RETIRO;
    private byte[] FOTO;
    
    public int getANO() {
        return ANO;
    }

    public void setANO(int ANO) {
        this.ANO = ANO;
    }

    public String getCHASIS() {
        return CHASIS;
    }

    public void setCHASIS(String CHASIS) {
        this.CHASIS = CHASIS;
    }

    public String getCOLOR() {
        return COLOR;
    }

    public void setCOLOR(String COLOR) {
        this.COLOR = COLOR;
    }

    public Date getFECHA_INGRESO() {
        return FECHA_INGRESO;
    }

    public void setFECHA_INGRESO(Date FECHA_INGRESO) {
        this.FECHA_INGRESO = FECHA_INGRESO;
    }

    public Date getFECHA_RETIRO() {
        return FECHA_RETIRO;
    }

    public void setFECHA_RETIRO(Date FECHA_RETIRO) {
        this.FECHA_RETIRO = FECHA_RETIRO;
    }

    public byte[] getFOTO() {
        return FOTO;
    }

    public void setFOTO(byte[] FOTO) {
        this.FOTO = FOTO;
    }

    public String getMARCA() {
        return MARCA;
    }

    public void setMARCA(String MARCA) {
        this.MARCA = MARCA;
    }

    public String getMODELO() {
        return MODELO;
    }

    public void setMODELO(String MODELO) {
        this.MODELO = MODELO;
    }

    public String getPATENTE() {
        return PATENTE;
    }

    public void setPATENTE(String PATENTE) {
        this.PATENTE = PATENTE;
    }
/*
    public vehiculo getV() {
        return v;
    }

    public void setV(vehiculo v) {
        this.v = v;
    }
    
   
*/
    
    public static void llenarTablaVehiculos(JTable tabla, ResultSet resultadoMostrarPersonal) throws SQLException {
        tabla.removeAll();
        System.out.println("Inicio Llenado de tabla");
        int cantidadColumnas = resultadoMostrarPersonal.getMetaData().getColumnCount();
        System.out.println("Cantidad columnas:" +cantidadColumnas);
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.setColumnCount(cantidadColumnas);
        ArrayList cabeceras = new ArrayList();
        for(int z=0;z<cantidadColumnas;z++){
            //Esto imprime el nombre de las columnas
            cabeceras.add(resultadoMostrarPersonal.getMetaData().getColumnName(z+1));
            System.out.println ("Imprimiendo esta wea de metadata : " +resultadoMostrarPersonal.getMetaData().getColumnName(z+1));
            
        }
        modelo.setColumnIdentifiers(cabeceras.toArray()); 
        while(resultadoMostrarPersonal.next()){
            ArrayList lista = new ArrayList();            
            for(int i=0;i<cantidadColumnas;i++){
                lista.add(i,resultadoMostrarPersonal.getString(i+1));
                System.out.println(resultadoMostrarPersonal.getString(i+1));
                
            }
            modelo.addRow(lista.toArray());
        }
        
        tabla.setModel(modelo);
        tabla.setAutoCreateRowSorter(true);
        tabla.setAutoscrolls(true);
        
        
    }
    
    public static void llenarTablaVehiculoConductor(JTable tabla, ResultSet resultadoMostrarPersonal) throws SQLException {
        tabla.removeAll();
        System.out.println("Inicio Llenado de tabla");
        int cantidadColumnas = resultadoMostrarPersonal.getMetaData().getColumnCount();
        System.out.println("Cantidad columnas:" +cantidadColumnas);
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.setColumnCount(cantidadColumnas);
        ArrayList cabeceras = new ArrayList();
        for(int z=0;z<cantidadColumnas;z++){
            //Esto imprime el nombre de las columnas
            cabeceras.add(resultadoMostrarPersonal.getMetaData().getColumnName(z+1));
            System.out.println ("Imprimiendo esta wea de metadata : " +resultadoMostrarPersonal.getMetaData().getColumnName(z+1));
            
        }
        modelo.setColumnIdentifiers(cabeceras.toArray()); 
        while(resultadoMostrarPersonal.next()){
            ArrayList lista = new ArrayList();            
            for(int i=0;i<cantidadColumnas;i++){
                lista.add(i,resultadoMostrarPersonal.getString(i+1));
                System.out.println(resultadoMostrarPersonal.getString(i+1));
                
            }
            modelo.addRow(lista.toArray());
        }
        
        tabla.setModel(modelo);
        tabla.setAutoCreateRowSorter(true);
        tabla.setAutoscrolls(true);
        
        
    }
    
    
    
    
}
