/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg9;

import java.util.Random;

/**
 *
 * @author zacharyzordo
 */
public class RegularDie implements Die {
    private int dieValue;
    private int dieSides;

    public RegularDie() { // Default constructor for a die with number of sides assigned by the constructor.
        this.dieSides = 6;
        this.dieValue = 0;
    }
    
    public RegularDie(int dieSides) { // Constructor for a die which could have the number of sides assigned in main.
        // Create a Random class object.
        this.dieSides = dieSides;
        this.dieValue = 0;
    }

    public int getDieValue() {
        return dieValue;
    }
    
    public void roll() {
        Random randomNumbers = new Random();
        this.dieValue = randomNumbers.nextInt(this.dieSides)+1; // Roll the die (add 1 because random int starts at 0).
    }
}
