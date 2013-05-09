package Store;

import Products.*;

public interface CheckoutBasket {
	
	public void addToBasket(Product p);
	
	public boolean removeBasket(Product p);
	
	public boolean checkoutBasket();
}
