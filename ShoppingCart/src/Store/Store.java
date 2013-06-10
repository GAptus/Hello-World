package Store;

import java.util.ArrayList;
//SATISFIES ASSESSMENT CRITERIA 1.1
public interface Store {
	
	public ArrayList<Product> findProductsByOption(String option) throws ProductDoesNotExistException;
	
	public CheckoutBasket getBasketInstance();
	
	public Product findProduct(String name) throws ProductDoesNotExistException;
	
	public Product searchByProductNumber(String number) throws ProductDoesNotExistException;
	
}
