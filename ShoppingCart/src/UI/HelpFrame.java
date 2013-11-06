package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Class HelpFrame
 * jframe to represent the HelpFrame
 * @author giacomo
 *
 */
public class HelpFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel helpPanel;
    private JTextArea userGuide;
    private JScrollPane scrollUserGuide;
    private JButton closeHelp;

    private JFrame previousFrame;

    /**
     * Constructor
     * sets up and builds the jframe to represent the help frame
     * @param helpText
     */
    public HelpFrame(String helpText) {
        build(helpText);
        addListener();
        setVisible(false);
    }

    /**
     * Method build
     * builds the componenets and adds them to the jframe
     * @param helpText
     * String containing the help text
     */
    private void build(String helpText) {
        setTitle("User Guide");

        helpPanel = new JPanel();

        helpPanel.setLayout(new BorderLayout());

        userGuide = new JTextArea();
        userGuide.setEditable(false);
        userGuide.setText(helpText);
        closeHelp = new JButton("Close");

        scrollUserGuide = new JScrollPane(userGuide);

        helpPanel.add(scrollUserGuide, BorderLayout.CENTER);
        helpPanel.add(closeHelp, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        getContentPane().add(helpPanel);

        setSize(400, 400);

    }

    /**
     * Method addListener
     * sets up the listeners for the jframe
     */
    private void addListener() {
        closeHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
                previousFrame.setVisible(true);
            }
        });
    }

    public void setPreviousFrame(JFrame previousFrame) {
        this.previousFrame = previousFrame;
    }

}
