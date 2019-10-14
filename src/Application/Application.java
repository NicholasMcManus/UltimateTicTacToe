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
        
        char[][] biggerAttempt = {{'0','1','2'},{'3','4','5'},{'6','7','8'}};
        
        trying = new char[]{'0','1','2','3','4','5','6','7','8'};
        
        thisView.showBoard(biggerAttempt);
        thisView.showBoard(trying);
    }
}
