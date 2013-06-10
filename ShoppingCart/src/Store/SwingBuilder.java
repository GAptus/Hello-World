package Store;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 * 
 * @author giacomo
 *Class SwingBuilder
 *A Class which provides a series of methods to build a gui for the OOP Shopping cart project
 */
//SATISFIES ASSESSMENT CRITERIA 1.1
public class SwingBuilder {
	// SATISFIES ASSESSMENT CRITERIA 1.2
	// Instantiates the store class to access its methods
	Store store = StoreImpl.getStore();
	
	CheckoutBasket basket = store.getBasketInstance();
	
	// Initialises global JFrame objects used in various buildFrame methods
	private JFrame welcomeFrame;
	private JFrame indexFrame;
	private JFrame displayFrame;
	private JFrame buyFrame;
	private JFrame showBasketFrame; 
	private JFrame removeFromBasketFrame;
	// Initialises global JPanel - used in itemStateChanged and buildBuyOptionsFrame
	private JPanel storagePanel;
	
	private String tempString;
	
	// String & Integer arrays containing information for JComboBox's created
	private String[] displayChoices = {"Desktops", "Laptops", "Monitors", "Keyboards", "Mice"};
	
	HashMap<String, BuildBuyCardPanel> cardMap = new HashMap<String, BuildBuyCardPanel>();
	
	private BuildBuyCardPanel card1;
	private BuildBuyCardPanel card2;
	private BuildBuyCardPanel card3;
	private BuildBuyCardPanel card4;
	private BuildBuyCardPanel card5;
	
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
	/**
	 * Method buildIndexFrame
	 * @return JFrame containing all the content required for the index frame
	 * Builds and returns a JFrame which contains all the information required for the index page
	 */
	private JFrame buildIndexFrame() {
		indexFrame = new JFrame("Please pick a option!");
		
		JPanel indexPanel = new JPanel();
		JButton displayAllButton = new JButton("Display all");
		
		
		final JComboBox<String> displayOptions = new JComboBox<String>(displayChoices);
		final JButton buyButton = new JButton("Click here to buy");
		
		final JButton showBasketButton = new JButton("View Basket");
		// Adding a action listener for the buy button
		buyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indexFrame.dispose();
				try {
					buildBuyOptionsFrame();
				} catch (ProductDoesNotExistException e1) {
					JOptionPane.showMessageDialog(indexFrame, "The product selected does not exist");
				}
			}
		});
		// Adding a action listener for the display all button
		displayAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indexFrame.dispose();
				try {
					displaySelected(displayOptions.getSelectedItem().toString());
				} catch (ProductDoesNotExistException e1) {
					JOptionPane.showMessageDialog(indexFrame, "The product selected does not exist");
				}
			}
		});
		// Adding a action listener for the show basket button
		showBasketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indexFrame.dispose();
				buildShowBasketFrame();
			}
		});
		
		indexPanel.add(displayOptions);
		indexPanel.add(displayAllButton);
		indexPanel.add(buyButton);
		indexPanel.add(showBasketButton);
		
		indexFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		indexFrame.setSize(240, 140);
		indexFrame.setResizable(false);
		indexFrame.setVisible(true);
		
		indexFrame.getContentPane().add(indexPanel);
		
		return indexFrame;
	}	
	/**
	 * Method buildBuyOptionsFrame
	 * @return A JFrame containing all the information for the Buying frame
	 * @throws ProductDoesNotExistException
	 */
	private JFrame buildBuyOptionsFrame() throws ProductDoesNotExistException {
		
		BorderLayout layout = new BorderLayout();
		
		buyFrame = new JFrame("Buy");
		
		final String DESKTOPS = "Desktops";
		final String LAPTOPS = "Laptops";
		final String MONITORS = "Monitors";
		final String KEYBOARDS = "Keyboards";
		final String MICE = "Mice";
		
		final JComboBox<String> buyOptions = new JComboBox<String>(displayChoices);
		
		tempString = buyOptions.getItemAt(0);
		
		try {
			card1 = new BuildBuyCardPanel(store.findProductsByOption(DESKTOPS));
			card2 = new BuildBuyCardPanel(store.findProductsByOption(LAPTOPS));
			card3 = new BuildBuyCardPanel(store.findProductsByOption(MONITORS));
			card4 = new BuildBuyCardPanel(store.findProductsByOption(KEYBOARDS));
			card5 = new BuildBuyCardPanel(store.findProductsByOption(MICE));
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(buyFrame, "Some kind of error :S");
		}
		// Using a card layout to change the information in the second combo box based on the currently selected option in the first combo box
		cardMap.put(DESKTOPS, card1);
		cardMap.put(LAPTOPS, card2);
		cardMap.put(MONITORS, card3);
		cardMap.put(KEYBOARDS, card4);
		cardMap.put(MICE, card5);
		
		storagePanel = new JPanel(new CardLayout());
		storagePanel.add(card1, DESKTOPS);
		storagePanel.add(card2, LAPTOPS);
		storagePanel.add(card3, MONITORS);
		storagePanel.add(card4, KEYBOARDS);
		storagePanel.add(card5, MICE);

		// Adding a item listener to the first JComboBox to check for changes in the selected option
		buyOptions.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CardLayout c1 = (CardLayout)(storagePanel.getLayout());
				c1.show(storagePanel, (String)e.getItem());
				tempString = (String)e.getItem();
			}
		});
		
		JPanel buttonPanel = new JPanel();
		
		JButton addToBasket = new JButton("Add to basket");
		// Adding a action listener to the add to basket button
		addToBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					basket.addToBasket(cardMap.get(tempString).getSelected(), cardMap.get(tempString).getQuantity());
				}
				catch (ProductDoesNotExistException e1) {
					JOptionPane.showMessageDialog(buyFrame, "The product does not exist");
				}
				finally {
					try {
						String output = cardMap.get(tempString).getQuantity() + " " + cardMap.get(tempString).getSelected().getProductName();
						JOptionPane.showMessageDialog(buyFrame, output);
					}
					catch (ProductDoesNotExistException e2) {
						JOptionPane.showMessageDialog(buyFrame, "The product does not exist");
					}
				}
			}		
		});
		
		JButton returnButton = createReturnButton(buyFrame);
		
		buttonPanel.add(addToBasket);
		buttonPanel.add(returnButton);
		
		buyFrame.setLayout(layout);
		
		buyFrame.getContentPane().add(buyOptions, BorderLayout.NORTH);
		buyFrame.getContentPane().add(storagePanel, BorderLayout.CENTER);
		buyFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		// Adding a action listener to the add to basket button
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
	/**
	 * Method displaySelected
	 * @param option String containing the option selected
	 * @return Jframe containing the results from the selected option
	 * @throws ProductDoesNotExistException
	 */
	private JFrame displaySelected(String option) throws ProductDoesNotExistException {
		displayFrame = new JFrame(option);
		JPanel displayPanel = new JPanel();
		final JButton returnToIndex = createReturnButton(displayFrame);
		
		ArrayList<Product> tempStore = store.findProductsByOption(option);
		System.out.println(tempStore.size());
		// Constructs text fields based on the number of results
		for (int i = 0; i < tempStore.size(); i++) {
			JTextArea tempArea = new JTextArea(tempStore.get(i).getDescription(), 10, 15);
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
	/**
	 * Method createReturnButton
	 * @param currentFrame JFrame which is the frame to which the button will be added
	 * @return JButton which will return the user to the index page
	 */
	private JButton createReturnButton(final JFrame currentFrame) {
		JButton returnButton = new JButton("Return to index");
		// Adding a action listener which will return you to the index page
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.dispose();
				buildIndexFrame();
			}
		});
		
		return returnButton;
	}
	/**
	 * Method buildShowBasketFrame
	 * @return JFrame containing the contents of your basket currently and a few JButtons with various options
	 */
	private JFrame buildShowBasketFrame() {
		showBasketFrame = new JFrame("Your basket");
		
		JPanel showBasketPanel = new JPanel();
		
		JTextArea basketContents = new JTextArea(basket.printOutBasket(), 20, 15);
		basketContents.setEditable(false);
		JButton checkout = new JButton("Checkout");
		JButton returnToIndex = createReturnButton(showBasketFrame);
		JButton remove = new JButton("Remove items");
		
		checkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(showBasketFrame, "Printing receipt, Thank you for shopping");
				showBasketFrame.dispose();
			}
		});
		
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBasketFrame.dispose();
				try {
					buildRemoveFromBasketFrame();
				} 
				catch (EmptyBasketException e1) {
					JOptionPane.showMessageDialog(showBasketFrame, "Your basket is empty");
				}
			}
		});
		
		showBasketPanel.add(basketContents);
		showBasketPanel.add(checkout);
		showBasketPanel.add(returnToIndex);
		showBasketPanel.add(remove);
		
		showBasketFrame.getContentPane().add(showBasketPanel);
		showBasketFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		showBasketFrame.setVisible(true);
		showBasketFrame.setResizable(false);
		showBasketFrame.setSize(260, 400);
		
		return showBasketFrame;
	}
	/**
	 * Method buildRemoveFromBasketFrame
	 * @return JFrame containing the options for removing items from your basket
	 * @throws EmptyBasketException 
	 */
	private JFrame buildRemoveFromBasketFrame() throws EmptyBasketException {
		removeFromBasketFrame = new JFrame("Remove From Basket");
		
		JPanel removeFromBasketPanel = new JPanel();
		
		final JComboBox<String> removeOptions = new JComboBox<String>(basket.productInBasket());
		JButton remove = new JButton("Remove");
		JButton removeAll = new JButton("Remove All");
		
		// Setting the default selected option for the removeOptions JComboBox
		String defaultOption = basket.productInBasket()[0];
		removeOptions.setSelectedItem(defaultOption);
		
		// Adding a action listener for the remove button
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Removes the selected option in the removeOptions JComboBox
					basket.removeFromBasket(basket.findProduct(removeOptions.getSelectedItem().toString()));
				}
				catch (ProductDoesNotExistException e1) {
					JOptionPane.showMessageDialog(removeFromBasketFrame, "The product does not exist");
				}
				finally {
					removeFromBasketFrame.dispose();
					buildShowBasketFrame();
				}
			}
		});
		// Adding a action listener for the remove all button 
		removeAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				basket.emptyBasket();
				removeFromBasketFrame.dispose();
				buildShowBasketFrame();
			}
		});
		
		removeFromBasketPanel.add(removeOptions);
		removeFromBasketPanel.add(remove);
		removeFromBasketPanel.add(removeAll);
		
		removeFromBasketFrame.getContentPane().add(removeFromBasketPanel);
		removeFromBasketFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		removeFromBasketFrame.setVisible(true);
		removeFromBasketFrame.setSize(280, 140);
		
		return removeFromBasketFrame;
	}
}
