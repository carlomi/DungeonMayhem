package Player;

import Cartas.Carta;
import Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Player implements Observer {
    private String name;
    private Personaje personaje;
    private int health;
    private int escudos;
    private List<Carta> mazo;
    private List<Carta> mano;
    private List<Carta> jugada;
    private List<Carta> cartasActivas;
    private List<Carta> descartadas;


    public Player(String name) {
        this.name = name;
        this.health = 10;
    }

    public Player(String name, Personaje personaje) {
        this.name = name;
        this.personaje = personaje;
        this.health = 10;
        this.mazo = personaje.getMazo();
        this.mano = new ArrayList<>();
        this.cartasActivas = new ArrayList<>();
        this.descartadas = new ArrayList<>();
    }


    //Metodos
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

    //Getters and Setters
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

    //METODOS NUEVOS
    public void tomarCarta(int cartasExtra) {
        for (int i = 0; i < cartasExtra; i++) {
            mano.add(mazo.getFirst());
            mazo.remove(mazo.getFirst());
        }
    }

    public boolean hasShield (){
        if (escudos > 0)
            return true;
        else return false;
    }

    @Override
    public void actualizar() {
        if (mano.isEmpty()) {
            tomarCarta(2);
        }
    }
}
