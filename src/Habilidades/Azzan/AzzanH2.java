package Habilidades.Azzan;

import Cartas.Carta;
import Cartas.CartaEspecial;
import Habilidades.AbstractHabilidad;
import Player.Players;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AzzanH2 extends AbstractHabilidad {

    @Override
    public void usarHabilidad(List<Players> players) {
        Players oponente;
        int i = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione un usuario para intercambiar puntos de vida:");
        for (Players p : players) {
            i++;
            System.out.println(i + ". " + p.getName() + " - " + p.getHealth() + " corazones.");
            System.out.println("----------------------------------------------------");
        }



    }


}
