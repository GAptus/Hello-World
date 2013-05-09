package Products;

public class Laptop extends Product {
	
	private String description;
	private double weight;
	private	double screenSize;
	private int hardDriveSize;
	private int numUSBPorts;
	private String processor;
	
	Laptop(String number, String name, double price, String description, double weight,
			double screenSize, int hardDriveSize, int numUSBPorts, String processor) {
		super(number, name, price);
		this.description = description;
		this.weight = weight;
		this.screenSize = screenSize;
		this.hardDriveSize = hardDriveSize;
		this.numUSBPorts = numUSBPorts;
		this.processor = processor;
	}

	public String getDescription() {
		return description;
	}

	public double getWeight() {
		return weight;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public int getHardDriveSize() {
		return hardDriveSize;
	}

	public int getNumUSBPorts() {
		return numUSBPorts;
	}

	public String getProcessor() {
		return processor;
	}
}
