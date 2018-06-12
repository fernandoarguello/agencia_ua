/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import modelo.clUsuario;
import modelo.clValidaSesion;
import vista.frmAcceso;
import controlador.ctrlSesion;
import modelo.clUsuario;
import modelo.clValidaSesion;
/**
 *
 * @author farguello
 */
public class clArranque {
       
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>

        /* Create and display the form */
        public static void main(String[] args) {
            clUsuario usuario = new clUsuario(); //Instancia el Constructor de la tabla de usuario
            clValidaSesion validaSesion = new clValidaSesion(); // Instancia la funcion que consulta la bd
            frmAcceso acceso = new frmAcceso(); //Instancia el formulario
            ctrlSesion sesion = new ctrlSesion(validaSesion, usuario, acceso); //Instancia la escucha de los eventos
            acceso.setVisible(true);
        }
    

}
