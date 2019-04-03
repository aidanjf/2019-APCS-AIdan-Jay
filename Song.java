/* Aidan Jay, Overlake APCS, 9/21/18
Project 1 - Song: This program outputs a cumulative song using static methods. 
Each method contains println statements and almost all methods call on other methods.
*/
public class Song {
   // Prints every verse one by one
   public static void main(String[] args) {
      v1();
      v2();
      v3();
      v4();
      v5();
      v6();
      v7();
   }
   
   //Prints the 1st verse with a blank line after
   public static void v1() {
      System.out.println("On the 1st day of \"Xmas\", my true love gave to me");
      l1();
      System.out.println();
   }  
   
   //Prints the 2nd verse with a blank line after
   public static void v2() {
      System.out.println("On the 2nd day of \"Xmas\", my true love gave to me");
      l2();
      System.out.println();
   }   
   
   //Prints the 3rd verse with a blank line after
   public static void v3() {
      System.out.println("On the 3rd day of \"Xmas\", my true love gave to me");
      l3();
      System.out.println();
   }
   
   //Prints the 4th verse with a blank line after
   public static void v4() {
      System.out.println("On the 4th day of \"Xmas\", my true love gave to me");
      l4();
      System.out.println();
   }
   
   //Prints the 5th verse with a blank line after
   public static void v5() {
      System.out.println("On the 5th day of \"Xmas\", my true love gave to me");
      l5();
      System.out.println();
   }
   
   //Prints the 6th verse with a blank line after
   public static void v6() {
      System.out.println("On the 6th day of \"Xmas\", my true love gave to me");
      l6();
      System.out.println();
   }
   
   //Prints the 7th verse with a blank line after
   public static void v7() {
      System.out.println("On the 7th day of \"Xmas\",");
      l7();
      System.out.println();
   }
   
   //Prints the 1st recurring line
   public static void l1() {
      System.out.println("a partridge in a pear tree.");
   }
   
   //Prints the first 2 recurring lines
   public static void l2() {
      System.out.println("two turtle doves, and");
      l1();
   }
   
   //Prints the first 3 recurring lines
   public static void l3() {
      System.out.println("three French hens,");
      l2();
   }
   
   //Prints the first 4 recurring lines
   public static void l4() {
      System.out.println("four calling birds,");
      l3();
   }
   
   //Prints the first 5 recurring lines
   public static void l5() {
      System.out.println("five golden rings,");
      l4();
   }
   
   //Prints the all recurring lines
   public static void l6() {
      System.out.println("six geese a-laying,");
      l5();
   }
   
   //Prints all recurring lines and my own line
   public static void l7() {
      System.out.println("there's vomit on his sweater already, mom's spaghetti,");
      System.out.println("and my true love gave to me,");
      l6();
   }
}   