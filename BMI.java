import java.util.*;

public class BMI {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      System.out.println("This program reads data for two people and\ncomputes their body mass index (BMI).");
   
      System.out.println();
   
      double bmi1 = BMI(console);
   
      System.out.println();
      
      double bmi2 = BMI(console);   
   
      results("Person 1", bmi1);
      results("Person 2", bmi2);
      System.out.println("\nrdDifference = " + Math.abs(bmi1 - bmi2)); 
   }
   
   public static double BMI(Scanner console) {
      System.out.println("Enter next person's information:");
      System.out.print("height (in inches)? ");
      double height = console.nextDouble();
      System.out.print("weight (in pounds)? ");
      double weight = console.nextDouble();
      return(weight / (height * height) * 703);  
   }
   
   public static void results(String person, double bmi) {
      System.out.println("\n" + person + " BMI = " + bmi);
      if (bmi < 18.5) {
         System.out.print("underweight");
      } else if (bmi <= 24.9) {
         System.out.print("normal");
      } else if (bmi <= 29.9) {
         System.out.print("overweight");
      } else if (bmi >= 30.0) {
         System.out.print("obese");
      }
   }
}