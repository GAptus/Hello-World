package Store;

import java.io.IOException;
import java.util.List;

/**
 * Interface CheckoutBasket
 * interface through which you interact with Basket.class
 * @author giacomo
 *
 */
public interface CheckoutBasket {
	
	public void addToBasket(Product p, int quantity);
	
	public void removeFromBasket(Product p);
	
	public Product findProduct(String name) throws ProductDoesNotExistException;
	
	public String printOutBasket();
	
	public List<String> productInBasket() throws EmptyBasketException;
	
	public void emptyBasket();
	
	public void printReceipt() throws IOException;
}
