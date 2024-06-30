package Habilidades.Lia;


import Habilidades.Habilidad;
import Player.Player;
import java.util.List;

public class LiaH1 implements Habilidad {

    @Override
    public void usarHabilidad(List<Player> opponents) {
        Player currentPlayer = opponents.get(0);

        for (Player opponent : opponents) {
            if (!opponent.equals(currentPlayer) && opponent.getEscudos() > 0) {
                opponent.setEscudos(0);
            }
        }

        currentPlayer.getMediator().notificar("Habilidad utilizada: Destruir todas las cartas de escudo", currentPlayer);
    }
}
