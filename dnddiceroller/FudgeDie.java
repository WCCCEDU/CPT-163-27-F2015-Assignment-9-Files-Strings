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
public class FudgeDie implements Die {

    private int sides;//number of sides on fudge die
    private int value;//value of die
    
    public FudgeDie(int sides){
        this.sides = sides;
        this.value = 0;
    }
    
    /*
    In this method, as long as 
    you are working with a die with a number of sides
    divisible by 3, values of the set 1,4,7,10 etc are -1's
    values of the set 2,5,8,11 etc are 0's
    values of the set 3,6,9,12 etc are +1's
    */
    @Override
    public void roll() {
        int rollValue;
        Random rand = new Random();
        rollValue = rand.nextInt(this.sides) + 1;
        if(rollValue%3 == 0){
            this.value = 1;
        }else if((rollValue+1)%3 == 0){
            this.value = 0;
        }else{
            rollValue = -1;
        }
        this.value = rollValue;
    }

    @Override
    public int getValue() {
        return this.value;
    }
    
   
    
}
