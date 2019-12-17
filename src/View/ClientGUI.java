package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.net.SocketException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientGUI extends JPanel{
    
    private JTextField addressField, portField;
    private JButton connectButton;
    private Controller.ClientController cControl;
    private JFrame parentFrame = null;
    
    /**
     * Default constructor for a ClientGUI
     */
    public ClientGUI()
    {
        super();
        this.setLayout(new GridLayout());
        
        addressField = new JTextField("127.0.0.5");
        this.add(addressField);
        
        portField = new JTextField("1710");
        this.add(portField);
        
        connectButton = new JButton("Connect");
        this.add(connectButton);
        
        connectButton.addActionListener((ActionEvent ae) -> {
            connect();
        });
    }
    
    /**
     * Pass a parent frame to be opened when the opened window is closed
     * @param frame 
     */
    public void setParentFrame(JFrame frame)
    {
        parentFrame = frame;
    }
    
    /**
     * What to do when the button is pressed
     */
    private void connect()
    {
        if(parentFrame != null)
            parentFrame.setVisible(false);
        
        try{
            cControl = new Controller.ClientController(addressField.getText(), Integer.parseInt(portField.getText()));
            cControl.setParentFrame(this.parentFrame);
        }catch (SocketException ex)
        {
            if(parentFrame != null)
                parentFrame.setVisible(true);
        }
    }
}
