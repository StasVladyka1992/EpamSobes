package Patterns.Observer;

/**
 * @project EpamSobes
 * author Stas Vladyka on 13.08.2019.
 */
public interface Observable {
    void add (Observer observer);
    void remove (Observer observer);
    void notifyObservers();
}
