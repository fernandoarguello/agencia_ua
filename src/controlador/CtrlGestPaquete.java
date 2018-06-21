/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author farguello
 */
import vista.frmPaquete;
import modelo.ConsultasCliente;
import modelo.clCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlGestPaquete implements ActionListener {
    private frmPaquete paquete;
    private ConsultasCliente ConClie;
    private clCliente clie;
    public CtrlGestPaquete(frmPaquete paquete, ConsultasCliente ConClie, clCliente clie){
        this.paquete = paquete;
        this.ConClie = ConClie;
        this.clie    = clie;
        this.paquete.btnBuscar.addActionListener(this); //Escucha del botón de búsqueda de cliente.
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == paquete){
            
        }else if(e.getSource() == paquete.btnBuscar){
            clie.setDocumento(paquete.txtDocumento.getText());
            if(ConClie.BuscarClientePaquete(clie)){
                paquete.txtTipoDocumento.setText(clie.getTipoDocumento());
                paquete.txtNombre.setText(clie.getNombres());
                paquete.txtApellido.setText(clie.getApellidos());
                paquete.txtFechaNacimiento.setText(clie.getFechaNacimiento().toString());
                paquete.txtDireccion.setText(clie.getDireccion());
                paquete.txtTelefono.setText(clie.getTelefono());
                paquete.txtCorreo.setText(clie.getMail());
            }else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
