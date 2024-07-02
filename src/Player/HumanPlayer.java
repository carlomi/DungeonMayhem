package Player;

import Mediator.GameMediator;
import Main.Game;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, Personaje personaje, GameMediator mediator, Game game) {
        super(name, personaje, mediator, game);
    }

    @Override
    public void drawCard() {
        // Implementar lógica para que el jugador humano tome una carta
    }

    @Override
    public void playCard() {
        // Implementar lógica para que el jugador humano juegue una carta
    }

    @Override
    public void chooseCharacter() {
        // Implementar lógica para que el jugador humano elija un personaje
    }
}
