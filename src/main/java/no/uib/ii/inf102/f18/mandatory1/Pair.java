package no.uib.ii.inf102.f18.mandatory1;

/**
 * A simple pair data structure.
 *
 * @author Amalie Rovik
 */
public class Pair<T> {
    private T x, y;

    Pair(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getY() {
        return y;
    }

    public T getX() {
        return x;
    }
}
