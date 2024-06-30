package Habilidades.Azzan;

import Habilidades.Habilidad;
import Player.Player;
import java.util.List;

public class AzzanH1 implements Habilidad {

    @Override
    public void usarHabilidad(List<Player> jugadores) {
        int damage = 3;
        Player currentPlayer = jugadores.get(0);

        for (Player p : jugadores) {
            if (!p.equals(currentPlayer)) {
                p.recibirAtaque(damage);
            }
        }
        System.out.println("Todos los jugadores recibieron 3 puntos de daño.");
        currentPlayer.getMediator().notificar("Habilidad utilizada: Todos los jugadores recibieron 3 puntos de daño", currentPlayer);
    }
}
