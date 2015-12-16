/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment9;

import java.util.Random;

/**
 *
 * @author mkavic
 */
public class NumberedDie implements Die  {
  //fields
    private final int sides;
    private int value;
   
    /**
     * Constructor
     * @param sides 
     */
    public NumberedDie (int sides){
        this.sides = sides;
    }
    /**
     * Roll method
     */
    public void roll(){
        Random die = new Random();
        value = die.nextInt(this.sides) + 1;
}
    /**
     * Value method
     * @return value field
     */
    public int value(){
        return this.value;
}
}

   

