import java.awt.Color;
/**
 * The shapes for the Tetris game.
 * 
 * @author Mateo Weiner
 *      assistance from martin baynes
 * @version April 13, 2019
 */
public class Tetrad
{
    private Block[] blocks;
    private MyBoundedGrid<Block> grid;
    private Location[] locs;
    private int random;

    /**
     * Constructs one shape using four blocks
     * 
     * @param gr the grid that is used for the tetrads
     */
    public Tetrad(MyBoundedGrid<Block> gr)
    {
        blocks = new Block[4];
        for (int i = 0; i < 4; i++)
        {
            blocks[i] = new Block();
        }
        grid = gr;
        random = (int)(Math.random()*7);
        locs = new Location[4];

        if (random == 0)
        {
            for (int x = 0; x < 4; x++)
            {
                blocks[x].setColor(Color.RED);
            }
            locs[0] = new Location(1, 4);
            locs[1] = new Location(2, 4);
            locs[2] = new Location(3, 4);
            locs[3] = new Location(0, 4);
        }
        if (random == 1)
        {
            for (int x = 0; x < 4; x++)
            {
                blocks[x].setColor(Color.GRAY);
            }
            locs[0] = new Location(0, 4);
            locs[1] = new Location(0, 3);
            locs[2] = new Location(1, 4);
            locs[3] = new Location(0, 5);
        }
        if (random == 2)
        {
            for (int x = 0; x < 4; x++)
            {
                blocks[x].setColor(Color.CYAN);
            }
            locs[0] = new Location(0, 4);
            locs[1] = new Location(0, 5);
            locs[2] = new Location(1, 4);
            locs[3] = new Location(1, 5);
        }
        if (random == 3)
        {
            for (int x = 0; x < 4; x++)
            {
                blocks[x].setColor(Color.YELLOW);
            }
            locs[0] = new Location(2, 4);
            locs[1] = new Location(1, 4);
            locs[2] = new Location(0, 4);
            locs[3] = new Location(2, 5);
        }
        if (random == 4)
        {
            for (int x = 0; x < 4; x++)
            {
                blocks[x].setColor(Color.MAGENTA);
            }
            locs[0] = new Location(2, 5);
            locs[1] = new Location(1, 5);
            locs[2] = new Location(0, 5);
            locs[3] = new Location(2, 4);
        }
        if (random == 5)
        {
            for (int x = 0; x < 4; x++)
            {
                blocks[x].setColor(Color.BLUE);
            }
            locs[0] = new Location(1, 4);
            locs[1] = new Location(0, 4);
            locs[2] = new Location(1, 3);
            locs[3] = new Location(0, 5);
        }
        if (random == 6)
        {
            for (int x = 0; x < 4; x++)
            {
                blocks[x].setColor(Color.GREEN);
            }
            locs[0] = new Location(0, 4);
            locs[1] = new Location(0, 3); 
            locs[2] = new Location(1, 4);
            locs[3] = new Location(1, 5);
        }
        addToLocations(grid, locs);
    }

    /**
     * adds a block to the grid
     * 
     * @param  gr   the grid which will contain the block
     * @param  locations   the array which will contain the blocks
     * 
     * @precondition the tetrad is not in the grid
     */
    public void addToLocations(MyBoundedGrid<Block> gr, Location[] locations)
    {
        for (int x = 0; x < 4; x++)
        {
            blocks[x].putSelfInGrid(gr, locations[x]);
        }
        locs = locations;
    }

    /**
     * removes a block
     * 
     * @precondition the block being removes is currently in the grid
     * 
     * @return the array of locations
     * 
     */
    private Location[] removeBlocks()
    {
        for (int x = 0; x < 4; x++)
        {
            blocks[x].removeSelfFromGrid();
        }
        return locs;
    }

    /**
     * checks locations on a grid to see if they are availible
     * 
     * @return true if the locations at the specified grid are empty; otherwise,
     *         false
     * @param gr         the grid to look for the locations in
     * @param locations  the locations to check for availibility
     */
    private boolean areEmpty(MyBoundedGrid<Block> gr, Location[] locations)
    {
        for (int x = 0; x < 4; x++)
        {
            if (!gr.isValid(locations[x]) || gr.get(locations[x]) != null)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * moves the tetrad to a new location
     * 
     * @return true if the locations at the specified grid are empty; otherwise,
     *         false
     * @param deltaRow  the number of spaces to move the tetrad down
     * @param deltaCol the number of spaces to move the tetrad to the right
     */
    public boolean translate(int deltaRow, int deltaCol)
    {
        Location[] oldLocs = removeBlocks();
        Location[] newLocs = new Location[4];
        for (int x = 0; x < 4; x++)
        {
            newLocs[x] = new Location(locs[x].getRow() + deltaRow, locs[x].getCol() + deltaCol);
        }
        if (areEmpty(grid, newLocs))
        {
            addToLocations(grid, newLocs);
            return true;
        }
        else
        {
            addToLocations(grid, oldLocs);
            return false;
        }
    }

    /**
     * rotates the tetrad
     * 
     * @return true if the rotate is successful; otherwise,
     *         false
     */
    public boolean rotate()
    {
        Location[] oldLocs = removeBlocks();
        Location[] newLocs = new Location[4];
        for (int x = 0; x < 4; x++)
        {
            if (random == 2)
            {
                addToLocations(grid, oldLocs);
                return true;
            }
            newLocs[x] = new Location(locs[0].getRow() - locs[0].getCol()
                + locs[x].getCol(), locs[0].getCol() + locs[0].getRow() - locs[x].getRow());
        }
        if (areEmpty(grid, newLocs))
        {
            addToLocations(grid, newLocs);
            return true;
        }
        else
        {
            addToLocations(grid, oldLocs);
            return false;
        }
    }
}