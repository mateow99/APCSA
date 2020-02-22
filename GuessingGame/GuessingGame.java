import java.util.Scanner;

/**
 * @ This code is creates a game where the user inputs an integer as its guess and from gets feedback on whether their number is too big or too small
 * 
 * @author Mateo Weiner  
 * @version 9/08/18
 */
public class GuessingGame
{
    // Only one instance variables permitted in this class.
    private int rand;  // random number

    /**
     * Creates an object for the class
     */
    public GuessingGame()
    {
        // initialise instance variables
        rand = 0;
    }

    /**
     * Creates a random number
     * @return  the random number created by the method
     */
    public int getRandomNumber( )
    {
        rand = (int)(Math.random() * 100) + 1;
        return rand;
    }

    /**
     * Obtains the user's guess from scanner
     * @return  the integer that the user guessed
     */
    public int getUserGuess( )
    {
        System.out.print("Guess a number between 1 and 100: ");
        Scanner in = new Scanner (System.in);
        int guess = in.nextInt( );
        return guess;
    }

    /**
     * The user's input creates an output comparing the guess and the number
     * @param   guess the parameter is the user's guess
     */
    public void giveUserFeedback(int guess)
    {
        if (guess < rand)
        {
            System.out.println("Your guess is too low!");
        }
        else if (guess > rand)
        {
            System.out.println("Your guess is too high!");
        }
        else
        {
            System.out.println("You win!! The number was " + rand + ".");
        }
    }

    /**
     * Checks the guess against the number to see if the guess was correct
     * @param   userGuess the parameter is the user's guess
     * @return  true if the user's guess is correct; otherwise,
     *          false
     */
    public boolean isWinner(int userGuess)
    {
        if (rand == userGuess)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Allows the user to play the game
     * @param   args arguements from a command line
     */
    public static void main(String [ ] args)
    {
        GuessingGame bob = new GuessingGame( );
        bob.getRandomNumber( );
        int est = bob.getUserGuess( );
        bob.giveUserFeedback(est);
        while ( ! bob.isWinner(est) )
        {
            est = bob.getUserGuess( );
            bob.giveUserFeedback(est);
        }
    }
}
