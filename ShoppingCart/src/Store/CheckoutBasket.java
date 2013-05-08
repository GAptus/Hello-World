package Store;

import Products.*;

public interface CheckoutBasket {
	
	public void addToBasket(Product p);
	
	public boolean removeFromBasket(Product p);
	
	public boolean checkoutBasket();
}
