package Habilidades.Azzan;

import Habilidades.AbstractHabilidad;
import Player.Players;
import Mediator.GameMediator;

import java.util.List;

public class AzzanH1 extends AbstractHabilidad {

    @Override
    public void usarHabilidad(List<Players> jugadores) {
        int damage = 3;

        for(Players p : jugadores){
            GameMediator.attack(p,damage);
        }
        System.out.println("Todos los jugadores fueron atacados 3 veces.");
    }
}
