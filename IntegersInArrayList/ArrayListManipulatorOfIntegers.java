import java.util.Scanner;
import java.util.ArrayList;

/**
 * Cover the basics of ArrayList from the first day lecture.
 * 
 * @author      Susan King 
 * @author      Mateo Weiner
 * @version     November 22, 2017
 * 
 * Students:  Look for three dots.  You write the necessary code there.
 */
public class ArrayListManipulatorOfIntegers
{
    /**
     * Constructs objects of class ArrayListManipulatorOfIntegers.
     */
    public ArrayListManipulatorOfIntegers()
    {
    }

    /**
     * Generates random numbers between -500 and 500.
     * The number of random numbers is itself a random number
     * between 0 and 20.
     * 
     * @return an ArrayList of random numbers
     */
    public ArrayList<Integer> generateRandomData( )
    {
        ArrayList <Integer> data = new ArrayList <Integer>( );
        int len = (int)(Math.random( ) * 21);
        for (int x = 0; x < len; x++)
        {
            data.add((int)(Math.random()*1001-500));
        }
        return data;
    }

    /**
     * Generates a predictable sequence of numbers with many
     * identical values to test the two methods that "remove neighboring 
     * duplicates".
     * 
     * @return an ArrayList of selected numbers
     */
    public ArrayList<Integer> generateFixedData( )
    {
        ArrayList <Integer> data = new ArrayList <Integer>( );
        data.add(7);
        data.add(10);
        data.add(10);
        data.add(15);
        data.add(15);
        data.add(15);
        data.add(50);
        data.add(50);
        data.add(50);
        data.add(50);
        data.add(50);
        data.add(7);
        return data;
    }

    /**
     * Generates an empty ArrayList.
     * 
     * @return an empty ArrayList
     */
    public ArrayList<Integer> generateEmptyArrayList( )
    {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        return nums;
    }

    /**
     * Outputs an ArrayList of Integers.
     * 
     * @param  numbers   an ArrayList of Integers
     */
    public void printData(ArrayList<Integer> numbers)
    { 
        if (numbers.size() == 0)
        {
            System.out.println("ArrayList is empty.");
            return;
        }
        for (int x=0; x < numbers.size(); x++)
        {
            System.out.println("numbers\' " + x + " element = " + numbers.get(x));
        }
    }

    /**
     * Generates a summation of all the Integers in an ArrayList.
     * 
     * @param  nums   an ArrayList of Integers
     * @return sum of all numbers in an ArrayList
     */    
    public long sumOfData(ArrayList<Integer> nums)
    {
        long sum = 0; 
        for (int x = 0; x < nums.size(); x++)
        {
            sum += nums.get(x);
        }
        return sum;
    }

    /**
     * Generates a product of all the Integers in an ArrayList.
     * 
     * @param  numbs   an ArrayList of Integers
     * @return product of all numbers in an ArrayList. If the
     *         ArrayList is empty, return 0
     */       
    public long productOfData(ArrayList<Integer> numbs)
    {
        if (numbs.size() == 0)
        {
            return 0;
        }
        long product = 1;
        for (int x = 0; x < numbs.size(); x++)
        {
            product *= numbs.get(x);
        }
        return product;
    }   

    /**
     * Finds the maximum Integer in an ArrayList. If the ArrayList is
     * empty, the smallest integer value is returned.
     * 
     * @param  values   an ArrayList of Integers
     * @return maximum numbers in an ArrayList
     */     
    public int getMaxOfData(ArrayList<Integer> values)
    {
        int max = Integer.MIN_VALUE;
        for (int x = 0; x < values.size(); x++)
        {
            max = Math.max(max, values.get(x));
        }
        return max;
    }   

    /**
     * Finds the minimum Integer in an ArrayList. If the ArrayList is
     * empty, the largest integer value is returned.
     * 
     * @param  vals   an ArrayList of Integers
     * @return minimum numbers in an ArrayList
     */       
    public int getMinOfData(ArrayList<Integer> vals)
    {
        int min = Integer.MAX_VALUE;
        for (int x = 0; x < vals.size(); x++)
        {
            min = Math.min(min, vals.get(x));
        }
        return min;
    } 

    /**
     * Turns all even Integer values in an ArrayList to the value of 6.
     * 
     * @param  numSeries   ArrayList of Integers
     */     
    public void replaceEvenWith6(ArrayList<Integer> numSeries)
    {
        for (int x = 0; x < numSeries.size(); x++)
        {
            if (numSeries.get(x)%2 == 0)
            {
                numSeries.set(x, 6);
            }
        }
    }

    /**
     * Turns all Integer values to their absolute values in an ArrayList.
     * 
     * @param  seriesOfNums   an ArrayList of Integers
     */      
    public void setAbsolute(ArrayList<Integer> seriesOfNums)
    {
        for (int x = 0; x < seriesOfNums.size(); x++)
        {
            seriesOfNums.set(x, Math.abs(seriesOfNums.get(x)));
        }
    }

    /**
     * Removes all odd Integer values from an ArrayList.
     * 
     * @param  seriesOfNumbers   an ArrayList of Integers
     */   
    public void removeOdds(ArrayList<Integer> seriesOfNumbers)
    {
        for (int x = seriesOfNumbers.size()-1; x >= 0; x--)
        {
            if (seriesOfNumbers.get(x)%2 != 0)
            {
                seriesOfNumbers.remove(x);
            }
        }
    }

    /**
     * Removes all but one duplicate, contiguous Integer values from 
     * an ArrayList.  If the same value is repeated in three contiguous
     * positions, only one of the values remains.  Likewise, if the
     * same value is repeated in "n" contigous positions, only
     * one of the values remains.
     * 
     * @param  quantities   an ArrayList of Integers
     * @postcondition   If "n" identical neighboring values in the  
     *                  ArrayList, "n-1" of them are removed
     */     
    public void removeAllButOneNeighboringDuplicates(ArrayList<Integer> quantities)
    {
        for (int x = 0; x < quantities.size()-1; x++)
        {
            if (quantities.get(x) == quantities.get(x+1))
            {
                quantities.remove(x);
                x--;
            }
        }
    }

    /**
     * Duplicates all Integer values that are a multiple of three
     * in an ArrayList.  If the multiple of three is at "n"
     * position, that value is now at both position "n"
     * and "n+1".
     * 
     * @param  quans   an ArrayList of Integers
     * @postcondition   Duplicates all Integer values that are a 
     *                  multiple of 3 in an ArrayList
     */         
    public void doubleUp(ArrayList<Integer> quans)
    {
        for (int x = 0; x < quans.size(); x++)
        {
            if (quans.get(x)%3 == 0)
            {
                quans.add(x+1,quans.get(x));
                x++;
            }
        }
    }

    /**
     * Removes all of continguous Integer values that are
     * from an ArrayList.  If removing of values creates
     * continguous identical values, they are to be
     * removed.
     * 
     * @param  collectionOfNumbers   an ArrayList of Integers
     * @postcondition   All of neighboring Integer values that
     *                  are the same are removed from the 
     *                  ArrayList
     */   
    public void removeAllNeighboringDuplicates(ArrayList<Integer> 
    collectionOfNumbers)
    {
        int index = collectionOfNumbers.size()-1;
        while (index > 0)
        {
            if (collectionOfNumbers.get(index)==(collectionOfNumbers.get(index-1)))
            {
                int store = collectionOfNumbers.remove(index);
                index--;
                while (index >= 0 && collectionOfNumbers.get(index) == store)
                {
                    collectionOfNumbers.remove(index);
                    index--;
                }
                index = Math.min(index+1, collectionOfNumbers.size()-1);
            }
            else
            {
                index--;
            }
        }
    }

    /**
     * Prints the menu for the user to read.
     */
    public void printMenu( )
    {
        System.out.println("Enter option: ");
        System.out.println(
            " 1 - generate new random data in an ArrayList \n" +
            " 2 - print ArrayList \n" +
            " 3 - print sum \n" +
            " 4 - print product \n" +
            " 5 - print max and min \n" +
            " 6 - replace even numbers with 6 \n" +
            " 7 - make all numbers absolute \n" +
            " 8 - remove all odd numbers \n" +
            " 9 - double up \n" +
            "10 - remove all but one neighboring duplicates \n" +
            "11 - remove all neighboring duplicates \n" +
            "12 - generate predicatable data in an ArrayList \n" +
            "13 - generate an empty ArrayList \n" +
            "14 - quit");
    }

    /**
     * Allows the user to select what action he or she wishes to 
     * make.  The desired action is then executed.
     */
    public void interactWithUser( )
    {
        Scanner in = new Scanner(System.in);
        ArrayList <Integer> testData = generateRandomData( );
        int choice = 0;
        printData(testData);
        while (choice != 14)
        {
            printMenu();
            choice = in.nextInt();
            in.nextLine();

            if(choice == 1)
            {
                testData = generateRandomData( ); 
            }
            else if (choice == 2)
            {
                printData( testData );
            }
            else if (choice == 3)
            {
                System.out.println( "Sum = " + sumOfData(testData) );
            }
            else if (choice == 4)
            {
                System.out.println( "Product = " + productOfData(testData) );        
            }
            else if (choice == 5)
            {       
                System.out.println( "Max = " + getMaxOfData(testData) );     
                System.out.println( "Min = " + getMinOfData(testData) );
            }
            else if (choice == 6)
            {
                replaceEvenWith6(testData);
            }
            else if (choice == 7)
            {
                setAbsolute(testData);
            }  
            else if (choice == 8)
            {
                removeOdds(testData);
            }
            else if (choice == 9)
            {
                doubleUp(testData);
            }  
            else if (choice == 10)
            {
                removeAllButOneNeighboringDuplicates(testData);
            }  
            else if (choice == 11)
            {
                removeAllNeighboringDuplicates(testData);
            }  
            else if (choice == 12)
            {
                testData = generateFixedData();
            } 
            else if (choice == 13)
            {
                testData = generateEmptyArrayList();
            } 
            else if (choice == 14)
            {
                System.out.println("Goodbye");
            }
        }
    }

    /**
     * Tests the code for ManipulatorOfIntegerArrayList.  The code is designed
     * to build skills with ArrayLists.
     * 
     * @param args   information passed from the user via the command line
     */
    public static void main(String[]args)
    {
        ArrayListManipulatorOfIntegers learner = new ArrayListManipulatorOfIntegers( );
        learner.interactWithUser( );
    }

}
