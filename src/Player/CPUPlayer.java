package Player;

import Cartas.Carta;
import Mediator.GameMediator;
import Main.Game;
import java.util.List;
import java.util.Random;

public class CPUPlayer extends Player {

    public CPUPlayer(String name, GameMediator mediator, Game game) {
        super(name, mediator, game);
    }

    public CPUPlayer(String name, Personaje personaje, GameMediator mediator, Game game) {
        super(name, personaje, mediator, game);
    }

    public void takeTurn(List<Player> opponents) {
        // Lógica para que el jugador CPU tome su turno
        Random rand = new Random();
        int action = rand.nextInt(3); // Suponiendo 3 tipos de acciones: atacar, curar, jugar carta

        switch (action) {
            case 0:
                // Atacar
                attack(opponents);
                break;
            case 1:
                // Curar
                heal();
                break;
            case 2:
                // Jugar carta
                playCard();
                break;
        }
    }

    private void attack(List<Player> opponents) {
        //lógica de ataque
        if (opponents.isEmpty()) {
            return;
        }
        Random rand = new Random();
        Player target = opponents.get(rand.nextInt(opponents.size()));
        System.out.println(getName() + " ataca a " + target.getName() + "!");
        // código de ataque aquí (por ejemplo, reducir la salud del objetivo)
        int damage = rand.nextInt(5) + 1; // Ejemplo de cálculo de daño
        target.recibirAtaque(damage);
        System.out.println(target.getName() + " recibe " + damage + " de daño.");
    }

    private void heal() {
        // la lógica de curación
        System.out.println(getName() + " se cura!");
        // código de curación aquí (por ejemplo, aumentar la salud)
        int healAmount = new Random().nextInt(5) + 1; // Ejemplo de cálculo de curación
        setHealth(getHealth() + healAmount);
        System.out.println(getName() + " se cura " + healAmount + " de salud.");
    }

    @Override
    public void playCard() {
        // lógica de jugar una carta
        System.out.println(getName() + " juega una carta!");
        // Agregar código para jugar una carta aquí
        // Ejemplo: jugar una carta aleatoria de la mano
        if (getMano().isEmpty()) {
            System.out.println(getName() + " no tiene cartas para jugar.");
            return;
        }
        Random rand = new Random();
        int cardIndex = rand.nextInt(getMano().size());
        Carta card = getMano().get(cardIndex);
        card.jugarCarta();
        getMano().remove(cardIndex);
        System.out.println(getName() + " juega " + card.getNombre() + ".");
    }

    @Override
    public void drawCard() {
        // Lógica para que el CPU tome una carta
        if (!getMazo().isEmpty()) {
            Carta carta = getMazo().remove(0);
            getMano().add(carta);
            System.out.println(getName() + " toma una carta: " + carta.getNombre());
        } else {
            System.out.println(getName() + " no tiene más cartas en el mazo.");
        }
    }

    @Override
    public void chooseCharacter() {
        // Lógica para que el CPU elija un personaje
        List<Personaje> personajesDisponibles = Personaje.generarPersonajes();
        Random rand = new Random();
        Personaje elegido = personajesDisponibles.get(rand.nextInt(personajesDisponibles.size()));
        setPersonaje(elegido);
        System.out.println(getName() + " ha elegido a " + elegido.getNombre() + ".");
    }
}


