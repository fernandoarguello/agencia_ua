/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author claud
 */
public class ConsultaCategoria extends clConexion{
    
   public boolean registrar(clCategoria cat) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO dbagencia.tblCategoria (idCategoria,descripcion) VALUES(?,?)";
         try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cat.getIdCategoria());
            ps.setString(3, cat.getDescripcion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    

 public boolean modificar(clCategoria cat) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE dbagencia.tblCategoria SET idCategoria=?,descripcion=?,WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cat.getIdCategoria());
            ps.setString(2, cat.getDescripcion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
 public boolean eliminar(clCategoria cat) {
        PreparedStatement ps = null;
        java.sql.Connection con = getConexion();

        String sql = "DELETE FROM dbagencia.tblCategoria WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cat.getIdCategoria());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
 public boolean buscar(clCategoria cat) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Connection con = getConexion();

        String sql = "SELECT * FROM dbagencia.tblCategoria WHERE idCategoria=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cat.getIdCategoria());
            rs = ps.executeQuery();

            if (rs.next()) {
                cat.setIdCategoria(Integer.parseInt(rs.getString("categoria")));
                cat.setDescripcion(rs.getString("descripcion"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}  

