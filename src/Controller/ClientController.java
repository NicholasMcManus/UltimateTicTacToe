package Controller;

//Adapted from IST 220 program designed to play around with sockets
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ClientController extends Thread {

    //Variables to modify the buffer
    private static final int SEND_SIZE = 100, RECIEVE_SIZE = 100;
    private Socket echoSocket = null;
    private ObjectOutputStream out = null;
    private ObjectInputStream in = null;
    private int port;
    private String address;
    private View.MenuPanel menu;
    private JButton colorChange;
    private ClientGame cGame;

    //GUI Bits
    public static void main(String args[]) {
        new ClientController("127.0.0.5", 8082);
    }

    public ClientController(String host, int port) {
        this.address = host;
        this.port = port;

        try {
            //Server setup
            String serverHostname = host;

            System.out.println("Connecting to host " + serverHostname + " on port " + port + ".");
            //Setup Socket
            this.startClientSocket(this.address, this.port);

            //Start listener for socket
            this.start();

            //Try to get the socket started, returns false if an error occured
            //Not implemented exactly yet
            /**
             * {@link UnknownHost} object used to read from console
             */
            //Modify the buffer sizes
            echoSocket.setSendBufferSize(SEND_SIZE);
            echoSocket.setReceiveBufferSize(RECIEVE_SIZE);

            //Actually what the client does
            //Launch the GUI
            this.buildSimpleMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean startClientSocket(String serverHostname, int port) {
        try {
            // instantiate new Socket connected to the server
            echoSocket = new Socket(serverHostname, port);
            out = new ObjectOutputStream(echoSocket.getOutputStream());
            in = new ObjectInputStream((echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + serverHostname);
            return false;
        } catch (IOException e) {
            System.err.println("Unable to get streams from server");
            return false;
        }

        return true;
    }

    @Override
    public void run() {
        this.watchSocket();
    }

    private void watchSocket() {
        try {
            /**
             * {@link UnknownHost} object used to read from console
             */

            int messageNum = 0;

            boolean serverShutdown = false;
            while (messageNum > -1) {
                //System.out.print("client: ");
                Object current = in.readObject();

                if (current instanceof String) {
                    String userInput = (String) current;
                    /**
                     * Exit on 'q' char sent
                     */
                    if ("q".equals(userInput)) {
                        out.writeObject("Q");
                    } else if ("bye".equals(userInput)) {
                        serverShutdown = true;
                    }

                    System.out.println("server: " + userInput);
                    System.out.println("#: " + ++messageNum);
                    if (serverShutdown) {
                        System.out.println("The server was shutdown");
                        break;
                    }
                    } else if (current instanceof Color) {
                    System.out.println("Start Request Acknowledged!");
                    out.writeObject(colorChange.getBackground());
                    System.out.println("Launching Game!");
                    menu.close();
                    cGame = new ClientGame(in, out, (Color)current, this.colorChange.getBackground());
                    cGame.setWindowProperties(new WindowListener() {
                        @Override
                        public void windowOpened(WindowEvent we) {
                        }

                        @Override
                        public void windowClosing(WindowEvent we) {
                            
                        }

                        @Override
                        public void windowClosed(WindowEvent we) {
                            ClientController.this.menu.setVisible(true);
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
                else if(current instanceof int[])
                {
                    int[] temp = (int[])current;
                    cGame.opponentMove(temp[0], temp[1]);
                }
                else
                {
                    System.out.println("Recieved " + current + "\nBut don't know what to do with it...");
                }
            }

            //End of what the client does
        } catch (EOFException ex) {
            System.out.println("Lost connection to stream. Shutting down.");
        } catch (IOException ex) {
            System.out.println("Unable to get streams from client");
            System.out.println(ex.toString());
            for (Object o : ex.getStackTrace()) {
                System.err.println(o);
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("Something broke when reading a class from the stream...");
        } finally {
            this.shutdownResources();
        }
    }

    private void shutdownResources() {
        try {
            //End of what the client does
            /**
             * Closing all the resources
             */
            out.close();
            in.close();
            echoSocket.close();
            System.out.println("Object resources cleaned up!");
        } catch (IOException ex) {
            System.err.println("Something REALLY broke when closing down resources");
        } finally {
            this.menu.dispose();
        }
    }

    public void buildSimpleMenu() {
        ArrayList<JButton> buttonList = new ArrayList();

        JButton start = new JButton("Start");
        start.setBackground(Color.GREEN);
        //start.setEnabled(false);
        //buttonList.add(start);

        colorChange = new JButton("Set Color");
        colorChange.setBackground(Color.BLUE);
        buttonList.add(colorChange);

        JButton exit = new JButton("Quit");
        exit.setBackground(Color.RED);

        buttonList.add(exit);

        this.menu = new View.MenuPanel(buttonList);
        this.menu.setTitle("Client Menu");
        this.menu.setDefaultCloseOperation(EXIT_ON_CLOSE);

        colorChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientController.this.menu.close();
                View.PlayerColorChooser pc = new View.PlayerColorChooser(colorChange.getBackground());
                pc.setWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent we) {
                    }

                    @Override
                    public void windowClosing(WindowEvent we) {
                    }

                    @Override
                    public void windowClosed(WindowEvent we) {
                        colorChange.setBackground(pc.getColor());
                        ClientController.this.menu.open();
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
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    out.writeObject("Q");
                } catch (IOException ex) {
                    System.err.println("Error when pushing quit command to server, it may have already closed");
                }
            }
        });

    }

}
