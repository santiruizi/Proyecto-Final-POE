/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial2poe.M_Paciente;

/**
 * Santiago Ruiz Gallego.
 * Juan Camilo Garcia Durango.
 * Isaac Antillano Cruy.
 * Andres David Gaitan.
 * Gabriela Lourdes Gomez.
 */

import java.time.LocalDate;
import javax.swing.*;

public class IngresoPaciente {
    public int ingresoP(Paciente[] pacientes,int contadorPacientes){
        
        String tipoDeDocumento, nombreCompleto, strFechaDeNacimiento, ciudadDeResidencia, paisDeResidencia, direccion, ocupacion, EPS, regimenContributivo;
        Integer numeroDeDocumento, telefonoFijo, celular;
        LocalDate fechaDeNacimiento;
        
        tipoDeDocumento = JOptionPane.showInputDialog("Digit el tipo de documento(TI, CC, CE): ");
        while(tipoDeDocumento.isEmpty() || !tipoDeDocumento.equalsIgnoreCase("ti") && !tipoDeDocumento.equalsIgnoreCase("cc") && !tipoDeDocumento.equalsIgnoreCase("ce")){
            JOptionPane.showMessageDialog(null, "El tipo de documento es invalido.");
            tipoDeDocumento = JOptionPane.showInputDialog("Digit el tipo de documento(TI, CC, CE): ");
        }
        
        numeroDeDocumento = Integer.valueOf(JOptionPane.showInputDialog("Digite el numero de documento: "));
        while(numeroDeDocumento <= 0 || numeroDeDocumento > 9999999999L){
            JOptionPane.showMessageDialog(null, "El numero de documento es invalido.");
            numeroDeDocumento = Integer.valueOf(JOptionPane.showInputDialog("Digite el numero de documento: "));
        }
        
        nombreCompleto = JOptionPane.showInputDialog("Digite su nombre completo: ");
        while(nombreCompleto.isEmpty()){
            JOptionPane.showMessageDialog(null, "El nombre es invalido.");
            nombreCompleto = JOptionPane.showInputDialog("Digite su nombre completo: ");
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
            JOptionPane.showMessageDialog(null, "El pais de residencia es invalido.");
            paisDeResidencia = JOptionPane.showInputDialog("Digite su pais de residencia: ");
        }
        
        direccion = JOptionPane.showInputDialog("Digite su dirección: ");
        while(direccion.isEmpty()){
            JOptionPane.showMessageDialog(null, "La dirección es invalida.");
            direccion = JOptionPane.showInputDialog("Digite su dirección: ");
        }
        
        telefonoFijo = Integer.valueOf(JOptionPane.showInputDialog("Digite el telefono fijo: "));
        while(telefonoFijo <= 0 || telefonoFijo > 9999999999L){
            JOptionPane.showMessageDialog(null, "El telefono fijo es invalido.");
            telefonoFijo = Integer.valueOf(JOptionPane.showInputDialog("Digite el telefono fijo: "));
        }
        
        ocupacion = JOptionPane.showInputDialog("Digit su ocupación: ");
        while(ocupacion.isEmpty()){
            JOptionPane.showMessageDialog(null, "La ocupacion es invalida.");
            ocupacion = JOptionPane.showInputDialog("Digit su ocupación: ");
        }
        
        celular = Integer.valueOf(JOptionPane.showInputDialog("Digite su celular: "));
        while(celular <= 0 || celular > 9999999999L){
            JOptionPane.showMessageDialog(null, "Numero de celular es invalido.");
            celular = Integer.valueOf(JOptionPane.showInputDialog("Digite su celular: "));
        }
        
        EPS = JOptionPane.showInputDialog("Digite su eps: ");
        while(EPS.isEmpty()){
            JOptionPane.showMessageDialog(null, "La eps es invalida.");
            EPS = JOptionPane.showInputDialog("Digite su eps: ");
        }
        
        regimenContributivo = JOptionPane.showInputDialog("Digite su regimen contributivo(Contributivo o Subsidiado)");
        while(regimenContributivo.isEmpty() || !regimenContributivo.equalsIgnoreCase("contributivo") && !regimenContributivo.equalsIgnoreCase("subsidiado")){
            JOptionPane.showMessageDialog(null, "El regimen contributo no es valido.");
            regimenContributivo = JOptionPane.showInputDialog("Digite su regimen contributivo(Contributivo o Subsidiado)");
        }
        
        Paciente newPaciente = new Paciente("defecto", 0, "defecto", LocalDate.of(2025, 11, 5), "defecto", "defecto", "defecto", 0, "defecto", 0, "defecto", "defecto");
        
        newPaciente.setTipoDeDocumento(tipoDeDocumento);
        newPaciente.setNumeroDeDocumento(numeroDeDocumento);
        newPaciente.setNombreCompleto(nombreCompleto);
        newPaciente.setFechaDeNacimiento(fechaDeNacimiento);
        newPaciente.setCiudadDeResidencia(ciudadDeResidencia);
        newPaciente.setPaisDeResidencia(paisDeResidencia);
        newPaciente.setDireccion(direccion);
        newPaciente.setTelefonoFijo(telefonoFijo);
        newPaciente.setOcupacion(ocupacion);
        newPaciente.setCelular(celular);
        newPaciente.setEPS(EPS);
        newPaciente.setRegimenContributivo(regimenContributivo);
        
        pacientes[contadorPacientes] = newPaciente;
       
        JOptionPane.showMessageDialog(null, "El registro del paciente fue un exito.");
        return 1 + contadorPacientes;
    }
}
