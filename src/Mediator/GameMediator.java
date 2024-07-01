package Mediator;

import Player.*;
import Cartas.Carta;

//cambie el mediator para que la habilidad 3 de minsc pudiera usarse
//ahi lo dejo cualquier cosa lo cambian
//por si no les parece

public class GameMediator {
    public static void attack(Player attacker, Player defender, int damage) {
        if (defender.hasShield()) {
            int totalShieldValue = defender.getEscudos().stream().mapToInt(Carta::getEscudos).sum();

            if (damage == totalShieldValue) {
                defender.getEscudos().clear();
            } else if (damage > totalShieldValue) {
                int remainder = damage - totalShieldValue;
                defender.getEscudos().clear();
                defender.recibirAtaque(remainder);
            } else {
                // Reducing the damage from shields
                int remainingDamage = damage;
                for (Carta shield : defender.getEscudos()) {
                    if (remainingDamage <= 0) break;
                    int shieldValue = shield.getEscudos();
                    if (remainingDamage >= shieldValue) {
                        remainingDamage -= shieldValue;
                    } else {
                        shield.setEscudos(shieldValue - remainingDamage);
                        remainingDamage = 0;
                    }
                }
                defender.getEscudos().removeIf(shield -> shield.getEscudos() <= 0);
            }
        } else {
            defender.recibirAtaque(damage);
        }
    }
}
