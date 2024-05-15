package main;

import java.util.Scanner;
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
    
    public static boolean despedirVisitante(Visitante persona){
        boolean estado = false;
        for (int i = 0; i < visitante.verTamanio(); i++) {
            if (visitante.frente().getNombre().equals(persona.getNombre())){
                visitante.eliminar();
                estado = true;
            }
        }
        visitantesActuales--;
        return estado;
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
        int opc = 0;
        Visitante vis = new Visitante(); 
        Scanner scan = new Scanner(System.in);
        
        do{
            System.out.println("1 - Ingresar visitante al parque");
            System.out.println("2 - Buscar visitante en el parque");
            System.out.println("3 - despedir visitante del parque");
            System.out.println("4 - Salir");
            opc = scan.nextInt();
            
            switch(opc){
                case 1:
                    System.out.println("Ingrese los datos del visitante: ");
                    System.out.println("Identificador");
                    int identificador = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Nombre: ");
                    String nombre = scan.nextLine();
                    registrarEntrada(new Visitante(identificador, nombre));
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del visitante que desea buscar");
                    scan.nextLine();
                    String nombreBuscar = scan.nextLine();
                    if (BuscarVisitante(nombreBuscar)) System.out.println("Se encuentra en el parque");
                    break;
                case 3:
                    System.out.println("Ingrese los datos del visitante que desea despedir: ");
                    System.out.println("Identificador");
                    vis.setIdVisitante(scan.nextInt()); 
                    scan.nextLine();
                    System.out.println("Nombre: ");
                    vis.setNombre(scan.nextLine());
                    if(despedirVisitante(vis)) System.out.println("Se despidio correctamente");
                    else System.out.println("No se pudo despedir");
                    break;
                default:
                    throw new AssertionError();
            }
        }while(opc != 4);
    }
    
}
