package UI;

import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import Store.Product;
import Store.ProductDoesNotExistException;

/**
 * Class BuildBuyCardPanel
 * Builds buy card panels
 * @author giacomo
 *
 */
public class BuildBuyCardPanel extends JPanel {
    
    private static final long serialVersionUID = 1L;

    private static final int SPINNER_LOWER_BOUND = 1;
    private static final int SPINNER_UPPER_BOUND = 100;
    private static final int SPINNER_START_VALUE = 1;
    private static final int SPINNER_INCREMENT_VALUE = 1;

    private static DecimalFormat decimalFormatterToTwoDecimalPlaces = new DecimalFormat("####.00");

    private JComboBox<String> comboBoxOfProductToSell;
    private JSpinner quantityOfProductToBuy;

    /**
     * Constructor
     * Adds two componenets
     * @param productsForSale
     * Contains the information required to build the components to be added to the panel
     * 
     */
    BuildBuyCardPanel(List<Product> productsForSale) {
        super();
        buildNewOptions(productsForSale);
    }

    /**
     * Method constructOptions
     * @param listOfProductsForSale
     * contains information for the method
     * @return String array containing the options for the JComboBox
     */
    private String[] constructOptions(List<Product> listOfProductsForSale) {
        String[] productsForSaleToBuy = new String[listOfProductsForSale.size()];

        for (int i = 0; i < productsForSaleToBuy.length; i++) {
            Product product = listOfProductsForSale.get(i);
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(product.getProductName());
            stringBuilder.append(": £");
            stringBuilder.append(decimalFormatterToTwoDecimalPlaces.format(product.getProductPrice()));

            productsForSaleToBuy[i] = stringBuilder.toString();
        }

        return productsForSaleToBuy;
    }

    /**
     * Method buildNewOptions
     * @param productsForSale
     * information for the method
     */
    private void buildNewOptions(List<Product> productsForSale) {
        quantityOfProductToBuy = new JSpinner(new SpinnerNumberModel(SPINNER_START_VALUE, SPINNER_LOWER_BOUND,
                                                                     SPINNER_UPPER_BOUND, SPINNER_INCREMENT_VALUE));
        comboBoxOfProductToSell = new JComboBox<String>(constructOptions(productsForSale));

        add(comboBoxOfProductToSell);
        add(quantityOfProductToBuy);
    }

    /**
     * Method getQuantity
     * @return int containing the quantity
     */
    public int getQuantity() {
        return (Integer) quantityOfProductToBuy.getValue();
    }
}
