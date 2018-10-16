package no.uib.ii.inf102.f18.mandatory1;

import java.util.NoSuchElementException;

/**
 * 1-indexed 
 *
 * @author Amalie Rovik
 * @param <Key>
 */
public class IndexMinPQ<Key extends Comparable<Key>> implements IIndexPQ<Key> {

    private Key[] keys;
    private int maxN;
    private int n; //number of elements on PQ
    private int[] pq; // binary heap using 1-based indexing
    private int[] qp; // inverse of qp[pq[i]] = pq[qp[i]] = i

    public IndexMinPQ(int size) {
        maxN = size + 1;
        n = 0;

        keys = (Key[]) new Comparable[maxN];
        pq = new int[maxN];
        qp = new int[maxN];

        for (int i = 0; i < maxN; i++) {
            qp[i] = -1;
        }
    }

    public void add(int index, Key key) {
        if (this.contains(index)) {
            throw new IllegalArgumentException("Index already in priority queue");
        }
        insert(index, key);
    }

    // i = index
    public void changeKey(int index, Key key) {
        if (index < 0 || index >= maxN) throw new IllegalArgumentException();
        if (!contains(index)) throw new NoSuchElementException("index is not in the priority queue");
        keys[index] = key;
        swim(qp[index]);
        sink(qp[index]);
    }

    public boolean contains(int i) { // should take constant time
        if( i < 0 || i >=maxN) throw new IllegalArgumentException();
        return qp[i] != -1;
    }

    public void insert(int i, Key key) {
        if (i < 0 || i >= maxN)
            throw new IndexOutOfBoundsException();
        if (contains(i))
            throw new IllegalArgumentException("index is already in the priority queue");
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }

    // i = index
    public void delete(int index) {
        if (index < 0 || index >= maxN) throw new IndexOutOfBoundsException();
        if (!contains(index)) throw new NoSuchElementException("index is not in the priority queue");
        int i = qp[index];
        exchange(i, n--);
        swim(i);
        sink(i);
        keys[index]=null;
        qp[index] = -1;
    }


    public Key getKey(int index) {
        if( index < 0 || index >= maxN)
            throw new IllegalArgumentException();
        if (!this.contains(index)) {
            throw new IllegalArgumentException("Index not in priority queue");
        } else {
            return keys[index];
        }
    }

    public Key peekKey() {
        return keys[pq[1]];
    }

    public int peek() {
        return pq[1];
    }

    public int poll() {
        int ih = pq[1]; // index of k high priority
        int il = pq[n]; // index of k low priority

        exchange(1, n--);
        sink(1);

        keys[ih] = null;
        qp[ih] = -1;

        return ih;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size() {
        return n;
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