package com.mycompany.parcial2poe.M_Consultorio;

import javax.swing.JOptionPane;

/*
 *  Santiago Ruiz Gallego.
 *  Juan Camilo Garcia Durango.
 *  Isaac Antillano Cruiz.
 *  Andres David Gaitan.
 *  Gabriela Lourdes Gomez.
*/

import com.mycompany.parcial2poe.M_Empleados.Empleado;

import javax.swing.JOptionPane;

public class Consultorio {
    private Integer id_consultorio;
    private String tipoDeConsultorio;
    private Integer id_empleado;        // ✅ Solo el ID (FK)
    private Integer extensionTelefono;
    private boolean estado;
    private String causa;

    // Constructor para INSERCIÓN (captura inicial sin IDs)
    public Consultorio(String tipoDeConsultorio, Integer id_empleado,
                    Integer extensionTelefono, boolean estado, String causa) {
        this.tipoDeConsultorio = tipoDeConsultorio;
        this.id_empleado = id_empleado;
        this.extensionTelefono = extensionTelefono;
        this.estado = estado;
        this.causa = causa;
    }

    // Constructor para CONSULTA (con id_consultorio desde BD)
    public Consultorio(Integer id_consultorio, String tipoDeConsultorio,
                    Integer id_empleado, Integer extensionTelefono,
                    boolean estado, String causa) {
        this.id_consultorio = id_consultorio;
        this.tipoDeConsultorio = tipoDeConsultorio;
        this.id_empleado = id_empleado;
        this.extensionTelefono = extensionTelefono;
        this.estado = estado;
        this.causa = causa;
    }

    // ========== GETTERS Y SETTERS ==========

    public Integer getId_Consultorio() {
        return id_consultorio;
    }

    public void setId_Consultorio(Integer id_consultorio) {
        this.id_consultorio = id_consultorio;
    }

    public String getTipoDeConsultorio() {
        return tipoDeConsultorio;
    }

    public void setTipoDeConsultorio(String tipoDeConsultorio) {
        this.tipoDeConsultorio = tipoDeConsultorio;
    }

    public Integer getId_Empleado() {  
        return id_empleado;
    }

    public void setId_Empleado(Integer id_empleado) {  
        this.id_empleado = id_empleado;
    }

    public Integer getExtensionTelefono() {
        return extensionTelefono;
    }

    public void setExtensionTelefono(Integer extensionTelefono) {
        this.extensionTelefono = extensionTelefono;
    }

    public boolean isEstado() {  
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public void getInfoConsultorio() {
        JOptionPane.showMessageDialog(null,
            "━━━━━━ Información del Consultorio ━━━━━━\n" +
            "ID: " + (id_consultorio != null ? id_consultorio : "Pendiente") + "\n" +
            "Tipo: " + tipoDeConsultorio + "\n" +
            "ID Empleado: " + id_empleado + "\n" +
            "Extensión: " + extensionTelefono + "\n" +
            "Estado: " + (estado ? "Activo" : "Inactivo") + "\n" +
            (causa != null ? "Causa: " + causa : ""));
    }
}