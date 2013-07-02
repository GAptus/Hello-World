package Store;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class IndexFrame extends JFrame{
	
	private Store store = new DefaultStore();
	private CheckoutBasket basket = store.getBasketInstance();
	
	private BuyFrame buyFrame = new BuyFrame(this, store, basket);
	
	private final String[] displayOptions = {"Desktops", "Laptops", "Monitors", "Keyboards", "Mice"};
	private JComboBox<String> displayOptionsCombo = new JComboBox<String>(displayOptions);
	
	private JPanel indexPanel;
	private JButton displayButton;
	private JButton addButton;
	private JButton viewButton;
	
	private JFrame tempFrame = this;
	
	public IndexFrame() {
	
		build();
		addListeners();
		
		setVisible(false);
		
	}
	
	private void build() {
		
		setTitle("Index");
		
		indexPanel = new JPanel();
		displayButton = new JButton("Display");
		addButton = new JButton("Add Items");
		viewButton = new JButton("View Basket");
		
		indexPanel.setLayout(new GridLayout(3, 1));
		
		displayButton.setToolTipText("Press to display the selected products");
		addButton.setToolTipText("Press to add items to your basket");
		viewButton.setToolTipText("Press to view your basket or to remove items from it");
		
		JPanel displayPanel = new JPanel();
		displayPanel.add(displayOptionsCombo);
		displayPanel.add(displayButton);
		
		JPanel addPanel = new JPanel();
		addPanel.add(addButton);
		
		JPanel viewPanel = new JPanel();
		viewPanel.add(viewButton);
		
		indexPanel.add(displayPanel);
		indexPanel.add(addPanel);
		indexPanel.add(viewPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		getContentPane().add(indexPanel);
		
		pack();
		
	}
	
	private void addListeners() {
		
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				setVisible(false);
				
				String optionSelected = displayOptionsCombo.getSelectedItem().toString();
				
				DisplayFrame displayFrame = new DisplayFrame(optionSelected, store, tempFrame);
				displayFrame.setVisible(true);
			}
		});
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				setVisible(false);
				buyFrame.setVisible(true);
			}
		});
		
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) {
				ViewBasketFrame viewFrame = new ViewBasketFrame(IndexFrame.this, basket);
				viewFrame.setVisible(true);
				setVisible(false);
			}
		});
		
	}
		
}
