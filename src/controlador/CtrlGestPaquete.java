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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CtrlGestPaquete implements ActionListener {
    private frmPaquete paquete;
    private ConsultasCliente ConClie;
    private clCliente clie;
    private ConsultaPais cPais;
    private clPais pais;
    private ConsultaContinente Cont;
    private clContinente cCont;
    public CtrlGestPaquete(frmPaquete paquete, ConsultasCliente ConClie, clCliente clie, ConsultaPais cPais, clPais Pais, ConsultaContinente Cont, clContinente cCont) throws SQLException{
        this.paquete = paquete;
        this.ConClie = ConClie;
        this.clie    = clie;
        this.pais    = Pais;
        this.cPais   = cPais;
        this.Cont    = Cont;
        this.cCont   = cCont;
        this.paquete.btnBuscar.addActionListener(this); //Escucha del botón de búsqueda de cliente.
        this.paquete.cmbPais.addActionListener(this); //Escucha de la accion del combobox pais.
        ResultSet rs = this.cPais.ListarPaises();
        try{
            while(rs.next()){
                this.paquete.cmbPais.addItem(rs.getString("descripcion"));
            }
            this.cPais.ListarPaises().close();
        }catch(SQLException e){
            System.err.println(e);
        }
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
        }else if(e.getSource() == paquete.btnAgregar){
            ConsultaPaquete ConPaq = new ConsultaPaquete();
            ResultSet rs = ConPaq.ListarPaquete(paquete.cmbPais.getSelectedItem().toString());
            try {
                while(rs.next()){
                    paquete.cmbPaquete.addItem(rs.getString("descripcion"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlGestPaquete.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(e.getSource() == paquete.cmbPais){
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
