package View;

//Imports
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class TicTacToeGUI extends JFrame{
    
    //private JFrame initialFrame;
    //private JPanel myPanel;
    private TicTacToePanel gamePanel;
    
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
     * Allow the buttons to be set from another class
     * @param i Button to be changed, 0 is top left
     * @param action The action to be performed
     */
    public void addActionListener(int i, ActionListener action)
    {
        gamePanel.getButton(i).addActionListener(action);
        System.out.println("Button " + i + " bound");
    }
}
