package com.confeccionesmaty.dao;

import com.confeccionesmaty.modelo.Compra;
import com.confeccionesmaty.util.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {

    public void insertarCompra(Compra compra) {
        String sql = "INSERT INTO compra (id_Cliente, code_Producto) VALUES (?, ?)";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, compra.getIdCliente());
            ps.setInt(2, compra.getCodeProducto());
            ps.executeUpdate();
            System.out.println("Compra insertada.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Compra> consultarCompras() {
        List<Compra> lista = new ArrayList<>();
        String sql = "SELECT * FROM compra";
        try (Connection con = Conexion.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Compra(
                        rs.getString("id_Cliente"),
                        rs.getInt("code_Producto")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }

    public void actualizarCompra(String idCliente, int codeProductoNuevo) {
        String sql = "UPDATE compra SET code_Producto=? WHERE id_Cliente=?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codeProductoNuevo);
            ps.setString(2, idCliente);
            ps.executeUpdate();
            System.out.println("Compra actualizada.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarCompra(String idCliente) {
        String sql = "DELETE FROM compra WHERE id_Cliente=?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, idCliente);
            ps.executeUpdate();
            System.out.println("Compra eliminada.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}