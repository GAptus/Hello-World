package Store;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class StoreImpl implements Store {
	
	private List<Product> productsForSale = new ArrayList<Product>();
	
	public void stock() {
		StockingStore stockMyStore = new StockingStore();
		
		productsForSale.addAll(stockMyStore.readItemsFromFile("Desktops", "Desktop"));
		productsForSale.addAll(stockMyStore.readItemsFromFile("Keyboards", "Keyboard"));
		productsForSale.addAll(stockMyStore.readItemsFromFile("Laptops", "Laptop"));
		productsForSale.addAll(stockMyStore.readItemsFromFile("Mice", "Mouse"));
		productsForSale.addAll(stockMyStore.readItemsFromFile("Monitors", "Monitor"));
	}
	
	public ArrayList<String> displayAllProducts() {
		
		ArrayList<String> allProducts = new ArrayList<String>();
		
		for (Product p : productsForSale) {
			allProducts.add(p.getDescription());
		}
		
		return allProducts;
	}

	public ArrayList<String> displayMonitors() {
		
		ArrayList<String> allMonitor = new ArrayList<String>();
		
		for (Product p : productsForSale) {
			if (p instanceof Monitor) {
				Monitor m = (Monitor) p;
				allMonitor.add(m.getDescription());
			}
		}
		
		return allMonitor;
	}

	public ArrayList<String> displayLaptops() {
		
		ArrayList<String> allLaptops = new ArrayList<String>();
		
		for (Product p : productsForSale) {
			if (p instanceof Laptop) {
				Laptop l = (Laptop) p;
				allLaptops.add(l.getDescription());
			}
		}
		
		return allLaptops;
	}

	public ArrayList<String> displayDesktops() {
		
		ArrayList<String> allDesktops = new ArrayList<String>();
		
		for (Product p : productsForSale) {
			if (p instanceof Desktop) {
				Desktop d = (Desktop) p;
				allDesktops.add(d.getDescription());
			}
		}
		
		return allDesktops;
	}

	public ArrayList<String> displayKeyboards() {
		
		ArrayList<String> allKeyboards = new ArrayList<String>();
		
		for (Product p : productsForSale) {
			if (p instanceof Keyboard) {
				Keyboard k = (Keyboard) p;
				allKeyboards.add(k.getDescription());
			}
		}
		
		return allKeyboards;
	}

	public ArrayList<String> displayMice() {
		
		ArrayList<String> allMice = new ArrayList<String>();
		
		for (Product p : productsForSale) {
			if (p instanceof Mouse) {
				Mouse m = (Mouse) p;
				allMice.add(m.getDescription());
			}
		}
		
		return allMice;
	}

	public ArrayList<String> searchKeyword(String keyword) {
		
		ArrayList<String> allKeywordMatches = new ArrayList<String>();
		
		for (Product p : productsForSale) {
			if (p.getDescription().contains(keyword));
				allKeywordMatches.add(p.getDescription());
		}
		
		return allKeywordMatches;
	}
	
	public Product searchByProductNumber(String productNumber) throws ProductDoesNotExistException {
			for (Product p : productsForSale) {
				if (p.getProductNumber().equals(productNumber)) {
					return p;
				}
			}
			throw new ProductDoesNotExistException();
	}
	
	class Basket implements CheckoutBasket {
		List<Product> basketList = new ArrayList<Product>();

		public void addToBasket(Product p) {
			basketList.add(p);
		}

		public void checkoutBasket() throws IOException {
			FileWriter fw = new FileWriter("Receipt");
			
			for (Product p : basketList) {
				fw.write(p.getProductName() + "   " + p.getProductPrice());
			}
			
			fw.close();
		}

		public boolean removeFromBasket(Product p) {
			
			for (Product removeP : basketList) {
				if (p.equals(removeP)) {
					basketList.remove(removeP);
					return true;
				}
			}
			return false;
		}
		
		
	}
}
