package com.ldss.proyectosandroid.home_spa.adaptador;

public class Reserva {

    private String UID;
    private String fecha;
    private String hora;
    private  String nombre;
    private  String direccion;
    private  String telefono;

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String toString() {
        return "Fecha: " + fecha + "\n" +  // Salto de línea después de la fecha
                "Hora: " + hora + "\n" + // Salto de línea después de la reseña
                "Nombre: " + nombre + " ★" + // Muestra las estrellas al final
                "direccion: " + direccion + " ★" + // Muestra las estrellas al final
                "Telefono: " + telefono + " ★"; // Muestra las estrellas al final
    }
}