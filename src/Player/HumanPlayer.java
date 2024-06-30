package Player;


import Mediator.GameMediator;
import Main.Game;
import Cartas.Carta;
import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, Personaje personaje, GameMediator mediator, Game game) {
        super(name, personaje, mediator, game);
    }

    @Override
    public void drawCard() {
        if (!getMazo().isEmpty()) {
            Carta carta = getMazo().remove(0);
            getMano().add(carta);
            System.out.println(getName() + " ha tomado una carta: " + carta.getNombre());
        } else {
            System.out.println("El mazo está vacío.");
        }
    }

    @Override
    public void playCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige una carta para jugar:");
        for (int i = 0; i < getMano().size(); i++) {
            System.out.println((i + 1) + ". " + getMano().get(i).getNombre());
        }
        int choice = scanner.nextInt();
        if (choice > 0 && choice <= getMano().size()) {
            Carta carta = getMano().remove(choice - 1);
            getCartasActivas().add(carta);
            System.out.println(getName() + " ha jugado la carta: " + carta.getNombre());
        } else {
            System.out.println("Selección no válida.");
        }
    }

    @Override
    public void chooseCharacter() {
        System.out.println(getName() + " ha elegido el personaje: " + getPersonaje().getNombre());
    }
}
