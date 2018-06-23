/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author claud
 */
public class ConsultaAtractivo {
   public boolean registrar (clAtractivo atr) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO Paquete (idAtractivo, idPais,idCiudad,idCategoria,descripcion,preico,hora_inicio,hora_fin) VALUES(?,?,?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, atr.getIdAtractivo());
            ps.setInt(2, atr.getIdPais());
            ps.setInt(3, atr.getIdCiudad());
            ps.setInt(3, atr.getIdCategoria());
            ps.setString(4, atr.getDescripcion());
            ps.setDouble(5, atr.getPrecio());
            ps.setTime(6, atr.getHora_inicio());
            ps.setTime(6, atr.getHora_fin());
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
    public boolean modificar(clAtractivo atr) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE tblAtractivo SET idAtractivo=?, idPais=?,idCiudad=?,idCategoria=?,descripcion=?,preico=?,hora_inicio=?,hora_fin=?";

        try {
             ps = con.prepareStatement(sql);
            ps.setInt(1, atr.getIdAtractivo());
            ps.setInt(2, atr.getIdPais());
            ps.setInt(3, atr.getIdCiudad());
            ps.setInt(3, atr.getIdCategoria());
            ps.setString(4, atr.getDescripcion());
            ps.setDouble(5, atr.getPrecio());
            ps.setTime(6, atr.getHora_inicio());
            ps.setTime(6, atr.getHora_fin());
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
    public boolean eliminar(clAtractivo atr) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM tblAtractivo WHERE idAtractivo=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, atr.getIdAtractivo());
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
    public boolean buscar(clAtractivo atr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM tblAtractivo WHERE idAtractivo=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, atr.getIdAtractivo());
            rs = ps.executeQuery();

            if (rs.next()) {
                atr.setIdAtractivo(Integer.parseInt(rs.getString("idAtractivo")));
                atr.setIdPais(Integer.parseInt(rs.getString("idPais")));
                atr.setIdCiudad(Integer.parseInt(rs.getString("idCiudad")));
                atr.setIdCategoria(Integer.parseInt(rs.getString("idCategoria")));
                atr.setDescripcion(rs.getString("descripcion"));
                atr.setPrecio(rs.getDouble("precio"));
               atr.setHora_inicio(rs.getTime("Hora_inicio"));
               atr.setHora_fin(rs.getTime("setHora_fin"));
                
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
      
    private Connection getConexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
 
}
