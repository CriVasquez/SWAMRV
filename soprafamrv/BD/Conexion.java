/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soprafamrv.BD;

import java.sql.*;
import javax.swing.JOptionPane;
import oracle.jdbc.*;
import soprafamrv.SISTEMA.conductor;
import soprafamrv.SISTEMA.vehiculo;
import soprafamrv.SISTEMA.ot;
import soprafamrv.SISTEMA.repuesto;

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
        //stmt.close();
        //return null;

    }

    public void registrarConductor(conductor conductor) throws SQLException{
        try {
            System.out.println("INICIO del Stored Procedure de insercion Conductor");
            //String query = "begin registrarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;";
            //String sql = "{call RegistrarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            //OracleCallableStatement cs = con.prepareCall("{call RegistrarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            //PreparedStatement cs = con.prepareStatement("insert into conductor values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            //**********NO FUNCIONA//OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("{call pruebaqlia(?,?)");
            //F U N C I O N A PERFECT OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;");
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;");
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
            cs.setDate(10, conductor.getFECHA_RETIRO());
            cs.setDate(11, conductor.getFECHA_NACIMIENTO());
            cs.setInt(12, conductor.getRADIO());
            cs.setString(13, conductor.getLICENCIA());
            cs.setString(14, conductor.getDETALLE());
            cs.setBytes(15, conductor.getFOTO());
            /*cs.setBytes(1, conductor.getFOTO());
            cs.setInt(2,1);
             * 
             */
            cs.executeUpdate();
//            int rsult = cs.executeUpdate();
            System.out.println("\nBlob succesfully inserted");
            con.commit();
            System.out.println("TERMINO del Stored Procedure de insercion Conductor");
        } catch (SQLException ex) {
            ex.printStackTrace();
    
        }
        
    }
    
    public void registrarVehiculo(vehiculo v) throws SQLException{
        try {
            System.out.println("INICIO del Stored Procedure de insercion Conductor");
            //String query = "begin registrarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;";
            //String sql = "{call RegistrarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            //OracleCallableStatement cs = con.prepareCall("{call RegistrarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            //PreparedStatement cs = con.prepareStatement("insert into conductor values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            //**********NO FUNCIONA//OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("{call pruebaqlia(?,?)");
            //F U N C I O N A PERFECT OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;");
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarVehiculo(?,?,?,?,?,?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setString(1, v.getPATENTE());
            cs.setString(2, v.getCHASIS());
            cs.setInt(3, v.getANO());
            cs.setString(4, v.getCOLOR());
            cs.setString(5, v.getMARCA());
            cs.setString(6, v.getMODELO());
            cs.setDate(7, v.getFECHA_INGRESO());
            cs.setDate(8, v.getFECHA_RETIRO());            
            cs.setBytes(9, v.getFOTO());
            /*cs.setBytes(1, conductor.getFOTO());
            cs.setInt(2,1);
             * 
             */
            cs.executeUpdate();
//            int rsult = cs.executeUpdate();
            System.out.println("\nBlob succesfully inserted");
            con.commit();
            
            
            System.out.println("TERMINO del Stored Procedure de insercion Conductor");
        } catch (SQLException ex) {
            ex.printStackTrace();
    
        }    
    }
    public void registrarVehiculoConductor(String conductor, String patente, Date fecha_asignacion, String descripcion) throws SQLException{
        try {
            System.out.println("INICIO del Stored Procedure de insercion Vehiculo-Conductor");
            //String query = "begin registrarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;";
            //String sql = "{call RegistrarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            //OracleCallableStatement cs = con.prepareCall("{call RegistrarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            //PreparedStatement cs = con.prepareStatement("insert into conductor values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            //**********NO FUNCIONA//OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("{call pruebaqlia(?,?)");
            //F U N C I O N A PERFECT OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;");
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarVehiculoConductor(?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setString(1, conductor);
            cs.setString(2, patente);
            cs.setDate(3, fecha_asignacion);
            cs.setString(4, descripcion);
            
            /*cs.setBytes(1, conductor.getFOTO());
            cs.setInt(2,1);
             * 
             */
            cs.executeUpdate();
//            int rsult = cs.executeUpdate();
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
            //String query = "begin registrarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;";
            //String sql = "{call RegistrarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            //OracleCallableStatement cs = con.prepareCall("{call RegistrarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            //PreparedStatement cs = con.prepareStatement("insert into conductor values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            //**********NO FUNCIONA//OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("{call pruebaqlia(?,?)");
            //F U N C I O N A PERFECT OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarConductor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;");
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
    
    public void registrarOTSERVICIO (int idot, String patente, int id_servicio) throws SQLException{
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
        } catch (SQLException ex) {
            ex.printStackTrace();
    
        }    
}
    public void registrarRepuesto(repuesto repuesto) throws SQLException{
        try {
            System.out.println("INICIO del Stored Procedure de insercion Repuesto");
            OracleCallableStatement cs = (OracleCallableStatement) con.prepareCall("begin registrarRepuesto(?,?,?,?); end;");
            System.out.println("AQUI YA LLAME AL STORED PROCEDURE");
            cs.setInt(1, repuesto.getID_REPUESTO());
            cs.setString(2, repuesto.getNOMBRE());
            cs.setString(3, repuesto.getDETALLE());
            cs.setBytes(4, repuesto.getFOTO());
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
   
    
}
