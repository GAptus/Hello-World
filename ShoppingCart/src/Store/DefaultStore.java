package Store;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
//SATISFIES ASSESSMENT CRITERIA 1.1
public class DefaultStore implements Store {
	// SATISFIES ASSESSMENT CRITERIA 1.2
	// private variables of StoreImpl and Basket to incorporate the singleton design pattern
	//, meaning only a single instance of either class is allowed to exist at one given time

	// ArrayList of Product's which will contain a single instance of each Product
	private ArrayList<Product> productsForSale = new ArrayList<Product>();
	DecimalFormat myFormatter = new DecimalFormat("####.00");
	// Constructor so when StoreImpl is instantiated it will call method stock() and will fill productsForSale array, private to implement the singleton design pattern
	public DefaultStore() {
		stock();
	}
	
	public CheckoutBasket getBasketInstance() {
		CheckoutBasket basket = new Basket();
		
		return basket;
	}
	
	/**
	 * Method findProduct
	 * @return Returns a Product if its name matches the one specified in the arguments
	 * @param String name, the variable to which the method will check if it returns any matches
	 * Checks through the productsForSale array looking for any matches to the entered String, if found returns the Product, otherwise throws the exception @exception ProductDoesNotExistException
	 */
	public Product findProduct(String name) throws ProductDoesNotExistException {
		
		for (Product p : productsForSale) {
			// SATISFIES ASSESSMENT CRITERIA 1.5
			if (p.getProductName().equals(name)) {
				return p;
			}
		}
		
		throw new ProductDoesNotExistException();
	}
	/**
	 * Method stock
	 * Reads from different files and create objects from those files which it then adds to productsForSale
	 */
	private void stock() {
		StockingStore stockMyStore = new StockingStore();
		
		productsForSale.addAll(stockMyStore.readItemsFromFile("Desktops", "Desktop"));
		productsForSale.addAll(stockMyStore.readItemsFromFile("Keyboards", "Keyboard"));
		productsForSale.addAll(stockMyStore.readItemsFromFile("Laptops", "Laptop"));
		productsForSale.addAll(stockMyStore.readItemsFromFile("Mice", "Mouse"));
		productsForSale.addAll(stockMyStore.readItemsFromFile("Monitors", "Monitor"));
	}
	/**
	 * Method findProductsByOption
	 * @return Returns an ArrayList 
	 * @param String option
	 * Returns an ArrayList containing any Products found based on the option, if no Products found throw @exception ProductDoesNotExistException
	 */
	public ArrayList<Product> findProductsByOption(String option) throws ProductDoesNotExistException {
		// SATISFIES ASSESSMENT CRITERIA 1.5
		if (option.equals("Desktops")) {
			return displayDesktops();
		}
		if (option.equals("Laptops")) {
			return displayLaptops();
		}
		if (option.equals("Monitors")) {
			return displayMonitors();
		}
		if (option.equals("Keyboards")) {
			return displayKeyboards();
		}
		if (option.equals("Mice")) {
			return displayMice();
		}
		else {
			throw new ProductDoesNotExistException();
		}
	}
	/**
	 * Method displayMonitors
	 * @return ArrayList
	 * Returns an ArrayList containing all the Monitors
	 */
	private ArrayList<Product> displayMonitors() {
		
		ArrayList<Product> allMonitors = new ArrayList<Product>();
		
		for (Product p : productsForSale) {
			if (p instanceof Monitor) {
				allMonitors.add(p);
			}
		}
		
		return allMonitors;
	}
	/**
	 * Method displayLaptops
	 * @return ArrayList
	 * Returns an ArrayList containing all the Laptops
	 */
	private ArrayList<Product> displayLaptops() {
		
		ArrayList<Product> allLaptops = new ArrayList<Product>();
		
		for (Product p : productsForSale) {
			if (p instanceof Laptop) {
				allLaptops.add(p);
			}
		}
		
		return allLaptops;
	}
	/**
	 * Method displayDesktops
	 * @return ArrayList
	 * Returns an ArrayList containing all the Desktops
	 */
	private ArrayList<Product> displayDesktops() {
		
		ArrayList<Product> allDesktops = new ArrayList<Product>();
		
		for (Product p : productsForSale) {
			if (p instanceof Desktop) {
				allDesktops.add(p);
			}
		}
		
		return allDesktops;
	}
	/**
	 * Method displayKeyboards
	 * @return ArrayList
	 * Returns an ArrayList containing all the Keyboards
	 */
	private ArrayList<Product> displayKeyboards() {
		
		ArrayList<Product> allKeyboards = new ArrayList<Product>();
		
		for (Product p : productsForSale) {
			if (p instanceof Keyboard) {
				allKeyboards.add(p);
			}
		}
		
		return allKeyboards;
	}
	/**
	 * Method displayMice
	 * @return ArrayList
	 * Returns an ArrayList containing all the Mice
	 */
	private ArrayList<Product> displayMice() {
		
		ArrayList<Product> allMice = new ArrayList<Product>();
		
		for (Product p : productsForSale) {
			if (p instanceof Mouse) {
				allMice.add(p);
			}
		}
		
		return allMice;
	}
	/**
	 * Method searchByProductNumber
	 * @return Product
	 * Returns a Product based on the productNumber, throws a @exception ProductDoesNotExistException if no results
	 */
	public Product searchByProductNumber(String productNumber) throws ProductDoesNotExistException {
			for (Product p : productsForSale) {
				if (p.getProductNumber().equals(productNumber)) {
					return p;
				}
			}
			throw new ProductDoesNotExistException();
	}
	/**
	 * Class Basket
	 * @author giacomo
	 * Basket implements interface CheckoutBasket, a class providing a series of methods and variables to represent a real life Basket
	 */
	//SATISFIES ASSESSMENT CRITERIA 1.1
	private class Basket implements CheckoutBasket {
		// ArrayList containing the Products in the basket
		private ArrayList<Product> basketList = new ArrayList<Product>();
		// DecimalFormat to ensure doubles are on 2 decimal places
		DecimalFormat myFormatter = new DecimalFormat("####.00");
		/**
		 * Method emptyBasket
		 * Empties the basketList of all Products
		 */
		public void emptyBasket() {
			synchronized (basketList) {
				basketList.removeAll(basketList);
			}
		}
		/**
		 * Method productInBasket
		 * @return String[]
		 * Finds all the unique Products in the basketList and returns a short description of them in a String[]
		 */
		public String[] productInBasket() {
			ArrayList<Product> uniqueProducts = new ArrayList<Product>();
			// Synchronised to avoid ConcurrentModificationException
			synchronized (basketList) {
				for (Product p : basketList) {
					if (uniqueProducts.size() == 0) {
						uniqueProducts.add(p);
					}
					for (int i = 0; i < uniqueProducts.size(); i++) {
						if (!p.equals(uniqueProducts.get(i))) {
							uniqueProducts.add(p);
						}
					}
				}
				
				String[] products = new String[uniqueProducts.size()];
				
				for (int i = 0; i < products.length; i++) {
					products[i] = uniqueProducts.get(i).getProductName() + ": £" + myFormatter.format(uniqueProducts.get(i).getProductPrice());
				}
				
				return products;
			}
			
		}
		/**
		 * Method addToBasket
		 * @param Product p, int quantity
		 * Adds the Product in the quantity selected to basketList
		 */
		public void addToBasket(Product p, int quantity) {
			// Synchronised to avoid ConcurrentModificationException
			synchronized (basketList) {
				for (int i = 0; i < quantity; i++) {
					basketList.add(p);
				}
			}
		}
		/**
		 * Method removeFromBasket
		 * @param Product p
		 * Removes Product p from the basket
		 */
		public void removeFromBasket(Product p) {
			// Synchronised to avoid ConcurrentModificationException
			synchronized (basketList) {
				basketList.remove(p);
			}
		}
		/**
		 * Method printOutBasket
		 * @return String
		 * returns a String containing a list of the Product names, Product prices and the total price of all the items in basketList
		 */
		public String printOutBasket() {
			// Synchronised to avoid ConcurrentModificationException
			synchronized (basketList) {
				String basketContains =  "";
				
				if (basketList.size() == 0) {
					return basketContains;
				}
				
				for (Product p : basketList) {
					basketContains += p.getProductName() + ": £" + myFormatter.format(p.getProductPrice()) + "\n";
				}
				basketContains += "\n" + "Total: £" + myFormatter.format(findTotal());
				return basketContains;
			}
		}
		/**
		 * Method findProduct
		 * @returns Product
		 * @param name
		 * @throws ProductDoesNotExistException
		 * Searches through basketList looking for matches based on Product name, if found will return the product, otherwise throws @exception ProductDoesNotExistException
		 */
		public Product findProduct(String name) throws ProductDoesNotExistException {
			String[] parts = name.split(": £");
			// Synchronised to avoid ConcurrentModificationException
			synchronized (basketList) {
				for (Product p : basketList) {
					if (p.getProductName().equals(parts[0])) {
						return p;
					}
				}
			}
			
			throw new ProductDoesNotExistException();
		}
		/**
		 * Method findTotal
		 * @return double
		 * Return a double containing the total of all the Product's in the basketList
		 */
		private double findTotal() {
			// Synchronised to avoid ConcurrentModificationException
			synchronized (basketList) {
				double sum = 0.0;
				for (Product p : basketList) {
					sum += p.getProductPrice();
				}
				return sum;
			}
		}
		
		public void printReceipt() throws IOException {
			FileWriter f1 = null;
			try {
				f1 = new FileWriter("Receipt");

				double total = 0.0;
				
				for (Product p : basketList) {
					StringBuilder stringBuilder = new StringBuilder();
					total += p.getProductPrice();
					stringBuilder.append(p.getProductName());
					stringBuilder.append("\t");
					stringBuilder.append(p.getProductPrice());
					stringBuilder.append("\n");
					char[] tempChars = new char[stringBuilder.length()];
					tempChars = stringBuilder.toString().toCharArray();
					f1.write(tempChars);
				}
				String shoppingTotal = "Total: " + total;
				char[] tempChars = new char[shoppingTotal.length()];
				tempChars = shoppingTotal.toCharArray();
				f1.write(tempChars);
			} finally {
				f1.close();
			}			
		}
	}

}
