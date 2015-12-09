/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnddiceroller;

import java.util.Random;

/**
 *Loaded Die that favors a specified number when rolling.
 * @author Tehold
 */
public class LoadedDie implements Die {
    private int value;
    private int sides;
    private int loadedValue;
    private final String name = "Loaded";
    
    /**
     * Default Constructor for LoadedDie
     */
    public LoadedDie(){
        this.sides = 6;
        this.value = 1;
        this.loadedValue = 6;
    }
    /**
     * Constructor with parameters for number of sides, and desired value
     * @param sides
     * @param loadedValue 
     */
    public LoadedDie(int sides, int loadedValue) {
        this.sides = sides;
        this.loadedValue = loadedValue;
        this.value = 1;
    }
    
    /**
     * Returns the value of a LoadedDie
     * @return integer Value of LoadedDie
     */
    @Override
    public int value(){
        return this.value;
    }
    /**
     * Returns name of LoadedDie
     * @return String Loaded
     */
    @Override
    public String name() {
        return this.name;
    }
    
    /**
     * Method to roll the die and assign random value
     * If value is not equal to loaded value roll twice more or until
     * it is equal to loaded value
     */
    @Override
    public void roll() {
        this.value = (new Random()).nextInt(this.sides) +1;        
        for(int i = 0; i < 2; i++) {
            if(this.value != this.loadedValue) {
                this.value = (new Random()).nextInt(this.sides) +1;
            }
        }
    }
}
