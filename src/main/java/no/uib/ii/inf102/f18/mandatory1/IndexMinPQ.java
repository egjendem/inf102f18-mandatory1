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
        heap = new Key[length];
    }

    public static void main(String[] args) {
        IndexMinPQ<String> obj = new IndexMinPQ<>(10);

        obj.add("amalie");
    }

    void add(int index, Key key) {
        heap[index] = key;
    }

    void changeKey(int index, Key key) {
        //TODO
    }

    boolean contains(int index) {
        //TODO
        return true;
    }

    void delete(int index){

    }

    Key getKey(int index) {

    }

    Key peekKey() {

    }

    int peek() {

    }

    int poll() {

    }

    boolean isEmpty(){
    return true;
    }
}
