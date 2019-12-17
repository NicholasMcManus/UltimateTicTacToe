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

    /**
     * Create a server object to host a game of ultimate tic-tac-toe
     * @param in The stream to read from
     * @param out The stream to write to
     * @param player1 The color of the first player
     * @param player2 The color of the second player
     */
    public ServerGame(ObjectInputStream in, ObjectOutputStream out, Color player1, Color player2) {
        super();
        this.out = out;
        this.in = in;

        this.uView.startGame(player1, player2);
        this.uView.setTitle("Ultimate Tic-Tac-Toe: Player 1");

        //Syncronize exits
    }

    /**
     * A way to close the game with code
     */
    public void dispose() {
        this.uView.dispose();
    }

    /**
     * Record the opponents move, has less restrictions compared to standard move
     * @param board The board the play from from
     * @param button The space the play was made on
     */
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

    /**
     * Let a player claim a space as long as it it their turn
     * @param board The board to try and play on
     * @param button The space trying to be played
     */
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
}
