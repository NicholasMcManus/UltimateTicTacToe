package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UltimateView {
    
    //Local Variables
    private UltimateGUI uGame;
    
    //Constructors
    /**
    * Default Constructor
    */
    public UltimateView()
    {
        uGame = new UltimateGUI();
    }
    
    /**
     * Output the moves from the array
     * @param moves 1 Dimensional array with data
     */
    public void showBoard(char[] moves)
    {
        uGame.showBoard(moves);
    }
    
    /**
     * Start the tic-tac-toe game
     */
    public void startGame()
    {
        uGame.startTicTacToeGame();
    }
    
    /**
     * Allow the buttons to be set from another class
     * @param board The board to target
     * @param button The button of the board to assign the action to
     * @param action The action to be performed
     */
    public void addActionListener(int board, int button, ActionListener action)
    {
        //uGame.addActionListener(board, button, action);
        
        for(int lBoard = 0; lBoard < 9; lBoard++)
        {
            for(int lButton = 0; lButton < 9; lButton++)
            {
                final int F_BOARD = lBoard, F_BUTTON = lButton;
                System.out.println("Call Bind (" + F_BOARD + "," + F_BUTTON + ")");
                uGame.addActionListener(lBoard, lButton, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        System.out.println("Board: " + F_BOARD + " Button: " + F_BUTTON);
                    }
                });
            }
        }
    }
    
    /**
     * Declare someone the winner of the game
     * @param winner The character of the winner
     */
    public void declareWinner(char winner)
    {
        uGame.showWin(winner);
    }
    
    /**
     * Output the moves from an array
     * @param moves The array containing user moves
     */
    public void showBoard(char[][] moves)
    {
        uGame.showBoard(moves);
    }
}
