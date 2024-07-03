package Player;

import Cartas.Carta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CPU implements Players{
    private String name;
    private Personaje personaje;
    private int health;
    private int escudos;
    private int turnos;
    private List<Carta> mazo;
    private List<Carta> mano;
    private List<Carta> cartasActivas;
    private List<Carta> descartadas;
    private List<Players> oponentes;



    public CPU(String name, Personaje personaje) {
        this.name = name;
        this.personaje = personaje;
        this.health = 10;
        this.mazo = personaje.getMazo();
        this.mano = new ArrayList<>();
        this.cartasActivas = new ArrayList<>();
        this.descartadas = new ArrayList<>();
        this.oponentes = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public Personaje getPersonaje() {
        return personaje;
    }

    @Override
    public List<Carta> getMazo() {
        return mazo;
    }

    @Override
    public void setMazo(List<Carta> mazo) {
        this.mazo = mazo;
    }

    @Override
    public List<Carta> getMano() {
        return mano;
    }

    @Override
    public void setMano(List<Carta> mano) {
        this.mano = mano;
    }

    @Override
    public List<Carta> getCartasActivas() {
        return List.of();
    }

    @Override
    public void setCartasActivas(List<Carta> cartasActivas) {

    }

    @Override
    public List<Carta> getDescartadas() {
        return List.of();
    }

    @Override
    public void setDescartadas(List<Carta> descartadas) {

    }

    @Override
    public int getEscudos() {
        return escudos;
    }

    @Override
    public void setEscudos(int escudos) {
        this.escudos = escudos;
    }

    @Override
    public void mezclarMazo() {
        Collections.shuffle(mazo);
    }

    @Override
    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    @Override
    public void recibirAtaque() {
        health--;
    }

    @Override
    public void recibirAtaque(int damage) {
        health -= damage;
    }

    @Override
    public void curarse() {
        health++;
    }

    @Override
    public void curarse(int corazones) {
        health += corazones;
    }

    @Override
    public void tomarCarta() {
            mano.add(mazo.getFirst());
            mazo.remove(mazo.getFirst());
    }

    @Override
    public void tomarCarta(int cartasExtra) {
        for (int i = 0; i < cartasExtra; i++) {
            mano.add(mazo.getFirst());
            mazo.remove(mazo.getFirst());
        }
    }

    @Override
    public boolean hasShield() {
        if (escudos > 0)
            return true;
        else return false;
    }

    @Override
    public void setOponentes(List<Players> players){
        for(Players p : players){
            if (p.getName() != this.name){
                this.oponentes.add(p);
            }
        }
    }

    @Override
    public List<Players> getOponentes() {
        return oponentes;
    }

    @Override
    public void jugarCarta(Carta carta) {
        int i = 0;

        if(carta.getEspadas() > 0){
            carta.atacar(oponentes);
        }
        if (carta.getEscudos() > 0){
            escudos += carta.getEscudos();
        }
        if (carta.getCartasExtra() > 0){
            tomarCarta(carta.getCartasExtra());
        }
        if (carta.getRayos() > 0){
            turnos += carta.getRayos();
        }
        if (carta.getCorazones() > 0){
            curarse(carta.getCorazones());
        }
    }

    public void TakeTurn(){
        int index = (int)(Math.random() * mano.size());
        Carta randomElement = mano.get(index);
        jugarCarta(randomElement);
    }


}
