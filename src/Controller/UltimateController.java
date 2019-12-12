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
import java.awt.event.WindowListener;

/**
 *
 * @author tjell
 */
public class UltimateController{
    //------ Variables ------\\
    protected Model model;
    protected UltimateView uView;
    protected char[] space = new char[9];
    protected char[][] moves = new char[9][9];
    protected boolean nextTurn = false;
    protected int turnCount = 1;
    
    //------ Constructors ------\\
    /**
     * Default constructor
     */
    public UltimateController()
    {
        model = new Model();
        uView = new UltimateView();
        initializeGUIButtons();
    }
    
    /**
     * Initialize the GUI buttons if they are to be used
     *//**/
    protected void initializeGUIButtons()
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
                    winner = checkWin(moves[board]);
                    if(winner != '\0')
                    {
                        subWin(board, winner);
                        winner = checkWin(space);
                        uView.showBoard(space);
                        if(winner != '\0')
                        {
                            uView.declareWinner(winner);
                        }
                    }
                }
        });
            }
        }
        //System.out.println("Buttons initialized!");
    }/**/
    
    protected void subWin(int board, char winner)
    {
        space[board] = winner;
        moves[board] = new char[9];
    }
    
    /**
     * Start the game
     */
    public void start()
    {
        uView.startGame();
    }
    
    /**
     * Start the game with specific colors
     * @param player1 The color of player 1
     * @param player2 The color of player 2
     */
    public void start(Color player1, Color player2)
    {
        uView.startGame(player1, player2);
    }
    
    /**
     * lets the player mark their spot 
     */
    protected void claimSpace(int board, int button)
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
    
    /**
     * Set the window properties to allow for methods to run reacting to the
     * window changes
     * @param event The event describing window behavior
     */
    public void setWindowProperties(WindowListener event)
    {
        this.uView.setWindowListener(event);
    }
    
    /**
     * Check the thing for a win
     * @param board The 3x3 board to check for a win
     * @return The character of the winner if one exists
     */
    protected char checkWin(char[] board)
    {
        char winner = '\0';
        if(model.checkForWinner(board))
        {
            //Someone has won
            //Determine which character won
            winner = (turnCount-1)%2 == 0 ? 'X' : 'O';
        }
        
        return winner;
    }
}
