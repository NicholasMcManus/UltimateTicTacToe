package View;

//Import Statements
import java.awt.Color;
import javax.swing.JPanel;

//Swing Components
import javax.swing.JButton;

//AWT Components
import java.awt.GridLayout;

public class TicTacToePanel extends JPanel{
    //Class Variables
    private JButton[] ticTacToeButtons;
    
    //Constructor
    /**
     * Default constructor for building a tic-tac-toe pane
     */
    public TicTacToePanel()
    {
        //Construct a JPanel
        super();
        
        GridLayout layout;
        
        //Make a 3x3 View
        layout = new GridLayout(3,3);
        layout.setHgap(0);
        layout.setVgap(0);
        
        //Initialize the button array
        ticTacToeButtons = new JButton[9];
        
        //Put everything together
        this.setLayout(layout);
        
        for(int i = 0; i < ticTacToeButtons.length; i++)
        {
            //Initialize Button
            ticTacToeButtons[i] = new JButton();
            
            //Now the loop can work like a for-each
            JButton myButton = ticTacToeButtons[i];
            
            //Setup the button
            myButton.setContentAreaFilled(false);
            this.add(myButton);
        }
                
        validate();
        repaint();
    }
    
    //Write over a button with a square to show player move and disable button
    /**
     * Update the specified square with the color passed
     * @param i The square to be modified
     * @param playerColor The color to be changed to
     */
    protected void setSquare(int i, Color playerColor)
    {
        //System.out.println("Set " + i + " " + playerColor);
        ticTacToeButtons[i].setBackground(playerColor);
        ticTacToeButtons[i].setContentAreaFilled(true);
        ticTacToeButtons[i].setEnabled(false);
    }
    
    /**
     * Fill the board with the provided color
     * @param playerColor The color to fill the board with
     */
    protected void fillBoard(Color playerColor)
    {
        for(int i = 0; i < 9; i++)
            this.setSquare(i, playerColor);
    }
    
    /**
     * Return the specified button for modification
     * @param i The button selected
     * @return A direct reference to the button
     */
    protected JButton getButton(int i)
    {
        //System.out.println("Button " + i + " retrieved");
        return ticTacToeButtons[i];
    }
}
