package practicecar;

public class Engine extends CarPart {

	private String model;
	private int engineSpeed;
	private int torque;
	private boolean engineLight;

	public Engine(String partId, String partName, int daysSinceLastService, int errorCode, String model,
			int engineSpeed, int torque, boolean engineLight) {

		super(partId, partName, daysSinceLastService, errorCode);
		this.model = model;
		this.engineSpeed = engineSpeed;
		this.torque = torque;
		this.engineLight = engineLight;

	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the engineSpeed
	 */
	public int getEngineSpeed() {
		return engineSpeed;
	}

	/**
	 * @param engineSpeed
	 *            the engineSpeed to set
	 */
	public void setEngineSpeed(int engineSpeed) {
		this.engineSpeed = engineSpeed;
	}

	/**
	 * @return the torque
	 */
	public int getTorque() {
		return torque;
	}

	/**
	 * @param torque
	 *            the torque to set
	 */
	public void setTorque(int torque) {
		this.torque = torque;
	}

	/**
	 * @return the engineLight
	 */
	public boolean isEngineLight() {
		return engineLight;
	}

	/**
	 * @param engineLight
	 *            the engineLight to set
	 */
	public void setEngineLight(boolean engineLight) {
		this.engineLight = engineLight;
	}

	public String ErrorCodeDiagnosis(int errorCode) {
		String result;
		if (errorCode == 1) {
			result = "Your check engine light is on";
		} else if (errorCode < 1) {
			result = "Engine service overdue";
		} else {
			result = " Engine service due soon";
		}
		return result;
	}
	
	

	public int rpm() {
		return (this.engineSpeed * this.torque);
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		// String engineSpecs = EngineSpecs();

		return String.format("%s%s%s%s%d%n%s%d", super.toString(), "\nModel:", getModel(), "\nEngine Speed:",
				getEngineSpeed(), "Engine Torque:", getTorque());

	}

	public String PartCondition() {
		String result = (getDaysSinceLastService() < 180) && (isEngineLight() == false) ? "runs good"
				: "needs inspection";

		return result;
	}

	@Override
	public int ErrorCodeDiagnosis() {
		
			int code;
			if ((getDaysSinceLastService() < 180) && (isEngineLight() == false)) {
				code = 100;
			} else if ((getDaysSinceLastService() > 180)) {
				code = 50;
			} else if (isEngineLight()){
				code = 0;
			}
			else {code = 99;}
			return code;
		}
	

}
