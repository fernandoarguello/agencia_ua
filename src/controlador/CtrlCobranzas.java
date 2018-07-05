/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import vista.frmCobranza;
import modelo.clCobranza;
import modelo.ConsultaCobranzas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author farguello
 */
public class CtrlCobranzas implements ActionListener{
    private frmCobranza       frmCobranzas;
    private clCobranza        clsCobranzas;
    private ConsultaCobranzas ConsCobranzas;
    public CtrlCobranzas(frmCobranza formCobranza, clCobranza clsCobranzas, ConsultaCobranzas ConsCobranzas){
        this.frmCobranzas   = formCobranza;
        this.clsCobranzas   = clsCobranzas;
        this.ConsCobranzas  = ConsCobranzas;
        this.frmCobranzas.btnBuscar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
