package Controller;

import View.View;
import Model.Model;

public class Controller {
    //------ Variables ------\\
    Model model = new Model();
    View view = new View();
    private char[] space = new char[9];
    private int move;
    private boolean nextTurn = false;
    
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
          else if (checkSpace())
          {
                System.out.println("Invalid move.");
          }
          else
          {
              space[move-1] = 'X';
              view.showBoard(space);
              nextTurn = true;
          }
        }
        while (!nextTurn && i%2 != 0)
        {
          move = model.playerTurn();
          if (move < 1 || move > 9)
          {
               System.out.println("Invalid move.");
          }
          else if (checkSpace())
          {
                System.out.println("Invalid move.");
          }
          else
          {
              space[move-1] = 'O';
              view.showBoard(space);
              nextTurn = true;
          }
        }
        nextTurn = false;
      }
    }
    
    public boolean checkSpace()
    {
        if(space[move - 1] == 'X' || space[move-1] == 'O')
            return true;
        else
            return false;
    }
    
} // End of class
