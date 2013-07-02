package Store;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// SATISFIES ASSESSMENT CRITERIA 1.1
public class StoreTest {

	public static void main(String[] args) throws Exception {
		
		HelpFrame helpFrame = new HelpFrame(loadHelpText());
		IndexFrame indexFrame = new IndexFrame();
		WelcomeFrame welcomeFrame = new WelcomeFrame(indexFrame, helpFrame);

		indexFrame.setVisible(false);
		welcomeFrame.setVisible(true);
	}

	private static String loadHelpText() throws FileNotFoundException,
			IOException {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader("UserGuide");
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append("\n");
			}
		} finally {
			br.close();
		}
		return stringBuilder.toString();
	}
}
