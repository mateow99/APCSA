
import java.awt.Color;

/**
 * A <code>ColorTextPiece</code> is the game piece placed in the Grid.
 * @author  Mateo Weiner
 * @version June 7, 2018
 */
public class Piece
{
    private String str;
    private Color color;

    /**
     * Constructs a game piece with a String.
     * 
     * @param str a String to be displayed for this piece
     */      
    public Piece(String str) 
    { 
        this.str = str; 
        this.color = Color.WHITE;
    }

    /**
     * Returns the text for this piece.
     * 
     * @return text the string for this piece
     */     
    public String getText() 
    { 
        return str;
    }

    /**
     * Returns the color of this piece.
     * 
     * @return the color of this piece
     */        
    public Color getColor()
    {
        return color;
    }

    /**
     * Gets whether or not this piece is being used as an 
     * "empty" background cell for the gui
     * 
     * @return <code>true</code> if piece is being used as an "empty"
     *                           background cell for the gui; otherwise,
     *         <code>false</code> 
     */ 
    public boolean isBackground() 
    { 
        return str.equals("");
    }

    /**
     * Determines if the text for one tile is the same as the 
     * input parameter's tile's text.
     * 
     * @param obj  the Tile object whose text is being compared 
     *             to this object
     * @return <code>true</code> if texts of both tiles are the same;  otherwise,
     *         <code>false</code> 
     */
    public boolean equals(Piece p)
    {
        return this.getText().equals(p.getText());
    }

    /**
     * Returns the text of the tile.
     * 
     * @return the text of the tile
     */
    public String toString() 
    {
        return str;
    }
}