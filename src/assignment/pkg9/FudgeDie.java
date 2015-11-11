package assignment.pkg9;

import java.util.Random;
/**
 * A fudge (or modifier) die has evenly distributed values of -1, 0, and +1. 
 * Every time the dice tray is summed, you MAY also add a fudge die to the sum.
 * Fudge die are usually 6-sided but this class allows the number of sides to 
 * be changed. The number of sides must be evenly divisible by 3 in order for
 * the probability of rolling one of the 3 numbers to be even.
 * 
 * @author srtinkey
 */
public class FudgeDie implements Die {
   
    private int dieSides;           // number of sides on a die from user
    private int dieNum;             // number rolled by die
    private final int ACTUALSIDES = 3;  // number of sides actually on fudge die
    private String errorMsg;        // error message to return if error
    
   /**
    * constructor
    * no params
    */
    public FudgeDie(){
        this.dieSides = 6;          // default 6-sided die   
        this.dieNum = 0;
        this.errorMsg = "";
    }
    
    /** 
     * constructor
     * @param sides   number of sides on a die 
     */
    public FudgeDie(int sides){
        this.dieSides = sides;     
        this.dieNum = 0;
        this.errorMsg = "";
        checkSides();        
    }
    
    /** 
     * getDieSides  gets the number of sides on a die
     * @return      the number of sides on a die
     */
    @Override
    public int getDieSides(){
        return this.dieSides;
    }
    
     /**
     * getValue     get the value of a die roll
     * @return      the value of the die roll
     */
     @Override
    public int getDieValue(){
        return this.dieNum;
    }
    
    /**
     * getErrMsg    get the error message if it exists
     * @return      the error message if it exists
     */
    public String getErrMsg(){
        return this.errorMsg;
    }
    
    /**
     * roll     random number generator for a die roll based on an even
     *          probability of rolling one of 3 numbers: -1, 0, +1 
     * no params
     * returns nothing
     */
    @Override
    public void roll(){
        Random randomNumber = new Random();
        this.dieNum = randomNumber.nextInt(this.ACTUALSIDES);  // roll
        // valid numbers are -1, 0, 1 not 0, 1, 2
        this.dieNum -= 1;
    }
    
    /** 
     * checkSides   Check for a valid number of sides on this die type.
     *              Valid number of sides must be evenly divisible by 3
     *              because there must be an even probability of rolling
     *              the 3 numbers on the die (-1, 0, +1).
     * @return      error message if number of sides is invalid
     */
    public void checkSides(){
        if (this.dieSides % 3 != 0) {
            this.errorMsg = "ERROR:  Number of sides (" + dieSides + 
                            ") for Fudge die not allowed.";
        }
    }
    
}
