package Controller;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;

import View.MenuPanel;

public class MainMenuController {
    
    //Class Variables
    private JButton startButton, howToButton, quitButton;
    private MenuPanel menuPanel;
    
    /**
     * Default constructor for a Main Menu
     */
    public MainMenuController()
    {
        ArrayList<JButton> menuList = new ArrayList();
        
        startButton = new JButton("Shallot");
        startButton.setBackground(Color.GREEN);
        menuList.add(startButton);
        
        //setBackground(Color.LIGHT_GRAY);
        howToButton = new JButton("Potato");
        menuList.add(howToButton);
        
        quitButton = new JButton("Tomato");
        quitButton.setBackground(Color.RED);
        menuList.add(quitButton);
        
        startButton.setBounds(570, 300, 120, 45);
        howToButton.setBounds(570, 375, 120, 45);
        quitButton.setBounds(570, 450, 120, 45);
        
        menuPanel = new MenuPanel(menuList);
    }
}
