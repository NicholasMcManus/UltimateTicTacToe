package View;

//Swing Components
import javax.swing.JPanel;
import javax.swing.BorderFactory;

//AWT Components
import java.awt.GridLayout;
import java.awt.Color;

public class UltimatePanel extends JPanel{

    //Class Variables
    private TicTacToePanel[] tPanels;
    
    /**
     * Default Constructor
     */
    public UltimatePanel()
    {
        super();
        
        GridLayout layout = new GridLayout(3,3);
        layout.setVgap(0);
        layout.setHgap(0);
        
        this.setLayout(layout);
        
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        
        tPanels = new TicTacToePanel[9];
        
        for(int i = 0; i < tPanels.length; i++)
        {
            tPanels[i] = new TicTacToePanel();
            this.add(tPanels[i]);
            tPanels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        }
    }
    
    /**
     * Return the sub-TicTacToe board indicated
     * @param i The index of the sub-TicTacToe board
     * @return The sub-board specified
     */
    protected TicTacToePanel getSubBoard(int i)
    {
        return tPanels[i];
    }
    
    /**
     * Fill the entire board with a single color
     * @param paintBucket The color to paint the entire board
     */
    protected void fillBoard(Color paintBucket)
    {
        for(TicTacToePanel single : tPanels)
        {
            single.fillBoard(paintBucket);
        }
    }
    
}
