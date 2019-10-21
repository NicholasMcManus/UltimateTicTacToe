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
                  System.out.println("Player O wins");
              }
          }
        }
        nextTurn = false;
      }
    }
    
    public void newMove()
    {
        //There are 9 moves in a standard tic-tac-toe board
        for(int turn = 0; turn < 9; turn++)
        {
            int currentMove;
            
            //Get another move as long as the space is occupied
            do{
                System.out.println("The space is occupied.");
                currentMove = view.consoleMove();
            }while(checkSpace(currentMove));
            
            setMove(currentMove);
        }
    }
    
    private void setMove(int space)
    {
        this.space[space] = (turnCount++%2 == 0 ? 'X' : 'O');
    }
    
    private char checkWin()
    {
        if(model.checkForWinner(space))
        {
            //I no longer remember how this function was suppose to work...
        }
        
        return '\0';
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
                    setMove(num);
                    view.showBoard(space);
                }
            }
        });
        }
    }
    
    public boolean checkSpace(int move)
    {
        if(space[move] == 'X' || space[move] == 'O')
            return true;
        else
            return false;
    }
    
} // End of class
