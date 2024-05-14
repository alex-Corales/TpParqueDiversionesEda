package main;

import tda.Fila;

public class ParqueDeDiversiones {
    private int capacidadMaxima;
    private int visitantesActuales;
    private Fila<Visitante> filaGeneral;

    public ParqueDeDiversiones(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.visitantesActuales = 0;
        this.filaGeneral = new Fila<>();
    }

    public boolean registrarEntrada(Visitante visitante) {
        if (visitantesActuales >= capacidadMaxima) {
            System.out.println("El parque está lleno");
            return false;
        }
        filaGeneral.insertar(visitante);
        visitantesActuales++;
        return true;
    }

    public void registrarSalida(Visitante visitante) {
        
    }

}

