/**
 * 
 */
package practicecar;

import java.util.HashMap;

/**
 * @author Edwin Ngwa Example of using an abstract superclass to provide an
 *         interface like behavior with the benefits of inheritance to close
 *         related subclasses
 */
public abstract class CarPart {

	private final String partId;
	private String partName;
	private int daysSinceLastService;
	private int errorCode;

	public CarPart(String partId, String partName, int daysSinceLastService, int errorCode) {

		this.partId = partId;
		this.setPartName(partName);
		this.daysSinceLastService = daysSinceLastService;
		this.setErrorCode(errorCode);
	}

	/**
	 * @return the partId
	 */
	public String getPartId() {
		return partId;
	}

	/**
	 * @return the partName
	 */
	public String getPartName() {
		return partName;
	}

	/**
	 * @param partName
	 *            the partName to set
	 */
	public void setPartName(String partName) {
		this.partName = partName;
	}

	/**
	 * @return the errorCode set code here
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the daysSinceLastService
	 */
	public int getDaysSinceLastService() {
		return daysSinceLastService;
	}

	/**
	 * @param daysSinceLastService
	 *            the daysSinceLastService to set
	 */
	public void setDaysSinceLastService(int daysSinceLastService) {
		this.daysSinceLastService = daysSinceLastService;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * 
	 * @param errorCode
	 */
   
	public abstract String ErrorCodeDiagnosis(int errorCode);

	public abstract String PartCondition();// int condition starts with 100 if goog and 0 if bad //status print the condition of the acr aprt 
	
	public abstract int ErrorCodeDiagnosis();
	
	private String condition(int cond) {
		//if
		HashMap <Integer, String> partCondition = new HashMap<>();
		partCondition.put(1, "Engine Light is on");
		return partCondition.get(cond);
	}
	public void Status(int cond) {
		 
		  System.out.println(condition(cond));
		   
	   }

	@Override
	public String toString() {

		return String.format("####%s Details####\n Part ID: %s\n Type: %s", this.getClass().getSimpleName(),
				getPartId(), getPartName());

	}

}