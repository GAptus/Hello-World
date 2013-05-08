package Products;

public class Monitor extends Product {
	
	private String description;
	private double screenSize;
	private String resolution;
	private String aspectRatio;
	private int numUSBPorts;
	
	Monitor(String number, String name, double price, String description, double screenSize, String resolution, String aspectRatio, int numUSBPorts) {
		super(number, name, price);
		this.description = description;
		this.screenSize = screenSize;
		this.resolution = resolution;
		this.aspectRatio = aspectRatio;
		this.numUSBPorts = numUSBPorts;
	}

	public String getDescription() {
		return description;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public String getResolution() {
		return resolution;
	}

	public String getAspectRatio() {
		return aspectRatio;
	}

	public int getNumUSBPorts() {
		return numUSBPorts;
	}
}
