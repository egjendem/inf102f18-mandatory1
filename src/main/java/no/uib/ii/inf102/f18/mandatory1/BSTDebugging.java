package no.uib.ii.inf102.f18.mandatory1;

/*
* BST debugging for Kattis
*/

public class BSTDebugging {

    public static void main(String args[]) {
        Kattio io = new Kattio(System.in);
        int maxVal = Integer.MAX_VALUE;
        int minVal = Integer.MIN_VALUE;


        // in-values
        int n = io.getInt();
        //Search Key
        int key = io.getInt();
        int temp = io.getInt();

        for (int i = 1; i < n; i++) {
            int next = io.getInt();
            if (temp >= maxVal && temp > key) {
                System.out.println("invalid");
                return;
            }
            if (temp <= minVal && temp < key) {
                System.out.println("invalid");
                return;
            }
            // range changer
            if (temp < key && minVal < temp) {
                minVal = temp;
            }
            if (temp > key && maxVal > temp) {
                maxVal = temp;
            }

            if (temp == key) {
                System.out.println("invalid");
                return;
            }
            if (temp > key && next >= temp) {
                System.out.println("invalid");
                return;
            }
            if (temp < key && next <= temp) {
                System.out.println("invalid");
                return;
            }

            // if next and temp is less or equal to, search
            if (temp <= key && next <= temp) {
                System.out.println("invalid");
                return;

            }
            // if next and temp is bigger than/equal, search
            if (temp > key && next >= temp) {
                System.out.println("invalid");
                return;
            }
            temp = next;
        }
        System.out.println("valid");
    }
}
