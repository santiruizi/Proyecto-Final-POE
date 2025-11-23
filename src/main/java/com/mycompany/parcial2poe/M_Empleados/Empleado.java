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
    private Integer idEmpleado;
    
    // Constructor ademas se hereda los atributos de la clase madre.
    // Esta la uso para capturar los datos antes de usar Dao.
    public Empleado(String tipoDeDocumento, Integer numeroDeDocumento, String nombreCompleto, LocalDate fechaDeNacimiento, String ciudadDeResidencia, String paisDeResidencia, String ocupacion,String direccion, Integer telefonoFijo, Integer celular, String cargo){
        // El super: es el metodo en el cual se organiza los datos heredados dentro del constructor
        super(tipoDeDocumento, numeroDeDocumento, nombreCompleto, fechaDeNacimiento, ciudadDeResidencia, paisDeResidencia, ocupacion, direccion, celular, telefonoFijo);
        this.cargo = cargo;
    }

    // Este constructor ya va con Dao
    public Empleado(String tipoDeDocumento, Integer numeroDeDocumento, String nombreCompleto, LocalDate fechaDeNacimiento, String ciudadDeResidencia, String paisDeResidencia, String ocupacion,String direccion, Integer telefonoFijo, Integer celular, String cargo, int idEmpleado){
        super(tipoDeDocumento, numeroDeDocumento, nombreCompleto, fechaDeNacimiento, ciudadDeResidencia, paisDeResidencia, ocupacion, direccion, celular, telefonoFijo);
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
    }
    
    // Cargo
    
    public String getCargo(){
        return cargo;
    }
    
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
    // idEmpleado
    
    public Integer getIdEmpleado(){
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado){
        this.idEmpleado = idEmpleado;
    }

    @Override
    public void getInfo(){
        JOptionPane.showMessageDialog(null, "\n"+
                                            "ID empleado: "+ (idEmpleado != null ? idEmpleado : "No hay existencia de tal registro." )+"\n"+
                                            "Cargo: "+cargo);
    }
}
