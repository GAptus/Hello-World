package Store;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DisplayFrame extends JFrame {

	private Store store;
	private String option;
	
	private JFrame indexFrame;
	
	private ArrayList<Product> selectedProducts = new ArrayList<Product>();
	
	private JPanel displayFramePanel;
	private JPanel displayProductsPanel;
	private JButton returnButton;
	
	public DisplayFrame(String option, Store store,JFrame indexFrame) {
		
		this.indexFrame = indexFrame;
		this.option = option;
		this.store = store;
		
		populateArray();
		build();
		addListener();
		
		setVisible(true);
		
	}
	
	private void build() {
		
		setTitle(option + " Display");
		
		displayFramePanel = new JPanel();
		displayProductsPanel = new JPanel();
		
		displayFramePanel.setLayout(new BorderLayout());
		
		returnButton = new JButton("Return to Index");
		
		for (Product p : selectedProducts) {
			JTextArea productDescription = new JTextArea(p.getDescription(), 10, 15);
			JScrollPane productScroll = new JScrollPane(productDescription);
			
			productDescription.setEditable(false);
			
			displayProductsPanel.add(productScroll);
		}
		
		displayFramePanel.add(displayProductsPanel, BorderLayout.CENTER);
		displayFramePanel.add(returnButton, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		getContentPane().add(displayFramePanel);
		
		pack();
		
	}
	
	private void populateArray() {
		try {
			selectedProducts.addAll(store.findProductsByOption(option));
		} catch (ProductDoesNotExistException e) {
			
		}
	}
	
	private void addListener() {
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				indexFrame.setVisible(true);
			}
		});
	}
	

}
