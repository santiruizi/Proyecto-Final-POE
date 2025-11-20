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

import java.util.Arrays;
import javax.swing.*;

public class ModificarP {
    public void modificarPaciente(Paciente[] pacientes, int contadorPacientes, Integer numeroDeDocumento){
        Paciente[] copia = Arrays.copyOf(pacientes, contadorPacientes);
        
        for(Paciente e : copia){
            if(e.getNumeroDeDocumento().equals(numeroDeDocumento)){
                Integer opc, opc2;
                
                do{
                    opc = Integer.valueOf(JOptionPane.showInputDialog("Menú Modificación Paciente."+"\n"+
                                                                        "1. Dirección"+"\n"+
                                                                        "2. Telefono fijo."+"\n"+
                                                                        "3. Celular."+"\n"+
                                                                        "4. Ciudad de residencia."+"\n"+
                                                                        "5. Pais de residencia."+"\n"+
                                                                        "6. Ocupación."+"\n"+
                                                                        "Digite la opción que desea: "));
                    
                    switch(opc){
                        case 1->{
                            String newDireccion;
                            
                            newDireccion = JOptionPane.showInputDialog("Digite su nueva dirección: ");
                            while(newDireccion.isEmpty()){
                                JOptionPane.showMessageDialog(null, "La dirección es invalida");
                                newDireccion = JOptionPane.showInputDialog("Digite su nueva dirección: ");
                            }
                            e.setDireccion(newDireccion);
                            JOptionPane.showMessageDialog(null, "La modificación fue un exito");
                            break;
                        }
                        
                        case 2->{
                            Integer newTelefonoFijo;
                            
                            newTelefonoFijo = Integer.valueOf(JOptionPane.showInputDialog("Digite su nuevo telefono fijo: "));
                            while(newTelefonoFijo <= 0 || newTelefonoFijo > 9999999999L){
                                JOptionPane.showMessageDialog(null, "El telefono fijo es invalido.");
                                newTelefonoFijo = Integer.valueOf(JOptionPane.showInputDialog("Digite su nuevo telefono fijo: "));
                            }
                            e.setTelefonoFijo(newTelefonoFijo);
                            JOptionPane.showMessageDialog(null, "La modificación fue un exito.");
                            break;
                        }
                        
                        case 3->{
                            Integer newCelular;
                            
                            newCelular = Integer.valueOf(JOptionPane.showInputDialog("Digite su numero de celular: "));
                            while(newCelular <= 0 || newCelular > 9999999999L){
                                JOptionPane.showMessageDialog(null, "El numero de celular es invalido.");
                                newCelular = Integer.valueOf(JOptionPane.showInputDialog("Digite su numero de celular: "));
                            }
                            e.setCelular(newCelular);
                            JOptionPane.showMessageDialog(null, "La modificación fue un exito.");
                            break;
                        }
                        
                        case 4->{
                            String newCiudadDeResidencia;
                            
                            newCiudadDeResidencia = JOptionPane.showInputDialog("Digite su ciudad de residencia: ");
                            while(newCiudadDeResidencia.isEmpty()){
                                JOptionPane.showMessageDialog(null, "La ciudad de residencia es invalida.");
                                newCiudadDeResidencia = JOptionPane.showInputDialog("Digite su ciudad de residencia: ");
                            }
                            e.setCiudadDeResidencia(newCiudadDeResidencia);
                            JOptionPane.showMessageDialog(null, "La modificación fue un exito.");
                            break;
                        }
                        
                        case 5->{
                            String newPaisDeResidencia;
                            
                            newPaisDeResidencia = JOptionPane.showInputDialog("Digite su pais de residencia: ");
                            while(newPaisDeResidencia.isEmpty()){
                                JOptionPane.showMessageDialog(null, "El pais de residencia es invalido.");
                                newPaisDeResidencia = JOptionPane.showInputDialog("Digite su pais de residencia: ");
                            }
                            e.setPaisDeResidencia(newPaisDeResidencia);
                            JOptionPane.showMessageDialog(null, "La modificación fue un exito.");
                            break;
                        }
                        
                        case 6->{
                            String newOcupacion;
                            
                            newOcupacion = JOptionPane.showInputDialog("Digite su nueva ocupación: ");
                            while(newOcupacion.isEmpty()){
                                JOptionPane.showMessageDialog(null, "La ocupación es invalida.");
                                newOcupacion = JOptionPane.showInputDialog("Digite su nueva ocupación: ");
                            }
                            e.setOcupacion(newOcupacion);
                            JOptionPane.showMessageDialog(null, "La modificación fue un exito.");
                            break;
                        }
                        default->{JOptionPane.showMessageDialog(null, "Opción invalida.");}
                    }
                    opc2 = Integer.valueOf(JOptionPane.showInputDialog("Desea hacer otro proceso? (1. Si / 2. No)"));
                }while(opc2 !=2);
                
                JOptionPane.showMessageDialog(null, "Usted ha salido de menú modificaciones de pacientes.");
            }
        }
    }
}
