package com.confeccionesmaty.dao;

import com.confeccionesmaty.modelo.Proveedor;
import com.confeccionesmaty.util.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {

    public void insertarProveedor(Proveedor proveedor) {
        String sql = "INSERT INTO proveedorr (id_provedor, nombre, direccion, codigo_proveerdor) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, proveedor.getIdProveedor());
            ps.setString(2, proveedor.getNombre());
            ps.setString(3, proveedor.getDireccion());
            ps.setInt(4, proveedor.getCodigoProveedor());
            ps.executeUpdate();
            System.out.println("Proveedor insertado.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Proveedor> consultarProveedores() {
        List<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM proveedorr";
        try (Connection con = Conexion.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Proveedor(
                        rs.getInt("id_provedor"),
                        rs.getString("nombre"),
                        rs.getString("direccion"),
                        rs.getInt("codigo_proveerdor")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }

    public void actualizarProveedor(Proveedor proveedor) {
        String sql = "UPDATE proveedorr SET nombre=?, direccion=?, codigo_proveerdor=? WHERE id_provedor=?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getDireccion());
            ps.setInt(3, proveedor.getCodigoProveedor());
            ps.setInt(4, proveedor.getIdProveedor());
            ps.executeUpdate();
            System.out.println("Proveedor actualizado.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarProveedor(int id) {
        String sql = "DELETE FROM proveedorr WHERE id_provedor=?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Proveedor eliminado.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}