package Store;
/**
 * 
 * @author giacomo
 * Abstract Class Product
 * provides functionality for all Products extending from this class.
 */
public abstract class Product {
	private String productNumber;
	private String productName;
	private double productPrice;
	
	/**
	 * Constructor for a Product
	 * Sets fields for the 3 parameters entered 
	 * @param productNumber
	 * The product number
	 * @param productName
	 * The name of the product
	 * @param productPrice
	 * The price of the product
	 */
	Product(String productNumber, String productName, double productPrice) {
		this.productNumber = productNumber;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	/**
	 * Method getProductNumber
	 * @return String containing the product number
	 */
	public String getProductNumber() {
		return productNumber;
	}

	/**
	 * Method getProductName
	 * @return String containing the product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Method getProductPrice
	 * @return double containing the products price
	 */
	public double getProductPrice() {
		return productPrice;
	}
	
	public abstract String getDescription();
}
