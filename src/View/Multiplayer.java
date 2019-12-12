package View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Multiplayer extends JFrame{
    //----Declare Variables----\\
    private JPanel mainPanel;
    private JFrame openOnClose;
    //----Constructors----\\
    /**
     * Method to initialize MenuPanel to default values
     */
    public Multiplayer()
    {
        super("Network Settings");
        
        mainPanel = new JPanel();
        ClientGUI client = new ClientGUI();
        client.setParentFrame(this);
        
        ServerGUI server = new ServerGUI();
        server.setParentFrame(this);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        
        tabbedPane.addTab("Client", client);
        tabbedPane.addTab("Server", server);
        
        mainPanel.add(tabbedPane);
        
        this.add(mainPanel);
        
        
    }
    
    //----Set Methods----\\
    public void setParentWindow(JFrame window)
    {
        this.openOnClose = window;
        this.setupWindowListeners();
    }
    
    //----Get Methods----\\

    
    //----Additional Methods----\\
    public void launchWindow()
    {
        setSize(300, 100);
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    private void setupWindowListeners()
    {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                openOnClose.setVisible(true);
            }
        });
    }
}
