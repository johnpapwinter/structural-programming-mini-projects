package gr.aueb.cf.testbed.miniProjectsEaster;

/**
 * Δημιουργήστε μία εφαρμογή επαφών για ένα κινητό τηλέφωνο, η οποία μπορεί να περιέχει μέχρι 500 επαφές.
 * Κάθε επαφή έχει Επώνυμο, Όνομα και Τηλέφωνο.
 * Για να αποθηκεύεται τις επαφές χρησιμοποιήστε ένα δισδιάστατο πίνακα 500x3 όπου στη 1η θέση κάθε επαφής
 * θα αποθηκεύεται το Επώνυμο, στη 2η θέση το Όνομα και στη 3η θέση το τηλέφωνο, όλα ως String.
 * Υλοποιήστε τις βασικές CRUD πράξεις: Αναζήτηση Επαφής με βάση το τηλέφωνο,
 * Εισαγωγή Επαφής (αν δεν υπάρχει ήδη), Ενημέρωση Επαφής (εάν υπάρχει), Διαγραφή Επαφής (εάν υπάρχει).
 * Η main() θα πρέπει να εμφανίζει ένα μενού στον χρήστη, οποίος θα επιλέγει την κατάλληλη πράξη
 * ή Έξοδο από την εφαρμογή και με την κατάλληλη καθοδήγηση της εφαρμογής θα επιτελεί την επιλεγμένη πράξη.
 */


import java.util.Arrays;
import java.util.Scanner;

public class Project02Phonebook {

    static Scanner input = new Scanner(System.in);
    static String[][] phoneBook = new String[10][3];

    public static void main(String[] args) {
        int choice = 0;

        //array initialization
        initializeArray();


        while (true) {
            callMenu();
            choice = input.nextInt();
            if (choice == 5) {
                System.out.println("Bye!");
                break;
            } else {
                crudActions(choice);
            }

        }

        input.close();

    }


    public static void crudActions(int choice) {
        String lastName = "";
        String firstName = "";
        String telephone = "";

        //1 insert, 2 search, 3 update, 4 delete
        if (choice == 1) {
            //insert action
            printMessages(1);
            lastName = input.next();
            firstName = input.next();
            telephone = input.next();
            createAction(lastName, firstName, telephone);
        } else if (choice == 2) {
            //read action
            printMessages(2);
            lastName = input.next();
            firstName = input.next();
            int temp = readAction(lastName, firstName);
            if (temp != -1) {
                System.out.println("Entry found:");
                System.out.println(phoneBook[temp][0] + " " + phoneBook[temp][1] + " " + phoneBook[temp][2]);
            }
        } else if (choice == 3) {
            //update action
            printMessages(3);
            lastName = input.next();
            firstName = input.next();
            updateAction(lastName, firstName);
        } else {
            //delete action
            printMessages(4);
            lastName = input.next();
            firstName = input.next();
            deleteAction(lastName, firstName);
        }
    }


    /**
     * create method that creates a new entry within the array
     * @param lastName last name of the entry to be created
     * @param firstName first name of the entry to be created
     * @param telephone telephone number of the entry to be created
     */
    public static void createAction(String lastName, String firstName, String telephone) {
        int counter = 0;
        while (true) {
            if (counter == phoneBook.length) {
                System.out.println("The list is full!");
                break;
            }
            if (phoneBook[counter][0].equals("")) {
                phoneBook[counter][0] = lastName;
                phoneBook[counter][1] = firstName;
                phoneBook[counter][2] = telephone;
                bubbleSortList(phoneBook);
                break;
            }
            counter++;
        }
    }


    /**
     * simple read method that locates an entry within the array
     * @param lastName last name of the entry to be searched
     * @param firstName first name of the entry to be searched
     * @return returns the index of the entry if found, if not found, returns -1
     */
    public static int readAction(String lastName, String firstName) {
        for (int i = 0; i < phoneBook.length; i++) {
            if (phoneBook[i][0].equals(lastName)) {
                if (phoneBook[i][1].equals(firstName)) {
                    return i;
                }
            }
        }
        return -1;
    }


    /**
     * update method that takes a last and first name and updates the entry if it exists
     * @param lastName last name of the entry to be updated
     * @param firstName first name of the entry to be updated
     */
    public static void updateAction (String lastName, String firstName) {
        String newLastName;
        String newFirstName;
        String newTelephone;

        int position = readAction(lastName, firstName);
        if (position == -1) {
            System.out.println("The entry you are trying to update doesn't exist!");
        } else {
            System.out.println("Please enter the new name and telephone");
            newLastName = input.next();
            newFirstName = input.next();
            newTelephone = input.next();
            phoneBook[position][0] = newLastName;
            phoneBook[position][1] = newFirstName;
            phoneBook[position][2] = newTelephone;
            System.out.println("The entry was updated");
            bubbleSortList(phoneBook);

        }

    }


    /**
     * delete method that takes a last and first name and deletes the entry if it exists
     * @param lastName the last name of the entry to be deleted
     * @param firstName the first name of the entry to be deleted
     */
    public static void deleteAction (String lastName, String firstName) {
        int position = readAction(lastName, firstName);
        if (position != -1) {
            phoneBook[position][0] = "";
            phoneBook[position][1] = "";
            phoneBook[position][2] = "";
            bubbleSortList(phoneBook);
            System.out.println("The entry was deleted!");
        } else {
            System.out.println("The entry you are trying to delete doesn't exist!");
        }

    }


    /**
     * main menu messages
     */
    public static void callMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Insert New Entry");
        System.out.println("2. Search for an Existing Entry");
        System.out.println("3. Update an Existing Entry");
        System.out.println("4. Delete an Entry");
        System.out.println("5. Exit");
    }


    /**
     * utility messages groupped in a method for better readability
     * @param choice
     */
    public static void printMessages(int choice) {
        if (choice == 1) {
            System.out.println("Please insert the last name of the person");
            System.out.println("Please insert the name of the person");
            System.out.println("Please insert the phone number");
        } else if (choice == 2) {
            System.out.println("Please enter the last & first name of the person you are trying to find");
        } else if (choice == 3) {
            System.out.println("Please enter the last & first name of the person you are trying to update");
        } else {
            System.out.println("Please enter the last & first name of the entry you want to delete");
        }
    }


    /**
     * sorts a list of Strings using the bubble sort method. It sorts empty entries to the end of the array
     * @param inputString
     */

    public static void bubbleSortList(String[][] inputString) {
        for (int i = 0; i < inputString.length; i++) {
            for (int j = i + 1; j < inputString.length; j++) {
                if((!inputString[j][0].equals("")) && ((inputString[i][0].equals("")))) {
                    swap(inputString, i, j);
                }
                if((inputString[j][0].compareTo(inputString[i][0]) < 0) && (!inputString[j][0].equals(""))) {
                    swap(inputString, i, j);
                }
            }
        }
    }


    /**
     * swaps two entries in an array for the bubble sort method
     * @param inputString
     * @param i index to be swapped
     * @param j index to be swapped
     */
    public static void swap(String[][] inputString, int i, int j) {
        String temp;
        for (int k = 0; k < inputString[0].length; k++) {
            temp = inputString[i][k];
            inputString[i][k] = inputString[j][k];
            inputString[j][k] = temp;
        }

    }


    /**
     * simple initialization method, initialized all array elements to ""
     */
    public static void initializeArray() {
        for (int i = 0; i < phoneBook.length; i++) {
            for (int j = 0; j < phoneBook[0].length; j++) {
                phoneBook[i][j] = "";
            }
        }
    }


}
