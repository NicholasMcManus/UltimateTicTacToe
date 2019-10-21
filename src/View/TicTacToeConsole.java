package View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicTacToeConsole implements TicTacToeBoard{

    //Class Variables
    private static char placeHolder = '#';
    public final static String DEFAULT_FILE = "baseTicTacToe.txt";

    private String boardTemplate = "";
    
    //Constructors
    /**
     * Default constructor
     * Tries reading from default file
     * Creates file if does not exist
     * Reads data from created file
     */
    public TicTacToeConsole()
    {
        this(DEFAULT_FILE);
    }
    
    /**
     * Use a custom file to read in the tic-tac-toe board
     * @param fileName The file to be read in
     */
    public TicTacToeConsole(String fileName)
    {
        //Local Variables
        Scanner input = new Scanner("");
        boolean success = true;
        
        //Try opening the default file, if it does not exist
        //Try creating it and then opening it
        //If neither of these work, the program gives up.
        try {
            input.close();
            input = new Scanner(new File(fileName));
        } catch (FileNotFoundException ex) {
            //If the file cannot be found, try creating the file to be 
            try {
                System.out.println("There was an error openning " + fileName + " recovering using defaults");
                success = false;
                createDefaultFile();
                input = new Scanner(new File(DEFAULT_FILE));
            } catch (FileNotFoundException ex1) {
                Logger.getLogger(TicTacToeConsole.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        //Tell user which file actually decided to open
        System.out.println((success ? fileName : DEFAULT_FILE) + " was opened successfully");
        
        System.out.println("Reading Board Data from File");
        while(input.hasNextLine())
        {
            boardTemplate += input.nextLine() + '\n';
        }
    }
    
    //Static Method to create Default File
    /**
     * Create a file to act as a base
     * @throws FileNotFoundException 
     */
    protected static void createDefaultFile() throws FileNotFoundException {
        
        //Local Variables
        String sampleBoard = "   |   |   \n" +
                             " # | # | # \n" +
                             "   |   |   \n" +
                             "---+---+---\n" +
                             "   |   |   \n" +
                             " # | # | # \n" +
                             "   |   |   \n" +
                             "---+---+---\n" +
                             "   |   |   \n" +
                             " # | # | # \n" +
                             "   |   |   ";
        File sampleFile = new File(DEFAULT_FILE);
        
        sampleBoard = sampleBoard.replace('#', placeHolder);
        
        //Try opening the newly created file
        try {
            //Initialize the output stream
            PrintWriter output = new PrintWriter(sampleFile);
            
            //Write the sample to the file
            output.print(sampleBoard);
            
            //Close the writing stream
            output.close();
        } catch (FileNotFoundException ex) {
            System.out.println("There was an error opening the default file for editing");
            throw ex;
        }        
    }

    /**
     * Get the user input and return
     * @return The input from the user
     */
    public int getPlayerTurn()
    {
        Scanner input = new Scanner(System.in);
        int num;
        
        System.out.println("Enter number (1-9) to move in the corresponding square");
        num = input.nextInt();
        return num;
    }
    
    /**
     * Change the placeholder character
     * @param placeHolder Character to replace with player moves
     */
    protected static void setPlaceHolder(char placeHolder)
    {
        TicTacToeConsole.placeHolder = placeHolder;
    }
    
    /**
     * Method to allow boards read to be validated
     */
    private boolean validateBoard()
    {
        return ((boardTemplate.split(Character.toString(placeHolder))).length == 10);
    }
        
    /**
     * Display the tic-tac-toe board with moves inserted from the passed array
     * @param moves Array of length 9 that holds the characters representing player moves
     */
    @Override
    public void showBoard(char[] moves)
    {
        //Validate input
        if(!validateBoard())
        {
            System.out.println("Error: Array is the wrong size");
            return;
        }
        
        //Decalare local variables
        String[] components = boardTemplate.split(Character.toString(placeHolder));
        String message = components[0];
        
        for(int i = 0; i < moves.length; i++)
        {
            message += (moves[i] == '\0' ? ' ' : moves[i]) + components[i+1];
        }
        
        System.out.println(message);
    }
    
    /**
     * @return The representation of the object as a string
     */
    @Override
    public String toString() {
        return boardTemplate + "\nValid: " + this.validateBoard();
    }
}