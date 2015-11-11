package assignment.pkg9;

import java.util.Random;
        
/**
 * A Die is a many sided object that when rolled provides a random value from
 * 1 through the number of sides on the object. Some dice are 6 sided and have
 * the numbers 1-6 on them. Some dice are 20 sided with the numbers 1-20 on them.
 * Others are called fudge dice and have the values of -1 0 or +1
 * @author Paul Scarrone
 * @author Sharon R. Tinkey
 */
public class NumberedDie implements Die {
  
    private int dieSides;       // number of sides on a die
    private int dieNum;         // number rolled by a die
    private final int MINSIDES = 4;   // minimum number of sides a die can have
    private final int DEFAULTSIDES = 6;  // default number of sides for a die
    
   /**
    * constructor   creates default 6-sided numbered die
    * no params
    */
    public NumberedDie(){
        this.dieSides = DEFAULTSIDES;      // default die   
        this.dieNum = 0;  
    }
    
    /** 
     * constructor
     * @param sides   number of sides on a die 
     */
    public NumberedDie(int sides){
        this.dieSides = sides;
        if (this.dieSides < MINSIDES){
            throw new IllegalArgumentException("The die must have at least " +
                      MINSIDES + " sides.");
        }
        this.dieNum = 0;
    }
     
    /** 
     * getDieSides  gets the number of sides on a die
     * @return      the number of sides on a die
     */
    public int getDieSides(){
        return this.dieSides;
    }
    
     /**
     * getValue     get the value of a die roll
     * @return      the value of the die roll
     */
    public int getDieValue(){
        return this.dieNum;
    }
    
    /**
     * roll     random number generator for a die roll bases on the 
     *          number of sides on the die
     * no params
     * returns nothing
     */
    public void roll(){
        Random randomNumber = new Random();
        this.dieNum = randomNumber.nextInt(this.dieSides) + 1;
    }
    
   
}
