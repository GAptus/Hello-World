package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Store.CheckoutBasket;
import Store.EmptyBasketException;
import Store.ProductDoesNotExistException;

/**
 * Class RemoveFrame
 * Constructs a jframe to represent the RemoveFrame
 * @author giacomo
 *
 */
public class RemoveFrame extends JFrame {

    private static final long serialVersionUID = 1L;

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

    /**
     * Constructor
     * constructs the jframe
     * @param indexFrame
     * @param basket
     * @throws EmptyBasketException
     */
    public RemoveFrame(JFrame indexFrame, CheckoutBasket basket) throws EmptyBasketException {
        this.indexFrame = indexFrame;
        this.basket = basket;

        build();
        addActionListeners();

        setVisible(true);
    }

    /**
     * Method build
     * builds the jframe
     * @throws EmptyBasketException
     */
    private void build() throws EmptyBasketException {
        setTitle("Remove");

        removeTopPanel = new JPanel();
        removeBottomPanel = new JPanel();
        containerPanel = new JPanel();
        buttonPanel1 = new JPanel();
        buttonPanel2 = new JPanel();
        remove = new JButton("Remove");
        removeAll = new JButton("Remove All");
        returnButton = new JButton("Return");

        String[] productsInBasket = new String[basket.productInBasket().size()];
        productsInBasket = basket.productInBasket().toArray(productsInBasket);
        removeOptions = new JComboBox<String>(productsInBasket);

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
        
        setLocationRelativeTo(null);
    }

    /**
     * Method addActionListeners
     * sets up the action listeners
     */
    private void addActionListeners() {
        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    basket.removeFromBasket(basket.findProduct(removeOptions.getSelectedItem().toString()));
                }
                catch (ProductDoesNotExistException e) {
                    throw new RuntimeException(e);
                }
                
                dispose();
                ViewBasketFrame basketFrame = new ViewBasketFrame(indexFrame, basket);
                basketFrame.setVisible(true);
            }
        });

        removeAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                basket.emptyBasket();
                dispose();
                ViewBasketFrame basketFrame = new ViewBasketFrame(indexFrame, basket);
                basketFrame.setVisible(true);
            }
        });

        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                dispose();
                indexFrame.setVisible(true);
            }
        });
    }

}
