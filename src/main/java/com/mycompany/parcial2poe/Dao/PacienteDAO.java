/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial2poe.Dao;

/**
 *  Santiago Ruiz Gallego.
 *  Juan Camilo Garcia Durango.
 *  Isaac Antillano Cruiz.
 *  Andres David Gaitan.
 *  Gabriela Lourdes Gomez.
 */

import com.mycompany.parcial2poe.Persona;
import com.mycompany.parcial2poe.M_Paciente.Paciente;
import java.sql.*;

public class PacienteDAO {
    private Connection conexion;
    private PersonaDAO personaDAO;
    
    public PacienteDAO(Connection conexion) {
        this.conexion = conexion;
        this.personaDAO = new PersonaDAO(conexion);
    }
    
    /**
     * Inserta un paciente completo (PERSONA + PACIENTE)
     * Usa transacciones para garantizar consistencia
     */
    public int insertar(Paciente paciente) throws SQLException {
        // Desactivar auto-commit para manejar transacción manualmente
        conexion.setAutoCommit(false);
        
        try {
            // 1. Insertar en PERSONA primero (hereda de Persona)
            int id_persona = personaDAO.insertar(paciente);
            
            // 2. Insertar en PACIENTE usando el id_persona generado
            String sqlPaciente = "INSERT INTO PACIENTE (id_persona, eps, " +
                                "regimenContributivo, estado) VALUES (?, ?, ?, ?)";
            
            int id_paciente;
            try (PreparedStatement ps = conexion.prepareStatement(sqlPaciente, 
                Statement.RETURN_GENERATED_KEYS)) {
                
                ps.setInt(1, id_persona);
                ps.setString(2, paciente.getEps());
                ps.setString(3, paciente.getRegimenContributivo());
                ps.setBoolean(4, paciente.isEstado());
                
                int filasAfectadas = ps.executeUpdate();
                
                if (filasAfectadas > 0) {
                    // Recuperar el id_paciente generado
                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        if (rs.next()) {
                            id_paciente = rs.getInt(1);
                            paciente.setId_Paciente(id_paciente);
                            
                            // ✅ TODO salió bien, confirmar transacción
                            conexion.commit();
                            return id_paciente;
                        }
                    }
                }
                throw new SQLException("No se pudo insertar el paciente");
            }
            
        } catch (SQLException e) {
            // ❌ Hubo error, revertir TODA la transacción
            conexion.rollback();
            throw e;
        } finally {
            // Restaurar auto-commit
            conexion.setAutoCommit(true);
        }
    }
    
    /**
     * Busca un paciente por su id_paciente
     * Hace JOIN entre PERSONA y PACIENTE
     */
    public Paciente buscarPorId(int id_paciente) throws SQLException {
        String sql = "SELECT p.*, pa.id_paciente, pa.eps, " +
                    "pa.regimenContributivo, pa.estado " +
                    "FROM PERSONA p " +
                    "INNER JOIN PACIENTE pa ON p.id_persona = pa.id_persona " +
                    "WHERE pa.id_paciente = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id_paciente);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearPaciente(rs);
                }
            }
        }
        return null;
    }
    
    /**
     * Busca un paciente por número de documento
     */
    public Paciente buscarPorDocumento(Integer numeroDocumento) throws SQLException {
        String sql = "SELECT p.*, pa.id_paciente, pa.eps, " +
                    "pa.regimenContributivo, pa.estado " +
                    "FROM PERSONA p " +
                    "INNER JOIN PACIENTE pa ON p.id_persona = pa.id_persona " +
                    "WHERE p.numeroDeDocumento = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, numeroDocumento);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearPaciente(rs);
                }
            }
        }
        return null;
    }
    
    /**
     * Actualiza los datos de un paciente
     * Actualiza ambas tablas (PERSONA y PACIENTE)
     */
    public boolean actualizar(Paciente paciente) throws SQLException {
        conexion.setAutoCommit(false);
        
        try {
            // 1. Actualizar PERSONA
            boolean personaActualizada = personaDAO.actualizar(paciente);
            
            // 2. Actualizar PACIENTE
            String sqlPaciente = "UPDATE PACIENTE SET eps=?, " +
                                "regimenContributivo=?, estado=? " +
                                "WHERE id_paciente=?";
            
            try (PreparedStatement ps = conexion.prepareStatement(sqlPaciente)) {
                ps.setString(1, paciente.getEps());
                ps.setString(2, paciente.getRegimenContributivo());
                ps.setBoolean(3, paciente.isEstado());
                ps.setInt(4, paciente.getId_Paciente());
                
                boolean pacienteActualizado = ps.executeUpdate() > 0;
                
                if (personaActualizada && pacienteActualizado) {
                    conexion.commit();
                    return true;
                } else {
                    conexion.rollback();
                    return false;
                }
            }
            
        } catch (SQLException e) {
            conexion.rollback();
            throw e;
        } finally {
            conexion.setAutoCommit(true);
        }
    }
    
    /**
     * Elimina un paciente (automáticamente elimina de PERSONA por CASCADE)
     */
    public boolean eliminar(int id_paciente) throws SQLException {
        // Primero obtener el id_persona
        String sqlGetPersona = "SELECT id_persona FROM PACIENTE WHERE id_paciente = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sqlGetPersona)) {
            ps.setInt(1, id_paciente);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id_persona = rs.getInt("id_persona");
                    
                    // Eliminar de PERSONA (CASCADE eliminará de PACIENTE)
                    return personaDAO.eliminar(id_persona);
                }
            }
        }
        return false;
    }
    
    /**
     * Mapea un ResultSet a un objeto Paciente
     */
    private Paciente mapearPaciente(ResultSet rs) throws SQLException {
        return new Paciente(
            rs.getInt("id_persona"),
            rs.getString("tipoDeDocumento"),
            rs.getInt("numeroDeDocumento"),
            rs.getString("nombreCompleto"),
            rs.getDate("fechaDeNacimiento").toLocalDate(),
            rs.getString("ciudadDeResidencia"),
            rs.getString("paisDeResidencia"),
            rs.getString("ocupacion"),
            rs.getString("direccion"),
            rs.getInt("telefonoFijo"),
            rs.getInt("celular"),
            rs.getString("eps"),
            rs.getString("regimenContributivo"),
            rs.getBoolean("estado"),
            rs.getInt("id_paciente")
        );
    }
}