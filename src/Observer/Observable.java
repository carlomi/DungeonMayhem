package Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<Observer> observadores = new ArrayList<>();

    public void addObserver(Observer observer) {
        observadores.add(observer);
    }

    public void removeObserver(Observer observer) {
        observadores.remove(observer);
    }

    protected void notifyObservers() {
        for (Observer observer : observadores) {
            observer.actualizar();
        }
    }
}