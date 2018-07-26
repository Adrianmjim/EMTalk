package pad.ucm.fdi.emtalk.vista;

public interface Observable<T> {
    void addObserver(T obv);
    void delObserver(T obv);
}
