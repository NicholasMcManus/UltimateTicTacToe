package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ServerGame extends UltimateController{

    //Class Variables
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private boolean myTurn = true;

    public ServerGame(ObjectInputStream in, ObjectOutputStream out, Color player1, Color player2) {
        super();
        this.out = out;
        this.in = in;

        this.uView.startGame(player1, player2);
        this.uView.setTitle("Ultimate Tic-Tac-Toe: Player 1");
        
        //Syncronize exits
    }

    public void dispose()
    {
        this.uView.dispose();
    }
    
    public void opponentMove(int board, int button) {
        char winner;

        claimSpace(board, button);

        //Update the view
        uView.showBoard(moves);

        //Check for a winner and declare one if one is found
        winner = checkWin(moves[board]);
        if (winner != '\0') {
            subWin(board, winner);
            winner = checkWin(space);
            uView.showBoard(space);
            if (winner != '\0') {
                uView.declareWinner(winner);
            }
        }//*/
        
        myTurn = true;
    }

    @Override
    protected void initializeGUIButtons() {
        //For every button in the 3x3
        //System.out.println("Initializing buttons...");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //Appease the lambda
                final int board = i;
                final int button = j;

                //Add an action listener as defined below
                uView.addActionListener(i, j, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        if (myTurn) {
                            char winner;
                            //System.out.println("Index [" + board + "][" + button + "] was clicked!");

                            //*/Set the move attempt
                            claimSpace(board, button);
                            myTurn = false;
                            
                            try {
                                out.writeObject(new int[]{board, button});
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            //Update the view
                            uView.showBoard(moves);

                            //Check for a winner and declare one if one is found
                            winner = checkWin(moves[board]);
                            if (winner != '\0') {
                                subWin(board, winner);
                                winner = checkWin(space);
                                uView.showBoard(space);
                                if (winner != '\0') {
                                    uView.declareWinner(winner);
                                }
                            }//*/
                        }
                    }
                });
            }
        }
    }
}
