/* Aidan Jay, Overlake APCS, 9/28/18
Project 2 - Space Needle: This program uses multiple methods, nested for loops, and a
class constant to print a digital space needle with a changeable size thanks to the class constant.
*/
public class SpaceNeedle {
   public static final int SIZE = 7;
   
   // Prints all parts of the space needle
   public static void main(String[] args) {
      tip();
      pyramid();
      bowl();
      tip();
      middle();
      pyramid();
   }
   
   // Prints the vertical line
   public static void tip() {
      for (int i = 1; i <= SIZE; i++) {
         for (int j = 0; j <= (SIZE * 3 - 1); j++) {
            System.out.print(" ");
         }
         System.out.println("||");
      }  
   }
   
   // Prints the pyramid part with semicolons inside
   public static void pyramid() {
      for (int i = 1; i <= SIZE; i++) {
         for (int j = 1; j <= -3 * i + (3 * SIZE); j++) {
            System.out.print(" ");
         }
         System.out.print("__/");
         for (int j = 1; j <= 3 * i - 3; j++) {
            System.out.print(":");
         }
         System.out.print("||");
         for (int j = 1; j <= 3 * i - 3; j++) {
            System.out.print(":");
         }
         System.out.println("\\__");
      }
      line();
   }
   
   // Prints the horizontal line with quotation marks
   public static void line() {
      System.out.print("|");
      for (int i = 1; i <= SIZE * 6; i++) {
         System.out.print("\"");
      }
      System.out.println("|");
   }
   
   // Prints the bowl containing backwards and forward slashes
   public static void bowl() {
      for (int i = 1; i <= SIZE; i++) {
         for (int j = 1; j <= 2 * i - 2; j++) {
            System.out.print(" ");
         }  
         System.out.print("\\_");
         for (int j = 1; j <= -2 * i + (SIZE * 3 + 1); j++) {
            System.out.print("/\\");
         }
         System.out.println("_/");
      }
   }
   
   // Prints the midsection of the space needle
   public static void middle() {
      for (int i = 1; i <= SIZE * SIZE; i++) {
         for (int j = 1; j <= (SIZE * 2 + 1); j++) {
            System.out.print(" ");
         }
         System.out.print("|");
         for (int j = 1; j <= SIZE - 2; j++) {
            System.out.print("%");
         }
         System.out.print("||");
         for (int j = 1; j <= SIZE - 2; j++) {
            System.out.print("%");
         }
         System.out.println("|");
      }
   }
}