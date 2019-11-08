package Application;

//import Controller.Controller;
import java.awt.Color;
import java.io.FileNotFoundException;

public class Application {

    /**
     * Main driver for the program
     * @param args String array, currently unused
     */
    public static void main(String[] args) throws FileNotFoundException {
        //Testing the UltimateView Functions        
        View.UltimateView uView = new View.UltimateView();
        
        char[][] moves = new char[9][9];
        char[] winTest = new char[9];
        
        moves[0][0] = 'x';
        moves[1][1] = 'o';
        moves[2][2] = 'x';
        moves[3][3] = 'o';
        moves[4][4] = 'x';
        moves[5][5] = 'o';
        moves[6][6] = 'x';
        moves[7][7] = 'o';
        moves[8][8] = 'x';
        
        winTest[0] = 'x';
        winTest[1] = 'o';
        winTest[4] = 'x';
        winTest[6] = 'o';
        
        /*/
        uView.startGame(Color.GRAY,Color.BLACK);
        //uView.addActionListener(0, 0, null);
        uView.showBoard(moves);
        uView.showBoard(winTest);
        //*/
        
        //Testing the UltimateController
        Controller.UltimateController uc = new Controller.UltimateController();
        uc.start();
        //Testing the Main Menu
        //Controller.MainMenuController mc = new Controller.MainMenuController();

        //gamePane.showWin('x');
        //Controller controller = new Controller();

        //if(args.length > 0 && args[0].equals("GUI"))
            //controller.initializeGUIButtons();
        //else
            //controller.move();
            //controller.newMove();
        
    }
}
