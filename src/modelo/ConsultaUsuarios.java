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
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConsultaUsuarios extends clConexion{
    public boolean guardar(clUsuario usuario){
        PreparedStatement ps = null;
        com.mysql.jdbc.Connection con = getConexion();
        String sql = "INSERT INTO dbagencia.tblusuario(IdUsuario, Nombre, Apellido, CorreoElectronico, Password) values(?,?,?,?,?);";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getIdUsuario());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getCorreoElectronico());
            
            ps.setString(5, usuario.getPassword());
            ps.execute();
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
        return true;
    }
    public boolean eliminar(clUsuario usuario){
        PreparedStatement ps = null;
        ResultSet         rs = null;
        com.mysql.jdbc.Connection con = getConexion();
        
        String sql = "DELETE * FROM dbagencia.tblusuario WHERE idusuario = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getIdUsuario());
            ps.execute();
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
        return true;
    }
    public boolean modificar(clUsuario usuario){
        PreparedStatement ps = null;
        ResultSet         rs = null;
        com.mysql.jdbc.Connection con = getConexion();
        
        String sql = "Update dbagencia.tblusuario set(idusuario = ?, nombre = ?, apellido = ?, correoelectronico = ?, password = ?) where (idusuario = ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getIdUsuario());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getCorreoElectronico());
            ps.setString(5, usuario.getPassword());
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
    public boolean buscar(clUsuario usuario){
        PreparedStatement ps = null;
        ResultSet         rs = null;
        com.mysql.jdbc.Connection con = getConexion();
        
        String sql = "select * from dbagencia.tblusuario where idusuario = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getIdUsuario());
            rs = ps.executeQuery();
            if(rs.next()){
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setCorreoElectronico(rs.getString("correoelectronico"));
                usuario.setPassword(rs.getString("password"));
                
            }
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
