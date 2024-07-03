package Habilidades.Sutha;

import Cartas.Carta;
import Habilidades.AbstractHabilidad;
import Player.Players;

import java.util.List;

public class SuthaH1 extends AbstractHabilidad {
    @Override

    public void usarHabilidad(List<Player> opponents) {
        for (Player opponent : opponents) {
            if (!opponent.getEscudos().isEmpty()) {
                opponent.getEscudos().remove(0); // Eliminar la primera carta de escudo
                break; // Salir del bucle después de destruir un escudo
            }
        }

    public void usarHabilidad(List<Players> opponents) {


    }
}
