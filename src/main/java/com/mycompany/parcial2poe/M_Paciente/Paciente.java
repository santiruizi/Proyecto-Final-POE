/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial2poe.M_Paciente;

/**
 *
 * @author ruizg
 */

import com.mycompany.parcial2poe.Persona;
import java.time.LocalDate;

public class Paciente extends Persona{
    private String ocupacion;
    private Integer celular;
    private String EPS;
    private String regimenContributivo;
    
    public Paciente(String tipoDeDocumento, Integer numeroDeDocumento, String nombreCompleto, LocalDate fechaDeNacimiento, String ciudadDeResidencia, String paisDeResidencia, String direccion, Integer telefonoFijo, String ocupacion, Integer celular, String EPS, String regimenContributivo){
        super(tipoDeDocumento, numeroDeDocumento, nombreCompleto, fechaDeNacimiento, ciudadDeResidencia, paisDeResidencia, direccion, telefonoFijo);
        this.ocupacion = ocupacion;
        this.celular = celular;
        this.EPS = EPS;
        this.regimenContributivo = regimenContributivo;
    }

    // Ocupación.
    
    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    // Celular.
    
    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }
    
    // EPS.

    public String getEPS() {
        return EPS;
    }

    public void setEPS(String EPS) {
        this.EPS = EPS;
    }

    // Regimen Contributivo
    public String getRegimenContributivo() {
        return regimenContributivo;
    }

    public void setRegimenContributivo(String regimenContributivo) {
        this.regimenContributivo = regimenContributivo;
    }
    
    
}
