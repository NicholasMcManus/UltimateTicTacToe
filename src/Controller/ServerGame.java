package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ServerGame extends UltimateController {

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

    public void dispose() {
        this.uView.dispose();
    }

    public void opponentMove(int board, int button) {
        char winner;
        //System.out.println("Opponent claims:[" + board + "] [" + button + "]");
        super.claimSpace(board, button);
        this.oldSpace = button;
        
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

    //*
    @Override
    protected void claimSpace(int board, int button) {
        if (myTurn) {
            try {
                super.claimSpace(board, button);
                out.writeObject(new int[]{board, button});
                //System.out.println("You claim:[" + board + "] [" + button + "]");
                myTurn = false;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }        
    }
    //*/
}
