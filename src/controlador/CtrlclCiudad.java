/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.ConsultaCiudad;
import modelo.clCiudad;
import vista.frmCiudad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;

/**
 *
 * @author claud
 */
public class CtrlclCiudad implements ActionListener{
    private clCiudad cont;
    private ConsultaCiudad contC;
    private frmCiudad frm;
    
    public CtrlclCiudad(clCiudad cont, ConsultaCiudad contC, frmCiudad frm){
        this.cont = cont;
        this.contC = contC;
        this.frm = frm;
        this.frm.btnInsertar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }

//    CtrlclCiudad(clCiudad ciu, ConsultaCiudad ClCiudad, frmCiudad GesCiudad) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    public void iniciar(){
        frm.setTitle("Ciudad");
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
            //cont.setDescripcion(frm.txtDescripcion.getText());
                        
            if(contC.modificar(cont,frm.txtDescripcion.getText()))
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
                this.cont.setIdContinente(cont.getIdPais());
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
