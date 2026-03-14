package com.confeccionesmaty.dao;

import com.confeccionesmaty.modelo.Producto;
import com.confeccionesmaty.util.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public void insertarProducto(Producto producto) {
        String sql = "INSERT INTO productos (codigo, nombre, precio) VALUES (?, ?, ?)";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setFloat(3, producto.getPrecio());
            ps.executeUpdate();
            System.out.println("Producto insertado.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Producto> consultarProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Connection con = Conexion.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Producto(
                        rs.getInt("codigo"),
                        rs.getString("nombre"),
                        rs.getFloat("precio")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }

    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE productos SET nombre=?, precio=? WHERE codigo=?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, producto.getNombre());
            ps.setFloat(2, producto.getPrecio());
            ps.setInt(3, producto.getCodigo());
            ps.executeUpdate();
            System.out.println("Producto actualizado.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarProducto(int codigo) {
        String sql = "DELETE FROM productos WHERE codigo=?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
            System.out.println("Producto eliminado.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}