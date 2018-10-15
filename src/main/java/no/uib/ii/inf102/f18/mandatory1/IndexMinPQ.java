package no.uib.ii.inf102.f18.mandatory1;

/**
 * Minimum priority queue.
 *
 * @author Amalie Rovik
 * @param <Key>
 */
public class IndexMinPQ<Key extends Comparable<Key>> implements IIndexPQ<Key> {
    // Heap
    private Key[] heap;

    private int n;
    private int[] pq;
    private int[] qp;

    public IndexMinPQ(int length) {
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
        if (i < 0 || i >= maxN) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }

    public boolean contains(int index) {
        return qp[k] != -1;
    }

    public void delete(int index) {
        if (i < 0 || i >= maxN) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        int index = qp[i];
        exchange(index, n--);
        swim(index);
        sink(index);
        keys[i] = null;
        qp[i] = -1;
    }

    public Key getKey(int index) {
        if( index < 0 || index >=maxN) throw new IllegalArgumentException();
        // TODO Auto-generated method stub
        if (!this.contains(index)) {
            throw new IllegalArgumentException("Index not in priority queue");
        }else return keys[index];
    }

    public Key peekKey() {
        return keys[pq[1]];
    }

    public int peek() {
        return pq[1];
    }

    public int poll() {
        return 0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size() {
        return n;
    }

    public Item min() {
        return keys[pq[1]];
    }

    private void exchange(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exchange(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }
}
