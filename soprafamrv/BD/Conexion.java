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
    
    //METODOS CONEXION BD PARA CONDUCTOR
    public void registrarConductor(personal conductor) throws SQLException{
        try {
            //LISTO
            System.out.println("INICIO del Stored Procedure de insercion Conductor");
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setString(1, conductor.getRUT());
            cs.setString(2,conductor.getNOMBRE());
            cs.setString(3,conductor.getAPELLIDOPAT());
            cs.setString(4,conductor.getAPELLIDOMAT());
            cs.setString(5, conductor.getDIRECCION());
            cs.setInt(6,conductor.getTELEFONO());
            cs.setString(7, conductor.getEMAIL());
            cs.setInt(8, conductor.getID_COMUNA());
            cs.setDate(9, conductor.getFECHA_INGRESO());            
            cs.setDate(10, conductor.getFECHA_NACIMIENTO());
            cs.setInt(11, conductor.getRADIO());
            cs.setString(12, conductor.getLICENCIA());
            cs.setString(13, conductor.getDETALLE());
            cs.setBytes(14, conductor.getFOTO());            
            cs.executeUpdate();

            System.out.println("\nBlob succesfully inserted");
            con.commit();
            System.out.println("TERMINO del Stored Procedure de insercion Conductor");
        } catch (SQLException ex) {
            ex.printStackTrace();
    
        }
        
    }
    
    public void actualizarConductor(personal p) throws SQLException{
        try {
            System.out.println("INICIO del Stored Procedure de actualizacion Conductor");
            
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin actualizarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setString(1, p.getRUT());
            cs.setString(2, p.getNOMBRE());
            cs.setString(3, p.getAPELLIDOPAT());
            cs.setString(4, p.getAPELLIDOMAT());
            cs.setString(5, p.getDIRECCION());
            cs.setInt(6, p.getTELEFONO());
            cs.setString(7, p.getEMAIL());
            cs.setInt(8, p.getID_COMUNA());
            cs.setDate(9, p.getFECHA_NACIMIENTO());
            cs.setInt(10, p.getRADIO());
            cs.setString(11, p.getLICENCIA());            
            cs.setString(12, p.getDETALLE());
            cs.setBytes(13, p.getFOTO());            
            cs.executeUpdate();

            System.out.println("\nBlob succesfully inserted");
            con.commit();
            
            
            System.out.println("TERMINO del Stored Procedure de actualizacion Administrador");
        } catch (SQLException ex) {
            ex.printStackTrace();
    
        }    
    }
    
    
    //METODO BD CONEXION PARA ADMINISTRADOR
    public void registrarAdministrador(personal administrador) throws SQLException{
        try {
            //LISTO
            System.out.println("INICIO del Stored Procedure de insercion Administrador");
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarAdministrador(?,?,?,?,?,?,?,?,?,?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setString(1, administrador.getRUT());
            cs.setString(2, administrador.getNOMBRE());
            cs.setString(3, administrador.getCONTRASENA());
            cs.setString(4, administrador.getAPELLIDOPAT());
            cs.setString(5, administrador.getAPELLIDOMAT());
            cs.setString(6, administrador.getDIRECCION());
            cs.setInt(7, administrador.getTELEFONO());
            cs.setString(8, administrador.getEMAIL());
            cs.setInt(9, administrador.getID_COMUNA());
            cs.setDate(10, administrador.getFECHA_INGRESO());            
            cs.setDate(11, administrador.getFECHA_NACIMIENTO());            
            cs.setString(12, administrador.getDETALLE());
            cs.setBytes(13, administrador.getFOTO());            
            cs.executeUpdate();

            System.out.println("\nBlob succesfully inserted");
            con.commit();
            System.out.println("TERMINO del Stored Procedure de insercion Administrador");
        } catch (SQLException ex) {
            ex.printStackTrace();
    
        }
        
    }
    
    public void actualizarAdminstrador(personal p) throws SQLException{
        try {
            System.out.println("INICIO del Stored Procedure de actualizacion Administrador");
            
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin actualizarAdministrador(?,?,?,?,?,?,?,?,?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setString(1, p.getRUT());
            cs.setString(2, p.getNOMBRE());
            cs.setString(3, p.getCONTRASENA());
            cs.setString(4, p.getAPELLIDOPAT());
            cs.setString(5, p.getAPELLIDOMAT());
            cs.setString(6, p.getDIRECCION());
            cs.setInt(7, p.getTELEFONO());
            cs.setString(8, p.getEMAIL());
            cs.setInt(9, p.getID_COMUNA());
            cs.setDate(10, p.getFECHA_NACIMIENTO());
            cs.setString(11, p.getDETALLE());
            cs.setBytes(12, p.getFOTO());            
            cs.executeUpdate();

            System.out.println("\nBlob succesfully inserted");
            con.commit();
            
            
            System.out.println("TERMINO del Stored Procedure de actualizacion Administrador");
        } catch (SQLException ex) {
            ex.printStackTrace();
    
        }    
    }
    
    //CONEXION BD PARA ENCARGADO BODEGA
    public void registrarEncargadoBodega(personal encargadob) throws SQLException{
        try {
            //LISTO
            System.out.println("INICIO del Stored Procedure de insercion Encargado Bodega");
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarEncargadoB(?,?,?,?,?,?,?,?,?,?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setString(1, encargadob.getRUT());
            cs.setString(2, encargadob.getNOMBRE());
            cs.setString(3, encargadob.getCONTRASENA());
            cs.setString(4, encargadob.getAPELLIDOPAT());
            cs.setString(5, encargadob.getAPELLIDOMAT());
            cs.setString(6, encargadob.getDIRECCION());
            cs.setInt(7, encargadob.getTELEFONO());
            cs.setString(8, encargadob.getEMAIL());
            cs.setInt(9, encargadob.getID_COMUNA());
            cs.setDate(10, encargadob.getFECHA_INGRESO());            
            cs.setDate(11, encargadob.getFECHA_NACIMIENTO());            
            cs.setString(12, encargadob.getDETALLE());
            cs.setBytes(13, encargadob.getFOTO());            
            cs.executeUpdate();

            System.out.println("\nBlob succesfully inserted");
            con.commit();
            System.out.println("TERMINO del Stored Procedure de insercion Encargado Bodega");
        } catch (SQLException ex) {
            ex.printStackTrace();
    
        }
        
    }
    
    public void actualizarEncargadoB(personal p) throws SQLException{
        try {
            System.out.println("INICIO del Stored Procedure de actualizacion Encargado Bodega");
            
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin actualizarEncargadoB(?,?,?,?,?,?,?,?,?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setString(1, p.getRUT());
            cs.setString(2, p.getNOMBRE());
            cs.setString(3, p.getCONTRASENA());
            cs.setString(4, p.getAPELLIDOPAT());
            cs.setString(5, p.getAPELLIDOMAT());
            cs.setString(6, p.getDIRECCION());
            cs.setInt(7, p.getTELEFONO());
            cs.setString(8, p.getEMAIL());
            cs.setInt(9, p.getID_COMUNA());
            cs.setDate(10, p.getFECHA_NACIMIENTO());
            cs.setString(11, p.getDETALLE());
            cs.setBytes(12, p.getFOTO());            
            cs.executeUpdate();

            System.out.println("\nBlob succesfully inserted");
            con.commit();
            
            
            System.out.println("TERMINO del Stored Procedure de actualizacion Encargado Bodega");
        } catch (SQLException ex) {
            ex.printStackTrace();
    
        }    
    }
    
    //CONEXION BD PARA MECANICO
    public void registrarMecanico(personal mecanico) throws SQLException{
        try {
            //LISTO
            System.out.println("INICIO del Stored Procedure de insercion Mecanico");
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarMecanico(?,?,?,?,?,?,?,?,?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setString(1, mecanico.getRUT());
            cs.setString(2, mecanico.getNOMBRE());            
            cs.setString(3, mecanico.getAPELLIDOPAT());
            cs.setString(4, mecanico.getAPELLIDOMAT());
            cs.setString(5, mecanico.getDIRECCION());
            cs.setInt(6, mecanico.getTELEFONO());
            cs.setString(7, mecanico.getEMAIL());
            cs.setInt(8, mecanico.getID_COMUNA());
            cs.setDate(9, mecanico.getFECHA_INGRESO());            
            cs.setDate(10, mecanico.getFECHA_NACIMIENTO());            
            cs.setString(11, mecanico.getDETALLE());
            cs.setBytes(12, mecanico.getFOTO());            
            cs.executeUpdate();

            System.out.println("\nBlob succesfully inserted");
            con.commit();
            System.out.println("TERMINO del Stored Procedure de insercion Mecanico");
        } catch (SQLException ex) {
            ex.printStackTrace();
    
        }
        
    }
    
        public void actualizarMecanico(personal p) throws SQLException{
        try {
            System.out.println("INICIO del Stored Procedure de actualizacion Mecanico");
            
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin actualizarMecanico(?,?,?,?,?,?,?,?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setString(1, p.getRUT());
            cs.setString(2, p.getNOMBRE());            
            cs.setString(3, p.getAPELLIDOPAT());
            cs.setString(4, p.getAPELLIDOMAT());
            cs.setString(5, p.getDIRECCION());
            cs.setInt(6, p.getTELEFONO());
            cs.setString(7, p.getEMAIL());
            cs.setInt(8, p.getID_COMUNA());
            cs.setDate(9, p.getFECHA_NACIMIENTO());
            cs.setString(10, p.getDETALLE());
            cs.setBytes(11, p.getFOTO());            
            cs.executeUpdate();

            System.out.println("\nBlob succesfully inserted");
            con.commit();
            
            
            System.out.println("TERMINO del Stored Procedure de actualizacion Mecanico");
        } catch (SQLException ex) {
            ex.printStackTrace();
    
        }    
    }
    
    //METODOS CONEXION BD PARA VEHICULO
    public void registrarVehiculo(vehiculo v) throws SQLException{
        try {
            System.out.println("INICIO del Stored Procedure de insercion Vehiculo");
            
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarVehiculo(?,?,?,?,?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setString(1, v.getPATENTE());
            cs.setString(2, v.getCHASIS());
            cs.setInt(3, v.getANO());
            cs.setString(4, v.getCOLOR());
            cs.setString(5, v.getMARCA());
            cs.setString(6, v.getMODELO());
            cs.setDate(7, v.getFECHA_INGRESO());            
            cs.setBytes(8, v.getFOTO());
            
            cs.executeUpdate();

            System.out.println("\nBlob succesfully inserted");
            con.commit();
            
            
            System.out.println("TERMINO del Stored Procedure de insercion Vehiculo");
        } catch (SQLException ex) {
            ex.printStackTrace();
    
        }    
    }
    
    public void actualizarVehiculo(vehiculo v) throws SQLException{
        try {
            System.out.println("INICIO del Stored Procedure de insercion Conductor");
            
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin actualizarVehiculo(?,?,?,?,?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setString(1, v.getPATENTE());
            cs.setString(2, v.getCHASIS());
            cs.setInt(3, v.getANO());
            cs.setString(4, v.getCOLOR());
            cs.setString(5, v.getMARCA());
            cs.setString(6, v.getMODELO());
            cs.setDate(7, v.getFECHA_INGRESO());            
            cs.setBytes(8, v.getFOTO());
            
            cs.executeUpdate();

            System.out.println("\nBlob succesfully inserted");
            con.commit();
            
            
            System.out.println("TERMINO del Stored Procedure de actualizacion Conductor");
        } catch (SQLException ex) {
            ex.printStackTrace();
    
        }    
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
    
    //METODOS CONEXION BD PARA OT
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
    
    //METODOS CONEXION BD PARA REPUESTO
    public void registrarRepuesto(repuesto repuesto) throws SQLException{
        try {
            System.out.println("INICIO del Stored Procedure de insercion Repuesto");
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarRepuesto(?,?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setInt(1, repuesto.getID_REPUESTO());
            cs.setString(2, repuesto.getNOMBRE());
            cs.setString(3, repuesto.getMARCA());
            cs.setString(4, repuesto.getDETALLE());
            cs.setBytes(5, repuesto.getFOTO());
            cs.executeUpdate();

            System.out.println("\nBlob succesfully inserted");
            con.commit();
            System.out.println("TERMINO del Stored Procedure de insercion Repuesto");
            
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
