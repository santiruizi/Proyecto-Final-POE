/*
*   Santiago Ruiz Gallego.
*   Juan Camilo Garcia Durango.
*   Isaac Antillano Cruiz.
*   Andres David Gaitan.
*   Gabriela Lourdes Gomez.
*/

import com.mycompany.parcial2poe.Dao.ConexionBD;
import com.mycompany.parcial2poe.Dao.ConsultorioDAO;
import com.mycompany.parcial2poe.M_Consultorio.Consultorio;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;

public class TestConsultorioDAO {
    
    public static void main(String[] args) {
        Connection conexion = null;
        
        try {
            // 1. Conectar a BD
            conexion = ConexionBD.getConexion();
            JOptionPane.showMessageDialog(null, "✅ Conexión exitosa");
            
            ConsultorioDAO consultorioDAO = new ConsultorioDAO(conexion);
            
            // 2. Crear consultorio de revisión
            Consultorio consultorioRevision = new Consultorio(
                "revision",         // tipo
                1,                  // id_empleado (usa el del empleado que creaste antes)
                101,                // extensión telefónica
                true,               // activo
                "N/A"                // sin causa de inactividad
            );
            
            int idConsultorio1 = consultorioDAO.insertar(consultorioRevision);
            JOptionPane.showMessageDialog(null, 
                "✅ Consultorio de Revisión creado con ID: " + idConsultorio1);
            
            // 3. Crear consultorio de procedimiento
            Consultorio consultorioProcedimiento = new Consultorio(
                "procedimiento",    // tipo
                1,                  // id_empleado
                102,                // extensión diferente
                true,               // activo
                "N/A"
            );
            
            int idConsultorio2 = consultorioDAO.insertar(consultorioProcedimiento);
            JOptionPane.showMessageDialog(null, 
                "✅ Consultorio de Procedimiento creado con ID: " + idConsultorio2);
            
            // 4. Buscar el primer consultorio
            Consultorio consultorioRecuperado = consultorioDAO.buscarPorId(idConsultorio1);
            
            if (consultorioRecuperado != null) {
                consultorioRecuperado.getInfoConsultorio();
            }
            
            // 5. Listar todos los consultorios activos
            List<Consultorio> activos = consultorioDAO.listarActivos();
            
            StringBuilder info = new StringBuilder("=== CONSULTORIOS ACTIVOS ===\n");
            for (Consultorio c : activos) {
                info.append("ID: ").append(c.getId_Consultorio())
                    .append(" - Tipo: ").append(c.getTipoDeConsultorio())
                    .append(" - Ext: ").append(c.getExtensionTelefono())
                    .append("\n");
            }
            
            JOptionPane.showMessageDialog(null, info.toString());
            
            // 6. Listar solo los de revisión
            List<Consultorio> revisiones = consultorioDAO.listarPorTipo("revision");
            
            JOptionPane.showMessageDialog(null, 
                "✅ Consultorios de Revisión encontrados: " + revisiones.size());
            
            JOptionPane.showMessageDialog(null, "✅ Todas las pruebas completadas!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                "❌ Error: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null && !conexion.isClosed()) {
                    conexion.close();
                    System.out.println("Conexión cerrada");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}