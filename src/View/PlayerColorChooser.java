package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class PlayerColorChooser extends JFrame{
    //Class Variables
    private Color playerColor;
    private JColorChooser colorChooser;
    
    /**
     * Default constructor for a player to select a color
     * @param playerColor The original color of the player
     */
    public PlayerColorChooser(Color playerColor)
    {
        //Initialize Frame
        super();

        //Declare/Initialize Varaibles
        JPanel panel = new JPanel();
        
        this.playerColor = playerColor;
        
        colorChooser = new JColorChooser(this.playerColor);
        
        //Setup and apply the layout
        BorderLayout bLayout = new BorderLayout();
        panel.setLayout(bLayout);
        
        //Remove the default chooser panels, except for the first one
        AbstractColorChooserPanel panels[] = colorChooser.getChooserPanels();
        for (int i = 1; i < panels.length; i ++) {
            colorChooser.removeChooserPanel(panels[i]);
        }
        
        //Make the close button
        JButton closeButton = new JButton("Set");
        closeButton.setBackground(Color.GREEN);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                closeWindow();
            }
        });
        
        panel.add(colorChooser, BorderLayout.CENTER);
        panel.add(closeButton, BorderLayout.SOUTH);
        
        this.setTitle("Choose a Color");
        
        //Call the window handler when closing
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        this.add(panel);
        this.setSize(750, 375);
        this.setVisible(true);
    }
    
    /**
     * Allow the color to be retrieved from the pane
     * @return The selected color
     */
    public Color getColor()
    {
        return colorChooser.getColor();
    }
    
    /**
     * A method to close the menu that can be used from a button
     */
    private void closeWindow()
    {
        this.dispose();
    }
    
    /**
     * A method to allow a parent class to define window event interaction
     * @param event The event(s) and handling for each
     */
    public void setWindowListener(WindowListener event)
    {
        this.addWindowListener(event);
    }
}
