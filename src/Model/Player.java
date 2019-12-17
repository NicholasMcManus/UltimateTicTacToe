
package Model;



public class Player {
    //------ Variables ------\\
    String player1History, player2History;
    int player1Counter, player2Counter;
    
    //------ Constructors ------\\
    /*
     * Default constructor
     */
    public Player()
    {
        player1History = "";
        player2History = "";
        player1Counter = 0;
        player2Counter = 0;
    }
    
    //------ Setters and Getters ------\\
    
    
    //------ Other Methods ------\\
    public void getInfo(int board, int button, int count)
    {
        if(count % 2 == 0)
        {
            player1Counter++;
            player1History += "\nMoved at space [" + board + "," + button + "].";
        }
        else
        {
            player2Counter++;
            player2History += "\nMoved at space [" + board + "," + button + "].";
        }
    }
    
    
    public void toFile()
    {
        
    }
    
} // End of class
