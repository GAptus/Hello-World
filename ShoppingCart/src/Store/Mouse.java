package Store;

/**
 * Class Mouse
 * Provides the functionality for a mouse Product
 * @author giacomo
 *
 */
public class Mouse extends Product {

    private String description;
	private int dpi;
	private int numButtons;
	private String connectivity;
	
	/**
	 * Constructor
	 * assigns all the arguments to fields and constructs the product description
	 * @param number
	 * product number
	 * @param name
	 * product name
	 * @param price
	 * product price
	 * @param dpi
	 * mouse's dpi
	 * @param numButtons
	 * number of buttons on the mouse
	 * @param connectivity
	 * type of connectivity
	 */
	public Mouse(String number, String name, double price, int dpi, int numButtons, String connectivity) {
		super(number, name, price);
		this.dpi = dpi;
		this.numButtons = numButtons;
		this.connectivity = connectivity;
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Product Number: ");
		stringBuilder.append(super.getProductNumber());
		stringBuilder.append("\n");
		stringBuilder.append(super.getProductName());
		stringBuilder.append("\n£");
		stringBuilder.append(super.getProductPrice());
		stringBuilder.append("\nDPI: ");
		stringBuilder.append(dpi);
		stringBuilder.append("\nNumber of buttons: ");
		stringBuilder.append(numButtons);
		stringBuilder.append("/nConnectivity: ");
		stringBuilder.append(connectivity);
		
		this.description = stringBuilder.toString();
	}
	
	/**
	 * Method toString
	 * @return String containing the product specifications in the format it is read from the file
	 */
	public String toString() {
	    StringBuilder stringBuilder = new StringBuilder();
	    
	    stringBuilder.append(super.getProductNumber());
	    stringBuilder.append(",");
	    stringBuilder.append(super.getProductName());
	    stringBuilder.append(",");
	    stringBuilder.append(super.getProductPrice());
	    stringBuilder.append(",");
	    stringBuilder.append(dpi);
	    stringBuilder.append(",");
	    stringBuilder.append(numButtons);
	    stringBuilder.append(",");
	    stringBuilder.append(connectivity);
	    
	    return stringBuilder.toString();
    }
	
	/**
	 * Method getDescription
	 * @return String containing the products description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Method getDpi
	 * @return int containing the products dpi
	 */
	public int getDpi() {
		return dpi;
	}
	
	/**
	 * Method getNumButtons
	 * @return int containing the number of buttons of the product
	 */
	public int getNumButtons() {
		return numButtons;
	}
	
	/**
	 * Method getConnectivity
	 * @return String containing the type of connectivity of the product
	 */
	public String getConnectivity() {
		return connectivity;
	}
}
