package tda;

import java.util.LinkedList;
import java.util.Queue;

public class Fila<TIPO>{
    Queue<TIPO> fila;
    
    public Fila(){
        this.fila = new LinkedList<TIPO>(); 
    }
    
    public boolean insertar(TIPO elemento) {
        try {
            return fila.add(elemento);
        } catch (IllegalStateException e) {
            System.err.println("Error: la fila está llena.");
            return false;
        }
    }

    public TIPO eliminar() {
        return fila.poll();
    }

    public TIPO frente() {
        return fila.peek();
    }

    public boolean filaVacia() {
        return fila.isEmpty();
    }
}
