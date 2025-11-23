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

import java.time.LocalDate;
import javax.swing.*;

public class IngresoEmpleados {
    public int ingreso_E(Empleado[] empleados, int contadorEmpleados){
        
        String tipoDeDocumento, nombreCompleto, strFechaDeNacimiento, ciudadDeResidencia, cargo, paisDeResidencia, direccion;
        Integer numeroDeDocumento, celular, telefonoFijo;
        
        LocalDate fechaDeNacimiento;
        
        tipoDeDocumento = JOptionPane.showInputDialog("Digite el tipo de documento(TI, CC, CE): ");
        while(tipoDeDocumento.isEmpty() || !tipoDeDocumento.equalsIgnoreCase("ti") && !tipoDeDocumento.equalsIgnoreCase("cc") && !tipoDeDocumento.equalsIgnoreCase("ce")){
            JOptionPane.showMessageDialog(null, "El tipo de documento es invalido.");
            tipoDeDocumento = JOptionPane.showInputDialog("Digite el tipo de documento(TI, CC, CE): ");
        }
        
        numeroDeDocumento = Integer.valueOf(JOptionPane.showInputDialog("Digite el numero de documento: "));
        while(numeroDeDocumento <= 0 || numeroDeDocumento > 9999999999L){
            JOptionPane.showMessageDialog(null, "El numero de documento es invalido.");
            numeroDeDocumento = Integer.valueOf(JOptionPane.showInputDialog("Digite el numero de documento: "));
        }
        
        nombreCompleto = JOptionPane.showInputDialog("Digite el nombre completo: ");
        while(nombreCompleto.isEmpty()){
            JOptionPane.showMessageDialog(null, "El nombre es invalido");
            nombreCompleto = JOptionPane.showInputDialog("Digite el nombre completo: ");
        }
        
        direccion = JOptionPane.showInputDialog("Digite la dirección: ");
        while(direccion.isEmpty()){
            JOptionPane.showMessageDialog(null, "La dirección digitada es invalida.");
            direccion = JOptionPane.showInputDialog("Digite la dirección: ");
        }
        
        strFechaDeNacimiento = JOptionPane.showInputDialog("Digite la fecha de nacimiento(AA-MM-DD): ");
        while(strFechaDeNacimiento.isEmpty() || !strFechaDeNacimiento.matches("\\d{4}-\\d{2}-\\d{2}")){
            JOptionPane.showMessageDialog(null, "Formato inválido, debe de ser (AAAA-MM-DD)");
            strFechaDeNacimiento = JOptionPane.showInputDialog("Digite la fecha de nacimiento(AA-MM-DD): ");
        }
        fechaDeNacimiento = LocalDate.parse(strFechaDeNacimiento);
        
        ciudadDeResidencia = JOptionPane.showInputDialog("Digite su ciudad de residencia: ");
        while(ciudadDeResidencia.isEmpty()){
            JOptionPane.showMessageDialog(null, "La ciudad de residencia es invalida.");
            ciudadDeResidencia = JOptionPane.showInputDialog("Digite su ciudad de residencia: ");
        }
        
        paisDeResidencia = JOptionPane.showInputDialog("Digite su pais de residencia: ");
        while(paisDeResidencia.isEmpty()){
            JOptionPane.showMessageDialog(null, "El pais digitado es invalido.");
            paisDeResidencia = JOptionPane.showInputDialog("Digite su pais de residencia: ");
        }
        
        cargo = JOptionPane.showInputDialog("Digite su cargo actual(Enfermer@-Medic@): ");
        while(!cargo.equalsIgnoreCase("Enfermero") && !cargo.equalsIgnoreCase("Enfermera") && !cargo.equalsIgnoreCase("Medico") && !cargo.equalsIgnoreCase("Medica")){
            JOptionPane.showMessageDialog(null, "El cargo es invalido.");
            cargo = JOptionPane.showInputDialog("Digite su cargo actual(Enfermer@-Medic@): ");
        }
        
        celular = Integer.valueOf(JOptionPane.showInputDialog("Digite el numero de celular: "));
        while(celular <= 0 || celular > 9999999999L){
            JOptionPane.showMessageDialog(null, "El celular es invalido.");
            celular = Integer.valueOf(JOptionPane.showInputDialog("Digite el numero de celular: "));
        }
        
        telefonoFijo = Integer.valueOf(JOptionPane.showInputDialog("Digit el telefono fijo: "));
        while(telefonoFijo <= 0 || telefonoFijo > 9999999999L){
            JOptionPane.showMessageDialog(null, "Telefono fijo invalido.");
            telefonoFijo = Integer.valueOf(JOptionPane.showInputDialog("Digit el telefono fijo: "));
        }
        
        
        Empleado newEmpleado = new Empleado("C.C.",
        1020304050,
        "Ana María Pérez López",
        LocalDate.of(1995, 8, 15),
        "Carrera 10 # 50-25",
        "Bogotá",
        "Colombia",
        "Enfermera profesional",
        123,
        123,
        "Jefe de enfermeria");
        
        newEmpleado.setTipoDeDocumento(tipoDeDocumento);
        newEmpleado.setNumeroDeDocumento(numeroDeDocumento);
        newEmpleado.setNombreCompleto(nombreCompleto);
        newEmpleado.setDireccion(direccion);
        newEmpleado.setFechaDeNacimiento(fechaDeNacimiento);
        newEmpleado.setCiudadDeResidencia(ciudadDeResidencia);
        newEmpleado.setPaisDeResidencia(paisDeResidencia);
        newEmpleado.setCargo(cargo);
        newEmpleado.setCelular(celular);
        newEmpleado.setTelefonoFijo(telefonoFijo);
        
        empleados[contadorEmpleados] = newEmpleado;
        
        JOptionPane.showMessageDialog(null, "El registro del empleado fue un exito.");
        
        return 1 + contadorEmpleados;
    }
}
