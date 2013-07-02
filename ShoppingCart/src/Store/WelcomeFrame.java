package Store;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomeFrame extends JFrame {
	
	private JPanel welcomePanel;
	private JLabel welcomeLabel;
	private JButton enterStoreButton;
	private JButton helpButton;
	
	private final JFrame indexFrame;
	private HelpFrame helpFrame;
	
	public WelcomeFrame(JFrame indexFrame, HelpFrame helpFrame) {
		build();
		addListeners();		
		this.indexFrame = indexFrame;
		helpFrame.setPreviousFrame(this);
		this.helpFrame = helpFrame;
		
		setVisible(true);
	}	
	

	private void addListeners() {
		enterStoreButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				helpFrame.dispose();
				indexFrame.setVisible(true);
			}
		});
		
		helpButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				helpFrame.setVisible(true);
				setVisible(false);
			}
		});
	}
	
	
	private void build() {
		
		setTitle("Welcome");

		welcomePanel = new JPanel();
		welcomeLabel = new JLabel("Welcome to the store!");
		enterStoreButton = new JButton("Welcome to the store!");
		helpButton = new JButton("User Help");
		
		welcomePanel.setLayout(new GridLayout(3, 1));
		
		welcomePanel.add(welcomeLabel);
		welcomePanel.add(enterStoreButton);
		welcomePanel.add(helpButton);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(welcomePanel);
		
		pack();
		
	}
	
}
	


