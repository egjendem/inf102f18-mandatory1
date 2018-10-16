package no.uib.ii.inf102.f18.mandatory1;

import java.util.NoSuchElementException;

/**
 * Minimum indexed priority queue.
 * Use a binary tree to implementation.
 * @author Amalie Rovik
 * @param <Key> Is the generic type for the PQ.
 */

public class IndexMinPQ<Key extends Comparable<Key>> implements IIndexPQ<Key> {
    private Key[] keys; //items with priority
    private int maxN;
    private int n; //number of elements on PQ
    private int[] pq; // binary heap using 1-based indexing
    private int[] qp; // inverse of qp [pq[i]] = pq[qp[i]] = i

    public IndexMinPQ(int maxN) {
        if (maxN < 0) throw new IllegalArgumentException();
        this.maxN = maxN;
        keys = (Key[]) new Comparable[maxN + 1];    // make this of length NMAX??
        pq   = new int[maxN + 1];
        qp   = new int[maxN + 1];                   // make this of length NMAX??
        for (int i = 0; i <= maxN; i++) qp[i] = -1;
    }

    // Adds elements
    public void add(int index, Key key) {
        if (this.contains(index)) {
            throw new IllegalArgumentException("Index already in PQ");
        }
        insert(index, key);
    }

    public void changeKey(int index, Key key) {
        if (index < 0 || index >= maxN) throw new IllegalArgumentException();
        if (!contains(index)) throw new NoSuchElementException("It is not in the PQ");
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
            throw new IllegalArgumentException("It is already in the PQ");
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }

    public void delete(int index) {
        if (index < 0 || index >= maxN) throw new IndexOutOfBoundsException();
        if (!contains(index)) throw new NoSuchElementException("Index is not in the priority queue");
        int i = qp[index];
        exchange(index, n--);
        swim(index);
        sink(index);
        keys[i]=null;
        qp[i] = -1;
        System.out.println("Deleted key at index: " + index);
    }

    public Key getKey(int index) {
        if( index < 0 || index >=maxN)
            throw new IllegalArgumentException();
        if (!this.contains(index)) {
            throw new IllegalArgumentException("Index not in priority queue");
        } else return keys[index];
    }

    public Key peekKey() {
        return keys[pq[1]];
    }

    public int peek() {
        return pq[1];
    }

    public void poll(int i, Key key) {
        if (i < 0 || i >= maxN)
            throw new IndexOutOfBoundsException();
        if (!contains(i))
            throw new NoSuchElementException("The index is not in the PQ");
        if (keys[i].compareTo(key) <= 0)
            throw new IllegalArgumentException("This argument would not decrease the key");
        keys[i] = key;
        swim(qp[i]);
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