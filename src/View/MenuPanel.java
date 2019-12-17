package View;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuPanel extends JFrame {
    // attributes
    private MainMenu mm;
   
    /**
     * Default Constructor
     */
    public MenuPanel() {
        super("Main Menu");
        setSize(1200, 800);
        
        mm = new MainMenu();
        this.add(mm, "Center");     
        System.out.println("Show the Main Menu Panel");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Create a menu of buttons provided an ArrayList of buttons
     * @param buttonList The buttons to make into a menu
     */
    public MenuPanel(ArrayList<JButton> buttonList)
    {
        super("Main Menu");
        setSize(1200, 800);
        
        mm = new MainMenu(buttonList);
        this.add(mm, "Center");     
        System.out.println("Show the Main Menu Panel");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable

    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable

    /**
     * Give access to the main menu
     * @return 
     */
    public MainMenu getMm() {
        return mm;
    }
    // Additional methods -- such as for calculation, display
    
    /**
     * Show the frame
     */
    public void open()
    {
        this.setVisible(true);
    }
    
    /**
     * Hide the frame from view
     */
    public void close()
    {
        this.setVisible(false);
    }
    
    /**
     * Add an actionlistener to every button
     * @param al The action to bind to every button
     */
    public void setActionListeners(ActionListener al)
    {
        // add Action listeners to every button in every panel
        mm.getHowtoButton().addActionListener(al);
        mm.getQuitButton().addActionListener(al);
        mm.getStartButton().addActionListener(al);
    }

}   //end class