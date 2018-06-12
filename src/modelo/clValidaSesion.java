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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class clValidaSesion extends clConexion{
    public boolean buscar(clUsuario usuario){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = getConexion();
        String sql = "SELECT * FROM tblUsuario WHERE idUsuario = ?";
        try{
            ps = cn.prepareStatement(sql);
            ps.setString(1, usuario.getIdUsuario());
            rs = ps.executeQuery();
            if(rs.next()){
                usuario.setNombre("Nombre");
                usuario.setPassword("Password");
                return true;
            }
            return false;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        } 
    }
}
