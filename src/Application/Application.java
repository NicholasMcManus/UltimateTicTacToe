package Application;

import Controller.Controller;
import java.io.FileNotFoundException;

public class Application {

    /**
     * Main driver for the program
     * @param args String array, currently unused
     */
    public static void main(String[] args) throws FileNotFoundException {
        View.UltimateGUI gamePane = new View.UltimateGUI();
        gamePane.startTicTacToeGame();
        gamePane.showBoard(new char[]{'x','o','\0', '\0','x','\0', 'o','\0','\0'});
        
//gamePane.showWin('x');
        //Controller controller = new Controller();

        //if(args.length > 0 && args[0].equals("GUI"))
            //controller.initializeGUIButtons();
        //else
            //controller.move();
            //controller.newMove();
        
    }
}
