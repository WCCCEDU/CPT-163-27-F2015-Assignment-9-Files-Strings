/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnddiceroller;

import java.util.Random;

/**
 *
 * @author Tehold
 */
public class NumberedDie implements Die {
    private int value;
    private int sides;
    private final String name = "Numbered";
    /**
     * Default constructor for a NumberedDie
     */
    public NumberedDie(){
        this.sides = 6;
        this.value = 1;
    }
    /**
     * Constructor with parameter for number of sides
     * @param sides 
     */
    public NumberedDie(int sides){
        this.sides = sides;
    }
    /**
     * Returns the value of a NumberedDie
     * @return Integer Value of NumberedDie
     */
    @Override
    public int value(){
        return this.value;
    }
    /**
     * Returns name of Die
     * @return String Numbered
     */
    @Override
    public String name(){
        return this.name;
    }
    /**
     * Roll method to assign random value to NumberedDie
     */
    @Override
    public void roll(){
        this.value = (new Random()).nextInt(this.sides) +1;
    }
}
