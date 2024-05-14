package main;

import tda.Fila;

public class TpParqueDiversionesEda {
    
    
    /*
    Registro de entrada de visitantes: Cuando un visitante llega al parque, se
    agrega a la cola general de entrada. Cada visitante tiene un identificador único
    */
    
    public static void agregarVisitante(Fila visitante, int idVisitante, String nombre){
        visitante.insertar(new Visitante(idVisitante, nombre));
    }
    
    /*
    Control de capacidad general: El sistema debe verificar periódicamente si el
    número total de visitantes dentro del parque ha alcanzado la capacidad máxima
    permitida. Si es así, el sistema debe detener temporalmente la entrada de nuevos
    visitantes hasta que haya suficiente espacio disponible dentro del parque.
    */
    
    public static void controlCapacidad(){
        
    }
    
    public static void main(String[] args) {
        Fila<Visitante> visitante = new Fila();
    }
}
