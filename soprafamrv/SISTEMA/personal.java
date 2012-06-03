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
public class personal {
    
    private String RUT;
    private String NOMBRE;
    private String CONTRASENA;
    private String APELLIDOPAT;
    private String APELLIDOMAT;
    private String DIRECCION;
    private int TELEFONO;
    private String EMAIL;
    private int ID_COMUNA;
    private Date FECHA_INGRESO;
    private Date FECHA_RETIRO;
    private Date FECHA_NACIMIENTO;
    private int RADIO;
    private String LICENCIA;
    private String DETALLE;
    private byte[] FOTO;

    public String getAPELLIDOMAT() {
        return APELLIDOMAT;
    }

    public void setAPELLIDOMAT(String APELLIDOMAT) {
        this.APELLIDOMAT = APELLIDOMAT;
    }

    public String getAPELLIDOPAT() {
        return APELLIDOPAT;
    }

    public void setAPELLIDOPAT(String APELLIDOPAT) {
        this.APELLIDOPAT = APELLIDOPAT;
    }

    public String getCONTRASENA() {
        return CONTRASENA;
    }

    public void setCONTRASENA(String CONTRASENA) {
        this.CONTRASENA = CONTRASENA;
    }

    public String getDETALLE() {
        return DETALLE;
    }

    public void setDETALLE(String DETALLE) {
        this.DETALLE = DETALLE;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public Date getFECHA_INGRESO() {
        return FECHA_INGRESO;
    }

    public void setFECHA_INGRESO(Date FECHA_INGRESO) {
        this.FECHA_INGRESO = FECHA_INGRESO;
    }

    public Date getFECHA_NACIMIENTO() {
        return FECHA_NACIMIENTO;
    }

    public void setFECHA_NACIMIENTO(Date FECHA_NACIMIENTO) {
        this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
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

    public int getID_COMUNA() {
        return ID_COMUNA;
    }

    public void setID_COMUNA(int ID_COMUNA) {
        this.ID_COMUNA = ID_COMUNA;
    }

    public String getLICENCIA() {
        return LICENCIA;
    }

    public void setLICENCIA(String LICENCIA) {
        this.LICENCIA = LICENCIA;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public int getRADIO() {
        return RADIO;
    }

    public void setRADIO(int RADIO) {
        this.RADIO = RADIO;
    }

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    public int getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(int TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public boolean verificarRut(int rut, char dv){
        int m = 0 , s = 1;
        for (; rut!= 0; rut /=10){
        s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        return dv == (char) (s != 0 ? s +47 : 75);
    }
    
    public static void llenarTabla(JTable tabla, ResultSet resultadoMostrarPersonal) throws SQLException {
        tabla.removeAll();
        int cantidadColumnas = resultadoMostrarPersonal.getMetaData().getColumnCount();
        System.out.println(cantidadColumnas);
        DefaultTableModel modelo = new DefaultTableModel(){
             public boolean isCellEditable(int x, int y) {            
            return false; //Disallow the editing of any cell
            }            
        };
        
        
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
