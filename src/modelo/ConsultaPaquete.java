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
 * @author farguello
 */
public class ConsultaPaquete {
    public boolean registrar (clPaquete paq) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO Paquete (idPaquete, idAtractivo, idCliente,FechaSalida,FechaRetorno) VALUES(?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, paq.getIdPaquete());
            ps.setInt(2, paq.getIdAtractivo());
            ps.setInt(3, paq.getIdCliente());
            ps.setDate(4, (Date) paq.getFechaSalida());
             ps.setDate(4, (Date) paq.getFechaRetorno());
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
    public boolean modificar(clPaquete paq) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE tblPaquete SET idPaquete=?, descripcion=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, paq.getIdPaquete());
            ps.setInt(2, paq.getIdAtractivo());
            ps.setInt(3, paq.getIdCliente());
            ps.setDate(4, (Date) paq.getFechaSalida());
             ps.setDate(4, (Date) paq.getFechaRetorno());
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
    public boolean eliminar(clPaquete paq) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM tblPaquete WHERE idPaquete=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, paq.getIdPaquete());
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
    public boolean buscar(clPaquete paq) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM tblPaquere WHERE idPaquete=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, paq.getIdPaquete());
            rs = ps.executeQuery();

            if (rs.next()) {
                paq.setIdPaquete(Integer.parseInt(rs.getString("idPaquete")));
                paq.setIdAtractivo(Integer.parseInt(rs.getString("idAtractivo")));
                paq.setIdCliente(Integer.parseInt(rs.getString("idCliente")));
               paq.setFechaSalida(rs.getDate("FechaSalida"));
               paq.setFechaSalida(rs.getDate("FechaRetorno"));
                
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
