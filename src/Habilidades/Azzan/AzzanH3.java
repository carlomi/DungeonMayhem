package Habilidades.Azzan;

import Habilidades.Habilidad;
import Player.Player;
import java.util.List;
import java.util.Scanner;

public class AzzanH3 implements Habilidad {

    @Override
    public void usarHabilidad(List<Player> players) {
        Scanner scanner = new Scanner(System.in);
        Player currentPlayer = players.get(0); // Ajustar esto según la lógica del juego

        System.out.println("Seleccione el oponente con el que desea intercambiar puntos de vida:");
        int index = 1;
        for (Player opponent : players) {
            if (!opponent.equals(currentPlayer)) {
                System.out.println(index + ". " + opponent.getName() + " - Puntos de vida: " + opponent.getHealth());
                index++;
            }
        }

        int selectedIndex = scanner.nextInt() - 1;

        Player selectedOpponent = null;
        index = 0;
        for (Player opponent : players) {
            if (!opponent.equals(currentPlayer)) {
                if (index == selectedIndex) {
                    selectedOpponent = opponent;
                    break;
                }
                index++;
            }
        }

        if (selectedOpponent != null) {
            int tempHealth = currentPlayer.getHealth();
            currentPlayer.setHealth(selectedOpponent.getHealth());
            selectedOpponent.setHealth(tempHealth);

            currentPlayer.getMediator().notificar("Habilidad utilizada: Intercambiar puntos de vida con " + selectedOpponent.getName(), currentPlayer);
        } else {
            System.out.println("Oponente no válido seleccionado.");
        }
    }
}
