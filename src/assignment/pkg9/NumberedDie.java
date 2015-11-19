package assignment.pkg9;

import java.util.Random;

/**
 *
 * @author Katrina
 */
public class NumberedDie implements Die{
    final private int numberOfSides;
    private int value;

/**
 * the constructor
 * @param numberOfSides is the number of sides of the die.
 */
    public NumberedDie(int numberOfSides){
        this.numberOfSides = numberOfSides;
        this.value = 0; 
    }
    
    /**
     *
     * @return number of sides.
     */
    public int getNumberOfSides(){
        return this.numberOfSides;
    }
      
    @Override
    public int getValue() {
        return this.value;
    }      
    
    //the roll method simulates the rolling of the die.
 
    @Override
      public void roll(){
        //create a Random object.
        Random rand = new Random();
        //get a random value for this die.
        this.value = rand.nextInt(this.numberOfSides) +1;
      }
     
}

    

