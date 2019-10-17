package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
    //Local Variables
    TicTacToeConsole game;
    TicTacToeGUI guiInstance;
    
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
        game = new TicTacToeConsole(fileName);
        guiInstance = new TicTacToeGUI();
        for(int i = 0; i < 9; i++)
        {
            final int button = i;
            
            guiInstance.addActionListener(i, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.out.println(button);
                }
            });
        }
    }
    
    /**
     * Output the moves from the array
     * @param moves 1 Dimensional array with data
     */
    public void showBoard(char[] moves)
    {
        game.showBoard(moves);
        guiInstance.showBoard(moves);
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
