/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @Tabla tblPaquete
 */
public class clPaquete {
    private int     idPaquete;
    private int     idAtractivo;
    private int     idCliente;
    private Date    FechaSalida;
    private Date    FechaRetorno;
    private Boolean estado;
    private Double  importe;
//******************************************************************
//Getters
//******************************************************************    
    public int getIdPaquete() {
        return idPaquete;
    }

    public int getIdAtractivo() {
        return idAtractivo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public Date getFechaSalida() {
        return FechaSalida;
    }

    public Date getFechaRetorno() {
        return FechaRetorno;
    }

    public Boolean getEstado() {
        return estado;
    }

    public Double getImporte() {
        return importe;
    }
//******************************************************************
// Setters
//******************************************************************
    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public void setIdAtractivo(int idAtractivo) {
        this.idAtractivo = idAtractivo;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setFechaSalida(Date FechaSalida) {
        this.FechaSalida = FechaSalida;
    }

    public void setFechaRetorno(Date FechaRetorno) {
        this.FechaRetorno = FechaRetorno;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }
    
    
}
