package Model;

import java.util.Scanner;

public class Model {
    //------ Variables ------\\
    Player player;
    Scanner input = new Scanner(System.in);
    
    //------ Constructors ------\\
    /**
     * Default constructor
     */
    public Model()
    {
        player = new Player();
    }
    
    
    //------ Setters and Getters ------\\
    
    
    //------ Other Methods ------\\
    /**
     * Get user input for a 3x3 grid
     * @return The chosen square
     */
    public int playerTurn()
    {
        int num;
        System.out.println("Enter number (1-9) to move in the corresponding square");
        num = input.nextInt();
        return num;
    }
    
    /**
     * Determine if someone has won the board
     * @param spaces The array holding the moves played
     * @return If someone has won or not
     */
    public boolean checkForWinner(char[] spaces)
    {
        //---- Horizontal ----\\
        if (spaces[0] == 'X' && spaces[1] == 'X' && spaces[2] == 'X')
        {
            return true;
        }
        else if (spaces[0] == 'O' && spaces[1] == 'O' && spaces[2] == 'O')
        {
            return true;
        }
        else if (spaces[3] == 'X' && spaces[4] == 'X' && spaces[5] == 'X')
        {
            return true;
        }
        else if (spaces[3] == 'O' && spaces[4] == 'O' && spaces[5] == 'O')
        {
            return true;
        }
        else if (spaces[6] == 'X' && spaces[7] == 'X' && spaces[8] == 'X')
        {
            return true;
        }
        else if (spaces[6] == 'O' && spaces[7] == 'O' && spaces[8] == 'O')
        {
            return true;
        }
        //---- Vertical ----\\
        else if (spaces[0] == 'X' && spaces[3] == 'X' && spaces[6] == 'X')
        {
            return true;
        }
        else if (spaces[0] == 'O' && spaces[3] == 'O' && spaces[6] == 'O')
        {
            return true;
        }
        else if (spaces[1] == 'X' && spaces[4] == 'X' && spaces[7] == 'X')
        {
            return true;
        }
        else if (spaces[1] == 'O' && spaces[4] == 'O' && spaces[7] == 'O')
        {
            return true;
        }
        else if (spaces[2] == 'X' && spaces[5] == 'X' && spaces[8] == 'X')
        {
            return true;
        }
        else if (spaces[2] == 'O' && spaces[5] == 'O' && spaces[8] == 'O')
        {
            return true;
        }
        //---- Diagonal ----\\
        else if (spaces[0] == 'X' && spaces[4] == 'X' && spaces[8] == 'X')
        {
            return true;
        }
        else if (spaces[0] == 'O' && spaces[4] == 'O' && spaces[8] == 'O')
        {
            return true;
        }
        else if (spaces[2] == 'X' && spaces[4] == 'X' && spaces[6] == 'X')
        {
            return true;
        }
        else if (spaces[2] == 'O' && spaces[4] == 'O' && spaces[6] == 'O')
        {
            return true;
        }
        //---- No winner ----\\
        else
        {
            return false;
        }
    }


    public void sendInfo(int board, int button, int count)
    {
        player.getInfo(board, button, count);
    }
    
    public void sendInfo(int board, int count)
    {
        player.getInfo(board, count);
    }
} // End of class
