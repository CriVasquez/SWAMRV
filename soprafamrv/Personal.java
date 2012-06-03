/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Personals.java
 *
 * Created on 29-12-2011, 12:31:16 AM
 */
package soprafamrv;

import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleCallableStatement;
import org.jdesktop.application.Action;
import soprafamrv.BD.Conexion;
import soprafamrv.SISTEMA.miPanel;
import soprafamrv.SISTEMA.personal;
import soprafamrv.SISTEMA.subeImagen;

/**
 *
 * @author Cri
 */
public class Personal extends javax.swing.JInternalFrame {

    /**
     * Creates new form Personals
     */
    public Personal() throws SQLException {

        initComponents();        
        this.JFNUMRADIO.setVisible(false);
        this.JFTIPOLICENCIA.setVisible(false);
        this.jLabel13.setVisible(false);
        this.jLabel14.setVisible(false);
        this.JFCONTRASENA.setVisible(false);
        this.JFCONTRASENA1.setVisible(false);
        this.jLabel2.setVisible(false);
        this.jLabel24.setVisible(false);
        this.JFComunaID.setVisible(false);
        cargarNuevo();        
        AsignarFechaIngreso();

    }
    
    
    byte[] IMAGEN;
    int contador = 0;
    int contador2 = 0;
    
    private String retornarMes(String month){
    if (month.equals("1")){
        month = "Enero";                
        }                              
    else if(month.equals("2")){                    
        month = "Febrero";                    
        }
    else if(month.equals("3")){                    
        month = "Marzo";                    
        }
    else if(month.equals("4")){                    
        month = "Abril";                    
        }
    else if(month.equals("5")){                    
        month = "Mayo";                    
        }
    else if(month.equals("6")){                    
        month = "Junio";                    
        }
    else if(month.equals("7")){                    
        month = "Julio";                    
        }
    else if(month.equals("8")){                    
        month = "Agosto";                    
        }
    else if(month.equals("9")){          
        month = "Septiembre";                    
        }
    else if(month.equals("10")){                    
        month = "Octubre";                    
        }
    else if(month.equals("11")){                    
        month = "Noviembre";                    
        }
    else if(month.equals("12")){                    
        month = "Diciembre";                    
        }
    System.out.println ("MES RETORNADO: " +month);
    return month;
    }

    private void ResetearCampos() {
        this.JFRUT.setText(null);
        this.JFCONTRASENA.setText(null);
        this.JFCONTRASENA1.setText(null);
        this.JFNOMBRE.setText(null);
        this.JFAPEPA.setText(null);
        this.JFAPEMA.setText(null);
        this.JFDIRE.setText(null);
        this.JFTELE.setText(null);
        this.JFEMAIL.setText(null);
        this.JFNUMRADIO.setText(null);
        this.JTDETALLE.setText(null);
        this.jCBTipoCuenta.setSelectedIndex(0);
        this.JCCOMUNA.setSelectedIndex(0);
        this.JCFECHAING1.setSelectedIndex(0);
        this.JCFECHAING2.setSelectedIndex(0);
        this.JCFECHAING3.setSelectedIndex(0);
         
        this.JCFECHANAC1.setSelectedIndex(0);
        this.JCFECHANAC2.setSelectedIndex(0);
        this.JCFECHANAC3.setSelectedIndex(0);
         
        this.JPanelImagen.removeAll();
        this.JPanelImagen.repaint();
        
    }

    private void AsignarFechaIngreso() {
        //Puedo jugar con DD MM YYYY para mostrarlos individualmente
        DateFormat dia = new SimpleDateFormat("dd");
        DateFormat mes = new SimpleDateFormat("MMMMMMMMMM");
        DateFormat ano = new SimpleDateFormat("yyyy");
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        this.JCFECHAING1.addItem(dia.format(date));
        this.JCFECHAING2.addItem(mes.format(date).toUpperCase());
        this.JCFECHAING3.addItem(ano.format(date));
        this.JCFECHAING1.setSelectedIndex(1);
        this.JCFECHAING2.setSelectedIndex(1);
        this.JCFECHAING3.setSelectedIndex(1);

        int year = Integer.parseInt(ano.format(date));
        System.out.println("Inicio ingreso años");
        for (int x = 2010; x <= year; x++) {            
            this.JCFECHANAC3.addItem(x);

        }
        System.out.println("Termino ingreso años");

    }

    private void HabilitarCampos() {
        this.JFRUT.setEnabled(true);
        this.JFCONTRASENA.setEnabled(true);
        this.JFCONTRASENA1.setEnabled(true);
        this.JFNOMBRE.setEnabled(true);
        this.JFAPEPA.setEnabled(true);
        this.JFAPEMA.setEnabled(true);
        this.JFDIRE.setEnabled(true);
        this.JFTELE.setEnabled(true);
        this.JFEMAIL.setEnabled(true);
        this.JTDETALLE.setEnabled(true);
        this.JCCOMUNA.setEnabled(true);
        this.JCFECHANAC1.setEnabled(true);
        this.JCFECHANAC2.setEnabled(true);
        this.JCFECHANAC3.setEnabled(true);        
        this.JBGUARDAR.setEnabled(true);
        this.JBBorrar.setEnabled(true);
        this.JFNUMRADIO.setEnabled(true);
        this.JFTIPOLICENCIA.setEnabled(true);
        this.jCBTipoCuenta.setEnabled(true);
        this.jButton3.setEnabled(true);
   
    }
    
    private void DeshabilitarCampos(){
        this.JBBorrar.setEnabled(false);
        this.JBGUARDAR.setEnabled(false);
        this.jButton3.setEnabled(false);
        this.JFRUT.setEnabled(false);
        this.JFCONTRASENA.setEnabled(false);
        this.JFCONTRASENA1.setEnabled(false);
        this.JFNOMBRE.setEnabled(false);
        this.JFAPEPA.setEnabled(false);
        this.JFAPEMA.setEnabled(false);
        this.JFDIRE.setEnabled(false);
        this.JFTELE.setEnabled(false);
        this.JFEMAIL.setEnabled(false);
        this.JTDETALLE.setEnabled(false);
        this.JCCOMUNA.setEnabled(false);
        this.JCFECHANAC1.setEnabled(false);
        this.JCFECHANAC2.setEnabled(false);
        this.JCFECHANAC3.setEnabled(false);        
        this.JFNUMRADIO.setEnabled(false);
        this.JFTIPOLICENCIA.setEnabled(false);
        JPanelImagen.removeAll();
        JPanelImagen.repaint();
    
    }
   
    private void cargarNuevo() {
        //Carga las COMUNAS en el comboBox
        try {
            String query = "Select nombre from buscarcomuna";
            ResultSet rs = Conexion.ejecutarQuery(query);

            while (rs.next()) {
                this.JCCOMUNA.addItem(rs.getString("nombre"));
            }
                       
        } catch (SQLException ex) {
            Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Action
    public void Guardar() throws SQLException, ParseException {
        System.out.println("Creación de objetos");
        subeImagen s = new subeImagen();
        personal p = new personal();
                
        System.out.println("Inicio Definición Variables");
        String TIPOCUENTA = (String) this.jCBTipoCuenta.getSelectedItem();
        String RUT = this.JFRUT.getText();
        String NOMBRE = this.JFNOMBRE.getText().toUpperCase().trim();
        String CONTRASENA = this.JFCONTRASENA.getPassword().toString();
        String APELLIDO_PATERNO = this.JFAPEPA.getText().toUpperCase().trim();
        String APELLIDO_MATERNO = this.JFAPEMA.getText().toUpperCase().trim();
        String DIRECCION = this.JFDIRE.getText().toUpperCase().trim();
        String TELEFONO = this.JFTELE.getText().trim();
        String EMAIL = this.JFEMAIL.getText().toUpperCase().trim();
        String COMUNA = this.JFComunaID.getText().trim();
        String FECHA_INGRESO = this.JCFECHAING1.getSelectedItem() + "-" + this.JCFECHAING2.getSelectedItem() + "-" + this.JCFECHAING3.getSelectedItem();        
        String FECHA_NACIMIENTO = this.JCFECHANAC1.getSelectedItem() + "-" + this.JCFECHANAC2.getSelectedItem() + "-" + this.JCFECHANAC3.getSelectedItem();
        String NUM_RADIO = this.JFNUMRADIO.getText().trim();
        String LICENCIA = this.JFTIPOLICENCIA.getText().trim();
        String DETALLES = this.JTDETALLE.getText().toUpperCase().trim();
        
        byte[] FOTO = IMAGEN;
        if (contador2 == 1){
            System.out.println("numero contador2: " +contador2);
            FOTO = s.ObtenerBytes();    
        }
        else if(contador2 == 2){
            FOTO = s.ObtenerBytes();    
        }
        
        
        System.out.println("Definicion formato fecha");
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MMMMMMMMMM-yyyy", new Locale("es", "ES"));
        java.sql.Date ingreso = new java.sql.Date(sdf.parse(FECHA_INGRESO).getTime());        
        java.sql.Date nac = new java.sql.Date(sdf.parse(FECHA_NACIMIENTO).getTime());
   
        p.setRUT(RUT);
        p.setNOMBRE(NOMBRE);        
        p.setAPELLIDOPAT(APELLIDO_PATERNO);
        p.setAPELLIDOMAT(APELLIDO_MATERNO);
        p.setDIRECCION(DIRECCION);
        p.setTELEFONO(Integer.parseInt(TELEFONO));
        p.setEMAIL(EMAIL);
        p.setID_COMUNA(Integer.parseInt(COMUNA)-1);
        p.setFECHA_INGRESO(ingreso);        
        p.setFECHA_NACIMIENTO(nac);        
        p.setDETALLE(DETALLES);
        p.setFOTO(FOTO);
        
        Conexion c = new Conexion();      
        System.out.println("Termino Definición Variables");
        
        System.out.println("INICIO impresion variables asignadas");
        System.out.println("RUT: " +p.getRUT());
        System.out.println("NOMBRE: " +p.getNOMBRE());
        System.out.println("APEPA: " +p.getAPELLIDOPAT());
        System.out.println("APEMA: " +p.getAPELLIDOMAT());
        System.out.println("DIRECCION: " +p.getDIRECCION());
        System.out.println("TELEFONO: " +p.getTELEFONO());
        System.out.println("EMAIL: " +p.getEMAIL());
        System.out.println("ID_COMUNA: " +p.getID_COMUNA());
        System.out.println("FECHAIN: " +p.getFECHA_INGRESO());        
        System.out.println("FECHANAC: " +p.getFECHA_NACIMIENTO());        
        System.out.println("DETALLE: " +p.getDETALLE());
        System.out.println("FOTO: " +p.getFOTO());
        System.out.println("TERMINO impresion variables asignadas");
        if (contador == 2){
            System.out.println("NUMERO CONTADOR DENTRO DEL IF: " +contador);
            if (TIPOCUENTA.equals("Administrador")){
                if (!"Seleccionar Tipo Cuenta".equals(this.jCBTipoCuenta.getSelectedItem().toString()) && this.JFRUT.getText().trim() != null && this.JFCONTRASENA.getText().trim() != null && this.JFNOMBRE.getText().trim() != null && this.JFAPEPA.getText().trim() != null && this.JFAPEMA.getText().trim() != null && this.JFDIRE.getText().trim() != null && this.JFTELE.getText().trim() != null && this.JFEMAIL.getText().trim() != null && this.JTDETALLE.getText().trim() != null && !"Día".equals(this.JCFECHAING1.getSelectedItem().toString()) && !"Mes".equals(this.JCFECHAING2.getSelectedItem().toString()) && !"Año".equals(this.JCFECHAING3.getSelectedItem().toString()) && !"Día".equals(this.JCFECHANAC1.getSelectedItem().toString()) && !"Mes".equals(this.JCFECHANAC2.getSelectedItem().toString()) && !"Año".equals(this.JCFECHANAC3.getSelectedItem().toString()) && !"Seleccionar Comuna".equals(this.JCCOMUNA.getSelectedItem().toString()))        {
                int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Guardar?", "Mensajero", JOptionPane.YES_NO_CANCEL_OPTION);
                //n = 0 es YES, n = 1 es NO, n = 2 es Cancel
                System.out.println("numero" + JOptionPane.YES_NO_CANCEL_OPTION);
                    if (n == 0) {                
                        try {                    
                            p.setCONTRASENA(CONTRASENA);
                            c.actualizarAdminstrador(p);
                            ResetearCampos();
                            JOptionPane.showMessageDialog(null, "Datos Ingresados Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);                
                            contador = 0;
                            contador2 = 0;
                            DeshabilitarCampos();
                            } catch (Exception e) {
                                e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Se ha producido un error en la inserción", "Error", JOptionPane.ERROR_MESSAGE);                
                                }        
                            JPanelImagen.removeAll();        
                            JPanelImagen.repaint();                
                        }
            
                    else if (n == 1) {
                    ResetearCampos();
                        }            
                    }
            
                    else{
                    JOptionPane.showMessageDialog(null,"Codigo: " +"Debe llenartodos los campos solicitados", "Error", JOptionPane.ERROR_MESSAGE); 
                    }
                }        
        else if(TIPOCUENTA.equals("Mecanico")){
            if (!"Seleccionar Tipo Cuenta".equals(this.jCBTipoCuenta.getSelectedItem().toString()) && this.JFRUT.getText().trim() != null && this.JFNOMBRE.getText().trim() != null && this.JFAPEPA.getText().trim() != null && this.JFAPEMA.getText().trim() != null && this.JFDIRE.getText().trim() != null && this.JFTELE.getText().trim() != null && this.JFEMAIL.getText().trim() != null && this.JTDETALLE.getText().trim() != null && !"Día".equals(this.JCFECHAING1.getSelectedItem().toString()) && !"Mes".equals(this.JCFECHAING2.getSelectedItem().toString()) && !"Año".equals(this.JCFECHAING3.getSelectedItem().toString()) && !"Día".equals(this.JCFECHANAC1.getSelectedItem().toString()) && !"Mes".equals(this.JCFECHANAC2.getSelectedItem().toString()) && !"Año".equals(this.JCFECHANAC3.getSelectedItem().toString()) && !"Seleccionar Comuna".equals(this.JCCOMUNA.getSelectedItem().toString()))        {
                int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Guardar?", "Mensajero", JOptionPane.YES_NO_CANCEL_OPTION);
                //n = 0 es YES, n = 1 es NO, n = 2 es Cancel
                System.out.println("numero" + JOptionPane.YES_NO_CANCEL_OPTION);
                if (n == 0) {               
                    try {
                        c.actualizarMecanico(p);
                        ResetearCampos();
                        JOptionPane.showMessageDialog(null, "Datos Ingresados Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);                            
                        contador = 0;
                        contador2 = 0;
                        DeshabilitarCampos();
                        }
                    
                    catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Se ha producido un error en la inserción", "Error", JOptionPane.ERROR_MESSAGE);
                        }                    
                        JPanelImagen.removeAll();                        
                        JPanelImagen.repaint();
            }
                
                else if (n == 1) {
                    ResetearCampos();
                    }
                }
                
        else{
                JOptionPane.showMessageDialog(null,"Codigo: " +"Debe llenartodos los campos solicitados", "Error", JOptionPane.ERROR_MESSAGE); 
                }                
            }        
        
        else if(TIPOCUENTA.equals("Conductor")){
            if (!"Seleccionar Tipo Cuenta".equals(this.jCBTipoCuenta.getSelectedItem().toString()) && this.JFRUT.getText().trim() != null && this.JFCONTRASENA.getText().trim() != null && this.JFNOMBRE.getText().trim() != null && this.JFAPEPA.getText().trim() != null && this.JFAPEMA.getText().trim() != null && this.JFDIRE.getText().trim() != null && this.JFTELE.getText().trim() != null && this.JFEMAIL.getText().trim() != null && this.JFNUMRADIO.getText().trim() != null && this.JTDETALLE.getText().trim() != null && !"Día".equals(this.JCFECHAING1.getSelectedItem().toString()) && !"Mes".equals(this.JCFECHAING2.getSelectedItem().toString()) && !"Año".equals(this.JCFECHAING3.getSelectedItem().toString()) && !"Día".equals(this.JCFECHANAC1.getSelectedItem().toString()) && !"Mes".equals(this.JCFECHANAC2.getSelectedItem().toString()) && !"Año".equals(this.JCFECHANAC3.getSelectedItem().toString()) && !"Seleccionar Comuna".equals(this.JCCOMUNA.getSelectedItem().toString()))        {
                int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Guardar?", "Mensajero", JOptionPane.YES_NO_CANCEL_OPTION);
                //n = 0 es YES, n = 1 es NO, n = 2 es Cancel
                System.out.println("numero" + JOptionPane.YES_NO_CANCEL_OPTION);
                if (n == 0) {               
                    try {
                        p.setRADIO(Integer.parseInt(NUM_RADIO));
                        p.setLICENCIA(LICENCIA);
                        c.actualizarConductor(p);
                        ResetearCampos();
                        JOptionPane.showMessageDialog(null, "Datos Ingresados Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);                            
                        contador = 0;
                        contador2 = 0;
                        DeshabilitarCampos();
                        }
                    
                    catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Se ha producido un error en la inserción", "Error", JOptionPane.ERROR_MESSAGE);
                        }                    
                        JPanelImagen.removeAll();                        
                        JPanelImagen.repaint();
            }
                
                else if (n == 1) {
                    ResetearCampos();
                    }
                }
                
        else{
                JOptionPane.showMessageDialog(null,"Codigo: " +"Debe llenartodos los campos solicitados", "Error", JOptionPane.ERROR_MESSAGE); 
                }  
            
        }
        else if(TIPOCUENTA.equals("Encargado Bodega")){
            if (!"Seleccionar Tipo Cuenta".equals(this.jCBTipoCuenta.getSelectedItem().toString()) && this.JFRUT.getText().trim() != null && this.JFCONTRASENA.getText().trim() != null && this.JFNOMBRE.getText().trim() != null && this.JFAPEPA.getText().trim() != null && this.JFAPEMA.getText().trim() != null && this.JFDIRE.getText().trim() != null && this.JFTELE.getText().trim() != null && this.JFEMAIL.getText().trim() != null && this.JFNUMRADIO.getText().trim() != null && this.JTDETALLE.getText().trim() != null && !"Día".equals(this.JCFECHAING1.getSelectedItem().toString()) && !"Mes".equals(this.JCFECHAING2.getSelectedItem().toString()) && !"Año".equals(this.JCFECHAING3.getSelectedItem().toString()) && !"Día".equals(this.JCFECHANAC1.getSelectedItem().toString()) && !"Mes".equals(this.JCFECHANAC2.getSelectedItem().toString()) && !"Año".equals(this.JCFECHANAC3.getSelectedItem().toString()) && !"Seleccionar Comuna".equals(this.JCCOMUNA.getSelectedItem().toString()))        {
                int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Guardar?", "Mensajero", JOptionPane.YES_NO_CANCEL_OPTION);
                //n = 0 es YES, n = 1 es NO, n = 2 es Cancel
                System.out.println("numero" + JOptionPane.YES_NO_CANCEL_OPTION);
                if (n == 0) {               
                    try {
                        p.setCONTRASENA(CONTRASENA);
                        c.actualizarEncargadoB(p);
                        ResetearCampos();
                        JOptionPane.showMessageDialog(null, "Datos Ingresados Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);                            
                        contador = 0;
                        contador2 = 0;
                        DeshabilitarCampos();
                        }
                    
                    catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Se ha producido un error en la inserción", "Error", JOptionPane.ERROR_MESSAGE);
                        }                    
                        JPanelImagen.removeAll();                        
                        JPanelImagen.repaint();
            }
                
                else if (n == 1) {
                    ResetearCampos();
                    }
                }
                
        else{
                JOptionPane.showMessageDialog(null,"Codigo: " +"Debe llenartodos los campos solicitados", "Error", JOptionPane.ERROR_MESSAGE); 
                }  
            
            }
        }
        else{
            //aqui no hago nada
            if (TIPOCUENTA.equals("Administrador")){
                if (!"Seleccionar Tipo Cuenta".equals(this.jCBTipoCuenta.getSelectedItem().toString()) && this.JFRUT.getText().trim() != null && this.JFCONTRASENA.getText().trim() != null && this.JFNOMBRE.getText().trim() != null && this.JFAPEPA.getText().trim() != null && this.JFAPEMA.getText().trim() != null && this.JFDIRE.getText().trim() != null && this.JFTELE.getText().trim() != null && this.JFEMAIL.getText().trim() != null && this.JTDETALLE.getText().trim() != null && !"Día".equals(this.JCFECHAING1.getSelectedItem().toString()) && !"Mes".equals(this.JCFECHAING2.getSelectedItem().toString()) && !"Año".equals(this.JCFECHAING3.getSelectedItem().toString()) && !"Día".equals(this.JCFECHANAC1.getSelectedItem().toString()) && !"Mes".equals(this.JCFECHANAC2.getSelectedItem().toString()) && !"Año".equals(this.JCFECHANAC3.getSelectedItem().toString()) && !"Seleccionar Comuna".equals(this.JCCOMUNA.getSelectedItem().toString()))        {
                int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Guardar?", "Mensajero", JOptionPane.YES_NO_CANCEL_OPTION);
                //n = 0 es YES, n = 1 es NO, n = 2 es Cancel
                System.out.println("numero" + JOptionPane.YES_NO_CANCEL_OPTION);
                    if (n == 0) {                
                        try {                    
                            p.setCONTRASENA(CONTRASENA);
                            c.registrarAdministrador(p);
                            ResetearCampos();
                            JOptionPane.showMessageDialog(null, "Datos Ingresados Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);                
                            contador = 0;
                            contador2 = 0;
                            DeshabilitarCampos();
                            } catch (Exception e) {
                                e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Se ha producido un error en la inserción", "Error", JOptionPane.ERROR_MESSAGE);                
                                }        
                            JPanelImagen.removeAll();        
                            JPanelImagen.repaint();                
                        }
            
                    else if (n == 1) {
                    ResetearCampos();
                        }            
                    }
            
                    else{
                    JOptionPane.showMessageDialog(null,"Codigo: " +"Debe llenartodos los campos solicitados", "Error", JOptionPane.ERROR_MESSAGE); 
                    }
                }        
        else if(TIPOCUENTA.equals("Mecanico")){
            if (!"Seleccionar Tipo Cuenta".equals(this.jCBTipoCuenta.getSelectedItem().toString()) && this.JFRUT.getText().trim() != null && this.JFNOMBRE.getText().trim() != null && this.JFAPEPA.getText().trim() != null && this.JFAPEMA.getText().trim() != null && this.JFDIRE.getText().trim() != null && this.JFTELE.getText().trim() != null && this.JFEMAIL.getText().trim() != null && this.JTDETALLE.getText().trim() != null && !"Día".equals(this.JCFECHAING1.getSelectedItem().toString()) && !"Mes".equals(this.JCFECHAING2.getSelectedItem().toString()) && !"Año".equals(this.JCFECHAING3.getSelectedItem().toString()) && !"Día".equals(this.JCFECHANAC1.getSelectedItem().toString()) && !"Mes".equals(this.JCFECHANAC2.getSelectedItem().toString()) && !"Año".equals(this.JCFECHANAC3.getSelectedItem().toString()) && !"Seleccionar Comuna".equals(this.JCCOMUNA.getSelectedItem().toString()))        {
                int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Guardar?", "Mensajero", JOptionPane.YES_NO_CANCEL_OPTION);
                //n = 0 es YES, n = 1 es NO, n = 2 es Cancel
                System.out.println("numero" + JOptionPane.YES_NO_CANCEL_OPTION);
                if (n == 0) {               
                    try {
                        c.registrarMecanico(p);
                        ResetearCampos();
                        JOptionPane.showMessageDialog(null, "Datos Ingresados Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);                            
                        contador = 0;
                        contador2 = 0;
                        DeshabilitarCampos();
                        }
                    
                    catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Se ha producido un error en la inserción", "Error", JOptionPane.ERROR_MESSAGE);
                        }                    
                        JPanelImagen.removeAll();                        
                        JPanelImagen.repaint();
            }
                
                else if (n == 1) {
                    ResetearCampos();
                    }
                }
                
        else{
                JOptionPane.showMessageDialog(null,"Codigo: " +"Debe llenartodos los campos solicitados", "Error", JOptionPane.ERROR_MESSAGE); 
                }                
            }        
        
        else if(TIPOCUENTA.equals("Conductor")){
            if (!"Seleccionar Tipo Cuenta".equals(this.jCBTipoCuenta.getSelectedItem().toString()) && this.JFRUT.getText().trim() != null && this.JFCONTRASENA.getText().trim() != null && this.JFNOMBRE.getText().trim() != null && this.JFAPEPA.getText().trim() != null && this.JFAPEMA.getText().trim() != null && this.JFDIRE.getText().trim() != null && this.JFTELE.getText().trim() != null && this.JFEMAIL.getText().trim() != null && this.JFNUMRADIO.getText().trim() != null && this.JTDETALLE.getText().trim() != null && !"Día".equals(this.JCFECHAING1.getSelectedItem().toString()) && !"Mes".equals(this.JCFECHAING2.getSelectedItem().toString()) && !"Año".equals(this.JCFECHAING3.getSelectedItem().toString()) && !"Día".equals(this.JCFECHANAC1.getSelectedItem().toString()) && !"Mes".equals(this.JCFECHANAC2.getSelectedItem().toString()) && !"Año".equals(this.JCFECHANAC3.getSelectedItem().toString()) && !"Seleccionar Comuna".equals(this.JCCOMUNA.getSelectedItem().toString()))        {
                int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Guardar?", "Mensajero", JOptionPane.YES_NO_CANCEL_OPTION);
                //n = 0 es YES, n = 1 es NO, n = 2 es Cancel
                System.out.println("numero" + JOptionPane.YES_NO_CANCEL_OPTION);
                if (n == 0) {               
                    try {
                        p.setRADIO(Integer.parseInt(NUM_RADIO));
                        p.setLICENCIA(LICENCIA);
                        c.registrarConductor(p);
                        ResetearCampos();
                        JOptionPane.showMessageDialog(null, "Datos Ingresados Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);                            
                        contador = 0;
                        contador2 = 0;
                        DeshabilitarCampos();
                        }
                    
                    catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Se ha producido un error en la inserción", "Error", JOptionPane.ERROR_MESSAGE);
                        }                    
                        JPanelImagen.removeAll();                        
                        JPanelImagen.repaint();
            }
                
                else if (n == 1) {
                    ResetearCampos();
                    }
                }
                
        else{
                JOptionPane.showMessageDialog(null,"Codigo: " +"Debe llenartodos los campos solicitados", "Error", JOptionPane.ERROR_MESSAGE); 
                }  
            
        }
        else if(TIPOCUENTA.equals("Encargado Bodega")){
            if (!"Seleccionar Tipo Cuenta".equals(this.jCBTipoCuenta.getSelectedItem().toString()) && this.JFRUT.getText().trim() != null && this.JFCONTRASENA.getText().trim() != null && this.JFNOMBRE.getText().trim() != null && this.JFAPEPA.getText().trim() != null && this.JFAPEMA.getText().trim() != null && this.JFDIRE.getText().trim() != null && this.JFTELE.getText().trim() != null && this.JFEMAIL.getText().trim() != null && this.JFNUMRADIO.getText().trim() != null && this.JTDETALLE.getText().trim() != null && !"Día".equals(this.JCFECHAING1.getSelectedItem().toString()) && !"Mes".equals(this.JCFECHAING2.getSelectedItem().toString()) && !"Año".equals(this.JCFECHAING3.getSelectedItem().toString()) && !"Día".equals(this.JCFECHANAC1.getSelectedItem().toString()) && !"Mes".equals(this.JCFECHANAC2.getSelectedItem().toString()) && !"Año".equals(this.JCFECHANAC3.getSelectedItem().toString()) && !"Seleccionar Comuna".equals(this.JCCOMUNA.getSelectedItem().toString()))        {
                int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Guardar?", "Mensajero", JOptionPane.YES_NO_CANCEL_OPTION);
                //n = 0 es YES, n = 1 es NO, n = 2 es Cancel
                System.out.println("numero" + JOptionPane.YES_NO_CANCEL_OPTION);
                if (n == 0) {               
                    try {
                        p.setCONTRASENA(CONTRASENA);
                        c.registrarEncargadoBodega(p);
                        ResetearCampos();
                        JOptionPane.showMessageDialog(null, "Datos Ingresados Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);                            
                        contador = 0;
                        contador2 = 0;
                        DeshabilitarCampos();
                        }
                    
                    catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Se ha producido un error en la inserción", "Error", JOptionPane.ERROR_MESSAGE);
                        }                    
                        JPanelImagen.removeAll();                        
                        JPanelImagen.repaint();
            }
                
                else if (n == 1) {
                    ResetearCampos();
                    }
                }
                
        else{
                JOptionPane.showMessageDialog(null,"Codigo: " +"Debe llenartodos los campos solicitados", "Error", JOptionPane.ERROR_MESSAGE); 
                }  
            
            }
        }
        
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        JCTipoPersonal = new javax.swing.JComboBox();
        JBCargar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jCBTipoCuenta = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        JCFECHANAC3 = new javax.swing.JComboBox();
        JCFECHANAC1 = new javax.swing.JComboBox();
        JCFECHANAC2 = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JFNUMRADIO = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTDETALLE = new javax.swing.JTextArea();
        JPanelImagen = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        JCFECHAING2 = new javax.swing.JComboBox();
        JCFECHAING1 = new javax.swing.JComboBox();
        JCFECHAING3 = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        JFAPEPA = new javax.swing.JFormattedTextField();
        JFNOMBRE = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        JFRUT = new javax.swing.JFormattedTextField();
        JFDIRE = new javax.swing.JFormattedTextField();
        JFTELE = new javax.swing.JFormattedTextField();
        JFEMAIL = new javax.swing.JFormattedTextField();
        JCCOMUNA = new javax.swing.JComboBox();
        JFAPEMA = new javax.swing.JFormattedTextField();
        JBGUARDAR = new javax.swing.JButton();
        JFTIPOLICENCIA = new javax.swing.JFormattedTextField();
        JFCONTRASENA = new javax.swing.JPasswordField();
        jLabel24 = new javax.swing.JLabel();
        JFCONTRASENA1 = new javax.swing.JPasswordField();
        JFComunaID = new javax.swing.JTextField();
        JBBorrar = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jFileChooser.setName("jFileChooser"); // NOI18N

        setClosable(true);
        setIconifiable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(soprafamrv.SOPRAFAMRVApp0.class).getContext().getResourceMap(Personal.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 700));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel3.border.title"))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel2.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel2.border.titleColor"))); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        JCTipoPersonal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo Personal", "Administradores", "Conductores", "Mecánicos", "Encargados Bodega" }));
        JCTipoPersonal.setName("JCTipoPersonal"); // NOI18N
        JCTipoPersonal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCTipoPersonalItemStateChanged(evt);
            }
        });

        JBCargar.setText(resourceMap.getString("JBCargar.text")); // NOI18N
        JBCargar.setName("JBCargar"); // NOI18N
        JBCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCargarActionPerformed(evt);
            }
        });

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.setName("tabla");
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);
        tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCTipoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(JBCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(JCTipoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBCargar)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel1.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel1.border.titleColor"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        jLabel14.setText(resourceMap.getString("jLabel14.text")); // NOI18N
        jLabel14.setName("jLabel14"); // NOI18N

        jLabel13.setText(resourceMap.getString("jLabel13.text")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N

        jLabel12.setText(resourceMap.getString("jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N

        jCBTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar Tipo Cuenta", "Administrador", "Conductor", "Mecanico", "Encargado Bodega" }));
        jCBTipoCuenta.setEnabled(false);
        jCBTipoCuenta.setName("jCBTipoCuenta"); // NOI18N
        jCBTipoCuenta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBTipoCuentaItemStateChanged(evt);
            }
        });
        jCBTipoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTipoCuentaActionPerformed(evt);
            }
        });

        jLabel23.setText(resourceMap.getString("jLabel23.text")); // NOI18N
        jLabel23.setName("jLabel23"); // NOI18N

        JCFECHANAC3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Año" }));
        JCFECHANAC3.setEnabled(false);
        JCFECHANAC3.setName("JCFECHANAC3"); // NOI18N

        JCFECHANAC1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Día", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        JCFECHANAC1.setEnabled(false);
        JCFECHANAC1.setName("JCFECHANAC1"); // NOI18N

        JCFECHANAC2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mes", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
        JCFECHANAC2.setEnabled(false);
        JCFECHANAC2.setName("JCFECHANAC2"); // NOI18N

        jLabel22.setText(resourceMap.getString("jLabel22.text")); // NOI18N
        jLabel22.setName("jLabel22"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        JFNUMRADIO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("########"))));
        JFNUMRADIO.setEnabled(false);
        JFNUMRADIO.setName("JFNUMRADIO"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        JTDETALLE.setColumns(20);
        JTDETALLE.setLineWrap(true);
        JTDETALLE.setRows(5);
        JTDETALLE.setEnabled(false);
        JTDETALLE.setName("JTDETALLE"); // NOI18N
        jScrollPane1.setViewportView(JTDETALLE);

        JPanelImagen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("JPanelImagen.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("JPanelImagen.border.titleColor"))); // NOI18N
        JPanelImagen.setName("JPanelImagen"); // NOI18N

        javax.swing.GroupLayout JPanelImagenLayout = new javax.swing.GroupLayout(JPanelImagen);
        JPanelImagen.setLayout(JPanelImagenLayout);
        JPanelImagenLayout.setHorizontalGroup(
            JPanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );
        JPanelImagenLayout.setVerticalGroup(
            JPanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );

        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setEnabled(false);
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel18.setText(resourceMap.getString("jLabel18.text")); // NOI18N
        jLabel18.setName("jLabel18"); // NOI18N

        jLabel17.setText(resourceMap.getString("jLabel17.text")); // NOI18N
        jLabel17.setName("jLabel17"); // NOI18N

        JCFECHAING2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mes" }));
        JCFECHAING2.setEnabled(false);
        JCFECHAING2.setName("JCFECHAING2"); // NOI18N

        JCFECHAING1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Día" }));
        JCFECHAING1.setEnabled(false);
        JCFECHAING1.setName("JCFECHAING1"); // NOI18N

        JCFECHAING3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Año" }));
        JCFECHAING3.setEnabled(false);
        JCFECHAING3.setName("JCFECHAING3"); // NOI18N

        jLabel21.setText(resourceMap.getString("jLabel21.text")); // NOI18N
        jLabel21.setName("jLabel21"); // NOI18N

        try {
            JFAPEPA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("******************************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JFAPEPA.setEnabled(false);
        JFAPEPA.setName("JFAPEPA"); // NOI18N

        try {
            JFNOMBRE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("******************************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JFNOMBRE.setEnabled(false);
        JFNOMBRE.setName("JFNOMBRE"); // NOI18N

        jLabel15.setText(resourceMap.getString("jLabel15.text")); // NOI18N
        jLabel15.setName("jLabel15"); // NOI18N

        try {
            JFRUT.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-A")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JFRUT.setEnabled(false);
        JFRUT.setName("JFRUT"); // NOI18N
        JFRUT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JFRUTFocusLost(evt);
            }
        });

        try {
            JFDIRE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("******************************************************************************************************************************************************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JFDIRE.setEnabled(false);
        JFDIRE.setName("JFDIRE"); // NOI18N

        try {
            JFTELE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JFTELE.setEnabled(false);
        JFTELE.setName("JFTELE"); // NOI18N

        try {
            JFEMAIL.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("******************************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JFEMAIL.setEnabled(false);
        JFEMAIL.setName("JFEMAIL"); // NOI18N

        JCCOMUNA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar Comuna" }));
        JCCOMUNA.setEnabled(false);
        JCCOMUNA.setName("JCCOMUNA"); // NOI18N
        JCCOMUNA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JCCOMUNAMouseClicked(evt);
            }
        });
        JCCOMUNA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCCOMUNAItemStateChanged(evt);
            }
        });
        JCCOMUNA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JCCOMUNAFocusLost(evt);
            }
        });

        try {
            JFAPEMA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("******************************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JFAPEMA.setEnabled(false);
        JFAPEMA.setName("JFAPEMA"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(soprafamrv.SOPRAFAMRVApp0.class).getContext().getActionMap(Personal.class, this);
        JBGUARDAR.setAction(actionMap.get("Guardar")); // NOI18N
        JBGUARDAR.setText(resourceMap.getString("JBGUARDAR.text")); // NOI18N
        JBGUARDAR.setName("JBGUARDAR"); // NOI18N
        JBGUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBGUARDARActionPerformed(evt);
            }
        });

        try {
            JFTIPOLICENCIA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JFTIPOLICENCIA.setEnabled(false);
        JFTIPOLICENCIA.setName("JFTIPOLICENCIA"); // NOI18N

        JFCONTRASENA.setText(resourceMap.getString("JFCONTRASENA.text")); // NOI18N
        JFCONTRASENA.setEnabled(false);
        JFCONTRASENA.setName("JFCONTRASENA"); // NOI18N
        JFCONTRASENA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JFCONTRASENAFocusLost(evt);
            }
        });

        jLabel24.setText(resourceMap.getString("jLabel24.text")); // NOI18N
        jLabel24.setName("jLabel24"); // NOI18N

        JFCONTRASENA1.setEnabled(false);
        JFCONTRASENA1.setName("JFCONTRASENA1"); // NOI18N
        JFCONTRASENA1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JFCONTRASENA1FocusLost(evt);
            }
        });

        JFComunaID.setEditable(false);
        JFComunaID.setText(resourceMap.getString("JFComunaID.text")); // NOI18N
        JFComunaID.setEnabled(false);
        JFComunaID.setName("JFComunaID"); // NOI18N

        JBBorrar.setText(resourceMap.getString("JBBorrar.text")); // NOI18N
        JBBorrar.setEnabled(false);
        JBBorrar.setName("JBBorrar"); // NOI18N
        JBBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBGUARDAR))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(JFNOMBRE, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JFCONTRASENA1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JFCONTRASENA, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JFRUT, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCBTipoCuenta, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(JCCOMUNA, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JFEMAIL, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JFTELE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JFComunaID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(JFDIRE, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                                        .addComponent(JFAPEPA, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JFAPEMA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JFTIPOLICENCIA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JFNUMRADIO, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JCFECHANAC1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JCFECHAING1, 0, 50, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCFECHAING2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JCFECHANAC2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JCFECHAING3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JCFECHANAC3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel15)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                .addComponent(JPanelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(212, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPanelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBGUARDAR)
                    .addComponent(JBBorrar))
                .addGap(38, 38, 38))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JFRUT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JFCONTRASENA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JFCONTRASENA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JFNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JFAPEPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JFAPEMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JFDIRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(JFTELE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JFEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCCOMUNA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(JFComunaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(JCFECHAING1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(JCFECHAING2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(JCFECHAING3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(JCFECHANAC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(JCFECHANAC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(JCFECHANAC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JFNUMRADIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JFTIPOLICENCIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(146, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(140, 140, 140))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setName("jButton1"); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setName("jButton2"); // NOI18N
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setName("jButton4"); // NOI18N
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (contador == 2){
            subeImagen m = new subeImagen();
            m.Abrir_Dialogo(JPanelImagen);
            contador2 = 1;
        }
        else{
        subeImagen m = new subeImagen();
        m.Abrir_Dialogo(JPanelImagen);
        contador2 = 2;
        }
}//GEN-LAST:event_jButton3ActionPerformed

    private void JFRUTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JFRUTFocusLost

        personal p = new personal();
        String p1 = this.JFRUT.getText().substring(0, 2);
        String p2 = this.JFRUT.getText().substring(3, 6);
        String p3 = this.JFRUT.getText().substring(7, 10);
        char dv = this.JFRUT.getText().charAt(11);
        int rut = Integer.parseInt(p1 + p2 + p3);

        if (!p.verificarRut(rut, dv)) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un RUT Válido", "Error", JOptionPane.ERROR_MESSAGE);
            this.JFRUT.setText(null);
        }

    }//GEN-LAST:event_JFRUTFocusLost

    private void JBGUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGUARDARActionPerformed
    }//GEN-LAST:event_JBGUARDARActionPerformed

    private void jCBTipoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipoCuentaActionPerformed
    }//GEN-LAST:event_jCBTipoCuentaActionPerformed

    private void jCBTipoCuentaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBTipoCuentaItemStateChanged
        if (this.jCBTipoCuenta.getSelectedItem() == "Conductor") {
            this.JFNUMRADIO.setVisible(true);
            this.JFTIPOLICENCIA.setVisible(true);
            this.jLabel13.setVisible(true);
            this.jLabel14.setVisible(true);
            this.JFCONTRASENA.setVisible(false);
            this.JFCONTRASENA1.setVisible(false);
            this.jLabel2.setVisible(false);
            this.jLabel24.setVisible(false);
            }
        else if(this.jCBTipoCuenta.getSelectedItem() == "Mecanico"){
            this.JFNUMRADIO.setVisible(false);
            this.JFTIPOLICENCIA.setVisible(false);
            this.jLabel13.setVisible(false);
            this.jLabel14.setVisible(false);            
            this.JFCONTRASENA.setVisible(false);
            this.JFCONTRASENA1.setVisible(false);
            this.jLabel2.setVisible(false);
            this.jLabel24.setVisible(false);
        }
        else {
            this.JFNUMRADIO.setVisible(false);
            this.JFTIPOLICENCIA.setVisible(false);
            this.jLabel13.setVisible(false);
            this.jLabel14.setVisible(false);
            this.JFCONTRASENA.setVisible(true);
            this.JFCONTRASENA1.setVisible(true);
            this.jLabel2.setVisible(true);
            this.jLabel24.setVisible(true);

        }
    }//GEN-LAST:event_jCBTipoCuentaItemStateChanged

    private void JCTipoPersonalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCTipoPersonalItemStateChanged

        if (this.JCTipoPersonal.getSelectedItem() == "Conductores") {
            try {
                String query = "Select * from DatosConductor";
                ResultSet rs = Conexion.ejecutarQuery(query);
                personal.llenarTabla(tabla, rs);
                
            } catch (SQLException ex) {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (this.JCTipoPersonal.getSelectedItem() == "Administradores") {
            try {

                String query = "Select * from DatosAdministrador";
                ResultSet rs = Conexion.ejecutarQuery(query);
                personal.llenarTabla(tabla, rs);

            } catch (SQLException ex) {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (this.JCTipoPersonal.getSelectedItem() == "Mecánicos") {
            try {
                String query = "Select * from DatosMecanico";
                ResultSet rs = Conexion.ejecutarQuery(query);
                personal.llenarTabla(tabla, rs);

            } catch (SQLException ex) {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (this.JCTipoPersonal.getSelectedItem() == "Encargados Bodega") {
            try {
                String query = "Select * from DatosEncargadoBodega";
                ResultSet rs = Conexion.ejecutarQuery(query);
                personal.llenarTabla(tabla, rs);

            } catch (SQLException ex) {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        else {
        }

    }//GEN-LAST:event_JCTipoPersonalItemStateChanged

    private void JBCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCargarActionPerformed
        String NOMBRE = null;
        String CONTRASENA = null;
        String APEPA = null;
        String APEMA = null;
        String DIRE = null;
        int TELEFONO = 0;
        String EMAIL = null;
        int IDCOMUNA = 0;
        String FECHAIN = null;
        String FECHARE = null;
        String FECHANA = null;
        int RADIO = 0;
        String LICENCIA = null;
        String DETALLE = null;
        byte[] FOTOByte;
                
        //CONDUCTORES
        if (this.JCTipoPersonal.getSelectedItem() == "Conductores") {
            try {
                DeshabilitarCampos();
                String RUT = (String) this.tabla.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
                Connection con = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.clave);
                OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("BEGIN CargaConductores(?,?,?,?,?,?,?,?,?,?,?,?,?,?); END;");

                System.out.println("***INICIO CARGA CONDUCTOR***");
                System.out.println("Setiando Parametros ENTRADA");
                cs.setString(1, RUT);

                System.out.println("Setiando Parametros SALIDA");
                cs.registerOutParameter(2, Types.VARCHAR);
                cs.registerOutParameter(3, Types.VARCHAR);
                cs.registerOutParameter(4, Types.VARCHAR);
                cs.registerOutParameter(5, Types.VARCHAR);
                cs.registerOutParameter(6, Types.INTEGER);
                cs.registerOutParameter(7, Types.VARCHAR);
                cs.registerOutParameter(8, Types.INTEGER);
                cs.registerOutParameter(9, Types.DATE);
                cs.registerOutParameter(10, Types.DATE);                
                cs.registerOutParameter(11, Types.INTEGER);
                cs.registerOutParameter(12, Types.CHAR);
                cs.registerOutParameter(13, Types.VARCHAR);
                cs.registerOutParameter(14, Types.BLOB);
                                
                cs.execute();
                
                //Asignacion a las variables
                NOMBRE = cs.getOracleObject(2).stringValue();
                APEPA = cs.getOracleObject(3).stringValue();
                APEMA = cs.getOracleObject(4).stringValue();
                DIRE = cs.getOracleObject(5).stringValue();
                TELEFONO = cs.getOracleObject(6).intValue();
                EMAIL = cs.getOracleObject(7).stringValue();
                IDCOMUNA = cs.getOracleObject(8).intValue();
                String NOMBRE_COMUNA = null;
                String query = "Select nombre from comuna where id_comuna="+IDCOMUNA+"";
                ResultSet rs = Conexion.ejecutarQuery(query);
                while (rs.next()){
                    NOMBRE_COMUNA = rs.getString("nombre");
                }
                FECHAIN = cs.getOracleObject(9).stringValue();                
                FECHANA = cs.getOracleObject(10).stringValue();
                RADIO = cs.getOracleObject(11).intValue();
                LICENCIA = cs.getOracleObject(12).stringValue();
                DETALLE = cs.getOracleObject(13).stringValue();                                
                FOTOByte = cs.getBytes(14);
                InputStream z = new ByteArrayInputStream(FOTOByte);
                BufferedImage FOTO = ImageIO.read(z);
                
                IMAGEN = FOTOByte;
                
                String FECHA_INGRESO = FECHAIN.substring(0, 9);
                String FECHA_NACIMIENTO = FECHANA.substring(0, 9);
                String dateParts1[] = FECHA_INGRESO.split("/");
                String dateParts2[] = FECHA_NACIMIENTO.split("/");
                String month  = dateParts1[0];
                String day  = dateParts1[1];
                String year = dateParts1[2];
                String month2  = dateParts2[0];
                String day2  = dateParts2[1];
                String year2 = dateParts2[2];
                System.out.println ("FECHAINGRESO sin java sql: " +month);
                System.out.println ("FECHAINGRESO sin java sql: " +day);
                System.out.println ("FECHAINGRESO sin java sql: " +year);
                
                System.out.println ("FECHAINGRESO sin java sql: " +month2);
                System.out.println ("FECHAINGRESO sin java sql: " +day2);
                System.out.println ("FECHAINGRESO sin java sql: " +year2);
                String mes = retornarMes(month);
                String mes2 = retornarMes(month2);
                
                System.out.println("IMPRIMIENDO FOTO: "+FOTO);
                //Hasta aqui el codigo funciona bien!
                System.out.println(NOMBRE);
                System.out.println(APEPA);
                System.out.println(APEMA);
                System.out.println(DIRE);
                System.out.println(TELEFONO);
                System.out.println(EMAIL);
                System.out.println(IDCOMUNA);
                System.out.println(FECHAIN);
                System.out.println(FECHARE);
                System.out.println(FECHANA);
                System.out.println(RADIO);
                System.out.println(LICENCIA);
                System.out.println(DETALLE);
                System.out.println(FOTO);
                System.out.println("TERMINO CARGA CONDUCTOR");
                
                personal p = new personal();
                p.setRUT(RUT);
                this.JFRUT.setText(RUT);
                this.JFNOMBRE.setText(NOMBRE.trim());
                this.JFAPEPA.setText(APEPA.trim());
                this.JFAPEMA.setText(APEMA.trim());
                this.JFDIRE.setText(DIRE.trim());
                this.JFTELE.setText(String.valueOf(TELEFONO));
                this.JFEMAIL.setText(EMAIL.trim());
                this.JFNUMRADIO.setText(String.valueOf(RADIO));
                this.JTDETALLE.setText(DETALLE.trim());
                this.jCBTipoCuenta.setSelectedIndex(2);
                this.JFTIPOLICENCIA.setText(LICENCIA);
                this.JCCOMUNA.setSelectedItem(NOMBRE_COMUNA);

                this.JCFECHAING1.removeAllItems();
                this.JCFECHAING1.addItem(day);
                this.JCFECHAING1.setSelectedIndex(0);
                
                this.JCFECHAING2.removeAllItems();
                this.JCFECHAING2.addItem(mes);
                this.JCFECHAING2.setSelectedIndex(0);
                
                this.JCFECHAING3.removeAllItems();
                this.JCFECHAING3.addItem(year);
                this.JCFECHAING3.setSelectedIndex(0);
                                               
                this.JCFECHANAC1.setSelectedItem(day2);
                this.JCFECHANAC2.setSelectedItem(mes2.toUpperCase());                                                
                this.JCFECHANAC3.setSelectedItem(Integer.parseInt(year2.trim()));
                
                JPanelImagen.add(new miPanel(FOTO, JPanelImagen.getSize()));
                JPanelImagen.setVisible(true);
                JPanelImagen.repaint();
                contador = 1;

            } catch (IOException ex) {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else if (this.JCTipoPersonal.getSelectedItem() == "Administradores") {
            try {
                DeshabilitarCampos();
                String RUT = (String) this.tabla.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
                Connection con = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.clave);
                OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("BEGIN CargaAdministradores(?,?,?,?,?,?,?,?,?,?,?,?,?); END;");

                System.out.println("***INICIO CARGA ADMINISTRADOR***");
                System.out.println("Setiando Parametros ENTRADA");
                cs.setString(1, RUT);

                System.out.println("Setiando Parametros SALIDA");
                cs.registerOutParameter(2, Types.VARCHAR);
                cs.registerOutParameter(3, Types.VARCHAR);
                cs.registerOutParameter(4, Types.VARCHAR);
                cs.registerOutParameter(5, Types.VARCHAR);
                cs.registerOutParameter(6, Types.VARCHAR);
                cs.registerOutParameter(7, Types.INTEGER);                
                cs.registerOutParameter(8, Types.VARCHAR);
                cs.registerOutParameter(9, Types.INTEGER);
                cs.registerOutParameter(10, Types.DATE);
                cs.registerOutParameter(11, Types.DATE);                                
                cs.registerOutParameter(12, Types.VARCHAR);
                cs.registerOutParameter(13, Types.BLOB);
                                
                cs.execute();
                
                //Asignacion a las variables
                NOMBRE = cs.getOracleObject(2).stringValue();
                CONTRASENA = cs.getOracleObject(3).stringValue();
                APEPA = cs.getOracleObject(4).stringValue();
                APEMA = cs.getOracleObject(5).stringValue();
                DIRE = cs.getOracleObject(6).stringValue();
                TELEFONO = cs.getOracleObject(7).intValue();
                EMAIL = cs.getOracleObject(8).stringValue();
                IDCOMUNA = cs.getOracleObject(9).intValue();
                String NOMBRE_COMUNA = null;
                String query = "Select nombre from comuna where id_comuna="+IDCOMUNA+"";
                ResultSet rs = Conexion.ejecutarQuery(query);
                while (rs.next()){
                    NOMBRE_COMUNA = rs.getString("nombre");
                }
                FECHAIN = cs.getOracleObject(10).stringValue();                
                FECHANA = cs.getOracleObject(11).stringValue();                
                DETALLE = cs.getOracleObject(12).stringValue();                
                
                FOTOByte = cs.getBytes(13);
                InputStream z = new ByteArrayInputStream(FOTOByte);
                BufferedImage FOTO = ImageIO.read(z);
                
                IMAGEN = FOTOByte;
                
                String FECHA_INGRESO = FECHAIN.substring(0, 9);
                String FECHA_NACIMIENTO = FECHANA.substring(0, 9);
                String dateParts1[] = FECHA_INGRESO.split("/");
                String dateParts2[] = FECHA_NACIMIENTO.split("/");
                String month  = dateParts1[0];
                String day  = dateParts1[1];
                String year = dateParts1[2];
                String month2  = dateParts2[0];
                String day2  = dateParts2[1];
                String year2 = dateParts2[2];
                System.out.println ("FECHAINGRESO sin java sql: " +month);
                System.out.println ("FECHAINGRESO sin java sql: " +day);
                System.out.println ("FECHAINGRESO sin java sql: " +year);
                
                System.out.println ("FECHAINGRESO sin java sql: " +month2);
                System.out.println ("FECHAINGRESO sin java sql: " +day2);
                System.out.println ("FECHAINGRESO sin java sql: " +year2);
                String mes = retornarMes(month);
                String mes2 = retornarMes(month2);
                
                
                System.out.println("IMPRIMIENDO FOTO: "+FOTO);
                //Hasta aqui el codigo funciona bien!
                System.out.println(NOMBRE);
                System.out.println(CONTRASENA);
                System.out.println(APEPA);
                System.out.println(APEMA);
                System.out.println(DIRE);
                System.out.println(TELEFONO);
                System.out.println(EMAIL);
                System.out.println(IDCOMUNA);
                System.out.println(FECHAIN);                
                System.out.println(FECHANA);                
                System.out.println(DETALLE);
                System.out.println(FOTO);
                System.out.println("TERMINO CARGA ADMINISTRADOR");
                
                personal p = new personal();
                p.setRUT(RUT);
                this.JFRUT.setText(RUT);
                this.JFNOMBRE.setText(NOMBRE.trim());
                this.JFAPEPA.setText(APEPA.trim());
                this.JFAPEMA.setText(APEMA.trim());
                this.JFDIRE.setText(DIRE.trim());
                this.JFTELE.setText(String.valueOf(TELEFONO));
                this.JFEMAIL.setText(EMAIL.trim());
                this.JFNUMRADIO.setText(String.valueOf(RADIO));
                this.JTDETALLE.setText(DETALLE.trim());
                this.jCBTipoCuenta.setSelectedIndex(1);                
                this.JCCOMUNA.setSelectedIndex(IDCOMUNA);
                this.JCFECHAING1.removeAllItems();
                this.JCFECHAING1.addItem(day);
                this.JCFECHAING1.setSelectedIndex(0);
                
                this.JCFECHAING2.removeAllItems();
                this.JCFECHAING2.addItem(mes);
                this.JCFECHAING2.setSelectedIndex(0);
                
                this.JCFECHAING3.removeAllItems();
                this.JCFECHAING3.addItem(year);
                this.JCFECHAING3.setSelectedIndex(0);
                                               
                this.JCFECHANAC1.setSelectedItem(day2);
                this.JCFECHANAC2.setSelectedItem(mes2.toUpperCase());                                                
                this.JCFECHANAC3.setSelectedItem(Integer.parseInt(year2.trim()));
                
                JPanelImagen.add(new miPanel(FOTO, JPanelImagen.getSize()));
                JPanelImagen.setVisible(true);
                JPanelImagen.repaint();
                contador = 1;

            } catch (IOException ex) {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
      }else if(this.JCTipoPersonal.getSelectedItem() == "Mecánicos"){
          try {
                DeshabilitarCampos();
                String RUT = (String) this.tabla.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
                Connection con = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.clave);
                OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("BEGIN CargaMecanicos(?,?,?,?,?,?,?,?,?,?,?,?); END;");

                System.out.println("***INICIO CARGA MECANICO***");
                System.out.println("Setiando Parametros ENTRADA");
                cs.setString(1, RUT);

                System.out.println("Setiando Parametros SALIDA");
                cs.registerOutParameter(2, Types.VARCHAR);                
                cs.registerOutParameter(3, Types.VARCHAR);
                cs.registerOutParameter(4, Types.VARCHAR);
                cs.registerOutParameter(5, Types.VARCHAR);
                cs.registerOutParameter(6, Types.INTEGER);                
                cs.registerOutParameter(7, Types.VARCHAR);
                cs.registerOutParameter(8, Types.INTEGER);
                cs.registerOutParameter(9, Types.DATE);
                cs.registerOutParameter(10, Types.DATE);                                
                cs.registerOutParameter(11, Types.VARCHAR);
                cs.registerOutParameter(12, Types.BLOB);
                                
                cs.execute();
                
                //Asignacion a las variables
                NOMBRE = cs.getOracleObject(2).stringValue();                
                APEPA = cs.getOracleObject(3).stringValue();
                APEMA = cs.getOracleObject(4).stringValue();
                DIRE = cs.getOracleObject(5).stringValue();
                TELEFONO = cs.getOracleObject(6).intValue();
                EMAIL = cs.getOracleObject(7).stringValue();
                IDCOMUNA = cs.getOracleObject(8).intValue();
                String NOMBRE_COMUNA = null;
                String query = "Select nombre from comuna where id_comuna="+IDCOMUNA+"";
                ResultSet rs = Conexion.ejecutarQuery(query);
                while (rs.next()){
                    NOMBRE_COMUNA = rs.getString("nombre");
                }
                FECHAIN = cs.getOracleObject(9).stringValue();                
                FECHANA = cs.getOracleObject(10).stringValue();                
                DETALLE = cs.getOracleObject(11).stringValue();                
               
                FOTOByte = cs.getBytes(12);
                InputStream z = new ByteArrayInputStream(FOTOByte);
                BufferedImage FOTO = ImageIO.read(z);
                
                IMAGEN = FOTOByte;
                
                String FECHA_INGRESO = FECHAIN.substring(0, 9);
                String FECHA_NACIMIENTO = FECHANA.substring(0, 9);
                String dateParts1[] = FECHA_INGRESO.split("/");
                String dateParts2[] = FECHA_NACIMIENTO.split("/");
                String month  = dateParts1[0];
                String day  = dateParts1[1];
                String year = dateParts1[2];
                String month2  = dateParts2[0];
                String day2  = dateParts2[1];
                String year2 = dateParts2[2];
                System.out.println ("FECHAINGRESO sin java sql: " +month);
                System.out.println ("FECHAINGRESO sin java sql: " +day);
                System.out.println ("FECHAINGRESO sin java sql: " +year);
                
                System.out.println ("FECHAINGRESO sin java sql: " +month2);
                System.out.println ("FECHAINGRESO sin java sql: " +day2);
                System.out.println ("FECHAINGRESO sin java sql: " +year2);
                String mes = retornarMes(month);
                String mes2 = retornarMes(month2);
                
                
                System.out.println("IMPRIMIENDO FOTO: "+FOTO);
                //Hasta aqui el codigo funciona bien!
                System.out.println(NOMBRE);                
                System.out.println(APEPA);
                System.out.println(APEMA);
                System.out.println(DIRE);
                System.out.println(TELEFONO);
                System.out.println(EMAIL);
                System.out.println(IDCOMUNA);
                System.out.println(FECHAIN);                
                System.out.println(FECHANA);                
                System.out.println(DETALLE);
                System.out.println(FOTO);
                System.out.println("TERMINO CARGA MECANICO");
                
                personal p = new personal();
                p.setRUT(RUT);
                this.JFRUT.setText(RUT);
                this.JFNOMBRE.setText(NOMBRE.trim());
                this.JFAPEPA.setText(APEPA.trim());
                this.JFAPEMA.setText(APEMA.trim());
                this.JFDIRE.setText(DIRE.trim());
                this.JFTELE.setText(String.valueOf(TELEFONO));
                this.JFEMAIL.setText(EMAIL.trim());                
                this.JTDETALLE.setText(DETALLE.trim());
                this.jCBTipoCuenta.setSelectedIndex(3);                
                this.JCCOMUNA.setSelectedIndex(IDCOMUNA);
                
                this.JCFECHAING1.removeAllItems();
                this.JCFECHAING1.addItem(day);
                this.JCFECHAING1.setSelectedIndex(0);
                
                this.JCFECHAING2.removeAllItems();
                this.JCFECHAING2.addItem(mes);
                this.JCFECHAING2.setSelectedIndex(0);
                
                this.JCFECHAING3.removeAllItems();
                this.JCFECHAING3.addItem(year);
                this.JCFECHAING3.setSelectedIndex(0);
                                               
                this.JCFECHANAC1.setSelectedItem(day2);
                this.JCFECHANAC2.setSelectedItem(mes2.toUpperCase());                                                
                this.JCFECHANAC3.setSelectedItem(Integer.parseInt(year2.trim()));
                
                JPanelImagen.add(new miPanel(FOTO, JPanelImagen.getSize()));
                JPanelImagen.setVisible(true);
                JPanelImagen.repaint();
                contador = 1;

            } catch (IOException ex) {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
      }else if(this.JCTipoPersonal.getSelectedItem() == "Encargados Bodega"){
          try {
                DeshabilitarCampos();
                String RUT = (String) this.tabla.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
                Connection con = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.clave);
                OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("BEGIN CargaEncargadoB(?,?,?,?,?,?,?,?,?,?,?,?,?); END;");

                System.out.println("***INICIO CARGA ENCARGADO BODEGA***");
                System.out.println("Setiando Parametros ENTRADA");
                cs.setString(1, RUT);

                System.out.println("Setiando Parametros SALIDA");
                cs.registerOutParameter(2, Types.VARCHAR);
                cs.registerOutParameter(3, Types.VARCHAR);
                cs.registerOutParameter(4, Types.VARCHAR);
                cs.registerOutParameter(5, Types.VARCHAR);
                cs.registerOutParameter(6, Types.VARCHAR);
                cs.registerOutParameter(7, Types.INTEGER);                
                cs.registerOutParameter(8, Types.VARCHAR);
                cs.registerOutParameter(9, Types.INTEGER);
                cs.registerOutParameter(10, Types.DATE);
                cs.registerOutParameter(11, Types.DATE);                                
                cs.registerOutParameter(12, Types.VARCHAR);
                cs.registerOutParameter(13, Types.BLOB);
                                
                cs.execute();
                
                //Asignacion a las variables
                NOMBRE = cs.getOracleObject(2).stringValue();
                CONTRASENA = cs.getOracleObject(3).stringValue();
                APEPA = cs.getOracleObject(4).stringValue();
                APEMA = cs.getOracleObject(5).stringValue();
                DIRE = cs.getOracleObject(6).stringValue();
                TELEFONO = cs.getOracleObject(7).intValue();
                EMAIL = cs.getOracleObject(8).stringValue();
                IDCOMUNA = cs.getOracleObject(9).intValue();
                String NOMBRE_COMUNA = null;
                String query = "Select nombre from comuna where id_comuna="+IDCOMUNA+"";
                ResultSet rs = Conexion.ejecutarQuery(query);
                while (rs.next()){
                    NOMBRE_COMUNA = rs.getString("nombre");
                }
                FECHAIN = cs.getOracleObject(10).stringValue();                
                FECHANA = cs.getOracleObject(11).stringValue();                
                DETALLE = cs.getOracleObject(12).stringValue();                
                
                FOTOByte = cs.getBytes(13);
                InputStream z = new ByteArrayInputStream(FOTOByte);
                BufferedImage FOTO = ImageIO.read(z);
                
                IMAGEN = FOTOByte;
                
                String FECHA_INGRESO = FECHAIN.substring(0, 9);
                String FECHA_NACIMIENTO = FECHANA.substring(0, 9);
                String dateParts1[] = FECHA_INGRESO.split("/");
                String dateParts2[] = FECHA_NACIMIENTO.split("/");
                String month  = dateParts1[0];
                String day  = dateParts1[1];
                String year = dateParts1[2];
                String month2  = dateParts2[0];
                String day2  = dateParts2[1];
                String year2 = dateParts2[2];
                System.out.println ("FECHAINGRESO sin java sql: " +month);
                System.out.println ("FECHAINGRESO sin java sql: " +day);
                System.out.println ("FECHAINGRESO sin java sql: " +year);
                
                System.out.println ("FECHAINGRESO sin java sql: " +month2);
                System.out.println ("FECHAINGRESO sin java sql: " +day2);
                System.out.println ("FECHAINGRESO sin java sql: " +year2);
                String mes = retornarMes(month);
                String mes2 = retornarMes(month2);
                
                
                System.out.println("IMPRIMIENDO FOTO: "+FOTO);
                //Hasta aqui el codigo funciona bien!
                System.out.println(NOMBRE);
                System.out.println(CONTRASENA);
                System.out.println(APEPA);
                System.out.println(APEMA);
                System.out.println(DIRE);
                System.out.println(TELEFONO);
                System.out.println(EMAIL);
                System.out.println(IDCOMUNA);
                System.out.println(FECHAIN);                
                System.out.println(FECHANA);                
                System.out.println(DETALLE);
                System.out.println(FOTO);
                System.out.println("TERMINO CARGA ENCARGADO BODEGA");
                
                personal p = new personal();
                p.setRUT(RUT);
                this.JFRUT.setText(RUT);
                this.JFNOMBRE.setText(NOMBRE.trim());                
                this.JFAPEPA.setText(APEPA.trim());
                this.JFAPEMA.setText(APEMA.trim());
                this.JFDIRE.setText(DIRE.trim());
                this.JFTELE.setText(String.valueOf(TELEFONO));
                this.JFEMAIL.setText(EMAIL.trim());
                this.JFNUMRADIO.setText(String.valueOf(RADIO));
                this.JTDETALLE.setText(DETALLE.trim());
                this.jCBTipoCuenta.setSelectedIndex(4);                
                this.JCCOMUNA.setSelectedIndex(IDCOMUNA);
                this.JCFECHAING1.removeAllItems();
                this.JCFECHAING1.addItem(day);
                this.JCFECHAING1.setSelectedIndex(0);
                
                this.JCFECHAING2.removeAllItems();
                this.JCFECHAING2.addItem(mes);
                this.JCFECHAING2.setSelectedIndex(0);
                
                this.JCFECHAING3.removeAllItems();
                this.JCFECHAING3.addItem(year);
                this.JCFECHAING3.setSelectedIndex(0);
                                               
                this.JCFECHANAC1.setSelectedItem(day2);
                this.JCFECHANAC2.setSelectedItem(mes2.toUpperCase());                                                
                this.JCFECHANAC3.setSelectedItem(Integer.parseInt(year2.trim()));
                
                JPanelImagen.add(new miPanel(FOTO, JPanelImagen.getSize()));
                JPanelImagen.setVisible(true);
                JPanelImagen.repaint();
                contador = 1;

            } catch (IOException ex) {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
      }
    }//GEN-LAST:event_JBCargarActionPerformed

    private void JCCOMUNAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCCOMUNAItemStateChanged
        if(this.JCCOMUNA.getSelectedIndex() != 0){
        try {
            
            String Nombre = (String) this.JCCOMUNA.getSelectedItem();

            OracleCallableStatement cs;
            Connection con = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.clave);
            cs = (OracleCallableStatement) con.prepareCall("BEGIN ObtenerComuna(?,?); END;");

            System.out.println("Setiando Parametros ENTRADA");
            cs.setString(1, Nombre);

            System.out.println("Setiando Parametros SALIDA");
            cs.registerOutParameter(2, Types.INTEGER);
            cs.execute();
            int ID_COMUNA = cs.getOracleObject(2).intValue();
            this.JFComunaID.setText(String.valueOf(ID_COMUNA));

            System.out.println(ID_COMUNA);
            System.out.println("Fin Operacion");


        } catch (SQLException ex) {
            Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else{
            this.JCCOMUNA.setSelectedIndex(48);
        }
    }//GEN-LAST:event_JCCOMUNAItemStateChanged

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
    }//GEN-LAST:event_formInternalFrameActivated

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
    }//GEN-LAST:event_jPanel1FocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         ResetearCampos();
         AsignarFechaIngreso();
         HabilitarCampos();    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaFocusGained

    }//GEN-LAST:event_tablaFocusGained

    private void JFCONTRASENA1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JFCONTRASENA1FocusLost
        if (!this.JFCONTRASENA.getText().equals(this.JFCONTRASENA1.getText())) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Mensajero", JOptionPane.WARNING_MESSAGE);
            this.JFCONTRASENA.setText(null);
            this.JFCONTRASENA1.setText(null);

        }

    }//GEN-LAST:event_JFCONTRASENA1FocusLost

    private void JFCONTRASENAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JFCONTRASENAFocusLost
        if (this.JFCONTRASENA.getText().length() < 6) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener un minimo de 6 caracteres", "Mensajero", JOptionPane.WARNING_MESSAGE);
            this.JFCONTRASENA.setText(null);
        }

    }//GEN-LAST:event_JFCONTRASENAFocusLost

    private void JBBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBorrarActionPerformed
            JPanelImagen.removeAll();
            JPanelImagen.repaint();    
}//GEN-LAST:event_JBBorrarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    if(contador == 1){
        this.jButton3.setEnabled(true);
        this.JBGUARDAR.setEnabled(true);
        this.JBBorrar.setEnabled(true);
        HabilitarCampos();
        this.JFRUT.setEnabled(false);
        contador = 2;
    }        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (contador == 1 || contador == 2){            
            if(this.jCBTipoCuenta.getSelectedItem() == "Administrador"){
                int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Eliminar?", "Mensajero", JOptionPane.YES_NO_OPTION);
                if (n == 0){
                    try {
                        System.out.println("IMPRIMIENDO N :" +n);
                        String RUT = this.JFRUT.getText();
                        Connection con = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.clave);
                        OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("BEGIN BorrarAdministrador(?); END;");
                        cs.setString(1, RUT);
                        cs.executeUpdate();
                        
                        ResetearCampos();   
                        JOptionPane.showMessageDialog(null, "Administrador Borrado Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);                                                        
                } catch (SQLException ex) {
                    Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else{
            System.out.println("IMPRIMIENDO N :" +n);
            ResetearCampos();
        }
    }
            else if (this.jCBTipoCuenta.getSelectedItem() == "Conductor"){
                int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Eliminar?", "Mensajero", JOptionPane.YES_NO_OPTION);
                if (n == 0){
                    try {
                        System.out.println("IMPRIMIENDO N :" +n);
                        String RUT = this.JFRUT.getText();
                        Connection con = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.clave);
                        OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("BEGIN BorrarConductor(?); END;");
                        cs.setString(1, RUT);
                        cs.executeUpdate();
                        
                        ResetearCampos();   
                        JOptionPane.showMessageDialog(null, "Conductor Borrado Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);                                                        
                } catch (SQLException ex) {
                    Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else{
            System.out.println("IMPRIMIENDO N :" +n);
            ResetearCampos();
        }
            }
            else if(this.jCBTipoCuenta.getSelectedItem() == "Mecanico"){
                int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Eliminar?", "Mensajero", JOptionPane.YES_NO_OPTION);
                if (n == 0){
                    try {
                        System.out.println("IMPRIMIENDO N :" +n);
                        String RUT = this.JFRUT.getText();
                        Connection con = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.clave);
                        OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("BEGIN BorrarMecanico(?); END;");
                        cs.setString(1, RUT);
                        cs.executeUpdate();
                        
                        ResetearCampos();   
                        JOptionPane.showMessageDialog(null, "Mecanico Borrado Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);                                                        
                } catch (SQLException ex) {
                    Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else{
            System.out.println("IMPRIMIENDO N :" +n);
            ResetearCampos();
        }                
            }
            else if(this.jCBTipoCuenta.getSelectedItem() == "Encargado Bodega"){
                int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Eliminar?", "Mensajero", JOptionPane.YES_NO_OPTION);
                if (n == 0){
                    try {
                        System.out.println("IMPRIMIENDO N :" +n);
                        String RUT = this.JFRUT.getText();
                        Connection con = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.clave);
                        OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("BEGIN BorrarEncargadoB(?); END;");
                        cs.setString(1, RUT);
                        cs.executeUpdate();
                        
                        ResetearCampos();   
                        JOptionPane.showMessageDialog(null, "Encargado de Bodega Borrado Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);                                                        
                } catch (SQLException ex) {
                    Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else{
            System.out.println("IMPRIMIENDO N :" +n);
            ResetearCampos();
        }                            
            }
     
        }
        else {
        JOptionPane.showMessageDialog(null, "Primero debe cargar a un Trabajador", "Mensajero", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

private void JCCOMUNAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCCOMUNAMouseClicked
        if(this.JCCOMUNA.getSelectedIndex() != 0){
        try {
            
            String Nombre = (String) this.JCCOMUNA.getSelectedItem();

            OracleCallableStatement cs;
            Connection con = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.clave);
            cs = (OracleCallableStatement) con.prepareCall("BEGIN ObtenerComuna(?,?); END;");

            System.out.println("Setiando Parametros ENTRADA");
            cs.setString(1, Nombre);

            System.out.println("Setiando Parametros SALIDA");
            cs.registerOutParameter(2, Types.INTEGER);
            cs.execute();
            int ID_COMUNA = cs.getOracleObject(2).intValue();
            this.JFComunaID.setText(String.valueOf(ID_COMUNA));

            System.out.println(ID_COMUNA);
            System.out.println("Fin Operacion");


        } catch (SQLException ex) {
            Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else{
            this.JCCOMUNA.setSelectedIndex(48);
        }
}//GEN-LAST:event_JCCOMUNAMouseClicked

private void JCCOMUNAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JCCOMUNAFocusLost
        if(this.JCCOMUNA.getSelectedIndex() != 0){
        try {
            
            String Nombre = (String) this.JCCOMUNA.getSelectedItem();

            OracleCallableStatement cs;
            Connection con = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.clave);
            cs = (OracleCallableStatement) con.prepareCall("BEGIN ObtenerComuna(?,?); END;");

            System.out.println("Setiando Parametros ENTRADA");
            cs.setString(1, Nombre);

            System.out.println("Setiando Parametros SALIDA");
            cs.registerOutParameter(2, Types.INTEGER);
            cs.execute();
            int ID_COMUNA = cs.getOracleObject(2).intValue();
            this.JFComunaID.setText(String.valueOf(ID_COMUNA));

            System.out.println(ID_COMUNA);
            System.out.println("Fin Operacion");


        } catch (SQLException ex) {
            Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else{
            this.JCCOMUNA.setSelectedIndex(48);
        }

}//GEN-LAST:event_JCCOMUNAFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBBorrar;
    private javax.swing.JButton JBCargar;
    private javax.swing.JButton JBGUARDAR;
    public javax.swing.JComboBox JCCOMUNA;
    private javax.swing.JComboBox JCFECHAING1;
    private javax.swing.JComboBox JCFECHAING2;
    private javax.swing.JComboBox JCFECHAING3;
    private javax.swing.JComboBox JCFECHANAC1;
    private javax.swing.JComboBox JCFECHANAC2;
    private javax.swing.JComboBox JCFECHANAC3;
    private javax.swing.JComboBox JCTipoPersonal;
    private javax.swing.JFormattedTextField JFAPEMA;
    private javax.swing.JFormattedTextField JFAPEPA;
    private javax.swing.JPasswordField JFCONTRASENA;
    private javax.swing.JPasswordField JFCONTRASENA1;
    private javax.swing.JTextField JFComunaID;
    private javax.swing.JFormattedTextField JFDIRE;
    private javax.swing.JFormattedTextField JFEMAIL;
    private javax.swing.JFormattedTextField JFNOMBRE;
    private javax.swing.JFormattedTextField JFNUMRADIO;
    private javax.swing.JFormattedTextField JFRUT;
    private javax.swing.JFormattedTextField JFTELE;
    private javax.swing.JFormattedTextField JFTIPOLICENCIA;
    private javax.swing.JPanel JPanelImagen;
    private javax.swing.JTextArea JTDETALLE;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jCBTipoCuenta;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
