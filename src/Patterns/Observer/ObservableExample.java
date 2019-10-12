package Patterns.Observer;

import java.util.List;
import java.util.Map;

/**
 * @project EpamSobes
 * author Stas Vladyka on 13.08.2019.
 */
public class ObservableExample implements Observable {
    private List<Observer> observers;

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update();
        }
    }
}
