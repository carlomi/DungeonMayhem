package Habilidades.Blorp;


import Habilidades.Habilidad;
import Player.Player;
import java.util.List;

public class BlorpH2 implements Habilidad {

    @Override
    public void usarHabilidad(List<Player> players) {
        Player currentPlayer = players.get(0);

        for (Player opponent : players) {
            if (!opponent.equals(currentPlayer) && opponent.getEscudos() > 0) {
                int escudos = opponent.getEscudos();
                opponent.setEscudos(0);
                currentPlayer.curarse(escudos);
                currentPlayer.getMediator().notificar("Habilidad utilizada: Destruir escudo y curar por " + escudos, currentPlayer);
                break;
            }
        }
    }
}
