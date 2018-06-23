package controlador;

import modelo.ConsultasCliente;
import modelo.clCliente;
import vista.frmCliente;
import modelo.ConsultaPais;
import modelo.ConsultaCiudad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.clPais;

/**
 *
 * @author Eduardo Giménez
 */
public class CtrlclCliente implements ActionListener{
    private clCliente cli;
    private ConsultasCliente cliC;
    private frmCliente frm;
    private ConsultaPais conP;
    private clPais pais;
    
    public CtrlclCliente(clCliente cli, ConsultasCliente cliC, frmCliente frm, ConsultaPais conP, clPais pais) throws SQLException{
        this.cli = cli;
        this.cliC = cliC;
        this.frm = frm;
        this.conP = conP;
        this.pais = pais;
        this.frm.btnGrabar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        
        ResultSet resS = conP.ListarPaises();
        try{
            while (resS.next()){
                frm.cmbPais.addItem(resS.getString("descripcion"));
            }
            this.conP.ListarPaises().close();
        }catch(SQLException e){
                    System.err.println(e);
        }
        
        ResultSet resB = conP.ObtieneIdPais();
        try{
            while (resB.next()){
                frm.cmbCiudad.addItem(resB.getString("descripcion"));
            }
            this.conP.ObtieneIdPais().close();
        }catch(SQLException e){
                System.err.println(e);
        }
            
    }

    
        
    
    
    public void iniciar(){
        frm.setTitle("Cliente");
        frm.setLocationRelativeTo(null);
        frm.txtIdCliente.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== frm){
        
        }else if(e.getSource()== frm.btnGrabar){
            cli.setIdCliente(Integer.parseInt(frm.txtIdCliente.getText()));
            cli.setTipoDocumento(frm.cmbTipoDocumento.toString());
            cli.setNombres(frm.txtNombres.getText());
            cli.setApellidos(frm.txtApellidos.getText());
            cli.setDireccion(frm.txtDireccion.getText());
            cli.setDescripcion(frm.cmbPais.getSelectedItem().toString());
            //cli.setIdPais(Integer.parseInt(frm.cmbPais.toString()));
            cli.setCiudad(Integer.parseInt(frm.cmbCiudad.toString()));
            cli.setTelefono(frm.txtTelefono.getText());
            cli.setMail(frm.txtEmail.getText());
            
            if(cliC.registrar(cli))
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnModificar) {
            cli.setIdCliente(Integer.parseInt(frm.txtIdCliente.getText()));
            cli.setDocumento(frm.txtDocumento.getText());
            cli.setTipoDocumento(frm.cmbTipoDocumento.toString());
            cli.setNombres(frm.txtNombres.getText());
            cli.setApellidos(frm.txtApellidos.getText());
            cli.setDireccion(frm.txtDireccion.getText());
            cli.setIdPais(Integer.parseInt(frm.cmbPais.toString()));
            cli.setCiudad(Integer.parseInt(frm.cmbCiudad.toString()));
            cli.setTelefono(frm.txtTelefono.getText());
            cli.setMail(frm.txtEmail.getText());
            
            if(cliC.modificar(cli))
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnEliminar) {
            cli.setIdCliente(Integer.parseInt(frm.txtIdCliente.getText()));
            
            if(cliC.eliminar(cli))
            {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnBuscar) {
            cli.setDocumento(frm.txtDocumento.getText());
            
            if(cliC.buscar(cli)){
                frm.txtIdCliente.setText(String.valueOf(cli.getIdCliente()));
                frm.txtDocumento.setText(cli.getDocumento());
                frm.cmbTipoDocumento.addItem("Cédula");
                frm.txtNombres.setText(String.valueOf(cli.getNombres()));
                frm.txtApellidos.setText(String.valueOf(cli.getApellidos()));
                frm.txtDireccion.setText(String.valueOf(cli.getDireccion()));
                //frm.cmbPais.addItem((cli.getIdPais()));
                //frm.cmbCiudad.addItem((cli.getCiudad()));
                frm.txtFechaNacimiento.setText(String.valueOf(cli.getFechaNacimiento()));
                frm.txtTelefono.setText(String.valueOf(cli.getTelefono()));
                frm.txtEmail.setText(String.valueOf(cli.getMail()));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnLimpiar) {
            limpiar();
        }
    }
    
    public void limpiar()
    {
        frm.txtIdCliente.setText(null);
        frm.txtDocumento.setText(null);
        frm.cmbTipoDocumento.setSelectedItem("Cédula");
        frm.txtNombres.setText(null);
        frm.txtApellidos.setText(null);
        frm.txtDireccion.setText(null);
        //frm.cmbPais.setSelectedItem(null);
        //frm.cmbCiudad.setModel(null);
        frm.txtFechaNacimiento.setText(null);
        frm.txtTelefono.setText(null);
        frm.txtEmail.setText(null);
    }
}