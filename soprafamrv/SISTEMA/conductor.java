/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soprafamrv.SISTEMA;

import java.io.ByteArrayInputStream;
import java.sql.Date;

/**
 *
 * @author Cri
 */
public class conductor {

    private String RUT;
    private String NOMBRE;
    private String APELLIDOPAT;
    private String APELLIDOMAT;
    private String DIRECCION;
    private int TELEFONO;
    private String EMAIL;
    private int ID_COMUNA;
    private Date FECHA_INGRESO;
    private Date FECHA_RETIRO;
    private Date FECHA_NACIMIENTO;
    private int RADIO;
    private String LICENCIA;
    private String DETALLE;
    private byte[] FOTO;

    /**
     * @return the RUT
     */
    public String getRUT() {
        return RUT;
    }

    /**
     * @param RUT the RUT to set
     */
    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    /**
     * @return the NOMBRE
     */
    public String getNOMBRE() {
        return NOMBRE;
    }

    /**
     * @param NOMBRE the NOMBRE to set
     */
    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    /**
     * @return the APELLIDOPAT
     */
    public String getAPELLIDOPAT() {
        return APELLIDOPAT;
    }

    /**
     * @param APELLIDOPAT the APELLIDOPAT to set
     */
    public void setAPELLIDOPAT(String APELLIDOPAT) {
        this.APELLIDOPAT = APELLIDOPAT;
    }

    /**
     * @return the APELLIDOMAT
     */
    public String getAPELLIDOMAT() {
        return APELLIDOMAT;
    }

    /**
     * @param APELLIDOMAT the APELLIDOMAT to set
     */
    public void setAPELLIDOMAT(String APELLIDOMAT) {
        this.APELLIDOMAT = APELLIDOMAT;
    }

    /**
     * @return the DIRECCION
     */
    public String getDIRECCION() {
        return DIRECCION;
    }

    /**
     * @param DIRECCION the DIRECCION to set
     */
    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    /**
     * @return the TELEFONO
     */
    public int getTELEFONO() {
        return TELEFONO;
    }

    /**
     * @param TELEFONO the TELEFONO to set
     */
    public void setTELEFONO(int TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    /**
     * @return the EMAIL
     */
    public String getEMAIL() {
        return EMAIL;
    }

    /**
     * @param EMAIL the EMAIL to set
     */
    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    /**
     * @return the ID_COMUNA
     */
    public int getID_COMUNA() {
        return ID_COMUNA;
    }

    /**
     * @param ID_COMUNA the ID_COMUNA to set
     */
    public void setID_COMUNA(int ID_COMUNA) {
        this.ID_COMUNA = ID_COMUNA;
    }

    /**
     * @return the FECHA_INGRESO
     */
    public Date getFECHA_INGRESO() {
        return FECHA_INGRESO;
    }

    /**
     * @param FECHA_INGRESO the FECHA_INGRESO to set
     */
    public void setFECHA_INGRESO(Date FECHA_INGRESO) {
        this.FECHA_INGRESO = FECHA_INGRESO;
    }

    /**
     * @return the FECHA_RETIRO
     */
    public Date getFECHA_RETIRO() {
        return FECHA_RETIRO;
    }

    /**
     * @param FECHA_RETIRO the FECHA_RETIRO to set
     */
    public void setFECHA_RETIRO(Date FECHA_RETIRO) {
        this.FECHA_RETIRO = FECHA_RETIRO;
    }

    /**
     * @return the FECHA_NACIMIENTO
     */
    public Date getFECHA_NACIMIENTO() {
        return FECHA_NACIMIENTO;
    }

    /**
     * @param FECHA_NACIMIENTO the FECHA_NACIMIENTO to set
     */
    public void setFECHA_NACIMIENTO(Date FECHA_NACIMIENTO) {
        this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
    }

    /**
     * @return the RADIO
     */
    public int getRADIO() {
        return RADIO;
    }

    /**
     * @param RADIO the RADIO to set
     */
    public void setRADIO(int RADIO) {
        this.RADIO = RADIO;
    }

    /**
     * @return the LICENCIA
     */
    public String getLICENCIA() {
        return LICENCIA;
    }

    /**
     * @param LICENCIA the LICENCIA to set
     */
    public void setLICENCIA(String LICENCIA) {
        this.LICENCIA = LICENCIA;
    }

    /**
     * @return the DETALLE
     */
    public String getDETALLE() {
        return DETALLE;
    }

    /**
     * @param DETALLE the DETALLE to set
     */
    public void setDETALLE(String DETALLE) {
        this.DETALLE = DETALLE;
    }

    /**
     * @return the FOTO
     */
    public byte[] getFOTO() {
        return FOTO;
    }

    /**
     * @param FOTO the FOTO to set
     */
    public void setFOTO(byte[] FOTO) {
        this.FOTO = FOTO;
    }
    
}
