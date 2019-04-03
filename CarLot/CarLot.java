import java.util.*;
import java.io.*;

public class CarLot {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);		
      CarManager cars = initializeCars();		
      cars.printCarInventory();
      String response;
      do {
         System.out.print("Do you want to (D)rive, (A)dd gas, (M)odify inventory, or (Q)uit? ");
         response = console.next();
         if (!quit(response)) {
            if (response.equalsIgnoreCase("D")) {
               System.out.print("How many miles? ");
               cars.drive(console.nextInt(), whichCar(console, cars.getSize()));
            } else if (response.equalsIgnoreCase("M")) {
               modInventory(console, cars);
            } else {
               System.out.print("How much gas? ");
               cars.addGas(console.nextDouble(), whichCar(console, cars.getSize()));
            }
            System.out.println();
            cars.printCarInventory();
         }
      } while(!quit(response));
   }
	
   public static CarManager initializeCars() throws FileNotFoundException {      
      CarManager manager = new CarManager("cars.txt");
      return manager;
   }
	
   
   public static boolean quit(String response) {
      return !response.equalsIgnoreCase("D") && !response.equalsIgnoreCase("A") && !response.equalsIgnoreCase("M");
   }
   
   public static void modInventory(Scanner console, CarManager cars) {
      System.out.println();
      System.out.println("***INVENTORY MODIFICATION***");
      System.out.print("Do you want to add a (N)ew car, (R)emove a car, or (S)witch a car? ");
      String response = console.next();
      System.out.println();
      console.nextLine();
      if (response.equalsIgnoreCase("N")) {
         System.out.print("Car Name: ");
         String name = console.nextLine();
         System.out.print("Fuel Capacity: ");
         int fuelCap = console.nextInt();
         System.out.print("Fuel Efficiency: ");
         int fuelEff = console.nextInt();
         System.out.print("Mileage: ");
         int mileage = console.nextInt();
         cars.addCar(name, fuelCap, fuelEff, mileage);
      } else if (response.equalsIgnoreCase("R")) {
         cars.removeCar(whichCar(console, cars.getSize()));
      } else {
         System.out.print("Car Name: ");
         console.nextLine();
         String name = console.nextLine();
         System.out.print("Fuel Capacity: ");
         int fuelCap = console.nextInt();
         System.out.print("Fuel Efficiency: ");
         int fuelEff = console.nextInt();
         System.out.print("Mileage: ");
         int mileage = console.nextInt();
         cars.switchCar(whichCar(console, cars.getSize()), name, fuelCap, fuelEff, mileage);
      }
   }
   
   public static int whichCar(Scanner console, int size) {
      System.out.print("Which Car (1-" + size + ")? ");
      return console.nextInt() - 1;
   }
}