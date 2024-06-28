package Cartas;
import Habilidades.*;

public class CartaEspecial extends CartaNormal implements Carta{
    Habilidad habilidad;

    //Constructors
    public CartaEspecial(String nombre, String owner, int espadas, int corazones, int escudos, int rayos, int cartasExtra, Habilidad habilidad) {
        super(nombre, owner, espadas, corazones, escudos, rayos, cartasExtra);
        this.habilidad = habilidad;
    }

    public CartaEspecial(String nombre, String owner, Habilidad habilidad) {
        super(nombre, owner);
        this.habilidad = habilidad;
    }

    public CartaEspecial(String nombre, String owner){
        super(nombre, owner);
    }

    //Getters and Setters
    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }
}
