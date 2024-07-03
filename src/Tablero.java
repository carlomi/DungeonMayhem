import Cartas.Carta;
import Player.*;
import Player.Player;
import Player.Personaje;

import java.util.*;

public class Tablero {
    public static List<Players> players = new ArrayList<Players>();

    private static void personajesCPU(List<Personaje> personajes){
        List<Personaje> available = new ArrayList<>();

        for (Personaje p : personajes) {
            if (!p.isEnUso()) {
                available.add(p);
                p.setEnUso(true);
            }
        }

        players.addLast(new CPU("Carlomi", available.get(0)));
        players.addLast(new CPU("Jimbito", available.get(1)));
        players.addLast(new CPU("Sagabi", available.get(2)));
        players.addLast(new CPU("Rex", available.get(3)));
        players.addLast(new CPU("Tony", available.get(4)));
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
        personajes.get(seleccion-1).setEnUso(true);
        return personajes.get(seleccion-1);
    }

    public static void crearJugador(List<Personaje> personajes){
        Scanner sc = new Scanner(System.in);
        String nombre;
        Personaje personaje;
        System.out.println("Ingresa tu nombre: ");
        nombre = sc.nextLine();
        personaje = seleccionarPersonaje(personajes);
        players.addFirst(new Player(nombre, personaje));
        personajesCPU(personajes);

        for (Players p : players){
            p.setOponentes(players);
        }
    }

    public static void imprimirJugadores(){
        for (Players p : players) {
            System.out.println("Jugador: " + p.getName());
            Personaje personaje = p.getPersonaje();
            System.out.println("Personaje Seleccionado: " + personaje.getNombre());
        }
    }

    public static void empezarPartida(){
        int Cartas = 0;

        for (Players p : players) {
            p.mezclarMazo();
            p.tomarCarta(3);
        }

        while (players.get(0).getHealth() > 0 && players.size() > 1)
        {
            for (Players p : players ) {
                p.setTurnos(1);
                p.tomarCarta();
                p.takeTurn();
                }
            }
        }
    }
