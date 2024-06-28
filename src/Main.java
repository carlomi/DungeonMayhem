import Cartas.Carta;
import Player.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Mediator.GameMediator;

import static Player.Personaje.*;

public class Main {
    public static List<Player> players = new ArrayList<Player>();
    public static List<Personaje> personajes = new ArrayList<Personaje>();

    public static void main(String[] args) {
        personajes = generarPersonajes();
        crearJugador(personajes);
        imprimirJugadores();

    }


    public static Personaje seleccionarPersonaje(List<Personaje> personajes){
        Scanner sc = new Scanner(System.in);
        int seleccion;
        System.out.println("Seleccione el personaje que desea: ");
        System.out.println();

        int i = 1;
        for(Personaje p : personajes)
        {
            if (!p.isEnUso()) {
                System.out.println("Opcion numero " + i + ": ");
                System.out.println("Personaje: " + p.getNombre());
                System.out.println("Descripcion: " + p.getDescripcion());
                System.out.println("Color " + p.getColor());
                System.out.println("--------------------------------------");
            }
            i++;
        }
        seleccion = sc.nextInt();
        return personajes.get(seleccion-1);
    }

    public static void crearJugador(List<Personaje> personajes){
        Scanner sc = new Scanner(System.in);
        String nombre;
        Personaje personaje;

        System.out.println("Ingresa tu nombre: ");
        nombre = sc.nextLine();

        personaje = seleccionarPersonaje(personajes);

        players.add(new Player(nombre, personaje));
    }

    public static void imprimirJugadores(){
        for (Player p : players) {
            System.out.println("Jugador: " + p.getName());
            Personaje personaje = p.getPersonaje();
            System.out.println("Personaje Seleccionado: " + personaje.getNombre());
        }
    }
}