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
import modelo.clValidaSesion; //Gestor de la conexión
import modelo.clUsuario; //Constructor
import vista.frmAcceso; //Formulario para Acceso
import vista.frmPrincipal;
// Clases Estandar
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class clSesion implements ActionListener{
    public clValidaSesion validaSesion;
    public clUsuario usuario;
    public frmAcceso acceso;
    public frmPrincipal principal;
    public clSesion(clValidaSesion validaSesion, clUsuario usuario, frmAcceso acceso){
        this.validaSesion = validaSesion;
        this.usuario = usuario;
        this.acceso = acceso;
        this.acceso.btnAceptar.addActionListener(this);
        this.acceso.btnCancelar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == acceso.btnAceptar){
            usuario.setNombre(acceso.txtUsuario.getText());
            if(validaSesion.buscar(usuario)){
                String psw = acceso.pswContrasenha.getText();
                if(psw == usuario.getPassword().toString()){
                    frmPrincipal pantPrincipal = new frmPrincipal();
                    pantPrincipal.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Contrasenha Incorrecta.");
                }
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
