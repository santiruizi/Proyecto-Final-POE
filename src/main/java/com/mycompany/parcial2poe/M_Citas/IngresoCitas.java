package com.mycompany.parcial2poe.M_Citas;

import com.mycompany.parcial2poe.M_Paciente.FuncionesPacientes;

/*
    Santiago Ruiz Gallego.
    Juan Camilo Garcia Durango.
    Isaac Antillano Cruy.
    Andres David Gaitan.
    Gabriela Lourdes Gomez.
 */

import java.time.LocalTime;

import javax.swing.JOptionPane;

import java.time.LocalDate;

public class IngresoCitas {
    public int ingresoCitas(Citas[] cita, int contadorCitas){

        Integer numeroDeDocumentoPaciente;
        String strFechaCita, strHoraCita, tipoDeConsulta, estadoCita, nivelDeUrgencia;
        LocalDate fechaCita;
        LocalTime horaCita;

        numeroDeDocumentoPaciente = Integer.valueOf(JOptionPane.showInputDialog("Digite el numero de documento: "));
        while(numeroDeDocumentoPaciente <= 0 || numeroDeDocumentoPaciente > 9999999999L){
            JOptionPane.showMessageDialog(null, "El numero de documento es invalido.");
            numeroDeDocumentoPaciente = Integer.valueOf(JOptionPane.showInputDialog("Digite el numero de documento: "));
        }

        strFechaCita = JOptionPane.showInputDialog("Digite la fecha de la cita(AA-MM-DD): ");
        while(strFechaCita.isEmpty() || !strFechaCita.matches("\\d{4}-\\d{2}-\\d{2}")){
            JOptionPane.showMessageDialog(null, "Formato inválido, debe de ser (AAAA-MM-DD)");
            strFechaCita = JOptionPane.showInputDialog("Digite la fecha de la cita(AA-MM-DD): ");
        }
        fechaCita = LocalDate.parse(strFechaCita);

        strHoraCita = JOptionPane.showInputDialog("Hora de la Cita"+"\n"+
                                                    "Recuerda que para sacar la cita debe ser en el horario ");

        return 1;
    }
}
