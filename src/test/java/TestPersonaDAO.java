/*
*   Santiago Ruiz Gallego.
*   Juan Camilo Garcia Durango.
*   Isaac Antillano Cruiz.
*   Andres David Gaitan.
*   Gabriela Lourdes Gomez.
*/

import com.mycompany.parcial2poe.Dao.ConexionBD;
import com.mycompany.parcial2poe.Dao.PersonaDAO;
import com.mycompany.parcial2poe.Persona;
import java.sql.Connection;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class TestPersonaDAO {
    public static void main(String[] args) {
        Connection conexion = null;
        
        try {
            // 1. Establecer conexión
            conexion = ConexionBD.getConexion();
            JOptionPane.showMessageDialog(null, "✅ Conexión exitosa a la BD");
            
            // 2. Crear instancia del DAO
            PersonaDAO personaDAO = new PersonaDAO(conexion);
            
            // 3. Crear una persona de prueba (constructor SIN id)
            Persona personaPrueba = new Persona(
                "CC",                           // tipoDeDocumento
                123456789L,                      // numeroDeDocumento
                "Juan Pérez Test",              // nombreCompleto
                LocalDate.of(1995, 3, 15),     // fechaDeNacimiento
                "Cali",                         // ciudadDeResidencia
                "Colombia",                     // paisDeResidencia
                "Estudiante",                   // ocupacion
                "Calle 10 #20-30",             // direccion
                3201234L,                        // telefonoFijo
                308761004L                    // celular
            );
            
            // 4. Insertar en la BD
            int idGenerado = personaDAO.insertar(personaPrueba);
            JOptionPane.showMessageDialog(null, 
                "✅ Persona insertada con ID: " + idGenerado);
            
            // 5. Buscar la persona recién insertada
            Persona personaRecuperada = personaDAO.buscarPorId(idGenerado);
            
            if (personaRecuperada != null) {
                String info = "=== PERSONA RECUPERADA DE BD ===\n" +
                            "ID: " + personaRecuperada.getId_Persona() + "\n" +
                            "Nombre: " + personaRecuperada.getNombreCompleto() + "\n" +
                            "Documento: " + personaRecuperada.getNumeroDeDocumento() + "\n" +
                            "Ciudad: " + personaRecuperada.getCiudadDeResidencia() + "\n" +
                            "Celular: " + personaRecuperada.getCelular();
                
                JOptionPane.showMessageDialog(null, info);
                
                // También puedes usar el método getInfo() de Persona
                personaRecuperada.getInfo();
            }
            
            // 6. Probar actualización (OPCIONAL)
            personaRecuperada.setNombreCompleto("Juan Pérez Actualizado");
            boolean actualizado = personaDAO.actualizar(personaRecuperada);
            
            if (actualizado) {
                JOptionPane.showMessageDialog(null, 
                    "✅ Persona actualizada correctamente");
            }
            
            JOptionPane.showMessageDialog(null, 
                "✅ Todas las pruebas completadas exitosamente!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                "❌ Error: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            // Cerrar conexión
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
