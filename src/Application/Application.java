package Application;

import java.io.FileNotFoundException;
import View.View;

public class Application {

    /**
     * Main driver for the program
     * @param args String array, currently unused
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        View thisView = new View();
                
        char[] trying = new char[9];
        trying[4] = 'X';
        trying[0] = 'O';
        
        thisView.showBoard(trying);
    }
}
