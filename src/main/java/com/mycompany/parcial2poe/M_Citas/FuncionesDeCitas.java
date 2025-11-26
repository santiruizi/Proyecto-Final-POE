/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial2poe.M_Citas;

import com.mycompany.parcial2poe.M_Paciente.Paciente;
/**
 *  Santiago Ruiz Gallego.
 *  Juan Camilo Garcia Durango.
 *  Isaac Antillano Cruiz.
 *  Andres David Gaitan.
 *  Gabriela Lourdes Gomez.
 */

import javax.swing.*;

public class FuncionesDeCitas {
    public boolean validarExistenciaCita(int contadorCitas){
        if(contadorCitas <= 0){
            JOptionPane.showMessageDialog(null, "Actualmente no existen registros de citas.");
            return true;
        }
        return false;
    }

    
}
