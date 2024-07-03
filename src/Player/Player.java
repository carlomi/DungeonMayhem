package Player;

import Cartas.Carta;
import Cartas.CartaEspecial;
import Mediator.GameMediator;
import Observer.Observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Player implements Observer, Players {
    private String name;
    private Personaje personaje;
    private int health;
    private int escudos;
    private List<Carta> mazo;
    private List<Carta> mano;
    private List<Carta> cartasActivas;
    private List<Carta> descartadas;
    private List<Players> oponentes;
    private int turnos;


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
        this.oponentes = new ArrayList<>();
        }

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

    public int getTurnos (){
        return turnos;
    }

    @Override
    public void agregarTurnos(int turnos) {
        this.turnos += turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    //METODOS NUEVOS
    @Override
    public void tomarCarta(){
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

    public boolean hasShield (){
        if (escudos > 0)
            return true;
        else return false;
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
        if (carta.getClass() == CartaEspecial.class){
            ((CartaEspecial) carta).getHabilidad().usarHabilidad(oponentes);
        }
        turnos--;
    }

    @Override
    public void actualizar() {
        if (mano.isEmpty()) {
            tomarCarta(2);
        }
    }
     public void mezclarMazo(){
         Collections.shuffle(this.mazo);
     }

     public void takeTurn(){
        int i = 0;
        Carta cartaElegida;
        Scanner sc = new Scanner(System.in);
         while (turnos > 0) {
             System.out.println("Elige una carta: ");
             for (Carta c : mano) {
                 System.out.println((i+1)+ ". " + c.getNombre());
                 System.out.println("Espadas: " + c.getEspadas());
                 System.out.println("Escudos: " + c.getEscudos());
                 System.out.println("Rayos: " + c.getRayos());
                 System.out.println("Corazones: " + c.getCorazones());
                 System.out.println("Cartas Extra: " + c.getCartasExtra());
                 i++;
             }
             cartaElegida = mano.get(sc.nextInt() - 1);
             mano.remove(cartaElegida);
             descartadas.add(cartaElegida);

             jugarCarta(cartaElegida);
             actualizar();
             setTurnos(turnos--);
         }
     }
}
