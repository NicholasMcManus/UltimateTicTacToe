package Application;

import Controller.Controller;
import java.io.FileNotFoundException;
import View.View;

public class Application {

    /**
     * Main driver for the program
     * @param args String array, currently unused
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        Controller controller = new Controller();

        //if(args.length > 0 && args[0].equals("GUI"))
            controller.initializeGUIButtons();
        //else
            //controller.move();
            //controller.newMove();
    }
}
