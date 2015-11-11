/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg9;

import java.util.Random;

/**
 *
 * @author User
 */
public class Loaded implements Die {
    private int sides;
    private int loadedSides;
    private int value;
  
    public Loaded(int sides, int loadedSides){
        this.sides = sides;
        this.loadedSides = loadedSides;
    }

    @Override
    public int getValue() {
        return value;
    }
  
    /**
     * Method that updates the value field until it rolls the maximum number.
     */
    @Override
    public void roll(){
        Random rand = new Random();
        this.value = rand.nextInt(this.sides) + 1;
        while(this.value != this.sides + 1){
            rand = new Random();
            this.value = rand.nextInt(this.sides) + 1;
    }
  }
}
