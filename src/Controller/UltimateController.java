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
public class UltimateController {
    //------ Variables ------\\
    Model model;
    UltimateView uView;
    private char[] space = new char[9];
    private char[][] moves = new char[9][9];
    private boolean nextTurn = false;
    int oldSpace = -1;
    private int turnCount = 1;
    
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
    private void initializeGUIButtons()
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
                    if(setRestriction(board, button, oldSpace))
                    {
                        //Causing issues, implementing workaround
                        oldSpace = button;

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
                }
        });
            }
        }
        //System.out.println("Buttons initialized!");
    }/**/
    
    private void subWin(int board, char winner)
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
     * @param board
     * @param button 
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
    
    /**
     * Determines whether or not a space is occupied
     * @param move The space to check
     * @return True if the space is occupied
     */
    public boolean checkSpace(int move)
    {
        //If the space is occupied by either x or o return true
        return space[move] == 'X' || space[move] == 'O';
    }
    
    public void setWindowProperties(WindowListener event)
    {
        this.uView.setWindowListener(event);
    }
    
    /**
     * Check the thing for a win
     * @param board
     * @return The character of the winner if one exists
     */
    private char checkWin(char[] board)
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
    
    /**
     * Sets restriction for the next move
     * @param board The board the button was pressed from
     * @param bound The button that was pressed
     * @param oldSpace A record of the space that was chosen before
     * @return 
     */
    private boolean setRestriction(int board, int bound, int oldSpace)
    {
        boolean valid = false;
        if(oldSpace == -1)
        {
            System.out.print("First Move: ");
            bound = -1;
        }
        else if(checkSpace(oldSpace))
        {
            System.out.println("Board occupied: ");
            bound = -1;
        }
        
        switch(bound)
        {
            case 0:
                if(oldSpace == board)
                {
                    System.out.println("Next move at board " + (bound+1) + ".");
                    valid = true;
                    break;
                }
                else
                {
                    valid = false;
                    break;
                }
            case 1:
                if(oldSpace == board)
                {
                    System.out.println("Next move at board " + (bound+1) + ".");
                    valid = true;
                    break;
                }
                else
                {
                    valid = false;
                    break;
                }
            case 2:
                if(oldSpace == board)
                {
                    System.out.println("Next move at board " + (bound+1) + ".");
                    valid = true;
                    break;
                }
                else
                {
                    valid = false;
                    break;
                }
            case 3:
                if(oldSpace == board)
                {
                    System.out.println("Next move at board " + (bound+1) + ".");
                    valid = true;
                    break;
                }
                else
                {
                    valid = false;
                    break;
                }
            case 4:
                if(oldSpace == board)
                {
                    System.out.println("Next move at board " + (bound+1) + ".");
                    valid = true;
                    break;
                }
                else
                {
                    valid = false;
                    break;
                }
            case 5:
                if(oldSpace == board)
                {
                    System.out.println("Next move at board " + (bound+1) + ".");
                    valid = true;
                    break;
                }
                else
                {
                    valid = false;
                    break;
                }
            case 6:
                if(oldSpace == board)
                {
                    System.out.println("Next move at board " + (bound+1) + ".");
                    valid = true;
                    break;
                }
                else
                {
                    valid = false;
                    break;
                }
            case 7:
                if(oldSpace == board)
                {
                    System.out.println("Next move at board " + (bound+1) + ".");
                    valid = true;
                    break;
                }
                else
                {
                    valid = false;
                    break;
                }
            case 8:
                if(oldSpace == board)
                {
                    System.out.println("Next move at board " + (bound+1) + ".");
                    valid = true;
                    break;
                }
                else
                {
                    valid = false;
                    break;
                }
            default:
                System.out.println("Next move at any board.");
                valid = true;
                break;
        }
        return valid;
    }
}
