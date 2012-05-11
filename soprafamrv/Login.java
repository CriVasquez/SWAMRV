/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Login.java
 *
 * Created on Apr 20, 2012, 12:53:29 AM
 */
package soprafamrv;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import soprafamrv.BD.Conexion;

/**
 *
 * @author Cri
 */
public class Login extends javax.swing.JFrame {

    /** Creates new form Login */
    public Login() {
        initComponents();
        setBounds(400, 200, 460, 350);
        PruebaConexion();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBLimpiar = new javax.swing.JButton();
        JBIngresar = new javax.swing.JButton();
        JFLOGINRUT = new javax.swing.JFormattedTextField();
        LabelContraseña = new javax.swing.JLabel();
        JPCONTRASENA = new javax.swing.JPasswordField();
        LabelUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LabelTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        LabelVersion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        LabelEstadoConexion = new javax.swing.JLabel();
        LabelESTADO = new javax.swing.JLabel();
        JCTipoCuenta = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(soprafamrv.SOPRAFAMRVApp0.class).getContext().getResourceMap(Login.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);

        JBLimpiar.setText(resourceMap.getString("JBLimpiar.text")); // NOI18N
        JBLimpiar.setName("JBLimpiar"); // NOI18N
        JBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimpiarActionPerformed(evt);
            }
        });

        JBIngresar.setText(resourceMap.getString("JBIngresar.text")); // NOI18N
        JBIngresar.setName("JBIngresar"); // NOI18N
        JBIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBIngresarActionPerformed(evt);
            }
        });

        try {
            JFLOGINRUT.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-A")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JFLOGINRUT.setName("JFLOGINRUT"); // NOI18N
        JFLOGINRUT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JFLOGINRUTFocusLost(evt);
            }
        });

        LabelContraseña.setText(resourceMap.getString("LabelContraseña.text")); // NOI18N
        LabelContraseña.setName("LabelContraseña"); // NOI18N

        JPCONTRASENA.setText(resourceMap.getString("JPCONTRASENA.text")); // NOI18N
        JPCONTRASENA.setName("JPCONTRASENA"); // NOI18N

        LabelUsuario.setText(resourceMap.getString("LabelUsuario.text")); // NOI18N
        LabelUsuario.setName("LabelUsuario"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        LabelTitulo.setFont(resourceMap.getFont("LabelTitulo.font")); // NOI18N
        LabelTitulo.setText(resourceMap.getString("LabelTitulo.text")); // NOI18N
        LabelTitulo.setName("LabelTitulo"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        LabelVersion.setFont(resourceMap.getFont("LabelVersion.font")); // NOI18N
        LabelVersion.setText(resourceMap.getString("LabelVersion.text")); // NOI18N
        LabelVersion.setName("LabelVersion"); // NOI18N

        jSeparator1.setName("jSeparator1"); // NOI18N

        LabelEstadoConexion.setText(resourceMap.getString("LabelEstadoConexion.text")); // NOI18N
        LabelEstadoConexion.setName("LabelEstadoConexion"); // NOI18N

        LabelESTADO.setText(resourceMap.getString("LabelESTADO.text")); // NOI18N
        LabelESTADO.setName("LabelESTADO"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(LabelVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                .addComponent(LabelEstadoConexion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelEstadoConexion)))
        );

        JCTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo cuenta", "Administrador", "Encargado Bodega" }));
        JCTipoCuenta.setName("JCTipoCuenta"); // NOI18N

        jLabel1.setIcon(resourceMap.getIcon("jLabel1.icon")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(JBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(JCTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(LabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(LabelContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(LabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(JBIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(JPCONTRASENA, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(JFLOGINRUT, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel4))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(JBLimpiar))
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(JCTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(LabelUsuario))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(LabelContraseña))
            .addComponent(LabelTitulo)
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(JBIngresar))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(JPCONTRASENA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(JFLOGINRUT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void JFLOGINRUTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JFLOGINRUTFocusLost
 // Si es encargado de bodega, solo puede ver el módulo Repuesto
}//GEN-LAST:event_JFLOGINRUTFocusLost

private void JBIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBIngresarActionPerformed
        try {
            if (this.JCTipoCuenta.getSelectedItem() == "Encargado Bodega"){
                
            Principal p = new Principal();
            p.show();
            p.JBFalla.setEnabled(false);
            p.JBOT.setEnabled(false);
            p.JBPersonal.setEnabled(false);
            p.JBVehiculo.setEnabled(false);
            RetiroRepuesto rp = new RetiroRepuesto();
            String query = "Select nombre, apellido_paterno, apellido_materno from Encargado_Bodega where rut_encargado='"+this.JFLOGINRUT.getText()+"'";
            ResultSet rs = Conexion.ejecutarQuery(query);
            while (rs.next()){
                rp.RUT = "hola";
                        
            }
            
            }
            else{
            Principal p = new Principal();
            p.show();
            RetiroRepuesto rp = new RetiroRepuesto();
            //String query = "Select nombre, apellido_paterno, apellido_materno from Administrador where rut_administrador='"+this.JFLOGINRUT.getText()+"'";
            //ResultSet rs = Conexion.ejecutarQuery(query);
            //while (rs.next()){
                rp.RUT = this.JFLOGINRUT.getText();
            //}
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_JBIngresarActionPerformed

private void JBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimpiarActionPerformed
    this.JFLOGINRUT.setText(null);
    this.JPCONTRASENA.setText(null);    
}//GEN-LAST:event_JBLimpiarActionPerformed

private void PruebaConexion(){
    try {
            //esto es la manera simple, podrias buscar sobre el patron de diseño singleton, que optimiza las llamadas a la bd
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            Conexion.con = DriverManager.getConnection(Conexion.url, Conexion.usuario, Conexion.clave);
            System.out.println ("Conectado");
            this.LabelESTADO.setText("Conectado");
            this.LabelESTADO.setForeground(Color.BLUE);   
        } catch (SQLException e) {
            System.out.println ("SIN CONEXION");
            this.LabelESTADO.setText("Sin conexión");
            this.LabelESTADO.setForeground(Color.red);    
        }

}
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBIngresar;
    private javax.swing.JButton JBLimpiar;
    private javax.swing.JComboBox JCTipoCuenta;
    private javax.swing.JFormattedTextField JFLOGINRUT;
    private javax.swing.JPasswordField JPCONTRASENA;
    private javax.swing.JLabel LabelContraseña;
    private javax.swing.JLabel LabelESTADO;
    private javax.swing.JLabel LabelEstadoConexion;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JLabel LabelVersion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
