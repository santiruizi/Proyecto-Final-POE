/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial2poe.M_Consultorio;

/**
 *  Santiago Ruiz Gallego.
 *  Juan Camilo Garcia Durango.
 *  Isaac Antillano Cruiz.
 *  Andres David Gaitan.
 *  Gabriela Lourdes Gomez
 */

import javax.swing.*;

public class FuncionesConsultorio {

    public boolean validarExistenciaConsulta(int contadorConsultorio){
        if(contadorConsultorio <= 0){
            JOptionPane.showMessageDialog(null, "Actualmente no existen consultas.");
            return true;
        }
        return false;
    }
}
