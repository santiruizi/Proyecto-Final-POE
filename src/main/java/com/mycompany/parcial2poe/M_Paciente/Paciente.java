/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial2poe.M_Paciente;

/**
 *  Sanitago Ruiz Gallego.
 *  Juan Camilo Garcia Durango.
 *  Isaac Antillano Cruy.
 *  Andres David Gaitan.
 *  Gabriela Lourdes Gomez.
 */

import com.mycompany.parcial2poe.Persona;
import java.time.LocalDate;
import javax.swing.*;

public class Paciente extends Persona{
    private Integer id_paciente;
    private String eps;
    private String regimenContributivo;
    private boolean estado;
    
    // Se hace la captura de los datos, para despues con el otro constructor asigarle la llave y despues se hace la copia en Dao
    public Paciente(String tipoDeDocumento, Long numeroDeDocumento, String nombreCompleto, LocalDate fechaDeNacimiento, String ciudadDeResidencia, String paisDeResidencia, String ocupacion,String direccion, Long telefonoFijo, long celular, String eps, String regimenContributivo, boolean estado){
        super(tipoDeDocumento, numeroDeDocumento, nombreCompleto, fechaDeNacimiento, ciudadDeResidencia, paisDeResidencia, ocupacion, direccion, telefonoFijo, celular);
        this.eps = eps;
        this.regimenContributivo = regimenContributivo;
        this.estado = estado;
    }

    // Constructor el cual hace el registro en Dao
    public Paciente(int id_persona,String tipoDeDocumento, Long numeroDeDocumento, String nombreCompleto, LocalDate fechaDeNacimiento, String ciudadDeResidencia, String paisDeResidencia, String ocupacion,String direccion, Long telefonoFijo, Long celular, String eps, String regimenContributivo, boolean estado, Integer id_paciente){
        super(id_persona, tipoDeDocumento, numeroDeDocumento, nombreCompleto, fechaDeNacimiento, ciudadDeResidencia, paisDeResidencia, ocupacion, direccion, telefonoFijo, celular);
        this.id_paciente = id_paciente;
        this.eps = eps;
        this.regimenContributivo = regimenContributivo;
        this.estado = estado;
    }
    
    // id_paciente

    public Integer getId_Paciente(){
        return id_paciente;
    }

    public void setId_Paciente(Integer id_paciente){
        this.id_paciente = id_paciente;
    }

    // EPS.

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    // Regimen Contributivo
    public String getRegimenContributivo() {
        return regimenContributivo;
    }

    public void setRegimenContributivo(String regimenContributivo) {
        this.regimenContributivo = regimenContributivo;
    }
    
    // Estado

    public boolean isEstado(){
        return estado;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    @Override
    public void getInfo(){
        super.getInfo();
        JOptionPane.showMessageDialog(null, 
                                            "Información Paciente:"+"\n"+
                                            "Nombre de eps que pertenece: "+eps+"\n"+
                                            "Regimen Contributivo: "+regimenContributivo+"\n"+
                                            "Estado: "+estado); 
    }
}