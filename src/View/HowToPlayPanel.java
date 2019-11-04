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
    public HowToPlayPanel() {
        // initialize default values
        super();
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setSize(1200, 800);
    
        htp = new JLabel("How To Play");
        description = new JLabel("Game instructions on how to play. What is TicTacToe? Where?");
        
        returnbtn = new JButton("Return to Main");
        
        add(htp);
        htp.setBounds(450, 0, 200, 25);
        
        
        add(description);
        System.out.println(description.getPreferredSize());
        description.setBounds(300, 50, 870, 200);
        
        add(returnbtn);
        returnbtn.setBounds(800, 400, 100, 25);
    
    
    }
    
     public JButton getReturnBtn() {
        return returnbtn;
    }
    
    
    
    
}
