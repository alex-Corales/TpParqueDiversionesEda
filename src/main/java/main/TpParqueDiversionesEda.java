package main;

import tda.Fila;

public class TpParqueDiversionesEda {
    
    
    /*
    Registro de entrada de visitantes: Cuando un visitante llega al parque, se
    agrega a la cola general de entrada. Cada visitante tiene un identificador único
    */
    
    public static boolean registrarEntrada(Visitante vis) {
        if (visitantesActuales >= capacidadMaxima) {
            System.out.println("El parque está lleno");
            return false;
        }
        visitante.insertar(vis);
        visitantesActuales++;
        return true;
    }
    
    /*Despedir visitante, para no decir eliminar porque parece que lo matamos.
    Se recorre la fila y si se encuentra, se quita de la lista principal.
    Ahora al no estar en la fila podemos decir que no se encuentra en el parque.
    */
    
    public static void despedirVisitante(Visitante persona){
        for (int i = 0; i < visitante.verTamanio(); i++) {
            if (visitante.frente() == persona)
                visitante.eliminar();
        }
        visitantesActuales--;
    }
    
    /*
    Busqueda de personas por nombre dentro de la fila general del parque.
    Si la persona esta dentro de la fila, es porque se encuentra dentro del parque.
    */
    
    public static boolean BuscarVisitante(String nombre){
        boolean esta = false;
        for (int i = 0; i < visitante.verTamanio(); i++) {
            if (visitante.frente().getNombre().equalsIgnoreCase(nombre))
                esta = true;
        }
        return esta;
    }
    
    /* Se declara la fila visitante fuera del main para que sean accesibles
    desde los metodos definidos.
    */
    
    static Fila<Visitante> visitante = new Fila();
    static int capacidadMaxima = 100; 
    static int visitantesActuales = 0;
    
    public static void main(String[] args) {
       
    }
    
}
