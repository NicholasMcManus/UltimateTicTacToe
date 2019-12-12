package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.net.SocketTimeoutException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ServerGUI extends JPanel{

    private JTextField portField;
    private JButton hostButton;
    private Controller.ServerController sControl;
    private JFrame parentFrame;
    
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
    
        public void setParentFrame(JFrame frame)
    {
        parentFrame = frame;
    }
    
    private void startServer()
    {
        if(this.parentFrame != null)
            parentFrame.setVisible(false);
        
        try {
            sControl = new Controller.ServerController(Integer.parseInt(portField.getText()));
            sControl.setParentFrame(parentFrame);
        } catch (SocketTimeoutException ex) {
            if(this.parentFrame != null)
            parentFrame.setVisible(true);
        }
        
    }
}
