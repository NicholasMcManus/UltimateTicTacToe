package View;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
        
        JTabbedPane tabbedPane = new JTabbedPane();
        
        tabbedPane.addTab("Client", new ClientGUI());
        tabbedPane.addTab("Server", new ServerGUI());
        
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
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we) {
                openOnClose.setVisible(true);
            }

            @Override
            public void windowClosed(WindowEvent we) {
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
