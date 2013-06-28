package Store;
// SATISFIES ASSESSMENT CRITERIA 1.1
public class StoreTest {
	
	public static void main(String[] args) {
	

	
		IndexFrame indexFrame = new IndexFrame();
		WelcomeFrame welcomeFrame = new WelcomeFrame(indexFrame, helpFrame);
		HelpFrame helpFrame = new HelpFrame(welcomeFrame);
		
		
		SwingBuilder myBuilder = new SwingBuilder();
		myBuilder.buildWelcomeFrame();
		
		
	}
}
