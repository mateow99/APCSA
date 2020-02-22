/**
 * ArrowListener establishes the name of the methods that
 * respond to the four arrow keys.
 * 
 * @author  Mateo Weiner
 * @version April 13, 2019
 */
public interface ArrowListener
{
    /**
     * Responses to the up arrow.
     */
    void upPressed();

    /**
     * Responses to the down arrow.
     */
    void downPressed();

    /**
     * Responses to the left arrow.
     */
    void leftPressed();

    /**
     * Responses to the right arrow.
     */
    void rightPressed();
     
    /**
     * Responses to the space.
     */
    void spacePressed();
    
}
