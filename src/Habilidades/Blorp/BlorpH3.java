package Habilidades.Blorp;



import Habilidades.Habilidad;
import Player.Player;
import java.util.List;

public class BlorpH3 implements Habilidad {

    @Override
    public void usarHabilidad(List<Player> players) {
        Player currentPlayer = players.get(0);
        currentPlayer.getMediator().notificar("Habilidad utilizada: Atacar dos veces cuando una carta sea destruida", currentPlayer);
    }
}
