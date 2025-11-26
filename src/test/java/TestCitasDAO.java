/*
*   Santiago Ruiz Gallego.
*   Juan Camilo Garcia Durango.
*   Isaac Antillano Cruiz.
*   Andres David Gaitan.
*   Gabriela Lourdes Gomez.
*/

import com.mycompany.parcial2poe.Dao.*;
import com.mycompany.parcial2poe.M_Citas.Citas;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;

public class TestCitasDAO {
    
    public static void main(String[] args) {
        Connection conexion = null;
        
        try {
            conexion = ConexionBD.getConexion();
            
            CitasDAO citasDAO = new CitasDAO(conexion);
            
            // Crear cita de prueba (usa IDs existentes de paciente y consultorio)
            Citas citaPrueba = new Citas(
                1,  // id_paciente (debe existir en tu BD)
                1,  // id_consultorio (debe existir en tu BD)
                LocalDate.of(2025, 12, 10),
                LocalTime.of(10, 30),
                "revision",
                "solicitada",
                "media"
            );
            
            int idCita = citasDAO.insertar(citaPrueba);
            JOptionPane.showMessageDialog(null, 
                "✅ Cita insertada con ID: " + idCita);
            
            // Buscar la cita
            Citas citaRecuperada = citasDAO.buscarPorId(idCita);
            if (citaRecuperada != null) {
                citaRecuperada.mostrarInfoCita();
            }
            JOptionPane.showMessageDialog(null, "✅ Todas las pruebas completadas!");
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