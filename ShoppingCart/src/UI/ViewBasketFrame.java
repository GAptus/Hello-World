package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Store.CheckoutBasket;
import Store.EmptyBasketException;

/**
 * Class ViewBasketFrame
 * Builds the view basket jframe
 * @author giacomo
 *
 */
public class ViewBasketFrame extends JFrame {


    private static final long serialVersionUID = 1L;

    private CheckoutBasket basket;

    private JFrame indexFrame;
    private JPanel viewBasketPanel;
    private JPanel viewBasketButtonsPanel;
    private JTextArea basketContents;
    private JScrollPane basketContentScroll;
    private JButton checkoutButton;
    private JButton returnButton;
    private JButton removeButton;

    /**
     * Constructor
     * setups the jframe
     * @param indexFrame
     * @param basket
     */
    public ViewBasketFrame(JFrame indexFrame, CheckoutBasket basket) {
        this.indexFrame = indexFrame;
        this.basket = basket;

        build();
        addActionListeners();

        setVisible(false);
    }

    /**
     * Method build
     * Builds the jframe
     */
    private void build() {
        setTitle("Your Basket");

        // Assignment of values to previously initialised variables
        viewBasketPanel = new JPanel();
        viewBasketButtonsPanel = new JPanel();
        checkoutButton = new JButton("checkoutButton");
        returnButton = new JButton("Return");
        removeButton = new JButton("removeButton items");
        basketContents = new JTextArea(basket.printOutBasket(), 20, 20);
        basketContents.setEditable(false);
        basketContentScroll = new JScrollPane(basketContents);

        viewBasketPanel.setLayout(new BorderLayout());

        checkoutButton.setToolTipText("Press to checkoutButton with your current receipt");
        removeButton.setToolTipText("Press to removeButton items from your basket");
        returnButton.setToolTipText("Press to return to the index");

        viewBasketButtonsPanel.add(checkoutButton);
        viewBasketButtonsPanel.add(removeButton);
        viewBasketButtonsPanel.add(returnButton);

        viewBasketPanel.add(basketContentScroll, BorderLayout.CENTER);
        viewBasketPanel.add(viewBasketButtonsPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().add(viewBasketPanel);

        setResizable(false);
        pack();

        setLocationRelativeTo(null);

    }
    
    /**
     * Method addActionListeners
     * Adds the action listeners for the jframe
     */
    private void addActionListeners() {
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    basket.printReceipt();
                }
                catch (IOException ioe) {
                    throw new RuntimeException(ioe);
                }

                System.exit(0);
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                dispose();
                RemoveFrame removeButtonFrame = null;
                try {
                    removeButtonFrame = new RemoveFrame(indexFrame, basket);
                }
                catch (EmptyBasketException e) {
                    throw new RuntimeException(e);
                }
                removeButtonFrame.setVisible(true);
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
