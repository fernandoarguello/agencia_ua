/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author farguello
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import java.sql.Date;

public class ConsultaPaquete extends clConexion {
    public ResultSet ListarPaquete(String Pais){
        PreparedStatement ps =null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT SINGLE * FROM dbagencia.tblpais where idPais = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(2, Pais);
            rs = ps.executeQuery();
            if(rs.next()){
                ps = null;
                rs = null;
                sql = "SELECT SINGLE * FROM dbagencia.pais where idPais = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(2, rs.getInt("idPais"));
                rs = ps.executeQuery();
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return rs;
    }
    public boolean RegistrarPaquete(clPaquete paquete){
        PreparedStatement ps = null;
        Connection       con = getConexion();
        String sql = "INSERT INTO dbagencia.tblpaquete(idAtractivo, idCliente, FechaSalida, FechaRetorno, estado, importe) values (?,?,?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(2, 0);
            ps.setInt(3, 0);
            Date fecha = null;
            ps.setDate(4, fecha);
            ps.setDate(5, fecha);
            ps.setString(6, "");
            ps.setDouble(7, 0);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
}
