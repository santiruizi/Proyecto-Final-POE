package com.mycompany.parcial2poe.Dao;

/*
*   Santiago Ruiz Gallego.
*   Juan Camilo Garcia Durango.
*   Isaac Antillano Cruiz.
*   Andres David Gaitan.
*   Gabriela Lourdes Gomez.
*/

import com.mycompany.parcial2poe.M_Citas.Citas;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CitasDAO {
    private Connection conexion;
    
    public CitasDAO(Connection conexion) {
        this.conexion = conexion;
    }
    
    /**
     * Inserta una cita en la BD
     */
    public int insertar(Citas cita) throws SQLException {
        String sql = "INSERT INTO CITAS (id_paciente, id_consultorio, fechaCita, " +
                    "horaCita, tipoDeConsulta, estadoCita, nivelDeUrgencia) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql, 
            Statement.RETURN_GENERATED_KEYS)) {
            
            ps.setInt(1, cita.getId_Paciente());
            ps.setInt(2, cita.getId_Consultorio());
            ps.setDate(3, Date.valueOf(cita.getFechaCita()));
            ps.setTime(4, Time.valueOf(cita.getHoraCita()));
            ps.setString(5, cita.getTipoDeConsulta());
            ps.setString(6, cita.getEstadoCita());
            ps.setString(7, cita.getNivelDeUrgencia());
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idGenerado = rs.getInt(1);
                        cita.setId_Cita(idGenerado);
                        return idGenerado;
                    }
                }
            }
            throw new SQLException("No se pudo insertar la cita");
        }
    }
    
    /**
     * Busca una cita por su ID
     */
    public Citas buscarPorId(int id_cita) throws SQLException {
        String sql = "SELECT * FROM CITAS WHERE id_cita = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id_cita);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearCita(rs);
                }
            }
        }
        return null;
    }
    
    /**
     * Consultar citas por documento del paciente
     */
    public List<Citas> buscarPorDocumentoPaciente(Integer numeroDocumento) throws SQLException {
        String sql = "SELECT c.* FROM CITAS c " +
                    "INNER JOIN PACIENTE pa ON c.id_paciente = pa.id_paciente " +
                    "INNER JOIN PERSONA p ON pa.id_persona = p.id_persona " +
                    "WHERE p.numeroDeDocumento = ? " +
                    "ORDER BY c.fechaCita DESC, c.horaCita DESC";
        
        List<Citas> lista = new ArrayList<>();
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, numeroDocumento);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearCita(rs));
                }
            }
        }
        return lista;
    }
    
    /**
     * Consultar citas por documento del empleado
     */
    public List<Citas> buscarPorDocumentoEmpleado(Integer numeroDocumento) throws SQLException {
        String sql = "SELECT ci.* FROM CITAS ci " +
                    "INNER JOIN CONSULTORIO co ON ci.id_consultorio = co.id_consultorio " +
                    "INNER JOIN EMPLEADO e ON co.id_empleado = e.id_empleado " +
                    "INNER JOIN PERSONA p ON e.id_persona = p.id_persona " +
                    "WHERE p.numeroDeDocumento = ? " +
                    "ORDER BY ci.fechaCita DESC, ci.horaCita DESC";
        
        List<Citas> lista = new ArrayList<>();
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, numeroDocumento);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearCita(rs));
                }
            }
        }
        return lista;
    }
    
    /**
     * Listar todos los pacientes que han realizado citas por fecha
     */
    public List<Citas> listarPorFecha(LocalDate fecha) throws SQLException {
        String sql = "SELECT * FROM CITAS WHERE fechaCita = ? " +
                    "ORDER BY horaCita ASC";
        
        List<Citas> lista = new ArrayList<>();
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(fecha));
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearCita(rs));
                }
            }
        }
        return lista;
    }
    
    /**
     * Actualizar fecha, hora y estado de una cita
     */
    public boolean actualizar(Citas cita) throws SQLException {
        String sql = "UPDATE CITAS SET fechaCita=?, horaCita=?, estadoCita=? " +
                    "WHERE id_cita=?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(cita.getFechaCita()));
            ps.setTime(2, Time.valueOf(cita.getHoraCita()));
            ps.setString(3, cita.getEstadoCita());
            ps.setInt(4, cita.getId_Cita());
            
            return ps.executeUpdate() > 0;
        }
    }
    
    /**
     * Elimina una cita
     */
    public boolean eliminar(int id_cita) throws SQLException {
        String sql = "DELETE FROM CITAS WHERE id_cita = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id_cita);
            return ps.executeUpdate() > 0;
        }
    }
    
    /**
     * Mapea un ResultSet a un objeto Citas
     */
    private Citas mapearCita(ResultSet rs) throws SQLException {
        return new Citas(
            rs.getInt("id_cita"),
            rs.getInt("id_paciente"),
            rs.getInt("id_consultorio"),
            rs.getDate("fechaCita").toLocalDate(),
            rs.getTime("horaCita").toLocalTime(),
            rs.getString("tipoDeConsulta"),
            rs.getString("estadoCita"),
            rs.getString("nivelDeUrgencia")
        );
    }
}