package Model;

import java.util.Scanner;

public class Model {
    //------ Variables ------\\
    Player p1;
    Player p2;
    Scanner input = new Scanner(System.in);
    
    //------ Constructors ------\\
    /**
     * Default constructor
     */
    public Model()
    {
        p1 = new Player();
        p2 = new Player();
    }
    
    
    //------ Setters and Getters ------\\
    
    
    //------ Other Methods ------\\
    public int playerTurn()
    {
        int num;
        System.out.println("Enter number (1-9) to move in the corresponding square");
        num = input.nextInt();
        return num;
    }
    
} // End of class
