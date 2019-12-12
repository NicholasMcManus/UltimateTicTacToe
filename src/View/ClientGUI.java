package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientGUI extends JPanel{
    
    private JTextField addressField, portField;
    private JButton connectButton;
    private Controller.ClientController cControl;
    private JFrame parentFrame = null;
    
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
    
    public void setParentFrame(JFrame frame)
    {
        parentFrame = frame;
    }
    
    private void connect()
    {
        if(parentFrame != null)
            parentFrame.setVisible(false);
        
        try{
            cControl = new Controller.ClientController(addressField.getText(), Integer.parseInt(portField.getText()));
            cControl.setParentFrame(this.parentFrame);
        }catch (NullPointerException ex)
        {
            if(parentFrame != null)
                parentFrame.setVisible(true);
        }
    }
}
