package gr.aueb.cf.testbed.miniProjectsEaster;

import java.util.Arrays;

/**
 * Έστω ένας δισδιάστατος πίνακας που περιέχει τα στοιχεία άφιξης και αναχώρησης αυτοκινήτων
 * σε μορφή arr[][] = {{1012, 1136}, {1317, 1417}, {1015, 1020}} Αναπτύξτε μία εφαρμογή που διαβάζει
 * να εκτυπώνει τον μέγιστο αριθμό αυτοκινήτων που είναι σταθμευμένα το ίδιο χρονικό διάστημα.
 * Για παράδειγμα, στον παραπάνω πίνακα το αποτέλεσμα θα πρέπει να είναι: 2. Το 1ο αυτοκίνητο αφίχθη στις 10:12
 * και αναχώρησε στις 11:36, το 3ο αυτοκίνητο αφίχθη στις 10:15 και αναχώρησε στις 10:20.
 * Επομένως, το 1ο και το 3ο αυτοκίνητο ήταν παρόντα το ίδιο χρονικό διάστημα.
 * Hint. Με βάση τον αρχικό πίνακα, δημιουργήστε ένα δισδιάστατο πίνακα που σε κάθε γραμμή θα περιέχει δύο πεδία int.
 * Στο πρώτο πεδίο θα εισάγεται η ώρα άφιξης ή αναχώρησης από τον αρχικό πίνακα και στο 2ο πεδίο
 * θα εισάγεται ο αριθμός 1 αν πρόκειται για άφιξη και 0 αν πρόκειται για αναχώρηση.
 * Ταξινομήστε τον πίνακα σε αύξουσα σειρά με βάση την ώρα. Στη συνέχεια υπολογίστε το μέγιστο αριθμό αυτοκινήτων
 * που είναι σταθμευμένα το ίδιο χρονικό διάστημα με ένα πέρασμα του πίνακα.
 */


public class Project04Parking {
    public static void main(String[] args) {
        int[][] parkingHours = {{1012, 1136}, {1317, 1417}, {1015, 1020}};
        int[][] array1 = new int[parkingHours.length * 2][2];
        int counter = 0;
        int maxCars = 0;
        int currentCars = 0;

        //fill the new 2D array with the data in parking hours. Column 0 is filled with the incoming
        //and outgoing hours. Column 1 is filled with +1 or -1 depending on whether a car came in or left
        for (int i = 0; i < parkingHours.length; i++) {
            for (int j = 0; j < parkingHours[0].length; j++) {
                array1[counter][0] = parkingHours[i][j];
                if (j == 0) {
                    array1[counter][1] = 1;
                } else {
                    array1[counter][1] = -1;
                }
                counter++;
                }
        }


        //the 2D array is sorted based on the incoming/outgoing hours
        Arrays.sort(array1, (a, b) -> Integer.compare(a[0], b[0]));


        //Check the array to find the maximum number of cars present
        for (int i = 0; i < array1.length; i++) {
            if (maxCars < (currentCars + array1[i][1])) {
                maxCars++;
            }
            currentCars = currentCars + array1[i][1];
        }

        System.out.printf("The maximum numbers of cars present was %d", maxCars);


    }
}
