package Products;

public class Mouse extends Product {
	
	private String description;
	private int dpi;
	private int numButtons;
	private boolean wireless;
	
	Mouse(String number, String name, double price, String description, int dpi, int numButtons, boolean wireless) {
		super(number, name, price);
		this.description = description;
		this.dpi = dpi;
		this.numButtons = numButtons;
		this.wireless = wireless;
	}

	public String getDescription() {
		return description;
	}

	public int getDpi() {
		return dpi;
	}

	public int getNumButtons() {
		return numButtons;
	}

	public boolean isWireless() {
		return wireless;
	}
}
