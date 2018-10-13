package no.uib.ii.inf102.f18.mandatory1;

/**
 * @author Amalie Rovik
 * This class will do the Quicksort algorithm non-recursive (iterative).
 * The cost is approximately O(n log n) or O(n^2) in some cases, which is worst case guaranteed.
 */
public class IterativeQuick {

    /**
     * Test IterativeQuick by calling main method.
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 10;
        arr[1] = 5;

        MyStack<int[]> stack = new MyStack<>();
        stack.add(arr);

        System.out.println(stack.pop()[0]);

        System.out.println(stack.getCount());

    }

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
}