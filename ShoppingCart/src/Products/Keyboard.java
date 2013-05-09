package Products;

public class Keyboard extends Product {
	
	private String description;
	private String size;
	private boolean wireless;
	
	Keyboard(String number, String name, double price, String description, String size, boolean wireless) {
		super(number, name, price);
		this.description = description;
		this.size  = size;
		this.wireless = wireless;
	}

	public String getDescription() {
		return description;
	}

	public String getSize() {
		return size;
	}

	public boolean isWireless() {
		return wireless;
	}
}
