package Mediator;


import Player.Player;
import java.util.ArrayList;
import java.util.List;

public class GameMediator {
    private List<Player> players;
    private Player controllingPlayer;
    private boolean shieldsControlledByPlayer;

    public GameMediator() {
        this.players = new ArrayList<>();
        this.shieldsControlledByPlayer = false;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void notificar(String mensaje, Player jugador) {
        System.out.println(mensaje + " por " + jugador.getName());
    }

    public void setShieldsControlledByPlayer(Player player, boolean control) {
        this.controllingPlayer = player;
        this.shieldsControlledByPlayer = control;
    }

    public boolean isShieldsControlledByPlayer() {
        return shieldsControlledByPlayer;
    }

    public Player getControllingPlayer() {
        return controllingPlayer;
    }
}

