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
public class Fudge implements Die {
    private int dieValue;

    public Fudge() { // Default constructor for a Fudge Die.
        this.dieValue = 0;
    }

    public int getDieValue() {
        return dieValue;
    }
    
    public void roll() {
        Random randomNumbers = new Random();
        this.dieValue = randomNumbers.nextInt(3)-1; // Randomly pick between -1, 0, and +1.
    }
}
