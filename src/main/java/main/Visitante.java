package main;

public class Visitante {
    private int idVisitante;
    private String nombre;

    public Visitante(int idVisitante, String nombre) {
        this.idVisitante = idVisitante;
        this.nombre = nombre;
    }

    public int getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(int idVisitante) {
        this.idVisitante = idVisitante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
