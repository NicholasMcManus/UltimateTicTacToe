package View;

//Import Statements
import javax.swing.JPanel;

//Swing Components
import javax.swing.JButton;

//AWT Conponents
import java.awt.GridLayout;
import java.awt.event.ActionListener;

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
        layout.setHgap(10);
        layout.setVgap(10);
        
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
    
    protected JButton getButton(int i)
    {
        System.out.println("Button " + i + " retrieved");
        return ticTacToeButtons[i];
    }
}
