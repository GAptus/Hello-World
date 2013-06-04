package Store;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface Store {
	
	public ArrayList<String> displayAllProducts();
	
	public ArrayList<String> displayMonitors();
	
	public ArrayList<String> displayLaptops();
	
	public ArrayList<String> displayDesktops();
	
	public ArrayList<String> displayKeyboards();
	
	public ArrayList<String> displayMice();
	
	public ArrayList<String> searchKeyword(String keyword);
}
