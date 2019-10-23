package View;

import java.awt.Color;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UltimateGUI extends JFrame implements TicTacToeBoard{

    //Class Variables
    private UltimatePanel gamePanel = new UltimatePanel();
    private Color player1Color = Color.RED;
    private Color player2Color = Color.BLUE;
    
    /**
     * Default Constructor
     */
    public UltimateGUI()
    {
        //Initialize JFrame
        super("Tic-Tac-Toe!");
        
        gamePanel = new UltimatePanel();
        
        //Initialize the Panel
        //myPanel = new JPanel();
        this.add(gamePanel, "Center");
    }

    /**
     * Get the current player 1 color
     * @return Player 1's Color
     */
    public Color getPlayer1Color() {
        return player1Color;
    }

    /**
     * Set the color for player 1
     * @param player1Color The new color for player 1
     */
    public void setPlayer1Color(Color player1Color) {
        this.player1Color = player1Color;
    }

    /**
     * Get the current player 2 color
     * @return Player 2's Color
     */
    public Color getPlayer2Color() {
        return player2Color;
    }

    /**
     * Set the color for player 1
     * @param player2Color The new color for player 1
     */
    public void setPlayer2Color(Color player2Color) {
        this.player2Color = player2Color;
    }

    public void startTicTacToeGame()
    {
        //Finalize the frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(750, 750);
        setVisible(true);     
    }

    /**
     * Display the macro-board
     * @param moves 
     */
    @Override
    public void showBoard(char[] moves) {
        for(int i = 0; i < moves.length; i++)
        {
            if(Character.toLowerCase(moves[i]) == 'x')
                gamePanel.getSubBoard(i).fillBoard(player1Color);
            else if(Character.toLowerCase(moves[i]) == 'o')
                gamePanel.getSubBoard(i).fillBoard(player2Color);
            //If neither, do nothing the boards may still need to be used
        }
    }

    /**
     * Given an array of character arrays place the indicated moves in their positions
     * @param moves The array of moves
     */
    public void showBoard(char[][] moves)
    {
        for(int i = 0; i < moves.length; i++)
        {
            showSubBoard(i,moves[i]);
        }
    }        
    
    /**
     * Apply the moves board to the specified tic-tac-toe board
     * @param i 
     * @param moves 
     */
    private void showSubBoard(int i, char[] moves)
    {
        if(moves.length != 9)
        {
            System.out.println("Invalid Move List.");
            return;
        }
        //Local variables
        char p1 = 'x', p2 = 'o';
        
        //Iterate the loop and update as needed
        for(int j = 0; j < moves.length; j++)
        {
            //System.out.println("Check move " + moves[i]);
            if(Character.toLowerCase(moves[j]) == p1)
            {
                gamePanel.getSubBoard(i).setSquare(j,player1Color);
            }
            else if(Character.toLowerCase(moves[j]) == p2)
            {
                gamePanel.getSubBoard(i).setSquare(j,player2Color);
            }
            
        }
    }
    
    /**
     * Provided a winner indicate and declare the winner
     * @param winner The character of the player who won the game
     */
    @Override
    public void showWin(char winner) {
        if(Character.toLowerCase(winner) == 'x')
        {
            gamePanel.fillBoard(player1Color);
        }
        else if(Character.toLowerCase(winner) == 'o')
        {   
            gamePanel.fillBoard(player2Color);
        }
        
        //Likely need to remove these lines to get 9x9 running
        JOptionPane.showMessageDialog(new Frame(), winner + " has won!");
        System.exit(0);
    }
    
}
