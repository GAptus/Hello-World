package UI;

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

import Store.CheckoutBasket;
import Store.ProductDoesNotExistException;
import Store.ProductType;
import Store.Store;

/**
 * Class BuyFrame
 * jframe to represent the BuyFrame
 * @author giacomo
 *
 */
public class BuyFrame extends JFrame {

    private static final long serialVersionUID = 1L;

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

    /**
     * Constructor
     * sets up and builds the jframe
     * @param indexFrame
     * @param store
     * @param basket
     * @throws ProductDoesNotExistException
     */
    public BuyFrame(JFrame indexFrame, Store store, CheckoutBasket basket) throws ProductDoesNotExistException {
        this.indexFrame = indexFrame;
        this.basket = basket;

        for (ProductType productType : ProductType.values()) {
            cardMap.put(productType.getDisplayValue(), new BuildBuyCardPanel(store.findProductsByOption(productType)));
        }

        build();
        addEventListeners();

        setVisible(false);

    }

    /**
     * Method build
     * builds the componenets and adds them to the jframe
     * @throws ProductDoesNotExistException
     */
    private void build() throws ProductDoesNotExistException {

        setTitle("Buy");

        buyPanel = new JPanel();
        cardStoragePanel = new JPanel();
        buyButtonPanel = new JPanel();

        buyPanel.setLayout(new BorderLayout());
        cardStoragePanel.setLayout(new CardLayout());

        for (ProductType productType : ProductType.values()) {
            buyOptions.addItem(productType.getDisplayValue());
        }

        selectedItem = buyOptions.getItemAt(0);

        addToBasket = new JButton("Add Item");
        returnButton = new JButton("Return");

        for (ProductType productType : ProductType.values()) {
            cardStoragePanel.add(cardMap.get(productType.getDisplayValue()), productType.getDisplayValue());
        }

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
        
        setLocationRelativeTo(null);

    }

    /**
     * Method addEventListeners
     * sets up the event listeners for the jframe
     */
    private void addEventListeners() {
        buyOptions.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                selectedItem = (String) event.getItem();
                CardLayout c1 = (CardLayout) cardStoragePanel.getLayout();
                c1.show(cardStoragePanel, selectedItem);
            }
        });

        addToBasket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    basket.addToBasket(cardMap.get(selectedItem).getSelected(), cardMap.get(selectedItem).getQuantity());
                    String output = cardMap.get(selectedItem).getQuantity() + " "
                                    + cardMap.get(selectedItem).getSelected().getProductName();
                    JOptionPane.showMessageDialog(buyPanel, output);
                }
                catch (ProductDoesNotExistException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                buyOptions.setSelectedIndex(0);
                setVisible(false);
                indexFrame.setVisible(true);
            }
        });
    }

}
