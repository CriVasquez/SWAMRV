/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Vehiculos.java
 *
 * Created on 28-12-2011, 11:19:31 PM
 */
package soprafamrv;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
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
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import oracle.jdbc.OracleCallableStatement;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;
import soprafamrv.BD.Conexion;
import soprafamrv.SISTEMA.BarraProgreso;
import soprafamrv.SISTEMA.EjemploBarraProgreso;
import soprafamrv.SISTEMA.miPanel;
import soprafamrv.SISTEMA.subeImagen;
import soprafamrv.SISTEMA.vehiculo;


/**
 *
 * @author Cri
 */
public class Vehiculo extends javax.swing.JInternalFrame {

    /** Creates new form Vehiculos */
    public Vehiculo() throws SQLException {
        initComponents();
        CargarVehiculos();  
        
    }
    int contador = 0;
    
    @Action
    public void guardar() throws SQLException, ParseException{
        System.out.println("Creación de objetos");
        subeImagen s = new subeImagen();
        vehiculo v = new vehiculo();
        
        System.out.println("INICIO DEFINICION DE VARIABLES");
        String PATENTE = this.JFPATENTE.getText().toUpperCase();
        String CHASIS = this.JFCHASIS.getText().toUpperCase().trim();
        int ANO = Integer.parseInt(this.JFANO.getText().trim());
        String COLOR = (String) this.JCCOLOR.getSelectedItem();
        String MARCA = (String) this.JCMARCA.getSelectedItem();
        String MODELO = (String) this.JCMODELO.getSelectedItem();
        String FECHA_INGRESO = this.JCFECHAING1.getSelectedItem() + "-" + this.JCFECHAING2.getSelectedItem() + "-" + this.JCFECHAING3.getSelectedItem();
        String FECHA_RETIRO = this.JCFECHARET1.getSelectedItem() + "-" + this.JCFECHARET2.getSelectedItem() + "-" + this.JCFECHARET3.getSelectedItem();
        byte[] FOTO = s.ObtenerBytes();
        
        System.out.println("Definicion formato fecha");
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MMMMMMMMMM-yyyy", new Locale("es", "ES"));
        java.sql.Date ingreso = new java.sql.Date(sdf.parse(FECHA_INGRESO).getTime());
        java.sql.Date retiro = new java.sql.Date(sdf.parse(FECHA_RETIRO).getTime());
        
        v.setPATENTE(PATENTE);
        v.setCHASIS(CHASIS);
        v.setANO(ANO);
        v.setCOLOR(COLOR);
        v.setMARCA(MARCA);
        v.setMODELO(MODELO);        
        v.setFECHA_INGRESO(ingreso);
        v.setFECHA_RETIRO(retiro);
        v.setFOTO(FOTO);
        
        System.out.println("Termino Definición Variables");
        Conexion c = new Conexion();
        
        
        System.out.println("INICIO impresion variables asignadas");
        System.out.println("PATENTE: " +v.getPATENTE());
        System.out.println("CHASIS: " +v.getCHASIS());
        System.out.println("AÑO: " +v.getANO());
        System.out.println("COLOR: " +v.getCOLOR());
        System.out.println("MARCA: " +v.getMARCA());
        System.out.println("MODELO: " +v.getMODELO());
        System.out.println("FECHA_IN: " +v.getFECHA_INGRESO());
        System.out.println("FECHA_RET: " +v.getFECHA_RETIRO());
        System.out.println("FOTO: " +v.getFOTO());
        System.out.println("TERMINO impresion variables asignadas");
        
        if (this.JFPATENTE.getText().trim() != null && this.JFCHASIS.getText().trim() != null && this.JFANO.getText().trim() != null && !"Seleccionar Color".equals(this.JCCOLOR.getSelectedItem().toString()) && !"Seleccionar Marca".equals(this.JCMARCA.getSelectedItem().toString()) && !"Seleccionar Modelo".equals(this.JCMODELO.getSelectedItem().toString()))        {
            int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Guardar?", "Mensajero", JOptionPane.YES_NO_CANCEL_OPTION);
            //n = 0 es YES, n = 1 es NO, n = 2 es Cancel
            System.out.println("numero" + JOptionPane.YES_NO_CANCEL_OPTION);
            if (n == 0) {
                //String query = "begin RegistrarConductor ('"+RUT+"','"+NOMBRE+"','"+APELLIDO_PATERNO+"','"+APELLIDO_MATERNO+"','"+DIRECCION+"',"+TELEFONO+",'"+EMAIL+"',"+COMUNA+",'"+FECHA_INGRESO+"','"+FECHA_RETIRO+"','"+FECHA_NACIMIENTO+"',"+NUM_RADIO+",'"+LICENCIA+"','"+DETALLES+"', "+FOTO+"); end;";       
                try {
                c.registrarVehiculo(v);
                ResetearCampos();
                JOptionPane.showMessageDialog(null, "Datos Ingresados Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);
                contador = 1;
                } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Se ha producido un error en la inserción", "Error", JOptionPane.ERROR_MESSAGE);
                
                }        
                JPanelImagen.removeAll();        
                JPanelImagen.repaint();
                this.TablaVehiculo.removeAll();
                CargarVehiculos();  
            } else if (n == 1) {
            ResetearCampos();
                }
        }else{
            JOptionPane.showMessageDialog(null,"Codigo: " +"Debe llenartodos los campos solicitados", "Error", JOptionPane.ERROR_MESSAGE); 
            }
    
    }
    
    private void cargaVehiculoConductor(){
   try {
            String query = "Select * from buscarconductor";
            ResultSet rs = Conexion.ejecutarQuery(query);

            while (rs.next()) {
                this.JCConductor.addItem(rs.getString("rut_conductor")+ " - " +rs.getString("nombre")+ " " +rs.getString("apellido_paterno")+ " " +rs.getString("apellido_materno"));               

            }
            
            String query2 = "Select * from buscarvehiculo";
            ResultSet rs2 = Conexion.ejecutarQuery(query2);
            while (rs2.next()) {                
                this.JCVEHICULO.addItem(rs2.getString("patente")+ " - " +rs2.getString("marca")+ " " +rs2.getString("modelo")+ " " +rs2.getString("ano"));

            }
            //rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
         
    
    
    
    private void HabilitarCampos() {
        this.JFPATENTE.setEnabled(true);
        this.JFCHASIS.setEnabled(true);
        this.JFANO.setEnabled(true);
        this.JCCOLOR.setEnabled(true);
        this.JCMARCA.setEnabled(true);
        this.JCMODELO.setEnabled(true);
        this.JCFECHARET1.setEnabled(true);
        this.JCFECHARET2.setEnabled(true);
        this.JCFECHARET3.setEnabled(true);
        
    }
    
    private void DeshabilitarCampos() {
        this.JFPATENTE.setEnabled(false);
        this.JFCHASIS.setEnabled(false);
        this.JFANO.setEnabled(false);
        this.JCCOLOR.setEnabled(false);
        this.JCMARCA.setEnabled(false);
        this.JCMODELO.setEnabled(false);
        this.JCFECHARET1.setEnabled(false);
        this.JCFECHARET2.setEnabled(false);
        this.JCFECHARET3.setEnabled(false);
        JPanelImagen.removeAll();
        JPanelImagen.repaint();
    }
    
    
    private void CargarVehiculos() throws SQLException{
        String query = "Select * from DatosVehiculo";
        ResultSet rs = Conexion.ejecutarQuery(query);
        vehiculo.llenarTablaVehiculos(TablaVehiculo, rs);
        String query2 = "Select * from DatosVehiculoConductor";
        ResultSet rs2 = Conexion.ejecutarQuery(query2);
        vehiculo.llenarTablaVehiculoConductor(TablaVehiculoConductor, rs2);
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
        this.JCFECHAING4.addItem(dia.format(date));
        this.JCFECHAING5.addItem(mes.format(date).toUpperCase());
        this.JCFECHAING6.addItem(ano.format(date));
                
        this.JCFECHAING1.setSelectedIndex(1);
        this.JCFECHAING2.setSelectedIndex(1);
        this.JCFECHAING3.setSelectedIndex(1);
        this.JCFECHAING4.setSelectedIndex(1);
        this.JCFECHAING5.setSelectedIndex(1);
        this.JCFECHAING6.setSelectedIndex(1);

        int year = Integer.parseInt(ano.format(date));
        System.out.println("Inicio ingreso años");
        for (int x = 1900; x <= year; x++) {
            this.JCFECHARET3.addItem(x);
        }
        System.out.println("Termino ingreso años");

    }
    
    private void ResetearCampos() {
        this.JFPATENTE.setText(null);
        this.JFCHASIS.setText(null);
        this.JFANO.setText(null);
        this.JCCOLOR.setSelectedIndex(0);
        this.JCMARCA.setSelectedIndex(0);
        this.JCMODELO.setSelectedIndex(0);
        this.JCFECHAING1.setSelectedIndex(0);
        this.JCFECHAING2.setSelectedIndex(0);
        this.JCFECHAING3.setSelectedIndex(0);
        this.JCFECHARET1.setSelectedIndex(0);
        this.JCFECHARET2.setSelectedIndex(0);
        this.JCFECHARET3.setSelectedIndex(0);
        this.JPanelImagen.removeAll();
        this.JPanelImagen.repaint();
        this.JCConductor.setSelectedIndex(0);
        this.JCVEHICULO.setSelectedIndex(0);
        this.JTDESCRIPCION.setText(null);

    }

        
        

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        JDConductorVehiculo = new javax.swing.JDialog();
        jLabel12 = new javax.swing.JLabel();
        JCConductor = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        JCVEHICULO = new javax.swing.JComboBox();
        JCFECHAING4 = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        JCFECHAING5 = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        JCFECHAING6 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTDESCRIPCION = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        JFCHASIS = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JCFECHAING3 = new javax.swing.JComboBox();
        JCMARCA = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JFPATENTE = new javax.swing.JFormattedTextField();
        JCCOLOR = new javax.swing.JComboBox();
        JCMODELO = new javax.swing.JComboBox();
        JCFECHAING2 = new javax.swing.JComboBox();
        JCFECHAING1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JCFECHARET1 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JCFECHARET2 = new javax.swing.JComboBox();
        JCFECHARET3 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        JPanelImagen = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        JFANO = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaVehiculo = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaVehiculoConductor = new javax.swing.JTable();

        jFileChooser.setName("jFileChooser"); // NOI18N

        JDConductorVehiculo.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(soprafamrv.SOPRAFAMRVApp0.class).getContext().getResourceMap(Vehiculo.class);
        JDConductorVehiculo.setTitle(resourceMap.getString("JDConductorVehiculo.title")); // NOI18N
        JDConductorVehiculo.setAlwaysOnTop(true);
        JDConductorVehiculo.setName("JDConductorVehiculo"); // NOI18N
        JDConductorVehiculo.setResizable(false);

        jLabel12.setText(resourceMap.getString("jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N

        JCConductor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar Conductor" }));
        JCConductor.setName("JCConductor"); // NOI18N

        jLabel14.setText(resourceMap.getString("jLabel14.text")); // NOI18N
        jLabel14.setName("jLabel14"); // NOI18N

        jLabel15.setText(resourceMap.getString("jLabel15.text")); // NOI18N
        jLabel15.setName("jLabel15"); // NOI18N

        jLabel16.setText(resourceMap.getString("jLabel16.text")); // NOI18N
        jLabel16.setName("jLabel16"); // NOI18N

        JCVEHICULO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar Vehículo" }));
        JCVEHICULO.setName("JCVEHICULO"); // NOI18N

        JCFECHAING4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Día" }));
        JCFECHAING4.setEnabled(false);
        JCFECHAING4.setName("JCFECHAING4"); // NOI18N

        jLabel18.setText(resourceMap.getString("jLabel18.text")); // NOI18N
        jLabel18.setName("jLabel18"); // NOI18N

        JCFECHAING5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mes" }));
        JCFECHAING5.setEnabled(false);
        JCFECHAING5.setName("JCFECHAING5"); // NOI18N

        jLabel19.setText(resourceMap.getString("jLabel19.text")); // NOI18N
        jLabel19.setName("jLabel19"); // NOI18N

        JCFECHAING6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Año" }));
        JCFECHAING6.setEnabled(false);
        JCFECHAING6.setName("JCFECHAING6"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        JTDESCRIPCION.setColumns(20);
        JTDESCRIPCION.setLineWrap(true);
        JTDESCRIPCION.setRows(5);
        JTDESCRIPCION.setName("JTDESCRIPCION"); // NOI18N
        jScrollPane2.setViewportView(JTDESCRIPCION);

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JDConductorVehiculoLayout = new javax.swing.GroupLayout(JDConductorVehiculo.getContentPane());
        JDConductorVehiculo.getContentPane().setLayout(JDConductorVehiculoLayout);
        JDConductorVehiculoLayout.setHorizontalGroup(
            JDConductorVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDConductorVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JDConductorVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JDConductorVehiculoLayout.createSequentialGroup()
                        .addGroup(JDConductorVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(JDConductorVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                            .addComponent(JCVEHICULO, 0, 458, Short.MAX_VALUE)
                            .addGroup(JDConductorVehiculoLayout.createSequentialGroup()
                                .addComponent(JCFECHAING4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCFECHAING5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addGap(4, 4, 4)
                                .addComponent(JCFECHAING6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JCConductor, 0, 458, Short.MAX_VALUE)))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        JDConductorVehiculoLayout.setVerticalGroup(
            JDConductorVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDConductorVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JDConductorVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(JCConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JDConductorVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(JCVEHICULO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JDConductorVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(JCFECHAING4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(JCFECHAING5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(JCFECHAING6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JDConductorVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2))
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 700));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

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

        jButton5.setText(resourceMap.getString("jButton5.text")); // NOI18N
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setName("jButton5"); // NOI18N
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);

        jButton6.setText(resourceMap.getString("jButton6.text")); // NOI18N
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setName("jButton6"); // NOI18N
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton6);

        jButton7.setText(resourceMap.getString("jButton7.text")); // NOI18N
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setName("jButton7"); // NOI18N
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton7);

        jButton9.setText(resourceMap.getString("jButton9.text")); // NOI18N
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setName("jButton9"); // NOI18N
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton9);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel2.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel2.border.titleColor"))); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        try {
            JFCHASIS.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**********")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JFCHASIS.setEnabled(false);
        JFCHASIS.setName("JFCHASIS"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        JCFECHAING3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Año" }));
        JCFECHAING3.setEnabled(false);
        JCFECHAING3.setName("JCFECHAING3"); // NOI18N

        JCMARCA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar Marca", "DAEWOO" }));
        JCMARCA.setEnabled(false);
        JCMARCA.setName("JCMARCA"); // NOI18N

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        try {
            JFPATENTE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("******")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JFPATENTE.setEnabled(false);
        JFPATENTE.setName("JFPATENTE"); // NOI18N

        JCCOLOR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar Color", "BLANCO", "NEGRO", "AZULINO", "AZUL FRANCIA", "ROJO", "NARANJO", "AMARILLO ORO", "CELESTE", "VERDE MANZANA", "VERDE LIMON", "VERDE BOTELLA", "MORADO", "GRIS", "CAFE", "FUCSIA/A PEDIDO", "CALIPSO/A PEDIDO", " " }));
        JCCOLOR.setEnabled(false);
        JCCOLOR.setName("JCCOLOR"); // NOI18N

        JCMODELO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar Modelo", "HEAVEN" }));
        JCMODELO.setEnabled(false);
        JCMODELO.setName("JCMODELO"); // NOI18N

        JCFECHAING2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mes" }));
        JCFECHAING2.setEnabled(false);
        JCFECHAING2.setName("JCFECHAING2"); // NOI18N

        JCFECHAING1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Día" }));
        JCFECHAING1.setEnabled(false);
        JCFECHAING1.setName("JCFECHAING1"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        JCFECHARET1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Día", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        JCFECHARET1.setEnabled(false);
        JCFECHARET1.setName("JCFECHARET1"); // NOI18N

        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        JCFECHARET2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mes", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
        JCFECHARET2.setEnabled(false);
        JCFECHARET2.setName("JCFECHARET2"); // NOI18N

        JCFECHARET3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Año" }));
        JCFECHARET3.setEnabled(false);
        JCFECHARET3.setName("JCFECHARET3"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        JPanelImagen.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("JPanelImagen.border.title"))); // NOI18N
        JPanelImagen.setName("JPanelImagen"); // NOI18N

        javax.swing.GroupLayout JPanelImagenLayout = new javax.swing.GroupLayout(JPanelImagen);
        JPanelImagen.setLayout(JPanelImagenLayout);
        JPanelImagenLayout.setHorizontalGroup(
            JPanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
        );
        JPanelImagenLayout.setVerticalGroup(
            JPanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        jLabel17.setText(resourceMap.getString("jLabel17.text")); // NOI18N
        jLabel17.setName("jLabel17"); // NOI18N

        try {
            JFANO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JFANO.setEnabled(false);
        JFANO.setName("JFANO"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(soprafamrv.SOPRAFAMRVApp0.class).getContext().getActionMap(Vehiculo.class, this);
        jButton1.setAction(actionMap.get("guardar")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton11.setText(resourceMap.getString("jButton11.text")); // NOI18N
        jButton11.setName("jButton11"); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(JPanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(JCFECHARET1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JCFECHAING1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel11))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(JCFECHARET2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JCFECHARET3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(JCFECHAING2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(JCFECHAING3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel17)
                                        .addComponent(jLabel1))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JFANO)
                                        .addComponent(JFCHASIS)
                                        .addComponent(JFPATENTE, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JCCOLOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JCMODELO, javax.swing.GroupLayout.Alignment.TRAILING, 0, 120, Short.MAX_VALUE)
                                        .addComponent(JCMARCA, 0, 120, Short.MAX_VALUE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton3))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JFPATENTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JFCHASIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JFANO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(JCCOLOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(JCMARCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(JCMODELO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCFECHAING3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(JCFECHAING2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(JCFECHAING1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCFECHARET3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(JCFECHARET2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCFECHARET1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel1.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel1.border.titleColor"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jButton10.setText(resourceMap.getString("jButton10.text")); // NOI18N
        jButton10.setName("jButton10"); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel3.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel3.border.titleColor"))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        TablaVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaVehiculo.setName("TablaVehiculo"); // NOI18N
        jScrollPane1.setViewportView(TablaVehiculo);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel4.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel4.border.titleColor"))); // NOI18N
        jPanel4.setName("jPanel4"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        TablaVehiculoConductor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaVehiculoConductor.setName("TablaVehiculoConductor"); // NOI18N
        jScrollPane3.setViewportView(TablaVehiculoConductor);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(93, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        subeImagen m = new subeImagen();
        m.Abrir_Dialogo(JPanelImagen);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        JPanelImagen.removeAll();
        JPanelImagen.repaint();    
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        HabilitarCampos();
        AsignarFechaIngreso();
    }//GEN-LAST:event_jButton4ActionPerformed

    
    
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
    try {
                DeshabilitarCampos();
                
                String PATENTE = (String) this.TablaVehiculo.getValueAt(TablaVehiculo.getSelectedRow(), TablaVehiculo.getSelectedColumn());
                Connection con = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.clave);
                OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("BEGIN CargaVehiculos(?,?,?,?,?,?,?,?,?); END;");
                

                System.out.println("***INICIO CARGA VEHICULO***");
                System.out.println("Setiando Parametros ENTRADA");
                cs.setString(1, PATENTE);

                System.out.println("Setiando Parametros SALIDA");
                cs.registerOutParameter(2, Types.VARCHAR);
                cs.registerOutParameter(3, Types.INTEGER);
                cs.registerOutParameter(4, Types.VARCHAR);
                cs.registerOutParameter(5, Types.VARCHAR);
                cs.registerOutParameter(6, Types.VARCHAR);
                cs.registerOutParameter(7, Types.DATE);
                cs.registerOutParameter(8, Types.DATE);                
                cs.registerOutParameter(9, Types.BLOB);
                                                
                cs.execute();
                String CHASIS = null;
                int ANO = 0;
                String COLOR = null;
                String MARCA = null;
                String MODELO = null;
                String FECHAIN = null;
                String FECHARE = null;
                byte[] FOTOByte;
                
                //Asignacion a las variables
                CHASIS = cs.getOracleObject(2).stringValue();
                ANO = cs.getOracleObject(3).intValue();
                COLOR = cs.getOracleObject(4).stringValue();
                MARCA = cs.getOracleObject(5).stringValue();
                MODELO = cs.getOracleObject(6).stringValue();
                FECHAIN = cs.getOracleObject(7).stringValue();
                FECHARE = cs.getOracleObject(8).stringValue();
                //FOTO = cs.getOracleObject(15).characterStreamValue();                
                FOTOByte = cs.getBytes(9);
                InputStream z = new ByteArrayInputStream(FOTOByte);
                BufferedImage FOTO = ImageIO.read(z);
                System.out.println("IMPRIMIENDO FOTO: "+FOTO);
                //Hasta aqui el codigo funciona bien!
                System.out.println(CHASIS);
                System.out.println(ANO);
                System.out.println(COLOR);
                System.out.println(MARCA);
                System.out.println(MODELO);
                System.out.println(FECHAIN);
                System.out.println(FECHARE);
                System.out.println(FOTO);
                System.out.println("TERMINO CARGA VEHICULO");
                
                vehiculo v = new vehiculo();
                v.setPATENTE(PATENTE);
                this.JFPATENTE.setText(PATENTE);
                this.JFCHASIS.setText(CHASIS.trim());
                this.JFANO.setText(String.valueOf(ANO).trim());
                this.JCCOLOR.setSelectedIndex(0);
                this.JCMARCA.setSelectedIndex(0);
                this.JCMODELO.setSelectedIndex(0);
                this.JCFECHAING1.setSelectedIndex(0);
                this.JCFECHAING2.setSelectedIndex(0);
                this.JCFECHAING3.setSelectedIndex(0);
                this.JCFECHARET1.setSelectedIndex(0);
                this.JCFECHARET2.setSelectedIndex(0);
                this.JCFECHARET3.setSelectedIndex(0);
                JPanelImagen.add(new miPanel(FOTO, JPanelImagen.getSize()));
                JPanelImagen.setVisible(true);
                JPanelImagen.repaint();
                
                
                
            } catch (IOException ex) {
                Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
    this.JDConductorVehiculo.setVisible(true);
    this.JDConductorVehiculo.setLocation(400, 200);
    this.JDConductorVehiculo.setSize(600,400);
    AsignarFechaIngreso();
    cargaVehiculoConductor();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            System.out.println("Creación de objetos");
            
            System.out.println("INICIO DEFINICION DE VARIABLES");
            String CONDUCTOR = this.JCConductor.getSelectedItem().toString().substring(0, 12).trim();
            String VEHICULO = this.JCVEHICULO.getSelectedItem().toString().substring(0, 6).trim();
            String FECHA_ASIGNACION = this.JCFECHAING4.getSelectedItem() + "-" + this.JCFECHAING5.getSelectedItem() + "-" + this.JCFECHAING6.getSelectedItem();            
            String DESCRIPCION = this.JTDESCRIPCION.getText().toUpperCase().trim();
            System.out.println("Definicion formato fecha");
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MMMMMMMMMM-yyyy", new Locale("es", "ES"));
            java.sql.Date asignacion = new java.sql.Date(sdf.parse(FECHA_ASIGNACION).getTime());
            
            System.out.println("Termino Definición Variables");
            Conexion c = new Conexion();
                        
            System.out.println("INICIO impresion variables asignadas");
            System.out.println("CONDUCTOR: "+CONDUCTOR);
            System.out.println("VEHICULO: "+VEHICULO);
            System.out.println("FECHA-INGRESO: "+FECHA_ASIGNACION);
            System.out.println("DESCRIPCION: "+DESCRIPCION);
            System.out.println("TERMINO impresion variables asignadas");
            
            if (!"Seleccionar Conductor".equals(this.JCConductor.getSelectedItem().toString()) && !"Seleccionar Vehículo".equals(this.JCVEHICULO.getSelectedItem().toString()) && this.JTDESCRIPCION.getText().trim() != null )        {
                int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Guardar?", "Mensajero", JOptionPane.YES_NO_CANCEL_OPTION);
                //n = 0 es YES, n = 1 es NO, n = 2 es Cancel
                System.out.println("numero" + JOptionPane.YES_NO_CANCEL_OPTION);
                if (n == 0) {
                    //String query = "begin RegistrarConductor ('"+RUT+"','"+NOMBRE+"','"+APELLIDO_PATERNO+"','"+APELLIDO_MATERNO+"','"+DIRECCION+"',"+TELEFONO+",'"+EMAIL+"',"+COMUNA+",'"+FECHA_INGRESO+"','"+FECHA_RETIRO+"','"+FECHA_NACIMIENTO+"',"+NUM_RADIO+",'"+LICENCIA+"','"+DETALLES+"', "+FOTO+"); end;";       
                    try {
                    c.registrarVehiculoConductor(CONDUCTOR, VEHICULO, asignacion, DESCRIPCION);
                    ResetearCampos();
                    JOptionPane.showMessageDialog(null, "Datos Ingresados Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);
                    contador = 1;
                    } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Se ha producido un error en la inserción", "Error", JOptionPane.ERROR_MESSAGE);
                    
                    }        
                } else if (n == 1) {
                ResetearCampos();
                    }
            }else{
                JOptionPane.showMessageDialog(null,"Codigo: " +"Debe llenartodos los campos solicitados", "Error", JOptionPane.ERROR_MESSAGE); 
                }
        } catch (ParseException ex) {
            Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox JCCOLOR;
    private javax.swing.JComboBox JCConductor;
    private javax.swing.JComboBox JCFECHAING1;
    private javax.swing.JComboBox JCFECHAING2;
    private javax.swing.JComboBox JCFECHAING3;
    private javax.swing.JComboBox JCFECHAING4;
    private javax.swing.JComboBox JCFECHAING5;
    private javax.swing.JComboBox JCFECHAING6;
    private javax.swing.JComboBox JCFECHARET1;
    private javax.swing.JComboBox JCFECHARET2;
    private javax.swing.JComboBox JCFECHARET3;
    private javax.swing.JComboBox JCMARCA;
    private javax.swing.JComboBox JCMODELO;
    private javax.swing.JComboBox JCVEHICULO;
    private javax.swing.JDialog JDConductorVehiculo;
    private javax.swing.JFormattedTextField JFANO;
    private javax.swing.JFormattedTextField JFCHASIS;
    private javax.swing.JFormattedTextField JFPATENTE;
    private javax.swing.JPanel JPanelImagen;
    private javax.swing.JTextArea JTDESCRIPCION;
    private javax.swing.JTable TablaVehiculo;
    private javax.swing.JTable TablaVehiculoConductor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
