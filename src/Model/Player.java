
package Model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player {
    //------ Variables ------\\
    String path;
    String player1History, player2History;
    int player1Counter, player2Counter;
    
    //------ Constructors ------\\
    /*
     * Default constructor
     */
    public Player()
    {
        path = "Player info";
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
            player1History += "\nMoved at space [" + (board+1) + "," + (button+1) + "].";
        }
        else
        {
            player2Counter++;
            player2History += "\nMoved at space [" + (board+1) + "," + (button+1) + "].";
        }
        
        try {
            toFile();
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getInfo(int board, int count)
    {
        if(count % 2 == 0)
        {
            player1History += "\nWon board " + (board+1);
        }
        else
        {
            player2History += "\nWon board " + (board+1);
        }
        
        try {
            toFile();
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void toFile() throws IOException
    {
        FileWriter write = new FileWriter(path);
        PrintWriter print = new PrintWriter(write);
        
        print.println("~~Player 1 Info~~");
        print.println("\nNumber of moves: " + player1Counter);
        print.print("\nMove history:");
        print.println(player1History);
        
        print.println("\n");
        print.println("~~Player 2 Info~~");
        print.println("\nNumber of moves: " + player2Counter);
        print.print("\nMove history:");
        print.print(player2History);
        
        print.close();
    }
    
} // End of class
