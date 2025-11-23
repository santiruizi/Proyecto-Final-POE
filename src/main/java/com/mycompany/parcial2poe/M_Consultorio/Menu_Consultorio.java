/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial2poe.M_Consultorio;

/**
 *  Santiago Ruiz Gallego.
 *  Juan Camilo Garcia Durango.
 *  Isaac Antillano Cruy.
 *  Andres David Gaitan.
 *  Gabriela Lourdes Gomez.
 */

import javax.swing.*;
public class Menu_Consultorio {
    public void m_Consultorio(){
        Integer opc, opc2;
        int contadorConsultorio = 0;
        Consultorio[] consultas = new Consultorio[50];
        
        do{
            opc = Integer.valueOf(JOptionPane.showInputDialog("Menú Consultorio"+"\n"+
                                                                "1. Ingreso de nueva cita."+"\n"+
                                                                "2. Consultar consultorio por medio de su id."+"\n"+
                                                                "3. Consultar consultorio por medio del id del empleado."+"\n"+
                                                                "4. Consultar consultorio por estado."+"\n"+
                                                                "5. Consultar consultorio por tipo."+"\n"+
                                                                "6. Disponibilidad de consultorio por cita."+"\n"+
                                                                "7. Modificar datos."));
            switch(opc){
                
                default->{JOptionPane.showMessageDialog(null, "Opción invalida."); break;}
            }
            opc2 = Integer.valueOf(JOptionPane.showInputDialog("Desea hacer otro proceso? (1. Si/)"));
        }while(opc2 != 1);
        JOptionPane.showMessageDialog(null, "Usted ha salido del modulo Consultorio.");
    }
}