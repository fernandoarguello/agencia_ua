/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.SQLException;
import modelo.clCobranza;
/**
 *
 * @author farguello
 */
public class ConsultaCobranzas extends clConexion{
    public boolean GuardarCobranza(clCobranza cobro){
        PreparedStatement   ps = null;
        com.mysql.jdbc.Connection con = getConexion();
        
        String sql = "Insert into dbagencia(idPaquete, MontoCobrado, FechaCobro) values (?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, cobro.getIdpaquete());
            ps.setDouble(2, cobro.getMontoCobrado());
            ps.setDate(1, Date.valueOf(cobro.getFechaCobro().toString()));
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
    }
    public boolean BuscarCliente(clCliente cliente){
        PreparedStatement  ps = null;
        ResultSet          rs = null;
        return false;
    }
    
}
