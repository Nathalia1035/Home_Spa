package com.ldss.proyectosandroid.home_spa.modelo;

import android.widget.EditText;

public class Registro {

    private String UID;
    private String nombreR;
    private  String apellidoR;
    private  String direccionR;
    private  String telefonoR;
    private  String passwordR;



    public String getApellidoR() {
        return apellidoR;
    }

    public void setApellidoR(String apellidoR) {
        this.apellidoR = apellidoR;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getTelefonoR() {
        return telefonoR;
    }

    public void setTelefonoR(String telefonoR) {
        this.telefonoR = telefonoR;
    }

    public String getPasswordR() {
        return passwordR;
    }

    public void setPasswordR(String passwordR) {
        this.passwordR = passwordR;
    }

    public String getNombreR() {
        return nombreR;
    }

    public void setNombreR(String nombreR) {
        this.nombreR = nombreR;
    }

    public String getDireccionR() {
        return direccionR;
    }

    public void setDireccionR(String direccionR) {
        this.direccionR = direccionR;
    }

    @Override
    public String toString(){ return "Nombre: "+ nombreR + "\n" + "Apellido: "+apellidoR + "\n" +"Direccion: " +direccionR +"\n" + "Telefono: "+ telefonoR + "\n" + "Contraseña: "+passwordR+"\n";  }
}
