package Application;

import Controller.Controller;
import java.io.FileNotFoundException;

public class Application {

    /**
     * Main driver for the program
     * @param args String array, currently unused
     */
    public static void main(String[] args) throws FileNotFoundException {
        View.UltimateView uView = new View.UltimateView();
        
        char[][] moves = new char[9][9];
        moves[0][0] = 'x';
        moves[1][1] = 'o';
        moves[2][2] = 'x';
        moves[3][3] = 'o';
        moves[4][4] = 'x';
        moves[5][5] = 'o';
        moves[6][6] = 'x';
        moves[7][7] = 'o';
        moves[8][8] = 'x';
        
        uView.startGame();
        uView.addActionListener(0, 0, null);
        uView.showBoard(moves);
        uView.showBoard(new char[]{'x','o','\0', '\0','x','\0', 'o','\0','\0'});
        
//gamePane.showWin('x');
        //Controller controller = new Controller();

        //if(args.length > 0 && args[0].equals("GUI"))
            //controller.initializeGUIButtons();
        //else
            //controller.move();
            //controller.newMove();
        
    }
}
