package Cartas;
import Player.*;



public interface Carta {
    void atacar(Player objetivo);
    void escudo();
    void cartaExtra();
    void rayo();
    void curar();
    void jugarCarta();
    String getNombre();
}