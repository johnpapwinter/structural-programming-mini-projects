package gr.aueb.cf.testbed.miniProjectsEaster;

import java.io.*;
import java.util.Arrays;

/**
 * Αναπτύξτε μία εφαρμογή που διαβάζει έναν-έναν τους χαρακτήρες ενός αρχείου και
 * τους εισάγει σε ένα πίνακα 256x2. Κάθε θέση του πίνακα είναι επομένως ένας
 * πίνακας δύο θέσεων, όπου στη 1η θέση αποθηκεύεται ο χαρακτήρας που έχει
 * διαβαστεί (αν δεν υπάρχει ήδη στον πίνακα) και στη 2η θέση αποθηκεύεται το πλήθος
 * των φορών που έχει διαβαστεί (βρεθεί) κάθε χαρακτήρας. Χαρακτήρες
 * θεωρούνται και τα κενά και οι αλλαγές γραμμής και γενικά οποιοσδήποτε UTF-8 χαρακτήρας.
 * Στο τέλος η main() παρουσιάζει στατιστικά στοιχεία για κάθε χαρακτήρα
 * όπως η συχνότητα εμφάνισής του στο κείμενο ταξινομημένα ανά χαρακτήρα και ανά συχνότητα εμφάνισης.
 */


public class Project03NoOfChars {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int[][] noOfInstances = new int[256][2];
        int n = 0;
        int index = 0;
        int limit = 0;
        int bufSize = 8192;
        char[] buf = new char[bufSize];
        BufferedReader bf = new BufferedReader(new FileReader("C:/Users/johnp/Desktop/Coding Factory/another.txt"));

        while ((n = bf.read(buf, 0, bufSize)) != -1) {
            sb.append(buf, 0, n);
        }

        for (int i = 0; i < sb.length(); i++) {
            //try to determine whether the character is already present in the array
            index = getPosition(noOfInstances, (int) sb.charAt(i));

            if (index == -1) { //if the character doesn't exist, insert it
                noOfInstances[limit][0] = (int) sb.charAt(i);
                noOfInstances[limit][1] = 1;
                limit++; //increments the total number of unique characters present in the String by one
            } else { // ifit exists increase frequency by one
                noOfInstances[index][0] = (int) sb.charAt(i);
                noOfInstances[index][1] = noOfInstances[index][1] + 1;
            }
        }

        //new array created with length equal to the number of unique character, the unique  elements are then
        //deep copied to the new array
        int[][] newArray = new int[limit][2];
        newArray = newArrayCopy(noOfInstances, limit);

        //sort and print by characters
        Arrays.sort(newArray, (a, b) -> Integer.compare(a[0], b[0]));
        showList(newArray);


        //sort and print by frequency
        System.out.println();
        Arrays.sort(newArray, (a, b) -> Integer.compare(b[1], a[1]));
        showList(newArray);

   }


    /**
     * The method finds and returns the position of a certain character within an array
     * @param array the array
     * @param character the character to be searched
     * @return the position of the input character in the array, returns -1 if the character is not present
     */
   public static int getPosition(int[][] array, int character) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == character) {
                return i;
            }
        }
        return -1;
   }


    /**
     * Method that deep copies the elements of the input array into another new array
     * @param input the array with the elements to be copied
     * @param limit is the variable that defines the max length of the new array to be created
     * @return returns the array
     */
   public static int[][] newArrayCopy(int[][]input, int limit) {
        int[][] output = new int[limit][2];
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] != 0) {
                    output[i][j] = input[i][j];
                }
            }

        }
        return output;
   }


    /**
     * Simple method to print the list
     * @param input the list to be shown
     */
   public static void showList(int[][]input) {
        for(int i = 0; i < input.length; i++) {
            System.out.println(((char) input[i][0]) + " = " + input[i][1]);
        }
   }

}
