package Store;

import javax.swing.*;

public class StoreTest {
	
	public static void main(String[] args) {
	
		Store myStore = new StoreImpl();
	
		SwingBuilder myBuilder = new SwingBuilder();
		JPanel myFrame = new JPanel();
		
		myFrame = myBuilder.buildFrame(400, 300);
		
		myFrame.setVisible(true);
		
		JFrame newFrame = new JFrame("Welcome Frame");
		
		newFrame.add(myFrame);
		newFrame.pack();
		newFrame.setVisible(true);
	}
}
