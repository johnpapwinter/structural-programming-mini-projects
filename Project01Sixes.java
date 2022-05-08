package gr.aueb.cf.testbed.miniProjectsEaster;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Αναπτύξτε ένα πρόγραμμα σε Java που να διαβάζει από ένα αρχείο ακέραιους αριθμούς μέχρι να βρει την τιμή -1
 * (το αρχείο πρέπει να περιέχει περισσότερους από 6 αριθμούς και το πολύ 49 αριθμούς) με τιμές από 1 έως 49.
 * Τους αριθμούς αυτούς τους εισάγει σε ένα πίνακα, τον οποίο ταξινομεί (π.χ. με την Arrays.sort()).
 * Στη συνέχεια, το πρόγραμμα παράγει όλες τις δυνατές εξάδες (συνδυασμούς 6 αριθμών).
 * Ταυτόχρονα και αμέσως μετά την παραγωγή κάθε εξάδας ‘φιλτράρει’ κάθε εξάδα ώστε να πληροί τα παρακάτω κριτήρια:
 * 1) Να περιέχει το πολύ 4 άρτιους, 2) να περιέχει το πολύ 4 περιττούς, 3) να περιέχει το πολύ 2 συνεχόμενους,
 * 4) να περιέχει το πολύ 3 ίδιους λήγοντες, 5) να περιέχει το πολύ 3 αριθμούς στην ίδια δεκάδα.
 * Τέλος, εκτυπώνει τις τελικές εξάδες σε ένα αρχείο με όνομα της επιλογής σας και κατάληξη.txt.
 *
 * Hint. Ακολουθήστε τη διαδικασία που είχαμε δει για την παραγωγή 4άδων.
 * Κάθε παραγόμενη εξάδα μπορεί να αποθηκεύεται σε ένα πίνακα ο οποίος στη συνέχεια να ελέγχεται
 * από κάθε μία από τις αναφερόμενες μεθόδους (φίλτρα). Αν για παράδειγμα μία εξάδα
 * έχει αποθηκευτεί στον πίνακα arr, τότε για να ‘περάσει’ τα φίλτρα που είναι ταυτόχρονα περιορισμοί,
 * θα πρέπει να ελεγχθεί. Π.χ. if (!isEven(arr)) && (!isOfdd(arr)) && (!isContiguous(arr)) && (!isSameEnding(arr))
 * && (!isSameTen), γράψε την εξάδα στο αρχείο εξόδου.
 */


public class Project01Sixes {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File inFile = new File("C:/Users/johnp/Desktop/Coding Factory/filein.txt");
        Scanner in = new Scanner(inFile);
        int s = 6;
        int[] row = new int[6];
        PrintStream ps = new PrintStream("C:/Users/johnp/Desktop/Coding Factory/filesixes.txt", "UTF-8");


        ArrayList<Integer> numbers = new ArrayList<>();

        while (in.hasNextInt()) {
            numbers.add(in.nextInt());
        }

        for (int i = 0; i < numbers.size() - 5; i++) {
            for (int j = i + 1; j <= numbers.size() - s + 1; j++) {
                for (int k = j + 1; k <= numbers.size() - s + 2; k++) {
                    for (int m = k + 1; m < numbers.size() - s + 3; m++) {
                        for (int n = m + 1; n < numbers.size() - s + 4; n++) {
                            for (int o = n + 1; o < numbers.size() - s + 5; o++) {
                                row[0] = numbers.get(i);
                                row[1] = numbers.get(j);
                                row[2] = numbers.get(k);
                                row[3] = numbers.get(m);
                                row[4] = numbers.get(n);
                                row[5] = numbers.get(o);
                                if(isEven(row) && isOdd(row) && isContinuous(row) && isSameEnding(row) && isSameTen(row)) {
                                    ps.printf("%d\t%d\t%d\t%d\t%d\t%d\n", numbers.get(i), numbers.get(j), numbers.get(k), numbers.get(m), numbers.get(n), numbers.get(o));
                                } else {
                                    System.out.println("Combo not good");
                                }
                            }
                        }
                    }
                }
            }
        }

        ps.close();


    }

    /**
     *
     * @param input array of integers
     * @return true if there is a maximum of 4 even numbers in the array
     */
    public static boolean isEven(int[] input) {
        int counter =0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] % 2 == 0) {
                counter++;
            }
        }
        return counter <= 4;
    }

    /**
     *
     * @param input array of integers
     * @return true if there is a maximum of 4 odd numbers in the array
     */

    public static boolean isOdd(int[] input) {
        int counter =0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] % 2 != 0) {
                counter++;
            }
        }
        return counter <= 4;
    }


    /**
     *
     * @param input an array of integers
     * @return returns true if there are max 2 continuous numbers
     */

    public static boolean isContinuous(int[] input) {
        int counter = 0;
        for (int i = 0; i < input.length; i++) {
            if ((i + 1) >= input.length) {
                break;
            } else if ((input[i + 1] - input[i]) == 1) {
                counter++;
            }
        }

        return counter <= 2;
    }


    /**
     *
     * @param input an array of integers
     * @return true if there are max 3 numbers that end in the same digit
     */

   public static boolean isSameEnding(int[] input) {
        int counter = 0;
        for (int k = 0; k <= 9; k++) {
            for (int i = 0; i < input.length; i++) {
                if (input[i] % 10 == k) {
                    counter++;
                }
            }
            if (counter <= 3) {
                return true;
            }
            counter = 0;
        }

        return false;
   }


    /**
     *
     * @param input an array of integers
     * @return true if there are max 3 numbers in the same ten
     */

  public static boolean isSameTen(int[] input) {
        int counter = 0;
        for (int k = 0; k <= 4; k++) {
            for (int i = 0; i < input.length; i++) {
                if (input[i] / 10 == k) {
                    counter++;
                }
            }
            if (counter <= 3) {
                return true;
            }
            counter = 0;
        }

        return false;
    }



}

