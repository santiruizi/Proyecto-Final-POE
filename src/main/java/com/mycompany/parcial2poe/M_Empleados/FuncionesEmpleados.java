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

import java.util.Arrays;
import javax.swing.*;

public class FuncionesEmpleados {
    
    public void ordenarPorDocumento(Empleado[] empleados, int contadorEmpleados){
        Empleado[] copia = Arrays.copyOf(empleados, contadorEmpleados);
        Arrays.sort(copia, (e1, e2)->e1.getNumeroDeDocumento().compareTo(e2.getNumeroDeDocumento()));
        JOptionPane.showMessageDialog(null, "El ordenamiento fue un exito.");
    }
    
    public Empleado buscarPorDocumento(Empleado[] empleados, Long numeroDeDocumento, int contadorEmpleados){
        int izquierda = 0, derecha = contadorEmpleados;
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            int comparacion = empleados[medio].getNumeroDeDocumento().compareTo(numeroDeDocumento);
            if (comparacion == 0) return empleados[medio];
            else if (comparacion < 0) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        return null;

    }
    
    public void ordenarPorCargo(Empleado[] empleados, int contadorEmpleados){
        Empleado[] copia = Arrays.copyOf(empleados, contadorEmpleados);
        Arrays.sort(copia, (e1, e2)->e1.getCargo().compareToIgnoreCase(e2.getCargo()));
        JOptionPane.showMessageDialog(null, "El ordenamiento fue un exito.");
    }
    
    public void mostarPorCargo(Empleado[] empleados, int contadorEmpleados){
        Empleado[] copia = Arrays.copyOf(empleados, contadorEmpleados);
        for(Empleado e : copia){
            e.getInfo();
        }
    }
    
    public void ordenarAlfabeticamente(Empleado[] empleados, int contadorEmpleados){
        Empleado[] copia = Arrays.copyOf(empleados, contadorEmpleados);
        Arrays.sort(copia, (e1, e2)-> e1.getNombreCompleto().compareToIgnoreCase(e2.getNombreCompleto()));
        JOptionPane.showMessageDialog(null, "El ordenamiento fue un exito.");
    }
    
    public void mostarAlfabeticamente(Empleado[] empleados, int contadorEmpleados){
        Empleado[] copia = Arrays.copyOf(empleados, contadorEmpleados);
        for(Empleado e : copia){
            e.getInfo();
        }
    }
    
    public void eliminarEmpleado(Empleado[] empleados, int contadorEmpleados, Long numeroDeDocumento){
        for (int i = 0; i < contadorEmpleados; i++) {
            if (empleados[i].getNumeroDeDocumento().equals(numeroDeDocumento)) {
                for (int j = i; j < contadorEmpleados - 1; j++) {
                    empleados[j] = empleados[j + 1];
                }
                empleados[contadorEmpleados - 1] = null; 
                JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No existe un empleado con ese número de documento.");
    }

    public boolean verificarExistencia(int contadorEmpleados){
        if(contadorEmpleados <= 0){
            JOptionPane.showMessageDialog(null, "No existen registros de empleados actualmente.");
            return true;
        }
        return false;
    }
}
