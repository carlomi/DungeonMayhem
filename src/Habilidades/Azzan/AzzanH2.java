package Habilidades.Azzan;

import Habilidades.Habilidad;
import Player.Player;
import java.util.List;

public class AzzanH2 implements Habilidad {

    @Override
    public void usarHabilidad(List<Player> players) {
        Player currentPlayer = players.get(0);

        for (Player opponent : players) {
            if (!opponent.equals(currentPlayer) && opponent.getEscudos() > 0) {
                opponent.setEscudos(opponent.getEscudos() - 1);
                currentPlayer.setEscudos(currentPlayer.getEscudos() + 1);
                currentPlayer.getMediator().notificar("Habilidad utilizada: Tomar un escudo de un oponente y usarlo", currentPlayer);
                break;
            }
        }
    }
}
