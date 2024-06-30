package Habilidades.Delilah;


import Habilidades.Habilidad;
import Player.Player;
import java.util.List;

public class DelilahH2 implements Habilidad {

    @Override
    public void usarHabilidad(List<Player> opponents) {
        Player currentPlayer = opponents.get(0);
        currentPlayer.getMediator().setShieldsControlledByPlayer(currentPlayer, true);
        currentPlayer.getMediator().notificar("Habilidad utilizada: Hasta tu próximo turno, eliges el objetivo de todas las cartas de escudo", currentPlayer);
    }
}
