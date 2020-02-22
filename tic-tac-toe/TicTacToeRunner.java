
import java.awt.Color;
import info.gridworld.grid.*;
import info.gridworld.world.*;
import info.gridworld.gui.*;

/**
 * The <code>TicTacToeGameRunner</code> starts and oversees
 * the TicTacToe game. 
 * @author  Mateo Weiner
 * @version June 7, 2018
 */
public class TicTacToeRunner extends World<Piece>
{
    private boolean isXTurn;
    private boolean winner;

    /**
     * Constructs a TicTacToe Game.
     */
    public TicTacToeRunner() 
    {
        isXTurn = true;
        winner = false;
        makeBoard();
        setMessage("Tic Tac Toe - X Goes First");
    }

    /**
     * 
     */
    public void colorX()
    {
        Location[] locs= new Location[5];
        locs[0] = new Location(0,0);
        locs[1] = new Location(2,0);
        locs[2] = new Location(0,2);
        locs[3] = new Location(2,2);
        locs[4] = new Location(1,1);
    }

    /**
     * 
     */
    public void colorO()
    {
        Location[] locs= new Location[4];
        locs[0] = new Location(1,0);
        locs[1] = new Location(0,1);
        locs[2] = new Location(1,2);
        locs[3] = new Location(2,1);
    }

    /**
     * Initializes the board to white, empty tiles.
     */
    private void makeBoard() 
    {
        setGrid(new BoundedGrid<Piece>(3, 3));
        for(int r = 0; r < getGrid().getNumRows(); r++)
        {
            for(int c = 0; c < getGrid().getNumCols(); c++)
            {
                add(new Location(r,c), new Piece(""));
            }
        }
    }

    /**
     * Checks for tie and sets messsage accordingly
     */
    private void checkTie()
    {
        int players = 0;
        for(int r = 0; r < getGrid().getNumRows(); r++)
        {
            for(int c = 0; c < getGrid().getNumCols(); c++)
            {
                if (!getGrid().get(new Location(r,c)).isBackground())
                {
                    players++;
                }
            }
        }
        if (players == 9)
        {
            setMessage("TIE");
        }
    }

    /**
     * Determines the winner. Currently written in O(1), independent of N, 
     * the number of pieces currently played.
     * 
     * @param   loc   location of the last piece just played
     * @return  true  if the piece just played at position <code>loc</code> completes
     *                a win for the player who just moved; otherwise,
     *          false 
     */
    private boolean determineWinner(Location loc) 
    {
        // only need to check if 3 in a row from the current loc (last move made)
        int dir = Location.AHEAD, consecutive = 0;
        Location nextLoc;
        Grid<Piece> gr = getGrid();

        Piece piecePlayed = gr.get(loc);
        for (int diagonals = 1; diagonals <= 4; diagonals++)
        {
            nextLoc = loc.getAdjacentLocation(dir);
            consecutive = 1; 
            for (int x = 1; x <= 2; x++)
            {
                while(gr.isValid(nextLoc) && gr.get(nextLoc).equals(piecePlayed))
                {
                    consecutive++;
                    nextLoc = nextLoc.getAdjacentLocation(dir);
                }
                dir += Location.HALF_CIRCLE;
                nextLoc = loc.getAdjacentLocation(dir);
            }
            if (consecutive >= 3)
            {
                return true;
            }
            dir += Location.HALF_CIRCLE + Location.HALF_RIGHT;
        }
        return false;
    }

    /**
     * Determines whether it is a legal move and, if so, places a piece 
     * and calls determineWinner.  This method is called when the 
     * current player clicks and attempts to place a piece.
     * 
     * @param  loc location passed from the GUI where the use just clicked
     * @return true 
     */
    public boolean locationClicked(Location loc)
    {
        if ( winner )
        {
            return true; 
        }
        if ( getGrid().get(loc).isBackground() ) // player making a legal move
        {
            if ( isXTurn ) 
            {
                add(loc, new Piece("X"));
                setMessage("O's Turn - X moved to " + loc);
            }
            else
            {
                add(loc, new Piece("O"));
                setMessage("X's Turn - O moved to " + loc);
            }
            checkTie();
            if ( determineWinner(loc) ) 
            {
                winner = true;
                if ( isXTurn )
                    setMessage("X WINS");
                else
                    setMessage("O WINS");
            }
            isXTurn = !isXTurn;
        }
        else // player making an illegal move
        {
            if ( isXTurn )
                setMessage("Occupied Cell - X, it's still your turn");
            else
                setMessage("Occupied Cell - O, it's still your turn");
        }
        return true;      
    }

    /**
     * Sets up the game and starts it.
     * 
     * @param args  information from the command line
     */
    public static void main(String[] args)
    {
        World ttt = new TicTacToeRunner();
        /*
         * Gets rid of focus indicator on the gui.
         */
        System.setProperty("info.gridworld.gui.selection", "hide"); 
        ttt.show();
    }
}