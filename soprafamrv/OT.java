package soprafamrv;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.lang.String;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import oracle.jdbc.OracleCallableStatement;
import soprafamrv.BD.Conexion;
import soprafamrv.SISTEMA.ot;



/**
 *
 * @author Cri
 */
public class OT extends javax.swing.JInternalFrame {
    /** Creates new form OTS */
    public OT() throws SQLException {
        initComponents();
        CargarOT();      
        this.JTOBSIDSERVICIO.setVisible(false);
                
    }
    
    private void CargarOT() throws SQLException {
        this.TablaOT.removeAll();
        this.TablaOT1.removeAll();
        String query = "Select * from DatosOT";
        String query2 = "select * from DATOSOTServicio";
        ResultSet rs = Conexion.ejecutarQuery(query);
        ResultSet rs1 = Conexion.ejecutarQuery(query2);
        ResultSet rs2 = Conexion.ejecutarQuery(query2);
        ResultSet rs3 = Conexion.ejecutarQuery(query2);
        ot.llenarTablaOT(TablaOT1, rs);
        ot.llenarTablaOT(TablaOT, rs1);
        ot.llenarTablaOT(TablaOT4, rs2);
        ot.llenarTablaOT(TablaOT3, rs3);
        
    }
    
    private void HabilitarCampos(){
        this.JCPATENTE.setEnabled(true);
        this.JCADMINISTRADOR.setEnabled(true);
        this.JCMECANICO.setEnabled(true);
        this.TCINI1.setEnabled(false);
        this.TCINI2.setEnabled(false);
        this.TCINI3.setEnabled(false);
        this.TCTER1.setEnabled(true);
        this.TCTER2.setEnabled(true);
        this.TCTER3.setEnabled(true);
        this.JCTRABAJO.setEnabled(true);
        
    
    }
    
    private void AsignarFechaIngreso() {
        //Puedo jugar con DD MM YYYY para mostrarlos individualmente
        DateFormat dia = new SimpleDateFormat("dd");
        DateFormat mes = new SimpleDateFormat("MMMMMMMMMM");
        DateFormat ano = new SimpleDateFormat("yyyy");
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        this.TCINI1.addItem(dia.format(date));
        this.TCINI2.addItem(mes.format(date).toUpperCase());
        this.TCINI3.addItem(ano.format(date));
        this.TCINI1.setSelectedIndex(1);
        this.TCINI2.setSelectedIndex(1);
        this.TCINI3.setSelectedIndex(1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        
        int year = Integer.parseInt(ano.format(date));
        System.out.println("Inicio ingreso años");
        for (int x = 1900; x <= year; x++) {
            this.TCINI3.addItem(x);
            this.TCTER3.addItem(x);            
        }
        System.out.println("Termino ingreso años");

    }
    
    
     private void CargaOrden(){
     try {            
            String query2 = "Select * from buscarvehiculo";
            ResultSet rs2 = Conexion.ejecutarQuery(query2);
            while (rs2.next()) {                
                this.JCPATENTE.addItem(rs2.getString("patente")+ " - " +rs2.getString("marca")+ " " +rs2.getString("modelo")+ " " +rs2.getString("ano"));
            }
            
            String query3 = "Select * from buscaradministrador";
            ResultSet rs3 = Conexion.ejecutarQuery(query3);
            while (rs3.next()) {                
                this.JCADMINISTRADOR.addItem(rs3.getString("RUT_ADMINISTRADOR")+ " - " +rs3.getString("NOMBRE")+ " " +rs3.getString("APELLIDO_PATERNO")+ " " +rs3.getString("APELLIDO_MATERNO"));
            }
            
            String query4 = "Select * from buscarmecanico";
            ResultSet rs4 = Conexion.ejecutarQuery(query4);
            while (rs4.next()) {                
                this.JCMECANICO.addItem(rs4.getString("RUT_MECANICO")+ " - " +rs4.getString("NOMBRE")+ " " +rs4.getString("APELLIDO_PATERNO")+ " " +rs4.getString("APELLIDO_MATERNO"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
     AsignarFechaIngreso();     
     }
     
     private void ResetearCampos(){
         this.JFNUMORDEN.setText(null);
         this.JCPATENTE.setSelectedIndex(0);
         this.JCADMINISTRADOR.setSelectedIndex(0);
         this.JCMECANICO.setSelectedIndex(0);
         this.TCTER1.setSelectedIndex(0);
         this.TCTER2.setSelectedIndex(0);
         this.TCTER3.setSelectedIndex(0);
         this.JCTRABAJO.setSelectedIndex(0);         
     }
     

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        TCINI3 = new javax.swing.JComboBox();
        TCINI1 = new javax.swing.JComboBox();
        TCINI2 = new javax.swing.JComboBox();
        TCTER2 = new javax.swing.JComboBox();
        TCTER1 = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        JCTRABAJO = new javax.swing.JComboBox();
        TCTER3 = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JFNUMORDEN = new javax.swing.JFormattedTextField();
        JCADMINISTRADOR = new javax.swing.JComboBox();
        JCPATENTE = new javax.swing.JComboBox();
        JCMECANICO = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        JDSNUMORDEN = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        JLServiDispo = new java.awt.List();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        JLServiSelec = new java.awt.List();
        JDSPATENTE = new javax.swing.JFormattedTextField();
        JDSMARCA = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        JDSMODELO = new javax.swing.JFormattedTextField();
        jButton9 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaOT1 = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jcasdasd1 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jButton17 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaOT = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaOT2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTOBSERV = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        JTOBSIDOT = new javax.swing.JTextField();
        JTOBSPATENTE = new javax.swing.JTextField();
        JTOBSSERVICIO = new javax.swing.JTextField();
        JTOBSESTADO = new javax.swing.JTextField();
        JTOBSIDSERVICIO = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton18 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaOT4 = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jButton20 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        JBCargarRepuesto = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        TablaOT6 = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        JTOBSERV2 = new javax.swing.JTextArea();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        JTOBSIDOT2 = new javax.swing.JTextField();
        JTOBSPATENTE2 = new javax.swing.JTextField();
        JTOBSSERVICIO2 = new javax.swing.JTextField();
        JTOBSESTADO2 = new javax.swing.JTextField();
        JTOBSIDSERVICIO2 = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        JBCargarFalla = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaOT3 = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jButton19 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TablaOT5 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        JTOBSERV1 = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        JTOBSIDOT1 = new javax.swing.JTextField();
        JTOBSPATENTE1 = new javax.swing.JTextField();
        JTOBSSERVICIO1 = new javax.swing.JTextField();
        JTOBSESTADO1 = new javax.swing.JTextField();
        JTOBSIDSERVICIO1 = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(soprafamrv.SOPRAFAMRVApp0.class).getContext().getResourceMap(OT.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

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
        jToolBar1.add(jButton2);

        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setName("jButton3"); // NOI18N
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel2.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel2.border.titleColor"))); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel1.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel1.border.titleColor"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        TCINI3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Año" }));
        TCINI3.setEnabled(false);
        TCINI3.setName("TCINI3"); // NOI18N

        TCINI1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Día" }));
        TCINI1.setEnabled(false);
        TCINI1.setName("TCINI1"); // NOI18N

        TCINI2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mes" }));
        TCINI2.setEnabled(false);
        TCINI2.setName("TCINI2"); // NOI18N

        TCTER2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        TCTER2.setEnabled(false);
        TCTER2.setName("TCTER2"); // NOI18N

        TCTER1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Día", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        TCTER1.setEnabled(false);
        TCTER1.setName("TCTER1"); // NOI18N

        jLabel17.setText(resourceMap.getString("jLabel17.text")); // NOI18N
        jLabel17.setName("jLabel17"); // NOI18N

        jLabel18.setText(resourceMap.getString("jLabel18.text")); // NOI18N
        jLabel18.setName("jLabel18"); // NOI18N

        jLabel20.setText(resourceMap.getString("jLabel20.text")); // NOI18N
        jLabel20.setName("jLabel20"); // NOI18N

        JCTRABAJO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar Trabajo", "Mantención", "Reparación" }));
        JCTRABAJO.setEnabled(false);
        JCTRABAJO.setName("JCTRABAJO"); // NOI18N

        TCTER3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Año" }));
        TCTER3.setEnabled(false);
        TCTER3.setName("TCTER3"); // NOI18N

        jLabel19.setText(resourceMap.getString("jLabel19.text")); // NOI18N
        jLabel19.setName("jLabel19"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        JFNUMORDEN.setEnabled(false);
        JFNUMORDEN.setName("JFNUMORDEN"); // NOI18N

        JCADMINISTRADOR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar Administrador" }));
        JCADMINISTRADOR.setEnabled(false);
        JCADMINISTRADOR.setName("JCADMINISTRADOR"); // NOI18N

        JCPATENTE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar Patente" }));
        JCPATENTE.setEnabled(false);
        JCPATENTE.setName("JCPATENTE"); // NOI18N
        JCPATENTE.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCPATENTEItemStateChanged(evt);
            }
        });
        JCPATENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCPATENTEActionPerformed(evt);
            }
        });

        JCMECANICO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar Mecanico" }));
        JCMECANICO.setEnabled(false);
        JCMECANICO.setName("JCMECANICO"); // NOI18N

        jButton5.setText(resourceMap.getString("jButton5.text")); // NOI18N
        jButton5.setName("jButton5"); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCTRABAJO, 0, 221, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TCINI1, 0, 84, Short.MAX_VALUE)
                                    .addComponent(TCTER1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 84, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel17))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TCTER2, 0, 121, Short.MAX_VALUE)
                                    .addComponent(TCINI2, javax.swing.GroupLayout.Alignment.LEADING, 0, 121, Short.MAX_VALUE)))
                            .addComponent(JFNUMORDEN, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TCINI3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TCTER3, 0, 68, Short.MAX_VALUE))
                                .addGap(91, 91, 91))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JCMECANICO, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCPATENTE, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCADMINISTRADOR, javax.swing.GroupLayout.Alignment.LEADING, 0, 211, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JFNUMORDEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCPATENTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JCADMINISTRADOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JCMECANICO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TCINI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TCINI2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(TCINI3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TCTER1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)
                        .addComponent(TCTER2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(TCTER3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(JCTRABAJO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(182, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel3.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel3.border.titleColor"))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        JDSNUMORDEN.setEditable(false);
        JDSNUMORDEN.setEnabled(false);
        JDSNUMORDEN.setName("JDSNUMORDEN"); // NOI18N

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel4.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel4.border.titleColor"))); // NOI18N
        jPanel4.setName("jPanel4"); // NOI18N

        jButton7.setText(resourceMap.getString("jButton7.text")); // NOI18N
        jButton7.setName("jButton7"); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText(resourceMap.getString("jButton8.text")); // NOI18N
        jButton8.setName("jButton8"); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        JLServiDispo.setMultipleMode(true);
        JLServiDispo.setName("JLServiDispo"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLServiDispo, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(JLServiDispo, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton7))
                .addGap(33, 33, 33))
        );

        jSeparator1.setName("jSeparator1"); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel6.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel6.border.titleColor"))); // NOI18N
        jPanel6.setName("jPanel6"); // NOI18N

        jButton11.setText(resourceMap.getString("jButton11.text")); // NOI18N
        jButton11.setName("jButton11"); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText(resourceMap.getString("jButton12.text")); // NOI18N
        jButton12.setName("jButton12"); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        JLServiSelec.setMultipleMode(true);
        JLServiSelec.setName("JLServiSelec"); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JLServiSelec, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(JLServiSelec, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton11))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        JDSPATENTE.setEditable(false);
        JDSPATENTE.setEnabled(false);
        JDSPATENTE.setName("JDSPATENTE"); // NOI18N

        JDSMARCA.setEditable(false);
        JDSMARCA.setEnabled(false);
        JDSMARCA.setName("JDSMARCA"); // NOI18N

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel21.setText(resourceMap.getString("jLabel21.text")); // NOI18N
        jLabel21.setName("jLabel21"); // NOI18N

        jLabel22.setText(resourceMap.getString("jLabel22.text")); // NOI18N
        jLabel22.setName("jLabel22"); // NOI18N

        JDSMODELO.setEditable(false);
        JDSMODELO.setEnabled(false);
        JDSMODELO.setName("JDSMODELO"); // NOI18N

        jButton9.setText(resourceMap.getString("jButton9.text")); // NOI18N
        jButton9.setName("jButton9"); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JDSMODELO)
                            .addComponent(JDSMARCA)
                            .addComponent(JDSPATENTE, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JDSNUMORDEN, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton9)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(JDSPATENTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(JDSMARCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(JDSMODELO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JDSNUMORDEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addGap(95, 95, 95))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel10.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel10.border.titleColor"))); // NOI18N
        jPanel10.setAutoscrolls(true);
        jPanel10.setName("jPanel10"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        TablaOT1.setAutoCreateRowSorter(true);
        TablaOT1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaOT1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TablaOT1.setName("TablaOT1"); // NOI18N
        TablaOT1.getTableHeader().setReorderingAllowed(false);
        TablaOT1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TablaOT1FocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(TablaOT1);

        jButton15.setText(resourceMap.getString("jButton15.text")); // NOI18N
        jButton15.setName("jButton15"); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel11.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel11.border.titleColor"))); // NOI18N
        jPanel11.setName("jPanel11"); // NOI18N

        jLabel13.setText(resourceMap.getString("jLabel13.text")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N

        jButton16.setText(resourceMap.getString("jButton16.text")); // NOI18N
        jButton16.setName("jButton16"); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel14.setText(resourceMap.getString("jLabel14.text")); // NOI18N
        jLabel14.setName("jLabel14"); // NOI18N

        jcasdasd1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MES" }));
        jcasdasd1.setName("jcasdasd1"); // NOI18N

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AÑO" }));
        jComboBox3.setName("jComboBox3"); // NOI18N

        jRadioButton4.setText(resourceMap.getString("jRadioButton4.text")); // NOI18N
        jRadioButton4.setName("jRadioButton4"); // NOI18N

        jRadioButton5.setText(resourceMap.getString("jRadioButton5.text")); // NOI18N
        jRadioButton5.setName("jRadioButton5"); // NOI18N

        jRadioButton6.setText(resourceMap.getString("jRadioButton6.text")); // NOI18N
        jRadioButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton6.setName("jRadioButton6"); // NOI18N

        jButton17.setText(resourceMap.getString("jButton17.text")); // NOI18N
        jButton17.setName("jButton17"); // NOI18N
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcasdasd1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
                        .addComponent(jButton17))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton4)
                        .addGap(16, 16, 16)
                        .addComponent(jRadioButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                        .addComponent(jButton16)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jcasdasd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6)
                    .addComponent(jButton16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton15, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton15)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addContainerGap())
        );

        jTabbedPane1.addTab(resourceMap.getString("jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        jPanel8.setName("jPanel8"); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel5.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel5.border.titleColor"))); // NOI18N
        jPanel5.setAutoscrolls(true);
        jPanel5.setName("jPanel5"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        TablaOT.setAutoCreateRowSorter(true);
        TablaOT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaOT.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        TablaOT.setName("TablaOT"); // NOI18N
        TablaOT.getTableHeader().setReorderingAllowed(false);
        TablaOT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TablaOTFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(TablaOT);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel7.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel7.border.titleColor"))); // NOI18N
        jPanel7.setName("jPanel7"); // NOI18N

        jButton13.setText(resourceMap.getString("jButton13.text")); // NOI18N
        jButton13.setName("jButton13"); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel12.setText(resourceMap.getString("jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N

        jRadioButton2.setText(resourceMap.getString("jRadioButton2.text")); // NOI18N
        jRadioButton2.setName("jRadioButton2"); // NOI18N

        jRadioButton3.setText(resourceMap.getString("jRadioButton3.text")); // NOI18N
        jRadioButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton3.setName("jRadioButton3"); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(jButton13)
                .addGap(22, 22, 22))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel12)
                .addComponent(jRadioButton2)
                .addComponent(jRadioButton3))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jButton13))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel9.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel9.border.titleColor"))); // NOI18N
        jPanel9.setName("jPanel9"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        TablaOT2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaOT2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        TablaOT2.setName("TablaOT2");
        TablaOT2.getTableHeader().setReorderingAllowed(false);
        TablaOT2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaOT2MouseClicked(evt);
            }
        });
        TablaOT2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TablaOT2FocusGained(evt);
            }
        });
        TablaOT2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TablaOT2KeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(TablaOT2);

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        JTOBSERV.setColumns(20);
        JTOBSERV.setLineWrap(true);
        JTOBSERV.setRows(5);
        JTOBSERV.setName("JTOBSERV"); // NOI18N
        JTOBSERV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTOBSERVFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTOBSERVFocusLost(evt);
            }
        });
        jScrollPane4.setViewportView(JTOBSERV);

        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        jLabel15.setText(resourceMap.getString("jLabel15.text")); // NOI18N
        jLabel15.setName("jLabel15"); // NOI18N

        jLabel16.setText(resourceMap.getString("jLabel16.text")); // NOI18N
        jLabel16.setName("jLabel16"); // NOI18N

        jLabel23.setText(resourceMap.getString("jLabel23.text")); // NOI18N
        jLabel23.setName("jLabel23"); // NOI18N

        JTOBSIDOT.setText(resourceMap.getString("JTOBSIDOT.text")); // NOI18N
        JTOBSIDOT.setEnabled(false);
        JTOBSIDOT.setName("JTOBSIDOT"); // NOI18N

        JTOBSPATENTE.setEnabled(false);
        JTOBSPATENTE.setName("JTOBSPATENTE"); // NOI18N

        JTOBSSERVICIO.setEnabled(false);
        JTOBSSERVICIO.setName("JTOBSSERVICIO"); // NOI18N

        JTOBSESTADO.setEnabled(false);
        JTOBSESTADO.setName("JTOBSESTADO"); // NOI18N

        JTOBSIDSERVICIO.setEditable(false);
        JTOBSIDSERVICIO.setText(resourceMap.getString("JTOBSIDSERVICIO.text")); // NOI18N
        JTOBSIDSERVICIO.setEnabled(false);
        JTOBSIDSERVICIO.setName("JTOBSIDSERVICIO"); // NOI18N

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel12.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel12.border.titleColor"))); // NOI18N
        jPanel12.setName("jPanel12"); // NOI18N

        jLabel24.setText(resourceMap.getString("jLabel24.text")); // NOI18N
        jLabel24.setName("jLabel24"); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Servicio", "Mantención", "Reparación" }));
        jComboBox1.setName("jComboBox1"); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jButton18.setText(resourceMap.getString("jButton18.text")); // NOI18N
        jButton18.setName("jButton18"); // NOI18N
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton14.setText(resourceMap.getString("jButton14.text")); // NOI18N
        jButton14.setName("jButton14"); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(JTOBSPATENTE, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTOBSESTADO, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(JTOBSIDOT, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTOBSIDSERVICIO, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTOBSSERVICIO, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(79, 79, 79))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTOBSIDOT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTOBSPATENTE, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTOBSESTADO, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTOBSSERVICIO, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton14)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTOBSIDSERVICIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton6.setText(resourceMap.getString("jButton6.text")); // NOI18N
        jButton6.setName("jButton6"); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(24, 24, 24)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(resourceMap.getString("jPanel8.TabConstraints.tabTitle"), jPanel8); // NOI18N

        jPanel14.setName("jPanel14"); // NOI18N

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel17.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel17.border.titleColor"))); // NOI18N
        jPanel17.setAutoscrolls(true);
        jPanel17.setName("jPanel17"); // NOI18N

        jScrollPane6.setName("jScrollPane6"); // NOI18N

        TablaOT4.setAutoCreateRowSorter(true);
        TablaOT4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaOT4.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        TablaOT4.setName("TablaOT4"); // NOI18N
        TablaOT4.getTableHeader().setReorderingAllowed(false);
        TablaOT4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TablaOT4FocusGained(evt);
            }
        });
        jScrollPane6.setViewportView(TablaOT4);

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel18.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel18.border.titleColor"))); // NOI18N
        jPanel18.setName("jPanel18"); // NOI18N

        jButton20.setText(resourceMap.getString("jButton20.text")); // NOI18N
        jButton20.setName("jButton20"); // NOI18N
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jLabel26.setText(resourceMap.getString("jLabel26.text")); // NOI18N
        jLabel26.setName("jLabel26"); // NOI18N

        jRadioButton9.setText(resourceMap.getString("jRadioButton9.text")); // NOI18N
        jRadioButton9.setName("jRadioButton9"); // NOI18N

        jRadioButton10.setText(resourceMap.getString("jRadioButton10.text")); // NOI18N
        jRadioButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton10.setName("jRadioButton10"); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(jButton20)
                .addGap(22, 22, 22))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel26)
                .addComponent(jRadioButton9)
                .addComponent(jRadioButton10))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jButton20))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBCargarRepuesto.setText(resourceMap.getString("JBCargarRepuesto.text")); // NOI18N
        JBCargarRepuesto.setName("JBCargarRepuesto"); // NOI18N

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel21.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel21.border.titleColor"))); // NOI18N
        jPanel21.setName("jPanel21"); // NOI18N

        jScrollPane9.setName("jScrollPane9"); // NOI18N

        TablaOT6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaOT6.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        TablaOT6.setName("TablaOT6"); // NOI18N
        TablaOT6.getTableHeader().setReorderingAllowed(false);
        TablaOT6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaOT6MouseClicked(evt);
            }
        });
        TablaOT6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TablaOT6FocusGained(evt);
            }
        });
        TablaOT6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TablaOT6KeyPressed(evt);
            }
        });
        jScrollPane9.setViewportView(TablaOT6);

        jScrollPane10.setName("jScrollPane10"); // NOI18N

        JTOBSERV2.setColumns(20);
        JTOBSERV2.setLineWrap(true);
        JTOBSERV2.setRows(5);
        JTOBSERV2.setName("JTOBSERV2"); // NOI18N
        JTOBSERV2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTOBSERV2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTOBSERV2FocusLost(evt);
            }
        });
        jScrollPane10.setViewportView(JTOBSERV2);

        jLabel32.setText(resourceMap.getString("jLabel32.text")); // NOI18N
        jLabel32.setName("jLabel32"); // NOI18N

        jLabel33.setText(resourceMap.getString("jLabel33.text")); // NOI18N
        jLabel33.setName("jLabel33"); // NOI18N

        jLabel34.setText(resourceMap.getString("jLabel34.text")); // NOI18N
        jLabel34.setName("jLabel34"); // NOI18N

        jLabel35.setText(resourceMap.getString("jLabel35.text")); // NOI18N
        jLabel35.setName("jLabel35"); // NOI18N

        JTOBSIDOT2.setEnabled(false);
        JTOBSIDOT2.setName("JTOBSIDOT2"); // NOI18N

        JTOBSPATENTE2.setEnabled(false);
        JTOBSPATENTE2.setName("JTOBSPATENTE2"); // NOI18N

        JTOBSSERVICIO2.setEnabled(false);
        JTOBSSERVICIO2.setName("JTOBSSERVICIO2"); // NOI18N

        JTOBSESTADO2.setEnabled(false);
        JTOBSESTADO2.setName("JTOBSESTADO2"); // NOI18N

        JTOBSIDSERVICIO2.setEditable(false);
        JTOBSIDSERVICIO2.setEnabled(false);
        JTOBSIDSERVICIO2.setName("JTOBSIDSERVICIO2"); // NOI18N

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel22.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel22.border.titleColor"))); // NOI18N
        jPanel22.setName("jPanel22"); // NOI18N

        jLabel36.setText(resourceMap.getString("jLabel36.text")); // NOI18N
        jLabel36.setName("jLabel36"); // NOI18N

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Servicio", "Mantención", "Reparación" }));
        jComboBox4.setName("jComboBox4"); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jButton24.setText(resourceMap.getString("jButton24.text")); // NOI18N
        jButton24.setName("jButton24"); // NOI18N
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setText(resourceMap.getString("jButton25.text")); // NOI18N
        jButton25.setName("jButton25"); // NOI18N
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setText(resourceMap.getString("jButton26.text")); // NOI18N
        jButton26.setName("jButton26"); // NOI18N
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(178, 178, 178))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(JTOBSESTADO2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(188, 188, 188))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(195, 195, 195))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(223, 223, 223))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addComponent(JTOBSSERVICIO2, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTOBSIDSERVICIO2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton25)
                        .addContainerGap())
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JTOBSPATENTE2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTOBSIDOT2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                        .addGap(144, 144, 144))))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTOBSIDOT2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTOBSPATENTE2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTOBSESTADO2)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTOBSSERVICIO2)
                            .addComponent(JTOBSIDSERVICIO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton26)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap(408, Short.MAX_VALUE)
                        .addComponent(JBCargarRepuesto)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(201, 201, 201))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBCargarRepuesto))
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(resourceMap.getString("jPanel14.TabConstraints.tabTitle"), jPanel14); // NOI18N

        jPanel13.setName("jPanel13"); // NOI18N

        JBCargarFalla.setText(resourceMap.getString("JBCargarFalla.text")); // NOI18N
        JBCargarFalla.setName("JBCargarFalla"); // NOI18N

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel15.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel15.border.titleColor"))); // NOI18N
        jPanel15.setAutoscrolls(true);
        jPanel15.setName("jPanel15"); // NOI18N

        jScrollPane5.setName("jScrollPane5"); // NOI18N

        TablaOT3.setAutoCreateRowSorter(true);
        TablaOT3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaOT3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        TablaOT3.setName("TablaOT3"); // NOI18N
        TablaOT3.getTableHeader().setReorderingAllowed(false);
        TablaOT3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TablaOT3FocusGained(evt);
            }
        });
        jScrollPane5.setViewportView(TablaOT3);

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel16.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel16.border.titleColor"))); // NOI18N
        jPanel16.setName("jPanel16"); // NOI18N

        jButton19.setText(resourceMap.getString("jButton19.text")); // NOI18N
        jButton19.setName("jButton19"); // NOI18N
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel25.setText(resourceMap.getString("jLabel25.text")); // NOI18N
        jLabel25.setName("jLabel25"); // NOI18N

        jRadioButton7.setText(resourceMap.getString("jRadioButton7.text")); // NOI18N
        jRadioButton7.setName("jRadioButton7"); // NOI18N

        jRadioButton8.setText(resourceMap.getString("jRadioButton8.text")); // NOI18N
        jRadioButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton8.setName("jRadioButton8"); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(jButton19)
                .addGap(22, 22, 22))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel25)
                .addComponent(jRadioButton7)
                .addComponent(jRadioButton8))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jButton19))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel19.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel19.border.titleColor"))); // NOI18N
        jPanel19.setName("jPanel19"); // NOI18N

        jScrollPane7.setName("jScrollPane7"); // NOI18N

        TablaOT5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaOT5.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        TablaOT5.setName("TablaOT5"); // NOI18N
        TablaOT5.getTableHeader().setReorderingAllowed(false);
        TablaOT5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaOT5MouseClicked(evt);
            }
        });
        TablaOT5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TablaOT5FocusGained(evt);
            }
        });
        TablaOT5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TablaOT5KeyPressed(evt);
            }
        });
        jScrollPane7.setViewportView(TablaOT5);

        jScrollPane8.setName("jScrollPane8"); // NOI18N

        JTOBSERV1.setColumns(20);
        JTOBSERV1.setLineWrap(true);
        JTOBSERV1.setRows(5);
        JTOBSERV1.setName("JTOBSERV1"); // NOI18N
        JTOBSERV1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTOBSERV1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTOBSERV1FocusLost(evt);
            }
        });
        jScrollPane8.setViewportView(JTOBSERV1);

        jLabel27.setText(resourceMap.getString("jLabel27.text")); // NOI18N
        jLabel27.setName("jLabel27"); // NOI18N

        jLabel28.setText(resourceMap.getString("jLabel28.text")); // NOI18N
        jLabel28.setName("jLabel28"); // NOI18N

        jLabel29.setText(resourceMap.getString("jLabel29.text")); // NOI18N
        jLabel29.setName("jLabel29"); // NOI18N

        jLabel30.setText(resourceMap.getString("jLabel30.text")); // NOI18N
        jLabel30.setName("jLabel30"); // NOI18N

        JTOBSIDOT1.setEnabled(false);
        JTOBSIDOT1.setName("JTOBSIDOT1"); // NOI18N

        JTOBSPATENTE1.setEnabled(false);
        JTOBSPATENTE1.setName("JTOBSPATENTE1"); // NOI18N

        JTOBSSERVICIO1.setEnabled(false);
        JTOBSSERVICIO1.setName("JTOBSSERVICIO1"); // NOI18N

        JTOBSESTADO1.setEnabled(false);
        JTOBSESTADO1.setName("JTOBSESTADO1"); // NOI18N

        JTOBSIDSERVICIO1.setEditable(false);
        JTOBSIDSERVICIO1.setEnabled(false);
        JTOBSIDSERVICIO1.setName("JTOBSIDSERVICIO1"); // NOI18N

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel20.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, resourceMap.getColor("jPanel20.border.titleColor"))); // NOI18N
        jPanel20.setName("jPanel20"); // NOI18N

        jLabel31.setText(resourceMap.getString("jLabel31.text")); // NOI18N
        jLabel31.setName("jLabel31"); // NOI18N

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Servicio", "Mantención", "Reparación" }));
        jComboBox2.setName("jComboBox2"); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jButton21.setText(resourceMap.getString("jButton21.text")); // NOI18N
        jButton21.setName("jButton21"); // NOI18N
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setText(resourceMap.getString("jButton22.text")); // NOI18N
        jButton22.setName("jButton22"); // NOI18N
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setText(resourceMap.getString("jButton23.text")); // NOI18N
        jButton23.setName("jButton23"); // NOI18N
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(178, 178, 178))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(JTOBSESTADO1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(188, 188, 188))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(JTOBSPATENTE1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(195, 195, 195))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(JTOBSIDOT1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(223, 223, 223))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addComponent(JTOBSSERVICIO1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTOBSIDSERVICIO1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton22)
                        .addContainerGap())))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTOBSIDOT1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTOBSPATENTE1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTOBSESTADO1)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTOBSSERVICIO1)
                            .addComponent(JTOBSIDSERVICIO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton23)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBCargarFalla)
                        .addGap(28, 28, 28)))
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(209, 209, 209))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBCargarFalla))
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(resourceMap.getString("jPanel13.TabConstraints.tabTitle"), jPanel13); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1331, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
        private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        String[] selectedItems = this.JLServiSelec.getItems();
        for(int i=0;  i<selectedItems.length; i++){
            this.JLServiSelec.remove(selectedItems[i]);
            this.JLServiDispo.add(selectedItems[i]);
        }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String[] selectedItems = this.JLServiSelec.getSelectedItems();
        for(int i=0;  i<selectedItems.length; i++){
            this.JLServiSelec.remove(selectedItems[i]);
            this.JLServiDispo.add(selectedItems[i]);
        }        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String[] selectedItems = this.JLServiDispo.getItems();
        for(int i=0;  i<selectedItems.length; i++){
            this.JLServiDispo.remove(selectedItems[i]);
            this.JLServiSelec.add(selectedItems[i]);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String[] selectedItems = this.JLServiDispo.getSelectedItems();
        for(int i=0;  i<selectedItems.length; i++){
            this.JLServiDispo.remove(selectedItems[i]);
            this.JLServiSelec.add(selectedItems[i]);
        }
    }//GEN-LAST:event_jButton7ActionPerformed
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            System.out.println("INICIO DEFINICION DE VARIABLES");
            ot ordentrabajo = new ot();
            int NUMORDEN = Integer.parseInt(this.JFNUMORDEN.getText());
            String PATENTE = (String) this.JCPATENTE.getSelectedItem().toString().substring(0, 6);
            String RUT_ADMIN = this.JCADMINISTRADOR.getSelectedItem().toString().substring(0, 12);
            String RUT_MECA = this.JCMECANICO.getSelectedItem().toString().substring(0, 12);
            String FECHA_INICIO = this.TCINI1.getSelectedItem() + "-" + this.TCINI2.getSelectedItem() + "-" + this.TCINI3.getSelectedItem();
            String FECHA_TERMINO = this.TCTER1.getSelectedItem() + "-" + this.TCTER2.getSelectedItem() + "-" + this.TCTER3.getSelectedItem();
            String TIPOTRAB = (String) this.JCTRABAJO.getSelectedItem();
            
            System.out.println("Definicion formato fecha");
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MMMMMMMMMM-yyyy", new Locale("es", "ES"));
            java.sql.Date inicio = new java.sql.Date(sdf.parse(FECHA_INICIO).getTime());
            java.sql.Date termino = new java.sql.Date(sdf.parse(FECHA_TERMINO).getTime());
            
            ordentrabajo.setID_OT(NUMORDEN);
            ordentrabajo.setPATENTE(PATENTE);
            ordentrabajo.setRUT_ADMINISTRADOR(RUT_ADMIN);
            ordentrabajo.setRUT_MECANICO(RUT_MECA);
            ordentrabajo.setFECHA_INICIO(inicio);
            ordentrabajo.setFECHA_TERMINO(termino);
            ordentrabajo.setTIPOTRABAJO(TIPOTRAB);
            
            System.out.println("Termino Definición Variables");
            Conexion c = new Conexion();
        
            System.out.println("INICIO impresion variables asignadas");            
            System.out.println("NUM_ORDEN: " +ordentrabajo.getID_OT());
            System.out.println("PATENTE: " +ordentrabajo.getPATENTE());
            System.out.println("RUT ADMINISTRADOR: " +ordentrabajo.getRUT_ADMINISTRADOR());
            System.out.println("RUT MECANICO: " +ordentrabajo.getRUT_MECANICO());
            System.out.println("FECHA INICIO: " +ordentrabajo.getFECHA_INICIO());
            System.out.println("FECHA TERMINO: " +ordentrabajo.getFECHA_TERMINO());
            System.out.println("ID TIPO TRABAJO: " +ordentrabajo.getTIPOTRABAJO());
            System.out.println("TERMINO impresion variables asignadas");
            
            if (!"Seleccionar Patente".equals(this.JCPATENTE.getSelectedItem().toString()) && !"Seleccionar Administrador".equals(this.JCADMINISTRADOR.getSelectedItem().toString()) && !"Seleccionar Mecanico".equals(this.JCMECANICO.getSelectedItem().toString()) && !"Seleccionar Trabajo".equals(this.JCTRABAJO.getSelectedItem().toString()) && !"Dia".equals(this.TCINI1.getSelectedItem().toString()) && !"Mes".equals(this.TCINI2.getSelectedItem().toString()) && !"Ano".equals(this.TCINI3.getSelectedItem().toString()) && !"Dia".equals(this.TCTER1.getSelectedItem().toString()) && !"Mes".equals(this.TCTER2.getSelectedItem().toString()) && !"Año".equals(this.TCTER3.getSelectedItem().toString()))        {
                int n = JOptionPane.showConfirmDialog(rootPane, "¿Esta¡ seguro que desea Guardar?", "Mensajero", JOptionPane.YES_NO_CANCEL_OPTION);
                //n = 0 es YES, n = 1 es NO, n = 2 es Cancel
                System.out.println("numero" + JOptionPane.YES_NO_CANCEL_OPTION);
                if (n == 0) {
                //String query = "begin RegistrarConductor ('"+RUT+"','"+NOMBRE+"','"+APELLIDO_PATERNO+"','"+APELLIDO_MATERNO+"','"+DIRECCION+"',"+TELEFONO+",'"+EMAIL+"',"+COMUNA+",'"+FECHA_INGRESO+"','"+FECHA_RETIRO+"','"+FECHA_NACIMIENTO+"',"+NUM_RADIO+",'"+LICENCIA+"','"+DETALLES+"', "+FOTO+"); end;";       
                try {
                c.registrarOT(ordentrabajo);
                ResetearCampos();
                String query5 = "Select id_servicio, nombre from servicio";
                ResultSet rs5 = Conexion.ejecutarQuery(query5);
                while (rs5.next()) {        
                    this.JLServiDispo.add(rs5.getString("nombre"));
                }
                JOptionPane.showMessageDialog(null, "Datos Ingresados Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);
                CargarOT();
                
                System.out.println ("OBTENCION DE MARCA Y MODELO VEHICULO SEGUN PATENTE");
                String query = "Select marca, modelo from vehiculo where patente ='"+ordentrabajo.getPATENTE()+"'";
                ResultSet rs = Conexion.ejecutarQuery(query);
                while (rs.next()) {
                     this.JDSPATENTE.setText(ordentrabajo.getPATENTE());
                     this.JDSMARCA.setText(rs.getString("marca"));
                     this.JDSMODELO.setText(rs.getString("modelo"));
                     this.JDSNUMORDEN.setText(String.valueOf(ordentrabajo.getID_OT()));
                     }
                                
                } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Se ha producido un error en la inserciÃ³n", "Error", JOptionPane.ERROR_MESSAGE);
                
                }        
                
            } else if (n == 1) {
            ResetearCampos();
                }
            }else{
                JOptionPane.showMessageDialog(null,"Codigo: " +"Debe llenar todos los campos solicitados", "Error", JOptionPane.ERROR_MESSAGE); 
            }
                    
        } catch (ParseException ex) {
            Logger.getLogger(OT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void JCPATENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCPATENTEActionPerformed

    }//GEN-LAST:event_JCPATENTEActionPerformed

    private void JCPATENTEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCPATENTEItemStateChanged
        try {
            //CREAR VISTAS DE ESTAS WEAS MENOS DE BUSCAR VEHICULO Q ESTA HECHA
                 String patente = this.JCPATENTE.getSelectedItem().toString().substring(0, 6);
                 System.out.println("PATENTE: "+patente);
                 String query = "Select max(id_ot) from orden_trabajo where patente ='"+patente+"'";
                 ResultSet rs = Conexion.ejecutarQuery(query);
                 while (rs.next()) {
                     if (rs.getString("max(id_ot)") != null){
                     int id = Integer.parseInt(rs.getString("max(id_ot)"))+1;
                     this.JFNUMORDEN.setText(String.valueOf(id));               
                     }
                     else if (this.JCPATENTE.getSelectedItem().equals("Seleccionar Patente")){
                     this.JFNUMORDEN.setText(null);
                     }
                     else{
                     this.JFNUMORDEN.setText("1");
                     }
                 }
        } catch (SQLException ex) {
            Logger.getLogger(OT.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }//GEN-LAST:event_JCPATENTEItemStateChanged

    private void TablaOTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaOTFocusGained
    int y = this.TablaOT.getSelectedColumn();
    int x = this.TablaOT.getSelectedRow();
   
    String idot = (String) TablaOT.getValueAt(x,0);
    String patente = (String) TablaOT.getValueAt(x,1); 
    TablaOT.getValueAt(x, y); //CON ESTE OBTENGO EL VALOR DE LA CELDA SELECCIONADA
    System.out.println("VALOR EN CELDA SELECCIONADA " +TablaOT.getValueAt(x, 0)); //esto sirve para seleccionar cualquier fila y que me tome el valor de la primera columna
    System.out.println("VALOR EN CELDA SELECCIONADA " +TablaOT.getValueAt(x, 1)); //esto sirve para seleccionar cualquier fila y que me tome el valor de la segunda columna
   
    }//GEN-LAST:event_TablaOTFocusGained

    private void TablaOT1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaOT1FocusGained
    int y = this.TablaOT1.getSelectedColumn();
    int x = this.TablaOT1.getSelectedRow();
    
    TablaOT1.getValueAt(x, y); //CON ESTE OBTENGO EL VALOR DE LA CELDA SELECCIONADA
    System.out.println("VALOR EN CELDA SELECCIONADA " +TablaOT1.getValueAt(x, y));
    
    //Con este saco el IDOT
    System.out.println("VALOR EN CELDA SELECCIONADA " +TablaOT1.getValueAt(x, 0)); //esto sirve para seleccionar cualquier fila y que me tome el valor de la primera columna           
    }//GEN-LAST:event_TablaOT1FocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        if (this.JCPATENTE.isEnabled() == false){
        HabilitarCampos();
        CargaOrden();          
        }    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            int y = this.TablaOT.getSelectedColumn();
            int x = this.TablaOT.getSelectedRow();    
            String idot = (String) TablaOT.getValueAt(x,0);
            String patente = (String) TablaOT.getValueAt(x,1); 
            /*Connection con = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.clave);
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("BEGIN CargaConductores(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); END;");
            System.out.println("***INICIO CARGA OTSERVICIO***");
            System.out.println("Setiando Parametros ENTRADA");
            System.out.println("IDOT: " +idot+ "PATENTE: " +patente);
            cs.setInt(1, Integer.parseInt(idot));
            cs.setString(2, patente);

            System.out.println("Setiando Parametros SALIDA");
            cs.registerOutParameter(3, Types.INTEGER);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.execute();
            int ID_SERVICIO = 0;
            String OBSERVACIONES = null;
            String ESTADO = null;
            //Asignacion a las variables
            ID_SERVICIO = cs.getOracleObject(3).intValue();
            OBSERVACIONES = cs.getOracleObject(4).stringValue();
            ESTADO = cs.getOracleObject(5).stringValue();  
             * 
             */
            //String query = "select ots.id_ot, ots.patente, ots.id_servicio, s.nombre, ots.observaciones, ots.estado from orden_trabajo_servicio ots, servicio s where ots.id_servicio = s.id_servicio and id_ot= "+Integer.parseInt(idot)+" and patente= '"+patente+"'";
            String query = "select ots.id_ot, ots.patente, ots.id_servicio, s.nombre, ots.observaciones ,ots.estado from orden_trabajo_servicio ots, servicio s where ots.id_servicio = s.id_servicio and id_ot= "+Integer.parseInt(idot)+" and patente= '"+patente+"'";
            ResultSet rs = Conexion.ejecutarQuery(query);                       
            ot.llenarTablaOT2(TablaOT2, rs);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
            System.out.println("AQUI ENTRE PARA COMENZAR A GUARDAR OTSERVICIO");
            System.out.println("jdspatente: " +this.JDSPATENTE.getText().trim());
            if(this.JDSPATENTE.getText().trim() != null && this.JDSMARCA.getText().trim() != null && this.JDSMODELO.getText().trim() != null && this.JDSNUMORDEN.getText().trim() != null && this.JLServiSelec.getItemCount()>0) {
            String[] selectedItems = this.JLServiSelec.getItems();
            Conexion c = new Conexion();
            for (int i = 0; i < selectedItems.length; i++) {
            try {
                System.out.println("AQUI ENTRE AL TRY");
                this.JLServiDispo.add(selectedItems[i]);
                String nombre = selectedItems[i];
                String query = "Select id_servicio from servicio where nombre = '"+nombre+"'";
                ResultSet rs = Conexion.ejecutarQuery(query);
                while (rs.next()) {
                    System.out.println("AQUI ENTRE AL WHILE");
                    String patente = this.JDSPATENTE.getText();
                    int idOT = Integer.parseInt(this.JDSNUMORDEN.getText());          
                    int idServ = Integer.parseInt(rs.getString("id_servicio"));
                    System.out.println ("AQUI ESTOY ANTES DE MANDAR LOS DATOS");
                    System.out.println ("IDOT: " +idOT);
                    System.out.println ("PATENTE: " +patente);
                    System.out.println ("IDSERVICIO: " +idServ);
                    
                    c.registrarOTSERVICIO(idOT, patente, idServ);
                }
            }   catch (DocumentException ex) {
                    Logger.getLogger(OT.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(OT.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                System.out.println("AQUI ENTRE AL CATCH");
                Logger.getLogger(OT.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
            }
                
            }                    
            JOptionPane.showMessageDialog(null, "¡Guardado con exito!");   
            this.JLServiSelec.removeAll();
            this.JDSPATENTE.setText(null);
            this.JDSMARCA.setText(null);
            this.JDSMODELO.setText(null);
            this.JDSNUMORDEN.setText(null);
            
            }
                
            
            else{
            JOptionPane.showMessageDialog(null, "No hay datos para ingresar");            
            }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void TablaOT2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaOT2MouseClicked
        int y = this.TablaOT2.getSelectedColumn();
        int x = this.TablaOT2.getSelectedRow();    
        String IDOT =(String) TablaOT2.getValueAt(x,0);
        String PATENTE = (String) TablaOT2.getValueAt(x,1); 
        String IDSERVICIO = (String) TablaOT2.getValueAt(x,2); 
        String SERVICIO = (String) TablaOT2.getValueAt(x,3);
        String OBSERVACION = (String) TablaOT2.getValueAt(x,4);
        String ESTADO = (String) TablaOT2.getValueAt(x,5);
        System.out.println("ASIGNANDO VARIABLES");
        this.JTOBSIDOT.setText(IDOT);
        this.JTOBSPATENTE.setText(PATENTE);
        this.JTOBSIDSERVICIO.setText(IDSERVICIO);
        this.JTOBSSERVICIO.setText(SERVICIO);
        this.JTOBSESTADO.setText(ESTADO); 
        this.JTOBSERV.setText(OBSERVACION);
    }//GEN-LAST:event_TablaOT2MouseClicked

    private void TablaOT2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaOT2FocusGained
        int y = this.TablaOT2.getSelectedColumn();
        int x = this.TablaOT2.getSelectedRow();    
        String IDOT =(String) TablaOT2.getValueAt(x,0);
        String PATENTE = (String) TablaOT2.getValueAt(x,1); 
        String IDSERVICIO = (String) TablaOT2.getValueAt(x,2); 
        String SERVICIO = (String) TablaOT2.getValueAt(x,3);
        String OBSERVACION = (String) TablaOT2.getValueAt (x,4);
        String ESTADO = (String) TablaOT2.getValueAt(x,5);
        System.out.println("ASIGNANDO VARIABLES");
        this.JTOBSIDOT.setText(IDOT);
        this.JTOBSPATENTE.setText(PATENTE);
        this.JTOBSIDSERVICIO.setText(IDSERVICIO);
        this.JTOBSSERVICIO.setText(SERVICIO);
        this.JTOBSESTADO.setText(ESTADO);
        this.JTOBSERV.setText(OBSERVACION);
        
    }//GEN-LAST:event_TablaOT2FocusGained

    private void TablaOT2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaOT2KeyPressed
        int y = this.TablaOT2.getSelectedColumn();
        int x = this.TablaOT2.getSelectedRow();    
        String IDOT =(String) TablaOT2.getValueAt(x,0);
        String PATENTE = (String) TablaOT2.getValueAt(x,1); 
        String IDSERVICIO = (String) TablaOT2.getValueAt(x,2); 
        String SERVICIO = (String) TablaOT2.getValueAt(x,3);
        String ESTADO = (String) TablaOT2.getValueAt(x,5);
        System.out.println("ASIGNANDO VARIABLES");
        this.JTOBSIDOT.setText(IDOT);
        this.JTOBSPATENTE.setText(PATENTE);
        this.JTOBSIDSERVICIO.setText(IDSERVICIO);
        this.JTOBSSERVICIO.setText(SERVICIO);
        this.JTOBSESTADO.setText(ESTADO);        
    }

    
    /*  
    }//GEN-LAST:event_TablaOT2KeyPressed
*/      
    private void JTOBSERVFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTOBSERVFocusGained
       
    }//GEN-LAST:event_JTOBSERVFocusGained

    private void JTOBSERVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTOBSERVFocusLost
         
    }//GEN-LAST:event_JTOBSERVFocusLost

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int x = this.TablaOT2.getSelectedRow();    
        String OBSERVACION = this.JTOBSERV.getText();
        TablaOT2.setValueAt(OBSERVACION, x, 4);
        System.out.println("ASIGNANDO VARIABLES"); 
        this.JTOBSERV.setText(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        this.JTOBSERV.setText(null);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
      /*  System.out.println("INICIO IMPRESION BOTON");
        int y = this.TablaOT2.getRowCount();
        int x = this.TablaOT2.getColumnCount();   
        
        
        for(int z=0; z<y; z++){
            //FILAS
            System.out.println("DENTRO DEL PRIMER FOR, FILAS: " +y);
            String[] datos = new String[6];
            for (int i=0; i<x; i++){            
                System.out.println("DENTRO DEL SEGUNDO FOR, COLUMNAS: " +x);
                //estas son las columnas
                datos[i] = (String) TablaOT2.getValueAt(z,i);                                        
                System.out.println(TablaOT2.getValueAt(z,i));                                        
             
            }
        String query = "update orden_trabajo_servicio ots set ots.observaciones = "+datos[5]+" where id_ot="+Integer.parseInt(datos[0])+" and patente='"+datos[1]+"' and id_servicio = '"+datos[3]+"'";
        }
        
        System.out.println("filas: " +y);
        System.out.println("columnas: " +x);
        //String idot = (String) TablaOT.getValueAt(x,0);
        //String patente = (String) TablaOT.getValueAt(x,1); 
       * 
       */

    }//GEN-LAST:event_jButton14ActionPerformed

private void TablaOT3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaOT3FocusGained
// TODO add your handling code here:
}//GEN-LAST:event_TablaOT3FocusGained

private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButton19ActionPerformed

private void TablaOT4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaOT4FocusGained
// TODO add your handling code here:
}//GEN-LAST:event_TablaOT4FocusGained

private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButton20ActionPerformed

private void TablaOT5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaOT5MouseClicked
// TODO add your handling code here:
}//GEN-LAST:event_TablaOT5MouseClicked

private void TablaOT5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaOT5FocusGained
// TODO add your handling code here:
}//GEN-LAST:event_TablaOT5FocusGained

private void TablaOT5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaOT5KeyPressed
// TODO add your handling code here:
}//GEN-LAST:event_TablaOT5KeyPressed

private void JTOBSERV1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTOBSERV1FocusGained
// TODO add your handling code here:
}//GEN-LAST:event_JTOBSERV1FocusGained

private void JTOBSERV1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTOBSERV1FocusLost
// TODO add your handling code here:
}//GEN-LAST:event_JTOBSERV1FocusLost

private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButton21ActionPerformed

private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButton22ActionPerformed

private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButton23ActionPerformed

private void TablaOT6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaOT6MouseClicked
// TODO add your handling code here:
}//GEN-LAST:event_TablaOT6MouseClicked

private void TablaOT6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TablaOT6FocusGained
// TODO add your handling code here:
}//GEN-LAST:event_TablaOT6FocusGained

private void TablaOT6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaOT6KeyPressed
// TODO add your handling code here:
}//GEN-LAST:event_TablaOT6KeyPressed

private void JTOBSERV2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTOBSERV2FocusGained
// TODO add your handling code here:
}//GEN-LAST:event_JTOBSERV2FocusGained

private void JTOBSERV2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTOBSERV2FocusLost
// TODO add your handling code here:
}//GEN-LAST:event_JTOBSERV2FocusLost

private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButton24ActionPerformed

private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButton25ActionPerformed

private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButton26ActionPerformed

private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButton15ActionPerformed

private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButton16ActionPerformed

private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButton17ActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCargarFalla;
    private javax.swing.JButton JBCargarRepuesto;
    private javax.swing.JComboBox JCADMINISTRADOR;
    private javax.swing.JComboBox JCMECANICO;
    private javax.swing.JComboBox JCPATENTE;
    private javax.swing.JComboBox JCTRABAJO;
    private javax.swing.JFormattedTextField JDSMARCA;
    private javax.swing.JFormattedTextField JDSMODELO;
    private javax.swing.JFormattedTextField JDSNUMORDEN;
    private javax.swing.JFormattedTextField JDSPATENTE;
    private javax.swing.JFormattedTextField JFNUMORDEN;
    private java.awt.List JLServiDispo;
    private java.awt.List JLServiSelec;
    private javax.swing.JTextArea JTOBSERV;
    private javax.swing.JTextArea JTOBSERV1;
    private javax.swing.JTextArea JTOBSERV2;
    private javax.swing.JTextField JTOBSESTADO;
    private javax.swing.JTextField JTOBSESTADO1;
    private javax.swing.JTextField JTOBSESTADO2;
    private javax.swing.JTextField JTOBSIDOT;
    private javax.swing.JTextField JTOBSIDOT1;
    private javax.swing.JTextField JTOBSIDOT2;
    private javax.swing.JTextField JTOBSIDSERVICIO;
    private javax.swing.JTextField JTOBSIDSERVICIO1;
    private javax.swing.JTextField JTOBSIDSERVICIO2;
    private javax.swing.JTextField JTOBSPATENTE;
    private javax.swing.JTextField JTOBSPATENTE1;
    private javax.swing.JTextField JTOBSPATENTE2;
    private javax.swing.JTextField JTOBSSERVICIO;
    private javax.swing.JTextField JTOBSSERVICIO1;
    private javax.swing.JTextField JTOBSSERVICIO2;
    private javax.swing.JComboBox TCINI1;
    private javax.swing.JComboBox TCINI2;
    private javax.swing.JComboBox TCINI3;
    private javax.swing.JComboBox TCTER1;
    private javax.swing.JComboBox TCTER2;
    private javax.swing.JComboBox TCTER3;
    private javax.swing.JTable TablaOT;
    private javax.swing.JTable TablaOT1;
    private javax.swing.JTable TablaOT2;
    private javax.swing.JTable TablaOT3;
    private javax.swing.JTable TablaOT4;
    private javax.swing.JTable TablaOT5;
    private javax.swing.JTable TablaOT6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JComboBox jcasdasd1;
    // End of variables declaration//GEN-END:variables
}
