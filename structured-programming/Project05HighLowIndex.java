package gr.aueb.cf.testbed.miniProjectsEaster;

import java.util.Scanner;

/**
 * Έστω ένας ταξινομημένος πίνακας με επαναλαμβανόμενα στοιχεία.
 * Γράψτε μία μέθοδο int[] getLowAndHighIndexOf(int[] arr, int key) που να υπολογίζει
 * και να επιστρέφει τα low και high index ενός πίνακα arr, για ένα ακέραιο key που λαμβάνει ως παράμετρο.
 * Γράψτε και μία main() που να βρίσκει το low και high index για τον πίνακα {0, 1, 4, 4, 4, 6, 7, 8, 8, 8, 8, 9}.
 * Για παράδειγμα, αν δώσουμε ως τιμή το 8, θα πρέπει να επιστρέφει {7, 10}.
 * Hint. Ελέγξτε αν το key περιέχεται στον πίνακα και σε ποια θέση.
 * Αν ναι, τότε από τη θέση αυτή μετρήστε τα στοιχεία όσο υπάρχουν στοιχεία με ίδια τιμή
 * και μέχρι να βρείτε το τέλος του πίνακα.
 */


public class Project05HighLowIndex {
    public static void main(String[] args) {
        int[] arr = {0, 1, 4, 4, 6, 7, 8, 8, 8, 9};
        int key = 0;
        int indexHigh = 0;
        int indexLow = 0;

        Scanner in = new Scanner(System.in);
        System.out.println("Please insert a number: ");
        key = in.nextInt();


        //check for low and high positions of the number requested in the array
        for (int i = 0; i < arr.length; i++) {
            //check for low position with "point out of bounds" safeguard
            if ((arr[i] == arr[0]) && (arr[i] == key)) {
                indexLow = i;
            } else if ((arr[i] == key) && (arr[i - 1] != key)) {
                indexLow = i;
            }

            //check for high position with "pointer out of bounds" safeguard
            if ((arr[i] == (arr.length - 1)) && (arr[i] == key)) {
                indexHigh = i;
            } else if ((arr[i] == key) && (arr[i + 1] != key)) {
                indexHigh = i;
            }
        }

        System.out.printf("The lox index for the number %d is %d and the high index is %d", key, (indexLow + 1), (indexHigh +1));
    }
}
