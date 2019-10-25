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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JPanel  {
    //----Declare Variables----\\
    private MainMenu mm;
    private JButton startButton;
    private JButton howtoButton;
    private JButton quitButton;
    
    //----Constructors----\\
    /**
     * Method to initialize MenuPanel to default values
     */
    public MainMenu()
    {
        super();
        setLayout(new BorderLayout());
        setLayout(null);
        setSize(1200, 800);
        
        startButton = new JButton("PLAY");
        startButton.setBackground(Color.GREEN);
        add(startButton);
        
        //setBackground(Color.LIGHT_GRAY);
        howtoButton = new JButton("How To Play");
        add(howtoButton);
        
        quitButton = new JButton("EXIT");
        quitButton.setBackground(Color.RED);
        add(quitButton);
        
        creator = new JLabel("<html><div style = 'text-align: center;'>Creators: Jaemi, Tahjir, and Jimmy.<br/>");
        creator.setBounds(570, 500, 120, 45);
        add(creator);
        
        startButton.setBounds(570, 300, 120, 45);
        howtoButton.setBounds(570, 375, 120, 45);
        quitButton.setBounds(570, 450, 120, 45);
    }
    

    //----Get Methods----\\
    public JButton getStartButton() {
        return startButton;
    }

    public JButton getHowtoButton() {
        return howtoButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }
    
    //----Additional Methods----\\

    

  
    
}//end of class