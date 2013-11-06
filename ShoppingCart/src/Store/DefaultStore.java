package Store;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

/**
 * Class DefaultStore
 * representation of a store
 * @author giacomo
 *
 */
public class DefaultStore implements Store {
    
    /**
     * {@value}
     */
    final static DecimalFormat decimalFormatterTwoDecimalPlace = new DecimalFormat("####.00");
    
    private CheckoutBasket shoppingBasket;
    
    private Map<ProductType, List<Product>> productTypeToSelectionOfProductsMap;

    public DefaultStore(StockingStore stock) {
        productTypeToSelectionOfProductsMap = stock.getProductTypesToSelectionOfProductsMap();
        shoppingBasket = new Basket();
    }

    public CheckoutBasket getShoppingBasket() {
        return shoppingBasket;
    }

    /**
     * Method findProduct
     * 
     * @return Returns a Product if its name matches the one specified in the arguments
     * @param nameQuery
     * the variable to which the method will check if it returns any matches Checks through the
     * productsForSale array looking for any matches to the entered String, if found returns the Product,
     * otherwise throws the exception @exception ProductDoesNotExistException
     */
    public Product findProduct(String nameQuery) throws ProductDoesNotExistException {
        for (ProductType productType : ProductType.values()) {
            List<Product> listOfProductsToBeSearched = productTypeToSelectionOfProductsMap.get(productType.name());

            for (Product product : listOfProductsToBeSearched) {
                if (product.getProductName().equals(nameQuery)) {
                    return product;
                }

            }
        }

        throw new ProductDoesNotExistException();
    }

    /**
     * Method findProductsByOption
     * 
     * @return Returns an ArrayList
     * @param String
     * option Returns an ArrayList containing any Products found based on the option, if no Products found
     * throw @exception ProductDoesNotExistException
     */
    public List<Product> findProductsByOption(ProductType productType) {
        return productTypeToSelectionOfProductsMap.get(productType);
    }

    /**
     * Method searchByProductNumber
     * 
     * @return Product Returns a Product based on the productNumber, throws a @exception ProductDoesNotExistException if
     *         no results
     */
    public Product searchByProductNumber(String productNumberQuery) throws ProductDoesNotExistException {
        for (ProductType productType : ProductType.values()) {
            List<Product> listOfProductsToBeSearched = productTypeToSelectionOfProductsMap.get(productType.name());

            for (Product product : listOfProductsToBeSearched) {
                if (product.getProductNumber() == productNumberQuery) {
                    return product;
                }
            }
        }
        throw new ProductDoesNotExistException();
    }
   
}
