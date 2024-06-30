package Habilidades.Blorp;



import Habilidades.Habilidad;
import Player.Player;
import java.util.List;

public class BlorpH3 implements Habilidad {

    @Override
    public void usarHabilidad(List<Player> players) {
        Player currentPlayer = players.get(0); // Ajustar esto según la lógica del juego
        currentPlayer.getMediator().notificar("Habilidad utilizada: Atacar dos veces cuando una carta sea destruida", currentPlayer);
        // Aquí podrías ajustar el estado del juego para que el jugador actual ataque dos veces cuando una carta sea destruida.
    }
}
