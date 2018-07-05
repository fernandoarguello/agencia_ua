/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author farguello
 */
public class clCobranza {
    private int id_cobranza;
    private int idpaquete;
    private double MontoCobrado;
    private Date FechaCobro;

    public int getId_cobranza() {
        return id_cobranza;
    }

    public int getIdpaquete() {
        return idpaquete;
    }

    public double getMontoCobrado() {
        return MontoCobrado;
    }

    public void setId_cobranza(int id_cobranza) {
        this.id_cobranza = id_cobranza;
    }

    public void setIdpaquete(int idpaquete) {
        this.idpaquete = idpaquete;
    }

    public void setMontoCobrado(double MontoCobrado) {
        this.MontoCobrado = MontoCobrado;
    }

    public Date getFechaCobro() {
        return FechaCobro;
    }

    public void setFechaCobro(Date FechaCobro) {
        this.FechaCobro = FechaCobro;
    }
    
    
    
    
    
}
