/*
*   Santiago Ruiz Gallego.
*   Juan Camilo Garcia Durango.
*   Isaac Antillano Cruiz.
*   Andres David Gaitan.
*   Gabriela Lourdes Gomez.
*/

import com.mycompany.parcial2poe.Dao.ConexionBD;
import com.mycompany.parcial2poe.Dao.PacienteDAO;
import com.mycompany.parcial2poe.M_Paciente.Paciente;
import java.sql.Connection;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class TestPacienteDAO {
    
    public static void main(String[] args) {
        Connection conexion = null;
        
        try {
            conexion = ConexionBD.getConexion();
            JOptionPane.showMessageDialog(null, "✅ Conexión exitosa");
            
            PacienteDAO pacienteDAO = new PacienteDAO(conexion);
            
            // Crear paciente de prueba
            Paciente pacientePrueba = new Paciente(
                "CC", 987654321, "María García Test",
                LocalDate.of(1992, 7, 20),
                "Cali", "Colombia", "Profesora",
                "Carrera 5 #10-20", 3305678, 315987654,
                "Salud Total", "Contributivo", true
            );
            
            // Insertar
            int idPaciente = pacienteDAO.insertar(pacientePrueba);
            JOptionPane.showMessageDialog(null, 
                "✅ Paciente insertado con ID: " + idPaciente);
            
            // Buscar
            Paciente pacienteRecuperado = pacienteDAO.buscarPorId(idPaciente);
            
            if (pacienteRecuperado != null) {
                pacienteRecuperado.getInfo(); // Muestra info completa
            }
            
            JOptionPane.showMessageDialog(null, "✅ Test completado!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                "❌ Error: " + e.getMessage(), "Error", 
                JOptionPane.ERROR_MESSAGE);
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
