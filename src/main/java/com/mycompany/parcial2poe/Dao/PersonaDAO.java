package com.mycompany.parcial2poe.Dao;

/*
*   Santiago Ruiz Gallego.
*   Juan Camilo Garcia Durango.
*   Isaac Antillano Cruiz.
*   Andres David Gaitan.
*   Gabriela Lourdes Gomez.
*/

import com.mycompany.parcial2poe.Persona;
import java.sql.*;
import java.time.LocalDate;

public class PersonaDAO {
    private Connection conexion;
    
    // Constructor recibe la conexión
    public PersonaDAO(Connection conexion) {
        this.conexion = conexion;
    }
    
    /**
     * Inserta una persona en la BD y retorna el ID generado
     * @param persona Objeto Persona sin id_persona
     * @return id_persona generado por AUTO_INCREMENT
     */
    public int insertar(Persona persona) throws SQLException {
        String sql = "INSERT INTO PERSONA (tipoDeDocumento, numeroDeDocumento, " +
                    "nombreCompleto, fechaDeNacimiento, ciudadDeResidencia, " +
                    "paisDeResidencia, ocupacion, direccion, telefonoFijo, celular) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql, 
            Statement.RETURN_GENERATED_KEYS)) {
            
            ps.setString(1, persona.getTipoDeDocumento());
            ps.setLong(2, persona.getNumeroDeDocumento());
            ps.setString(3, persona.getNombreCompleto());
            ps.setDate(4, Date.valueOf(persona.getFechaDeNacimiento()));
            ps.setString(5, persona.getCiudadDeResidencia());
            ps.setString(6, persona.getPaisDeResidencia());
            ps.setString(7, persona.getOcupacion());
            ps.setString(8, persona.getDireccion());
            ps.setLong(9, persona.getTelefonoFijo());
            ps.setLong(10, persona.getCelular());
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                // Recuperar el ID generado
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idGenerado = rs.getInt(1);
                        persona.setId_Persona(idGenerado); // Asignar al objeto
                        return idGenerado;
                    }
                }
            }
            throw new SQLException("No se pudo insertar la persona");
        }
    }
    
    /**
     * Busca una persona por su ID
     */
    public Persona buscarPorId(int id_persona) throws SQLException {
        String sql = "SELECT * FROM PERSONA WHERE id_persona = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id_persona);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearPersona(rs);
                }
            }
        }
        return null;
    }
    
    /**
     * Actualiza los datos de una persona existente
     */
    public boolean actualizar(Persona persona) throws SQLException {
        String sql = "UPDATE PERSONA SET tipoDeDocumento=?, numeroDeDocumento=?, " +
                    "nombreCompleto=?, fechaDeNacimiento=?, ciudadDeResidencia=?, " +
                    "paisDeResidencia=?, ocupacion=?, direccion=?, " +
                    "telefonoFijo=?, celular=? WHERE id_persona=?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, persona.getTipoDeDocumento());
            ps.setLong(2, persona.getNumeroDeDocumento());
            ps.setString(3, persona.getNombreCompleto());
            ps.setDate(4, Date.valueOf(persona.getFechaDeNacimiento()));
            ps.setString(5, persona.getCiudadDeResidencia());
            ps.setString(6, persona.getPaisDeResidencia());
            ps.setString(7, persona.getOcupacion());
            ps.setString(8, persona.getDireccion());
            ps.setLong(9, persona.getTelefonoFijo());
            ps.setLong(10, persona.getCelular());
            ps.setInt(11, persona.getId_Persona());
            
            return ps.executeUpdate() > 0;
        }
    }
    
    /**
     * Elimina una persona por su ID
     */
    public boolean eliminar(int id_persona) throws SQLException {
        String sql = "DELETE FROM PERSONA WHERE id_persona = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id_persona);
            return ps.executeUpdate() > 0;
        }
    }
    
    /**
     * Mapea un ResultSet a un objeto Persona
     */
    protected Persona mapearPersona(ResultSet rs) throws SQLException {
        return new Persona(
            rs.getInt("id_persona"),
            rs.getString("tipoDeDocumento"),
            rs.getLong("numeroDeDocumento"),
            rs.getString("nombreCompleto"),
            rs.getDate("fechaDeNacimiento").toLocalDate(),
            rs.getString("ciudadDeResidencia"),
            rs.getString("paisDeResidencia"),
            rs.getString("ocupacion"),
            rs.getString("direccion"),
            rs.getLong("telefonoFijo"),
            rs.getLong("celular")
        );
    }
}