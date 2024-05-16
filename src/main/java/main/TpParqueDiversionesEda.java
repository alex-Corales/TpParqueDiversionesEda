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
    
    public static Visitante BuscarVisitante(String nombre){
        Visitante encontrado = null;
        for (int i = 0; i < visitante.verTamanio(); i++) {
            if (visitante.frente().getNombre().equalsIgnoreCase(nombre))
                encontrado = visitante.frente();
            visitante.insertar(visitante.eliminar());
        }
        return encontrado;
    }
    
    
    /* Se declara la fila visitante fuera del main para que sean accesibles
    desde los metodos definidos.
    */
    
    static Fila visitante = new Fila();
    static int capacidadMaxima = 100; 
    static int visitantesActuales = 0;
    static Atraccion[] atracciones;
    
    public static void main(String[] args) {
        int opc = 0;
        int subopc = 0;
        Visitante vis = new Visitante(); 
        Scanner scan = new Scanner(System.in);
        
        do{
            System.out.println("1 - Ingresar visitante al parque");
            System.out.println("2 - Buscar visitante en el parque");
            System.out.println("3 - Despedir visitante del parque");
            System.out.println("4 - Atracciones");
            System.out.println("5 - Salir");
            opc = scan.nextInt();
            
            switch(opc){
                case 1:
                    System.out.println("Ingrese los datos del visitante: ");
                    System.out.print("Identificador: ");
                    int identificador = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scan.nextLine();
                    registrarEntrada(new Visitante(identificador, nombre));
                    break;
                    
                case 2:
                    System.out.print("Ingrese el nombre del visitante que desea buscar -->");
                    scan.nextLine();
                    String nombreBuscar = scan.nextLine();
                    Visitante encontrado = BuscarVisitante(nombreBuscar);
                    if (encontrado!=null) System.out.println(encontrado.getNombre()+" Se encuentra en el parque");
                    else System.out.println(nombreBuscar+" No se encuentra en nuestras instalaciones");
                    break;
                    
                case 3:
                    System.out.print("Ingrese el nombre del visitante que desea despedir --> ");
                    scan.nextLine();
                    Visitante despedir = BuscarVisitante(scan.nextLine());
                    if (despedir != null){
                        if(despedirVisitante(despedir)) System.out.println("Se despidio correctamente a"+despedir.getNombre());
                        else System.out.println("No se pudo despedir a"+despedir.getNombre()+". Parece que no quiere irse");
                    }else System.out.println("No se ha encontrado a esa persona dentro del parque");
                    break;
                    
                case 4:
                    do{
                        System.out.println("1 - Crear Atracciones");
                        System.out.println("2 - Ingresar visitante a una atraccion");
                        System.out.println("3 - Remover a visitante de una atraccion");
                        System.out.println("4 - Volver al menu principal");
                        subopc = scan.nextInt();
                    
                        switch(subopc){
                            case 1:
                                if (atracciones == null){
                                    System.out.print("Ingrese la cantidad de atracciones a crear -->");
                                    atracciones = new Atraccion[scan.nextInt()];
                                    scan.nextLine();
                                    
                                    for(int i=0; i<atracciones.length; i++){
                                        System.out.print("Ingrese el nombre de la atraccion -->");
                                        atracciones[i]= new Atraccion();
                                        atracciones[i].setNombre(scan.next());
                                    }
                                }
                                else System.out.println("Las atracciones ya fueron creadas con anterioridad");
                                break;
                                
                            case 2:
                                System.out.println("Ingrese el nombre de la atraccion");
                                
                                for (int i = 0; i < atracciones.length; i++) {
                                    if(atracciones[i].getNombre().equalsIgnoreCase(scan.next())){
                                        System.out.print("Ingrese el nombre de la persona a ingresar a la Atraccion -->");
                                        Visitante ingresante = BuscarVisitante(scan.next());
                                        if(ingresante != null){
                                            atracciones[i].IngresarVisitante(ingresante);
                                            System.out.println("Se ha ingresado a "+ingresante.getNombre()+" a la atraccion "+atracciones[i].getNombre());
                                        }else{
                                            System.out.println("No se ha encontrado a la persona dentro del parque");
                                        }
                                    }
                                }
                                break;
                                
                            case 3:
                                System.out.println("Ingrese el nombre de la atraccion");
                                
                                for (int i = 0; i < atracciones.length; i++) {
                                    if(atracciones[i].getNombre().equalsIgnoreCase(scan.next())){
                                        System.out.print("Ingrese el nombre de la persona que se retira de la Atraccion -->");
                                        Visitante ingresante = BuscarVisitante(scan.next());
                                        if(ingresante != null){
                                            atracciones[i].EliminarVisitante(ingresante);
                                            System.out.println(ingresante.getNombre()+" se ha retirado de a la atraccion "+atracciones[i].getNombre());
                                        }else{
                                            System.out.println("No se ha encontrado a la persona dentro del parque");
                                        }
                                    }
                                }
                                
                                break;
                                
                            default:
                                System.out.println("Opcion no valida !");
                                break;
                        }
                    
                    }while (subopc != 4);
                    break;
                    
                default:
                    System.out.println("Opcion no valida !");
            }
        }while(opc != 5);
    }
    
}
