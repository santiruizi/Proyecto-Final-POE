/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial2poe.M_Paciente;

/**
 * Santiago Ruiz Gallego.
 * Juan Camilo Garcia Durango.
 * Isaac Antillano Cruiz.
 * Andres David Gaitan.
 * Gabriela Lourdes Gomez.
 */

import javax.swing.*;
import java.util.Arrays;
import java.time.LocalDate;

public class FuncionesPacientes {
    
    public boolean validarPaciente(int contadorPacientes){
        if(contadorPacientes <= 0){
            JOptionPane.showMessageDialog(null, "No existen registros de pacientes actualmente.");
            return true;
        }
        return false;
    }
    
    public void ordenarPorDocumento(Paciente[] pacientes, int contadorPacientes){
        Paciente[] copias = Arrays.copyOf(pacientes, contadorPacientes);
        Arrays.sort(copias, (e1, e2)->e1.getNumeroDeDocumento().compareTo(e2.getNumeroDeDocumento()));
        JOptionPane.showMessageDialog(null, "El ordenamiento fue un exito.");
    }
    
    public void busquedaPorNumeroDeDocumento(Paciente[] pacientes, int contadorPacientes, Integer numeroDeDocumento){
        for(int i = 0; i < contadorPacientes; i++){
            if(pacientes[i].getNumeroDeDocumento().equals(numeroDeDocumento)){
                JOptionPane.showMessageDialog(null, "Este paciente existe.");
            }
        }
        JOptionPane.showMessageDialog(null, "El paciente no existe.");
    }
    
    public void ordenarPorFechaDeNacimiento(Paciente[] pacientes, int contadorPacientes){
        Paciente[] copia = Arrays.copyOf(pacientes, contadorPacientes);
        Arrays.sort(copia, (e1, e2)->e1.getFechaDeNacimiento().compareTo(e2.getFechaDeNacimiento()));
        JOptionPane.showMessageDialog(null, "El ordenamiento fue un exito.");
    }
    
    public void busquedaDeExistenciaFechaDeNacimiento(Paciente[] pacientes, int contadorPacientes, LocalDate fechaDeNacimiento){
        for(int i = 0; i < contadorPacientes; i++){
            if(pacientes[i].getFechaDeNacimiento().equals(fechaDeNacimiento)){
                JOptionPane.showMessageDialog(null, "El paciente existe.");
            }
        }
        JOptionPane.showMessageDialog(null, "El paciente no existe");
    }
    
    public void ordenarAlfabeticamente(Paciente[] pacientes, int contadorPacientes){
        Paciente[] copia = Arrays.copyOf(pacientes, contadorPacientes);
        Arrays.sort(copia, (e1, e2)->e1.getNombreCompleto().compareToIgnoreCase(e2.getNombreCompleto()));
        JOptionPane.showMessageDialog(null, "El ordenamiento fue un exito");
    }
    
    public void busquedaExistenciaAlfabetica(Paciente[] pacientes, int contadorPacientes, String nombreCompleto){
        Paciente[] copia = Arrays.copyOf(pacientes, contadorPacientes);
        for(Paciente e : copia){
            if(e.getNombreCompleto().equalsIgnoreCase(nombreCompleto)){
                JOptionPane.showMessageDialog(null, "El paciente existe.");
            }
        }
        JOptionPane.showMessageDialog(null, "El paciente no existe.");
    }
    
    public void eliminarEmpleado(Paciente[] pacientes, int contadorPacientes, Integer numeroDeDocumento){
        for (int i = 0; i < contadorPacientes; i++) {
            if (pacientes[i].getNumeroDeDocumento().equals(numeroDeDocumento)) {
                for (int j = i; j < contadorPacientes - 1; j++) {
                    pacientes[j] = pacientes[j + 1];
                }
                pacientes[contadorPacientes - 1] = null; 
                JOptionPane.showMessageDialog(null, "Paciente eliminado correctamente.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No existe un paciente con ese número de documento.");
    }
}
