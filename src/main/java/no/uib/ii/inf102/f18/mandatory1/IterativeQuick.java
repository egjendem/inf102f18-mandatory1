package no.uib.ii.inf102.f18.mandatory1;

import java.util.SplittableRandom;

public class IterativeQuick {

    public static void sort(Comparable[] arr) {
        shuffle(arr);
        qs(arr, 0, arr.length-1);
    }

    public static int part(Comparable[] arr, int lb, int ub) {
        Comparable pivot = arr[ub];
        int i = (lb - 1); //lower bound index
        for (int j = lb; j < ub; j++) {
            //Check if equal or smaller than piv
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                //perform swap i - j
                Comparable temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //perform swap i+1 - pivot
        Comparable temp = arr[i + 1];
        arr[i + 1] = arr[ub];
        arr[ub] = temp;
        return i + 1;
    }



    static void qs(Comparable arr[], int l, int h) {
        // Creating an auxiliary stack, so I can pop from top
        int[] stack = new int[h - l + 5]; //size + 5

        int top = -1;

        stack[++top] = l;
        stack[++top] = h;

        while (top >= 0) {
            // Pop h and l
            h = stack[top--];
            l = stack[top--];

            int p = part(arr, l, h);

            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
    }
    private static void shuffle(Comparable[] arr) {
        SplittableRandom r = new SplittableRandom();
        for (int i = 0; i < arr.length; i++) {
            int j = r.nextInt(arr.length-i) + i;
            swap(i, j, arr);
        }
    }

    private static void swap(int i, int j, Comparable[] arr) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}