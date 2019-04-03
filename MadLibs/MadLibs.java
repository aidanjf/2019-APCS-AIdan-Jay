/* Aidan Jay, Overlake APCS, 1/9/2019
Project 5 - MadLibs: This program uses scanners placed on files and lines paired with a printstream object to print the created madlib to a file
to allow the user to either, create a madlib, view a madlib, or quit. The user intent is dealt with in the user
interface using a do-while loop which is based on whether the user types c, v, or q. Each different response
will either call another method to handle the desired task or quit, in the case of q. To create a madlib, a user is 
prompted for an input file until an existing one is given, and an output file name which will either be created
or overwritten. Then the user will be prompted for their desired words for the place holders. To view a madlib 
a user is prompted for their desired file, then it is printed. Finally, to quit, the program simply does nothing and ends.
*/
import java.util.*;
import java.io.*;

public class MadLibs {
   /** Manages all parts of the program: printing the intro, creating the user Scanner (which is passed into other methods),
    *  and creating a user interface where they can choose what task they want to program to carry
    *  out. This can be done an indefinite amount of times and the tasks can be called in any order
    *  through a do-while loop.
    *  Precondition: None.
    *  Postcondition: 
    *     -Intro will have been printed
    *     -User is prompted atleast once
    */
   public static void main(String[] args) throws FileNotFoundException {
      System.out.println("Welcome to the game of Mad Libs.");
      System.out.println("I will ask you to provide various words");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.");
      System.out.println();
      Scanner user = new Scanner(System.in);
      String userResponse;
      do {   
         System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
         userResponse = user.next();
         manageUserInterface(userResponse, user);
      } while (!(userResponse.equals("q")) && !(userResponse.equals("Q")));
   }
   
   /** Determines whether to call the create madlibs method or the view madlibs method using an if statement.
    *  Takes in a single char as the user's intent to determine this.
    *  Precondition: Char passed in as a parameter is either c or v. File exists, otherwise throws a
    *  FileNotFoundException.
    *  Postcondition:
    *     -None.
    */
   public static void manageUserInterface(String userIntent, Scanner user) throws FileNotFoundException {
      if (userIntent.equals("c") || userIntent.equals("C")) {        
         createMadLib(user);
      } else if (userIntent.equals("v") || userIntent.equals("V")) {
         viewMadLib(user);
      }
   }
   
   /** Creates the input file, output file, and the printstream for the output file. Takes in
    *  a console scanner to prompt the user for file names. Calls another method that does
    *  actual file writing. At the end, prints that the madlib was created.
    *  Precondition: Input file does have to exist. Throws a FileNotFoundException.
    *  Postcondition:
    *     -Output file has been created
    *     -"Your mad-lib has been created!" printed to the console
    */
   public static void createMadLib(Scanner user) throws FileNotFoundException {
      File input = promptForInputFile(user);
      System.out.print("Output file name: ");
      PrintStream writeOutput = new PrintStream(new File(user.next()));
      System.out.println();
      writeOutputFile(writeOutput, input, user);
      System.out.println("Your mad-lib has been created!");
      System.out.println();
   }
   
   /** Writes the actual output file. Takes in a printstream object, a file object, and a scanner object as parameters
    *  to do this. Processes through the file using a new scanner and each line of the file using an additional line scanner.
    *  Calls a method to prompt for a placeholder and prints the result to the file if the token is determined to be a place holder.
    *  Precondition: Input file is valid. Otherwise throws FileNotFoundException even though it will be valid thanks to the 
    *  promptForInputFile method.
    *  Postcondition: 
    *     -Output file has been written
    */
   public static void writeOutputFile(PrintStream writeOutput, File input, Scanner user) throws FileNotFoundException {
      user.nextLine();
      Scanner fileReader = new Scanner(input);
      while (fileReader.hasNextLine()) {
         Scanner line = new Scanner(fileReader.nextLine());
         while (line.hasNext()) {
            String token = line.next();
            if (token.charAt(0) == '<' && token.charAt(token.length() - 1) == '>') {
               System.out.print("Please type " + reformatToken(token) + ": ");
               token = user.nextLine();
            }
            writeOutput.print(token + " ");
         }
         writeOutput.println();
      }
   }
   
   /** Processes each placeholder token and returns a string with the correctly formatted placeholder and correct grammar.
    *  Takes in the token as a string to do this.
    *  Precondition: String parameter has to be a placeholder token.
    *  Postcondition: 
    *     -String containing the processed token is returned
    */
   public static String reformatToken(String token) {
      String prompt = token.substring(1, token.length() - 1);
      prompt = prompt.toLowerCase();
      prompt = prompt.replace("-", " ");
      if (prompt.charAt(0) == 'a' || prompt.charAt(0) == 'e' || prompt.charAt(0) == 'i' || prompt.charAt(0) == 'o'
            || prompt.charAt(0) == 'u') {
         return "an " + prompt;
      } else {
         return "a " + prompt;
      }
   }
   
   /** Takes in a console scanner to prompt the user for an input file by calling another method, then 
    *  prints it with correct spacing by creating a scanner then using the scanner to print each line.
    *  Precondition: Scanner is placed on valid file. Throws FileNotFoundException.
    *  Postcondition:
    *     -File is printed with correct spacing
    */
   public static void viewMadLib(Scanner user) throws FileNotFoundException {
      Scanner print = new Scanner(promptForInputFile(user));
      System.out.println();
      while (print.hasNextLine()) {
         System.out
            .print(print.nextLine());
         System.out.println();
         
      }
      System.out.println();
   }
   
   /** Takes in a console scanner as a parameter. Prompts the user for an input file 
    *  until a valid one is given using a while loop. Returns the input file object
    *  Precondition: None.
    *  Postcondition:
    *     -Valid input file object is returned
    */
   public static File promptForInputFile(Scanner user) {
      System.out.print("Input file name: ");
      File input = new File(user.next());
      while (!(input.exists())) {
         System.out.print("File not found. Try again: ");
         input = new File(user.next());
      }
      return input;
   }
}