package Habilidades.MinscAndBoo;


import Player.Player;
import Player.Players;
import Habilidades.AbstractHabilidad;
import Mediator.GameMediator;

import Cartas.Carta;
import Cartas.CartaEspecial;
import Habilidades.AbstractHabilidad;
import Player.Players;


import java.util.List;

public class MinscH3 extends AbstractHabilidad {
    @Override
    public void usarHabilidad(List<Player> jugadores) {
        if (jugadores.size() < 2) return; // Asegurarse de que haya al menos un defensor

        Player atacante = jugadores.get(0); // Asumimos que el primer jugador en la lista es el que usa la habilidad

        Players defensor = (Players) jugadores.get(1); // sera el jugador que le sigue

    @Override
    public void usarHabilidad(List<Players> opponents) {


        // se cura el usuario
        atacante.curarse(1); // llamamos el metoto de curar de la clase abstracta

        // definimos el valor del dano que causara el ataque
        int damage = 2; // quitara 2 puntos de vida al jugador que le sigue

        // Usar el mediador para atacar al defensor
        GameMediator.attack(defensor, damage);
    }
}
