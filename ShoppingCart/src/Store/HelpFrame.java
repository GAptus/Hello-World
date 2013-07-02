package Store;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HelpFrame extends JFrame {
	
	private JPanel helpPanel;
	private JTextArea userGuide;
	private JScrollPane scrollUserGuide;
	private JButton closeHelp;
	
	private JFrame previousFrame;
	
	public HelpFrame(String helpText) {
		build(helpText);
		addListener();
		setVisible(false);
	}
	
	private void build(String helpText) {
		setTitle("User Guide");
		
		helpPanel = new JPanel();
		
		helpPanel.setLayout(new BorderLayout());
		
		userGuide = new JTextArea();
		userGuide.setEditable(false);
		userGuide.setText(helpText);
		closeHelp = new JButton("Close");

		scrollUserGuide = new JScrollPane(userGuide);
		
		helpPanel.add(scrollUserGuide, BorderLayout.CENTER);
		helpPanel.add(closeHelp, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		getContentPane().add(helpPanel);
		
		setSize(400, 400);
	
	}
	
	private void addListener() {
		closeHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				previousFrame.setVisible(true);
			}
		});
	}
	
	public void setPreviousFrame(JFrame previousFrame){
		this.previousFrame = previousFrame;
	}
	
}
