/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import vista.frmPrincipal;
import vista.frmPaquete;
import vista.frmGestionUsuario;
import vista.frmCliente;
import vista.frmContinente;
import modelo.ConsultasCliente;
import modelo.clCliente;
import controlador.CtrlGestPaquete;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author farguello
 */
public class CtrlMenuPrincipal implements ActionListener{
    public frmPrincipal MenuPrincipal;
    public frmPaquete paquete;
    public frmGestionUsuario GestionUsuario;
    public frmCliente cliente;
    public frmContinente continente;
    public CtrlMenuPrincipal(frmPrincipal menu){
        this.MenuPrincipal = menu;
        this.MenuPrincipal.jmiTratarPaquete.addActionListener(this);
        this.MenuPrincipal.jmiUsuario.addActionListener(this);
        this.MenuPrincipal.mnuitmCliente.addActionListener(this);
        this.MenuPrincipal.mnuitmContinente.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == MenuPrincipal.jmiTratarPaquete){
            
            frmPaquete paq = new frmPaquete();
            ConsultasCliente ConClie = new ConsultasCliente();
            clCliente Clie = new clCliente();
            CtrlGestPaquete acciones = new CtrlGestPaquete(paq, ConClie, Clie);
            MenuPrincipal.jdpPrincipal.add(paq);
            
            paq.setVisible(true);
        }else if(e.getSource() == MenuPrincipal.jmiUsuario){
            frmGestionUsuario GestUs = new frmGestionUsuario();
            MenuPrincipal.jdpPrincipal.add(GestUs);
            GestUs.setVisible(true);
        }else if(e.getSource()== MenuPrincipal.mnuitmCliente){
            frmCliente GesClie = new frmCliente();
            ConsultasCliente ConClie = new ConsultasCliente();
            clCliente Clie = new clCliente();
            CtrlclCliente clieC = new CtrlclCliente(Clie, ConClie, GesClie);
            MenuPrincipal.jdpPrincipal.add(GesClie);
            GesClie.setVisible(true);
        }else if(e.getSource()== MenuPrincipal.mnuitmContinente){
            frmContinente GesCont = new frmContinente();
            MenuPrincipal.jdpPrincipal.add(GesCont);
            GesCont.setVisible(true);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
