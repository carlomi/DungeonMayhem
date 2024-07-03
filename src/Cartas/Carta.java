package Cartas;

import Player.*;

import java.util.List;

public interface Carta {
 Feature/jaime
    void atacar(Player objetivo);
    void escudo();
    void cartaExtra();
    void rayo();
    void curar();
    void jugarCarta();
    String getNombre();

    int getBonusDamage();

    void setBonusDamage(int bonusDamage);
    int getEscudos(); // Añadir este método
    void setEscudos(int escudos); // Añadir este método
  
    public void atacar(List<Players> oponentes);
    public void rayo();
    public void curar();
    public String getOwner();
    public void setOwner(String owner);
    public int getEspadas();
    public void setEspadas(int espadas);
    public int getCorazones();
    public void setCorazones(int corazones);
    public int getEscudos();
    public void setEscudos(int escudos);
    public int getRayos();
    public void setRayos(int rayos);
    public int getCartasExtra();
    public void setCartasExtra(int cartasExtra);
    public String getNombre();
    public void setNombre(String nombre);
    public void ataqueCPU(List<Players> oponentes);
  
}
