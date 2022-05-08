package gr.aueb.cf.testbed.miniProjectsEaster;


import java.util.Arrays;

/**
 * Μία από τις πρώτες εφαρμογές των Η/Υ ήταν η κρυπτογράφηση. Ένας απλός τρόπος κρυπτογράφησης
 * είναι η κωδικοποίηση κάθε χαρακτήρα με ένα ακέραιο με βάση ένα κλειδί κρυπτογράφησης.
 * Μία τέτοια μέθοδος κρυπτογράφησης περιγράφεται στη συνέχεια.
 * Κωδικοποίησε τον 1ο χαρακτήρα του μηνύματος με την ακέραια τιμή που αντιστοιχεί
 * σε αυτόν (από τον κώδικα ASCII). Κωδικοποίησε του επόμενους χαρακτήρες:
 * (α) προσθέτοντας την ακέραια ASCII τιμή του καθένα από αυτούς με τον κωδικό του προηγούμενού του,
 * (β) παίρνοντας το υπόλοιπο της διαίρεσης του αθροίσματος αυτού διά μία σταθερά.
 * Η σταθερά αυτή ονομάζεται κλειδί (key) κρυπτογράφησης και (υποτίθεται πως) είναι μυστική.
 * Υποθέτουμε πως τα μηνύματα τελειώνουν με τον χαρακτήρα #.
 * Γράψτε ένα πρόγραμμα java που να υλοποιεί τον αλγόριθμο κρυπτογράφησης έτσι
 * ώστε το κωδικοποιημένο μήνυμα που προκύπτει να είναι μία ακολουθία ακεραίων που τελειώνει με -1.
 * Γράψτε και τον αλγόριθμο αποκρυπτογράφησης που λαμβάνει ως είσοδο μία ακολουθία ακεραίων
 * που τελειώνει με -1 και υπολογίζει το αρχικό μήνυμα.
 */


public class Project09Crypto {
    public static void main(String[] args) {
        String inText = "this is a test#";
        int key = 120;
        String outText;
        int[] codedMessage = new int[inText.length()];


        System.out.println("Encrypted message");
        encrypt(inText, key, codedMessage);
        System.out.println(Arrays.toString(codedMessage));

        System.out.println();

        System.out.println("Decrypted message");
        outText = decrypt(codedMessage, key);
        System.out.println(outText);



    }


    /**
     * this method encrypts an input string converting it to a sequence of integers and stores them
     * into an array
     * @param input the input string to be encrypted
     * @param key the encryption key
     * @param array the encrypted sequence of integers
     */
    public static void encrypt(String input, int key, int[] array) {
        int previousCipher = input.charAt(0);
        int cipher = 0;
        String out = String.valueOf(input.charAt(0));
        array[0] = input.charAt(0);

        for (int i = 1; i < input.length(); i++) {
            if ((int) input.charAt(i) == 35) {
                array[i] = -1;
                break;
            } else if ((int) input.charAt(i) == 32) {
                array[i] = 32;
                out = out.concat(" ");
            } else {
                cipher = ((int) input.charAt(i) + previousCipher) % key;
                array[i] = cipher;
                previousCipher = cipher;
                out = out.concat(String.valueOf((char) cipher));

            }
        }

    }


    /**
     * this method takes an array of integers which are the result of the encryption method
     * and reconverts them to a String
     * @param input the array of coded integers
     * @param key the encryption/decryption key
     * @return the decrypted String of characters
     */
    public static String decrypt(int[] input, int key) {
        int previousCipher = input[0];
        int decipher = 0;
        String out = String.valueOf((char) input[0]);

        for (int i = 1; i < input.length; i++) {
            if (input[i] == -1) {
                out = out.concat("#");
                break;
            } else if (input[i] == 32) {
                out = out.concat(" ");
            } else {
                decipher = (input[i] + key) - previousCipher;
                previousCipher = (int) input[i];
                out = out.concat(String.valueOf((char) decipher));
            }
        }

        return out;

    }

}
