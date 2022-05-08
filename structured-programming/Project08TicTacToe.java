package gr.aueb.cf.testbed.miniProjectsEaster;

import java.util.Scanner;

/**
 * Αναπτύξτε ένα παιχνίδι Τρίλιζα, όπου δύο παίκτες παίζουν Χ και Ο (ή 1 και 2 αν θέλετε
να υλοποιήσετε με πίνακα ακεραίων και όχι με πίνακα char) και κερδίζει ο παίκτης
που έχει συμπληρώσει τρία ίδια σύμβολα ή αριθμούς σε οποιαδήποτε διάσταση του πίνακα, οριζόντια, κάθετα ή διαγώνια.
Η main() μπορεί να ελέγχει τη ροή του παιχνιδιού, όπως ποιος παίκτης παίζει κάθε
φορά (εναλλαγή μεταξύ των δύο παικτών), να διαβάζει από το stdin το σύμβολο που
δίνει ο κάθε παίκτης και να εμφανίζει με γραφικό τρόπο (όπως είχαμε δει σε
αντίστοιχο παράδειγμα στην τάξη) την τρίλιζα μετά από κάθε κίνηση κάθε παίκτη.
Ενώ, μπορείτε να δημιουργήσετε και μία μέθοδο που να ελέγχει (μετά από κάθε
κίνηση) αν ο παίκτης που έκανε την κίνηση έκανε τρίλιζα.
Το πρόγραμμα θα πρέπει να λαμβάνει υπόψη την περίπτωση ισοπαλίας όπως και να
μην επιτρέπει ένας παίκτης να παίξει σε θέση που είναι ήδη κατειλημμένη.
 */

public class Project08TicTacToe {

    static int[][] board = new int[3][3];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        while (true) {
            menu();
            choice = in.nextInt();
            if (choice == 3) {
                System.out.println("Arrivederci!");
                break;
            } else if (choice == 2) {
                howToPlay();
            } else {
                initializeBoard();
                playTheGame();
            }

        }

        in.close();
    }


    /**
     * Method that handles the game turns and assignments
     */
    public static void playTheGame() {
        int xAxis, yAxis;
        int turn = 1;
        boolean player1 = true;
        boolean turnPlayed; //controller to loop if the player gives an invalid spot


        while (turn <= 9) { //loop runs 9 times due to the 9 available moves
            turnPlayed = false;
            if (player1) {
                while (!turnPlayed) { //controller loop for when a player selects an invalid spot
                    System.out.println("Player 1's turn. Please insert coordinates");
                    showBoard();

                    xAxis = in.nextInt();
                    yAxis = in.nextInt();

                    if (board[xAxis][yAxis] != 0) {
                        System.out.println("This spot is already taken!");
                    } else {
                        board[xAxis][yAxis] = 1;
                        turnPlayed = true; //controller to loop if the player gives an invalid spot, breaks inner loop
                        if (victoryConditions()) {
                            System.out.println("Player 1 wins!");
                            turn = 100;  //controller to break the outer loop
                            break;
                        }
                    }

                    player1 = false; //switch to player 2
                }
            } else {
                while (!turnPlayed) { //controller loop for when a player selects an invalid spot
                    System.out.println("Player 2's turn. Please insert coordinates");
                    showBoard();

                    xAxis = in.nextInt();
                    yAxis = in.nextInt();

                    if (board[xAxis][yAxis] != 0) {
                        System.out.println("This spot is already taken!");
                    } else {
                        board[xAxis][yAxis] = 2;
                        turnPlayed = true; //controller to loop if the player gives an invalid spot, breaks inner loop
                        if (victoryConditions()) {
                            System.out.println("Player 2 wins!");
                            turn = 100; //controller to break the outer loop
                            break;
                        }
                    }

                    player1 = true; //switch to player 1
                }
            }
            turn++;
        }

        //controller to mark the game as a draw, turn will never rise above 10 so to avoid using a different
        //variable, the value 100 is assigned for victory to break the outer loop. 10 breaks it naturally
        if (turn == 10) {
            System.out.println("This game is a draw!");
        }


    }


    /**
     * the method checks the board to see if any of the victory conditions are met
     * @return  returns true if any victory condition is met, false otherwise
     */
    public static boolean victoryConditions() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < 3; j++) {
                //victory conditions for horizontal rows
                if ((board[0][j] == board[1][j]) && (board[1][j] == board[2][j])) {
                    if((board[0][j] == board[1][j]) && (board[1][j] == board[2][j]) && (board[1][j] == 0)) {
                        //safeguard, game returned victory in every case due to the board being initialized to zero
                        break;
                    }
                    return true;
                }
            }

            //victory conditions for vertical rows
            if ((board[i][0] == board[i][1]) && (board[i][0] == board[i][2])) {
                if ((board[i][0] == board[i][1]) && (board[i][0] == board[i][2]) && (board[i][0] == 0)) {
                    //safeguard, game returned victory in every case due to the board being initialized to zero
                    break;
                }
                return true;
            }
        }

        //victory conditions for diagonal rows
        if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2])) {
            if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) && board[1][1] == 0) {
                //safeguard, game returned victory in every case due to the board being initialized to zero
                return false;
            }
            return true;
        } else if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0])){
            if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]) && board[1][1] == 0) {
                //safeguard, game returned victory in every case due to the board being initialized to zero
                return false;
            }
            return true;
        }

        return false;
    }


    /**
     * the method visualizes the board for the players, 0 for unclaimed spots,
     * 1 for spots claimed by Player 1 and 2 for spots claimed by Player 2
     */
    public static void showBoard() {
        for (int[] row : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * Simple method that prints the main menu
     */
    public static void menu() {
        System.out.println("Please select action:");
        System.out.println("1. New Game");
        System.out.println("2. How to Play");
        System.out.println("3. Exit");
    }


    /**
     * The method initializes the board setting all spots to 0 so that the players can play
     */
    public static void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 0;
            }
        }
    }


    /**
     * Instructions on how to play the game
     */
    public static void howToPlay() {
        System.out.println("This is a simple tic tac toe game for two players (Player 1 and 2)");
        System.out.println("Each player places a mark on the board, '1' for player 1 and '2' for player 2");
        System.out.println("Insert the coordinates of the spot you wish to select when your turn comes");
        System.out.println("Please insert the column and press enter. Then insert the row and press enter");
        System.out.println("The first player that has three marks in a row (horizontal, vertical or diagonal) wins");
        System.out.println("You cannot place your mark in the same spot as one already selected");
        System.out.println("Good luck!");
    }
}
