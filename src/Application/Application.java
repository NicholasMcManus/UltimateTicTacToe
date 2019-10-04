package Application;

import java.io.FileNotFoundException;

public class Application {

    /**
     * Main driver for the program
     * @param args String array, currently unused
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        View.TicTacToeConsole testBoard;
        //View.TicTacToeConsole.setPlaceHolder('~');
        View.TicTacToeConsole.createDefaultFile();
        
        testBoard = new View.TicTacToeConsole();
        
        //System.out.println(testBoard);
        
        char[] trying = new char[9];
        trying[4] = 'X';
        trying[0] = 'O';
        
        testBoard.showBoard(trying);
    }
}
