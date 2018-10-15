package no.uib.ii.inf102.f18.mandatory1;

/**
 * Minimum priority queue.
 *
 * @author Amalie Rovik
 * @param <Key>
 */
public class IndexMinPQ<Key extends Comparable<Key>> implements IIndexPQ<Key> {
    // Heap
    Key[] heap;

    IndexMinPQ(int length) {
        heap = (Key[]) new Comparable[length];
    }

    public static void main(String[] args) {
        IndexMinPQ<String> obj = new IndexMinPQ<>(10);

        obj.add(1,"amalie");
        // .. 9
        obj.add(10,"espen");
    }

    public void add(int index, Key key) {

        heap[index] = key;
    }

    public void changeKey(int index, Key key) {
        //TODO
    }

    public boolean contains(int index) {
        return true;
    }

    public void delete(int index){

    }

    public Key getKey(int index) {
        return null;
    }

    public Key peekKey() {
        return null;
    }

    public int peek() {
        return 0;
    }

    public int poll() {
        return 0;
    }

    public boolean isEmpty(){
        return true;
    }

    public int size() {
        return 0;
    }
}
