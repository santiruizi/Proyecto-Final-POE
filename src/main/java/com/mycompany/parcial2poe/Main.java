/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial2poe;

/**
 * Santiago Ruiz Gallego.
 * Juan Camilo Garcia Durango.
 * Isaac Antillano Cruy.
 * Andres David Gaitan.
 * Gabriela Lourdes Gomez.
 */

import com.mycompany.parcial2poe.M_Paciente.Modulo_Paciente;
import com.mycompany.parcial2poe.M_Empleados.Modulo_Empleado;
import com.mycompany.parcial2poe.M_Citas.Modulo_Citas;

import javax.swing.*;

public class Main {
    
    public static void main(String[] args){
        //InterfazMain interM = new InterfazMain();
        
        Integer opc, opc2;
        
        Modulo_Empleado moduloEmpleados = new Modulo_Empleado();
        Modulo_Paciente moduloPacientes = new Modulo_Paciente();
        Modulo_Citas moduloCitas = new Modulo_Citas();
        
        do{
            opc = Integer.valueOf(JOptionPane.showInputDialog("Clínica Hells Pass"+"\n"+
                                                                "1. Modulo pacientes."+"\n"+
                                                                "2. Modulo empleado."+"\n"+
                                                                "3. Modulo Consultorio"+"\n"+
                                                                "4. Modulo Citas"+"\n"+
                                                                "Digite la opción que desee: "));
            
            switch(opc){
                case 1 ->{
                    moduloPacientes.m_Paciente();
                    break;
                }
                
                case 2 ->{
                    moduloEmpleados.m_Empleado();
                    break;
                }

                case 3->{
                    break;
                }

                case 4->{
                    moduloCitas.m_Citas();
                    break;
                }
                
                default-> {JOptionPane.showMessageDialog(null, "Opción invalida,"); break;}
            }
            
            opc2 = Integer.valueOf(JOptionPane.showInputDialog("Desea hacer otro proceso? (1. Si / 2. No)"));
        }while(opc2 !=2);
        
        JOptionPane.showMessageDialog(null, "Ha salido del sistema de Clinica Hell pass");
    }
}
