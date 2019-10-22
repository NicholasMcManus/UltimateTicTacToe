package Controller;

import View.View;
import Model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    //------ Variables ------\\
    Model model;
    View view;
    private char[] space = new char[9];
    private int move;
    private boolean nextTurn = false;
    private int turnCount = 1;
    
    //------ Constructors ------\\
    /**
     * Default constructor
     */
    public Controller()
    {
        model = new Model();
        view = new View();
        view.showBoard(space);
    }
    
    //------ Other Methods ------\\
    /**
     * Run the 3x3 program using console input and output
     */
    public void move()
    {
      for(int i = 0; i < 9; i++)
      {
        while (!nextTurn && i%2 == 0)
        {
          move = model.playerTurn();
          if (move < 1 || move > 9)
          {
               System.out.println("Invalid move");
          }
          else if (checkSpace(move-1))
          {
                System.out.println("Invalid move.");
          }
          else
          {
              space[move-1] = 'X';
              view.showBoard(space);
              nextTurn = true;
              if (model.checkForWinner(space))
              {
                  i = 9;
                  System.out.println("Player X wins");
              }
          }
        }
        while (!nextTurn && i%2 != 0)
        {
          move = model.playerTurn();
          if (move < 1 || move > 9)
          {
               System.out.println("Invalid move.");
          }
          else if (checkSpace(move-1))
          {
                System.out.println("Invalid move.");
          }
          else
          {
              space[move-1] = 'O';
              view.showBoard(space);
              nextTurn = true;
              if (model.checkForWinner(space))
              {
                  i = 9;
                  //System.out.println("Player O wins");
              }
          }
        }
        nextTurn = false;
      }
    }
    
    /**
     * A re-write of the 3x3 console based tic-tac-toe game
     * Uses more internal methods shared with GUI based applications
     */
    public void newMove()
    {
        //There are 9 moves in a standard tic-tac-toe board
        char winner;
        
        for(int turn = 0; turn < 9; turn++)
        {
            int currentMove = view.consoleMove()-1;
            
            //Get another move as long as the space is occupied
            while(checkSpace(currentMove)){
                System.out.println("The space is occupied.");
                currentMove = view.consoleMove()-1;
            }
            
            //System.out.println("Selected space: " + currentMove);
            //Send the valid move to the method
            setMove(currentMove);
            //Update the view
            view.showBoard(space);
            
            winner = this.checkWin();
            
            if(winner != '\0')
            {
                view.declareWinner(winner);
                return;
            }
        }
    }
    
    /**
     * Set the move passed to the correct player
     * @param space 
     */
    private void setMove(int space)
    {
        //Check the move bounds
        if(space < 0 || space > 8)
            System.out.println("Invalid Move Detected");
        
        //Figure out who actually played a move
        this.space[space] = (turnCount++%2 == 0 ? 'X' : 'O');
    }
    
    /**
     * Figure out if someone won using the model
     * @return The character of the winning player if someone won '\0' represents no win
     */
    private char checkWin()
    {
        char winner = '\0';
        if(model.checkForWinner(space))
        {
            //Someone has won
            //Determine which character won
            winner = (++turnCount)%2 == 0 ? 'X' : 'O';
        }
        
        return winner;
    }
    
    /**
     * Initialize the GUI buttons if they are to be used
     */
    public void initializeGUIButtons()
    {
        //For every button in the 3x3
        for(int i = 0; i < 9; i++)
        {
            //Appease the lambda
            final int num = i;
            
            //Add an action listener as defined below
            view.addActionListener(i, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //Is the move valid
                if(!checkSpace(num))
                {
                    //If so
                    char winner;
                    
                    //Set the move attempt
                    setMove(num);
                    
                    //Update the view
                    view.showBoard(space);
                    
                    //Check for a winner and declare one if one is found
                    winner = checkWin();
                    if(winner != '\0')
                        view.declareWinner(winner);
                }
            }
        });
        }
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
    
} // End of class
