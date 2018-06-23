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

    private Connection getConexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

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
