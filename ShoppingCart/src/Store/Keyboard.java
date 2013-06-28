package Store;
//SATISFIES ASSESSMENT CRITERIA 1.1
// SATISFIES ASSESSMENT CRITERIA 2.2 - Inheritance
public class Keyboard extends Product {
	// SATISFIES ASSESSMENT CRITERIA 1.2
	private String description;
	private String size;
	private String connectivity;
	
	public Keyboard(String number, String name, double price, String size, String connectivity) {
		super(number, name, price);
		this.size  = size;
		this.connectivity = connectivity;
		this.description = "Product Number: " + super.getProductNumber() + "\n"
							+ super.getProductName() + "         " + "£" + super.getProductPrice() + "\n"
							+ "Size: " + size + "\n"
							+ "Connectivity: " + connectivity;
	}
	
	public String toString() {
		return super.getProductNumber() + "," + super.getProductName() + "," + super.getProductNumber() + "," + size + "," + connectivity;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getSize() {
		return size;
	}

	public String getConnectivity() {
		return connectivity;
	}
}
