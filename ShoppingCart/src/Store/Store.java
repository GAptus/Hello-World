package Store;

import java.util.List;
/**
 * @author giacomo
 *
 * Interface to provide methods through which to access the DefaultStore class.
 *
 */
public interface Store {
	
    public List<Product> findProductsByOption(ProductType productType);
	
	public Product findProduct(String name) throws ProductDoesNotExistException;
	
	public Product searchByProductNumber(String number) throws ProductDoesNotExistException;
	
	public CheckoutBasket getShoppingBasket();
	
}
