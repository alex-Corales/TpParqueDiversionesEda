package main;

import tda.Fila;

public class Atraccion {
    private String nombre;
    private Fila visitantes;
    
    public Atraccion(String nombre){
        visitantes = new Fila();
        this.nombre = nombre;
    }

    public Fila getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(Fila visitante) {
        this.visitantes = visitante;
    }
    
    public void IngresarVisitante(Visitante visitante){
        visitantes.insertar(visitante);
    }
    
    public void EliminarVisitantes(){
        visitantes.eliminar();
    }
    
    public void EliminarVisitante(Visitante visitante){
        try {
            while(!visitantes.filaVacia()){
            if(visitantes.frente() == visitante) visitantes.eliminar();
            visitantes.insertar(visitantes.eliminar());
            }
        } catch (Exception e) {
            System.out.println("No se pudo eliminar al visitante de la fila");
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
        
}
