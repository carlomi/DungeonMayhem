package Player;

public interface Players {
    public void imprimirMazo();
    public void recibirAtaque();
    public void recibirAtaque(int damage);
    public void curarse();
    public void curarse(int corazones);
    public void tomarCarta();
    public void tomarCarta(int cartasExtra);
    public boolean hasShield();
}
