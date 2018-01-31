package practicecar;

import java.util.ArrayList;
import java.util.Scanner;

public class Wheels extends CarPart {

	private double tireTreadDepth;
	private ArrayList<String> tireSpecs = new ArrayList<>();
	Scanner input = new Scanner(System.in);

	public Wheels(String partId, String partName, int daysSinceLastService, int errorCode, double tireTreadDepth,
			ArrayList<String> tireSpecs) {

		super(partId, partName, daysSinceLastService, errorCode);
		this.tireTreadDepth = tireTreadDepth;
		this.tireSpecs = tireSpecs;
	}

	/**
	 * @return the tireThreadDepth
	 */
	public double getTireTreadDepth() {
		return tireTreadDepth;
	}

	/**
	 * @param tireThreadDepth
	 *            the tireTreadDepth to set
	 */
	public void setTireTreadDepth(double tireThreadDepth) {
		this.tireTreadDepth = tireThreadDepth;
	}

	/**
	 * @return the tireSpecs
	 */
	public String displayTireSpecs() {

		String result = String.join("", getTireSpecs());

		return result.toUpperCase();

	}

	/**
	 * @param tireSpecs
	 *            the tireSpecs to set
	 */
	public void changeTireSpecs(ArrayList<String> tireSpecs) {

		for (int i = 0; i < tireSpecs.size(); i++) {
			System.out.printf("(Position %d value : %s)Enter new value or 'q' to quit :", (i + 1), tireSpecs.get(i));
			String newValue = input.nextLine();
			if ((newValue.compareToIgnoreCase("q") == 0) || (newValue.isEmpty())) {
				continue;
			} else {

				tireSpecs.set(i, newValue);
			}
		}

	}

	// Divide the first by the last position items in Tire specification
	// Arraylist to get the tire load ratio
	public double tireLoadRatio() {

		double tireAspectRatio = Double.parseDouble(tireSpecs.get(0));
		double tireLoadRating = Double.parseDouble(tireSpecs.get(tireSpecs.size() - 1));

		return tireAspectRatio / tireLoadRating;

	}

	/**
	 * @return the tireThreadDepth
	 */
	public ArrayList<String> getTireSpecs() {
		return tireSpecs;
	}

	public String ErrorCodeDiagnosis(int errorCode) {
		String errorResult;
		if (errorCode == 1) {
			errorResult = PartCondition();
		}

		else {
			errorResult = "Check tire pressure";
		}
		return errorResult;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		// String engineSpecs = EngineSpecs();

		return String.format(" %s%n %s %s", super.toString(), "Tire Specification:", displayTireSpecs());

	}

	public String PartCondition() {
		String result;
		if (getTireTreadDepth() <= 10 / 32) {
			result = "tire has original tread depth ";
		} else if ((getTireTreadDepth() <= 10 / 32) || (getTireTreadDepth() >= 8 / 32)) {
			result = "tire is worn but useable";
		} else {
			result = " tire is bald and should be replaced";
		}

		return result + tireRotation();
	}

	@Override
	public int ErrorCodeDiagnosis() {
		int code;
		if (getTireTreadDepth() <= 10 / 32) {
			code = 90;
		} else if ((getTireTreadDepth() <= 10 / 32) || (getTireTreadDepth() >= 8 / 32)) {
			code = 45;
		} else {
			code =2;
		}
		return code;
	}
	public boolean tireRating() {

		return displayTireSpecs().contains("Y") ? true : false;

	}

	public String tireRotation() {

		String result;
		if ((getDaysSinceLastService() < 180) && (displayTireSpecs().contains("Y"))) {

			result = ",rated for high speed above 186 mph and does not need rotation";

		}

		else if ((getDaysSinceLastService() > 180) && (displayTireSpecs().contains("Y"))) {
			result = ", rated for high speed above 186 mph and needs to be rotated";
		}

		else if (getDaysSinceLastService() > 180) {

			result = ",rated for speed below 186 mph and needs rotation";

		}

		else {
			result = "Tire is rated for speed below 186 mph and needs to be rotated";
		}

		return result;

	}



}
