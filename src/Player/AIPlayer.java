package Player;


import Mediator.GameMediator;
import Main.Game;
import Cartas.Carta;
import java.util.Random;

public class AIPlayer extends Player {

    public AIPlayer(String name, Personaje personaje, GameMediator mediator, Game game) {
        super(name, personaje, mediator, game);
    }

    @Override
    public void drawCard() {
        if (!getMazo().isEmpty()) {
            Carta carta = getMazo().remove(0);
            getMano().add(carta);
            System.out.println(getName() + " (IA) ha tomado una carta: " + carta.getNombre());
        } else {
            System.out.println("El mazo está vacío.");
        }
    }

    @Override
    public void playCard() {
        if (!getMano().isEmpty()) {
            Random rand = new Random();
            int index = rand.nextInt(getMano().size());
            Carta carta = getMano().remove(index);
            getCartasActivas().add(carta);
            System.out.println(getName() + " (IA) ha jugado la carta: " + carta.getNombre());
        } else {
            System.out.println("La mano está vacía.");
        }
    }

    @Override
    public void chooseCharacter() {
        System.out.println(getName() + " (IA) ha elegido el personaje: " + getPersonaje().getNombre());
    }
}
