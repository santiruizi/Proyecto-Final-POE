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
    private int id_empleado;
    private String cargo;
    
    // Constructor ademas se hereda los atributos de la clase madre.
    // Esta la uso para capturar los datos antes de usar el esquema de la .
    public Empleado(String tipoDeDocumento, Long numeroDeDocumento, String nombreCompleto, LocalDate fechaDeNacimiento, String ciudadDeResidencia, String paisDeResidencia, String ocupacion,String direccion, Long telefonoFijo, long celular, String cargo){
        // El super: es el metodo en el cual se organiza los datos heredados dentro del constructor
        super(tipoDeDocumento, numeroDeDocumento, nombreCompleto, fechaDeNacimiento, ciudadDeResidencia, paisDeResidencia, ocupacion, direccion, celular, telefonoFijo);
        this.cargo = cargo;
    }

    public Empleado(int id_persona,String tipoDeDocumento, Long numeroDeDocumento, String nombreCompleto, LocalDate fechaDeNacimiento, String ciudadDeResidencia, String paisDeResidencia, String ocupacion,String direccion, Long telefonoFijo, Long celular, String cargo, int id_empleado){
        // El super: es el metodo en el cual se organiza los datos heredados dentro del constructor
        super(id_persona,tipoDeDocumento, numeroDeDocumento, nombreCompleto, fechaDeNacimiento, ciudadDeResidencia, paisDeResidencia, ocupacion, direccion, celular, telefonoFijo);
        this.cargo = cargo;
        this.id_empleado = id_empleado;
    }

    // id_empleado

    public int getId_Empleado(){
        return id_empleado;
    }

    public void setId_Empleado(int id_empleado){
        this.id_empleado = id_empleado;
    }
    
    // Cargo
    
    public String getCargo(){
        return cargo;
    }
    
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
    @Override
    public void getInfo(){
        // Heredo los atributos de la clase base que es "Persona"
        super.getInfo();
        JOptionPane.showMessageDialog(null, 
            "━━━━━━ Información Laboral ━━━━━━\n" +
            "ID Empleado: " + (id_empleado <= 0   ? id_empleado : "Pendiente de asignar") + "\n" +
            "Cargo: " + cargo);
    }
}
