package Cartas;

import Player.Player;

public class CartaNormal implements Carta {
    private String nombre;
    private String owner;
    private int espadas;
    private int corazones;
    private int escudos;
    private int rayos;
    private int cartasExtra;
    private int bonusDamage; // Campo para almacenar el daño extra

    // Constructores
    public CartaNormal(String nombre, String owner, int espadas, int corazones, int escudos, int rayos, int cartasExtra) {
        this.nombre = nombre;
        this.owner = owner;
        this.espadas = espadas;
        this.corazones = corazones;
        this.escudos = escudos;
        this.rayos = rayos;
        this.cartasExtra = cartasExtra;
        this.bonusDamage = 0; // Valor por defecto
    }

    public CartaNormal(String owner, int espadas, int corazones, int escudos, int rayos, int cartasExtra) {
        this.owner = owner;
        this.espadas = espadas;
        this.corazones = corazones;
        this.escudos = escudos;
        this.rayos = rayos;
        this.cartasExtra = cartasExtra;
        this.bonusDamage = 0; // Valor por defecto
    }

    public CartaNormal(String nombre, String owner) {
        this.nombre = nombre;
        this.owner = owner;
        this.bonusDamage = 0; // Valor por defecto
    }

    public CartaNormal(String owner) {
        this.owner = owner;
        this.bonusDamage = 0; // Valor por defecto
    }

    public CartaNormal() {
        this.bonusDamage = 0; // Valor por defecto
    }

    // Getters and Setters
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
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
    }

    @Override
    public void escudo() {
        // Lógica de escudo
    }

    @Override
    public void cartaExtra() {
        // Lógica de carta extra
    }

    @Override
    public void rayo() {
        // Lógica de rayo
    }

    @Override
    public void curar() {
        // Lógica de curar
    }

    @Override
    public void jugarCarta() {
        // Lógica de jugar carta
    }
}
