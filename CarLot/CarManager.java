import java.util.*;
import java.io.*;


public class CarManager {
   private ArrayList<Car> cars;
   
   public CarManager(String file) throws FileNotFoundException {
      cars = new ArrayList<Car>();
      Scanner fileReader = new Scanner(new File(file));
      fileReader.nextLine();
      while (fileReader.hasNextLine()) {
         String name = fileReader.nextLine();
         Scanner singleCarData = new Scanner(fileReader.nextLine());
         this.cars.add(new Car(name, singleCarData.nextInt(), singleCarData.nextInt(), singleCarData.nextInt()));
      }
   }
   
   public void addCar(String name, int fuelCap, int fuelEfficiency, int mileage) {
      cars.add(new Car(name, fuelCap, fuelEfficiency, mileage));
   }
   
   public void removeCar(int index) {
      cars.remove(index);
   }
   
   public void switchCar(int i, String name, int fuelCap, int fuelEfficiency, int mileage) {
      cars.set(i, new Car(name, fuelCap, fuelEfficiency, mileage));
   }
   
   public void printCarInventory() {
      System.out.printf("%-23s %14s %6s %12s %9s\n", 
                        "   Car Name", "Fuel Capacity", "MPG", "Fuel Level", "Mileage");
      for (int i = 0; i < cars.size(); i++) {
         System.out.println(i + 1 + ": " + cars.get(i));
      }
      System.out.println();
   }
   
   public int getSize() {
      return cars.size();
   }
   
   public void drive(int miles, int index) {
      Car tempCar = cars.get(index);
      tempCar.drive(miles);
      cars.set(index, tempCar);
   }
   
   public void addGas(double gas, int index) {
      Car tempCar = cars.get(index);
      tempCar.addGas(gas);
      cars.set(index, tempCar);
   }
}