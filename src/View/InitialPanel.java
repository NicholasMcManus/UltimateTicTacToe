
/**
	File name: InitialPanel.java
	Short description:
	IST 242 Assignment:
	@author Jaemi Hammond
	@version 1.01 Apr 16, 2019
*/

package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author jbh5619
 */

public class InitialPanel extends JPanel {
    // attributes
    private MainMenu mm;
   
    
    public InitialPanel() {
        super();
        setLayout(null);
        setSize(1200, 800);
        
        mm = new MainMenu();
        add(mm);     
        mm.setVisible(true);
        
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