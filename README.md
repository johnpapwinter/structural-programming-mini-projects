# mini-projects
A collection of ten mini-projects created for the Coding Factory 2022

Project 1
----------------------------------------
Develop a Java app that will read integers from a file until it finds the value -1
(the file must contain more than 6 numbers and a max of 49 numbers) with a range from 1 to 49.
The numbers must be added to an array which will then be sorted (e.g. with Arrays.sort()).
Then, the app will produce all possible groupings of 6 numbers. After each group, it's going to filter it so that it adheres to the following criteria:
1) It contains at least 4 even numbers
2) it contains a maximum of 4 odd numbers
3) it has a max of 2 numbers in sequence,
4) it has at most 3 numbers that have the same ending
5) it has at most 3 numbers in the same ten.
Then, it prints out the groups in a txt file.


Project 2
----------------------------------------
Create an app for a mobile phone that can store up to 500 contacts. Each contact must have a first name, last name, and number.
To store the contacts, you must use a 500x3 array which stores the last name in the first column, the name in the second,
and the number in the third, all as a String.
Apply the basic CRUD operations: Search contact by number, insert contact (if it doesn't alreay exist,
update contact (if it exists), delete contact (if it exists).
Main() must show a menu to the user and the user will be able to select the operation or exit the app.


Project 3
----------------------------------------
Create an app that reads one by one the characters of a file and enters them in a 256x2 array.
The array is going to have two columns, the character will be placed in the first column
and the number of instances of each character appears in the file will be placed in the second column.
Spaces, new lines and any UTF-8 character is considered a character for the purposes of this app.
The main() will print out the statistics for each character, for example the frequency and the user
will be able to see them either sorted by character or sorted by frequency.


Project 4
----------------------------------------
You have a 2D array that contains data on car arrival and departure. The array has a format of arr[][] = {{1012, 1136}, {1317, 1417}, {1015, 1020}}.
Develop an app that reads and prints out the maximum number of cars that are parked concurently.
For example, in the array above the max number is 2: The first car came in 10:12 and left in 11:36, the third one came in 10:15 and left in 10:20.
Thus, the first and 3rd cars were present at the same time.


Project 5
----------------------------------------
You have a sorted array with repeating elements. Write an int[] getLowAndHighIndexOf(int[] arr, int key) method
that calculates and returns the low and high index values or an array arr taking an int key as a parameter.
Write a main() method that finds the low and high index for the array {0, 1, 4, 4, 4, 6, 7, 8, 8, 8, 8, 9}.
For example, if we provide the number 8 as a parameter, the method should return {7, 10}.


Project 6
----------------------------------------
You have an array of integers. Then, the maximum sub subarray is the continuous subarray that has
the greatest sum. Implement a linear algorithm (having a 0(n)) to solve the problem.
For example, if we have the array {−2, 1, −3, 4, −1, 2, 1, −5, 4},
then the continuous subarray with the max sum is {4, −1, 2, 1} the sum of which is 6.


Project 7
----------------------------------------
Write two methods that copy 2D arrays. An int[][] shallowCopy(int[][] arr) method
that copies a 2D array, but that the elements of the array are references to the original array.
Write also an int[][] deepCopy(int[][] arr) method. Write a main() method that demostrates why shallow copy
does not function as we want it to by changing an elements of an array of the copied array.
Demonstrate that the deep copy works by changing an element of the original array showing
that the copied array remains unchanged.


Project 8
----------------------------------------
Develop a tic-tac-toe game where two players play with X and O. The player that has three symbols
that are in sequence winds (be they horizontically, vertically, or diagonically).
The main() method can control the flow of the game (for example which player's turn it is),
read from stdin the symbol of each player and display the board after each player's move.
Create also a method that checks if the game. The app must take into account a draw result
and not allow a player to place his/her symbol in an already occupied spot.


Project 9
----------------------------------------
Μία από τις πρώτες εφαρμογές των Η/Υ ήταν η κρυπτογράφηση. Ένας απλός τρόπος κρυπτογράφησης
είναι η κωδικοποίηση κάθε χαρακτήρα με ένα ακέραιο με βάση ένα κλειδί κρυπτογράφησης.
Μία τέτοια μέθοδος κρυπτογράφησης περιγράφεται στη συνέχεια.
Κωδικοποίησε τον 1ο χαρακτήρα του μηνύματος με την ακέραια τιμή που αντιστοιχεί
σε αυτόν (από τον κώδικα ASCII). Κωδικοποίησε του επόμενους χαρακτήρες:
(α) προσθέτοντας την ακέραια ASCII τιμή του καθένα από αυτούς με τον κωδικό του προηγούμενού του,
(β) παίρνοντας το υπόλοιπο της διαίρεσης του αθροίσματος αυτού διά μία σταθερά.
Η σταθερά αυτή ονομάζεται κλειδί (key) κρυπτογράφησης και (υποτίθεται πως) είναι μυστική.
Υποθέτουμε πως τα μηνύματα τελειώνουν με τον χαρακτήρα #.
Γράψτε ένα πρόγραμμα java που να υλοποιεί τον αλγόριθμο κρυπτογράφησης έτσι
ώστε το κωδικοποιημένο μήνυμα που προκύπτει να είναι μία ακολουθία ακεραίων που τελειώνει με -1.
Γράψτε και τον αλγόριθμο αποκρυπτογράφησης που λαμβάνει ως είσοδο μία ακολουθία ακεραίων
που τελειώνει με -1 και υπολογίζει το αρχικό μήνυμα. 


Project 10
----------------------------------------
Έστω ένα θέατρο που έχει θέσεις όπου η κάθε θέση περιγράφεται με ένα χαρακτήρα
που είναι η στήλη και ένα αριθμό που είναι η σειρά. Για παράδειγμα, η θέση C2
βρίσκεται στη 2η σειρά και 3η στήλη.
Αναπτύξτε ένα πρόγραμμα διαχείρισης θεάτρου με 30 σειρές και 12 στήλες. Πιο
συγκεκριμένα γράψτε μία μέθοδο void book(char column, int row) που να κάνει book
μία θέση αν δεν είναι ήδη booked και μία μέθοδο void cancel(char column, int row)
που να ακυρώνει την κράτηση μία θέσης αν είναι ήδη booked.
Hint. Υποθέστε ότι ο δισδιάστατος πίνακας που απεικονίζει το θέατρο είναι ένα
πίνακας από boolean, όπου το true σημαίνει ότι η θέση είναι booked και false ότι δεν
είναι booked. Αρχικά όλες οι θέσεις πρέπει να είναι non-booked. 
 
