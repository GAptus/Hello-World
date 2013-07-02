package Store;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BuyFrame extends JFrame {
	
	private Store store;
	private CheckoutBasket basket;
	
	private HashMap<String, BuildBuyCardPanel> cardMap = new HashMap<String, BuildBuyCardPanel>();

	private JFrame indexFrame;
	private JPanel buyPanel;
	private JPanel cardStoragePanel;
	private JPanel buyButtonPanel;
	private JComboBox<String> buyOptions = new JComboBox<String>();
	private JButton addToBasket;
	private JButton returnButton;
	
	private String selectedItem;
	
	private BuildBuyCardPanel card1;
	private BuildBuyCardPanel card2;
	private BuildBuyCardPanel card3;
	private BuildBuyCardPanel card4;
	private BuildBuyCardPanel card5;
	
	private final String DESKTOPS = "Desktops";
	private final String LAPTOPS = "Laptops";
	private final String MONITORS = "Monitors";
	private final String KEYBOARDS = "Keyboards";
	private final String MICE = "Mice";
	

	public BuyFrame(JFrame indexFrame, Store store, CheckoutBasket basket) {
		this.indexFrame = indexFrame;
		this.store = store;
		this.basket = basket;
		
		build();
		addEventListeners();
		
		setVisible(false);
		
	}
	
	private void build() {
		
		setTitle("Buy");
		
		buyPanel = new JPanel();
		cardStoragePanel = new JPanel();
		buyButtonPanel = new JPanel();
		
		buyPanel.setLayout(new BorderLayout());
		cardStoragePanel.setLayout(new CardLayout());
		
		buyOptions.addItem(DESKTOPS);
		buyOptions.addItem(LAPTOPS);
		buyOptions.addItem(MONITORS);
		buyOptions.addItem(KEYBOARDS);
		buyOptions.addItem(MICE);
		
		selectedItem = buyOptions.getItemAt(0);
		
		addToBasket = new JButton("Add Item");
		returnButton = new JButton("Return");
		
		createCards();
		
		cardMap.put(DESKTOPS, card1);
		cardMap.put(LAPTOPS, card2);
		cardMap.put(MONITORS, card3);
		cardMap.put(KEYBOARDS, card4);
		cardMap.put(MICE, card5);
		
		cardStoragePanel.add(card1, DESKTOPS);
		cardStoragePanel.add(card2, LAPTOPS);
		cardStoragePanel.add(card3, MONITORS);
		cardStoragePanel.add(card4, KEYBOARDS);
		cardStoragePanel.add(card5, MICE);
		
		addToBasket.setToolTipText("Press to add the selected item to your basket");
		returnButton.setToolTipText("Press to return to the index");
		
		buyButtonPanel.add(addToBasket);
		buyButtonPanel.add(returnButton);
		
		buyPanel.add(buyOptions, BorderLayout.NORTH);
		buyPanel.add(cardStoragePanel, BorderLayout.CENTER);
		buyPanel.add(buyButtonPanel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(buyPanel);
		
		setResizable(false);
		pack();
		
	}
	
	private void addEventListeners() {
		buyOptions.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CardLayout c1 = (CardLayout)(cardStoragePanel.getLayout());
				c1.show(cardStoragePanel, (String)e.getItem());
				selectedItem = (String)e.getItem();
			}
		});
		
		addToBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					basket.addToBasket(cardMap.get(selectedItem).getSelected(), cardMap.get(selectedItem).getQuantity());
					String output = cardMap.get(selectedItem).getQuantity() + " " + cardMap.get(selectedItem).getSelected().getProductName();
					JOptionPane.showMessageDialog(buyPanel, output);
				} catch (ProductDoesNotExistException e1) {
					JOptionPane.showMessageDialog(buyPanel, "The product does not exist");
				}
			}
		});
		
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				indexFrame.setVisible(true);
			}
		});
	}

	
	private void createCards() {
		try {
			card1 = new BuildBuyCardPanel(store.findProductsByOption(DESKTOPS));
			card2 = new BuildBuyCardPanel(store.findProductsByOption(LAPTOPS));
			card3 = new BuildBuyCardPanel(store.findProductsByOption(MONITORS));
			card4 = new BuildBuyCardPanel(store.findProductsByOption(KEYBOARDS));
			card5 = new BuildBuyCardPanel(store.findProductsByOption(MICE));
		} catch (Exception e) {
			e.printStackTrace();
		}
		catch (ProductDoesNotExistException e2) {
			e2.printStackTrace();
		}
	}
	
}
