package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Store.DefaultStore;
import Store.ProductDoesNotExistException;
import Store.StockingStore;
import Store.Store;
import UI.HelpFrame;
import UI.IndexFrame;
import UI.WelcomeFrame;

public class StoreTest {
    
	public static void main(String[] args) throws ProductDoesNotExistException, Exception {
		Store store = new DefaultStore(new StockingStore());
		HelpFrame helpFrame = new HelpFrame(loadHelpText());
		IndexFrame indexFrame = new IndexFrame(store);
		WelcomeFrame welcomeFrame = new WelcomeFrame(indexFrame, helpFrame);

		indexFrame.setVisible(false);
		welcomeFrame.setVisible(true);
	}

	// Reads from a file returning a String containing all the file data.
	private static String loadHelpText() throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader br = null;
		FileReader fr = new FileReader("UserGuide");
		br = new BufferedReader(fr);
		
		String line;
		while ((line = br.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append("\n");
		}
		
		br.close();
		
		return stringBuilder.toString();
	}
}
