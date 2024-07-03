package Habilidades.Sutha;

import Habilidades.AbstractHabilidad;
import Player.Players;

import java.util.List;

public class SuthaH3 extends AbstractHabilidad {
    @Override

    public void usarHabilidad(List<Player> oponentes) {
        Player jugadorActual = oponentes.get(0);
        for (Player oponente : oponentes) {
            jugadorActual.curarse(1);
            jugadorActual.atacar(oponente);
        }

    public void usarHabilidad(List<Players> opponents) {


    }
}
