package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ServerGUI extends JPanel{

    private JTextField portField;
    private JButton hostButton;
    private Controller.ServerController sControl;
    
    public ServerGUI()
    {
        super();
        this.setLayout(new GridLayout());
        
        this.add(new JLabel("Port"));
        
        portField = new JTextField("1710");
        this.add(portField);
        
        hostButton = new JButton("Host");
        this.add(hostButton);
        
        hostButton.addActionListener((ActionEvent ae) -> {
            this.startServer();
        });
    }
    
    private void startServer()
    {
        sControl = new Controller.ServerController(Integer.parseInt(portField.getText()));
    }
}
