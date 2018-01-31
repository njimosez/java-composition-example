package practicecar;

import java.util.InputMismatchException;
import java.util.Scanner;

/* @author Edwin Ngwa 
 *  Using a composition class a a blueprint for a car object with
 *  with different components objects (subclasses) related to a superclass
 *        
 */

public class Car {

	static Scanner input = new Scanner(System.in);

	private Engine engine;
	private FuelTank fueltank;
	private Wheels wheels;
	private double accelaration;
	private static final double REAR_AXLE_RATIO = 3.62;

	public Car(Engine engine, FuelTank fueltank, Wheels wheels) {
		this.engine = engine;
		this.fueltank = fueltank;
		this.wheels = wheels;
		this.accelaration = 0;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public FuelTank getFueltank() {
		return fueltank;
	}

	public void setFueltank(FuelTank fueltank) {
		this.fueltank = fueltank;
	}

	public Wheels getWheels() {
		return wheels;
	}

	public void setWheels(Wheels wheels) {
		this.wheels = wheels;
	}

	public double getAccelaration() {
		return accelaration;
	}

	private double getAcceleration(double transmissionGearRatio) {

		double carSpeed = (((0.00595) * (engine.rpm()) * (wheels.tireLoadRatio()))
				/ (transmissionGearRatio * REAR_AXLE_RATIO));

		if ((carSpeed > 180) && (wheels.tireRating())) {
			System.out.println(" Caution! you have exceeded your maximum rated tire speed ");
		}

		return carSpeed;

	}
	
	
	
	carAcceleration acceleration = (double transmissionGearRatio) -> {

		double carSpeed = (((0.00595) * (engine.rpm()) * (wheels.tireLoadRatio()))
				/ (transmissionGearRatio * REAR_AXLE_RATIO));

		if ((carSpeed > 180) && (wheels.tireRating())) {
			System.out.println(" Caution! you have exceeded your maximum rated tire speed ");
		}

		return "Your car is running at %.2f mph"+ carSpeed;

	};

	
	
	
	
	public void run() {

		boolean success = true;

		double carSpeed;

		if (getAccelaration() <= 0) {
			System.out.println("Car is not moving; Accelaration is " + getAccelaration());

		}

		int switchValue = 0;
		while (success) {

			
			try {
				System.out.print("\nChange Acceleration level (1-4, 5=quit) :");
				switchValue = input.nextInt();
				success = false;
				// Exception handler for inputs other than integer value
			} catch (InputMismatchException a) {

				System.out.println("Invalid data. Should be an integer");
				input.next();
			}

			switch (switchValue) {
			case 1:
				acceleration.getAcceleration(0.73);
			//	carSpeed = getAcceleration(0.73);
			//	System.out.printf("Your car is in Gear 1 and running at %.2f mph", carSpeed);
				success = true;
				break;
			case 2:
				acceleration.getAcceleration(0.63);
			//	carSpeed = getAcceleration(0.63);
			//	System.out.printf("Your car is in Gear 2 and running at %.2f mph ", carSpeed);
				success = true;
				break;
			case 3:
				acceleration.getAcceleration(0.54);
			//	carSpeed = getAcceleration(0.54);
			//	System.out.printf("Your car is in Gear 3 and running at %.2f mph", carSpeed);
				success = true;
				break;
			case 4:
				carSpeed = getAcceleration(0.40);
				System.out.printf("Your car is in Gear 4 and running at %.2f mph", carSpeed);
				success = true;
				break;
			case 5:
				carSpeed = 0;
				System.out.println("Your car will now stop running....");
				success = false;
				break;
			default:
				System.out.print("Invalid digit....");
				success = true;
				break;

			}

		}

	}

	@Override
	public String toString() {
		return " " + engine + "\n" + fueltank + "\n" + wheels + " \nCurrent Speed =" + accelaration + "mph";
	}

}

