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
public class Fudge implements Die {
    private int sides;
    private int value;
  
    public Fudge(int sides){
        this.sides = sides;
    }

    @Override
    public int getValue() {
        return value;
    }
  
    /**
     * Method that updates the value field with either -1, 1, or 0.
     */
    @Override
    public void roll(){
        Random rand = new Random();
        this.value = rand.nextInt(3) - 1;
  }
}
