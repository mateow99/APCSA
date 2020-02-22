/*
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2002-2006 College Entrance Examination Board 
 * (http://www.collegeboard.com).
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */
import java.awt.Color;

/**
 * A <code>ColorTextPiece</code> is the game piece placed in the Grid.
 * <p>
 * copyright&copy; 2007 Dave Wittry (http://apcomputerscience.com)
 * @author  Dave Wittry
 * 
 * @author  Susan King July 5, 2010 Added equals() and isBackGround() 
 *                                 based upon Dave Wittry GamePiece
 * @author  Susan King June 3, 2015 Added documentation
 * @author  Alexandra Michael modified for Checkstyle
 * @author  Mateo Weiner
 * 
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
