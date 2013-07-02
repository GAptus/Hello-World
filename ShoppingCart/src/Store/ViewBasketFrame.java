package Store;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ViewBasketFrame extends JFrame {
	
	private CheckoutBasket basket;
	
	private JFrame indexFrame;
	private JPanel viewBasketPanel;
	private JPanel buttonsPanel;
	private JTextArea basketContents;
	private JScrollPane basketContentScroll;
	private JButton checkout;
	private JButton returnButton;
	private JButton remove;

	private String basketText;
	
	public ViewBasketFrame(JFrame indexFrame, CheckoutBasket basket) {
		this.indexFrame = indexFrame;
		this.basket = basket;
		
		build();
		addActionListeners();
		
		setVisible(false);
	}
	
	private void build() {
		setTitle("Your Basket");
		
		viewBasketPanel = new JPanel();
		buttonsPanel = new JPanel();
		checkout = new JButton("Checkout");
		returnButton = new JButton("Return");
		remove = new JButton("Remove items");
		basketContents = new JTextArea(basket.printOutBasket(), 20, 20);
		basketContents.setEditable(false);
		basketContentScroll = new JScrollPane(basketContents);
		
		viewBasketPanel.setLayout(new BorderLayout());
		
		checkout.setToolTipText("Press to checkout with your current receipt");
		remove.setToolTipText("Press to remove items from your basket");
		returnButton.setToolTipText("Press to return to the index");
		
		buttonsPanel.add(checkout);
		buttonsPanel.add(remove);
		buttonsPanel.add(returnButton);
		
		viewBasketPanel.add(basketContentScroll, BorderLayout.CENTER);
		viewBasketPanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(viewBasketPanel);
		
		setResizable(false);
		pack();
		
	}
	
	private void addActionListeners() {
		checkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					basket.printReceipt();
				} catch (IOException e1) {

				}
				System.exit(0);
			}
		});
		
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RemoveFrame removeFrame = null;
				try {
					removeFrame = new RemoveFrame(indexFrame, basket);
				} catch (EmptyBasketException e1) {

				}
				removeFrame.setVisible(true);
			}
		});
		
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				indexFrame.setVisible(true);
			}
		});
	}
}
