package Products;

public class Desktop extends Product {
	
	private String description;
	private String size;
	private int numUSBPorts;
	private String processor;
	private String motherboard;
	private String graphicsCard;
	private int ramSize;
	private int hardDriveSize;
	
	Desktop(String number, String name, double price, int numUSBPorts, String processor, String motherboard, String graphicsCard, int ramSize, int hardDriveSize) {
		super(number, name, price);
		this.numUSBPorts = numUSBPorts;
		this.processor = processor;
		this.motherboard = motherboard;
		this.graphicsCard = graphicsCard;
		this.ramSize = ramSize;
		this.hardDriveSize = hardDriveSize;
	}

	public String getDescription() {
		return description;
	}

	public String getSize() {
		return size;
	}

	public int getNumUSBPorts() {
		return numUSBPorts;
	}

	public String getProcessor() {
		return processor;
	}

	public String getMotherboard() {
		return motherboard;
	}

	public String getGraphicsCard() {
		return graphicsCard;
	}

	public int getRamSize() {
		return ramSize;
	}

	public int getHardDriveSize() {
		return hardDriveSize;
	}
}
