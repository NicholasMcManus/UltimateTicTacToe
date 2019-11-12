package Controller;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;

import View.MenuPanel;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainMenuController {
    
    //Class Variables
    private JButton startButton, howToButton, quitButton;
    private MenuPanel menuPanel;
    private Color player1Color, player2Color;
    private View.SettingGUI setGUI;
    private UltimateController uControll;
    
    /**
     * Default constructor for a Main Menu
     */
    public MainMenuController()
    {
        ArrayList<JButton> menuList = new ArrayList();
        
        //Setup default colors
        player1Color = Color.RED;
        player2Color = Color.BLUE;
        
        //Setup the start button
        startButton = new JButton("Start");
        startButton.setBackground(Color.GREEN);
        menuList.add(startButton);
        
        startButton.addActionListener((ActionEvent ae) -> {
            uControll = new UltimateController();
            uControll.start(player1Color, player2Color);
            this.setupGameWindow();
            menuPanel.close();
        });
        
        //Setup the settings button
        JButton settingButton = new JButton("Settings");
        settingButton.setBackground(Color.orange);
        menuList.add(settingButton);
        settingButton.addActionListener((ActionEvent ae) -> {
            setGUI = new View.SettingGUI(player1Color, player2Color);
            setupSettingWindow();
        });
        
        //Setup the how to play button
        howToButton = new JButton("How to Play");
        howToButton.setBackground(Color.LIGHT_GRAY);
        menuList.add(howToButton);
        
        //Setup the Quit button
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
    
    /**
     * Method to setup the window listener when a user wants to change their color
     */
    private void setupSettingWindow()
    {
        setGUI.setWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we) {
            }

            @Override
            public void windowClosed(WindowEvent we) {
                player1Color = setGUI.getPlayer1Color();
                player2Color = setGUI.getPlayer2Color();
            }

            @Override
            public void windowIconified(WindowEvent we) {
            }

            @Override
            public void windowDeiconified(WindowEvent we) {
            }

            @Override
            public void windowActivated(WindowEvent we) {
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
            }
        });
    }
    
    /**
     * Method to allow for the menu to launch when the game is finished/closed
     */
    private void setupGameWindow()
    {
        uControll.setWindowProperties(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we) {
                menuPanel.open();
            }

            @Override
            public void windowClosed(WindowEvent we) {
            }

            @Override
            public void windowIconified(WindowEvent we) {
            }

            @Override
            public void windowDeiconified(WindowEvent we) {
            }

            @Override
            public void windowActivated(WindowEvent we) {
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
            }
        });
    }
}
