package Controller;

//Adapted from IST 220 program designed to play around with sockets
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ServerController extends Thread{
 
    protected Socket socket;
    private ObjectOutputStream out = null;
    private ObjectInputStream in = null;
    private View.MenuPanel menu;
    private JButton colorChange;
    private Thread thread;
    private ServerGame sGame;
    private JFrame parentFrame;
    
    private ServerController(Socket socket) {
        try {            
            this.socket = socket;
            
            System.out.println("New client connected from " + socket.getInetAddress().getHostAddress());
            
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            
            thread = this;
            thread.start();
            
            this.buildSimpleMenu();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 
    public ServerController(int portNumber) throws SocketTimeoutException
    {
        System.out.println("SocketServer Example");
        ServerSocket server = null;
        try {
            server = new ServerSocket(portNumber);
            
            //Set server search time to 5 seconds
            server.setSoTimeout(5000);
                /**
                 * create a new {@link SocketServer} object for each connection
                 * this will allow multiple client connections
                 * When used with the while true, only needing 1 connection per
                 * server, the loop is commented out
                 */
                System.out.println("And we wait...");
                new ServerController(server.accept());
                System.out.println("Found a Client!");
                
                
                
        } catch (SocketTimeoutException to){
            System.out.println("Client took too long to connect");
            throw to;
        } catch (IOException ex) {
            System.out.println("Unable to start server.");
        } finally {
            try {
                if (server != null)
                    server.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
        
    public void buildSimpleMenu()
    {
        ArrayList<JButton> buttonList = new ArrayList();

        JButton start = new JButton("Start");
        start.setBackground(Color.GREEN);
        buttonList.add(start);

        colorChange = new JButton("Set Color");
        colorChange.setBackground(Color.RED);
        buttonList.add(colorChange);

        JButton exit = new JButton("Quit");
        exit.setBackground(Color.RED);

        buttonList.add(exit);

        this.menu = new View.MenuPanel(buttonList);
        this.menu.setTitle("Server Menu");
        this.menu.setDefaultCloseOperation(EXIT_ON_CLOSE);     
        
        this.menu.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                if(ServerController.this.parentFrame != null)
                    ServerController.this.parentFrame.setVisible(true);
            }
        
        });
        
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ServerController.this.out.writeObject(
                            ServerController.this.colorChange.getBackground());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        colorChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServerController.this.menu.close();
                View.PlayerColorChooser pc = new View.PlayerColorChooser(colorChange.getBackground());
                pc.setWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent we) {
                        colorChange.setBackground(pc.getColor());
                        ServerController.this.menu.open();
                    }
                });
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    out.writeObject("bye");
                } catch (IOException ex) {
                    System.err.println("Error when pushing quit command to server, it may have already closed");
                }
                //ServerController.this.menu.dispose();
            }
        });
    }

    public void setParentFrame(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }
    
    @Override
    public void run() {
        //Variables to manipulate the socket buffers
        final int SEND_SIZE = 100, RECIEVE_SIZE = 100;
        int numMessages = 0;
        
        try {
            // process I/O from communication buffer
            String request;
            
            socket.setSendBufferSize(SEND_SIZE);
            socket.setReceiveBufferSize(RECIEVE_SIZE);
            
            while (numMessages > -1) {
                Object input = in.readObject();
                
                if(input instanceof String)
                {
                    request = (String)input;

                    //Step 4: Modify to say Message Processed
                    System.out.println("Message processed:" + request);

                    if(request.equals("Q"))
                    {
                        System.out.println("Exit Program!");
                        out.writeObject("q");
                        break;
                    }
                    else if(request.equals("rQuit"))
                    {
                        sGame.dispose();
                    }
                    else
                    {
                        request += '\n';
                        out.writeObject(request);
                    }
                    out.writeObject(++numMessages);
                }
                else if(input instanceof Color)
                {
                    System.out.println("Acknowledgement recieved, let's GOOO!");
                    menu.close();
                    sGame = new ServerGame(in, out, colorChange.getBackground(), (Color)input);
                    sGame.setWindowProperties(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent we) {
                            ServerController.this.menu.setVisible(true);
                            try {
                                out.writeObject("rQuit");
                            } catch (IOException ex) {
                                System.out.println("Could not send close to client");
                            }
                        }
                    });
                }
                else if(input instanceof int[])
                {
                    int[] temp = (int[])input;
                    sGame.opponentMove(temp[0], temp[1]);
                }
                else
                {
                    System.out.println("Recieved " + input + "\nBut don't know what to do with it...");
                }
            }
        } catch (EOFException ex){
            System.out.println("Lost connection to stream. Shutting down.");
        } catch (IOException ex) {
            System.out.println("Unable to get streams from client");
            System.out.println(ex.toString());
            for(Object o: ex.getStackTrace())
                System.err.println(o);
        } catch (ClassNotFoundException ex) {
            System.err.println("Something broke when reading a class from the stream...");
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
                System.out.println("Object resources cleaned up.");
                this.menu.dispose();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (NullPointerException ex){
                System.out.println("Something was cleaned up before I got there. ServerController:271");
            }
            
        }
    }

    public static void main(String[] args) throws SocketTimeoutException {
        new ServerController(8082);
    }
}