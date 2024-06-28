package Habilidades.Azzan;

import Habilidades.AbstractHabilidad;
import Player.Player;

import java.util.List;

public class AzzanH1 extends AbstractHabilidad {

    @Override
    public void usarHabilidad(List<Player> jugadores) {
        int damage = 3;

        for(Player p : jugadores){
            p.recibirAtaque(damage);
        }
        System.out.println("Todos los jugadores recibieron 3 puntos de daño.");
    }

}
