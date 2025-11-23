package com.mycompany.parcial2poe.M_Citas;

/*
    Santiago Ruiz Gallego.
    Juan Camilo Garcia Durango.
    Isaac Antillano Cruy.
    Andres David Gaitan.
    Gabriela Lourdes Gomez.
*/

import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.*;
import com.mycompany.parcial2poe.M_Paciente.Paciente;
import com.mycompany.parcial2poe.M_Consultorio.Consultorio;
public class Citas {

    private String idCita;
    private Paciente numeroDeDocumentoPaciente;
    private LocalDate fechaCita;
    private LocalTime horaCita;
    private String tipoDeConsulta;
    private String estadoCita;
    private Consultorio idConsultorio;
    private String nivelDeUrgencia;

    // Constructor

    public Citas(String idCita, Paciente numeroDeDocumentoPaciente, LocalDate fechaCita, LocalTime horaCita, String tipoDeConsulta, String estadoCita, Consultorio idConsultorio, String nivelDeUrgencia){
        this.idCita = idCita;
        this.numeroDeDocumentoPaciente = numeroDeDocumentoPaciente;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.tipoDeConsulta = tipoDeConsulta;
        this.estadoCita = estadoCita;
        this.idConsultorio = idConsultorio;
        this.nivelDeUrgencia = nivelDeUrgencia;
    }

    // id de la cita

    public String getIdCita(){
        return idCita;
    }

    public void setIdCita(String idCita){
        this.idCita = idCita;
    }

    // numero de documento del paciente.

    public Paciente getPaciente(){
        return numeroDeDocumentoPaciente;
    }

    public void getNumeroDeDocumentoPaciente(Paciente numeroDeDocumentoPaciente){
        this.numeroDeDocumentoPaciente = numeroDeDocumentoPaciente;
    }

    // fecha Cita este se maneja por dia, mes y año.

    public LocalDate getFechaCita(){
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita){
        this.fechaCita = fechaCita;
    }

    // hora de la cita.

    public LocalTime getHoraCita(){
        return horaCita;
    }

    public void setHoraCita(LocalTime horaCita){
        this.horaCita = horaCita;
    }

    // Tipo de consulta

    public String getTipoDeConsulta(){
        return tipoDeConsulta;
    }

    public void setTipoDeConsulta(String tipoDeConsulta){
        this.tipoDeConsulta = tipoDeConsulta;
    }

    // Estado Cita

    public String getEstadoCita(){
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita){
        this.estadoCita = estadoCita;
    }

    // Id del consultorio.

    public Consultorio getIdConsultorio(){
        return  idConsultorio;
    }

    public void setIdConsultorio(Consultorio idConsultorio){
        this.idConsultorio = idConsultorio;
    }

    // Nivel de urgenica

    public String getNivelDeUrgencia(){
        return nivelDeUrgencia;
    }

    public void setNivelDeUrgencia(String nivelDeUrgencia){
        this.nivelDeUrgencia = nivelDeUrgencia;
    }

    public void mostrarInfoCita(){
        JOptionPane.showMessageDialog(null, "ID de la cita: "+idCita+"\n"+
                                                                "Numero de documento del paciente: "+numeroDeDocumentoPaciente+"\n"+
                                                                "Fecha de la cita: "+fechaCita+"\n"+
                                                                "Hora de la cita: "+horaCita+"\n"+
                                                                "Tipo de consulta: "+tipoDeConsulta+"\n"+
                                                                "Estado de la cita: "+estadoCita+"\n"+
                                                                "ID del consultorio: "+idConsultorio+"'n"+
                                                                "Nivel de urgencia: "+nivelDeUrgencia);
    }
}
