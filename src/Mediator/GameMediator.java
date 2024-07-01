package Mediator;

import Player.CPUPlayer;
import Player.Player;
import Cartas.Carta;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameMediator {
    private List<Player> players;
    private Scanner scanner;
    private Player controllingPlayer;

    public GameMediator(List<Player> players) {
        this.players = players;
        this.scanner = new Scanner(System.in);
        this.controllingPlayer = null; // Inicialmente no hay jugador que controle los escudos
    }

    public GameMediator() {

    }

    public boolean isShieldsControlledByPlayer() {
        // Implementar lógica para determinar si los escudos son controlados por un jugador
        return controllingPlayer != null;
    }

    public Player getControllingPlayer() {
        // Implementar lógica para obtener el jugador que controla los escudos
        return controllingPlayer;
    }

    public void setControllingPlayer(Player player) {
        this.controllingPlayer = player;
    }

    public void startGame() {
        while (!isGameOver()) {
            Player currentPlayer = players.get(0);
            if (currentPlayer instanceof CPUPlayer) {
                ((CPUPlayer) currentPlayer).takeTurn(getOpponents(currentPlayer));
            } else {
                // Turno del jugador humano (implementar la lógica de entrada del usuario aquí)
                humanPlayerTurn(currentPlayer);
            }
            // Verificar el estado del juego después de cada turno
            if (isGameOver()) {
                break;
            }
            nextTurn();
        }
        System.out.println("El juego ha terminado.");
    }

    public void nextTurn() {
        Player currentPlayer = players.remove(0);
        players.add(currentPlayer);
    }

    private boolean isGameOver() {
        // Implementar la lógica de fin del juego
        int alivePlayers = 0;
        for (Player player : players) {
            if (player.getHealth() > 0) {
                alivePlayers++;
            }
        }
        return alivePlayers <= 1;
    }

    private List<Player> getOpponents(Player currentPlayer) {
        List<Player> opponents = new ArrayList<>(players);
        opponents.remove(currentPlayer);
        return opponents;
    }

    private void humanPlayerTurn(Player player) {
        System.out.println(player.getName() + ", es tu turno.");
        System.out.println("Selecciona una acción: 1) Atacar, 2) Curar, 3) Jugar carta, 4) Tomar carta");
        int action = scanner.nextInt();

        switch (action) {
            case 1:
                attack(player, getOpponents(player));
                break;
            case 2:
                heal(player);
                break;
            case 3:
                player.playCard();
                break;
            case 4:
                player.drawCard();
                break;
            default:
                System.out.println("Acción no válida. Turno perdido.");
        }
    }

    private void attack(Player player, List<Player> opponents) {
        if (opponents.isEmpty()) {
            return;
        }
        System.out.println("Selecciona un oponente para atacar:");
        for (int i = 0; i < opponents.size(); i++) {
            System.out.println((i + 1) + ") " + opponents.get(i).getName());
        }
        int targetIndex = scanner.nextInt() - 1;
        if (targetIndex < 0 || targetIndex >= opponents.size()) {
            System.out.println("Oponente no válido. Turno perdido.");
            return;
        }
        Player target = opponents.get(targetIndex);
        int damage = new Random().nextInt(5) + 1; // Ejemplo de cálculo de daño
        target.recibirAtaque(damage);
        System.out.println(player.getName() + " ataca a " + target.getName() + " y le causa " + damage + " de daño.");
    }

    private void heal(Player player) {
        int healAmount = new Random().nextInt(5) + 1; // Ejemplo de cálculo de curación
        player.curarse(healAmount);
        System.out.println(player.getName() + " se cura " + healAmount + " de salud.");
    }
}
