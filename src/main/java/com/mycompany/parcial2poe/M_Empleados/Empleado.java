/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial2poe.M_Empleados;

/**
 * Santiago Ruiz Gallego.
 * Juan Camilo Garcia Durango.
 * Isaac Antillano Cruy.
 * Andres David Gaitan.
 * Gabriela Lourdes Gomez.
 */

import com.mycompany.parcial2poe.Persona;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Empleado extends Persona{
    private String cargo;
    private Integer celular;
    
    // Constructor ademas se hereda los atributos de la clase madre.
    public Empleado(String tipoDeDocumento, Integer numeroDeDocumento, String nombreCompleto, LocalDate fechaDeNacimiento, String direccion, String ciudadDeResidencia, String paisDeResidencia, String cargo, Integer celular, Integer telefonoFijo){
        // El super: es el metodo en el cual se organiza los datos heredados dentro del constructor
        super(tipoDeDocumento, numeroDeDocumento, nombreCompleto, fechaDeNacimiento, ciudadDeResidencia, paisDeResidencia, direccion, telefonoFijo);
        this.cargo = cargo;
        this.celular = celular;
    }
    
    // Cargo
    
    public String getCargo(){
        return cargo;
    }
    
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
    // Celular

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }
    
    @Override
    public void getInfo(){
        JOptionPane.showMessageDialog(null, "\n"+
                                            "Cargo: "+cargo+"\n"+
                                            "Celular: "+celular);
    }
}
