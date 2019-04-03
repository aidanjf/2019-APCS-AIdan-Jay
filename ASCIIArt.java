import java.util.*;
import java.io.*;

public class ASCIIArt {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner file = new Scanner(new File("homer.txt"));
      char[][] a = readFile(file);
      display(a);
      //displayFlippedHoriz(a);
      System.out.println();
      displayFlippedVert(a);
   }
   
   public static char[][] readFile(Scanner file) throws FileNotFoundException {
      int height = file.nextInt();
      int width = file.nextInt();
      char[][] a = new char[height][width];
      for (int i = 0; i < height; i++) {
         for (int j = 0; j < width; j++) {
            a[i][j] = (char) file.nextInt();
         }
      
      }
      return a;
   }
   
   public static void display(char[][] a) {
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a[0].length; j++) {
            System.out.print(a[i][j]);
         }
         System.out.println();
      }
   }
   
   public static void displayFlippedHoriz(char[][] a) {
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a[i].length / 2; j++) {
            char temp = a[i][j];
            a[i][j] = a[i][a[i].length - 1 - j];
            a[i][a[i].length - 1 - j] = temp;
         }
      }
      display(a);
   }
   
   public static void displayFlippedVert(char[][] a) {
      for (int i = 0; i < a.length / 2; i++) {
         char[] temp = a[i];
         a[i] = a[a.length - 1 - i];
         a[a.length - 1 - i] = temp;
      }
      display(a);
   }
}