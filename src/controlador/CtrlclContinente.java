package Controlador;

import modelo.ConsultaContinente;
import modelo.clContinente;
import vista.frmContinente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlclContinente implements ActionListener {

    private clContinente mod;
    private ConsultaContinente modC;
    private frmContinente frm;

    public CtrlclContinente(clContinente mod, ConsultaContinente modC, frmContinente frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnInsertar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        //this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Continente");
        frm.setLocationRelativeTo(null);
        frm.txtDescripcion.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frm.btnInsertar) {
            mod.setDescripcion(frm.txtDescripcion.getText());
           
            
            if(modC.registrar(mod))
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnModificar) {
            
            mod.setDescripcion(frm.txtDescripcion.getText());
            
            if(modC.modificar(mod))
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnEliminar) {
            mod.setDescripcion(frm.txtDescripcion.getText());
            
            if(modC.eliminar(mod))
            {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnBuscar) {
            mod.setDescripcion(frm.txtDescripcion.getText());
            
            if(modC.buscar(mod))
            {
              mod.setDescripcion(frm.txtDescripcion.getText());

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }
        
//        if (e.getSource() == frm.btnLimpiar) {
//            limpiar();
//        }

    }
    
    public void limpiar()
    {
        frm.txtDescripcion.setText(null);
        
    }

}
