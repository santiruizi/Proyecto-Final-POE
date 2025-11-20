/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial2poe;

/**
 * Santiago Ruiz Gallego.
 * Juan Camilo Garcia Durango.
 * Isaac Antillano Cruy.
 * Andres David Gaitan.
 * Gabriela Lourdes Gomez.
 */

import java.time.LocalDate;
import javax.swing.*;

public class Persona {
    private String tipoDeDocumento;
    private Integer numeroDeDocumento;
    private String nombreCompleto;
    private LocalDate fechaDeNacimiento;
    private String direccion;
    private String ciudadDeResidencia;
    private String paisDeResidencia;
    private Integer telefonoFijo;

    // Constructor
    
    public Persona(String tipoDeDocumento, Integer numeroDeDocumento, String nombreCompleto, LocalDate fechaDeNacimiento, String ciudadDeResidencia, String paisDeResidencia, String direccion, Integer telefonoFijo) {
        this.tipoDeDocumento = tipoDeDocumento;
        this.numeroDeDocumento = numeroDeDocumento;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.ciudadDeResidencia = ciudadDeResidencia;
        this.paisDeResidencia = paisDeResidencia;
        this.telefonoFijo = telefonoFijo;
    }

    // Tipo de documento
    
    public String getTipoDeDocumento() {
        return tipoDeDocumento;
    }

    public void setTipoDeDocumento(String tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }

    // Numero de documento
    
    public Integer getNumeroDeDocumento() {
        return numeroDeDocumento;
    }

    public void setNumeroDeDocumento(Integer numeroDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
    }

    // Nombre completo
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    // Direccion
    
    public String getDireccion(){
        return direccion;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    // Fecha de nacimiento
    
    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    // Ciudad de residencia
    
    public String getCiudadDeResidencia() {
        return ciudadDeResidencia;
    }

    public void setCiudadDeResidencia(String ciudadDeResidencia) {
        this.ciudadDeResidencia = ciudadDeResidencia;
    }
    
    // Pais de residencia
    
    public String getPaisDeResidencia(){
        return paisDeResidencia;
    }
    
    public void setPaisDeResidencia(String paisDeResidencia){
        this.paisDeResidencia = paisDeResidencia;
    }
    
    // Telefono fijo
    
    public Integer getTelefonoFijo(){
        return telefonoFijo;
    }
    
    public void setTelefonoFijo(Integer telefonoFijo){
        this.telefonoFijo = telefonoFijo;
    }
    public void getInfo(){
        JOptionPane.showMessageDialog(null,"\n"+
                                            "Tipo de documento: "+tipoDeDocumento+"\n"+
                                            "Numero de documento: "+numeroDeDocumento+"\n"+
                                            "Nombre completo: "+nombreCompleto+"\n"+
                                            "Fecha de nacimiento"+fechaDeNacimiento+"\n"+
                                            "Direción: "+ direccion+"\n" +
                                            "Ciudad de residencia: "+ciudadDeResidencia+"\n"+
                                            "Pais de residencia: "+paisDeResidencia+"\n"+
                                            "Telefono fijo: "+telefonoFijo);
    }
}
