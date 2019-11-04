package Controller;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;

import View.MenuPanel;
import View.UltimateGUI;
import java.awt.event.ActionEvent;

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
        
        startButton = new JButton("Start");
        startButton.setBackground(Color.GREEN);
        menuList.add(startButton);
        
        startButton.addActionListener((ActionEvent ae) -> {
            UltimateGUI ug = new UltimateGUI();
            ug.startTicTacToeGame();
            menuPanel.close();
        });
        
        howToButton = new JButton("How to Play");
        howToButton.setBackground(Color.LIGHT_GRAY);
        menuList.add(howToButton);
        
        quitButton = new JButton("Quit");
        quitButton.setBackground(Color.RED);
        menuList.add(quitButton);
        
        quitButton.addActionListener((ActionEvent ae) -> {
            System.out.println("Quit the program");
            System.exit(0);
        });
        
        startButton.setBounds(570, 300, 120, 45);
        howToButton.setBounds(570, 375, 120, 45);
        quitButton.setBounds(570, 450, 120, 45);
        
        menuPanel = new MenuPanel(menuList);
    }
}
