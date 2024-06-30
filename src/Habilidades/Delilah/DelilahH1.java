package Habilidades.Delilah;


import Habilidades.Habilidad;
import Player.Player;
import java.util.List;
import java.util.Scanner;

public class DelilahH1 implements Habilidad {

    @Override
    public void usarHabilidad(List<Player> opponents) {
        Scanner scanner = new Scanner(System.in);
        Player currentPlayer = opponents.get(0);

        for (Player opponent : opponents) {
            if (!opponent.equals(currentPlayer)) {
                System.out.println(opponent.getName() + ", ¿quieres alabar la grandeza de " + currentPlayer.getName() + " y darle un escudo? (yes/no)");
                String respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("yes")) {
                    currentPlayer.setEscudos(currentPlayer.getEscudos() + 1);
                }
            }
        }

        currentPlayer.getMediator().notificar("Habilidad utilizada: Cada oponente puede elegir alabar tu grandeza y darte un escudo", currentPlayer);
    }
}
