

/**
 * Write a description of class TetrisRunner here.
 * 
 * @author (your name)
 *    With assistance from:  (list of people who helped)
 *
 * @version (a version number or a date) 
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
