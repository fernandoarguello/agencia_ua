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
public class ConsultaCiudad extends clConexion{
      public boolean registrar(clCiudad ciu) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO dbagencia.tblCiudad (idCiudad, idPais, descripcion) VALUES(?,?,?)";
         try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ciu.getIdPais());
            ps.setString(3, ciu.getDescripcion());
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
    

 public boolean modificar(clCiudad ciu) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE dbagencia.tblciudad SET idCiudad=?, idPais=?, descripcion=?,WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ciu.getIdCiudad());
            ps.setInt(2, ciu.getIdPais());
            ps.setString(3, ciu.getDescripcion());
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
 public boolean eliminar(clCiudad ciu) {
        PreparedStatement ps = null;
        java.sql.Connection con = getConexion();

        String sql = "DELETE FROM dbagencia.tblCiudad WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ciu.getIdCiudad());
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
 public boolean buscar(clCiudad ciu) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.sql.Connection con = getConexion();

        String sql = "SELECT * FROM dbagencia.tblCiudad WHERE idCiudad=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ciu.getIdCiudad());
            rs = ps.executeQuery();

            if (rs.next()) {
                ciu.setIdCiudad(Integer.parseInt(rs.getString("ciudad")));
                ciu.setIdPais(rs.getInt("pais"));
                ciu.setDescripcion(rs.getString("descripcion"));
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

    

