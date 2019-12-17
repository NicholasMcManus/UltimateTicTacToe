package Application;

//import Controller.Controller;
import java.io.FileNotFoundException;

public class Application {

    /**
     * Main driver for the program
     * @param args String array, currently unused
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        //Testing the Main Menu
        Controller.MainMenuController mc = new Controller.MainMenuController();
    }
}
