package Player;

import Cartas.Carta;

import java.util.List;

public interface Players {
    public String getName();
    public void setName(String name);
    public int getHealth();
    public void setHealth(int health);
    public Personaje getPersonaje();
    public void setPersonaje(Personaje personaje);
    public List<Carta> getMazo();
    public void setMazo(List<Carta> mazo);
    public List<Carta> getMano();
    public void setMano(List<Carta> mano);
    public List<Carta> getCartasActivas();
    public void setCartasActivas(List<Carta> cartasActivas);
    public List<Carta> getDescartadas();
    public void setDescartadas(List<Carta> descartadas);
    public int getEscudos();
    public void setEscudos(int escudos);
    public void mezclarMazo();
    public void recibirAtaque();
    public void recibirAtaque(int damage);
    public void curarse();
    public void curarse(int corazones);
    public void tomarCarta();
    public void tomarCarta(int cartasExtra);
    public boolean hasShield();


    int getEscudos();

    void setEscudos(int i);

    public void jugarCarta(Carta carta);
    public void setOponentes(List<Players> players);
    public List<Players> getOponentes();
    public int getTurnos();
    public void agregarTurnos(int turnos);
    public void setTurnos(int turnos);
    public void takeTurn();

}
