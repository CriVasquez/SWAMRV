/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Repuestos.java
 *
 * Created on 29-12-2011, 12:16:32 AM
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleCallableStatement;
import soprafamrv.BD.Conexion;
import soprafamrv.SISTEMA.miPanel;
import soprafamrv.SISTEMA.repuesto;
import soprafamrv.SISTEMA.subeImagen;


/**
 *
 * @author Cri
 */
public class Repuesto extends javax.swing.JInternalFrame {

    /** Creates new form Repuestos */
    public Repuesto() throws SQLException {
        initComponents();
        CargarRepuestos();
        
    }
    byte[] IMAGEN;
    int contador = 0;
    int contador2 = 0;
    
    private void HabilitarCampos(boolean x){
        this.JFCODREP.setEnabled(x);
        this.JFNOMBRE.setEnabled(x);
        this.JTEXTDESCRIP.setEnabled(x);            
        this.jButton4.setEnabled(x);
        this.JRGuardar.setEnabled(x);
    }
    
    private void ResetearCampos(){    
        this.JFCODREP.setText(null);
        this.JFNOMBRE.setText(null);
        this.JTEXTDESCRIP.setText(null);   
        this.JPanelImagen.removeAll();
        this.JPanelImagen.repaint();        
    }
    
    private void CargarRepuestos() throws SQLException{
        String query = "Select nombre from repuesto";
        ResultSet rs = Conexion.ejecutarQuery(query);
        while (rs.next()) {
            this.JLRepueR.add(rs.getString("nombre"));
         }
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
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTEXTDESCRIP = new javax.swing.JTextArea();
        JFNOMBRE = new javax.swing.JFormattedTextField();
        JFCODREP = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        JPanelImagen = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        JRGuardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        JLRepueR = new java.awt.List();
        jButton6 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(soprafamrv.SOPRAFAMRVApp0.class).getContext().getResourceMap(Repuesto.class);
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
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setName("jButton3"); // NOI18N
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setName("jPanel2"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        JTEXTDESCRIP.setColumns(20);
        JTEXTDESCRIP.setLineWrap(true);
        JTEXTDESCRIP.setRows(5);
        JTEXTDESCRIP.setEnabled(false);
        JTEXTDESCRIP.setName("JTEXTDESCRIP"); // NOI18N
        jScrollPane1.setViewportView(JTEXTDESCRIP);

        JFNOMBRE.setEnabled(false);
        JFNOMBRE.setName("JFNOMBRE"); // NOI18N

        JFCODREP.setEditable(false);
        JFCODREP.setName("JFCODREP"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(JFCODREP, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JFNOMBRE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JFCODREP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JFNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        JPanelImagen.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("JPanelImagen.border.title"))); // NOI18N
        JPanelImagen.setName("JPanelImagen"); // NOI18N

        javax.swing.GroupLayout JPanelImagenLayout = new javax.swing.GroupLayout(JPanelImagen);
        JPanelImagen.setLayout(JPanelImagenLayout);
        JPanelImagenLayout.setHorizontalGroup(
            JPanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
        JPanelImagenLayout.setVerticalGroup(
            JPanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(soprafamrv.SOPRAFAMRVApp0.class).getContext().getActionMap(Repuesto.class, this);
        jButton4.setAction(actionMap.get("Task")); // NOI18N
        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setEnabled(false);
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        JRGuardar.setText(resourceMap.getString("JRGuardar.text")); // NOI18N
        JRGuardar.setEnabled(false);
        JRGuardar.setName("JRGuardar"); // NOI18N
        JRGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4))
                            .addComponent(JPanelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(JRGuardar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JPanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JRGuardar)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel3.border.title"))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        JLRepueR.setName("JLRepueR"); // NOI18N

        jButton6.setText(resourceMap.getString("jButton6.text")); // NOI18N
        jButton6.setName("jButton6"); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLRepueR, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLRepueR, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addGap(689, 689, 689))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(865, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(280, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(71, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
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
}//GEN-LAST:event_jButton4ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            HabilitarCampos(true);
            String query = "Select max(id_repuesto) from repuesto";
            ResultSet rs = Conexion.ejecutarQuery(query);
            while (rs.next()) {
                if (rs.getString("max(id_repuesto)") != null){
                    int id = Integer.parseInt(rs.getString("max(id_repuesto)"))+1;
                    this.JFCODREP.setText(String.valueOf(id));               
                
                }else{
                    this.JFCODREP.setText("1");
                    }
                 }
        } catch (SQLException ex) {
            Logger.getLogger(Repuesto.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jButton1ActionPerformed

private void JRGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRGuardarActionPerformed
    subeImagen s = new subeImagen();    
    repuesto r = new repuesto();
    
    System.out.println("Inicio Definición Variables");
    int ID_REPUESTO = Integer.parseInt(this.JFCODREP.getText());    
    String NOMBRE = this.JFNOMBRE.getText().toUpperCase().trim();        
    String DESCRIPCION  = this.JTEXTDESCRIP.getText().toUpperCase().trim();    
    byte[] FOTO = IMAGEN;   
    if (contador2 == 1){
            System.out.println("numero contador2: " +contador2);
            FOTO = s.ObtenerBytes();    
        }
    else if(contador2 == 2){
            FOTO = s.ObtenerBytes();    
    }
    System.out.println("Termino Definición Variables");
    
    r.setID_REPUESTO(ID_REPUESTO);
    r.setNOMBRE(NOMBRE);    
    r.setDETALLE(DESCRIPCION);
    r.setFOTO(FOTO);
    
    repuesto conexionRepuesto = new repuesto();
    
    System.out.println("Termino Definición Variables");
    
    System.out.println("INICIO impresion variables asignadas");
    System.out.println("ID_REPUESTO: " +r.getID_REPUESTO());
    System.out.println("NOMBRE: " +r.getNOMBRE());    
    System.out.println("DESCRIPCION: " +r.getDETALLE());
    System.out.println("FOTO: " +r.getFOTO());
    if (contador == 2){
        if (r.getID_REPUESTO() != 0 && r.getNOMBRE() != null &&  r.getDETALLE() != null && r.getFOTO() != null){
            int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Guardar?", "Mensajero", JOptionPane.YES_NO_CANCEL_OPTION);
            //n = 0 es YES, n = 1 es NO, n = 2 es Cancel
            System.out.println("numero" + JOptionPane.YES_NO_CANCEL_OPTION);
            if (n == 0) {
                try {
                conexionRepuesto.actualizarRepuesto(r);
                ResetearCampos();
                JPanelImagen.removeAll();        
                JPanelImagen.repaint();                
                contador = 0;
                contador2 = 0;                
                HabilitarCampos(false);
                this.JLRepueR.removeAll();                
                CargarRepuestos();
                JOptionPane.showMessageDialog(null, "Datos Actualizados Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);
                
                } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Se ha producido un error en la inserción", "Error", JOptionPane.ERROR_MESSAGE);
                
                }        
            } else if (n == 1) {
            ResetearCampos();
      }

        }
        else{
            JOptionPane.showMessageDialog(null,"Codigo: " +"Debe llenar todos los campos solicitados", "Error", JOptionPane.ERROR_MESSAGE); 
        }
    }
    else{
        if (r.getID_REPUESTO() != 0 && r.getNOMBRE() != null &&  r.getDETALLE() != null && r.getFOTO() != null){
            int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Guardar?", "Mensajero", JOptionPane.YES_NO_CANCEL_OPTION);
            //n = 0 es YES, n = 1 es NO, n = 2 es Cancel
            System.out.println("numero" + JOptionPane.YES_NO_CANCEL_OPTION);
            if (n == 0) {
    
                try {
                conexionRepuesto.registrarRepuesto(r);
                ResetearCampos();
                JPanelImagen.removeAll();        
                JPanelImagen.repaint();
                JOptionPane.showMessageDialog(null, "Datos Ingresados Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);
                contador = 0;
                contador2 = 0;                                
                HabilitarCampos(false);      
                this.JLRepueR.removeAll();
                CargarRepuestos();
                
                } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Se ha producido un error en la inserción", "Error", JOptionPane.ERROR_MESSAGE);
                
                }        
            } else if (n == 1) {
            ResetearCampos();
      }

        }
        else{
            JOptionPane.showMessageDialog(null,"Codigo: " +"Debe llenar todos los campos solicitados", "Error", JOptionPane.ERROR_MESSAGE); 
        }
    }
}//GEN-LAST:event_JRGuardarActionPerformed

private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            ResetearCampos();         
            String NOMBRE = this.JLRepueR.getSelectedItem();      
            repuesto r = new repuesto();
            r.ObtenerRepuesto(NOMBRE);
            
            System.out.println("imprimiendo ID REPUESTO: " +r.getID_REPUESTO());
            System.out.println("imprimiendo NOMBRE: " +r.getNOMBRE());
            System.out.println("imprimiendo DETALLE: " +r.getDETALLE());
            System.out.println("imprimiendo FOTO: " +r.getFOTO());
            this.JFNOMBRE.setText(NOMBRE);            
            this.JFCODREP.setText(String.valueOf(r.getID_REPUESTO()));             
            this.JTEXTDESCRIP.setText(r.getDETALLE());
            IMAGEN = r.getFOTO();
            
            InputStream z = new ByteArrayInputStream(r.getFOTO());
            BufferedImage FOTO = ImageIO.read(z);
            JPanelImagen.add(new miPanel(FOTO, JPanelImagen.getSize()));
            JPanelImagen.setVisible(true);              
            JPanelImagen.repaint();
            contador = 1;
                        
        } catch (IOException ex) {           
            Logger.getLogger(RetiroRepuesto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("PROBLEMA1");
        } catch (SQLException ex) {        
            Logger.getLogger(RetiroRepuesto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("PROBLEMA2");
        }      
}//GEN-LAST:event_jButton6ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    if (contador == 1){
        HabilitarCampos(true);
        contador = 2;
    }    
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    if (contador == 1 || contador == 2){            
        int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Eliminar?", "Mensajero", JOptionPane.YES_NO_OPTION);
        if (n == 0){
                try {
                    repuesto r = new repuesto();
                    System.out.println("IMPRIMIENDO N :" +n);
                    int IDREPUESTO = Integer.parseInt(this.JFCODREP.getText());
                    r.borrarRepuesto(IDREPUESTO);
                    this.JLRepueR.removeAll();
                    CargarRepuestos();
                    ResetearCampos();
                    HabilitarCampos(false);                                        
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else{
            System.out.println("IMPRIMIENDO N :" +n);
            ResetearCampos();
        }
    }
    else {
        JOptionPane.showMessageDialog(null, "Primero debe cargar un Vehiculo", "Mensajero", JOptionPane.INFORMATION_MESSAGE);
    }    
}//GEN-LAST:event_jButton2ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField JFCODREP;
    private javax.swing.JFormattedTextField JFNOMBRE;
    private java.awt.List JLRepueR;
    private javax.swing.JPanel JPanelImagen;
    private javax.swing.JButton JRGuardar;
    private javax.swing.JTextArea JTEXTDESCRIP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
