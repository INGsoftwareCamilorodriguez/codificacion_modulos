import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/confecciones_maty",
                    "root",
                    ""
            );
            System.out.println("Conexion exitosa");
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
