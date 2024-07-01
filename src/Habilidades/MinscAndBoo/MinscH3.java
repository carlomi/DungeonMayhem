package Habilidades.MinscAndBoo;

import Player.Player;
import Habilidades.AbstractHabilidad;

import java.util.List;

public class MinscH3 extends AbstractHabilidad {
    @Override
    public void usarHabilidad(List<Player> jugadores) {
        // Asumir que el jugador actual es el primero en la lista
        Player jugadorActual = jugadores.get(0);

        // Aumentar el daño de las cartas de escudo en 1 por este turno
        // Suponiendo que tienes un método para esto, que puede ser customizado
        jugadorActual.getEscudos().forEach(carta -> carta.setBonusDamage(1));
    }
}
