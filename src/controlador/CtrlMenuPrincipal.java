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
import vista.frmCiudad;
import vista.frmContinente;
import vista.frmPais;
import vista.frmCobranza;
import modelo.ConsultasCliente;
import modelo.ConsultaCiudad;
import modelo.clCliente;
import modelo.ConsultaPais;
import modelo.clPais;
import modelo.clCiudad;
import modelo.ConsultaContinente;
import modelo.clContinente;
import modelo.clUsuario;
import modelo.ConsultaUsuarios;
import modelo.ConsultaCobranzas;
import modelo.clCobranza;
import controlador.CtrlCobranzas;
import controlador.CtrlGestPaquete;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import static java.util.Spliterators.iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
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
    public frmCiudad ciudad;
    public clCliente cli;
    public clContinente cCont;
    public clPais pais;
    public clCiudad ciu;
    
    public CtrlMenuPrincipal(frmPrincipal menu){
        this.MenuPrincipal = menu;
        this.MenuPrincipal.jmiTratarPaquete.addActionListener(this);
        this.MenuPrincipal.jmiUsuario.addActionListener(this);
        this.MenuPrincipal.mnuitmCliente.addActionListener(this);
        this.MenuPrincipal.mnuitmContinente.addActionListener(this);
        this.MenuPrincipal.mnuitmPais.addActionListener(this);
        this.MenuPrincipal.mnuitmCiudad.addActionListener(this);
        this.MenuPrincipal.jmiCobranza.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == MenuPrincipal.jmiTratarPaquete){
            
            frmPaquete paq = new frmPaquete();
            ConsultasCliente ConClie = new ConsultasCliente();
            clCliente Clie = new clCliente();
            ConsultaPais cPais = new ConsultaPais();
            clPais Pais = new clPais();
            ConsultaContinente Cont  = new ConsultaContinente();
            clContinente cCont = new clContinente();
            ConsultaCiudad cCiudad = new ConsultaCiudad();
            clCiudad ciu = new clCiudad();
            CtrlGestPaquete acciones = new CtrlGestPaquete(paq, ConClie, Clie, cPais, Pais, Cont, cCont);
            MenuPrincipal.jdpPrincipal.add(paq);
            
            paq.setVisible(true);
        }else if(e.getSource() == MenuPrincipal.jmiUsuario){
            frmGestionUsuario GestUs = new frmGestionUsuario();
            ConsultaUsuarios ConsUsuarios = new ConsultaUsuarios();
            clUsuario usuario = new clUsuario();
            CtrlGestUsuario gestUsuario = new CtrlGestUsuario(GestUs, usuario, ConsUsuarios);
            MenuPrincipal.jdpPrincipal.add(GestUs);
            GestUs.setVisible(true);
        }else if(e.getSource()== MenuPrincipal.mnuitmCliente){
            frmCliente GesClie = new frmCliente();
            ConsultasCliente ConClie = new ConsultasCliente();
            clCliente Clie = new clCliente();
            clPais Pais = new clPais();
            ConsultaPais cPais = new ConsultaPais();
            
            try {
                CtrlclCliente clieC = new CtrlclCliente(Clie, ConClie, GesClie, cPais, Pais);
            } catch (SQLException ex) {
                Logger.getLogger(CtrlMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            MenuPrincipal.jdpPrincipal.add(GesClie);
            GesClie.setVisible(true);
        }else if(e.getSource()== MenuPrincipal.mnuitmContinente){
            frmContinente GesCont = new frmContinente();
            ConsultaContinente ConCont = new ConsultaContinente();
            clContinente Cont = new clContinente();
            
            
            CtrlclContinente contC = new CtrlclContinente(Cont, ConCont, GesCont);
            MenuPrincipal.jdpPrincipal.add(GesCont);
            GesCont.setVisible(true);
        }else if(e.getSource()== MenuPrincipal.mnuitmPais){
            frmPais GesPais = new frmPais();
            ConsultaPais Clpais = new ConsultaPais();
            clPais pais = new clPais();
            
            
            CtrlclPais contC = new CtrlclPais(pais, Clpais, GesPais);
            MenuPrincipal.jdpPrincipal.add(GesPais);
            GesPais.setVisible(true);
        }
        else if(e.getSource()== MenuPrincipal.mnuitmCiudad){
            frmCiudad GesCiudad = new frmCiudad();
            ConsultaCiudad ClCiudad = new ConsultaCiudad();
            clCiudad ciu = new clCiudad();
            
            
            CtrlclCiudad contC = new CtrlclCiudad(ciu, ClCiudad, GesCiudad);
            MenuPrincipal.jdpPrincipal.add(GesCiudad);
            GesCiudad.setVisible(true);
        }else if(e.getSource() == MenuPrincipal.jmiCobranza){
            frmCobranza GesCob = new frmCobranza();
            ConsultaCobranzas ConsCobranza = new ConsultaCobranzas();
            clCobranza clsCobranzas = new clCobranza();
            CtrlCobranzas ctrlCobranzas = new CtrlCobranzas(GesCob, clsCobranzas, ConsCobranza);
            MenuPrincipal.jdpPrincipal.add(GesCob);
            GesCob.setVisible(true);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}    
