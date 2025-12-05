package com.mycompany.parcial2poe.Dao;

/*
*   Santiago Ruiz Gallego.
*   Juan Camilo Garcia Durango.
*   Isaac Antillano Cruiz.
*   Andres David Gaitan.
*   Gabriela Lourdes Gomez.
*/

import com.mycompany.parcial2poe.M_Empleados.Empleado;
import java.sql.*;

public class EmpleadoDAO {
    private Connection conexion;
    private PersonaDAO personaDAO;
    
    public EmpleadoDAO(Connection conexion) {
        this.conexion = conexion;
        this.personaDAO = new PersonaDAO(conexion);
    }
    
    /**
     * Inserta un empleado completo (PERSONA + EMPLEADO)
     */
    public int insertar(Empleado empleado) throws SQLException {
        conexion.setAutoCommit(false);
        
        try {
            // 1. Insertar en PERSONA
            int id_persona = personaDAO.insertar(empleado);
            
            // 2. Insertar en EMPLEADO
            String sqlEmpleado = "INSERT INTO EMPLEADO (id_persona, cargo) " +
                                "VALUES (?, ?)";
            
            int id_empleado;
            try (PreparedStatement ps = conexion.prepareStatement(sqlEmpleado, 
                Statement.RETURN_GENERATED_KEYS)) {
                
                ps.setInt(1, id_persona);
                ps.setString(2, empleado.getCargo());
                
                int filasAfectadas = ps.executeUpdate();
                
                if (filasAfectadas > 0) {
                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        if (rs.next()) {
                            id_empleado = rs.getInt(1);
                            empleado.setId_Empleado(id_empleado);
                            
                            conexion.commit();
                            return id_empleado;
                        }
                    }
                }
                throw new SQLException("No se pudo insertar el empleado");
            }
            
        } catch (SQLException e) {
            conexion.rollback();
            throw e;
        } finally {
            conexion.setAutoCommit(true);
        }
    }
    
    /**
     * Busca un empleado por su id_empleado
     */
    public Empleado buscarPorId(int id_empleado) throws SQLException {
        String sql = "SELECT p.*, e.id_empleado, e.cargo " +
                    "FROM PERSONA p " +
                    "INNER JOIN EMPLEADO e ON p.id_persona = e.id_persona " +
                    "WHERE e.id_empleado = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id_empleado);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearEmpleado(rs);
                }
            }
        }
        return null;
    }
    
    /**
     * Busca un empleado por número de documento
     */
    public Empleado buscarPorDocumento(Integer numeroDocumento) throws SQLException {
        String sql = "SELECT p.*, e.id_empleado, e.cargo " +
                    "FROM PERSONA p " +
                    "INNER JOIN EMPLEADO e ON p.id_persona = e.id_persona " +
                    "WHERE p.numeroDeDocumento = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, numeroDocumento);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearEmpleado(rs);
                }
            }
        }
        return null;
    }
    
    /**
     * Actualiza los datos de un empleado
     */
    public boolean actualizar(Empleado empleado) throws SQLException {
        conexion.setAutoCommit(false);
        
        try {
            // 1. Actualizar PERSONA
            boolean personaActualizada = personaDAO.actualizar(empleado);
            
            // 2. Actualizar EMPLEADO
            String sqlEmpleado = "UPDATE EMPLEADO SET cargo=? " +
                                "WHERE id_empleado=?";
            
            try (PreparedStatement ps = conexion.prepareStatement(sqlEmpleado)) {
                ps.setString(1, empleado.getCargo());
                ps.setInt(2, empleado.getId_Empleado());
                
                boolean empleadoActualizado = ps.executeUpdate() > 0;
                
                if (personaActualizada && empleadoActualizado) {
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
     * Elimina un empleado
     */
    public boolean eliminar(int id_empleado) throws SQLException {
        String sqlGetPersona = "SELECT id_persona FROM EMPLEADO WHERE id_empleado = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sqlGetPersona)) {
            ps.setInt(1, id_empleado);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id_persona = rs.getInt("id_persona");
                    return personaDAO.eliminar(id_persona);
                }
            }
        }
        return false;
    }
    
    /**
     * Mapea un ResultSet a un objeto Empleado
     */
    private Empleado mapearEmpleado(ResultSet rs) throws SQLException {
        return new Empleado(
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
            rs.getLong("celular"),
            rs.getString("cargo"),
            rs.getInt("id_empleado")
        );
    }
}