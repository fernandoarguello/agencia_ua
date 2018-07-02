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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import vista.frmGestionUsuario;
import modelo.clUsuario;
import modelo.ConsultaUsuarios;
public class CtrlGestUsuario implements ActionListener{
    frmGestionUsuario frmUsuario;
    clUsuario         usuario;
    ConsultaUsuarios  ConsUsuario;
    public CtrlGestUsuario(frmGestionUsuario frmUsuario, clUsuario usuario, ConsultaUsuarios ConsUsuario){
        this.frmUsuario     = frmUsuario;
        this.usuario        = usuario;
        this.ConsUsuario    = ConsUsuario;
        this.frmUsuario.btnAgregar.addActionListener(this);
        this.frmUsuario.btnAgregar.addKeyListener(cmdGuardar);
        this.frmUsuario.requestFocusInWindow();
        this.frmUsuario.requestFocus();
        this.frmUsuario.txtNombre.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.frmUsuario.btnAgregar){
            guardar();
        }
        if(e.getSource()==this.frmUsuario.btnBuscar){
            buscar();
        }
        if(e.getSource()==this.frmUsuario.btnModificar){
            modificar();
        }
        if(e.getSource()==this.frmUsuario.btnEliminar){
            eliminar();
        }
        if(e.getSource()==this.frmUsuario.btnCancelar){
            cancelar();
        }
    };
    
    KeyListener cmdGuardar = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            guardar();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    KeyListener cmdBuscar = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            buscar();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    KeyListener cmdEliminar = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            eliminar();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    KeyListener cmdModificar = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            modificar();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    KeyListener cmdCancelar = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            cancelar();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    private void guardar(){
        limpiar();
    }
    private void buscar(){
        
    }
    private void eliminar(){
        limpiar();
    }
    private void modificar(){
        
    }
    private void cancelar(){
        limpiar();
    }
    private void limpiar(){
        this.frmUsuario.txtNombre.setText(null);
        this.frmUsuario.txtApellido.setText(null);
        this.frmUsuario.txtUsuario.setText(null);
        this.frmUsuario.txtCorreo.setText(null);
        this.frmUsuario.txtPassword.setText(null);
        this.frmUsuario.txtRepContrasenha.setText(null);
    }
}
