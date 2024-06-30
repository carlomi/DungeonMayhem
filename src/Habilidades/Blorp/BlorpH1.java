package Habilidades.Blorp;

import Habilidades.Habilidad;
import Player.Player;
import java.util.List;

public class BlorpH1 implements Habilidad {

    @Override
    public void usarHabilidad(List<Player> players) {
        Player currentPlayer = players.get(0);
        currentPlayer.getMediator().notificar("Habilidad utilizada: Este turno, los ataques ignoran los escudos", currentPlayer);

    }
}
