package com.mycompany.parcial2poe.M_Consultorio;

import javax.swing.JOptionPane;

/*
 *  Santiago Ruiz Gallego.
 *  Juan Camilo Garcia Durango.
 *  Isaac Antillano Cruiz.
 *  Andres David Gaitan.
 *  Gabriela Lourdes Gomez.
*/

import com.mycompany.parcial2poe.M_Empleados.Empleado;

public class Consultorio {
    private Integer idConsultorio;
    private String tipoDeConsultorio;
    private Empleado idEmpleado;
    private Integer extensionTelefono;
    private boolean estado;
    private String causa;

    // Este lo trabajo antes de la creación del user captura los datos primordiales
    public Consultorio(String tipoDeConsultorio, Integer extensionTelefono, boolean estado){
        this.tipoDeConsultorio = tipoDeConsultorio;
        this.extensionTelefono = extensionTelefono;
        this.estado = estado;
    }    

    // Este va ya cuando se monta la Dao y lo tengo en mysql
    public Consultorio(Integer idConsultorio, String tipoDeConsultorio, Empleado idEmpleado, Integer extensionTelefono, boolean estado, String causa){
        this.idConsultorio = idConsultorio;
        this.tipoDeConsultorio = tipoDeConsultorio;
        this.idEmpleado = idEmpleado;
        this.extensionTelefono = extensionTelefono;
        this.estado = estado;
        this.causa = causa;
    }

    // idConsultorio

    public Integer getIdConsultorio(){
        return idConsultorio;
    }

    public void setIdConsultorio(Integer idConsultorio){
        this.idConsultorio = idConsultorio;
    }

    // Tipo de Consultorio

    public String getTipoDeConsultorio(){
        return tipoDeConsultorio;
    }

    public void setTipoDeConsultorio(String tipoDeConsultorio){
        this.tipoDeConsultorio = tipoDeConsultorio;
    }

    // idEmpleado

    public Empleado getIdEmpleado(){
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado){
        this.idEmpleado = idEmpleado;
    }

    // Extensión telefono.

    public Integer getExtensionTelefono(){
        return extensionTelefono;
    }

    public void setExtensionTelefono(Integer extensionTelefono){
        this.extensionTelefono = extensionTelefono;
    }

    // Estado

    public boolean getEstado(){
        return estado;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    // Causa

    public String getCausa(){
        return causa;
    }

    public void setCausa(String causa){
        this.causa = causa;
    }

    // información del consultorio

    public void getInfoConsultorio(){
        JOptionPane.showMessageDialog(null, "Tipo de consultorio: "+ tipoDeConsultorio +"\n"+
                                                                "Extensión de telefono :"+extensionTelefono+"\n"+
                                                                "Causa: "+ ((estado) ? "Activo": "Inactivo, (" + causa +")"));
    }
}
