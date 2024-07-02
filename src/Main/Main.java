package Main;

import Player.CPUPlayer;
import Player.HumanPlayer;
import Player.Player;
import Player.Personaje;
import Mediator.GameMediator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Player> players = new ArrayList<>();
    public static List<Personaje> personajes = new ArrayList<>();

    public static void main(String[] args) {
        personajes = Personaje.generarPersonajes();
        GameMediator mediator = new GameMediator(players);
        Game game = new Game(players);

        crearJugador(personajes, mediator, game);
        crearJugadoresAI(personajes, mediator, game);
        imprimirJugadores();

        game.startGame();
    }

    public static Personaje seleccionarPersonaje(List<Personaje> personajes) {
        Scanner sc = new Scanner(System.in);
        int seleccion;
        System.out.println("Seleccione el personaje que desea: ");
        System.out.println();

        int i = 1;
        for (Personaje p : personajes) {
            if (!p.isEnUso()) {
                System.out.println("Opcion numero " + i + ": ");
                System.out.println("Personaje: " + p.getNombre());
                System.out.println("Descripcion: " + p.getDescripcion());
                System.out.println("Color: " + p.getColor());
                System.out.println("--------------------------------------");
            }
            i++;
        }
        seleccion = sc.nextInt();
        return personajes.get(seleccion - 1);
    }

    public static void crearJugador(List<Personaje> personajes, GameMediator mediator, Game game) {
        Scanner sc = new Scanner(System.in);
        String nombre;
        Personaje personaje;

        System.out.println("Ingresa tu nombre: ");
        nombre = sc.nextLine();

        personaje = seleccionarPersonaje(personajes);
        personaje.setEnUso(true);
        players.add(new HumanPlayer(nombre, personaje, mediator, game));
    }

    public static void crearJugadoresAI(List<Personaje> personajes, GameMediator mediator, Game game) {
        for (int i = 1; i <= 3; i++) {
            Personaje personaje = seleccionarPersonaje(personajes);
            personaje.setEnUso(true);
            players.add(new CPUPlayer("AI Player " + i, personaje, mediator, game));
        }
    }

    public static void imprimirJugadores() {
        for (Player p : players) {
            System.out.println("Jugador: " + p.getName());
            Personaje personaje = p.getPersonaje();
            System.out.println("Personaje Seleccionado: " + personaje.getNombre());
        }
    }
}
