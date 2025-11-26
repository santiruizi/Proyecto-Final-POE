/*
*   Santiago Ruiz Gallego.
*   Juan Camilo Garcia Durango.
*   Isaac Antillano Cruiz.
*   Andres David Gaitan.
*   Gabriela Lourdes Gomez.
*/

import com.mycompany.parcial2poe.Dao.ConexionBD;
import com.mycompany.parcial2poe.Dao.EmpleadoDAO;
import com.mycompany.parcial2poe.M_Empleados.Empleado;
import java.sql.Connection;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class TestEmpleadoDAO {
    
    public static void main(String[] args) {
        Connection conexion = null;
        
        try {
            conexion = ConexionBD.getConexion();
            
            EmpleadoDAO empleadoDAO = new EmpleadoDAO(conexion);
            
            Empleado empleadoPrueba = new Empleado(
                "CC", 555666777, "Dr. Carlos Martínez",
                LocalDate.of(1985, 4, 10),
                "Cali", "Colombia", "Médico",
                "Avenida 6 #30-50", 3307890, 320123456,
                "Médico General"
            );
            
            int idEmpleado = empleadoDAO.insertar(empleadoPrueba);
            JOptionPane.showMessageDialog(null, 
                "✅ Empleado insertado con ID: " + idEmpleado);
            
            Empleado empleadoRecuperado = empleadoDAO.buscarPorId(idEmpleado);
            if (empleadoRecuperado != null) {
                empleadoRecuperado.getInfo();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null) conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}