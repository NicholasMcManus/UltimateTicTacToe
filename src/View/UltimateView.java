package View;

import java.awt.Color;
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
     * Start the tic-tac-toe game with custom player move colors
     * @param player1Color The color to use for player 1
     * @param player2Color The color to use for player 2
     */
    public void startGame(Color player1Color, Color player2Color)
    {
        uGame.startTicTacToeGame(player1Color, player2Color);
    }
    
    /**
     * Allow the buttons to be set from another class
     * @param board The board to target
     * @param button The button of the board to assign the action to
     * @param action The action to be performed
     */
    public void addActionListener(int board, int button, ActionListener action)
    {
        uGame.addActionListener(board, button, action);
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
    
    /**
     * Get the UltimateGUI frame
     * @return UltimateGUI frame
     */
    //public UltimateGUI getUGame() {
    //    return uGame;
    //}
}
