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

public class ModificarE {
    
    public void modificarEmpleados(Empleado[] empleados, int contadorEmpledos, Integer numeroDeDocumento){
        Empleado[] copia = Arrays.copyOf(empleados, contadorEmpledos);
        for(Empleado e : copia){
            if(e.getNumeroDeDocumento().equals(numeroDeDocumento)){
                Integer opc, opc2;
                
                do{
                    opc = Integer.valueOf(JOptionPane.showInputDialog("Menú Modificaciones"+"\n"+
                                                                        "1. Modificar dirección"+"\n"+
                                                                        "2. Telefono fijo."+"\n"+
                                                                        "3. Celular"+"\n"+
                                                                        "4. Ciudad de residencia."+"\n"+
                                                                        "5. Pais de residencia."+"\n"+
                                                                        "Digite la opción: "));
                    
                    switch(opc){
                        
                        case 1->{
                            String newDireccion;
                            
                            newDireccion = JOptionPane.showInputDialog("Digite la nueva dirección que desee: ");
                            while(newDireccion.isEmpty()){
                                JOptionPane.showMessageDialog(null, "Dirección invalida");
                            }
                            e.setDireccion(newDireccion);
                            break;
                        }
                        
                        case 2 ->{
                            Long newTelefonoFijo;
                            
                            newTelefonoFijo = Long.valueOf(JOptionPane.showInputDialog("Digite el nuevo telefono fijo: "));
                            while(newTelefonoFijo <= 0 || newTelefonoFijo > 9999999999L){
                                JOptionPane.showMessageDialog(null, "El cambio de telefono fijo, no ha sido posible.");
                                newTelefonoFijo = Long.valueOf(JOptionPane.showInputDialog("Digite el nuevo telefono fijo: "));
                            }
                            e.setTelefonoFijo(newTelefonoFijo);
                            break;
                        }
                        
                        case 3->{
                            Long newCelular;
                            
                            newCelular = Long.valueOf(JOptionPane.showInputDialog("Digite el nuevo numero de celular: "));
                            while(newCelular <= 0 || newCelular > 9999999999L){
                                JOptionPane.showMessageDialog(null, "El nuevo numero de celular, no ha sido posible el registro.");
                                newCelular = Long.valueOf(JOptionPane.showInputDialog("Digite el nuevo numero de celular: "));
                            }
                            e.setCelular(newCelular);
                            break;
                        }
                        
                        case 4->{
                            String newCiudadDeResidencia;
                            
                            newCiudadDeResidencia = JOptionPane.showInputDialog("Digite la nueva ciudad de residencia: ");
                            while(newCiudadDeResidencia.isEmpty()){
                                JOptionPane.showMessageDialog(null, "El registro de cambio de ciudad de residencia, no ha sido posible.");
                                newCiudadDeResidencia = JOptionPane.showInputDialog("Digite la nueva ciudad de residencia: ");
                            }
                            e.setCiudadDeResidencia(newCiudadDeResidencia);
                            break;
                        }
                        
                        case 5->{
                            String newPaisDeResidencia;
                            
                            newPaisDeResidencia = JOptionPane.showInputDialog("Digite el nuevo pais de residencia: ");
                            while(newPaisDeResidencia.isEmpty()){
                                JOptionPane.showMessageDialog(null, "El registro de cambio de pais de residencia, no ha sido posible.");
                                newPaisDeResidencia = JOptionPane.showInputDialog("Digite el nuevo pais de residencia: ");
                            }
                            e.setPaisDeResidencia(newPaisDeResidencia);
                            break;
                        }
                        
                        default->{JOptionPane.showMessageDialog(null, "Opción invalida.");}
                    }
                    
                    opc2 = Integer.valueOf(JOptionPane.showInputDialog("Desea hacer ptro proceso? (1. Si / 2. No)"));
                }while(opc2 != 2);
                
                JOptionPane.showMessageDialog(null, "Ustde ha salido del menú de modificación empleado.");
            }
        }
    }
}
