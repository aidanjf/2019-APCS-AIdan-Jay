/* Aidan Jay, Overlake APCS, 2/18/2019
Project 8 - Tic Tac Toe: Uses a 2d array and multiple Scanners to allow a user to play tic tac toe against an
unintelligent computer AI. It has 4 class constants for the size of the board, the String for an empty space, and the
String for the user character, and the String for the computer character. The game can also be played an indefinite amount of times
using a while loop.
*/
import java.util.*;

public class TicTacToe {
   
   public static final int SIZE = 3;
   public static final String empty = " ";
   public static final String user = "X";
   public static final String computer = "O";
   
   /** Initializes the 2d array for the board, creates the console scanner for the user, and contains the outer while loop
    *  which manages carrying out all the tasks for playing the game and reprompts the user for whether or not they want to play
    *  again.
    *  Preconditions: None.
    *  Postconditions:
    *     -Atleast one full cycle of the game has been completed.
    */
   public static void main(String[] args) {
      String userIntent = "Y";
      String[][] board = new String[SIZE][SIZE];
      Scanner console = new Scanner(System.in);
      while (userIntent.equals("Y")) {
         System.out.print("Let's play Tic-Tac-Toe");
         clearBoard(board);
         displayBoard(board);
         playOneGame(board, console);
         System.out.print("Play Again (Y or N)? ");
         userIntent = console.next();
         System.out.println();
      }
      System.out.println("Thanks for playing!");
   }
   
   /** Takes in the 2d board array of strings as a parameter and prints the board's contents formatted correctly to the console.
    *  Preconditions: board array has valid contents.
    *  Postconditions:
    *     -Board is displayed to the console.
    */
   public static void displayBoard(String[][] board) {
      System.out.println();
      displayLine(board, 0);
      for (int i = 1; i < SIZE; i++) {
         for (int j = 0; j < SIZE * 2 - 1; j++) {
            System.out.print("-");
         }
         System.out.println();
         displayLine(board, i);
      }
   }
   
   /** Takes in the 2d array of string as a parameter and the row as an integer parameter.
    *  Prints a single line of the board.
    *  Preconditions: board array has valid contents and row integer is a valid index of the array.
    *  Postconditions:
    *     -Single line of the board is printed.
    */
   public static void displayLine(String[][] board, int row) {
      System.out.print(board[row][0]);
      for (int i = 1; i < SIZE; i++) {
         System.out.print("|");
         System.out.print(board[row][i]);
      }
      System.out.println();
   }
   
   /** Takes in the 2d board array and the console scanner as parameters. Uses a do-while loop to successfully play 
    *  single game of tic tac toe and displays the results after.
    *  Preconditions: None.
    *  Postconditions:
    *     -A single game of tic tac toe is played and completed with results displayed.
    */
   public static void playOneGame(String[][] board, Scanner console) {
      do {
         System.out.println();
         System.out.println("Your Turn");
         userTurn(board, console);
         if (isGameOver(board).equals(empty)) {
            computerTurn(board);
         }
         displayBoard(board);
      } while (isGameOver(board).equals(empty));
      displayResult(isGameOver(board));
   }
   
   /** Takes in the 2d board array as a parameter and clears it by resetting each element to an empty space.
    *  Preconditions: None.
    *  Postconditions: Elements in array are set to empty space.
    */
   public static void clearBoard(String[][] board) {
      for (int i = 0; i < SIZE; i++) {
         for (int j = 0; j < SIZE; j++) {
            board[i][j] = empty;
         }
      }
   }
   
   /** Takes in the 2d board array and the console scanner as parameters. Prompts the user for a space on the board
    *  until a valid space is given using a while loop. Sets that space to the user String.
    *  Preconditions: None.
    *  Postconditions: A valid space on the board is set to the user String.
    */
   public static void userTurn(String board[][], Scanner console) {
      System.out.print("Row: ");
      int row = console.nextInt();     
      System.out.print("Column: ");
      int col = console.nextInt();
      
      while (row > SIZE || row < 1 || col > SIZE || col < 1 || !(isSpaceOpen(board, row - 1, col - 1))) {
         System.out.println("Sorry, that space is invalid, try again.");
         displayBoard(board);
         System.out.print("Row: ");
         row = console.nextInt();
         System.out.print("Column: ");
         col = console.nextInt();
      }
      board[row - 1][col - 1] = user;
   }
  
   /** Takes in the 2d board array as a parameter. Creates a random object and uses it to the row and column
    *  until an empty space is given using a while loop. Sets the valid board space as the computer String.
    *  Preconditions: None.
    *  Postconditions:
    *     -Valid space on the board is set to the computer String.
    */
   public static void computerTurn(String[][] board) {
      Random rand = new Random();
      int row = rand.nextInt(SIZE);
      int col = rand.nextInt(SIZE);
      while (!(isSpaceOpen(board, row, col))) {
         row = rand.nextInt(SIZE);
         col = rand.nextInt(SIZE);
      }
      board[row][col] = computer;
   }
   
   /** Takes in the 2d board array as a parameter and checks if there is a winner, if the it's a "cat's game", or if the
    *  game isn't over yet. Uses multiple for loops to check each situation and will return the winner character if there is one.
    *  Otherwise returns the string "full" indicating a full board, or and empty string.
    *  Preconditions: None.
    *  Postconditions: 
    *     -Returns a String of either the winner character, a full board, or an empty string to indicate the game isn't complete.
    */
   public static String isGameOver(String board[][]) {
      //Checks the rows
      for (int i = 0; i < SIZE; i++) {
         //Stores the first String of the row
         String rowcheck = board[i][0];
         if (!(rowcheck.equals(" "))) {
            for (int j = 1; j < SIZE; j++) {
               //Breaks out of this iteration if the character isn't the same as the first one in the row stored in the temp variable
               if (!(board[i][j].equals(rowcheck))) {
                  break;
               } else if (j == SIZE - 1) {
                  return rowcheck;
               }
               
            }
         }
      }
      
      //Checks the columns
      for (int i = 0; i < SIZE; i++) {
         //Stores the first String of the column
         String colcheck = board[0][i];
         if (!(colcheck.equals(" "))) {
            for (int j = 1; j < SIZE; j++) {
               //Breaks out of this iteration if the character isn't the same as the first one in the col stored in the temp variable
               if (!(board[j][i].equals(colcheck))) {
                  break;
               } else if (j == SIZE - 1) {
                  return colcheck;
               }
               
            }
         }
      }
      
      //Checks the downward diagonal
      String diagcheck1 = board[0][0];
      if (!(diagcheck1.equals(empty))) {
         for (int i = 1; i < SIZE; i++) {
            if (!(board[i][i].equals(diagcheck1))) {
               break;
            } else if (i == SIZE - 1) {
               return diagcheck1;
            }
         }
      }
      
      //Checks the upward diagonal
      String diagcheck2 = board[2][0];
      if (!(diagcheck2.equals(empty))) {
         for (int i = 1; i < SIZE; i++) {
            if (!(board[SIZE - 1 - i][i].equals(diagcheck2))) {
               break;
            } else if (i == SIZE - 1) {
               return diagcheck2;
            }
         }
      }
      
      //If none of the other checks return a winner this checks if the board is full and returns full or the empty string accordingly
      if (isBoardFull(board)) {
         return "full";
      } else {
         return empty;
      }
   }
   
   /** Takes in the 2d board array as a parameter. Checks if the board is full, returns true if it is, returns false otherwise.
    *  Preconditions: None.
    *  Postconditions: 
    *     -True or false is returned depending on whether or not the board is full.
    */
   public static boolean isBoardFull(String[][] board) {
      for (int i = 0; i < SIZE; i++) {
         for (int j = 0; j < SIZE; j++) {
            if (board[i][j].equals(" ")) {
               return false;
            }
         }
      }
      return true;
   }
   
   /** Takes in the 2d board array, a row index, and a column index as parameters. Checks if the row and column parameter indexes
    *  correspond to an open space. Returns true is the space is open, false otherwise.
    *  Preconditions: None.
    *  Postconditions: 
    *     -True or false is returned depending on whether or not the indicated space on the board is open.
    */
   public static boolean isSpaceOpen(String board[][], int row, int col) {
      return (board[row][col] == " ");
   }
   
   /** Takes in the winner String as a parameter("X", "O", or "full"). Prints either the user winner sentence, the computer sentence,
    *  or that "it's a cat's game," depending on who winner String corresponds to.
    *  Preconditions: None.
    *  Postconditions:
    *     -Results are printed depending on the winner string parameter.
    */
   public static void displayResult(String winner) {
      System.out.println();
      if (winner.equals(user)) {
         System.out.println("Congratulations player! You are the winner!!!");
      } else if (winner.equals(computer)) {
         System.out.println("Sorry player, the computer won.  Better luck next time.");
      } else {
         System.out.println("It is a cat's game.");
      }
   }
}