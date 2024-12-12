package com.ldss.proyectosandroid.home_spa.adaptador;

public class Calificacion {

    String opinion;
    float estrellas;

    String fecha;

    public float getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(float estrellas) {
        this.estrellas = estrellas;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + "\n" +  // Salto de línea después de la fecha
                "Reseña: " + opinion + "\n" + // Salto de línea después de la reseña
                "Puntuación: " + estrellas + " ★"; // Muestra las estrellas al final
    }

}
