package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.clCliente;
import vista.frmCliente;

/**
 *
 * @author Eduardo Giménez
 */
public class CtrlclCliente implements ActionListener{
    private clCliente cli;
    
    public CtrlclCliente(clCliente cli){
        this.cli = cli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
