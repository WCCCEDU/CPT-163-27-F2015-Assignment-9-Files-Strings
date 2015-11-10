package dnddiceroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A Fudge Dice will have an equal number of "+", "-", and "0" sides.
 * The dice value will be  1 for a "+" side roll
 * The dice value will be  0 for a "0" side roll
 * The dice value will be -1 for a "-" side roll
 * 
 * @author Rhonda Marashall
 * Nov 9, 2015
 * 
 * The Fudge class implements the Die interface
  
 */
public class Fudge implements Die {
    private int numberOfSides;
    private int value;
 
    // An array to hold the character on each side of this dice
    private List<String> fudgeDice = new ArrayList();
    
    /**
     * Fudge constructor
     * @param numberOfSides 
     */
    public Fudge(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        String theValue = "-";
        for (int i = 0; i < this.numberOfSides; i++) {
            fudgeDice.add(theValue);
            if (theValue.equals("-")) theValue = "0";
            else if (theValue.equals("0")) theValue = "+";
            else theValue = "-";
            
        }  // Fudge constructor
    }
    
    /**
     * roll method (Required by Die interface)
     *
     * Assign the value of the roll by determining the character
     * on the side of the dice.  These characters are stored
     * the the fudgeDice array.
     * A character of "-" assigns a value of -1
     * A character of "+" assigns a value of 1
     * A character of "0" assigns a value of 0
     */
    @Override
    public void roll() {
        Random randomNumber = new Random();
        int side = randomNumber.nextInt(this.numberOfSides);
        
        if (fudgeDice.get(side).equals("-")) this.value = -1;
        else if (fudgeDice.get(side).equals("0")) this.value = 0;
        else this.value = 1;
    } // roll method
    
    
    /**
     * getValue accessors method (Required by Die interface)
     * @return  The Fudge objects value
     */
    @Override
    public int getValue() {
        return this.value;
    } // getValue method
    
} // Fudge class
