package Cartas;

import Habilidades.Habilidad;

public class LiaCardFactory implements CartaFactory {
    private final String owner = "Lia";

    public Carta createCartaNormal(String nombre, int espadas, int corazones, int escudos, int rayos, int cartasExtra){
        return new CartaNormal(nombre, owner, espadas,corazones,escudos,rayos,cartasExtra);
    }

    public Carta createCartaEspecial(String nombre, int espadas, int corazones, int escudos, int rayos, int cartasExtra, Habilidad habilidad){
        return new CartaEspecial(nombre, owner, espadas,corazones,escudos,rayos,cartasExtra,habilidad);
    }

    @Override
    public Carta createCartaEspecial(String nombre, Habilidad habilidad) {
        return new CartaEspecial(nombre, owner, habilidad);
    }
}