package Store;

import Products.*;
import java.util.*;

public class StoreImpl implements Store {
	
	private Set<Product> productsForSale = new HashSet<Product>();
	
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
}
