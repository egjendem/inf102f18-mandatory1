package no.uib.ii.inf102.f18.mandatory1;

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
    class iStack<T> {
        Node<T> head; // Head of the Node stack.
        /**
         * Run the constructor when an iStack instance is created
         * and initialize the stack.
         */
        iStack() {

        }

        /**
         * @author Amalie Rovik
         * This will represent a node in and iStack instance.
         * @param <E>
         */
        class Node<E> {

        }
    }
}
