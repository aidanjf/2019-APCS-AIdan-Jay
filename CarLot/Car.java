import java.util.*;

public class Car {
	private int fuelEfficiency;	// miles per gallon
	private int fuelCapacity;		// gallons
	private double fuelLevel;
	private int mileage;
	private String name;
	
   private static final int NAME_MAX = 20;
	
	public Car(String name, int fuelCapacity, int fuelEfficiency, int mileage)	{
		if (fuelEfficiency <= 0 || mileage < 0 || fuelCapacity <= 0) {
			throw new IllegalArgumentException();
		}
      if (name.length() > NAME_MAX) {
			this.name = name.substring(0, 21);
		} else {
		   this.name = name;
      }
		this.fuelEfficiency = fuelEfficiency;
		this.fuelCapacity = fuelCapacity;
		fuelLevel = fuelCapacity / 2.0;
		this.mileage = mileage;
	}
	
	public String getName() {
		return name;
	}
	
	public int getFuelEfficiency() {
		return fuelEfficiency;
	}
	
	public int getMileage() {
       return mileage;
   }
	
	public int getFuelCapacity() {
		return fuelCapacity;
	}
	
	public double getFuelLevel() {
		return fuelLevel;
	}
	
	public void drive(int miles) {
      double newFuelLevel = fuelLevel - 1.0 * miles / fuelEfficiency;
		if (miles < 0) {
			throw new IllegalArgumentException("miles to drive cannot be negative");
		} else if (newFuelLevel < 0) {
      	throw new IllegalArgumentException("distance is too far");
      }
		mileage += miles;
		fuelLevel = newFuelLevel;
	}
	
	public void addGas(double gas) {
		if (gas < 0) {
			throw new IllegalArgumentException("gas amount to add cannot be negative");
		} else if (fuelLevel + gas > fuelCapacity) {
			throw new IllegalArgumentException("exceeds fuel capacity");
		}
		fuelLevel += gas;
	}
   
   public String toString() {
      return String.format("%-20s %14d %6d %12.1f %9d", name, fuelCapacity, fuelEfficiency, fuelLevel, mileage);
   }
}
	
	