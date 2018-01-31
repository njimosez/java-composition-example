/**
 * @author Edwin Ngwa  3/3/2017
 * PuHUB 100 Practice Coding Exercise to 
 * demonstrates use of composition and inheritance
 *   
 */
package practicecar;

import java.util.ArrayList;

import java.util.Scanner;

public class Simulator {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<String> tireSpecs = new ArrayList<>();
		// add items for tire specification arraylist;
		tireSpecs.add("109");
		tireSpecs.add("35Z");
		tireSpecs.add("R19Y");
		tireSpecs.add(" 10");

		// Create subclasses objects to compose the car object

		Engine toyota = new Engine("1234", "5 cyl engine ", 30, 0, "Diesel", 1000, 6, true);
		FuelTank tank = new FuelTank("WET34", "Fuel Tank", 180, 1, 18.5, 70, 15);
		Wheels michelin = new Wheels("5467", "Tire", 365, 2, 9 / 32, tireSpecs);

		// create the composed car object and test functionalities
		Car mycar = new Car(toyota, tank, michelin);

		System.out.println("$$$$$$$$$ My Car Specs $$$$$$$$$$$");
		System.out.println(mycar);
		mycar.run();

		// Test functionality of engine child class

		System.out.println("########### Engine Condition####################");

		System.out.println("Your Car " + toyota.getPartName() + toyota.PartCondition());

		System.out.println("and" + toyota.ErrorCodeDiagnosis(2));

		// example of upcasting to test a unique engine subclass behavior not
		// extended from the superclass
		if (toyota instanceof Engine) {
			System.out.printf("Your %s engine can rotate at %d rpm\n", ((Engine) toyota).getModel(),
					((Engine) toyota).rpm());
		}

		// Test functionality of Wheels child class
		System.out.println(michelin);
		System.out.println("=== Tires Condition===");

		michelin.ErrorCodeDiagnosis(michelin.getErrorCode());
		System.out.println(michelin.PartCondition());

		// change values of the tire specifications arraylist

		System.out.print("Change Tire specifications ? Y(es)/N(o): ");
		String changeValue = input.next().toUpperCase();

		if (changeValue.charAt(0) == 'Y') {
			if (michelin instanceof Wheels) {
				((Wheels) michelin).changeTireSpecs(((Wheels) michelin).getTireSpecs());
			}
		}

		// Test functionality of FuelTank child class

		System.out.println("\n#############Fuel Tank##################");

		System.out.println(tank.milesPerGallon());
		System.out.println(tank.ErrorCodeDiagnosis(2));
		tank.PartCondition();
	}

}
