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
                                                                "2. Consultar citas por id."+"\n"+
                                                                "3. Consultar citas por numero de documento del paciente."+"\n"+
                                                                "4. Consultar citas"));

            switch(opc){}
            opc2 = Integer.valueOf(JOptionPane.showInputDialog("Desea hacer otra proceso? (1. Si / 2.No)"));
        }while(opc2 != 2);
        JOptionPane.showMessageDialog(null, "Usted ha salido del modulo de citas.");
    }
}
