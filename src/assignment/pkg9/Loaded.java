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
public class Loaded implements Die {
    private int dieValue;
    private int dieSides;
    private int loadedValue = 3;
    
    // Assign how much more probable it will be that the die lands on the loaded value.
    // A loadedWeight of 1 has the effect of adding one extra side with the loadedValue
    // For example, a loadedWeight of 2 on a 7-sided dice will increase the probability
    // of landing on the loadedValue by 2/7ths.
    private int loadedWeight = 2; // How much more probable will it be that the 

    public Loaded() { // Default constructor for a Loaded Die.
        this.dieSides = 6;
        this.dieValue = 0;
    }
    
    public Loaded(int dieSides, int loadedValue) {
        this.dieSides = dieSides;
        this.loadedValue = loadedValue;
    }

    public int getDieValue() {
        return dieValue;
    }
    
    public void roll() {
        Random randomNumbers = new Random(); 
        int currentRoll = randomNumbers.nextInt(this.dieSides + loadedWeight)+1; // Roll the loaded die.
        if(currentRoll > this.dieSides){
            currentRoll = this.loadedValue;
        }
        this.dieValue = currentRoll;
    }
}
