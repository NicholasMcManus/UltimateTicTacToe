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

    public MainMenu getMm() {
        return mm;
    }
    // Additional methods -- such as for calculation, display
    
    public void setActionListeners(ActionListener al)
    {
        // add Action listeners to every button in every panel
        mm.getHowtoButton().addActionListener(al);
        mm.getQuitButton().addActionListener(al);
        mm.getStartButton().addActionListener(al);
    }

}   //end class