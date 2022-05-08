package gr.aueb.cf.testbed.miniProjectsEaster;

import java.util.Arrays;

/**
 * Γράψτε δύο μεθόδους που αφορούν την αντιγραφή δισδιάστατων πινάκων. Μία μέθοδο int[][] shallowCopy(int[][] arr)
 * που αντιγράφει ένα δισδιάστατο πίνακα αλλά μόνο τις τιμές του βασικού πίνακα που είναι αναφορές στους πίνακες
 * που είναι στοιχεία του βασικού πίνακα. Και μία μέθοδο int[][] deepCopy(int[][] arr).
 * Γράψτε μία main που να δείχνετε γιατί το shallow copy δεν δουλεύει όπως θα θέλαμε,
 * αφού αλλάζοντας ένα στοιχείο ενός πίνακα από δύο για παράδειγμα copies, αλλάζει το στοιχείο και στον άλλο πίνακα,
 * αφού κατά βάση πρόκειται για ένα και μόνο κοινό στοιχείο (αφού έχει γίνει shallow copy).
 * Δείξτε και την περίπτωση του deep copy. Δείξτε ότι δουλεύει όπως θα θέλαμε. Δηλαδή δεν επηρεάζουν
 * οι αλλαγές στοιχείων το κάθε copy, το οποίο τώρα είναι ανεξάρτητο.
 */


public class Project07DeepShallowCopy {
    public static void main(String[] args) {
        int[][] array1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] array2;

        //Βλέπουμε τον πίνακα 1
        System.out.println(Arrays.deepToString(array1));

        //Κάνουμε ένα shallow copy του πίνακα 1 στον 2. Ουσιαστικά, αυτό που συμβαίνει είναι
        //Ότι αντιγράφεται το reference που δείχνει στα ίδια δεδομένα.
        array2 = shallowCopy(array1);
        System.out.println(Arrays.deepToString(array2));

        //Αν αλλάξουμε ένα στοιχείο στον 1, τότε η αλλαγή θα γίνει και στον 2 γιατί εκείνο
        //πρόκειται για μια αναφορά που δείχνει στο ίδιο σημείο του heap.
        array1[0][0] = 100;
        System.out.println(array2[0][0]);

        //Τώρα αντιγράφουμε τον πίνακα, δεσμεύοντας έναν διαφορετικό χώρο στο heap και περνώντας εκεί
        //απλά τα ίδια δεδομένα. Το reference δείχνει αλλού. Βλέπουμε ότι αν αλλάξουμε ένα στοιχείο
        //στον πίνακα 1, τότε η αλλαγή δεν εμφανίζεται στον 2
        array2 = deepCopy(array1);
        array1[0][0] = 250;
        System.out.println(Arrays.deepToString(array2));

    }

    /**
     *
     * @param input a 2D array
     * @return a 2D array
     */
    public static int[][] shallowCopy(int[][] input) {
        return input;
    }


    /**
     *
     * @param input a 2D array
     * @return a copy of a 2D array
     */
    public static int[][] deepCopy(int[][] input) {
        int[][] output = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            System.arraycopy(input[i], 0, output[i], 0, input[i].length);
        }
        return output;

    }
}
