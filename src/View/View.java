package View;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View {
    //Local Variables
    private ArrayList<TicTacToeBoard> games = new ArrayList();
    
    //Constructors
    /**
    * Default Constructor
    */
    public View()
    {
        this(TicTacToeConsole.DEFAULT_FILE);
    }
    
    /**
     * Constructor with specific file
     * @param fileName The file to try and open to create the board
     */
    public View(String fileName)
    {
        games.add(new TicTacToeConsole(fileName));
        games.add(new TicTacToeGUI());
    }
    
    /**
     * Output the moves from the array
     * @param moves 1 Dimensional array with data
     */
    public void showBoard(char[] moves)
    {
        games.forEach(var -> var.showBoard(moves));
    }
    
    /**
     * Uses a scanner to read in a tic-tac-toe move
     * @return The requested space or -1 if no console views exist
     */
    public int consoleMove()
    {
        for(TicTacToeBoard board : games)
        {
            if(board instanceof TicTacToeConsole)
                return ((TicTacToeConsole)board).getPlayerTurn();
        }
        return -1;
    }
    
    /**
     * Allow the buttons to be set from another class
     * @param i Button to be changed, 0 is top left
     * @param action The action to be performed
     */
    public void addActionListener(int i, ActionListener action)
    {
        games.forEach(e -> 
        {
            if(e instanceof TicTacToeGUI) 
                    ((TicTacToeGUI)e).addActionListener(i, action);
        });
            
    }
    
    /**
     * Output the moves from an array
     * @param moves The array containing user moves
     */
    public void showBoard(char[][] moves)
    {
        //Make sure to reduce indexOutOfBounds errors
        if(moves.length == 0)
            return;
        
        //Make the local variable able to support all values
        char[] newMoves = new char[(moves.length*moves[0].length)];
        
        //Fill the new array with values from the 1D array
        for(int outer = 0; outer < moves.length; outer++)
            for(int inner = 0; inner < moves[outer].length; inner++)
                newMoves[outer*moves.length+inner] = moves[outer][inner];
        
        //Display the board from the converted values
        this.showBoard(newMoves);
    }
    
}
