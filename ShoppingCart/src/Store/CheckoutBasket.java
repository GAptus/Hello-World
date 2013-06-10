package Store;
//SATISFIES ASSESSMENT CRITERIA 1.1
public interface CheckoutBasket {
	
	public void addToBasket(Product p, int quantity);
	
	public void removeFromBasket(Product p);
	
	public Product findProduct(String name) throws ProductDoesNotExistException;
	
	public String printOutBasket();
	
	public String[] productInBasket() throws EmptyBasketException;
	
	public void emptyBasket();
}
