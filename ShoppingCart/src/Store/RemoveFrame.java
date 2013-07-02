package Store;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RemoveFrame extends JFrame {
	
	private CheckoutBasket basket;
	
	private JFrame indexFrame;
	private JPanel removeTopPanel;
	private JPanel removeBottomPanel;
	private JPanel containerPanel;
	private JPanel buttonPanel1;
	private JPanel buttonPanel2;
	private JButton remove;
	private JButton removeAll;
	private JButton returnButton;
	
	private JComboBox<String> removeOptions;
	
	
	public RemoveFrame(JFrame indexFrame, CheckoutBasket basket) throws EmptyBasketException {
		this.indexFrame = indexFrame;
		this.basket = basket;
		
		build();
		addActionListeners();
		
		setVisible(true);
	}
	
	private void build() throws EmptyBasketException {
		setTitle("Remove");
		
		removeTopPanel = new JPanel();
		removeBottomPanel = new JPanel();
		containerPanel = new JPanel();
		buttonPanel1 =  new JPanel();
		buttonPanel2 = new JPanel();
		remove = new JButton("Remove");
		removeAll = new JButton("Remove All");
		returnButton = new JButton("Return");
		
		removeOptions = new JComboBox<String>(basket.productInBasket());
		
		removeBottomPanel.setLayout(new GridLayout(2, 1));
		containerPanel.setLayout(new BorderLayout());
		
		remove.setToolTipText("Press to remove the selected item");
		removeAll.setToolTipText("Press to remove all items from your basket");
		returnButton.setToolTipText("Press to return to the index");
		
		removeTopPanel.add(removeOptions);
		removeTopPanel.add(remove);
		
		buttonPanel1.add(removeAll);
		
		buttonPanel2.add(returnButton);
		
		removeBottomPanel.add(buttonPanel1);
		removeBottomPanel.add(buttonPanel2);
		
		containerPanel.add(removeTopPanel, BorderLayout.NORTH);
		containerPanel.add(removeBottomPanel, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		getContentPane().add(containerPanel);
		
		pack();
	}
	
	private void addActionListeners() {
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					basket.removeFromBasket(basket.findProduct(removeOptions.getSelectedItem().toString()));
				} catch (ProductDoesNotExistException e2) {
					
				}
				dispose();
				ViewBasketFrame basketFrame =  new ViewBasketFrame(indexFrame, basket);
				basketFrame.setVisible(true);
			}
		});
		
		removeAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				basket.emptyBasket();
				dispose();
				ViewBasketFrame basketFrame =  new ViewBasketFrame(indexFrame, basket);
				basketFrame.setVisible(true);
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
