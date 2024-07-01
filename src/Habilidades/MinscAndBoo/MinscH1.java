package Habilidades.MinscAndBoo;

import Cartas.Carta;
import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

public class MinscH1 extends AbstractHabilidad {
    @Override
    public void usarHabilidad(List<Player> oponentes) {
        // Asumir que el jugador actual es el primero en la lista
        Player jugadorActual = oponentes.get(0);

        // Iterar sobre todos los oponentes
        for (Player oponente : oponentes) {
            // Robar una carta del mazo de cada oponente
            Carta cartaRobada = oponente.robar();
            jugadorActual.robarCarta(cartaRobada);
        }
    }
}
