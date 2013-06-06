package Store;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;

import Store.StoreImpl.Basket;

/**
 * 
 * @author giacomo
 *Class SwingBuilder
 *A Class which provides a series of methods to build a gui for the OOP Shopping cart project
 */
public class SwingBuilder {
	// Instantiates the store class to access its methods
	Store store = new StoreImpl();
	
	Basket basket = store.new CheckoutBasket();
	
	// Initialises global JFrame objects used in various buildFrame methods
	JFrame welcomeFrame;
	JFrame indexFrame;
	JFrame searchFrame;
	JFrame displayFrame;
	JFrame keywordsFrame;
	JFrame buyFrame;
	// Initialises global JPanel - used in itemStateChanged and buildBuyOptionsFrame
	JPanel storagePanel;
	// String & Integer arrays containing information for JComboBox's created
	String[] displayChoices = {"Desktops", "Laptops", "Monitors", "Keyboards", "Mice"};
	String[] buyOptionsDesktop = {"HP h8-1590ea: £1029.99", "HP Pavilion p6-2496ea: 749.99", "HP Pavilion p6-2422ea: £269.99"};
	String[] buyOptionsKeyBoard = {"Razer BlackWidow: £99.99", "Logitech K800: £82.99", "Razer Anansi: £89.99"};
	String[] buyOptionsLaptop = {"Sony Vaio S Series: £529.99", "Toshiba Satellite: £929.99"};
	String[] buyOptionsMonitors = {"Dell UltraSharp U2312HM: £238.80", "Dell UltraSharp U2412M: £322.80"};
	String[] buyOptionsMice = {"Razer Naga Epic: £119.99", "Razer Naga Hex: £99.99", "Razer Ouroboros Elite: £109.99"};
	Integer[] quantity = {1,2,3,4,5,6,7,8,9,10};
	/**
	 * Method - buildWelcomeFrame
	 * @return A JFrame which will be the welcome frame
	 * Builds a welcome Frame for the shopping cart program and returns the JFrame created
	 */
	public JFrame buildWelcomeFrame() {
		// Assigning a value to welcomeFrame
		welcomeFrame = new JFrame("Welcome");
		// Creating a JPanel 
		JPanel welcomePanel = new JPanel();
		
		// JLabel containing a welcome message
		JLabel welcomeLabel = new JLabel("Welcome to the store!");
		// JButton to enter the store
		JButton enterStoreButton = new JButton("Press to enter store!");
		// Adding a new ActionListener to the JButton enterStoreButton
		enterStoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Disposes of the welcomeFrame and then call on the buildIndexFrame to create the indexFrame
				welcomeFrame.dispose();
				buildIndexFrame();
			}
		});
		// Adding the two components to a welcomePanel
		welcomePanel.add(welcomeLabel);
		welcomePanel.add(enterStoreButton);
		
		welcomeFrame.setLayout(new BorderLayout());
		
		welcomeFrame.setSize(200, 85);
		welcomeFrame.setResizable(false);
		
		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		welcomeFrame.getContentPane().add(welcomePanel, BorderLayout.CENTER);
		welcomeFrame.setVisible(true);
		
		return welcomeFrame;
	}
	
	public JFrame buildIndexFrame() {
		indexFrame = new JFrame("Please pick a option!");
		
		JPanel indexPanel = new JPanel();
		JButton displayAllButton = new JButton("Display all");
		
		
		final JComboBox<String> displayOptions = new JComboBox<String>(displayChoices);
		final JButton buyButton = new JButton("Click here to buy");
		
		
		buyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indexFrame.dispose();
				buildBuyOptionsFrame();
			}
		});
	
		
		displayAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indexFrame.dispose();
				try {
					displaySelected(displayOptions.getSelectedItem().toString());
				} catch (ProductDoesNotExistException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		indexPanel.add(displayOptions);
		indexPanel.add(displayAllButton);
		indexPanel.add(buyButton);
		
		indexFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		indexFrame.setSize(240, 100);
		indexFrame.setResizable(false);
		indexFrame.setVisible(true);
		
		indexFrame.getContentPane().add(indexPanel);
		
		return indexFrame;
	}
	
	public JPanel buildNewOptions(String option) {
		JPanel card = new JPanel();
		JComboBox<Integer> quantityList = new JComboBox<Integer>(quantity);
		JComboBox<String> optionsList = null;
		
		if (option.equals("Desktops")) {
			optionsList = new JComboBox<String>(buyOptionsDesktop);
		}
		if (option.equals("Laptops")) {
			optionsList = new JComboBox<String>(buyOptionsLaptop);
		}
		if (option.equals("Monitors")) {
			optionsList = new JComboBox<String>(buyOptionsMonitors);
		}
		if (option.equals("Keyboards")) {
			optionsList = new JComboBox<String>(buyOptionsKeyBoard);
		}
		if (option.equals("Mice")) {
			optionsList = new JComboBox<String>(buyOptionsMice);
		}
		
		card.add(optionsList);
		card.add(quantityList);
		
		return card;
	}
	
	public JFrame buildBuyOptionsFrame() {
		
		BorderLayout layout = new BorderLayout();
		
		buyFrame = new JFrame("Buy");
		
		final String DESKTOPS = "Desktops";
		final String LAPTOPS = "Laptops";
		final String MONITORS = "Monitors";
		final String KEYBOARDS = "Keyboards";
		final String MICE = "Mice";
		
		final JComboBox<String> buyOptions = new JComboBox<String>(displayChoices);
		
		
		
		JPanel card1 = buildNewOptions("Desktops");
		JPanel card2 = buildNewOptions("Laptops");
		JPanel card3 = buildNewOptions("Monitors");
		JPanel card4 = buildNewOptions("Keyboards");
		JPanel card5 = buildNewOptions("Mice");
		
		storagePanel = new JPanel(new CardLayout());
		storagePanel.add(card1, DESKTOPS);
		storagePanel.add(card2, LAPTOPS);
		storagePanel.add(card3, MONITORS);
		storagePanel.add(card4, KEYBOARDS);
		storagePanel.add(card5, MICE);
		
		buyOptions.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CardLayout c1 = (CardLayout)(storagePanel.getLayout());
				c1.show(storagePanel, (String)e.getItem());
			}
		});
		
		JPanel buttonPanel = new JPanel();
		
		JButton addToBasket = new JButton("Add to basket");
		
//		addToBasket.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				store.
//			}		
//		});
		
		JButton returnButton = createReturnButton(buyFrame);
		
		buttonPanel.add(addToBasket);
		buttonPanel.add(returnButton);
		
		buyFrame.setLayout(layout);
		
		buyFrame.getContentPane().add(buyOptions, BorderLayout.NORTH);
		buyFrame.getContentPane().add(storagePanel, BorderLayout.CENTER);
		buyFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		addToBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel addedMessage = new JLabel("Items have been added!");
				buyFrame.getContentPane().add(addedMessage);
			}
		});
		
		buyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buyFrame.setResizable(false);
		buyFrame.pack();
		buyFrame.setVisible(true);
		
		return buyFrame;
	}
	
	public JFrame displaySelected(String option) throws ProductDoesNotExistException {
		displayFrame = new JFrame(option);
		JPanel displayPanel = new JPanel();
		final JButton returnToIndex = createReturnButton(displayFrame);
		
		ArrayList<String> tempStore = store.findProductsByOption(option);
		System.out.println(tempStore.size());
		
		for (int i = 0; i < tempStore.size(); i++) {
			JTextArea tempArea = new JTextArea(tempStore.get(i), 10, 15);
			tempArea.setEditable(false);
			displayPanel.add(tempArea);
		}
		displayPanel.add(returnToIndex);
		
		displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayFrame.getContentPane().add(displayPanel);
		displayFrame.pack();
		displayFrame.setVisible(true);

		
		return displayFrame;
	}
	
	public JButton createReturnButton(final JFrame currentFrame) {
		JButton returnButton = new JButton("Return to index");
		
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.dispose();
				buildIndexFrame();
			}
		});
		
		return returnButton;
	}
	
}
