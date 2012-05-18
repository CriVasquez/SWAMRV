/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soprafamrv.SISTEMA;

import java.sql.Date;



/**
 *
 * @author Cri
 */
public class compra {
    private int NRO_FACTURA;
    private Date FECHA_COMPRA;
    private int ID_PROVEEDOR;
    private String RUT_ADMINISTRADOR;
    private String DETALLE;

    public String getDETALLE() {
        return DETALLE;
    }

    public void setDETALLE(String DETALLE) {
        this.DETALLE = DETALLE;
    }

    public Date getFECHA_COMPRA() {
        return FECHA_COMPRA;
    }

    public void setFECHA_COMPRA(Date FECHA_COMPRA) {
        this.FECHA_COMPRA = FECHA_COMPRA;
    }

    public int getID_PROVEEDOR() {
        return ID_PROVEEDOR;
    }

    public void setID_PROVEEDOR(int ID_PROVEEDOR) {
        this.ID_PROVEEDOR = ID_PROVEEDOR;
    }

    public int getNRO_FACTURA() {
        return NRO_FACTURA;
    }

    public void setNRO_FACTURA(int NRO_FACTURA) {
        this.NRO_FACTURA = NRO_FACTURA;
    }

    public String getRUT_ADMINISTRADOR() {
        return RUT_ADMINISTRADOR;
    }

    public void setRUT_ADMINISTRADOR(String RUT_ADMINISTRADOR) {
        this.RUT_ADMINISTRADOR = RUT_ADMINISTRADOR;
    }
    
    
    
}
