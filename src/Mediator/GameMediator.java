package Mediator;

import Player.*;

public class GameMediator {
    public static void attack(Player attacker, Player defender, int damage) {
        if (defender.hasShield()) {
            if (damage == defender.getEscudos()){
                defender.setEscudos(0);
            } else if (damage > defender.getEscudos()) {
                int remainder = damage - defender.getEscudos();
                defender.setEscudos(0);
                defender.recibirAtaque(remainder);
            }
        } else {
            defender.recibirAtaque(damage);
        }
    }
}
