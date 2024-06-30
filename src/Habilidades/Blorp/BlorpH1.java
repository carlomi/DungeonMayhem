package Habilidades.Blorp;

import Habilidades.Habilidad;
import Player.Player;
import java.util.List;

public class BlorpH1 implements Habilidad {

    @Override
    public void usarHabilidad(List<Player> players) {
        Player currentPlayer = players.get(0); // Ajustar esto según la lógica del juego
        currentPlayer.getMediator().notificar("Habilidad utilizada: Este turno, los ataques ignoran los escudos", currentPlayer);
        // Aquí podrías ajustar el estado del juego para que los ataques ignoren los escudos este turno.
    }
}
