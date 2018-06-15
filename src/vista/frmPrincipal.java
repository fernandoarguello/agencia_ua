/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Eduardo Giménez
 */
public class frmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpPrincipal = new javax.swing.JDesktopPane();
        mnuPrincipal = new javax.swing.JMenuBar();
        mnuMenu = new javax.swing.JMenu();
        mnuitmCambioContrasenha = new javax.swing.JMenuItem();
        sprSeparador1 = new javax.swing.JPopupMenu.Separator();
        mnuitmSalir = new javax.swing.JMenuItem();
        mnuMantenimiento = new javax.swing.JMenu();
        mnuitmCliente = new javax.swing.JMenuItem();
        mnuitmPais = new javax.swing.JMenuItem();
        mnuitmCiudad = new javax.swing.JMenuItem();
        mnuGestion = new javax.swing.JMenu();
        jmiTratarPaquete = new javax.swing.JMenuItem();
        mnuConsultas = new javax.swing.JMenu();
        mnuAdministrar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icn_agencia.png")).getImage());

        javax.swing.GroupLayout jdpPrincipalLayout = new javax.swing.GroupLayout(jdpPrincipal);
        jdpPrincipal.setLayout(jdpPrincipalLayout);
        jdpPrincipalLayout.setHorizontalGroup(
            jdpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
        );
        jdpPrincipalLayout.setVerticalGroup(
            jdpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );

        mnuMenu.setText("Menú");

        mnuitmCambioContrasenha.setText("Cambiar Contraseña");
        mnuMenu.add(mnuitmCambioContrasenha);
        mnuMenu.add(sprSeparador1);

        mnuitmSalir.setText("Salir");
        mnuitmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuitmSalirActionPerformed(evt);
            }
        });
        mnuMenu.add(mnuitmSalir);

        mnuPrincipal.add(mnuMenu);

        mnuMantenimiento.setText("Mantenimiento");

        mnuitmCliente.setText("Cliente");
        mnuitmCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mnuitmCliente.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        mnuMantenimiento.add(mnuitmCliente);

        mnuitmPais.setText("País");
        mnuitmPais.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mnuitmPais.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        mnuMantenimiento.add(mnuitmPais);

        mnuitmCiudad.setText("Ciudad");
        mnuitmCiudad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mnuitmCiudad.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        mnuMantenimiento.add(mnuitmCiudad);

        mnuPrincipal.add(mnuMantenimiento);

        mnuGestion.setText("Gestión");

        jmiTratarPaquete.setText("Tratar Paquete");
        mnuGestion.add(jmiTratarPaquete);

        mnuPrincipal.add(mnuGestion);

        mnuConsultas.setText("Consultas");
        mnuPrincipal.add(mnuConsultas);

        mnuAdministrar.setText("Administrar");
        mnuPrincipal.add(mnuAdministrar);

        setJMenuBar(mnuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpPrincipal)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnuitmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuitmSalirActionPerformed
        dispose();
    }//GEN-LAST:event_mnuitmSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane jdpPrincipal;
    public javax.swing.JMenuItem jmiTratarPaquete;
    private javax.swing.JMenu mnuAdministrar;
    private javax.swing.JMenu mnuConsultas;
    public javax.swing.JMenu mnuGestion;
    private javax.swing.JMenu mnuMantenimiento;
    private javax.swing.JMenu mnuMenu;
    public javax.swing.JMenuBar mnuPrincipal;
    private javax.swing.JMenuItem mnuitmCambioContrasenha;
    private javax.swing.JMenuItem mnuitmCiudad;
    private javax.swing.JMenuItem mnuitmCliente;
    private javax.swing.JMenuItem mnuitmPais;
    private javax.swing.JMenuItem mnuitmSalir;
    private javax.swing.JPopupMenu.Separator sprSeparador1;
    // End of variables declaration//GEN-END:variables
}
