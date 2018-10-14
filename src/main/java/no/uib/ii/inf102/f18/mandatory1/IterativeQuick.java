package no.uib.ii.inf102.f18.mandatory1;

/**
 * @author Amalie Rovik
 * @author Espen Gjendem
 *
 * This class will do the Quicksort algorithm non-recursive (iterative).
 * The cost is approximately O(n log n) or O(n^2) in some cases, which is worst case guaranteed.
 */
public class IterativeQuick {

    /**
     * Test IterativeQuick by calling main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        /* int[] arr = {1, 5, 3, 9, 4, 6, 10, 55, 2};

        IterativeQuick iq = new IterativeQuick(); // Instantiate the IterativeQuick object.

        iq.sort(arr, 0, arr.length-1); // Iterative Quicksort starts here.

        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]);
            }
        } */
    }

    /**
     * Partition an array by dividing it and create three parts. One array containing
     * values less than the pivot, another array for the values greater than the pivot and just
     * return the pivot itself as a singleton element.
     * (This is not the conventional way to do it,
     * but we'll simply do it for iterative Quicksort).
     *
     * @param arr The array to be partitioned
     * @param start Array index start
     * @param end Array index end
     * @return int Pivot Index
     */
    public int partition(Comparable[] arr, int start, int end) {
        Comparable pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (pivot.compareTo(arr[j]) >= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, end);

        return i + 1;
    }

    public void sort(Comparable[] arr, int start, int end) {
        MyStack<int[]> stack = new MyStack<>();

        int[] range = {start, end};
        stack.push(range);

        while (stack.size() > 0) {
            range = stack.pop();
            start = range[0];
            end = range[1];

            int pivot = partition(arr, start, end);

            if (start < pivot - 1) {
                stack.push(new int[]{start, pivot - 1});
            }

            if (pivot + 1 < end) {
                stack.push(new int[]{pivot + 1, end});
            }
        }
    }

    public void swap(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Takes an array with objects which has inherited Comparable
     * and calls the sort method declared in this class to start iterative process of
     * the Quicksort algorithm.
     *
     * @param arr Array to be sorted
     */
    public void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }
}