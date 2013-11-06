package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Store.Product;
import Store.ProductType;
import Store.Store;

/**
 * Class DisplayFrame
 * jframe to represent a display frmae
 * @author giacomo
 *
 */
public class DisplayFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private String option;

    private List<Product> selectedProducts = new ArrayList<Product>();
    private Map<String, ProductType> optionToProductType = new HashMap<String, ProductType>();

    private JFrame indexFrame;
    private JPanel displayFramePanel;
    private JPanel displayProductsPanel;

    private JButton returnButton;

    /**
     * Constructor 
     * builds and set up the jframe
     * @param option
     * @param store
     * @param indexFrame
     */
    public DisplayFrame(String option, Store store, JFrame indexFrame) {
        this.indexFrame = indexFrame;
        this.option = option;

        optionToProductType.put("Desktops", ProductType.DESKTOP);
        optionToProductType.put("Laptops", ProductType.LAPTOP);
        optionToProductType.put("Monitors", ProductType.MONITOR);
        optionToProductType.put("Keyboards", ProductType.KEYBOARD);
        optionToProductType.put("Mice", ProductType.MOUSE);

        selectedProducts = store.findProductsByOption(optionToProductType.get(option));

        build();
        addListener();

        setVisible(true);

    }

    /**
     * Method build
     * builds the components and adds them to the jframe
     */
    private void build() {

        setTitle(option + " Display");

        displayFramePanel = new JPanel();
        displayProductsPanel = new JPanel();

        displayFramePanel.setLayout(new BorderLayout());

        returnButton = new JButton("Return to Index");

        for (Product product : selectedProducts) {
            JTextArea productDescription = new JTextArea(product.getDescription(), 10, 25);
            JScrollPane productScroll = new JScrollPane(productDescription);

            productDescription.setEditable(false);

            displayProductsPanel.add(productScroll);
        }

        displayFramePanel.add(displayProductsPanel, BorderLayout.CENTER);
        displayFramePanel.add(returnButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        getContentPane().add(displayFramePanel);

        pack();

        setLocationRelativeTo(null);

    }

    /**
     * Method addListener
     * sets up the listeners for the jframe
     */
    private void addListener() {
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                dispose();
                indexFrame.setVisible(true);
            }
        });
    }

}
