package no.uib.ii.inf102.f18.mandatory1;

import java.util.Iterator;

/**
 * @author Amalie Rovik
 * This class will do the Quicksort algorithm non-recursive (iterative).
 * The cost is approximately O(n log n) or O(n^2) in some cases, which is worst case guaranteed.
 */
public class IterativeQuick {
    iStack<Comparable[]> stack;

    /**
     * Takes an array with objects which has inherited Comparable
     * and calls the sort method declared in this class to start iterative process of
     * the Quicksort algorithm.
     *
     * @param arr Array to be sorted
     */
    public void sort(Comparable[] arr) {

    }

    /**
     * This method does the non-recursive Quicksort algorithm.
     *
     * @param arr
     * @param s
     * @param e
     */
    public void sort(Comparable[] arr, int s, int e) {

    }

    /**
     * @author Amalie Rovik
     * iStack is a simplified implementation of the java Stack utility.
     */
    class iStack<T> implements Iterator {
        Node<T> head, tail, current == null; // Invariants for the Stack.
        /**
         * Run the constructor when an iStack instance is created
         * and initialize the stack.
         */
        iStack() {

        }

        public boolean hasNext() {

        }

        /**
         * @author Amalie Rovik
         * This Node class will represent a node object in an iStack instance.
         *
         * @param <E>
         */
        class Node<E> {
            E data = null;
            Node<E> next = null;

            Node(E d) {
                data = d;
            }

            public void setNext(Node<E> n) {
                next = n;
            }

            public void
        }
    }
}
