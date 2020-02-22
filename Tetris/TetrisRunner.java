

/**
 * The runner class for the Tetris game.
 * 
 * @author Mateo Weiner
 *      assistance from martin baynes
 * @version April 13, 2019
 */
public class TetrisRunner 
{
    /**
     * Write method description here.
     *
     * @param args arguments from the command line
     */
    public static void main(String [ ] args)
    {
        Tetris tetrisGame = new Tetris();
        tetrisGame.play();
        tetrisGame.gameOver();
    }

}
