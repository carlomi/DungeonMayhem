package Habilidades.Sutha;

import Habilidades.AbstractHabilidad;
import Player.Players;

import java.util.List;

public class SuthaH2 extends AbstractHabilidad {
    @Override

    public void usarHabilidad(List<Player> jugadores) {
        for (Player jugador : jugadores) {
            // Cada jugador descarta su mano
            jugador.descartarMano();

    public void usarHabilidad(List<Players> opponents) {


            // Luego roba tres cartas
            for (int i = 0; i < 3; i++) {
                jugador.robarCarta(jugador.getMazo().remove(0));
            }
        }
    }
}
