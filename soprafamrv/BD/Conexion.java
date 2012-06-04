/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soprafamrv.BD;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oracle.jdbc.*;
import oracle.jdbc.OraclePreparedStatement;
import soprafamrv.SISTEMA.conductor;
import soprafamrv.SISTEMA.vehiculo;
import soprafamrv.SISTEMA.ot;
import soprafamrv.SISTEMA.repuesto;
import soprafamrv.ARCHIVOS_EXP.GeneratePDF;
import soprafamrv.SISTEMA.compra;
import soprafamrv.SISTEMA.falla;
import soprafamrv.SISTEMA.personal;

/**
 *
 * @author Cri
 */
public class Conexion {
    // Comienzo de variables Globales

    public static String usuario = "SOPRAFAMRV";
    public static String clave = "fisica";
    public static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    public static Connection con;

    public Conexion() {
        try {
            //esto es la manera simple, podrias buscar sobre el patron de diseño singleton, que optimiza las llamadas a la bd
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            con = DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException e) {
        }
    }

    public static ResultSet ejecutarQuery(String Query) throws SQLException {
        Conexion x = new Conexion();
        OraclePreparedStatement stmt = (OraclePreparedStatement) x.con.prepareStatement(Query);
        OracleResultSet rs = (OracleResultSet) stmt.executeQuery();
        return rs;                
    }
    
    public static ResultSet ejecutarQuery2(String Query, OraclePreparedStatement stmt) throws SQLException {
        Conexion x = new Conexion();
        stmt = (OraclePreparedStatement) x.con.prepareStatement(Query);
        OracleResultSet rs = (OracleResultSet) stmt.executeQuery();        
        return rs;      
    }
    
    public void registrarVehiculoConductor(String conductor, String patente, Date fecha_asignacion, String descripcion) throws SQLException{
        try {
            System.out.println("INICIO del Stored Procedure de insercion Vehiculo-Conductor");

            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarVehiculoConductor(?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setString(1, conductor);
            cs.setString(2, patente);
            cs.setDate(3, fecha_asignacion);
            cs.setString(4, descripcion);
            
            cs.executeUpdate();

            System.out.println("DATOS INGRESADOS SATISFACTORIAMENTE");
            con.commit();
            System.out.println("TERMINO del Stored Procedure de insercion Conductor");
        } catch (SQLException ex) {
            ex.printStackTrace();
    
        }
    }
        
    public void registrarOT (ot ordentrabajo) throws SQLException{
        try {
            System.out.println("INICIO del Stored Procedure de insercion OT");

            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarOT(?,?,?,?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setInt(1, ordentrabajo.getID_OT());
            cs.setString(2, ordentrabajo.getPATENTE());
            cs.setString(3, ordentrabajo.getRUT_ADMINISTRADOR());
            cs.setString(4, ordentrabajo.getRUT_MECANICO());
            cs.setDate(5, ordentrabajo.getFECHA_INICIO());
            cs.setDate(6, ordentrabajo.getFECHA_TERMINO());            
            cs.setString(7, ordentrabajo.getTIPOTRABAJO());            

            cs.executeUpdate();

            System.out.println("\nOT succesfully inserted");
            con.commit();
            System.out.println("TERMINO del Stored Procedure de insercion OT");
        } catch (SQLException ex) {
            ex.printStackTrace();
    
        }    
}
            
    public void registrarOTSERVICIO (int idot, String patente, int id_servicio) throws SQLException, DocumentException, FileNotFoundException{
        try {
            System.out.println("INICIO del Stored Procedure de insercion Conductor");
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarOTSERVICIO(?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setInt(1, idot);
            cs.setString(2, patente);
            cs.setInt(3, id_servicio);

            cs.executeUpdate();

            System.out.println("\nOTSERVICIO succesfully inserted");
            con.commit();
            System.out.println("TERMINO del Stored Procedure de insercion OTSERVICIO");
            GeneratePDF gpdf = new GeneratePDF();
            
            //Obtencion datos personal de la orden_trabajo
            String query = "select ot.fecha_inicio as fechainicio, mec.nombre as mecnombre, mec.apellido_paterno as mecapepa, mec.apellido_materno as mecamema, adm.nombre as adnombre, adm.apellido_paterno as adapepa, adm.apellido_materno as adamema, ot.id_ot as idot, ot.patente as patente from orden_trabajo ot, mecanico mec, administrador adm where ot.id_ot = "+idot+" and ot.patente = '"+patente+"' and ot.rut_mecanico = mec.rut_mecanico and ot.rut_administrador = adm.rut_administrador";
            ResultSet rs = Conexion.ejecutarQuery(query);     
            
            String query2 = "select s.id_servicio, s.nombre from orden_trabajo_servicio ots, servicio s where ots.id_ot = "+idot+" and ots.patente = '"+patente+"' and ots.id_servicio = s.id_servicio";
            ResultSet rs2 = Conexion.ejecutarQuery(query2);     
            //Creacion de PDF
            gpdf.crearDocumento("ORDEN DE TRABAJO N°"+idot+"-PATENTE-"+patente);
            //Asignacion de contenido PDF a la clase GeneratePDF
            gpdf.ContenidoDocumento("SOPRAF S.A. SOFTWARE AMRV", "O  R  D  E  N     D  E     T  R  A  B  A  J  O", "S  E  R  V  I  C  I  O  S", rs, rs2);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
    
        }    
}
    
    public void actualizarOTSERVICIO (int idot, String patente, int id_servicio) throws SQLException, DocumentException, FileNotFoundException{
        try {
            System.out.println("INICIO del Stored Procedure de insercion Conductor");
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarOTSERVICIO(?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setInt(1, idot);
            cs.setString(2, patente);
            cs.setInt(3, id_servicio);

            cs.executeUpdate();

            System.out.println("\nOTSERVICIO succesfully inserted");
            con.commit();
            System.out.println("TERMINO del Stored Procedure de insercion OTSERVICIO");
            GeneratePDF gpdf = new GeneratePDF();
            
            //Obtencion datos personal de la orden_trabajo
            String query = "select ot.fecha_inicio as fechainicio, mec.nombre as mecnombre, mec.apellido_paterno as mecapepa, mec.apellido_materno as mecamema, adm.nombre as adnombre, adm.apellido_paterno as adapepa, adm.apellido_materno as adamema, ot.id_ot as idot, ot.patente as patente from orden_trabajo ot, mecanico mec, administrador adm where ot.id_ot = "+idot+" and ot.patente = '"+patente+"' and ot.rut_mecanico = mec.rut_mecanico and ot.rut_administrador = adm.rut_administrador";
            ResultSet rs = Conexion.ejecutarQuery(query);     
            
            String query2 = "select s.id_servicio, s.nombre from orden_trabajo_servicio ots, servicio s where ots.id_ot = "+idot+" and ots.patente = '"+patente+"' and ots.id_servicio = s.id_servicio";
            ResultSet rs2 = Conexion.ejecutarQuery(query2);     
            //Creacion de PDF
            gpdf.crearDocumento("ORDEN DE TRABAJO N°"+idot+"-PATENTE-"+patente);
            //Asignacion de contenido PDF a la clase GeneratePDF
            gpdf.ContenidoDocumento("SOPRAF S.A. SOFTWARE AMRV", "O  R  D  E  N     D  E     T  R  A  B  A  J  O", "S  E  R  V  I  C  I  O  S", rs, rs2);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
    
        }    
}
    
    
    public void RegistrarRepuestoOT(int NUM_ORDEN, String PATENTE, int ID_REPUESTO, String RUT_ENCARGADO, String OBSERVACIONES, int CANTIDAD) throws SQLException{
        try {
            System.out.println("INICIO del Stored Procedure de insercion OTREPUESTO");
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarOTREP(?,?,?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            System.out.println("AQUI YA RECIBI PARAMETROS DESDE RETIROREPUESTOS: " +NUM_ORDEN+ " , " +PATENTE+ " , " +ID_REPUESTO+ " , " +OBSERVACIONES+ " , " +CANTIDAD+ " , " +RUT_ENCARGADO);
            cs.setInt(1, NUM_ORDEN);
            cs.setString(2, PATENTE);
            cs.setInt(3, ID_REPUESTO);
            cs.setString(4, RUT_ENCARGADO);
            cs.setString(5, OBSERVACIONES);
            cs.setInt(6, CANTIDAD);
            
            cs.executeUpdate();
            System.out.println("\nSuccesfully inserted");
            con.commit();
            System.out.println("TERMINO del Stored Procedure de insercion OTREPUESTO");
            JOptionPane.showMessageDialog(null, "Datos Ingresados Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex, "Error", JOptionPane.ERROR_MESSAGE); 
    
        }
         
    }
    
    public void RegistrarFallaOT(int NUM_ORDEN, String PATENTE, int ID_FALLA, String OBSERVACIONES) throws SQLException{
        try {
            System.out.println("INICIO del Stored Procedure de insercion OTREPUESTO");
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarOTFALLA(?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            System.out.println("AQUI YA RECIBI PARAMETROS DESDE RETIROREPUESTOS: " +NUM_ORDEN+ " , " +PATENTE+ " , " +ID_FALLA+ " , " +OBSERVACIONES);
            cs.setInt(1, NUM_ORDEN);
            cs.setString(2, PATENTE);
            cs.setInt(3, ID_FALLA);           
            cs.setString(4, OBSERVACIONES);            
            
            cs.executeUpdate();
            System.out.println("\nSuccesfully inserted");
            con.commit();
            System.out.println("TERMINO del Stored Procedure de insercion OTFALLA");
            JOptionPane.showMessageDialog(null, "Datos Ingresados Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex, "Error", JOptionPane.ERROR_MESSAGE); 
    
        }
         
    }
   
    //METODOS CONEXION BD PARA COMPRA
    public void RegistrarCompra(compra com){
        try {
            System.out.println("INICIO del Stored Procedure de insercion OT");
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarCompra(?,?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setInt(1, com.getNRO_FACTURA());
            cs.setDate(2, com.getFECHA_COMPRA());
            cs.setInt(3, com.getID_PROVEEDOR());
            cs.setString(4, com.getRUT_ADMINISTRADOR());
            cs.setString(5, com.getDETALLE());

            cs.executeUpdate();

            System.out.println("\nOT succesfully inserted");
            con.commit();
            System.out.println("TERMINO del Stored Procedure de insercion OT");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex, "Error", JOptionPane.ERROR_MESSAGE); 
        }
        
    }
    
    public void RegistrarCompraRepuesto(int NROFACTURA, int IDREPUESTO, int CANTIDAD, String DETALLE){
        try {
            System.out.println("INICIO del Stored Procedure de insercion COMPRA DETALLE");
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarCompraRep(?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setInt(1, NROFACTURA);
            cs.setInt(2, IDREPUESTO);
            cs.setInt(3, CANTIDAD);
            cs.setString(4, DETALLE);
            cs.executeUpdate();

            System.out.println("\nCOMPRA_DETALLE succesfully inserted");
            con.commit();
            System.out.println("TERMINO del Stored Procedure de insercion COMPRA DETALLE");
            JOptionPane.showMessageDialog(null, "Datos Ingresados Satisfactoriamente", "Mensajero", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex, "Error", JOptionPane.ERROR_MESSAGE); 
        }
    
    }
}
