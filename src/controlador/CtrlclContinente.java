/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.ConsultaContinente;
import modelo.clContinente;
import vista.frmContinente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo Giménez
 */
public class CtrlclContinente implements ActionListener{
    private clContinente cont;
    private ConsultaContinente contC;
    private frmContinente frm;
    
    public CtrlclContinente(clContinente cont, ConsultaContinente contC, frmContinente frm){
        this.cont = cont;
        this.contC = contC;
        this.frm = frm;
        this.frm.btnInsertar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }
    
    public void iniciar(){
        frm.setTitle("Continente");
        frm.setLocationRelativeTo(null);
        frm.txtDescripcion.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== frm.btnInsertar){
            cont.setDescripcion(frm.txtDescripcion.getText());
                        
            if(contC.registrar(cont))
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnModificar) {
            cont.setDescripcion(frm.txtDescripcion.getText());
                        
            if(contC.modificar(cont))
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnEliminar) {
            cont.setDescripcion(frm.txtDescripcion.getText());
            
            if(contC.eliminar(cont))
            {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnBuscar) {
            cont.setDescripcion(frm.txtDescripcion.getText());
            
            if(contC.buscar(cont))
            {
                //frm.txtDescripcion.setText(cont.getDescripcion());
                JOptionPane.showMessageDialog(null, "Registro Encontrado");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }
    }
    
    public void limpiar()
    {
        frm.txtDescripcion.setText(null);
    }
}