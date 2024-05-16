package tda;

import java.util.LinkedList;
import java.util.Queue;
import main.Visitante;

public class Fila{
    Queue<Visitante> fila;
    
    public Fila(){
        this.fila = new LinkedList<Visitante>(); 
    }
    
    public boolean insertar(Visitante elemento) {
        try {
            return fila.add(elemento);
        } catch (IllegalStateException e) {
            System.err.println("Error: la fila está llena.");
            return false;
        }
    }

    public Visitante eliminar() {
        return fila.poll();
    }

    public Visitante frente() {
        return fila.peek();
    }

    public boolean filaVacia() {
        return fila.isEmpty();
    }
    
    public int verTamanio(){
        return fila.size();
    }
    
    
}
