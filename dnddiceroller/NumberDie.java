/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnddiceroller;

import java.util.Random;

/**
 *
 * @author WickedAwesome
 */
public class NumberDie implements Die {

    private int sides;//Number of sides on a die
    private int value;//value of Die
    
    public NumberDie(int sides){
        this.sides = sides;
        this.value = 0;
    }
    
    public int getSides() {return sides;}
    
    @Override
    public void roll() {
        Random rand = new Random();
        this.value = rand.nextInt(this.sides) + 1;
    }

    @Override
    public int getValue() {
    return value;
    }
    
    
}
