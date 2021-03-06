/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Fallas.java
 *
 * Created on 29-12-2011, 12:09:31 AM
 */
package soprafamrv;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import soprafamrv.BD.Conexion;
import soprafamrv.SISTEMA.falla;
import soprafamrv.SISTEMA.miPanel;
import soprafamrv.SISTEMA.subeImagen;

/**
 *
 * @author Cri
 */
public class Falla extends javax.swing.JInternalFrame {

    /** Creates new form Fallas */
    public Falla() {
        initComponents();   
        CargarFallas();
    }
    byte[] IMAGEN;
    int contador = 0;
    int contador2 = 0;    
    
    private void CargarFallas(){
        try {
            this.JLFallaR.removeAll();
            String query = "Select nombre from falla";
            ResultSet rs = Conexion.ejecutarQuery(query);
            while (rs.next()) {
                this.JLFallaR.add(rs.getString("nombre"));
             }
        } catch (SQLException ex) {
            Logger.getLogger(Falla.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void HabilitarCampos(boolean x){
        this.JFCODFALL.setEnabled(x);
        this.JFNOMBRE.setEnabled(x);
        this.JTEXTDESCRIP.setEnabled(x);
        this.jButton4.setEnabled(x);
        this.JRGuardar.setEnabled(x);
    }
    
    private void ResetearCampos(){
        IMAGEN = null;
        this.JFCODFALL.setText(null);
        this.JFNOMBRE.setText(null);
        this.JTEXTDESCRIP.setText(null);
        this.JPanelImagen.removeAll();
        this.JPanelImagen.repaint();
    
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
        jPanel3 = new javax.swing.JPanel();
        JLFallaR = new java.awt.List();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTEXTDESCRIP = new javax.swing.JTextArea();
        JFNOMBRE = new javax.swing.JFormattedTextField();
        JFCODFALL = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        JPanelImagen = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        JRGuardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(soprafamrv.SOPRAFAMRVApp0.class).getContext().getResourceMap(Falla.class);
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel3.border.title"))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        JLFallaR.setName("JLFallaR"); // NOI18N

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JLFallaR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addComponent(jButton6))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLFallaR, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6))
        );

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

        JFCODFALL.setEditable(false);
        JFCODFALL.setName("JFCODFALL"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(JFCODFALL, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JFNOMBRE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JFCODFALL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JFNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
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

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(soprafamrv.SOPRAFAMRVApp0.class).getContext().getActionMap(Falla.class, this);
        jButton4.setAction(actionMap.get("Task")); // NOI18N
        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
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
                        .addGap(446, 446, 446)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4))
                            .addComponent(JPanelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(JRGuardar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(JRGuardar)
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(91, 91, 91))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1013, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(478, Short.MAX_VALUE)))
        );

        getAccessibleContext().setAccessibleName(resourceMap.getString("Form.AccessibleContext.accessibleName")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            HabilitarCampos(true);
            String query = "Select max(id_falla) from falla";
            ResultSet rs = Conexion.ejecutarQuery(query);
            while (rs.next()) {
                if (rs.getString("max(id_falla)") != null){
                    ResetearCampos();
                    int id = Integer.parseInt(rs.getString("max(id_falla)"))+1;
                    this.JFCODFALL.setText(String.valueOf(id));  
                                    
                }else{
                    ResetearCampos();
                    this.JFCODFALL.setText("1");                   
                    }
                 }
        } catch (SQLException ex) {
            Logger.getLogger(Repuesto.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jButton1ActionPerformed

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

private void JRGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRGuardarActionPerformed
    subeImagen s = new subeImagen();    
    falla f = new falla();
    
    System.out.println("Inicio Definición Variables");
    int ID_FALLA = Integer.parseInt(this.JFCODFALL.getText());    
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
    System.out.println("FOTO ANTES DEL SET :" +FOTO);
    
    f.setID_FALLA(ID_FALLA);
    f.setNOMBRE(NOMBRE);    
    f.setDETALLE(DESCRIPCION);
    f.setFOTO(FOTO);
    
    falla conexionFalla = new falla();
    
    System.out.println("Termino Definición Variables");
    
    System.out.println("INICIO impresion variables asignadas");
    System.out.println("ID_FALLA: " +f.getID_FALLA());
    System.out.println("NOMBRE: " +f.getNOMBRE());    
    System.out.println("DESCRIPCION: " +f.getDETALLE());
    System.out.println("FOTO: " +f.getFOTO());
    
    if(contador == 2){
           if (f.getID_FALLA() != 0 && f.getNOMBRE() != null &&  f.getDETALLE() != null && f.getFOTO() != null){
                int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Guardar?", "Mensajero", JOptionPane.YES_NO_CANCEL_OPTION);
                //n = 0 es YES, n = 1 es NO, n = 2 es Cancel
                System.out.println("numero" + JOptionPane.YES_NO_CANCEL_OPTION);
                if (n == 0) {
                    try {
                    conexionFalla.actualizarFalla(f);
                    ResetearCampos();                
                    JOptionPane.showMessageDialog(null, "Datos Actualizados Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);
                    contador = 0;
                    contador2 = 0;
                    this.JFNOMBRE.setEnabled(false);
                    this.JTEXTDESCRIP.setEnabled(false);
                    CargarFallas();
                    HabilitarCampos(false);                    
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
        if (f.getID_FALLA() != 0 && f.getNOMBRE() != null &&  f.getDETALLE() != null && f.getFOTO() != null){
            int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea Guardar?", "Mensajero", JOptionPane.YES_NO_CANCEL_OPTION);
            //n = 0 es YES, n = 1 es NO, n = 2 es Cancel
            System.out.println("numero" + JOptionPane.YES_NO_CANCEL_OPTION);
            if (n == 0) {
                try {
                conexionFalla.registrarFalla(f);
                ResetearCampos();                
                JOptionPane.showMessageDialog(null, "Datos Ingresados Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);
                contador = 0;
                contador2 = 0;
                this.JFNOMBRE.setEnabled(false);
                this.JTEXTDESCRIP.setEnabled(false);
                CargarFallas();       
                HabilitarCampos(false);
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
            JPanelImagen.removeAll();  
            String NOMBRE = this.JLFallaR.getSelectedItem();
            falla f = new falla();
            f.ObtenerFalla(NOMBRE);
            
            System.out.println("imprimiendo ID FALLA: " +f.getID_FALLA());
            System.out.println("imprimiendo NOMBRE: " +f.getNOMBRE());
            System.out.println("imprimiendo DETALLE: " +f.getDETALLE());
            System.out.println("imprimiendo FOTO: " +f.getFOTO());
            this.JFNOMBRE.setText(f.getNOMBRE());
            this.JFCODFALL.setText(String.valueOf(f.getID_FALLA()));
            this.JTEXTDESCRIP.setText(f.getDETALLE());
            IMAGEN = f.getFOTO();
            
            InputStream z = new ByteArrayInputStream(f.getFOTO());
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
            falla f = new falla();            
            int FALLA = Integer.parseInt(this.JFCODFALL.getText().trim());
            System.out.println("IMPRIMIENDO IDFALLA: " +FALLA);
            f.borrarFalla(FALLA);
            CargarFallas();
            ResetearCampos();
            HabilitarCampos(false);            
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
    private javax.swing.JFormattedTextField JFCODFALL;
    private javax.swing.JFormattedTextField JFNOMBRE;
    private java.awt.List JLFallaR;
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
