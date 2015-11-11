package assignment.pkg9;

import java.util.Random;

/**
 * A loaded die has a greater probability that it will land on its "loaded" 
 * value side. This class assumes that the probability of a "loaded" number
 * being rolled is twice as likely to happen as the other numbers on the die.
 * 
 * @author srtinkey
 */
public class LoadedDie implements Die {
  
    // testing variables
    private static int one;
    private static int two;
    private static int three;
    private static int four;
    private static int five;
    private static int six;
    
    private int dieSides;                           // number of sides on a die
    private int dieNum;                             // number rolled by a die
    private static int loadedNum;                   // "loaded" value on die
    private static boolean loadedSetFlag = false;   // "loaded" value is set no set
    
   /**
    * constructor
    * no params
    */
    public LoadedDie(){
        this.dieSides = 6;      // default 6-sided die   
        this.dieNum = 0;    
    }
    
    /** 
     * constructor
     * @param sides   number of sides on a die 
     */
    public LoadedDie(int sides){
        this.dieSides = sides;     
        this.dieNum = 0;
    }
    
    /** 
     * constructor
     * @param sides   number of sides on a die
     * @param loaded  "loaded" number on a die
     */
    public LoadedDie(int sides, int loaded){
        this.dieSides = sides;     
        this.dieNum = 0;
        this.loadedNum = loaded;
    }
    
    /**
     * setLoadedDie     sets the loaded value of a die
     */
    public void setLoadedDie(){
        loadedNum();
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
     * getDieLoaded     get the "loaded" value of a die
     * @return          the "loaded" value of a die
     */
    public int getDieLoaded(){
        return this.loadedNum;
    }
    
    /**
     * roll     random number generator for a die roll
     *          Generates a random number based on the number of sides on die.
     *          The probability of generating the loaded number is twice as high
     *          as the other numbers so if the loaded number isn't generated the
     *          first time, a second time is tried.
     * no params
     * returns nothing
     */
    @Override
    public void roll(){
        Random randomNumber = new Random();
        this.dieNum = randomNumber.nextInt(this.dieSides) + 1;
        if (this.dieNum != this.loadedNum){
            this.dieNum = randomNumber.nextInt(this.dieSides) + 1;
        }
    }
    
    /**
     * loadedNum    sets the "loaded" value of a die
     *              sets the value only once (loadedSetFlag) unless 
     *              setLoadedDie is called again
     */
    public void loadedNum(){
        if (loadedSetFlag == false){
            Random randomNumber = new Random();
            this.loadedNum = randomNumber.nextInt(this.dieSides) + 1;
            System.out.println("Loaded Number = " + this.loadedNum);
            loadedSetFlag = true;
        }
    }
    
    
}
