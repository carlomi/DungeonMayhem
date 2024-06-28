package Cartas;

import Habilidades.Habilidad;

public interface CartaFactory {
    public Carta createCartaNormal(String nombre, int espadas, int corazones, int escudos, int rayos, int cartasExtra);
    public Carta createCartaEspecial(String nombre, int espadas, int corazones, int escudos, int rayos, int cartasExtra, Habilidad habilidad);
    public Carta createCartaEspecial(String nombre, Habilidad habilidad);
}