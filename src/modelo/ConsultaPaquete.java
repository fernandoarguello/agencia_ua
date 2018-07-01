/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author farguello
 */
public class ConsultaPaquete extends clConexion{
    public boolean registrar (clPaquete paq) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO dbagencia.tblPaquete (idPaquete, idAtractivo, idCliente,FechaSalida,FechaRetorno) VALUES(?,?,?,?,?)";
        
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

        String sql = "UPDATE dbagencia.tblPaquete SET idPaquete=?, descripcion=?";

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

        String sql = "DELETE FROM dbagencia.tblPaquete WHERE idPaquete=? ";

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

        String sql = "SELECT * FROM dbagencia.tblPaquete WHERE idPaquete=? ";

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

////    private Connection getConexion() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    

    public ArrayList ListarPaquete(clPais p){
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        java.sql.Connection cn = getConexion();
        
        String sql = "SELECT * FROM dbagencia.tblpais WHERE descripcion like '" + p.getDescripcion() +"'";
        ArrayList<String> modelo = new ArrayList();
        try{
            ps = cn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            if(rs.next()){
                int idPais = rs.getInt("idPais");
                ps = null;
                rs = null;
                sql = "SELECT * FROM dbagencia.tblAtractivo where idPais = ?";
                ps = cn.prepareStatement(sql);
                ps.setInt(1, idPais);
                rs = ps.executeQuery();
                while(rs.next()){
                    String paquete = rs.getString("descripcion");
                    modelo.add(paquete);
                }
            }
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        return modelo;
    }
    public boolean RegistrarPaquete(clPaquete paquete){
        PreparedStatement ps = null;
        Connection       con = getConexion();
        String sql = "INSERT INTO dbagencia.tblpaquete(idAtractivo, FechaSalida, FechaRetorno, tblCliente_idCliente, estado, importe) values (?,?,?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, paquete.getIdAtractivo());
            ps.setDate(2, Date.valueOf(paquete.getFechaSalida().toString()));
            ps.setDate(3, Date.valueOf(paquete.getFechaRetorno().toString()));
            ps.setInt(4, paquete.getIdCliente());
            ps.setBoolean(5, paquete.getEstado());
            ps.setDouble(6, paquete.getImporte());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
                JOptionPane.showMessageDialog(null, "Registro Insertado Correctamente!!!");
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    public String ObtCliente(clCliente c){
        String doc           = null;
        PreparedStatement ps = null;
        ResultSet rs         = null;
        com.mysql.jdbc.Connection con = getConexion();
        String sql = "SELECT * FROM dbagencia.tblcliente where documento = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getDocumento());
            rs = ps.executeQuery();
            if(rs.next()){
               doc = rs.getString("documento");
            }else{
                JOptionPane.showMessageDialog(null, "No se encuentra el registro");
            }
        }catch(SQLException e){
            System.err.println(e);
            
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        return doc;
    }
    public clAtractivo ObtPaquete(clAtractivo a){
        PreparedStatement ps = null;
            ResultSet         rs = null;
            com.mysql.jdbc.Connection con = getConexion();
            String sql = "SELECT * FROM dbagencia.tblatractivo WHERE descripcion like '"+a.getDescripcion().toString()+"'";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                a.setIdAtractivo(rs.getInt("idAtractivo"));
            }
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        return a;
    }
}
