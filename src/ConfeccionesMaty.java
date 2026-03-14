import com.confeccionesmaty.dao.*;
import com.confeccionesmaty.modelo.*;
import java.sql.Connection;
import com.confeccionesmaty.util.Conexion;

public class ConfeccionesMaty {

    public static void main(String[] args) {

        Connection con = Conexion.obtenerConexion();
        if (con != null) {
            System.out.println("=== Sistema iniciado ===\n");
        }

        System.out.println("--- CLIENTES ---");
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.insertarCliente(new Cliente("C001", "Maria", "Lopez", "3001234567"));
        clienteDAO.consultarClientes().forEach(System.out::println);
        clienteDAO.actualizarCliente(new Cliente("C001", "Maria", "Garcia", "3009999999"));
        clienteDAO.consultarClientes().forEach(System.out::println);
        clienteDAO.eliminarCliente("C001");

        System.out.println("\n--- PRODUCTOS ---");
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.insertarProducto(new Producto(1, "Camisa", 45000f));
        productoDAO.consultarProductos().forEach(System.out::println);
        productoDAO.actualizarProducto(new Producto(1, "Camisa Manga Larga", 50000f));
        productoDAO.consultarProductos().forEach(System.out::println);
        productoDAO.eliminarProducto(1);

        System.out.println("\n--- PROVEEDORES ---");
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        proveedorDAO.insertarProveedor(new Proveedor(1, "Textiles SA", "Calle 10", 101));
        proveedorDAO.consultarProveedores().forEach(System.out::println);
        proveedorDAO.actualizarProveedor(new Proveedor(1, "Textiles Nueva", "Calle 15", 101));
        proveedorDAO.consultarProveedores().forEach(System.out::println);
        proveedorDAO.eliminarProveedor(1);

        System.out.println("\n--- COMPRAS ---");
        clienteDAO.insertarCliente(new Cliente("C002", "Juan", "Perez", "3112345678"));
        productoDAO.insertarProducto(new Producto(2, "Pantalon", 80000f));
        CompraDAO compraDAO = new CompraDAO();
        compraDAO.insertarCompra(new Compra("C002", 2));
        compraDAO.consultarCompras().forEach(System.out::println);
        compraDAO.actualizarCompra("C002", 2);
        compraDAO.consultarCompras().forEach(System.out::println);
        compraDAO.eliminarCompra("C002");
        clienteDAO.eliminarCliente("C002");
        productoDAO.eliminarProducto(2);

        System.out.println("\n=== CRUD completado ===");
    }
}