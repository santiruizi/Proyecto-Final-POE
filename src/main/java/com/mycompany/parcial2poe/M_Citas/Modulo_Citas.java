package com.mycompany.parcial2poe.M_Citas;

/*
    Santiago Ruiz Gallego
    Juan Camilo Garcia Durango.
    Isaac Antillano Cruy
    Andres David Gaitan.
    Gabriela Lourdes Gomez.
 */

import javax.swing.*;

public class Modulo_Citas {
    public void m_Citas(){

        int opc, opc2;

        do{
            opc = Integer.valueOf(JOptionPane.showInputDialog("Menú de Citas"+"\n"+
                                                                "1. Ingreso de una nueva cita."+"\n"+
                                                                "2. Consultar las citas por su id."+"\n"+
                                                                "3. Consultar citas por documento del paciente."+"\n"+
                                                                "4. Consultar citas por documento del empleado."+
                                                                "5. Listar todos los pacientes que han realizado citas por fecha."+
                                                                "6. Modificar citas en fecha u hora y estado de la cita."+
                                                                "Digite la opción que desee: "));

            switch(opc){
                case 1->{
                    break;
                }

                case 2->{
                    break;
                }

                case 3->{
                    break;
                }

                case 4->{
                    break;
                }

                case 5->{
                    break;
                }

                case 6->{
                    break;
                }

                default -> { JOptionPane.showMessageDialog(null, "Opción invalida."); break;}
            }
            opc2 = Integer.valueOf(JOptionPane.showInputDialog("Desea hacer otra proceso? (1. Si / 2.No)"));
        }while(opc2 != 2);
        JOptionPane.showMessageDialog(null, "Usted ha salido del modulo de citas.");
    }
}
