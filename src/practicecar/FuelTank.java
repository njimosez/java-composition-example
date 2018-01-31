package practicecar;

public class FuelTank extends CarPart {

	private double tankCapacity;
	private double fuelConsummed;
	private double fuelPumped;
	private double gasMileage;

	public FuelTank(String partId, String partName, int daysSinceLastService, int errorCode, double tankCapacity,
			double fuelPumped, double fuelConsummed) {

		super(partId, partName, daysSinceLastService, errorCode);
		this.tankCapacity = tankCapacity;
		this.fuelConsummed = fuelConsummed;
		this.fuelPumped = fuelPumped;
		this.gasMileage = 50;
	}

	/**
	 * @return the tankCapacity
	 */
	public double getTankCapacity() {
		return tankCapacity;
	}

	/**
	 * @param tankCapacity
	 *            the tankCapacity to set
	 */
	public void setTankCapacity(double tankCapacity) {
		this.tankCapacity = tankCapacity;
	}

	/**
	 * @return the fuelPumped
	 */
	public double getFuelPumped() {
		return fuelPumped;
	}

	/**
	 * @param fuelPumped
	 *            the fuelPumped to set
	 */
	public void setFuelPumped(double fuelPumped) {
		this.fuelPumped = fuelPumped;
	}

	/**
	 * @return the fuelConsummed
	 */
	public double getFuelConsummed() {
		return fuelConsummed;
	}

	/**
	 * @param fuelConsummed
	 *            the fuelConsummed to set
	 */
	public void setFuelConsummed(double fuelConsummed) {
		this.fuelConsummed = fuelConsummed;
	}

	/**
	 * @return the gasMileage
	 */
	public double getGasMileage() {

		return gasMileage;
	}

	/**
	 * @param gasMileage
	 *            the gasMileage to set
	 */
	public void setGasMileage(double gasMileage) {
		this.gasMileage = gasMileage;
	}

	public String ErrorCodeDiagnosis(int errorCode) {
		String errorResult;
		if ((errorCode == 1) && (FuelRemaining() == 0)) {
			errorResult = "You have no fuel";
		}

		else {
			errorResult = PartCondition();
		}
		return errorResult;
	}

	public double FuelRemaining() {
		return getFuelPumped() - getFuelConsummed();
	}

	public String PartCondition() {

		String result;
		if (FuelRemaining() >= (getTankCapacity() / 2)) {
			result = "Your gas tank is more than half full";
		} else {
			result = "Your gas tank is less than half full";
		}

		return result;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {

		return String.format(" %s%n %s %s%n %s%s%n %s%s", super.toString(), "Tank Capacity(gal) :", getTankCapacity(),
				"Fuel Remaining(gal): ", FuelRemaining(), "Gas Mileage(mpg): ", getGasMileage());

	}

	public String milesPerGallon() {
		String mpg = String.format("%.2f", (FuelRemaining() / getGasMileage()));
		String result;
		if ((getGasMileage() > 0)) {

			result = getPartName() + " is good for another " + mpg + " miles";

		}

		else {
			result = "The gas mileage value entered is less than or equals zero";

		}

		return result;

	}

	@Override
	public int ErrorCodeDiagnosis() {
		// TODO Auto-generated method stub
		return 0;
	}

}
