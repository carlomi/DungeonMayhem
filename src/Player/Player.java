package Player;

import Cartas.Carta;
import Observer.Observer;
import Mediator.GameMediator;
import java.util.ArrayList;
import java.util.List;

public abstract class Player implements Observer {
    private String name;
    private Personaje personaje;
    private int health;
    private int escudos;
    private List<Carta> mazo;
    private List<Carta> mano;
    private List<Carta> jugada;
    private List<Carta> cartasActivas;
    private List<Carta> descartadas;
    private GameMediator mediator;
    private Object game;

    public Player(String name, GameMediator mediator, Object game) {
        this.name = name;
        this.mediator = mediator;
        this.game = game;
        this.health = 10;
        this.mazo = new ArrayList<>();
        this.mano = new ArrayList<>();
        this.jugada = new ArrayList<>();
        this.cartasActivas = new ArrayList<>();
        this.descartadas = new ArrayList<>();
    }

    public Player(String name, Personaje personaje, GameMediator mediator, Object game) {
        this.name = name;
        this.personaje = personaje;
        this.mediator = mediator;
        this.game = game;
        this.health = 10;
        this.mazo = personaje.getMazo();
        this.mano = new ArrayList<>();
        this.cartasActivas = new ArrayList<>();
        this.descartadas = new ArrayList<>();
    }

    // Métodos
    public void imprimirMazo(){
        for (Carta c : mazo) {
            System.out.println(c.getNombre());
        }
    }

    public void recibirAtaque() {
        this.health--;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void recibirAtaque(int damage){
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void curarse(){
        this.health++;
    }

    public void curarse (int corazones){
        this.health += corazones;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public List<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(List<Carta> mazo) {
        this.mazo = mazo;
    }

    public List<Carta> getMano() {
        return mano;
    }

    public void setMano(List<Carta> mano) {
        this.mano = mano;
    }

    public List<Carta> getJugada() {
        return jugada;
    }

    public void setJugada(List<Carta> jugada) {
        this.jugada = jugada;
    }

    public List<Carta> getCartasActivas() {
        return cartasActivas;
    }

    public void setCartasActivas(List<Carta> cartasActivas) {
        this.cartasActivas = cartasActivas;
    }

    public List<Carta> getDescartadas() {
        return descartadas;
    }

    public void setDescartadas(List<Carta> descartadas) {
        this.descartadas = descartadas;
    }

    public int getEscudos() {
        return escudos;
    }

    public void setEscudos(int escudos) {
        this.escudos = escudos;
    }

    public GameMediator getMediator() {
        return mediator;
    }

    public void setMediator(GameMediator mediator) {
        this.mediator = mediator;
    }

    public Object getGame() {
        return game;
    }

    public void setGame(Object game) {
        this.game = game;
    }

    public void tomarCarta(int cartasExtra) {
        for (int i = 0; i < cartasExtra; i++) {
            if (!mazo.isEmpty()) {
                mano.add(mazo.get(0));
                mazo.remove(0);
            }
        }
    }

    public boolean hasShield() {
        return escudos > 0;
    }

    @Override
    public void actualizar() {
        if (mano.isEmpty()) {
            tomarCarta(2);
        }
    }

    // Métodos abstractos
    public abstract void drawCard();
    public abstract void playCard();
    public abstract void chooseCharacter();
}
