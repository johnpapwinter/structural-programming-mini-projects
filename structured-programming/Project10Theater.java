package gr.aueb.cf.testbed.miniProjectsEaster;

import java.util.Scanner;

/**
 * Έστω ένα θέατρο που έχει θέσεις όπου η κάθε θέση περιγράφεται με ένα χαρακτήρα
που είναι η στήλη και ένα αριθμό που είναι η σειρά. Για παράδειγμα, η θέση C2
βρίσκεται στη 2η σειρά και 3η στήλη.
Αναπτύξτε ένα πρόγραμμα διαχείρισης θεάτρου με 30 σειρές και 12 στήλες. Πιο
συγκεκριμένα γράψτε μία μέθοδο void book(char column, int row) που να κάνει book
μία θέση αν δεν είναι ήδη booked και μία μέθοδο void cancel(char column, int row)
που να ακυρώνει την κράτηση μία θέσης αν είναι ήδη booked.
Hint. Υποθέστε ότι ο δισδιάστατος πίνακας που απεικονίζει το θέατρο είναι ένα
πίνακας από boolean, όπου το true σημαίνει ότι η θέση είναι booked και false ότι δεν
είναι booked. Αρχικά όλες οι θέσεις πρέπει να είναι non-booked.
 */

public class Project10Theater {
    public static void main(String[] args) {
        boolean[][] theater = new boolean[30][12];
        Scanner in = new Scanner(System.in);
        int choice = 0;
        char column;
        int row;

        //initialize all seats to non-booked (false)
        for(int i = 0; i < theater.length; i++) {
            for (int j = 0; j < theater[0].length; j++) {
                theater[i][j] = false;
            }
        }

        while (true) {
            callMenu();
            choice = in.nextInt();
            if (choice == 3) {
                //exit program
                System.out.println("Bye!");
                break;
            } else if (choice == 1) {
                //book a seat
                messages(1);
                column = in.next().charAt(0);
                row = in.nextInt();
                //search if the seat is already booked, if not, book it
                if (!booked(column, row, theater)) {
                    theater[((int) column) - 65][row - 1] = true;
                    System.out.println("Thank you for booking a seat!");
                }
            } else {
                //cancel a reservation
                messages(2);
                column = in.next().charAt(0);
                row = in.nextInt();
                theater[(int) column - 65][row - 1] = cancel(column, row, theater);
            }
        }
    }


    /**
     * This method check to see whether a particular seat is booked
     * @param column the column of the theater to be searched
     * @param row the row of the theater to be searched
     * @param theater the array that represents the theater seats
     * @return true or false depending on whether the seat is booked or not
     */
    public static boolean booked(char column, int row, boolean[][] theater) {
            int temp = ((int) column) - 65;
            if (theater[row - 1][temp]) {
                System.out.println("Sorry, this seat is booked! Select another one!");
                return true;
            } else {
                return false;
            }
    }


    /**
     * This method cancels a reservation made or if the seat the user is trying to cancel
     * is already empty, alerts the user to try again
     * @param column the column of the theater to be searched
     * @param row the row of the theater to be searched
     * @param theater the array that represents the theater seats
     * @return returns always false, because either the reservation will be cancelled (true -> false)
     * or the seat will not have been booked in the first place (false), so there is no need to return
     * multiple values, only alert the user whether s/he needs to make another try
     */
    public static boolean cancel(char column, int row, boolean[][] theater) {
        int temp = ((int) column) - 65;
        if (theater[row - 1][temp]) {
            System.out.println("Your reservation has been cancelled!");
        } else {
            System.out.println("This seat is not booked! Select another one");
        }
        return false;
    }


    /**
     * Method for main menu
     */
    public static void callMenu() {
        System.out.println("Please select an action");
        System.out.println("1. Book a seat");
        System.out.println("2. Cancel a reservation");
        System.out.println("3. Exit");
    }


    /**
     * Method that prints messages to the user for booking and cancellation
     * @param choice the choice parameter determines which message will be printed
     */
    public static void messages(int choice) {
        if (choice == 1) {
            System.out.println("Please provide the column and row of the seat you wish to reserve");
            System.out.println("Please enter your choice in capital letters in the Latin alphabet");
        } else {
            System.out.println("Please provide the column and row of the seat you wish to cancel");
            System.out.println("Please enter your choice in capital letters in the Latin alphabet");
        }
    }
}
