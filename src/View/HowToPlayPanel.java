/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jmhaz
 */
public class HowToPlayPanel extends JPanel {
    //Instance Variables
    private JLabel htp;
    private JLabel description;
    private JButton returnbtn;
    
     // Constructors
    /**
     * Default constructor for a how to play panel
     */
    public HowToPlayPanel() {
        // initialize default values
        super();
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setSize(1200, 800);
    
        htp = new JLabel("How To Play");
        description = new JLabel("<html><div style = 'text-align: center;'>The goal is for the player to win three consecutive boards.<br/>"
                + "in a row, vertically, horizontally, or diagonally<br/><br/><br/><br/>"
                + "Player 1 slects a square first anywhere from the nine 9x9 mini boards, and the selected square will be highlighted.<br/>"
                + "Player 2 chooses next, and will be asked to choose a space in the designated 9x9 board in the output..<br/>"
                + "Once a player wins a mini board, that mini board will change to the players winning color,<br/>"
                + "and no more moves are allowed in that mini board. br/><br/><br/><br/>"
                + "Winner will have 3 of the 9 mini boards won consecutively, vertically, horizonbtally, or diagonally");
        
        returnbtn = new JButton("Return to Main");
        
        add(htp);
        htp.setBounds(450, 0, 200, 25);
        htp.setFont(new Font("Serif", Font.BOLD, 20));

        
        
        add(description);
        System.out.println(description.getPreferredSize());
        description.setBounds(300, 50, 870, 200);
        
        add(returnbtn);
        returnbtn.setBounds(800, 400, 100, 25);
    
    
    }
    
    /**
     * Allow for the return button to be modified
     * @return A JButton to be modified
     */
     public JButton getReturnBtn() {
        return returnbtn;
    }
    
    
    
    
}
