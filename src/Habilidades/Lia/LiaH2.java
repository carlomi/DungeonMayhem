package Habilidades.Lia;


import Habilidades.Habilidad;
import Player.Player;
import Cartas.Carta;
import java.util.List;
import java.util.Scanner;

public class LiaH2 implements Habilidad {

    @Override
    public void usarHabilidad(List<Player> opponents) {
        Scanner scanner = new Scanner(System.in);
        Player currentPlayer = opponents.get(0);

        System.out.println("Seleccione una carta de la pila de descarte para ponerla en su mano:");
        List<Carta> discardPile = currentPlayer.getDescartadas();
        for (int i = 0; i < discardPile.size(); i++) {
            System.out.println((i + 1) + ". " + discardPile.get(i).getNombre());
        }

        int selectedIndex = scanner.nextInt() - 1;
        if (selectedIndex >= 0 && selectedIndex < discardPile.size()) {
            Carta selectedCard = discardPile.remove(selectedIndex);
            currentPlayer.getMano().add(selectedCard);
            currentPlayer.getMediator().notificar("Habilidad utilizada: Elegir una carta de la pila de descarte y ponerla en la mano", currentPlayer);
        } else {
            System.out.println("Selección inválida.");
        }
    }
}
