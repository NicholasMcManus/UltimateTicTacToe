package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientGUI extends JPanel{
    
    private JTextField addressField, portField;
    private JButton connectButton;
    private Controller.ClientController cControl;
    
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
    
    private void connect()
    {
        this.setVisible(false);
        cControl = new Controller.ClientController(addressField.getText(), Integer.parseInt(portField.getText()));
    }
}
