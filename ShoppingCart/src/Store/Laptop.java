package Store;

/**
 * Class Laptop
 * Representation of a Laptop product
 * @author giacomo
 *
 */
public class Laptop extends Product {

	private String description;
	private double weight;
	private	double screenSize;
	private int hardDriveSize;
	private int numUSBPorts;
	private String processor;
	
	/**
	 * Constructor
	 * assigns all the arguments to fields and constructs the product description
	 * @param number
	 * product number
	 * @param name
	 * product name
	 * @param price
	 * product price
	 * @param weight
	 * Laptop weight
	 * @param screenSize
	 * laptop screen size
	 * @param hardDriveSize
	 * laptop hard drive size
	 * @param numUSBPorts
	 * number of usb ports on the laptop
	 * @param processor
	 * laptop processor
	 */
	public Laptop(String number, String name, double price, double weight,
			double screenSize, int hardDriveSize, int numUSBPorts, String processor) {
		super(number, name, price);
		this.weight = weight;
		this.screenSize = screenSize;
		this.hardDriveSize = hardDriveSize;
		this.numUSBPorts = numUSBPorts;
		this.processor = processor;
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Product Number: ");
		stringBuilder.append(super.getProductNumber());
		stringBuilder.append("\n");
		stringBuilder.append(super.getProductName());
		stringBuilder.append("\n£");
		stringBuilder.append(super.getProductPrice());
		stringBuilder.append("\nWeight(Kg): ");
		stringBuilder.append(weight);
		stringBuilder.append("\nScreen Size (inches): ");
		stringBuilder.append(screenSize);
		stringBuilder.append("\nHard Drive (Gb): ");
		stringBuilder.append(hardDriveSize);
		stringBuilder.append("\nNumber of USB Ports: ");
		stringBuilder.append(numUSBPorts);
		stringBuilder.append("\nProcessor: ");
		stringBuilder.append(processor);
		
		this.description = stringBuilder.toString();
	}
	
	/**
	 * Method toString
	 * @return String containing the objects specification in the format read from file
	 */
	public String toString() {
	    StringBuilder stringBuilder = new StringBuilder();
	    
	    stringBuilder.append(super.getProductNumber());
	    stringBuilder.append(",");
	    stringBuilder.append(super.getProductName());
	    stringBuilder.append(",");
	    stringBuilder.append(super.getProductPrice());
	    stringBuilder.append(",");
	    stringBuilder.append(weight);
	    stringBuilder.append(",");
	    stringBuilder.append(screenSize);
	    stringBuilder.append(",");
	    stringBuilder.append(hardDriveSize);
	    stringBuilder.append(",");
	    stringBuilder.append(numUSBPorts);
	    stringBuilder.append(",");
	    stringBuilder.append(processor);
	    
	    return stringBuilder.toString();
	}
	
	/**
	 * Method getDescription
	 * @return String containing the description of the product
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Method getWeight
	 * @return double containing the weight of the laptop
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Method getScreenSize
	 * @return double containing the screen size of the laptop
	 */
	public double getScreenSize() {
		return screenSize;
	}

	/**
	 * Method getHardDriveSize
	 * @return int containing the hard drive size of the laptop
	 */
	public int getHardDriveSize() {
		return hardDriveSize;
	}

	/**
	 * Method getNumUSBPorts
	 * @return int containing the number of usb ports on that laptop
	 */
	public int getNumUSBPorts() {
		return numUSBPorts;
	}
	
	/**
	 * Method getProcessor
	 * @return String containing the processor of the laptop
	 */
	public String getProcessor() {
		return processor;
	}
}
