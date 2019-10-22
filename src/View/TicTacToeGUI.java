package View;

//Imports
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToeGUI extends JFrame implements TicTacToeBoard{
    
    //Class Variables
    private TicTacToePanel gamePanel;
    private Color player1Color = Color.RED;
    private Color player2Color = Color.BLUE;
    
    //Constructor
    /**
     * Construct a usable Tic-Tac-Toe GUI
     */
    public TicTacToeGUI()
    {
        //Initialize JFrame
        super("Tic-Tac-Toe!");
        
        gamePanel = new TicTacToePanel();
        
        //Initialize the Panel
        //myPanel = new JPanel();
        this.add(gamePanel, "Center");   
        
        //Finalize the frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(750, 750);
        setVisible(true);        
    }

    /**
     * Allow the First Player's color to be retrieved
     * @return The color of the first player
     */
    public Color getPlayer1Color() {
        return player1Color;
    }

    /**
     * Allow the First Player's color to be set
     * @param player1Color The new color of the first player
     */
    public void setPlayer1Color(Color player1Color) {
        this.player1Color = player1Color;
    }

    /**
     * Allow the Second Player's color to be retrieved
     * @return The color of the second player
     */
    public Color getPlayer2Color() {
        return player2Color;
    }

    /**
     * Allow the Second Player's color to be set
     * @param player2Color The new color of the second player
     */
    public void setPlayer2Color(Color player2Color) {
        this.player2Color = player2Color;
    }
    
    /**
     * Display the tic-tac-toe board with moves inserted from the passed array
     * @param moves Array of length 9 that holds the characters representing player moves
     */
    @Override
    public void showBoard(char[] moves)
    {
        //System.out.println("Update the GUI!!!");
        if(moves.length != 9)
        {
            System.out.println("Invalid Move List.");
            return;
        }
        //Local variables
        char p1 = 'x', p2 = 'o';
        
        //Iterate the loop and update as needed
        for(int i = 0; i < 9; i++)
        {
            //System.out.println("Check move " + moves[i]);
            if(Character.toLowerCase(moves[i]) == p1)
            {
                gamePanel.setSquare(i,player1Color);
            }
            else if(Character.toLowerCase(moves[i]) == p2)
            {
                gamePanel.setSquare(i,player2Color);
            }
            
        }
    }
    
    /**
     * Show the winner given the character of the winner
     * @param winner The character that won the game
     */
    @Override
    public void showWin(char winner) {        
        for(int i = 0; i < 9; i++)
        {
            if(Character.toLowerCase(winner) == 'x')
            {
                gamePanel.setSquare(i,player1Color);
            }
            else if(Character.toLowerCase(winner) == 'o')
            {
                gamePanel.setSquare(i,player2Color);
            }
        }
        
        //Likely need to remove these lines to get 9x9 running
        JOptionPane.showMessageDialog(new Frame(), winner + " has won!");
        System.exit(0);
    }
    
    
    
    /**
     * Allow the buttons to be set from another class
     * @param i Button to be changed, 0 is top left
     * @param action The action to be performed
     */
    public void addActionListener(int i, ActionListener action)
    {
        gamePanel.getButton(i).addActionListener(action);
        //System.out.println("Button " + i + " bound");
    }
}
