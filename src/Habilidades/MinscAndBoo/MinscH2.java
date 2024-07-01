package Habilidades.MinscAndBoo;

import Player.Player;
import Habilidades.AbstractHabilidad;

import java.util.List;

public class MinscH2 extends AbstractHabilidad {
    @Override
    public void usarHabilidad(List<Player> jugadores) {
        int numJugadores = jugadores.size();

        // Guardar los puntos de vida actuales
        int[] puntosVida = new int[numJugadores];
        for (int i = 0; i < numJugadores; i++) {
            puntosVida[i] = jugadores.get(i).getHealth();
        }

        // Pasar los puntos de vida al jugador a la derecha
        for (int i = 0; i < numJugadores; i++) {
            int indexDerecha = (i + 1) % numJugadores;
            jugadores.get(indexDerecha).setHealth(puntosVida[i]);
        }
    }
}
