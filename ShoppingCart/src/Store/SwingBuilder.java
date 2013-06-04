package Store;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

public class SwingBuilder {
	
	public JPanel buildFrame(int x, int y) {
		JPanel homeFrame = new JPanel();
		Dimension d = new Dimension(x, y);
		homeFrame.setSize(d);
		return homeFrame;
	}
	
	public JPanel buildWelcomePanel(int x, int y) {
		JPanel welcomePanel = buildFrame(x, y);
		
		JLabel welcomeLabel = new JLabel("Welcome to the store!");
		JButton enterStoreButton = new JButton("Press to enter store!");
		
		welcomePanel.g.add(welcomeLabel);
		welcomePanel.add(enterStoreButton);
		
		return welcomePanel;
	}
}
