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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.clAtractivo;
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
        this.paquete.txtDocumento.addActionListener(this);
        this.paquete.txtImporte.addActionListener(this);
        this.paquete.cmbPais.removeAllItems();
        this.paquete.btnGuardar.addActionListener(this);
        
        paquete.btnBuscar.addKeyListener(escucha);
        paquete.btnGuardar.addKeyListener(guarda);
        cpaquete = new ConsultaPaquete();
        ArrayList paises = cPais.ListaPais();
        Iterator<String> i = paises.iterator();
        while(i.hasNext()){
            paquete.cmbPais.addItem(i.next());
        }
        this.paquete.cmbPais.setSelectedItem(null);
        this.paquete.cmbPaquete.setSelectedItem(null);
        this.paquete.cmbPaquete.removeAllItems();
        this.paquete.txtDocumento.requestFocus();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == paquete.txtDocumento){
            if(e.getModifiers() == 0){
                paquete.btnBuscar.requestFocus(true);
            }
        }else if(e.getSource() == paquete.btnBuscar){
            buscar();
        }else if(e.getSource() == paquete.cmbPais){
            if(paquete.cmbPais.getSelectedItem() != null){
                paquete.cmbPaquete.removeAllItems();
                clPais p = new clPais();
                p.setDescripcion(paquete.cmbPais.getSelectedItem().toString());
                ArrayList paquetes = new ArrayList();
                ConsultaPaquete cpaquete = new ConsultaPaquete();
                paquetes = cpaquete.ListarPaquete(p);
    //            paquetes = cpaquete.ListarPaquete(paquete.cmbPais.getSelectedItem().toString());
                Iterator<String> n = paquetes.iterator();
                while(n.hasNext()){
                    paquete.cmbPaquete.addItem(n.next());
                }
                paquete.cmbPaquete.setSelectedItem(null);
            }
            
        }else if(e.getSource() == paquete.btnGuardar){
            
           if(validar()){
                
                guardar();
           }else{
               JOptionPane.showMessageDialog(null, "Dato Inválido o Debe completar un campo antes de guardar.");
           }
        }else if (e.getSource() == paquete.txtDocumento){
            if("".equals(paquete.txtDocumento.getText().toString())){
                JOptionPane.showMessageDialog(null, "Debe ingresar el Documento");
            };
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    KeyListener escucha = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println(e.getKeyCode());
            if(e.getKeyCode()==0){
                buscar();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    KeyListener guarda = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            if(e.getKeyCode()==0){
                guardar();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    @SuppressWarnings("empty-statement")
    private boolean validar(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        int estado = 0;
        if(paquete.txtDocumento.getText() == null){
            estado = 1;
        }
        if(paquete.cmbPais.getSelectedItem() == null){
            estado = 1;
        }
        if(paquete.cmbPaquete.getSelectedItem() == null){
            estado = 1;
        }
        if(paquete.txtNombre.getSelectedText() == null){
            estado = 1;
        }
        if(paquete.txtApellido.getSelectedText() == null){
            estado = 1;
        }
        if(paquete.txtImporte.getSelectedText() == null){
            estado = 1;
        }
        if(paquete.txtFechaNacimiento.getText() == null){
            estado = 1;
        }else{
            try{
                sdf.parse(paquete.txtFechaNacimiento.getText().toString());
                estado = 0;
            }catch(ParseException e){
                estado = 1;
            }
        }
        if(paquete.txtFechaSalida.getText() == null){
            estado = 1;
        }else{
            try{
                sdf.parse(paquete.txtFechaSalida.getText().toString());
                estado = 0;
            }catch(ParseException e){
                estado = 1;
            }
        }
        if(paquete.txtRetorno.getText() == null){
            estado = 1;
        }else{
            try{
                sdf.parse(paquete.txtRetorno.getText().toString());
                estado = 0;
            }catch(ParseException e){
                estado = 1;
            }
        }
        if(estado == 1){
            return false;
        }else{
            return true;
        }
        
    }
    private void limpiar(){
        this.paquete.txtNombre.setText("");
        this.paquete.txtApellido.setText("");
        this.paquete.txtCorreo.setText("");
        this.paquete.txtDireccion.setText("");
        this.paquete.txtFechaNacimiento.setText("");
        this.paquete.txtRetorno.setText("");
        this.paquete.txtFechaSalida.setText("");
        this.paquete.txtTipoDocumento.setText("");
        this.paquete.txtTelefono.setText("");
        this.paquete.txtImporte.setText("");
        this.paquete.txtDocumento.setText(null);
        this.paquete.cmbPais.setSelectedItem(null);
        this.paquete.cmbPaquete.removeAllItems();
        this.paquete.cmbPaquete.setSelectedItem(null);
        this.paquete.txtDocumento.requestFocus(true);
    }
    private void buscar(){
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
    private void guardar(){
        clPaquete p = new clPaquete();                         //Constructores
                
        clie.setDocumento(paquete.txtDocumento.getText());     //Asigna el número de documento del cliente

        if(ConClie.BuscarClientePaquete(clie)){                //Envia el número de cliente y obtiene su id
            p.setIdCliente(clie.getIdCliente());               //Asigna el id de cliente a la instrucción de alta 
        }
        p.setEstado(Boolean.FALSE);
        clAtractivo a = new clAtractivo(); 

        a.setDescripcion(paquete.cmbPaquete.getSelectedItem().toString());
        int atractivo = cpaquete.ObtPaquete(a).getIdAtractivo();
        a.setIdAtractivo(atractivo);

        p.setIdAtractivo(a.getIdAtractivo());
        p.setFechaSalida(Date.valueOf(paquete.txtFechaSalida.getText().toString()));
        p.setFechaRetorno(Date.valueOf(paquete.txtFechaSalida.getText().toString()));
        p.setImporte(Double.parseDouble(paquete.txtImporte.getText()));
        cpaquete.RegistrarPaquete(p);
        limpiar();
    }
}

