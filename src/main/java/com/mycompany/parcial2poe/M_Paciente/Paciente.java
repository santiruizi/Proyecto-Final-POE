/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial2poe.M_Paciente;

/**
 *  Sanitago Ruiz Gallego.
 *  Juan Camilo Garcia Durango.
 *  Isaac Antillano Cruy.
 *  Andres David Gaitan.
 *  Gabriela Lourdes Gomez.
 */

import com.mycompany.parcial2poe.Persona;
import java.time.LocalDate;
import javax.swing.*;

public class Paciente extends Persona{
    private String EPS;
    private String regimenContributivo;
    private boolean estado;
    
    public Paciente(String tipoDeDocumento, Integer numeroDeDocumento, String nombreCompleto, LocalDate fechaDeNacimiento, String ciudadDeResidencia, String paisDeResidencia, String ocupacion,String direccion, Integer telefonoFijo, Integer celular, String EPS, String regimenContributivo, boolean estado){
        super(tipoDeDocumento, numeroDeDocumento, nombreCompleto, fechaDeNacimiento, ciudadDeResidencia, paisDeResidencia, ocupacion, direccion, telefonoFijo, celular);
        this.EPS = EPS;
        this.regimenContributivo = regimenContributivo;
        this.estado = estado;
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
    
    // Estado

    public boolean getEstado(){
        return estado;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    @Override
    public void getInfo(){
        JOptionPane.showMessageDialog(null, "Nombre de eps que pertenece: "+EPS+"\n"+
                                            "Regimen Contributivo: "+regimenContributivo+"\n"+
                                            "Estado: "+estado); 
    }
}
