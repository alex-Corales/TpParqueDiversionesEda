package main;

import tda.Fila;

public class Atraccion {
    private Fila<Visitante> visitante;
    
    public Atraccion(){
        visitante = new Fila<Visitante>();
    }

    public Fila<Visitante> getVisitante() {
        return visitante;
    }

    public void setVisitante(Fila<Visitante> visitante) {
        this.visitante = visitante;
    }
    
    
}
