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
import java.awt.Event;
import vista.frmPaquete;
import modelo.ConsultasCliente;
import modelo.ConsultaPais;
import modelo.ConsultaPaquete;
import modelo.clPais;
import modelo.clCliente;
import modelo.ConsultaContinente;
import modelo.clContinente;

import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.clPaquete;

public class CtrlGestPaquete implements ActionListener {
    private frmPaquete paquete;
    private ConsultasCliente ConClie;
    private clCliente clie;
    private ConsultaPais cPais;
    private clPais pais;
    private ConsultaContinente Cont;
    private clContinente cCont;
    private ConsultaPaquete cpaquete;
    public CtrlGestPaquete(frmPaquete paquete, ConsultasCliente ConClie, clCliente clie, ConsultaPais cPais, clPais Pais, ConsultaContinente Cont, clContinente cCont) {
        this.paquete = paquete;
        this.ConClie = ConClie;
        this.clie    = clie;
        this.pais    = Pais;
        this.cPais   = cPais;
        this.Cont    = Cont;
        this.cCont   = cCont;
        this.paquete.btnBuscar.addActionListener(this); //Escucha del botón de búsqueda de cliente.
        this.paquete.cmbPais.addActionListener(this); //Escucha de la accion del combobox pais.
        this.paquete.cmbPaquete.addActionListener(this);
        this.paquete.cmbPais.removeAllItems();
        
        cpaquete = new ConsultaPaquete();
        ArrayList paises = cPais.ListaPais();
        Iterator<String> i = paises.iterator();
        while(i.hasNext()){
            paquete.cmbPais.addItem(i.next());
        }
        this.paquete.cmbPais.setSelectedItem(null);
        this.paquete.cmbPaquete.setSelectedItem(null);
        this.paquete.cmbPaquete.removeAllItems();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == paquete.btnBuscar){
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
        }else if(e.getSource() == paquete.cmbPais){
//            this.paquete.cmbPaquete.removeAllItems();
//            ArrayList paquetes = new ArrayList();
//            clPais p = new clPais();
//            p.setDescripcion("Paraguay");
//            paquetes = cpaquete.ListarPaquete(p);
//            Iterator<String> n = paquetes.iterator();
//            while(n.hasNext()){
//                paquete.cmbPaquete.addItem(n.next());
//            }
        }else if(e.getSource() == paquete.cmbPaquete){
            
        }else if(e.getSource() == paquete.btnGuardar){
            validar();
            clPaquete p = new clPaquete();
            
            p.setIdCliente(0);
            p.setEstado(Boolean.FALSE);
            p.setIdAtractivo(0);
            p.setFechaSalida(Date.valueOf(paquete.txtFechaSalida.getText()));
            p.setFechaRetorno(Date.valueOf(paquete.txtFechaSalida.getText()));
            p.setImporte(Double.parseDouble(paquete.txtImporte.getText()));
            cpaquete.RegistrarPaquete(p);
            limpiar();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void validar(){
        if(paquete.txtDocumento.getText() == null){
            JOptionPane.showMessageDialog(null, "Campo Documento Vacio");
        }
        if(paquete.cmbPais.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Campo Pais Vacio");
        }
        if(paquete.cmbPaquete.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Campo Paquete Vacio");
        }
        if(paquete.txtNombre.getSelectedText() == null){
            JOptionPane.showMessageDialog(null, "Campo Nombre Vacio");
        }
        if(paquete.txtApellido.getSelectedText() == null){
            JOptionPane.showMessageDialog(null, "Campo Apellido Vacio");
        }
        if(paquete.txtImporte.getSelectedText() == null){
            JOptionPane.showMessageDialog(null, "Campo Importe Vacio");
        }
        
    }
    private void limpiar(){
        paquete.txtNombre.setText("");
        paquete.txtApellido.setText("");
        paquete.txtCorreo.setText("");
        paquete.txtDireccion.setText("");
        paquete.txtFechaNacimiento.setText("");
        paquete.txtRetorno.setText("");
        paquete.txtFechaSalida.setText("");
        paquete.txtTipoDocumento.setText("");
        paquete.txtTelefono.setText("");
        paquete.txtImporte.setText("");
    }
    
}

