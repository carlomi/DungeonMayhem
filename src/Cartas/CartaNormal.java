package Cartas;

import Player.Player;

public class CartaNormal implements Carta {
    private String nombre;
    private Player owner;
    private int espadas;
    private int corazones;
    private int escudos;
    private int rayos;
    private int cartasExtra;
    private int bonusDamage; // Campo para almacenar el daño extra

    // Constructores
    public CartaNormal(String nombre, Player owner, int espadas, int corazones, int escudos, int rayos, int cartasExtra) {
        this.nombre = nombre;
        this.owner = owner;
        this.espadas = espadas;
        this.corazones = corazones;
        this.escudos = escudos;
        this.rayos = rayos;
        this.cartasExtra = cartasExtra;
        this.bonusDamage = 0; // Valor por defecto
    }

    public CartaNormal(Player owner, int espadas, int corazones, int escudos, int rayos, int cartasExtra) {
        this.owner = owner;
        this.espadas = espadas;
        this.corazones = corazones;
        this.escudos = escudos;
        this.rayos = rayos;
        this.cartasExtra = cartasExtra;
        this.bonusDamage = 0; // Valor por defecto
    }

    public CartaNormal(String nombre, Player owner) {
        this.nombre = nombre;
        this.owner = owner;
        this.bonusDamage = 0; // Valor por defecto
    }

    public CartaNormal(Player owner) {
        this.owner = owner;
        this.bonusDamage = 0; // Valor por defecto
    }

    public CartaNormal(String owner, int espadas, int corazones, int escudos, int rayos, int cartasExtra) {
        this.bonusDamage = 0; // Valor por defecto
    }

    public CartaNormal(String nombre, String owner, int espadas, int corazones, int escudos, int rayos, int cartasExtra) {
    }

    // Getters and Setters
    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getEspadas() {
        return espadas;
    }

    public void setEspadas(int espadas) {
        this.espadas = espadas;
    }

    public int getCorazones() {
        return corazones;
    }

    public void setCorazones(int corazones) {
        this.corazones = corazones;
    }

    public int getEscudos() {
        return escudos;
    }

    public void setEscudos(int escudos) {
        this.escudos = escudos;
    }

    public int getRayos() {
        return rayos;
    }

    public void setRayos(int rayos) {
        this.rayos = rayos;
    }

    public int getCartasExtra() {
        return cartasExtra;
    }

    public void setCartasExtra(int cartasExtra) {
        this.cartasExtra = cartasExtra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int getBonusDamage() {
        return bonusDamage;
    }

    @Override
    public void setBonusDamage(int bonusDamage) {
        this.bonusDamage = bonusDamage;
    }

    // Métodos
    @Override
    public void atacar(Player objetivo) {
        // Lógica de ataque
        int totalDamage = this.espadas + this.bonusDamage;
        objetivo.recibirAtaque(totalDamage);
    }

    @Override
    public void escudo() {
        // Lógica de escudo
        for (int i = 0; i < this.escudos; i++) {
            this.owner.getEscudos().add(this);
        }
    }

    @Override
    public void cartaExtra() {
        // Lógica de carta extra
        for (int i = 0; i < this.cartasExtra; i++) {
            this.owner.robar();
        }
    }

    @Override
    public void rayo() {
        // Lógica de rayo
        this.owner.puedeJugarCartaExtra(true);
    }

    @Override
    public void curar() {
        // Lógica de curar
        this.owner.curarse(this.corazones);
    }

    @Override
    public void jugarCarta() {
        // Lógica de jugar carta
        if (this.espadas > 0) {
            // Asumimos que hay una referencia al jugador objetivo
            Player objetivo = this.owner.seleccionarObjetivo(); // Necesitarás implementar esta lógica
            this.atacar(objetivo);
        }
        if (this.escudos > 0) {
            this.escudo();
        }
        if (this.cartasExtra > 0) {
            this.cartaExtra();
        }
        if (this.rayos > 0) {
            this.rayo();
        }
        if (this.corazones > 0) {
            this.curar();
        }
    }
}
