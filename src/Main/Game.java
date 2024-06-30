package Main;


import Player.Player;
import Mediator.GameMediator;
import java.util.List;

public class Game {
    private List<Player> players;
    private GameMediator mediator;

    public Game(List<Player> players) {
        this.players = players;
        this.mediator = new GameMediator();
        initializePlayersWithMediator();
    }

    private void initializePlayersWithMediator() {
        for (Player player : players) {
            player.setMediator(mediator);
            player.setGame(this);
        }
    }

    public void startGame() {
        // Lógica para iniciar el juego
    }

    public void nextTurn() {
        // Lógica para pasar al siguiente turno
    }

    public void aplicarEscudo(Player target) {
        if (mediator.isShieldsControlledByPlayer()) {
            Player controllingPlayer = mediator.getControllingPlayer();
            System.out.println(controllingPlayer.getName() + ", elige el objetivo del escudo en lugar de " + target.getName());
            controllingPlayer.setEscudos(controllingPlayer.getEscudos() + 1);
        } else {
            target.setEscudos(target.getEscudos() + 1);
        }
    }
}
