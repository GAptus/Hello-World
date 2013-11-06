package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class welcomeFrame
 * Builds a JFrame for the Welcome page
 * @author giacomo
 *
 */
public class WelcomeFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel welcomePanel;
    private JLabel welcomeMessageLabel;
    private JButton enterStoreButton;
    private JButton helpButton;

    private final JFrame indexFrame;
    private final HelpFrame helpFrame;
    
    /**
     * Constructor
     * builds the JFrame
     * @param indexFrame
     * @param helpFrame
     */
    public WelcomeFrame(JFrame indexFrame, HelpFrame helpFrame) {
        build();
        addListeners();
        this.indexFrame = indexFrame;
        helpFrame.setPreviousFrame(this);
        this.helpFrame = helpFrame;

        setVisible(true);
    }

    /**
     * Method addListeners
     * sets up listeners for the JFrame
     */
    private void addListeners() {
        enterStoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                dispose();
                helpFrame.dispose();
                indexFrame.setVisible(true);
            }
        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                helpFrame.setVisible(true);
                setVisible(false);
            }
        });
    }

    /** 
     * Method build
     * Builds the frame putting in all the information
     */
    private void build() {

        setTitle("Welcome");

        welcomePanel = new JPanel();
        welcomeMessageLabel = new JLabel("Welcome to the store!");
        enterStoreButton = new JButton("Welcome to the store!");
        helpButton = new JButton("User Help");

        welcomePanel.setLayout(new GridLayout(3, 1));

        welcomePanel.add(welcomeMessageLabel);
        welcomePanel.add(enterStoreButton);
        welcomePanel.add(helpButton);
        
        enterStoreButton.setToolTipText("Click to enter the store");
        helpButton.setToolTipText("Click to see the user help guide");
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().add(welcomePanel);

        pack();

        setLocationRelativeTo(null);

    }

}
