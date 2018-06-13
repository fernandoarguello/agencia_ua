/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Eduardo Giménez
 */
public class ConsultasCliente extends clConexion{
    public boolean registrar (clCliente cli) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        
        String sql = "INSERT INTO tblCliente (idCliente, documento, TipoDocumento, Nombres, Apellidos, FechaNacimiento, direccion, ciudad, telefono, mail) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cli.getIdCliente());
            ps.setString(2, cli.getDocumento());
            ps.setString(3, cli.getTipoDocumento());
            ps.setString(4, cli.getNombres());
            ps.setString(5, cli.getApellidos());
            ps.setDate(6, cli.getFechaNacimiento());
            ps.setString(7, cli.getDireccion());
            ps.setInt(8, cli.getCiudad());
            ps.setString(9, cli.getTelefono());
            ps.setString(10, cli.getMail());
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
     public boolean modificar(clCliente cli) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE tblCliente SET documento=?, TipoDocumento=?, Nombres=? WHERE idCliente=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDocumento());
            ps.setString(2, cli.getTipoDocumento());
            ps.setString(3, cli.getNombres());
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
}
