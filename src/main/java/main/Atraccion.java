package main;

import tda.Fila;

public class Atraccion {
    private Fila<Visitante> visitantes = new Fila<>();
    
    public Atraccion(){
        visitantes = new Fila<Visitante>();
    }

    public Fila<Visitante> getVisitante() {
        return visitantes;
    }

    public void setVisitante(Fila<Visitante> visitante) {
        this.visitantes = visitante;
    }
    
    public void IngresarVisitante(Visitante visitante){
        visitantes.insertar(visitante);
    }
    
    public void EliminarVisitante(){
        visitantes.eliminar();
    }
    
    
}
