/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Principal.java
 *
 * Created on 02-04-2012, 12:32:41 PM
 */
package soprafamrv;

import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import org.jdesktop.application.Action;

/**
 *
 * @author Administrador
 */
public class Principal extends javax.swing.JFrame {

    /** Creates new form Principal */
    public Principal() throws SQLException {
        initComponents();  
        
        this.JBRUT.setVisible(false);
        setExtendedState(MAXIMIZED_BOTH);
                //Agregando Stylo Nimbuu a todas las ventanas
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
             if ("Windows classic".equals(info.getName())) {
                  UIManager.setLookAndFeel(info.getClassName());
                  break;
        }
    }
} catch (Exception e) {
    // If Nimbus is not available, you can set the GUI to another look and feel.
}
    }

     
    @Action
    public void showAboutBox() throws SQLException {
        
        /* h1 = new Vehiculo();
        // se aÃ±ade al jDesktopPane
        jDesktopPane1.add(h1);
        //se muestra en pantalla
        h1.show();*/
    }
    
    @Action
    public void ModuloVehiculo() throws SQLException {
        Vehiculo h1 = new Vehiculo();
        // se aÃ±ade al jDesktopPane
        jDesktopPane1.add(h1);
        //se muestra en pantalla
        h1.show();
        
    }
    
    @Action
    public void ModuloPersonal() throws SQLException {
        Personal h1 = new Personal();
        // se aÃ±ade al jDesktopPane
        jDesktopPane1.add(h1);
        //se muestra en pantalla
        h1.show();
    }
    
    @Action
    public void ModuloProveedor() throws SQLException {
        Proveedor h1 = new Proveedor();
        // se aÃ±ade al jDesktopPane
        jDesktopPane1.add(h1);
        //se muestra en pantalla
        h1.show();
    }
    
    @Action
    public void ModuloRepuesto() throws SQLException {
        Repuesto h1 = new Repuesto();
        // se aÃ±ade al jDesktopPane
        jDesktopPane1.add(h1);
        //se muestra en pantalla
        h1.show();
    }
    
    @Action
    public void ModuloFalla() {
        Falla h1 = new Falla();
        // se aÃ±ade al jDesktopPane
        jDesktopPane1.add(h1);
        //se muestra en pantalla
        h1.show();
    }
    
    @Action
    public void ModuloServicio() {
        Servicio h1 = new Servicio();
        // se aÃ±ade al jDesktopPane
        jDesktopPane1.add(h1);
        //se muestra en pantalla
        h1.show();
    }
   
    @Action
    public void ModuloOT() throws SQLException {
        OT h1 = new OT();
        // se aÃ±ade al jDesktopPane
        jDesktopPane1.add(h1);
        //se muestra en pantalla
        h1.show();
      }
    
    @Action
    public void ModuloRetiroRepuesto() throws SQLException {
        RetiroRepuesto h1 = new RetiroRepuesto();
        // se aÃ±ade al jDesktopPane
        jDesktopPane1.add(h1);
        //se muestra en pantalla
        h1.show();
     }
    
    @Action
    public void ModuloCompras() throws SQLException {
        Compra h1 = new Compra();
        // se aÃ±ade al jDesktopPane
        jDesktopPane1.add(h1);
        //se muestra en pantalla
        h1.show();
     }
    
    @Action
    public void ModuloInformeseIndicadores() throws SQLException {
        Informe h1 = new Informe();
        // se aÃ±ade al jDesktopPane
        jDesktopPane1.add(h1);
        //se muestra en pantalla
        h1.show();
    }

   
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        JBRUT = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        JBVehiculo = new javax.swing.JMenuItem();
        JBPersonal = new javax.swing.JMenuItem();
        JBRepuesto = new javax.swing.JMenuItem();
        JBFalla = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem JBAbout = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        JBOT = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(soprafamrv.SOPRAFAMRVApp0.class).getContext().getResourceMap(Principal.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jDesktopPane1.setBackground(resourceMap.getColor("jDesktopPane1.background")); // NOI18N
        jDesktopPane1.setName("jDesktopPane1"); // NOI18N
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(1024, 768));

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        JBRUT.setText(resourceMap.getString("JBRUT.text")); // NOI18N
        JBRUT.setName("JBRUT"); // NOI18N

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setForeground(resourceMap.getColor("jLabel2.foreground")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                        .addComponent(JBRUT)
                        .addGap(153, 153, 153))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statusMessageLabel)
                            .addComponent(statusAnimationLabel)
                            .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JBRUT)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(soprafamrv.SOPRAFAMRVApp0.class).getContext().getActionMap(Principal.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setText(resourceMap.getString("exitMenuItem.text")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        jMenuItem3.setText(resourceMap.getString("jMenuItem3.text")); // NOI18N
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        fileMenu.add(jMenuItem3);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N
        helpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuActionPerformed(evt);
            }
        });

        JBVehiculo.setAction(actionMap.get("ModuloVehiculo")); // NOI18N
        JBVehiculo.setText(resourceMap.getString("JBVehiculo.text")); // NOI18N
        JBVehiculo.setToolTipText(resourceMap.getString("JBVehiculo.toolTipText")); // NOI18N
        JBVehiculo.setName("JBVehiculo"); // NOI18N
        JBVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVehiculoActionPerformed(evt);
            }
        });
        helpMenu.add(JBVehiculo);

        JBPersonal.setAction(actionMap.get("ModuloPersonal")); // NOI18N
        JBPersonal.setText(resourceMap.getString("JBPersonal.text")); // NOI18N
        JBPersonal.setName("JBPersonal"); // NOI18N
        helpMenu.add(JBPersonal);

        JBRepuesto.setAction(actionMap.get("ModuloRepuesto")); // NOI18N
        JBRepuesto.setText(resourceMap.getString("JBRepuesto.text")); // NOI18N
        JBRepuesto.setName("JBRepuesto"); // NOI18N
        helpMenu.add(JBRepuesto);

        JBFalla.setAction(actionMap.get("ModuloFalla")); // NOI18N
        JBFalla.setText(resourceMap.getString("JBFalla.text")); // NOI18N
        JBFalla.setName("JBFalla"); // NOI18N
        helpMenu.add(JBFalla);

        jMenuItem6.setAction(actionMap.get("ModuloProveedor")); // NOI18N
        jMenuItem6.setText(resourceMap.getString("jMenuItem6.text")); // NOI18N
        jMenuItem6.setName("jMenuItem6"); // NOI18N
        helpMenu.add(jMenuItem6);

        jMenuItem1.setAction(actionMap.get("ModuloServicio")); // NOI18N
        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        helpMenu.add(jMenuItem1);

        JBAbout.setAction(actionMap.get("showAboutBox")); // NOI18N
        JBAbout.setText(resourceMap.getString("JBAbout.text")); // NOI18N
        JBAbout.setName("JBAbout"); // NOI18N
        helpMenu.add(JBAbout);

        menuBar.add(helpMenu);

        jMenu1.setText(resourceMap.getString("jMenu1.text")); // NOI18N
        jMenu1.setName("jMenu1"); // NOI18N

        jMenuItem5.setAction(actionMap.get("ModuloInformeseIndicadores")); // NOI18N
        jMenuItem5.setText(resourceMap.getString("jMenuItem5.text")); // NOI18N
        jMenuItem5.setName("jMenuItem5"); // NOI18N
        jMenu1.add(jMenuItem5);

        menuBar.add(jMenu1);

        jMenu2.setText(resourceMap.getString("jMenu2.text")); // NOI18N
        jMenu2.setName("jMenu2"); // NOI18N
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem2.setAction(actionMap.get("ModuloRetiroRepuesto")); // NOI18N
        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jMenu2.add(jMenuItem2);

        menuBar.add(jMenu2);

        jMenu3.setText(resourceMap.getString("jMenu3.text")); // NOI18N
        jMenu3.setName("jMenu3"); // NOI18N

        jMenuItem4.setAction(actionMap.get("ModuloCompras")); // NOI18N
        jMenuItem4.setText(resourceMap.getString("jMenuItem4.text")); // NOI18N
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        jMenu3.add(jMenuItem4);

        menuBar.add(jMenu3);

        jMenu4.setText(resourceMap.getString("jMenu4.text")); // NOI18N
        jMenu4.setName("jMenu4"); // NOI18N

        JBOT.setAction(actionMap.get("ModuloOT")); // NOI18N
        JBOT.setText(resourceMap.getString("JBOT.text")); // NOI18N
        JBOT.setName("JBOT"); // NOI18N
        jMenu4.add(JBOT);

        menuBar.add(jMenu4);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVehiculoActionPerformed

    }//GEN-LAST:event_JBVehiculoActionPerformed

    private void helpMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuActionPerformed

        // TODO add your handling code here:}//GEN-LAST:event_helpMenuActionPerformed
    }
private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
  
}//GEN-LAST:event_jMenu2ActionPerformed

    /**
     * @param args the command line arguments
     */
    
  /*  public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new Principal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
     * 
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JMenuItem JBFalla;
    protected javax.swing.JMenuItem JBOT;
    protected javax.swing.JMenuItem JBPersonal;
    protected static javax.swing.JLabel JBRUT;
    protected javax.swing.JMenuItem JBRepuesto;
    protected javax.swing.JMenuItem JBVehiculo;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    protected javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    protected javax.swing.JMenuItem jMenuItem4;
    protected javax.swing.JMenuItem jMenuItem5;
    protected javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables
}
