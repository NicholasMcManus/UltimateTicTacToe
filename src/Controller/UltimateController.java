/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Model;
import View.UltimateView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tjell
 */
public class UltimateController {
    //------ Variables ------\\
    Model model;
    UltimateView uView;
    private char[] space = new char[9];
    private char[][] moves = new char[9][9];
    private boolean nextTurn = false;
    private int turnCount = 1;
    
    //------ Constructors ------\\
    /**
     * Default constructor
     */
    public UltimateController()
    {
        model = new Model();
        uView = new UltimateView();
        //uView.showBoard(space);
        initializeGUIButtons();
    }
    
    /**
     * Initialize the GUI buttons if they are to be used
     *//**/
    public void initializeGUIButtons()
    {
        //For every button in the 3x3
        //System.out.println("Initializing buttons...");
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
            //Appease the lambda
            final int board = i;
            final int button = j;
            
            //Add an action listener as defined below
            uView.addActionListener(i, j, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    char winner;
                    //System.out.println("Index [" + board + "][" + button + "] was clicked!");
                    
                    //*/Set the move attempt
                    claimSpace(board, button);
                    
                    //Update the view
                    uView.showBoard(moves);
                    
                    //Check for a winner and declare one if one is found
                    winner = checkWin();
                    if(winner != '\0')
                        uView.declareWinner(winner);//*/
                }
        });
            }
        }
        //System.out.println("Buttons initialized!");
    }/**/
    
    public void start()
    {
        uView.startGame();
    }
    
    /**
     * lets the player mark their spot 
     */
    private void claimSpace(int board, int button)
    {
        if(turnCount % 2 == 0)
        {
            moves[board][button] = 'X';
            turnCount++;
            //System.out.println(turnCount);
        }
        else
        {
            moves[board][button] = 'O';
            turnCount++;
            //System.out.println(turnCount);
        }
        uView.showBoard(space);
    }
    
    private char checkWin()
    {
        char winner = '\0';
        if(model.checkForUltimateWinner(moves))
        {
            //Someone has won
            //Determine which character won
            winner = (turnCount)%2 == 0 ? 'X' : 'O';
        }
        
        return winner;
    }
}
