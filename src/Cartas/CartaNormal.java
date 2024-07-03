package Cartas;


import Mediator.GameMediator;
import Player.*;

import java.util.List;
import java.util.Scanner;

public class CartaNormal implements Carta{
    private String nombre;
    private String owner;
    private int espadas;
    private int corazones;
    private int escudos;
    private int rayos;
    private int cartasExtra;

    //Constructores
    public CartaNormal(String nombre, String owner, int espadas, int corazones, int escudos, int rayos, int cartasExtra) {
        this.nombre = nombre;
        this.owner = owner;
        this.espadas = espadas;
        this.corazones = corazones;
        this.escudos = escudos;
        this.rayos = rayos;
        this.cartasExtra = cartasExtra;
    }

    public CartaNormal(String owner, int espadas, int corazones, int escudos, int rayos, int cartasExtra) {
        this.owner = owner;
        this.espadas = espadas;
        this.corazones = corazones;
        this.escudos = escudos;
        this.rayos = rayos;
        this.cartasExtra = cartasExtra;
    }

    public CartaNormal(String nombre, String owner){
        this.nombre = nombre;
        this.owner = owner;
    }

    public CartaNormal(String owner){
        this.owner = owner;
    }

    public CartaNormal(){
    }


    //Getters and Setters
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

    //Metodos
    @Override
    public void atacar(List<Players> oponentes) {
        System.out.println("Elige el oponente a atacar:");
        int i = 0;
        for (Players p : oponentes) {
            System.out.println((i+1) + ". " + p.getName());
            i++;
        }

        Scanner sc = new Scanner(System.in);

        GameMediator.attack(oponentes.get(sc.nextInt() - 1),getEspadas());
    }


    @Override
    public void rayo() {

    }

    @Override
    public void curar() {

    }
}
