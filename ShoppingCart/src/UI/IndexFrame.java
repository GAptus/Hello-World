package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Store.CheckoutBasket;
import Store.ProductDoesNotExistException;
import Store.ProductType;
import Store.Store;

/**
 * Class IndexFrame
 * Builds jframe representing the index frame
 * @author giacomo
 *
 */
public class IndexFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private Store store;
    private CheckoutBasket basket;

    private JFrame indexFrame = this;
    private BuyFrame buyFrame;
    private JPanel indexContainerPanel;

    private JComboBox<String> displayOptionsCombo;

    private JButton displayButton;
    private JButton addButton;
    private JButton viewButton;

    /**
     * Constructor
     * builds the jframe
     * @param store
     * @throws ProductDoesNotExistException
     */
    public IndexFrame(Store store) throws ProductDoesNotExistException {
        this.store = store;
        this.basket = store.getShoppingBasket();

        this.buyFrame = new BuyFrame(this, store, basket);

        build();
        addListeners();

        setVisible(false);

    }
    
    /**
     * Method build
     * builds all the viewable components
     */
    private void build() {

        setTitle("Index");

        indexContainerPanel = new JPanel();
        displayButton = new JButton("Display");
        addButton = new JButton("Add Items");
        viewButton = new JButton("View Basket");

        indexContainerPanel.setLayout(new GridLayout(3, 1));

        displayButton.setToolTipText("Press to display the selected products");
        addButton.setToolTipText("Press to add items to your basket");
        viewButton.setToolTipText("Press to view your basket or to remove items from it");

        JPanel displayPanel = new JPanel();

        displayOptionsCombo = new JComboBox<String>();

        for (ProductType productType : ProductType.values()) {
            displayOptionsCombo.addItem(productType.getDisplayValue());
        }

        displayPanel.add(displayOptionsCombo);

        displayPanel.add(displayButton);

        JPanel addPanel = new JPanel();
        addPanel.add(addButton);

        JPanel viewPanel = new JPanel();
        viewPanel.add(viewButton);

        indexContainerPanel.add(displayPanel);
        indexContainerPanel.add(addPanel);
        indexContainerPanel.add(viewPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        getContentPane().add(indexContainerPanel);

        pack();

        setLocationRelativeTo(null);

    }

    /**
     * Method addListeners
     * sets up listeners for the jframe
     */
    private void addListeners() {

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
                String optionSelected = displayOptionsCombo.getSelectedItem().toString();
                DisplayFrame displayFrame = new DisplayFrame(optionSelected, store, indexFrame);
                displayFrame.setVisible(true);
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
                buyFrame.setVisible(true);
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ViewBasketFrame viewFrame = new ViewBasketFrame(IndexFrame.this, basket);
                viewFrame.setVisible(true);
                setVisible(false);
            }
        });

    }

}
