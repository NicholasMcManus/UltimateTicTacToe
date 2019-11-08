package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingGUI extends JFrame{

    //Class Variables    
    private Color player1Color, player2Color;
    private PlayerColorChooser pChoice;
    private JLabel player1, player2;
    private JButton changeP1, changeP2;
    
    /**
     * The constructor for user color settings
     * @param player1Color The current color for player 1
     * @param player2Color The current color for player 2
     */
    public SettingGUI(Color player1Color, Color player2Color)
    {
        super();
        
        JPanel panel = new JPanel();
        
        //GridPane layout setup
        GridLayout layout = new GridLayout(2,2);        
        panel.setLayout(layout);
        
        //Put the provided information into the class
        this.player1Color = player1Color;
        this.player2Color = player2Color;
        
        //Setup Player Color Labels
        player1 = new JLabel("Player 1");
        player2 = new JLabel("Player 2");
        
        //Setup Buttons for changing player color
        changeP1 = new JButton("Change");
        changeP1.setBackground(player1Color);
        changeP1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setPlayer1Color();
            }
        });
        
        changeP2 = new JButton("Change");
        changeP2.setBackground(player2Color);
        changeP2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setPlayer2Color();
            }
        });
        
        //Add elements to the pane
        panel.add(player1);
        panel.add(changeP1);
        panel.add(player2);
        panel.add(changeP2);
        this.add(panel);
        
        //Perform final setup
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(750, 750);
        setVisible(true); 
    }
    
    /**
     * Allow for window events to be passed by a utilizing class
     * @param event 
     */
    public void setWindowListener(WindowListener event)
    {
        this.addWindowListener(event);
    }
    
    /**
     * A method to get the color for player 1
     * @return The color of player 1
     */
    public Color getPlayer1Color()
    {
        return player1Color;
    }
    
    /**
     * A method to get the color for player 2
     * @return The color of player 2
     */
    public Color getPlayer2Color()
    {
        return player2Color;
    }
    
    /**
     * A WindowListener oriented towards setting the first player's color
     */
    private void setPlayer1Color()
    {
        pChoice = new PlayerColorChooser(player1Color);
        pChoice.setWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we) {
            }

            @Override
            public void windowClosed(WindowEvent we) {
                player1Color = pChoice.getColor();
                changeP1.setBackground(player1Color);
            }

            @Override
            public void windowIconified(WindowEvent we) {
            }

            @Override
            public void windowDeiconified(WindowEvent we) {
            }

            @Override
            public void windowActivated(WindowEvent we) {
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
            }
        });
    }
    
    /**
     * A WindowListener oriented towards setting the second player's color
     */
    private void setPlayer2Color()
    {
        pChoice = new PlayerColorChooser(player2Color);
        pChoice.setWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we) {
            }

            @Override
            public void windowClosed(WindowEvent we) {
                player2Color = pChoice.getColor();
                changeP2.setBackground(player2Color);
            }

            @Override
            public void windowIconified(WindowEvent we) {
            }

            @Override
            public void windowDeiconified(WindowEvent we) {
            }

            @Override
            public void windowActivated(WindowEvent we) {
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
            }
        });
    }
}
