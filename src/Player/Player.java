package Player;

import Cartas.Carta;
import Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Player implements Observer {
    private String name;
    private Personaje personaje;
    private int health;
    private List<Carta> escudos;
    private List<Carta> mazo;
    private List<Carta> mano;
    private List<Carta> jugada;
    private List<Carta> cartasActivas;
    private List<Carta> descartadas;
    private boolean puedeJugarCartaExtra;

    public Player(String name) {
        this.name = name;
        this.health = 10;
        this.escudos = new ArrayList<>();
        this.mazo = new ArrayList<>();
        this.mano = new ArrayList<>();
        this.jugada = new ArrayList<>();
        this.cartasActivas = new ArrayList<>();
        this.descartadas = new ArrayList<>();
        this.puedeJugarCartaExtra = false;
    }

    public Player(String name, Personaje personaje) {
        this.name = name;
        this.personaje = personaje;
        this.health = 10;
        this.mazo = personaje.getMazo();
        this.mano = new ArrayList<>();
        this.escudos = new ArrayList<>();
        this.cartasActivas = new ArrayList<>();
        this.descartadas = new ArrayList<>();
        this.puedeJugarCartaExtra = false;
    }

    // Métodos
    public void imprimirMazo() {
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

    public void recibirAtaque(int damage) {
        if (!escudos.isEmpty()) {
            int damageLeft = damage;
            while (damageLeft > 0 && !escudos.isEmpty()) {
                Carta shield = escudos.remove(0);
                damageLeft--;
                // Lógica adicional si se necesita al quitar un escudo
            }
            this.health -= damageLeft;
        } else {
            this.health -= damage;
        }

        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void curarse() {
        this.health++;
    }

    public void curarse(int corazones) {
        this.health += corazones;
    }

    public void atacar(Player objetivo) {
        objetivo.recibirAtaque(1); // Asumiendo que el daño por defecto es 1
    }

    public Carta robar() {
        if (!mazo.isEmpty()) {
            Carta carta = mazo.remove(0);
            mano.add(carta);
            return carta;
        }
        return null;
    }

    public void robarCarta(Carta carta) {
        if (carta != null) {
            mano.add(carta);
        }
    }

    public void descartarMano() {
        mano.clear();
    }

    // Getters and Setters
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

    public List<Carta> getEscudos() {
        return escudos;
    }

    public void setEscudos(List<Carta> escudos) {
        this.escudos = escudos;
    }

    public void tomarCarta(int cartasExtra) {
        for (int i = 0; i < cartasExtra; i++) {
            robar();
        }
    }

    public boolean hasShield() {
        return !escudos.isEmpty();
    }

    public void puedeJugarCartaExtra(boolean permitir) {
        this.puedeJugarCartaExtra = permitir;
    }

    @Override
    public void actualizar() {
        if (mano.isEmpty()) {
            tomarCarta(2);
        }
    }

    public Player seleccionarObjetivo() {
        // Lógica para seleccionar un objetivo (otro jugador)
        // Este método debe ser implementado para seleccionar adecuadamente un objetivo
        return null; // Placeholder
    }
}
