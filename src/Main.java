import Cartas.Carta;
import Player.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Mediator.GameMediator;

import static Player.Personaje.*;

public class Main {
    public static List<Personaje> personajes = new ArrayList<Personaje>();

    public static void main(String[] args) {
        personajes = generarPersonajes();
        Tablero.crearJugador(personajes);
        Tablero.imprimirJugadores();

        Tablero.empezarPartida();
    }
}