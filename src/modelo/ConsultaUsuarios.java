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
    public boolean eliminar(){
        return true;
    }
    public boolean modificar(){
        return true;
    }
    public boolean buscar(){
        return true;
    }
}
