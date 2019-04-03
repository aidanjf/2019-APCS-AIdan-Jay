import java.util.*;

public class Birthday {
   public static void main (String[] args) {
      System.out.println("This program tells you how many days");
      System.out.println("it will be until your next birthday.");
      System.out.println();
      int currentDay = dayOfTheYear("today's date:");
      int birthday = dayOfTheYear("your birthday");
      printNextBirthday(birthday, currentDay);
      printBirthdayFact();
   }
   
   public static int dayOfTheYear(String prompt) {
      System.out.println("Please enter " + prompt);
      Scanner console = new Scanner(System.in);
      System.out.print("What is the month (1-12)? ");
      int month = console.nextInt();
      System.out.print("What is the day   (1-" + daysInEachMonth(month) + ")? ");
      int day = console.nextInt();
      int dayOfTheYear = computeDayOfTheYear(month, day);
      System.out.println(month + "/" + day + " is day #" + dayOfTheYear + " of 365.");
      System.out.println();
      return dayOfTheYear;
   }
   
   
   
   public static int computeDayOfTheYear(int month, int dayOfTheMonth) {
      int days = 0;
      for (int i = 1; i <= month - 1; i++) {
         days += daysInEachMonth(i);
      }
      days += dayOfTheMonth;
      return days;
   }
   
   public static int daysInEachMonth(int month) {
      if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
         return 31;
      } else if (month == 4 || month == 6 || month == 9 || month == 11) {
         return 30;
      } else {
         return 28;
      }
   }
   
   public static void printNextBirthday(int birthday, int currentDay) {
      int nextBirthday = birthday - currentDay;
      if (nextBirthday < 0) {
         nextBirthday = 365 + nextBirthday;
      }
      if (nextBirthday == 1) {
         System.out.println("Wow, your birthday is tomorrow!");
      } else if (nextBirthday == 0) {
         System.out.println("Happy birthday!");
      } else {
         System.out.println("Your next birthday is in " + nextBirthday + " days.");
      }
   }
   
   public static void printBirthdayFact() {
      System.out.println();
      System.out.println("Did you know that on September 10th, 2008 the Large Hadron Collider");
      System.out.println("at CERN powered up for the first time in Geneva, Switzerland?");
   }
}