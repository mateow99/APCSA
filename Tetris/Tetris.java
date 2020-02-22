
/**
 * The main class for the Tetris game.
 * 
 * @author Mateo Weiner
 *      assistance from martin baynes
 * @version April 13, 2019
 */
public class Tetris implements ArrowListener
{
    private MyBoundedGrid<Block> grid;
    private BlockDisplay display;
    private Tetrad activeTetrad;
    private int score;
    private int level;
    private int previousScore;

    /**
     * Constructs the tetris grid
     */
    public Tetris()
    {
        grid = new MyBoundedGrid<Block>(20, 10);
        display = new BlockDisplay(grid);
        display.setTitle("Tetris");
        activeTetrad = new Tetrad(grid);
        display.showBlocks();
        score = 0;
        level = 0;
        previousScore = score;
        System.out.println("score \tlevel");
        System.out.println(score + "\t" + level/10);
        display.setArrowListener(this);
        display.showBlocks();
    }

    /**
     * Responses to the up arrow.
     */
    public void upPressed()
    {
        activeTetrad.rotate();
        display.showBlocks();
    }

    /**
     * Responses to the down arrow.
     */
    public void downPressed()
    {
        activeTetrad.translate(1, 0);
        display.showBlocks();
    }

    /**
     * Responses to the left arrow.
     */
    public void leftPressed()
    {
        activeTetrad.translate(0, -1);
        display.showBlocks();
    }

    /**
     * Responses to the right arrow.
     */
    public void rightPressed()
    {
        activeTetrad.translate(0, 1);
        display.showBlocks();
    }

    /**
     * Responses to the right arrow.
     */
    public void spacePressed()
    {
        while(activeTetrad.translate(1, 0))
        {
            downPressed();
        }
        display.showBlocks();
    }

    /**
     * 
     */
    public void play()
    {
        while(true)
        {
            try
            {
                Thread.sleep(1000 - level*100);
                if (!activeTetrad.translate(1, 0))
                {
                    clearCompletedRows();

                    if (previousScore != score)
                    {
                        previousScore = score;
                        System.out.println(score + "\t" + level/10);
                    }
                    for (int x = 3; x < 6; x++)
                    {
                        Location tempLoc = new Location(2,x);
                        if (grid.get(tempLoc) != null)
                        {
                            return;
                        }
                    }
                    activeTetrad = new Tetrad(grid);
                }
                display.showBlocks();
            }

            catch(InterruptedException e)
            {
                //ignore
            }
        }
    }

    /**
     * checks if the row is completed
     * 
     * @return true if the row is full of blocks; otherwise,
     *         false
     */
    private boolean isCompletedRow(int row)
    {
        for (int col = 0; col < 10; col++)
        {
            Location tempLoc = new Location(row, col);
            if (grid.get(tempLoc) == null)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * clears the row that is full
     */
    private void clearRow(int row)
    {
        for (int col = 0; col < 10; col++)
        {
            Location tempLoc = new Location(row, col);
            grid.remove(tempLoc);
        }
        while (row-- > 0)
        {
            for (int col = 0; col < 10; col++)
            {
                Block block = grid.get(new Location(row, col));
                if (block != null)
                {
                    block.moveTo(new Location(row+1, col));
                }
            }
        }
    }

    /**
     * clears all the rows that are full after each tetrad is placed
     */
    private void clearCompletedRows()
    {
        int counter = 0;
        for (int row = 0; row < 20; row++)
        {
            if (isCompletedRow(row))
            {
                counter++;
                level++;
                clearRow(row);
            }
        }
        if (counter == 4)
        {
            score += 1200;
        }
        else if (counter == 3)
        {
            score += 300;
        }
        else if (counter == 2)
        {
            score += 100;
        }
        else if (counter == 1)
        {
            score += 40;
        }
        display.showBlocks();
    }

    /**
     * gives a message omce the game is over
     */
    public void gameOver()
    {
        System.out.println("Game Over :(");
        System.out.println("Your final score is " + score + " and you got to level " + level/10);
    }

}