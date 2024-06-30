package Habilidades.Delilah;

import Habilidades.Habilidad;
import Player.Player;
import java.util.List;

public class DelilahH3 implements Habilidad {

    @Override
    public void usarHabilidad(List<Player> opponents) {
        Player currentPlayer = opponents.get(0); // Ajustar esto según la lógica del juego

        for (Player opponent : opponents) {
            if (!opponent.equals(currentPlayer) && opponent.getMano().isEmpty()) {
                opponent.setEscudos(opponent.getEscudos() + 1);
            }
        }

        for (Player player : opponents) {
            player.getCartasActivas().clear();
        }
        currentPlayer.getCartasActivas().clear();
        currentPlayer.getMediator().notificar("Habilidad utilizada: Dar escudos a oponentes sin cartas en juego y destruir todas las cartas", currentPlayer);
    }
}
