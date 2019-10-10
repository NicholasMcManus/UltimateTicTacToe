package View;

//Imports
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TicTacToeGUI extends Application{

    //Class Variables
    private Stage myStage;
    private Button[] myButton = new Button[9];
    
    private BorderPane mainPane = new BorderPane();
    private GridPane gridPane = new GridPane();
    private Pane myPane = new Pane();
      
    /**
     * Start the Javafx application
     * @param primaryStage The stage to start with
     */
    @Override
    public void start(Stage primaryStage) throws Exception {            
    //creating a Group object 
    Group group = new Group(); 
    this.myStage = primaryStage;
    
    //Creating a Scene by passing the group object, height and width   
    Scene scene = new Scene(group ,600, 300); 
      
    //setting color to the scene 
    scene.setFill(Color.BROWN);  
      
    //Setting the title to Stage. 
    primaryStage.setTitle("Sample Application"); 
   
    //Adding the scene to Stage 
    primaryStage.setScene(scene); 
       
    //Displaying the contents of the stage 
    primaryStage.show(); 
    }    
}
