package Controller;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClientGame extends UltimateController {

    //Class Variables
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private boolean myTurn = false;

    /**
     * Construct a game that can be played with two people using ObjectStreams
     * @param in The inputStream to read from
     * @param out The outputStream to write to
     * @param player1 The color of player 1
     * @param player2 The color of player 2
     */
    public ClientGame(ObjectInputStream in, ObjectOutputStream out, Color player1, Color player2) {
        super();
        this.out = out;
        this.in = in;

        this.uView.startGame(player1, player2);
        this.uView.setTitle("Ultimate Tic-Tac-Toe: Player 2");
    }

    /**
     * Close the game when called
     */
    public void dispose()
    {
        this.uView.dispose();
    }
    
    /**
     * The method to play a move for the opponent
     * @param board The board that was played on
     * @param button The space that was played on
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
     * Let the player mark their spot
     * @param board The board that was played on
     * @param button The position in the board that was played on
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
