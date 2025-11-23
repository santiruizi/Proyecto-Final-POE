/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial2poe.M_Empleados;

import javax.swing.JOptionPane;

/**
 * Santiago Ruiz Gallego.
 * Juan Camilo Garcia Durango.
 * Isaac Antillano Cruy.
 * Andres David Gaitan.
 * Gabriela Lourdes Gomez. 
 */
public class Modulo_Empleado {
    
    public void m_Empleado(){
        int opc, opc2;
        
        Empleado[] empleados = new Empleado[50];
        
        int contadorEmpleados = 0;
        
        FuncionesEmpleados funciones = new FuncionesEmpleados();
        
        IngresoEmpleados ingresoE = new IngresoEmpleados();
        
        do{
            opc = Integer.valueOf(JOptionPane.showInputDialog("Modulo Empleado"+"\n"+
                                    "1. Crear nuevo empleado."+"\n"+
                                    "2. Ordenar por numero de documento." + "\n" +
                                    "3. Consultar empleado por numero de documento."+"\n"+
                                    "4. Ordenar por cargo."+"\n"+
                                    "5. Listar todos los empleados por cargo."+ "\n" +
                                    "6. Ordenar todos los empleados por ordena alfabeticamente."+"\n"+
                                    "7. Listar todos los empleados por orden alfabetico."+"\n"+
                                    "8. Modificar datos."+"\n"+
                                    "9. Eliminación de empleado."+"\n"+
                                    "Digite la nueva opción: "));
            
            switch(opc){
                
                case 1->{
                    contadorEmpleados = ingresoE.ingreso_E(empleados, contadorEmpleados);
                    break;
                }
                
                case 2->{
                    if(funciones.verificarExistencia(contadorEmpleados)) break;
                    funciones.ordenarPorDocumento(empleados, contadorEmpleados);
                    break;
                }
                case 3->{
                    if(funciones.verificarExistencia(contadorEmpleados)) break;
                    
                    Integer newNumeroDeDocumento;
                    
                    newNumeroDeDocumento = Integer.valueOf(JOptionPane.showInputDialog("Digite el numero de cedula: "));
                    while(newNumeroDeDocumento <= 0 || newNumeroDeDocumento > 9999999999L){
                        JOptionPane.showMessageDialog(null, "Digite el numero de documento.");
                    }
                    
                    funciones.buscarPorDocumento(empleados, newNumeroDeDocumento, contadorEmpleados);
                    break;
                }
                
                case 4 ->{
                    if(funciones.verificarExistencia(contadorEmpleados)) break;
                    
                    funciones.ordenarPorCargo(empleados, contadorEmpleados);
                    break;
                }
                
                case 5->{
                    if(funciones.verificarExistencia(contadorEmpleados)) break;
                    
                    funciones.mostarPorCargo(empleados, contadorEmpleados);
                    break;
                }
                
                case 6->{
                    if(funciones.verificarExistencia(contadorEmpleados));
                    
                    funciones.ordenarAlfabeticamente(empleados, contadorEmpleados);
                    break;
                }
                
                case 7 ->{
                    if(funciones.verificarExistencia(contadorEmpleados)) break;
                    
                    funciones.mostarAlfabeticamente(empleados, contadorEmpleados);
                    break;
                }
                
                case 8 ->{
                    if(funciones.verificarExistencia(contadorEmpleados)) break;
                    
                    Integer numeroDeDocumento;
                    
                    numeroDeDocumento = Integer.valueOf(JOptionPane.showInputDialog("Digite el numero de documento: "));
                    while(numeroDeDocumento <= 0 || numeroDeDocumento > 9999999999L){
                        JOptionPane.showMessageDialog(null, "El numero de documento es invalido.");
                        numeroDeDocumento = Integer.valueOf(JOptionPane.showInputDialog("Digite el numero de documento: "));
                    }
                    
                    ModificarE modificarEmpleado = new ModificarE();
                    
                    modificarEmpleado.modificarEmpleados(empleados, contadorEmpleados, numeroDeDocumento);
                    break;
                }
                
                case 9->{
                    if(funciones.verificarExistencia(contadorEmpleados)) break;
                    
                    Integer numeroDeDocumento;
                    
                    numeroDeDocumento = Integer.valueOf(JOptionPane.showInputDialog("Digite el numero de documento: "));
                    while(numeroDeDocumento <= 0 || numeroDeDocumento > 9999999999L){
                        JOptionPane.showMessageDialog(null, "El numero de documento es invalido.");
                        numeroDeDocumento = Integer.valueOf(JOptionPane.showInputDialog("Digite el numero de documento: "));
                    }
                    
                    funciones.eliminarEmpleado(empleados, contadorEmpleados, numeroDeDocumento);
                    break;
                }
                
                default->{JOptionPane.showMessageDialog(null, "Opción invalida");}
            }
            
            opc2 = Integer.valueOf(JOptionPane.showInputDialog("Desea hacer otro proceso? (1. Si / 2. No)"));
        }while(opc2 != 2);
        JOptionPane.showMessageDialog(null, "Usted ha salido del modulo de pacientes");
    }
}
