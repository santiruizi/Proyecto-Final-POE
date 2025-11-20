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

import javax.swing.*;
import java.time.LocalDate;

public class m_Paciente {
    
    public void m_Paciente(){
        Integer opc, opc2;
        
        Paciente[] pacientes = new Paciente[50];
        FuncionesPacientes funcionesP = new FuncionesPacientes();
        int contadorPacientes = 0;
        do{
            opc = Integer.valueOf(JOptionPane.showInputDialog("Menú Pacientes"+"\n"+
                                                                "1. Ingresar un nuevo paciente."+"\n"+
                                                                "2. Ordenar por numero de documento."+"\n"+
                                                                "3. Poder consultar la existencia de un paciente por numero de documento."+"\n"+
                                                                "4. Ordenar por fecha de nacimiento."+"\n"+
                                                                "5. Poder consultar la existencia de un paciente por fecha de nacimiento."+"\n"+
                                                                "6. Ordenación alfabeticamente de los pacientes."+"\n"+
                                                                "7. Consultar existencia por medio alfabetico."+"\n"+
                                                                "8. Modificar información del paciente."+"\n"+
                                                                "9. Eliminación del paciente por medio del numero de documento."+"\n"+
                                                                "Digite la opción: "));
            
            switch(opc){
                case 1->{
                    
                    IngresoPaciente ingresoP = new IngresoPaciente();
                    
                    contadorPacientes = ingresoP.ingresoP(pacientes, contadorPacientes);
                    break;
                }
                
                case 2->{
                    
                    if(funcionesP.validarPaciente(contadorPacientes)) break;
                    
                    funcionesP.ordenarPorDocumento(pacientes, contadorPacientes);
                }
                
                case 3->{
                    if(funcionesP.validarPaciente(contadorPacientes));
                    
                    Integer numeroDeDocumento;
                    
                    numeroDeDocumento = Integer.valueOf(JOptionPane.showInputDialog("Digite su numero de documento: "));
                    while(numeroDeDocumento <= 0 || numeroDeDocumento > 9999999999L){
                        JOptionPane.showMessageDialog(null, "El numero de documento es invalido.");
                        numeroDeDocumento = Integer.valueOf(JOptionPane.showInputDialog("Digite su numero de documento: "));
                    }
                    funcionesP.busquedaPorNumeroDeDocumento(pacientes, contadorPacientes, numeroDeDocumento);
                    break;
                }
                
                case 4->{
                    if(funcionesP.validarPaciente(contadorPacientes)) break;
                    
                    funcionesP.ordenarPorFechaDeNacimiento(pacientes, contadorPacientes);
                    break;
                }
                
                case 5->{
                    if(funcionesP.validarPaciente(contadorPacientes)) break;
                    
                    String strFechaDeNacimiento;
                    LocalDate fechaDeNacimiento;
                    
                    strFechaDeNacimiento = JOptionPane.showInputDialog("Digite la fecha de nacimiento(AA-MM-DD): ");
                    while(strFechaDeNacimiento.isEmpty() || !strFechaDeNacimiento.matches("\\d{4}-\\d{2}-\\d{2}")){
                        JOptionPane.showMessageDialog(null, "Formato inválido, debe de ser (AAAA-MM-DD)");
                        strFechaDeNacimiento = JOptionPane.showInputDialog("Digite la fecha de nacimiento(AA-MM-DD): ");
                    }
                    fechaDeNacimiento = LocalDate.parse(strFechaDeNacimiento);
                    
                    funcionesP.busquedaDeExistenciaFechaDeNacimiento(pacientes, contadorPacientes, fechaDeNacimiento);
                    break;
                }
                
                case 6->{
                    if(funcionesP.validarPaciente(contadorPacientes)) break;
                    
                    funcionesP.ordenarAlfabeticamente(pacientes, contadorPacientes);
                    break;
                }
                
                case 7->{
                    if(funcionesP.validarPaciente(contadorPacientes)) break;
                    
                    String nombreCompleto;
                    
                    nombreCompleto = JOptionPane.showInputDialog("Digite su nombre completo: ");
                    while(nombreCompleto.isEmpty()){
                        JOptionPane.showMessageDialog(null, "El nombre es invalido.");
                        nombreCompleto = JOptionPane.showInputDialog("Digite su nombre completo: ");
                    }
                    funcionesP.busquedaExistenciaAlfabetica(pacientes, contadorPacientes, nombreCompleto);
                    break;
                }
                
                case 8->{
                    if(funcionesP.validarPaciente(contadorPacientes)) break;
                    
                    Integer numeroDeDocumento;
                    
                    numeroDeDocumento = Integer.valueOf(JOptionPane.showInputDialog("Digite su numero de documento: "));
                    while(numeroDeDocumento <= 0 || numeroDeDocumento > 9999999999L){
                        JOptionPane.showMessageDialog(null, "El numero de documento es invalido.");
                        numeroDeDocumento = Integer.valueOf(JOptionPane.showInputDialog("Digite su numero de documento: "));
                    }
                    
                    ModificarP modificacion = new ModificarP();
                    modificacion.modificarPaciente(pacientes, contadorPacientes, numeroDeDocumento);
                    break;
                }
                
                case 9->{
                    if(funcionesP.validarPaciente(contadorPacientes)) break;
                    
                    Integer numeroDeDocumento;
                    
                    numeroDeDocumento = Integer.valueOf(JOptionPane.showInputDialog("Digite el numero de documento: "));
                    while(numeroDeDocumento <= 0 || numeroDeDocumento > 9999999999L){
                        JOptionPane.showMessageDialog(null, "El numero de documento es invalido.");
                        numeroDeDocumento = Integer.valueOf(JOptionPane.showInputDialog("Digite el numero de documento: "));
                    }
                    
                    funcionesP.eliminarEmpleado(pacientes, contadorPacientes, numeroDeDocumento);
                }
                default-> {JOptionPane.showMessageDialog(null, "Opción invalida.");}
            }
            opc2 = Integer.valueOf(JOptionPane.showInputDialog("Desea hacer otro proceso? (1. Si / 2. No)"));
        }while(opc2 != 2);
    }
}
