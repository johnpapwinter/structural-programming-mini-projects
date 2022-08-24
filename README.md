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
Γράψτε δύο μεθόδους που αφορούν την αντιγραφή δισδιάστατων πινάκων. Μία μέθοδο int[][] shallowCopy(int[][] arr)
που αντιγράφει ένα δισδιάστατο πίνακα αλλά μόνο τις τιμές του βασικού πίνακα που είναι αναφορές στους πίνακες
που είναι στοιχεία του βασικού πίνακα. Και μία μέθοδο int[][] deepCopy(int[][] arr).
Γράψτε μία main που να δείχνετε γιατί το shallow copy δεν δουλεύει όπως θα θέλαμε,
αφού αλλάζοντας ένα στοιχείο ενός πίνακα από δύο για παράδειγμα copies, αλλάζει το στοιχείο και στον άλλο πίνακα,
αφού κατά βάση πρόκειται για ένα και μόνο κοινό στοιχείο (αφού έχει γίνει shallow copy).
Δείξτε και την περίπτωση του deep copy. Δείξτε ότι δουλεύει όπως θα θέλαμε. Δηλαδή δεν επηρεάζουν
οι αλλαγές στοιχείων το κάθε copy, το οποίο τώρα είναι ανεξάρτητο.


Project 8
----------------------------------------
Αναπτύξτε ένα παιχνίδι Τρίλιζα, όπου δύο παίκτες παίζουν Χ και Ο (ή 1 και 2 αν θέλετε
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
 
