package main;

public class Visitante {
    private String nombre;

    public Visitante() {
    }
    
    public Visitante(int idVisitante, String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
