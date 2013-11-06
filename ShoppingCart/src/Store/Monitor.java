package Store;
/**
 * Class Monitor
 * Representation of a Monitor product
 * @author giacomo
 *
 */
public class Monitor extends Product {
	
	private String description;
	private double screenSize;
	private String resolution;
	private String aspectRatio;
	private int numUSBPorts;
	
	/**
	 * Contructor
	 * assigns all the arguments to fields and constructs the product description
	 * @param number
	 * product number
	 * @param name
	 * product name
	 * @param price
	 * product price
	 * @param screenSize
	 * monitor screen size
	 * @param resolution
	 * monitor resolution
	 * @param aspectRatio
	 * monitor aspect ratio
	 * @param numUSBPorts
	 * number of usb ports on the monitor
	 */
	public Monitor(String number, String name, double price, double screenSize, String resolution, String aspectRatio, int numUSBPorts) {
		super(number, name, price);
		this.screenSize = screenSize;
		this.resolution = resolution;
		this.aspectRatio = aspectRatio;
		this.numUSBPorts = numUSBPorts;
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Product Number: ");
		stringBuilder.append(super.getProductNumber());
		stringBuilder.append("\n£");
		stringBuilder.append(super.getProductPrice());
		stringBuilder.append("\nScreenSize(inches): ");
		stringBuilder.append(screenSize);
		stringBuilder.append("\nResolution: ");
		stringBuilder.append(resolution);
		stringBuilder.append("\nAspect Ratio: ");
		stringBuilder.append(aspectRatio);
		stringBuilder.append("\nNumber of USB ports: ");
		stringBuilder.append(numUSBPorts);
		
		this.description = stringBuilder.toString();
	}
	
	/**
	 * Method toString
	 * @return String containing the product specification in the format read from the file
	 */
	public String toString() {
	    StringBuilder stringBuilder = new StringBuilder();
	   
	    stringBuilder.append(super.getProductNumber());
	    stringBuilder.append(",");
	    stringBuilder.append(super.getProductName());
	    stringBuilder.append(",");
	    stringBuilder.append(super.getProductPrice());
	    stringBuilder.append(",");
	    stringBuilder.append(screenSize);
	    stringBuilder.append(",");
	    stringBuilder.append(resolution);
	    stringBuilder.append(",");
	    stringBuilder.append(aspectRatio);
	    stringBuilder.append(",");
	    stringBuilder.append(numUSBPorts);
		
	    return stringBuilder.toString();
	}
	
	/**
	 * Method getDescription
	 * @return String containing the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Method getScreenSize
	 * @return double containing the screens size
	 */
	public double getScreenSize() {
		return screenSize;
	}

	/**
	 * Method getResolution
	 * @return String containing the monitors resolution
	 */
	public String getResolution() {
		return resolution;
	}

	/**
	 * Method getAspectRatio
	 * @return String containing the monitors aspect ratio
	 */
	public String getAspectRatio() {
		return aspectRatio;
	}

	/**
	 * Method getNumUSBPorts
	 * @return int containing the number of usb ports for that product
	 */
	public int getNumUSBPorts() {
		return numUSBPorts;
	}
}
