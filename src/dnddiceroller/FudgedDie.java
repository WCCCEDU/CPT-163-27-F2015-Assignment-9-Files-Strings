/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnddiceroller;
import java.util.Random;
/**
 * Fudged Die class that implements Die interface
 * When created the user can give the Die as many sides 
 * as they want. The method doesn't care and returns -1, 0, or 1.
 * @author Tehold
 */
public class FudgedDie implements Die{
    private int value;
    private int sides;
    private final String name = "Fudged";
    
    /**
     * Default Constructor
     */
    public FudgedDie() {
        this.value = 0;
        this.sides = 3;
    }
    /**
     * Constructor with Parameter for sides to make the user feel good
     * @param sides 
     */
    public FudgedDie(int sides) {
        this.sides = sides;
        this.value = 0;
    }
    /**
     * Returns the value of a FudgeDie
     * @return Integer Value of Die
     */
    @Override
    public int value() {
        return this.value;
    }
    /**
     * Returns name of Die
     * @return String Fudged
     */
    @Override
    public String name() {
        return this.name;
    }
    /**
     * Roll Method to determine if the FudgedDie is -1, 0, or 1.
     */
    @Override
    public void roll() {
        this.value = (new Random()).nextInt(3) - 1;
    }
}
