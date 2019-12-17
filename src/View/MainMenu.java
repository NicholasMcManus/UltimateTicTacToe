package View;
/**
	File name: MainMenu.java
	Short description: Class to Open Main Menu for Ultimate TicTacToe
	IST 311 Project  
	@author Jimmy McGettigan
	@version 1.01 10/20/2019
*/

/**
 *
 * @author tme5209
 */
import java.util.ArrayList;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel  {
    //----Declare Variables----\\
    private MainMenu mm;
    private JButton startButton;
    private JButton howtoButton;
    private JButton quitButton;
    private ArrayList<JButton> menuList;
    //----Constructors----\\
    /**
     * Method to initialize MenuPanel to default values
     */
    public MainMenu()
    {
        super();
        
        menuList = new ArrayList();
        
        startButton = new JButton("PLAY");
        startButton.setBackground(Color.GREEN);
        menuList.add(startButton);
        
        //setBackground(Color.LIGHT_GRAY);
        howtoButton = new JButton("How To Play");
        menuList.add(howtoButton);
        
        quitButton = new JButton("EXIT");
        quitButton.setBackground(Color.RED);
        menuList.add(quitButton);
        
        startButton.setBounds(570, 300, 120, 45);
        howtoButton.setBounds(570, 375, 120, 45);
        quitButton.setBounds(570, 450, 120, 45);
        
        this.configurePanel();
        this.addButtons(menuList);
    }
    
    /**
     * Construct a menu with provided buttons
     * @param menuButtons The list of buttons to be added to the panel
     */
    public MainMenu(ArrayList<JButton> menuButtons)
    {
        super();
        menuList = menuButtons;
        
        configurePanel();
        addButtons(menuButtons);
    }
    
    /**
     * Configure the dimensions of the JPanel
     */
    private void configurePanel()
    {
        //Construct a new layout based on the number of buttons to be displayed
        GridLayout myLayout = new GridLayout(1,1);
        myLayout.setRows(menuList.size());
        setLayout(myLayout);
        
        setSize(1200, 800);
    }
    
    /**
     * Add the buttons to the JPanel
     * @param buttons The list of buttons to be made into a menu
     */
    private void addButtons(ArrayList<JButton> buttons)
    {
        //Clear the current list, in case this is being called twice
        this.removeAll();
        
        buttons.forEach(current -> {
            this.add(current);
        });
    }

    //----Get Methods----\\
    /**
     * Get the start button
     * @return The start button
     */
    public JButton getStartButton() {
        return startButton;
    }

    /**
     * Get the how to button
     * @return The how to button
     */
    public JButton getHowtoButton() {
        return howtoButton;
    }

    /**
     * Get the quit button
     * @return The quit button
     */
    public JButton getQuitButton() {
        return quitButton;
    }
    
    //----Additional Methods----\\
}