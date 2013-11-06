package Store;

/**
 * Class Keyboard
 * Representation of a keyboard object
 * @author giacomo
 *
 */
public class Keyboard extends Product {
    
    private String description;
    private String size;
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
     * @param size
     * keyboard size
     * @param connectivity
     * keyboard connectivity
     */
    public Keyboard(String number, String name, double price, String size, String connectivity) {
        super(number, name, price);
        this.size = size;
        this.connectivity = connectivity;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Product Number: ");
        stringBuilder.append(super.getProductNumber());
        stringBuilder.append("\n");
        stringBuilder.append(super.getProductName());
        stringBuilder.append("\n£");
        stringBuilder.append(super.getProductPrice());
        stringBuilder.append("\nSize: ");
        stringBuilder.append(size);
        stringBuilder.append("\nConnectivity: ");
        stringBuilder.append(connectivity);

        this.description = stringBuilder.toString();
    }

    /**
     * Method toString
     * @return String containing the specification for the object in the format from which it was read from the file
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append(super.getProductNumber());
        stringBuilder.append(",");
        stringBuilder.append(super.getProductName());
        stringBuilder.append(",");
        stringBuilder.append(super.getProductPrice());
        stringBuilder.append(",");
        stringBuilder.append(size);
        stringBuilder.append(",");
        stringBuilder.append(connectivity);
        
        return stringBuilder.toString();
    }

    /**
     * Method getDescription
     * @return String containing a description of the keyboard
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method getSize
     * @return String containing the size of the keyboard
     */
    public String getSize() {
        return size;
    }
    
    /**
     * Method getConnectivity
     * @return String containing the connectivity of the keyboard
     */
    public String getConnectivity() {
        return connectivity;
    }
}
