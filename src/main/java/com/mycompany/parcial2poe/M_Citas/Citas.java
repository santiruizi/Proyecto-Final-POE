package com.mycompany.parcial2poe.M_Citas;

/*
    Santiago Ruiz Gallego.
    Juan Camilo Garcia Durango.
    Isaac Antillano Cruy.
    Andres David Gaitan.
    Gabriela Lourdes Gomez.
*/

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Citas {
    private Integer id_cita;
    private Integer id_paciente;      
    private Integer id_consultorio;   
    private LocalDate fechaCita;
    private LocalTime horaCita;
    private String tipoDeConsulta;
    private String estadoCita;
    private String nivelDeUrgencia;

    // Constructor para INSERCIÓN (sin id_cita)
    public Citas(Integer id_paciente, Integer id_consultorio,
                LocalDate fechaCita, LocalTime horaCita,
                String tipoDeConsulta, String estadoCita,
                String nivelDeUrgencia) {
        this.id_paciente = id_paciente;
        this.id_consultorio = id_consultorio;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.tipoDeConsulta = tipoDeConsulta;
        this.estadoCita = estadoCita;
        this.nivelDeUrgencia = nivelDeUrgencia;
    }

    // Constructor para CONSULTA (con id_cita desde BD)
    public Citas(Integer id_cita, Integer id_paciente, Integer id_consultorio,
                LocalDate fechaCita, LocalTime horaCita,
                String tipoDeConsulta, String estadoCita,
                String nivelDeUrgencia) {
        this.id_cita = id_cita;
        this.id_paciente = id_paciente;
        this.id_consultorio = id_consultorio;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.tipoDeConsulta = tipoDeConsulta;
        this.estadoCita = estadoCita;
        this.nivelDeUrgencia = nivelDeUrgencia;
    }

    // ========== GETTERS Y SETTERS ==========

    public Integer getId_Cita() {
        return id_cita;
    }

    public void setId_Cita(Integer id_cita) {
        this.id_cita = id_cita;
    }

    public Integer getId_Paciente() {  
        return id_paciente;
    }

    public void setId_Paciente(Integer id_paciente) {  
        this.id_paciente = id_paciente;
    }

    public Integer getId_Consultorio() {  
        return id_consultorio;
    }

    public void setId_Consultorio(Integer id_consultorio) {  
        this.id_consultorio = id_consultorio;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public LocalTime getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(LocalTime horaCita) {
        this.horaCita = horaCita;
    }

    public String getTipoDeConsulta() {
        return tipoDeConsulta;
    }

    public void setTipoDeConsulta(String tipoDeConsulta) {
        this.tipoDeConsulta = tipoDeConsulta;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }

    public String getNivelDeUrgencia() {
        return nivelDeUrgencia;
    }

    public void setNivelDeUrgencia(String nivelDeUrgencia) {
        this.nivelDeUrgencia = nivelDeUrgencia;
    }

    public void mostrarInfoCita() {
        JOptionPane.showMessageDialog(null,
            "━━━━━━ Información de la Cita ━━━━━━\n" +
            "ID Cita: " + (id_cita != null ? id_cita : "Pendiente") + "\n" +
            "ID Paciente: " + id_paciente + "\n" +
            "ID Consultorio: " + id_consultorio + "\n" +
            "Fecha: " + fechaCita + "\n" +
            "Hora: " + horaCita + "\n" +
            "Tipo de Consulta: " + tipoDeConsulta + "\n" +
            "Estado: " + estadoCita + "\n" +
            "Urgencia: " + nivelDeUrgencia);
    }
}