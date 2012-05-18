/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soprafamrv.SISTEMA;

/**
 *
 * @author Cri
 */
public class repuesto {    
    private int ID_REPUESTO;
    private String NOMBRE;
    private String MARCA;
    private String DETALLE;

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public String getMARCA() {
        return MARCA;
    }

    public void setMARCA(String MARCA) {
        this.MARCA = MARCA;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public String getDETALLE() {
        return DETALLE;
    }

    public void setDETALLE(String DETALLE) {
        this.DETALLE = DETALLE;
    }

    public byte[] getFOTO() {
        return FOTO;
    }

    public void setFOTO(byte[] FOTO) {
        repuesto.FOTO = FOTO;
    }

    public int getID_REPUESTO() {
        return ID_REPUESTO;
    }

    public void setID_REPUESTO(int ID_REPUESTO) {
        this.ID_REPUESTO = ID_REPUESTO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }
    private int CANTIDAD;
    static byte[] FOTO;
    
}
