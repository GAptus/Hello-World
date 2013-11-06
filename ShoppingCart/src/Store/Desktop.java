package Store;

/**
 * Class Desktop
 * @author giacomo
 * Representation of a Desktop product
 */
public class Desktop extends Product {

    private String description;
    private String size;
    private int numUSBPorts;
    private String processor;
    private String graphicsCard;
    private int ramSize;
    private int hardDriveSize;

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
     * desktop size
     * @param numUSBPorts
     * number of usb ports in desktop
     * @param processor
     * desktop processor
     * @param graphicsCard
     * desktop graphics card
     * @param ramSize
     * desktop amount of ram
     * @param hardDriveSize
     * desktop hard drive size
     */
    public Desktop(String number, String name, double price, String size, int numUSBPorts, String processor,
                   String graphicsCard, int ramSize, int hardDriveSize) {
        super(number, name, price);
        this.size = size;
        this.numUSBPorts = numUSBPorts;
        this.processor = processor;
        this.graphicsCard = graphicsCard;
        this.ramSize = ramSize;
        this.hardDriveSize = hardDriveSize;
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Product Number: ");
        stringBuilder.append(super.getProductNumber());
        stringBuilder.append("\n");
        stringBuilder.append(super.getProductName());
        stringBuilder.append("\n£");
        stringBuilder.append(super.getProductPrice());
        stringBuilder.append("\nNumber of USB Ports: ");
        stringBuilder.append(numUSBPorts);
        stringBuilder.append("\nProcessor: ");
        stringBuilder.append(processor);
        stringBuilder.append("\nGraphics Card");
        stringBuilder.append(graphicsCard);
        stringBuilder.append("\nRAM: ");
        stringBuilder.append(ramSize);
        stringBuilder.append("\nHard Drive Size (gb): ");
        stringBuilder.append(hardDriveSize);
        
        this.description = stringBuilder.toString(); 
    }
    
    /**
     * Method toString
     * @return String containing the specification for the object in the format from which it has been read from file
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
        stringBuilder.append(numUSBPorts);
        stringBuilder.append(",");
        stringBuilder.append(graphicsCard);
        stringBuilder.append(",");
        stringBuilder.append(ramSize);
        stringBuilder.append(",");
        stringBuilder.append(hardDriveSize);

        return stringBuilder.toString();
    }

    /**
     * Method getDescription
     * @return String containing the description of the desktop
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method getSize
     * @return String containing the size of the desktop
     */
    public String getSize() {
        return size;
    }

    /**
     * Method getNumUSBPorts
     * @return int containing the number of usb ports for the desktop
     */
    public int getNumUSBPorts() {
        return numUSBPorts;
    }

    /**
     * Method getProcessor
     * @return String containing the processor of the desktop
     */
    public String getProcessor() {
        return processor;
    }

    /**
     * Method getGraphicsCard
     * @return String containing the graphics card of the desktop
     */
    public String getGraphicsCard() {
        return graphicsCard;
    }

    /**
     * Method getRamSize
     * @return int containing the ram size for the desktop
     */
    public int getRamSize() {
        return ramSize;
    }

    /**
     * Method getHardDriveSize
     * @return int containing the hard drive size for the desktop
     */
    public int getHardDriveSize() {
        return hardDriveSize;
    }
}
