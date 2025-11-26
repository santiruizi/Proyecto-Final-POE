package com.mycompany.parcial2poe.Dao;

/*
*   Santiago Ruiz Gallego.
*   Juan Camilo Garcia Durango.
*   Isaac Antillano Cruiz.
*   Andres David Gaitan.
*   Gabriela Lourdes Gomez.
*/

import com.mycompany.parcial2poe.M_Consultorio.Consultorio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultorioDAO {
    private Connection conexion;
    
    public ConsultorioDAO(Connection conexion) {
        this.conexion = conexion;
    }
    
    /**
     * Inserta un consultorio en la BD
     */
    public int insertar(Consultorio consultorio) throws SQLException {
        String sql = "INSERT INTO CONSULTORIO (tipoDeConsultorio, id_empleado, " +
                    "extensionTelefono, estado, causa) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql, 
            Statement.RETURN_GENERATED_KEYS)) {
            
            ps.setString(1, consultorio.getTipoDeConsultorio());
            ps.setInt(2, consultorio.getId_Empleado());
            ps.setInt(3, consultorio.getExtensionTelefono());
            ps.setBoolean(4, consultorio.isEstado());
            ps.setString(5, consultorio.getCausa());
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idGenerado = rs.getInt(1);
                        consultorio.setId_Consultorio(idGenerado);
                        return idGenerado;
                    }
                }
            }
            throw new SQLException("No se pudo insertar el consultorio");
        }
    }
    
    /**
     * Busca un consultorio por su ID
     */
    public Consultorio buscarPorId(int id_consultorio) throws SQLException {
        String sql = "SELECT * FROM CONSULTORIO WHERE id_consultorio = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id_consultorio);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearConsultorio(rs);
                }
            }
        }
        return null;
    }
    
    /**
     * Lista todos los consultorios activos
     */
    public List<Consultorio> listarActivos() throws SQLException {
        String sql = "SELECT * FROM CONSULTORIO WHERE estado = true";
        List<Consultorio> lista = new ArrayList<>();
        
        try (PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                lista.add(mapearConsultorio(rs));
            }
        }
        return lista;
    }
    
    /**
     * Lista consultorios por tipo (revision o procedimiento)
     */
    public List<Consultorio> listarPorTipo(String tipo) throws SQLException {
        String sql = "SELECT * FROM CONSULTORIO WHERE tipoDeConsultorio = ? AND estado = true";
        List<Consultorio> lista = new ArrayList<>();
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, tipo);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearConsultorio(rs));
                }
            }
        }
        return lista;
    }
    
    /**
     * Actualiza un consultorio
     */
    public boolean actualizar(Consultorio consultorio) throws SQLException {
        String sql = "UPDATE CONSULTORIO SET tipoDeConsultorio=?, id_empleado=?, " +
                    "extensionTelefono=?, estado=?, causa=? " +
                    "WHERE id_consultorio=?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, consultorio.getTipoDeConsultorio());
            ps.setInt(2, consultorio.getId_Empleado());
            ps.setInt(3, consultorio.getExtensionTelefono());
            ps.setBoolean(4, consultorio.isEstado());
            ps.setString(5, consultorio.getCausa());
            ps.setInt(6, consultorio.getId_Consultorio());
            
            return ps.executeUpdate() > 0;
        }
    }
    
    /**
     * Elimina un consultorio (o lo desactiva si tiene citas asociadas)
     */
    public boolean eliminar(int id_consultorio) throws SQLException {
        String sql = "DELETE FROM CONSULTORIO WHERE id_consultorio = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id_consultorio);
            return ps.executeUpdate() > 0;
        }
    }
    
    /**
     * Mapea un ResultSet a un objeto Consultorio
     */
    private Consultorio mapearConsultorio(ResultSet rs) throws SQLException {
        return new Consultorio(
            rs.getInt("id_consultorio"),
            rs.getString("tipoDeConsultorio"),
            rs.getInt("id_empleado"),
            rs.getInt("extensionTelefono"),
            rs.getBoolean("estado"),
            rs.getString("causa")
        );
    }
}