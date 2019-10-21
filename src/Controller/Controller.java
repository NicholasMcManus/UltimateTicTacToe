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
            
            System.out.println("Selected space: " + currentMove);
            
            setMove(currentMove);
            view.showBoard(space);
            
            winner = this.checkWin();
            
            if(winner != '\0')
            {
                view.declareWinner(winner);
                return;
            }
        }
    }
    
    private void setMove(int space)
    {
        if(space < 0 || space > 8)
            System.out.println("Invalid Move Detected");
        
        this.space[space] = (turnCount++%2 == 0 ? 'X' : 'O');
    }
    
    private char checkWin()
    {
        char winner = '\0';
        if(model.checkForWinner(space))
        {
            //Someone has won
            //Determine which character won
            winner = (++turnCount)%2 == 0 ? 'X' : 'O';
            System.out.println(winner);
        }
        
        return winner;
    }
    
    public void initializeGUIButtons()
    {
        for(int i = 0; i < 9; i++)
        {
            final int num = i;
        
            view.addActionListener(i, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!checkSpace(num))
                {
                    char winner;
                    
                    setMove(num);
                    view.showBoard(space);
                    
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
        return space[move] == 'X' || space[move] == 'O';
    }
    
} // End of class
